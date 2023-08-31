package blog.cybertricks.euler.utils;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Some implementations not working. Resources:
 * <p>
 * https://www.baeldung.com/cs/array-generate-all-permutations
 * http://ruslanledesma.com/2016/06/17/why-does-heap-work.html
 */

@Component
public class Permutations {
    private final Logger logger;

    @Autowired
    public Permutations(Logger logger) {
        this.logger = logger;
    }

    public Set<List<Integer>> simpleRecursive(List<Integer> initial) {
        Set<List<Integer>> generatedPermutations = Collections.synchronizedSet(new HashSet<>());
        int initialSize = initial.size();
        simpleRecursiveAlgo(generatedPermutations, new ArrayList<>(initialSize), new ArrayList<>(initial));
        return generatedPermutations;
    }

    private void simpleRecursiveAlgo(
            Set<List<Integer>> generatedPermutations,
            List<Integer> currentPermutation,
            List<Integer> elementsToPermute
    ) {
        if (elementsToPermute.isEmpty()) {
            generatedPermutations.add(currentPermutation);
        } else {
            for (Integer element : elementsToPermute) {
                ArrayList<Integer> nextPermutation = new ArrayList<>(currentPermutation);
                nextPermutation.add(element);
                ArrayList<Integer> remainingElements = new ArrayList<>(elementsToPermute);
                remainingElements.remove(element);
                simpleRecursiveAlgo(generatedPermutations, nextPermutation, remainingElements);
            }
        }
    }

    /**
     * TODO: learn multi threading
     */
//    public Set<List<Integer>> simpleRecursiveMultiThread(List<Integer> initial) {
//        Set<List<Integer>> generatedPermutations = new HashSet<>();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);
//
//        for (Integer element : initial) {
//            ArrayList<Integer> nextPermutation = new ArrayList<>(List.of(element));
//            ArrayList<Integer> remainingElements = new ArrayList<>(initial);
//            remainingElements.remove(element);
//            // Only multi thread the first time
//            completionService.submit(new SimpleRecursiveCallable(generatedPermutations, nextPermutation,
//                    remainingElements));
//        }
//        executorService.shutdown();
//
//        try {
//            while (!executorService.isTerminated()) {
//                Future<Integer> future = completionService.take();
//                Integer result = future.get();
//            }
//        } catch (ExecutionException | InterruptedException ex) {
//            logger.error(String.valueOf(ex));
//        }
//
//        return generatedPermutations;
//    }
    public Set<List<Integer>> heap(List<Integer> initial) {
        Set<List<Integer>> generatedPermutations = new HashSet<>();
        ArrayList<Integer> arrayListInitial = new ArrayList<>(initial);
        // Create a shallow copy
        generatedPermutations.add(new ArrayList<>(arrayListInitial));
        heapAlgo(generatedPermutations, arrayListInitial, arrayListInitial.size());
        return generatedPermutations;
    }

    private void heapAlgo(
            // TODO change to callback
            Set<List<Integer>> generatedPermutations,
            List<Integer> currentPermutation,
            int n
    ) {
        for (int i = 0; i <= n; i++) {
            if (n > 2) {
                heapAlgo(generatedPermutations, currentPermutation, n - 1);
            }
            if (i >= n - 1) {
                // We don't want to execute the rest of the code for i = n
                break;
            }
            if (n % 2 == 0) {
                swap(currentPermutation, i, n - 1);
            } else {
                swap(currentPermutation, 0, n - 1);
            }
            generatedPermutations.add(new ArrayList<>(currentPermutation));
        }
    }

    /**
     * TODO
     */
    public Set<List<Integer>> quickPerm(List<Integer> initial) {
        Set<List<Integer>> generatedPermutations = new HashSet<>();
        quickPermAlgo(generatedPermutations, new ArrayList<>(initial));
        return generatedPermutations;
    }

    /**
     * TODO
     */
    private void quickPermAlgo(
            Set<List<Integer>> generatedPermutations,
            List<Integer> elementsToPermute
    ) {
        generatedPermutations.add(elementsToPermute);
        int size = elementsToPermute.size();
        List<Integer> p = new ArrayList<>();
        IntStream.range(0, size).forEach(val -> p.add(val));
        int index = 1;

        while (index < size) {
            Integer j = 0;

            p.set(index, p.get(index) - 1);
            if (index % 2 == 1) {
                j = p.get(index);
            }
            swap(elementsToPermute, index, j);
            generatedPermutations.add(elementsToPermute);
            index = 1;
            while (p.get(index) == 0) {
                p.set(index, index);
                index += 1;
            }
        }

    }

    private void swap(List<Integer> list, int i, int j) {
        Integer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    /**
     * Checks whether both lists are permutations of each other
     *
     * @param first  The first list
     * @param second The second list
     * @return A boolean that determines whether both lists are permutations of each other
     */
    // TODO test it does not modify the lists
    public boolean isPermutation(List<Integer> first, List<Integer> second) {
        if (first.size() != second.size()) {
            return false;
        }
        List<Integer> sortedFirst = first.stream().sorted().collect(Collectors.toList());
        List<Integer> sortedSecond = second.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < sortedFirst.size(); i++) {
            if (!sortedFirst.get(i).equals(sortedSecond.get(i))) {
                return false;
            }
        }
        return true;
    }
}

/**
 * TODO: learn multi threading
 */
//class SimpleRecursiveCallable implements Callable<Integer> {
//    private final Set<List<Integer>> generatedPermutations;
//    private final List<Integer> currentPermutation;
//    private final List<Integer> elementsToPermute;
//
//    SimpleRecursiveCallable(Set<List<Integer>> generatedPermutations,
//                            List<Integer> currentPermutation,
//                            List<Integer> elementsToPermute) {
//        this.generatedPermutations = generatedPermutations;
//        this.currentPermutation = currentPermutation;
//        this.elementsToPermute = elementsToPermute;
//    }
//
//    public Integer call() {
//        simpleRecursiveAlgo(this.generatedPermutations, this.currentPermutation, this.elementsToPermute);
//        return 0;
//    }
//
//    private void simpleRecursiveAlgo(
//            Set<List<Integer>> generatedPermutations,
//            List<Integer> currentPermutation,
//            List<Integer> elementsToPermute
//    ) {
//        if (elementsToPermute.isEmpty()) {
//            generatedPermutations.add(new ArrayList<>(currentPermutation));
//        } else {
//            for (Integer element : elementsToPermute) {
//                ArrayList<Integer> nextPermutation = new ArrayList<>(currentPermutation);
//                nextPermutation.add(element);
//                ArrayList<Integer> remainingElements = new ArrayList<>(elementsToPermute);
//                remainingElements.remove(element);
//                simpleRecursiveAlgo(generatedPermutations, nextPermutation, remainingElements);
//            }
//        }
//    }
//}

// TODO tree
// Perms of 1234
// starting by 1: 1234, 1324, ...
//1
//2                  3                   4
//3    4             2    4              2    3
//4     3            4    2              3    2
