package test.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.CountDownLatch;

@Component
public class ReportingRptJob {
    @Autowired
    private ThreadPoolTaskExecutor finThreadPoolTaskExecutor;


    @Scheduled(cron = "0 0/1 * * * ?")
    public void ourCatalogue() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 9;i++) {
            int finalI = i;
            finThreadPoolTaskExecutor
                    .submit(new Thread(() -> {
                        try {
                            Thread.sleep(5000* finalI);
                            System.out.println(1);
                            countDownLatch.countDown();
                            return   ;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }));
        }
        countDownLatch.await();
        System.out.println(3);
    }
}
