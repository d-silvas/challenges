package blog.cybertricks.euler.problems;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Problem52Test {
    private final Problem52 problem;

    // TODO: put this in a file that I don't commit
    @Value("${euler-solutions.problem52}")
    String solution;

    @Autowired
    public Problem52Test(Problem52 problem) {
        this.problem = problem;
    }

    @Test
    public void isOverTheMaximumForSize() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        assertEquals(false, problem.isOverTheMaximumForSize(list));
    }
}