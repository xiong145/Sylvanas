package test.Test;

import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class cop {
//    @Scheduled(cron = "* * * * * ? ")
    public void cc() throws InterruptedException {

        Thread.sleep(10000);
        System.out.println("546584685");
    }

}
