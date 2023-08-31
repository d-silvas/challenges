package blog.cybertricks.euler.problems;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Problem43Test {
    private final Problem43 problem;

    // TODO: put this in a file that I don't commit
    @Value("${euler-solutions.problem43}")
    String solution;

    @Autowired
    public Problem43Test(Problem43 problem) {
        this.problem = problem;
    }

    @Test
    void solve() {
        assertEquals(problem.solve(), solution);
    }
}