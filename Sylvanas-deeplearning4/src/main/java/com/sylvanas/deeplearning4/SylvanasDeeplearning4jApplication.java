package com.sylvanas.deeplearning4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author an-hou.xiong
 */
@SpringBootApplication
@EnableScheduling
public class SylvanasDeeplearning4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(SylvanasDeeplearning4jApplication.class, args);
    }

}
