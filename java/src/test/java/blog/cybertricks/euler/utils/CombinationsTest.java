package blog.cybertricks.euler.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SpringBootTest
class CombinationsTest {
    private final Combinations combinations;

    @Autowired
    public CombinationsTest(Combinations combinations) {
        this.combinations = combinations;
    }

    @Test
    void combinationsWithoutRepetition() {
        List<Integer[]> expected = new ArrayList<>();
        expected.add(new Integer[]{0, 1});
        expected.add(new Integer[]{0, 2});
        expected.add(new Integer[]{0, 3});
        expected.add(new Integer[]{1, 2});
        expected.add(new Integer[]{1, 3});
        expected.add(new Integer[]{2, 3});
        List<Integer[]> actual = combinations.combinationsWithoutRepetition(4, 2);
        assertArrayEquals(expected.get(0), actual.get(0));
        assertArrayEquals(expected.get(1), actual.get(1));
        assertArrayEquals(expected.get(2), actual.get(2));
        assertArrayEquals(expected.get(3), actual.get(3));
        assertArrayEquals(expected.get(4), actual.get(4));
        assertArrayEquals(expected.get(5), actual.get(5));
    }
}