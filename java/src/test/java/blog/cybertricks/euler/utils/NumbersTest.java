package blog.cybertricks.euler.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class NumbersTest {
    private final Numbers numbers;

    @Autowired
    public NumbersTest(Numbers numbers) {
        this.numbers = numbers;
    }

    @Test
    void digitsListToBigInteger() {
        assertEquals(BigInteger.ZERO, numbers.digitsListToBigInteger(List.of(0)));
        assertEquals(BigInteger.ONE, numbers.digitsListToBigInteger(List.of(1)));
        assertEquals(
                new BigInteger("1234567890123456789"),
                numbers.digitsListToBigInteger(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9))
        );
    }

    @Test
    void digitsListToInteger() {
        assertEquals(0, numbers.digitsListToInteger(List.of(0)));
        assertEquals(1, numbers.digitsListToInteger(List.of(1)));
        assertEquals(47891, numbers.digitsListToInteger(List.of(4, 7, 8, 9, 1)));
    }

    @Test
    void digitalRoot() {
        assertEquals(0, numbers.digitalRoot(0));
        assertEquals(9, numbers.digitalRoot(9));
        assertEquals(9, numbers.digitalRoot(2718));
        assertEquals(6, numbers.digitalRoot(12345));
        assertEquals(5, numbers.digitalRoot(27518));
    }

    @Test
    void testDigitSum() {
        assertEquals(0, numbers.digitsSum(BigInteger.ZERO));
        assertEquals(1, numbers.digitsSum(BigInteger.ONE));
        assertEquals(1, numbers.digitsSum(BigInteger.TEN));
        assertEquals(89, numbers.digitsSum(BigInteger.valueOf(2345678901234567890L)));
    }
}