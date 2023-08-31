package blog.cybertricks.euler.problems;

import blog.cybertricks.euler.utils.Numbers;
import blog.cybertricks.euler.utils.Permutations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Problem52 implements Problem {
    private final Permutations permutations;
    private final Numbers numbers;

    @Autowired
    public Problem52(Permutations permutations, Numbers numbers) {
        this.permutations = permutations;
        this.numbers = numbers;
    }

    public String solve() {
        // Try long first
        if (this.solveLong() != null) {
            return this.solveLong();
        }
        long limitForLong = Long.MAX_VALUE / 6L - 1L;
        BigInteger n = BigInteger.valueOf(limitForLong);
        while (true) {
            List<Integer> digitsOfN = numbers.bigIntegerToDigitsList(n);
            if (isOverTheMaximumForSize(digitsOfN)) {
                n = getFirstElementOfNextBatch(digitsOfN.size());
                continue;
            }
            List<Integer> digitsOf2N = numbers.bigIntegerToDigitsList(n.multiply(BigInteger.TWO));
            if (!permutations.isPermutation(digitsOfN, digitsOf2N)) {
                n = n.add(BigInteger.ONE);
                continue;
            }
            List<Integer> digitsOf3N = numbers.bigIntegerToDigitsList(n.multiply(BigInteger.valueOf(3)));
            if (!permutations.isPermutation(digitsOfN, digitsOf3N)) {
                n = n.add(BigInteger.ONE);
                continue;
            }
            System.out.println(n + " " + n.multiply(BigInteger.TWO) + " " + n.multiply(BigInteger.valueOf(3)));
            List<Integer> digitsOf4N = numbers.bigIntegerToDigitsList(n.multiply(BigInteger.valueOf(4)));
            if (!permutations.isPermutation(digitsOfN, digitsOf4N)) {
                n = n.add(BigInteger.ONE);
                continue;
            }
            System.out.println(
                    n + " " + n.multiply(BigInteger.TWO) + " " + n.multiply(BigInteger.valueOf(3)) + " " +
                            n.multiply(BigInteger.valueOf(4))
            );
            List<Integer> digitsOf5N = numbers.bigIntegerToDigitsList(n.multiply(BigInteger.valueOf(5)));
            if (!permutations.isPermutation(digitsOfN, digitsOf5N)) {
                n = n.add(BigInteger.ONE);
                continue;
            }
            System.out.println(
                    n + " " + n.multiply(BigInteger.TWO) + " " + n.multiply(BigInteger.valueOf(3)) + " " +
                            n.multiply(BigInteger.valueOf(4)) + " " + n.multiply(BigInteger.valueOf(5))
            );
            List<Integer> digitsOf6N = numbers.bigIntegerToDigitsList(n.multiply(BigInteger.valueOf(6)));
            if (permutations.isPermutation(digitsOfN, digitsOf6N)) {
                System.out.println(
                        n + " " + n.multiply(BigInteger.TWO) + " " + n.multiply(BigInteger.valueOf(3)) + " " +
                                n.multiply(BigInteger.valueOf(4)) + " " + n.multiply(BigInteger.valueOf(5)) +
                                " " + n.multiply(BigInteger.valueOf(6))
                );
                List<String> solutionAsString = digitsOf6N.stream().map(Object::toString).toList();
                return String.join("", solutionAsString);
            }
        }
    }

    public String solveLong() {
        long n = 10L;
        long max = Long.MAX_VALUE / 6L;
        while (n < max) {
            List<Integer> digitsOfN = numbers.longToDigitsList(n);
            if (isOverTheMaximumForSize(digitsOfN)) {
                n = getFirstElementOfNextBatchLong(digitsOfN.size());
                continue;
            }
            List<Integer> digitsOf2N = numbers.longToDigitsList(n * 2);
            if (!permutations.isPermutation(digitsOfN, digitsOf2N)) {
                n = n + 1L;
                continue;
            }
            List<Integer> digitsOf3N = numbers.longToDigitsList(n * 3);
            if (!permutations.isPermutation(digitsOfN, digitsOf3N)) {
                n = n + 1L;
                continue;
            }
            System.out.println(n + " " + n * 2 + " " + n * 3);
            List<Integer> digitsOf4N = numbers.longToDigitsList(n * 4);
            if (!permutations.isPermutation(digitsOfN, digitsOf4N)) {
                n = n + 1L;
                continue;
            }
            System.out.println(n + " " + n * 2 + " " + n * 3 + " " + n * 4);
            List<Integer> digitsOf5N = numbers.longToDigitsList(n * 5);
            if (!permutations.isPermutation(digitsOfN, digitsOf5N)) {
                n = n + 1L;
                continue;
            }
            System.out.println(n + " " + n * 2 + " " + n * 3 + " " + n * 4 + " " + n * 5);
            List<Integer> digitsOf6N = numbers.longToDigitsList(n * 6);
            if (permutations.isPermutation(digitsOfN, digitsOf6N)) {
                System.out.println(n + " " + n * 2 + " " + n * 3 + " " + n * 4 + " " + n * 5 + " " + n * 6);
                return digitsOfN.stream().map(String::valueOf).collect(Collectors.joining(""));
            }
        }
        return null;
    }

    /**
     * Gets a finishing condition for the current iteration batch. Keep in mind that the iteration runs in
     * numerical order
     * <p>
     * Warning! It fails for small numbers (< 10)
     */
    public boolean isOverTheMaximumForSize(List<Integer> list) {
        if (list.get(0) > 1) {
            return true;
        }
        // We want to see if ALL digits other than the first are >= 6
        // (testing all digits = 6 would be enough)
        for (int i = 1; i < list.size(); i++) {
            // If ONE element is < 6, return false
            if (list.get(i) < 6) {
                return false;
            }
        }
        return true;
    }

    public BigInteger getFirstElementOfNextBatch(int sizeOfDigitsOfN) {
        return BigInteger.TEN.pow(sizeOfDigitsOfN);
    }

    public long getFirstElementOfNextBatchLong(int sizeOfDigitsOfN) {
        return (long) Math.pow(10L, sizeOfDigitsOfN);
    }

}
