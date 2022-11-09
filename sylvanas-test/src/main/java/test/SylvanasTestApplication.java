package test;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author xiong
 */
@EnableDubbo
@SpringBootApplication
@EnableScheduling
public class SylvanasTestApplication {
    public static void main(String[] args) {

        SpringApplication.run(SylvanasTestApplication.class, args);
    }
}
