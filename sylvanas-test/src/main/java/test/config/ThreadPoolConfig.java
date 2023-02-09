package test.config;


import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import test.utils.Threads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 *
 * @author xiong
 */
@Configuration
public class ThreadPoolConfig {

    private final Logger logger = LoggerFactory.getLogger(ThreadPoolConfig.class);

    /**
     * 4C 16核
     */
    int processNum = Runtime.getRuntime().availableProcessors() * 16 * 2;


    /**
     * // 核心线程池大小
     */
    private int corePoolSize = (int) (processNum / (1 - 0.2));


    /**
     * // 最大可创建的线程数
     */
    private int maxPoolSize = (int) (processNum / (1 - 0.5));


    /**
     * // 队列最大长度
     */
    private int queueCapacity = maxPoolSize * 1000;

    /**
     * // 线程池维护线程所允许的空闲时间
     */
    private int keepAliveSeconds = 300;

    @Bean(name = "finThreadPoolTaskExecutor")
    public ThreadPoolTaskExecutor finThreadPoolTaskExecutor() {
        logger.warn("ThreadPoolConfig-threadPoolTaskExecutor线程池获取硬件线程数" + processNum);
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(maxPoolSize);
        executor.setCorePoolSize(corePoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadPriority(Thread.MAX_PRIORITY);
        executor.setDaemon(false);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        /**
         *  线程池对拒绝任务(无线程可用)的处理策略
         */
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadNamePrefix("cuckoo-finance-executor-");
        return executor;
    }

    /**
     * 执行周期性或定时任务
     */
    @Bean(name = "scheduledExecutorService")
    protected ScheduledExecutorService scheduledExecutorService() {
        logger.warn("ThreadPoolConfig-scheduledExecutorService线程池核心线程数" + corePoolSize);
        return new ScheduledThreadPoolExecutor(corePoolSize,
                new BasicThreadFactory.Builder().namingPattern("cuckoo-finance-schedule-pool-%d").daemon(true).build()) {
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                Threads.printException(r, t);
            }
        };
    }
}
