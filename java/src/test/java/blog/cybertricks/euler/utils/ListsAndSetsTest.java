package blog.cybertricks.euler.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class ListsAndSetsTest {
    private final ListsAndSets listsAndSets;

    @Autowired
    public ListsAndSetsTest(ListsAndSets listsAndSets) {
        this.listsAndSets = listsAndSets;
    }

    @Test
    void getNumberOfOccurrencesMap() {
        List<Integer> list = List.of(1, 1, 2, 2, 2, 3, 4, 5, 2, 2);
        HashMap<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 2);
        expected.put(2, 5);
        expected.put(3, 1);
        expected.put(4, 1);
        expected.put(5, 1);
        assertEquals(expected, listsAndSets.getNumberOfOccurrencesMap(list));
    }

    // TODO: change the code so that it handles duplicate maximum occurrences (example: 5 twos and 5 ones)
    @Test
    void getMaximumOccurrence() {
        List<Integer> list = List.of(1, 1, 2, 2, 2, 3, 4, 5, 2, 2);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(5);
        assertEquals(expected, listsAndSets.getMaximumOccurrence(list));
    }

    @Test
    void getNumberOfConsecutiveOccurrencesMap() {
        List<Integer> list = List.of(1, 1, 2, 2, 2, 3, 4, 5, 2, 2);
        HashMap<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 2);
        expected.put(2, 3);
        assertEquals(expected, listsAndSets.getNumberOfConsecutiveOccurrencesMap(list));
    }

    // TODO: change the code so that it handles duplicate maximum occurrences (example: 5 twos and 5 ones)
    @Test
    void getMaximumConsecutiveOccurrence() {
        List<Integer> list = List.of(1, 1, 2, 2, 2, 3, 4, 5, 2, 2);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(3);
        assertEquals(expected, listsAndSets.getMaximumConsecutiveOccurrence(list));
    }

    @Test
    void getMaximumConsecutiveOccurrence2() {
        List<Integer> list = List.of(1, 1, 2, 3, 4, 5);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        assertEquals(expected, listsAndSets.getMaximumConsecutiveOccurrence(list));
    }

    @Test
    void getMaximumConsecutiveOccurrence3() {
        // TODO look at this
        List<Integer> list = List.of(3870, -6894, 5634, 360, -6354, 3330, 3330);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(3330);
        expected.add(2);
        List<Integer> actual = listsAndSets.getMaximumConsecutiveOccurrence(list);
        assertEquals(expected, actual);
    }
}