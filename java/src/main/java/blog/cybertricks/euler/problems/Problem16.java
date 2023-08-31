package blog.cybertricks.euler.problems;

import blog.cybertricks.euler.utils.Numbers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class Problem16 implements Problem {
    private final Numbers numbers;

    @Autowired
    public Problem16(Numbers numbers) {
        this.numbers = numbers;
    }

    @Override
    public String solve() {
        BigInteger power = BigInteger.TWO.pow(1000);
        return String.valueOf(numbers.digitsSum(power));
    }
}
