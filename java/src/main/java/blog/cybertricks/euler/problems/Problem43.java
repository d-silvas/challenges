package blog.cybertricks.euler.problems;

import blog.cybertricks.euler.utils.Numbers;
import blog.cybertricks.euler.utils.Permutations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class Problem43 implements Problem {
    private final Permutations permutations;
    private final Numbers numbers;

    @Autowired
    public Problem43(Permutations permutations, Numbers numbers) {
        this.permutations = permutations;
        this.numbers = numbers;
    }

    private boolean checkDivisibility(List<Integer> num) {
        return numbers.digitsListToInteger(List.of(num.get(7), num.get(8), num.get(9))) % 17 == 0 &&
                numbers.digitsListToInteger(List.of(num.get(6), num.get(7), num.get(8))) % 13 == 0 &&
                numbers.digitsListToInteger(List.of(num.get(5), num.get(6), num.get(7))) % 11 == 0 &&
                numbers.digitsListToInteger(List.of(num.get(4), num.get(5), num.get(6))) % 7 == 0 &&
                numbers.digitsListToInteger(List.of(num.get(3), num.get(4), num.get(5))) % 5 == 0 &&
                numbers.digitsListToInteger(List.of(num.get(2), num.get(3), num.get(4))) % 3 == 0 &&
                numbers.digitsListToInteger(List.of(num.get(1), num.get(2), num.get(3))) % 2 == 0;
    }

    @Override
    public String solve() {
        Set<List<Integer>> pandigitalNumbers = permutations.heap(List.of(0, 1, 2, 3, 4, 5, 6, 7
                , 8, 9));
        ArrayList<BigInteger> pandigitalNumbersWithProperty = new ArrayList<>();
        for (List<Integer> candidate : pandigitalNumbers) {
            if (checkDivisibility(candidate)) {
                System.out.println(candidate);
                pandigitalNumbersWithProperty.add(numbers.digitsListToBigInteger(candidate));
            }
        }
        System.out.println(pandigitalNumbersWithProperty);
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger num : pandigitalNumbersWithProperty) {
            sum = sum.add(num);
        }
        return sum.toString();
    }
}
