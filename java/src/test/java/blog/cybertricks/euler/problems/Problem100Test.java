package blog.cybertricks.euler.problems;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Problem100Test {
    private final Problem100 problem;

    @Autowired
    public Problem100Test(Problem100 problem) {
        this.problem = problem;
    }

    @Test
    void test1RedAnd3Blue() {
        long discNumber = 1 + 3;
        assertEquals("3", problem.solveThreaded(discNumber, 10L, 1));
    }

    @Test
    void test6RedAnd15Blue() {
        long discNumber = 6 + 15;
        assertEquals("15", problem.solveThreaded(discNumber - 10L, 100L, 1));
    }

    @Test
    void test35RedAnd85Blue() {
        long discNumber = 35 + 85;
        assertEquals("85", problem.solveThreaded(discNumber - 10L, 100L, 1));
    }

    @Test
    void test6930RedAnd16731Blue() {
        long discNumber = 6930 + 16731;
        assertEquals("16731", problem.solveThreaded(discNumber - 1000L, 1000L, 4));
    }

    @Test
    void test40391RedAnd97513Blue() {
        long discNumber = 40391 + 97513;
        assertEquals("97513", problem.solveThreaded(discNumber - 10000L, 10000L, 4));
    }

    @Test
    void test235416RedAnd568345Blue() {
        long discNumber = 235416 + 568345;
        assertEquals("568345", problem.solveThreaded(discNumber - 100000L, 100000L, 4));
    }

    @Test
    void test313506783024RedAnd756872327473BlueLongOptimized() {
        long discNumber = 313506783024L + 756872327473L;
        assertEquals("756872327473", problem.solveThreaded(discNumber - 800000L, 100000, 8));
    }
}