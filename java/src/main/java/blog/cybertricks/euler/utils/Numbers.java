package blog.cybertricks.euler.utils;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Component
public class Numbers {
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private final Logger logger;

    @Autowired
    public Numbers(Logger logger) {
        this.logger = logger;
    }

    /**
     * Computes the integer square root of a number.
     * https://stackoverflow.com/questions/2685524/check-if-biginteger-is-not-a-perfect-square
     *
     * @param n The number.
     * @return The integer square root, i.e. the largest number whose square
     * doesn't exceed n.
     */
    public static BigInteger sqrt(BigInteger n) {
        if (n.signum() >= 0) {
            final int bitLength = n.bitLength();
            BigInteger root = BigInteger.ONE.shiftLeft(bitLength / 2);

            while (!isSqrt(n, root)) {
                root = root.add(n.divide(root)).divide(TWO);
            }
            return root;
        } else {
            throw new ArithmeticException("square root of negative number");
        }
    }

    private static boolean isSqrt(BigInteger n, BigInteger root) {
        final BigInteger lowerBound = root.pow(2);
        final BigInteger upperBound = root.add(BigInteger.ONE).pow(2);
        return lowerBound.compareTo(n) <= 0
                && n.compareTo(upperBound) < 0;
    }


    public BigInteger digitsListToBigInteger(List<Integer> digitsList) {
        int i = digitsList.size() - 1;
        BigInteger number = BigInteger.ZERO;
        for (Integer digit : digitsList) {
            BigInteger powerOf10 = BigInteger.TEN.pow(i);
            BigInteger b = new BigInteger(String.valueOf(digit)).multiply(powerOf10);
            number = number.add(b);
            i--;
        }
        return number;
    }

    /**
     * @TODO check for overflow
     */
    public Integer digitsListToInteger(List<Integer> digitsList) {
        int i = digitsList.size() - 1;
        Integer number = 0;
        for (Integer digit : digitsList) {
            number += digit * (int) Math.pow(10, i);
            i--;
        }
        return number;
    }

    public List<Integer> integerToDigitsList(Integer number) {
        List<Integer> digitsList = new ArrayList<>();
        while (number > 0) {
            digitsList.add(0, number % 10);
            number = number / 10;
        }
        return digitsList;
    }

    public List<Integer> longToDigitsList(Long number) {
        List<Integer> digitsList = new ArrayList<>();
        while (number > 0) {
            digitsList.add(0, (int) (number % 10L));
            number = number / 10L;
        }
        return digitsList;
    }

    public List<Integer> bigIntegerToDigitsList(BigInteger number) {
        List<Integer> digitsList = new ArrayList<>();
        while (number.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] quotientAndRemainder = number.divideAndRemainder(BigInteger.TEN);
            BigInteger quotient = quotientAndRemainder[0];
            BigInteger remainder = quotientAndRemainder[1]; // Less than 10
            digitsList.add(0, remainder.intValue());
            number = quotient;
        }
        return digitsList;
    }

    public long digitalRoot(long number) {
        if (number == 0) {
            return 0;
        }
        long remainder = number % 9;
        return remainder == 0 ? 9 : remainder;
    }

    public long digitsSum(BigInteger bigInteger) {
        String digits = bigInteger.toString();
        long sum = 0;

        for (int i = 0; i < digits.length(); i++) {
            int digit = (int) digits.charAt(i) - '0';
            sum += digit;
        }

        return sum;
    }
}
