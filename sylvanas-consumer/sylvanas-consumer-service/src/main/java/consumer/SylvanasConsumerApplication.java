package consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author xiong
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAsync
public class SylvanasConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SylvanasConsumerApplication.class, args);
    }
}
