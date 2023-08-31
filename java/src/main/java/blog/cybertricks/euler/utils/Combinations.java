package blog.cybertricks.euler.utils;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.baeldung.com/java-combinations-algorithm
 */
@Component
public class Combinations {
    private final Logger logger;

    @Autowired
    public Combinations(Logger logger) {
        this.logger = logger;
    }

    /**
     * Returns all the possible subsets of r elements from the set {1, ..., n}.
     * An iterative algorithm is used.
     *
     * @param n The set size. 0-indexed (n=0 is a set of size 1)
     * @param r The number of elements in each subset
     * @return All the possible subsets of r elements of the set {1, ..., n}
     */
    public List<Integer[]> combinationsWithoutRepetition(int n, int r) {
        List<Integer[]> combinations = new ArrayList<>();
        Integer[] combination = new Integer[r];

        // initialize with lowest lexicographic combination
        for (int i = 0; i < r; i++) {
            combination[i] = i;
        }

        while (combination[r - 1] < n) {
            combinations.add(combination.clone());

            // generate next combination in lexicographic order
            int t = r - 1;
            while (t != 0 && combination[t] == n - r + t) {
                t--;
            }
            combination[t]++;
            for (int i = t + 1; i < r; i++) {
                combination[i] = combination[i - 1] + 1;
            }
        }
        return combinations;
    }

    /**
     * Returns all the possible subsets of r elements from the set {1, ..., n},
     * where each element can be present from 0 to r times
     *
     * @param n The set size. 0-indexed (n=0 is a set of size 1)
     * @param r The number of elements in each subset
     * @return All the possible subsets of r elements of the set {1, ..., n}
     */
    // TODO
    public List<Integer[]> combinationsWithRepetition(int n, int r) {
        List<Integer[]> combinations = new ArrayList<>();
        return combinations;
    }
}
