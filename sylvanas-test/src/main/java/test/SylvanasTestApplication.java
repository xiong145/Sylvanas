package test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author xiong
 */
@SpringBootApplication
@EnableScheduling
public class SylvanasTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(SylvanasTestApplication.class, args);
    }
}
