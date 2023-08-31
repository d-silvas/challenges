package blog.cybertricks.euler.problems;

import blog.cybertricks.euler.utils.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
public class Problem49 implements Problem {
    private final Combinations combinations;
    private final Permutations permutations;
    private final ListsAndSets listsAndSets;
    private final Numbers numbers;
    private final Primes primes;
    private final Logger logger;

    @Autowired
    public Problem49(
            Permutations permutations,
            Combinations combinations,
            ListsAndSets listsAndSets,
            Numbers numbers,
            Primes primes,
            Logger logger
    ) {
        this.permutations = permutations;
        this.combinations = combinations;
        this.listsAndSets = listsAndSets;
        this.numbers = numbers;
        this.primes = primes;
        this.logger = logger;
    }

    /**
     * TODO
     * - Numbers starting by 0 not valid, e.g. "5 ## 157, 751, 571"
     * - Some are repeated, e.g. "3 ## 5081, 8501, 5801"
     */
    public String solve() {
        List<Integer[]> combinationsOf4Numbers = this.getAllCombinationsOf4Numbers();
        for (Integer[] combination : combinationsOf4Numbers) {
            Set<List<Integer>> permutationsOfCombination = permutations.heap(Arrays.asList(combination));
            List<Integer> primesInCombination = new ArrayList<>();
            for (List<Integer> permutation : permutationsOfCombination) {
                Integer candidate = numbers.digitsListToInteger(permutation);
                if (primes.isPrime(candidate)) {
                    primesInCombination.add(candidate);
                }
            }
            if (primesInCombination.size() >= 3) {
                List<Integer> permutationWith3ElementsAtSameDistance =
                        hasThreeElementsAtSameDistance(primesInCombination);
                if (permutationWith3ElementsAtSameDistance != null) {
                    Integer[] wantedSolutionOrNull = getWantedSolutionOrNull(permutationWith3ElementsAtSameDistance);
                    if (wantedSolutionOrNull != null) {
                        List<String> solutionAsString =
                                Arrays.stream(wantedSolutionOrNull).map(Object::toString).toList();
                        return String.join("", solutionAsString);
                    }
                }
            }
        }
        return "";
    }

    private List<Integer[]> getAllCombinationsOf4Numbers() {
        // We only need to generate the "lower part of the matrix"
        List<Integer[]> combinations = new ArrayList<>();
        for (int first = 0; first <= 9; first++) {
            for (int second = 0; second <= first; second++) {
                for (int third = 0; third <= second; third++) {
                    for (int fourth = 0; fourth <= third; fourth++) {
                        combinations.add(new Integer[]{first, second, third, fourth});
                    }
                }
            }
        }
        return combinations;
    }


    private List<Integer> hasThreeElementsAtSameDistance(List<Integer> list) {
        // TODO: improvement - get permutations as iterable and calculate them on-the-fly
        // These are combinations with repetition of 10 elements taken in groups of 4
        ArrayList<List<Integer>> listPermutations = new ArrayList<>(permutations.heap(list));
        for (int i = 0; i < listPermutations.size(); i++) {
            List<Integer> currentPermutation = listPermutations.get(i);
            List<Integer> differences = new ArrayList<>();
            for (int j = 1; j < currentPermutation.size(); j++) {
                Integer newDifference = currentPermutation.get(j) - currentPermutation.get(j - 1);
                differences.add(newDifference);
            }
            List<Integer> maximumOccurrence = listsAndSets.getMaximumConsecutiveOccurrence(differences);
            if (maximumOccurrence.size() > 0 && maximumOccurrence.get(1) >= 2) {
                return currentPermutation;
            }
        }
        return null;
    }

    private Integer[] getWantedSolutionOrNull(List<Integer> listWithSolutionCandidate) {
        if (listWithSolutionCandidate.contains(1487)) {
            return null;
        }
        List<Integer> differences = new ArrayList<>();
        for (int i = 1; i < listWithSolutionCandidate.size(); i++) {
            differences.add(listWithSolutionCandidate.get(i) - listWithSolutionCandidate.get(i - 1));
        }
        List<Integer> maximumOccurrence = listsAndSets.getMaximumConsecutiveOccurrence(differences);
        int indexOfFirstRepeatedDifference = differences.indexOf(maximumOccurrence.get(0));
        Integer[] solutionCandidate = new Integer[]{
                listWithSolutionCandidate.get(indexOfFirstRepeatedDifference),
                listWithSolutionCandidate.get(indexOfFirstRepeatedDifference + 1),
                listWithSolutionCandidate.get(indexOfFirstRepeatedDifference + 2)
        };
        Arrays.sort(solutionCandidate);
        // There is only one wanted solution, and it's the one that doesn't contain 3-digit numbers
        if (solutionCandidate[0] < 1000) {
            return null;
        }
        return solutionCandidate;
    }
}
