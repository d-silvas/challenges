package blog.cybertricks.euler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EulerApplicationConfig {
    @Bean
    public Logger logger() {
        return LoggerFactory.getLogger(EulerApplication.class);
    }
}
