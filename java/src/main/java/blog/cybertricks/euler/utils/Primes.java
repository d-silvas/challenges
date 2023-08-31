package blog.cybertricks.euler.utils;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Primes {
    private final Logger logger;

    @Autowired
    public Primes(Logger logger) {
        this.logger = logger;
    }

    public boolean isPrime(Integer n) {
        for (int i = 2; i <= n / 2; ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
