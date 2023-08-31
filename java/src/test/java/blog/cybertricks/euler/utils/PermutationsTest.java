package blog.cybertricks.euler.utils;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PermutationsTest {
    private final Permutations permutations;

    @Autowired
    public PermutationsTest(Permutations permutations) {
        this.permutations = permutations;
    }

    @Test
    void simpleRecursive1() {
        assertEquals(getPermutationsOf1(), permutations.simpleRecursive(List.of(1)));
    }

    @Test
    void simpleRecursive12() {
        assertEquals(getPermutationsOf12(), permutations.simpleRecursive(List.of(1, 2)));
    }

    @Test
    void simpleRecursive123() {
        assertEquals(getPermutationsOf123(), permutations.simpleRecursive(List.of(1, 2, 3)));
    }

    @Test
    void simpleRecursive1234() {
        assertEquals(getPermutationsOf1234(), permutations.simpleRecursive(List.of(1, 2, 3, 4)));
    }


    @Test
    void simpleRecursive12345() {
        assertEquals(getPermutationsOf12345(), permutations.simpleRecursive(List.of(1, 2, 3, 4, 5)));
    }

//    @Test
//    void simpleRecursiveMultiThread1() {
//        assertEquals(getPermutationsOf1(), permutations.simpleRecursiveMultiThread(List.of(1)));
//    }

//    @Test
//    void simpleRecursiveMultiThread12() {
//        assertEquals(getPermutationsOf12(), permutations.simpleRecursiveMultiThread(List.of(1, 2)));
//    }
//
//    @Test
//    void simpleRecursiveMultiThread123() {
//        assertEquals(getPermutationsOf123(), permutations.simpleRecursiveMultiThread(List.of(1, 2, 3)));
//    }
//
//    @Test
//    void simpleRecursiveMultiThread1234() {
//        assertEquals(getPermutationsOf1234(), permutations.simpleRecursiveMultiThread(List.of(1, 2, 3, 4)));
//    }
//
//    @Test
//    void simpleRecursiveMultiThread12345() {
//        assertEquals(getPermutationsOf12345(), permutations.simpleRecursiveMultiThread(List.of(1, 2, 3, 4, 5)));
//    }
//
//    @Test
//    void simpleRecursiveMultiThread1234567MatchesSimpleRecursive() {
//        assertEquals(permutations.simpleRecursive(List.of(1, 2, 3, 4, 5, 6, 7)),
//                permutations.simpleRecursiveMultiThread(List.of(1, 2, 3, 4, 5, 6, 7)));
//    }
//
//    @Test
//    void simpleRecursiveMultiThread12345678MatchesSimpleRecursive() {
//        assertEquals(permutations.simpleRecursive(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)),
//                permutations.simpleRecursiveMultiThread(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));
//    }

    @Test
    void quickPerm1() {
        assertEquals(getPermutationsOf1(), permutations.quickPerm(List.of(1)));
    }

    @Test
    @Disabled
    void quickPerm12() {
        assertEquals(getPermutationsOf12(), permutations.quickPerm(List.of(1, 2)));
    }

    @Test
    @Disabled
    void quickPerm123() {
        assertEquals(getPermutationsOf123(), permutations.quickPerm(List.of(1, 2, 3)));
    }

    @Test
    @Disabled
    void quickPerm1234() {
        assertEquals(getPermutationsOf1234(), permutations.quickPerm(List.of(1, 2, 3, 4)));
    }

    @Test
    @Disabled
    void quickPerm12345() {
        assertEquals(getPermutationsOf12345(), permutations.quickPerm(List.of(1, 2, 3, 4, 5)));
    }

    @Test
    void heap1() {
        assertEquals(getPermutationsOf1(), permutations.heap(List.of(1)));
    }

    @Test
    void heap12() {
        assertEquals(getPermutationsOf12(), permutations.heap(List.of(1, 2)));
    }

    @Test
    void heap123() {
        assertEquals(getPermutationsOf123(), permutations.heap(List.of(1, 2, 3)));
    }

    @Test
    void heap1234() {
        assertEquals(getPermutationsOf1234(), permutations.heap(List.of(1, 2, 3, 4)));
    }

    @Test
    void heap12345() {
        assertEquals(getPermutationsOf12345(), permutations.heap(List.of(1, 2, 3, 4, 5)));
    }

    // For isPermutation: 1053287469 2106574938 3159862407

    private Set<List<Integer>> getPermutationsOf1() {
        Set<List<Integer>> permutationsOf1 = new HashSet<>();
        permutationsOf1.add(new ArrayList<>(List.of(1)));
        return permutationsOf1;
    }

    private Set<List<Integer>> getPermutationsOf12() {
        Set<List<Integer>> permutationsOf12 = new HashSet<>();
        permutationsOf12.add(new ArrayList<>(List.of(1, 2)));
        permutationsOf12.add(new ArrayList<>(List.of(2, 1)));
        return permutationsOf12;
    }

    private Set<List<Integer>> getPermutationsOf123() {
        Set<List<Integer>> permutationsOf123 = new HashSet<>();
        permutationsOf123.add(new ArrayList<>(List.of(1, 2, 3)));
        permutationsOf123.add(new ArrayList<>(List.of(1, 3, 2)));
        permutationsOf123.add(new ArrayList<>(List.of(2, 1, 3)));
        permutationsOf123.add(new ArrayList<>(List.of(2, 3, 1)));
        permutationsOf123.add(new ArrayList<>(List.of(3, 1, 2)));
        permutationsOf123.add(new ArrayList<>(List.of(3, 2, 1)));
        return permutationsOf123;
    }

    private Set<List<Integer>> getPermutationsOf1234() {
        Set<List<Integer>> permutationsOf1234 = new HashSet<>();
        permutationsOf1234.add(new ArrayList<>(List.of(1, 2, 3, 4)));
        permutationsOf1234.add(new ArrayList<>(List.of(1, 2, 4, 3)));
        permutationsOf1234.add(new ArrayList<>(List.of(1, 3, 2, 4)));
        permutationsOf1234.add(new ArrayList<>(List.of(1, 3, 4, 2)));
        permutationsOf1234.add(new ArrayList<>(List.of(1, 4, 2, 3)));
        permutationsOf1234.add(new ArrayList<>(List.of(1, 4, 3, 2)));
        permutationsOf1234.add(new ArrayList<>(List.of(2, 1, 3, 4)));
        permutationsOf1234.add(new ArrayList<>(List.of(2, 1, 4, 3)));
        permutationsOf1234.add(new ArrayList<>(List.of(2, 3, 1, 4)));
        permutationsOf1234.add(new ArrayList<>(List.of(2, 3, 4, 1)));
        permutationsOf1234.add(new ArrayList<>(List.of(2, 4, 1, 3)));
        permutationsOf1234.add(new ArrayList<>(List.of(2, 4, 3, 1)));
        permutationsOf1234.add(new ArrayList<>(List.of(3, 1, 2, 4)));
        permutationsOf1234.add(new ArrayList<>(List.of(3, 1, 4, 2)));
        permutationsOf1234.add(new ArrayList<>(List.of(3, 2, 1, 4)));
        permutationsOf1234.add(new ArrayList<>(List.of(3, 2, 4, 1)));
        permutationsOf1234.add(new ArrayList<>(List.of(3, 4, 1, 2)));
        permutationsOf1234.add(new ArrayList<>(List.of(3, 4, 2, 1)));
        permutationsOf1234.add(new ArrayList<>(List.of(4, 1, 2, 3)));
        permutationsOf1234.add(new ArrayList<>(List.of(4, 1, 3, 2)));
        permutationsOf1234.add(new ArrayList<>(List.of(4, 2, 1, 3)));
        permutationsOf1234.add(new ArrayList<>(List.of(4, 2, 3, 1)));
        permutationsOf1234.add(new ArrayList<>(List.of(4, 3, 1, 2)));
        permutationsOf1234.add(new ArrayList<>(List.of(4, 3, 2, 1)));
        return permutationsOf1234;
    }


    private Set<List<Integer>> getPermutationsOf12345() {
        Set<List<Integer>> permutationsOf12345 = new HashSet<>();
        permutationsOf12345.add(new ArrayList<>(List.of(1, 2, 3, 5, 4)));
        permutationsOf12345.add(new ArrayList<>(List.of(1, 4, 5, 3, 2)));
        permutationsOf12345.add(new ArrayList<>(List.of(4, 1, 2, 3, 5)));
        permutationsOf12345.add(new ArrayList<>(List.of(4, 5, 3, 1, 2)));
        permutationsOf12345.add(new ArrayList<>(List.of(2, 5, 4, 3, 1)));
        permutationsOf12345.add(new ArrayList<>(List.of(4, 1, 3, 5, 2)));
        permutationsOf12345.add(new ArrayList<>(List.of(2, 1, 3, 4, 5)));
        permutationsOf12345.add(new ArrayList<>(List.of(3, 1, 4, 2, 5)));
        permutationsOf12345.add(new ArrayList<>(List.of(1, 3, 4, 5, 2)));
        permutationsOf12345.add(new ArrayList<>(List.of(5, 3, 2, 1, 4)));
        permutationsOf12345.add(new ArrayList<>(List.of(3, 1, 5, 4, 2)));
        permutationsOf12345.add(new ArrayList<>(List.of(1, 5, 2, 3, 4)));
        permutationsOf12345.add(new ArrayList<>(List.of(3, 4, 1, 5, 2)));
        permutationsOf12345.add(new ArrayList<>(List.of(5, 1, 4, 3, 2)));
        permutationsOf12345.add(new ArrayList<>(List.of(3, 5, 2, 4, 1)));
        permutationsOf12345.add(new ArrayList<>(List.of(4, 2, 3, 1, 5)));
        permutationsOf12345.add(new ArrayList<>(List.of(3, 2, 5, 1, 4)));
        permutationsOf12345.add(new ArrayList<>(List.of(4, 3, 1, 2, 5)));
        permutationsOf12345.add(new ArrayList<>(List.of(4, 3, 5, 2, 1)));
        permutationsOf12345.add(new ArrayList<>(List.of(4, 2, 1, 5, 3)));
        permutationsOf12345.add(new ArrayList<>(List.of(2, 4, 3, 5, 1)));
        permutationsOf12345.add(new ArrayList<>(List.of(4, 3, 2, 5, 1)));
        permutationsOf12345.add(new ArrayList<>(List.of(2, 5, 3, 1, 4)));
        permutationsOf12345.add(new ArrayList<>(List.of(5, 1, 4, 2, 3)));
        permutationsOf12345.add(new ArrayList<>(List.of(2, 1, 3, 5, 4)));
        permutationsOf12345.add(new ArrayList<>(List.of(2, 3, 4, 1, 5)));
        permutationsOf12345.add(new ArrayList<>(List.of(1, 5, 2, 4, 3)));
        permutationsOf12345.add(new ArrayList<>(List.of(5, 4, 1, 3, 2)));
        permutationsOf12345.add(new ArrayList<>(List.of(1, 3, 4, 2, 5)));
        permutationsOf12345.add(new ArrayList<>(List.of(3, 4, 1, 2, 5)));
        permutationsOf12345.add(new ArrayList<>(List.of(1, 2, 4, 5, 3)));
        permutationsOf12345.add(new ArrayList<>(List.of(3, 5, 2, 1, 4)));
        permutationsOf12345.add(new ArrayList<>(List.of(3, 4, 5, 2, 1)));
        permutationsOf12345.add(new ArrayList<>(List.of(1, 4, 2, 3, 5)));
        permutationsOf12345.add(new ArrayList<>(List.of(1, 3, 5, 4, 2)));
        permutationsOf12345.add(new ArrayList<>(List.of(1, 5, 3, 2, 4)));
        permutationsOf12345.add(new ArrayList<>(List.of(4, 3, 5, 1, 2)));
        permutationsOf12345.add(new ArrayList<>(List.of(2, 5, 1, 3, 4)));
        permutationsOf12345.add(new ArrayList<>(List.of(2, 4, 3, 1, 5)));
        permutationsOf12345.add(new ArrayList<>(List.of(3, 1, 5, 2, 4)));
        permutationsOf12345.add(new ArrayList<>(List.of(3, 1, 2, 4, 5)));
        permutationsOf12345.add(new ArrayList<>(List.of(3, 4, 2, 5, 1)));
        permutationsOf12345.add(new ArrayList<>(List.of(5, 2, 3, 4, 1)));
        permutationsOf12345.add(new ArrayList<>(List.of(5, 4, 1, 2, 3)));
        permutationsOf12345.add(new ArrayList<>(List.of(3, 2, 4, 5, 1)));
        permutationsOf12345.add(new ArrayList<>(List.of(1, 2, 3, 4, 5)));
        permutationsOf12345.add(new ArrayList<>(List.of(4, 1, 3, 2, 5)));
        permutationsOf12345.add(new ArrayList<>(List.of(3, 4, 5, 1, 2)));
        permutationsOf12345.add(new ArrayList<>(List.of(1, 4, 5, 2, 3)));
        permutationsOf12345.add(new ArrayList<>(List.of(4, 2, 1, 3, 5)));
        permutationsOf12345.add(new ArrayList<>(List.of(4, 2, 5, 3, 1)));
        permutationsOf12345.add(new ArrayList<>(List.of(2, 5, 1, 4, 3)));
        permutationsOf12345.add(new ArrayList<>(List.of(4, 5, 1, 2, 3)));
        permutationsOf12345.add(new ArrayList<>(List.of(4, 5, 1, 3, 2)));
        permutationsOf12345.add(new ArrayList<>(List.of(2, 5, 4, 1, 3)));
        permutationsOf12345.add(new ArrayList<>(List.of(2, 1, 4, 5, 3)));
        permutationsOf12345.add(new ArrayList<>(List.of(2, 3, 5, 1, 4)));
        permutationsOf12345.add(new ArrayList<>(List.of(1, 4, 2, 5, 3)));
        permutationsOf12345.add(new ArrayList<>(List.of(5, 3, 4, 2, 1)));
        permutationsOf12345.add(new ArrayList<>(List.of(1, 5, 3, 4, 2)));
        permutationsOf12345.add(new ArrayList<>(List.of(5, 3, 1, 4, 2)));
        permutationsOf12345.add(new ArrayList<>(List.of(3, 1, 2, 5, 4)));
        permutationsOf12345.add(new ArrayList<>(List.of(5, 4, 2, 3, 1)));
        permutationsOf12345.add(new ArrayList<>(List.of(5, 1, 2, 4, 3)));
        permutationsOf12345.add(new ArrayList<>(List.of(1, 3, 5, 2, 4)));
        permutationsOf12345.add(new ArrayList<>(List.of(1, 3, 2, 4, 5)));
        permutationsOf12345.add(new ArrayList<>(List.of(1, 5, 4, 2, 3)));
        permutationsOf12345.add(new ArrayList<>(List.of(1, 2, 4, 3, 5)));
        permutationsOf12345.add(new ArrayList<>(List.of(4, 3, 2, 1, 5)));
        permutationsOf12345.add(new ArrayList<>(List.of(2, 3, 4, 5, 1)));
        permutationsOf12345.add(new ArrayList<>(List.of(2, 4, 1, 3, 5)));
        permutationsOf12345.add(new ArrayList<>(List.of(2, 4, 5, 3, 1)));
        permutationsOf12345.add(new ArrayList<>(List.of(2, 1, 5, 4, 3)));
        permutationsOf12345.add(new ArrayList<>(List.of(5, 3, 4, 1, 2)));
        permutationsOf12345.add(new ArrayList<>(List.of(1, 3, 2, 5, 4)));
        permutationsOf12345.add(new ArrayList<>(List.of(1, 5, 4, 3, 2)));
        permutationsOf12345.add(new ArrayList<>(List.of(5, 1, 2, 3, 4)));
        permutationsOf12345.add(new ArrayList<>(List.of(3, 2, 1, 5, 4)));
        permutationsOf12345.add(new ArrayList<>(List.of(3, 5, 4, 2, 1)));
        permutationsOf12345.add(new ArrayList<>(List.of(3, 4, 2, 1, 5)));
        permutationsOf12345.add(new ArrayList<>(List.of(4, 2, 5, 1, 3)));
        permutationsOf12345.add(new ArrayList<>(List.of(2, 4, 1, 5, 3)));
        permutationsOf12345.add(new ArrayList<>(List.of(4, 2, 3, 5, 1)));
        permutationsOf12345.add(new ArrayList<>(List.of(4, 5, 2, 3, 1)));
        permutationsOf12345.add(new ArrayList<>(List.of(5, 2, 3, 1, 4)));
        permutationsOf12345.add(new ArrayList<>(List.of(2, 1, 4, 3, 5)));
        permutationsOf12345.add(new ArrayList<>(List.of(1, 4, 3, 5, 2)));
        permutationsOf12345.add(new ArrayList<>(List.of(5, 3, 1, 2, 4)));
        permutationsOf12345.add(new ArrayList<>(List.of(5, 2, 4, 3, 1)));
        permutationsOf12345.add(new ArrayList<>(List.of(5, 4, 2, 1, 3)));
        permutationsOf12345.add(new ArrayList<>(List.of(5, 3, 2, 4, 1)));
        permutationsOf12345.add(new ArrayList<>(List.of(5, 1, 3, 4, 2)));
        permutationsOf12345.add(new ArrayList<>(List.of(3, 2, 1, 4, 5)));
        permutationsOf12345.add(new ArrayList<>(List.of(3, 2, 5, 4, 1)));
        permutationsOf12345.add(new ArrayList<>(List.of(3, 5, 4, 1, 2)));
        permutationsOf12345.add(new ArrayList<>(List.of(1, 2, 5, 3, 4)));
        permutationsOf12345.add(new ArrayList<>(List.of(4, 1, 5, 3, 2)));
        permutationsOf12345.add(new ArrayList<>(List.of(2, 3, 1, 5, 4)));
        permutationsOf12345.add(new ArrayList<>(List.of(4, 5, 2, 1, 3)));
        permutationsOf12345.add(new ArrayList<>(List.of(4, 1, 2, 5, 3)));
        permutationsOf12345.add(new ArrayList<>(List.of(2, 3, 1, 4, 5)));
        permutationsOf12345.add(new ArrayList<>(List.of(2, 3, 5, 4, 1)));
        permutationsOf12345.add(new ArrayList<>(List.of(2, 4, 5, 1, 3)));
        permutationsOf12345.add(new ArrayList<>(List.of(3, 5, 1, 4, 2)));
        permutationsOf12345.add(new ArrayList<>(List.of(5, 2, 1, 4, 3)));
        permutationsOf12345.add(new ArrayList<>(List.of(5, 4, 3, 2, 1)));
        permutationsOf12345.add(new ArrayList<>(List.of(1, 2, 5, 4, 3)));
        permutationsOf12345.add(new ArrayList<>(List.of(3, 5, 1, 2, 4)));
        permutationsOf12345.add(new ArrayList<>(List.of(4, 1, 5, 2, 3)));
        permutationsOf12345.add(new ArrayList<>(List.of(1, 4, 3, 2, 5)));
        permutationsOf12345.add(new ArrayList<>(List.of(3, 2, 4, 1, 5)));
        permutationsOf12345.add(new ArrayList<>(List.of(4, 5, 3, 2, 1)));
        permutationsOf12345.add(new ArrayList<>(List.of(2, 5, 3, 4, 1)));
        permutationsOf12345.add(new ArrayList<>(List.of(4, 3, 1, 5, 2)));
        permutationsOf12345.add(new ArrayList<>(List.of(5, 1, 3, 2, 4)));
        permutationsOf12345.add(new ArrayList<>(List.of(5, 2, 4, 1, 3)));
        permutationsOf12345.add(new ArrayList<>(List.of(2, 1, 5, 3, 4)));
        permutationsOf12345.add(new ArrayList<>(List.of(5, 2, 1, 3, 4)));
        permutationsOf12345.add(new ArrayList<>(List.of(5, 4, 3, 1, 2)));
        permutationsOf12345.add(new ArrayList<>(List.of(3, 1, 4, 5, 2)));
        return permutationsOf12345;
    }
}
