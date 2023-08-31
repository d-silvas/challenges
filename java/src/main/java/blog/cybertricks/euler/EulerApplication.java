package blog.cybertricks.euler;

import blog.cybertricks.euler.problems.Problem18;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EulerApplication implements CommandLineRunner {
    private final Logger logger;
    /**
     * @TODO dynamic instantiation
     */
    @Autowired
    private Problem18 problem;

    @Autowired
    public EulerApplication(Logger logger) {
        this.logger = logger;
    }

    public static void main(String[] args) {
        SpringApplication.run(EulerApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // TODO: only execute this if there is arguments, and not during tests
        long start = System.nanoTime();
        String sol = problem.solve();
        long finish = System.nanoTime();
        logger.info("Sol: " + sol);
        logger.info("Took: " + (double) (finish - start) / 1000000 + "ms");
    }
}
