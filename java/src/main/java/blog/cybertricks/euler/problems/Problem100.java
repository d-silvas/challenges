package blog.cybertricks.euler.problems;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * We need to solve
 * (blue/(blue + red))*((blue - 1)/(blue + red - 1)) = 1/2;
 * blue*(blue - 1)*2 = (blue + red)*(blue + red - 1);
 * 2*blue*(blue - 1) = (total)*(total - 1);
 * <p>
 * We first calculate the proportion of red/total discs. Then, we loop over all the discs sizes, starting at 10^12.
 * We calculate the probabilities for each disc size, trying a few candidates for the number of red discs
 * that we know are very close to the solution.
 * <p>
 * This problem takes ~4hours to solve on my machine.
 */

final class Constants {
    /**
     * If blue and red are VERY big: blue~=blue-1; total~=total-1; and:
     * 2*blue*(blue - 1) = (total)*(total - 1); 2*blue^2 - total^2 = 0;
     * blue/total = 1/sqrt(2). Then, red/total = 1-1/sqrt(2)
     */
    public static final double RED_PROPORTION = 1 - 1 / Math.sqrt(2);
    public static final long SOLUTION_NOT_FOUND = -1L;

    private Constants() {
    }
}

@Component
public class Problem100 implements Problem {
    private final Logger logger;

    @Autowired
    public Problem100(Logger logger) {
        this.logger = logger;
    }

    public String solve() {
        // Start from a point which is closer to the solution
        return solveThreaded(1070000000000L, 100000000L, 12);
    }

    public String solveThreaded(long discNumber, long stepSize, int threadNumber) {
        while (true) {
            ExecutorService executorService = Executors.newFixedThreadPool(threadNumber);
            CompletionService<Long> completionService = new ExecutorCompletionService<>(executorService);
            ArrayList<CalculationCallable> tasks = getTasks(discNumber, stepSize, threadNumber);
            for (CalculationCallable task : tasks) {
                completionService.submit(task);
            }
            executorService.shutdown();

            try {
                while (!executorService.isTerminated()) {
                    Future<Long> future = completionService.take();
                    Long result = future.get();
                    System.out.println(future.get());
                    if (result != Constants.SOLUTION_NOT_FOUND) {
                        executorService.shutdownNow();
                        return String.valueOf(result);
                    }
                }
            } catch (ExecutionException | InterruptedException ex) {
                logger.error(String.valueOf(ex));
                return "";
            }
            discNumber += stepSize * threadNumber;
        }
    }

    private ArrayList<CalculationCallable> getTasks(long initialDiscNumber, long stepSize, int threadNumber) {
        ArrayList<CalculationCallable> tasks = new ArrayList<>();
        for (int i = 1; i <= threadNumber; i++) {
            tasks.add(new CalculationCallable(initialDiscNumber + stepSize * (i - 1),
                    initialDiscNumber + stepSize * i - 1));
        }
        return tasks;
    }
}

class CalculationCallable implements Callable<Long> {
    private final long minDiscNumber;
    private final long maxDiscNumber;

    CalculationCallable(Long minDiscNumber, Long maxDiscNumber) {
        this.minDiscNumber = minDiscNumber;
        this.maxDiscNumber = maxDiscNumber;
    }

    public Long call() {
        long discNumber = minDiscNumber;
        System.out.println("Starting: " + discNumber);
        while (discNumber <= maxDiscNumber) {
            long redApproximation = Math.round(discNumber * Constants.RED_PROPORTION);
            // The actual solution is exactly Math.floor(discNumber * Constants.RED_PROPORTION),
            // so these bounds can be improved
            long lowerBound = redApproximation - 2;
            long upperBound = redApproximation + 2;
            for (long red = lowerBound; red <= upperBound; red += 1) {
                long blue = discNumber - red;
                BigInteger blueBI = BigInteger.valueOf(blue);
                BigInteger redBI = BigInteger.valueOf(red);
                int ratio = blueBI.multiply(blueBI.subtract(BigInteger.ONE)).multiply(BigInteger.TWO)
                        .compareTo(blueBI.add(redBI).multiply(blueBI.add(redBI).subtract(BigInteger.ONE)));
                if (ratio == 0) {
                    return blue;
                }
            }
            discNumber = discNumber + 1;
        }
        return Constants.SOLUTION_NOT_FOUND;
    }
}
