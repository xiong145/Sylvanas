package test.utils;

import java.util.concurrent.locks.ReentrantLock;

public class CPULoadGenerator implements Runnable {

    private boolean running;

    @Override
    public void run() {
        running = true;
        while (running) {
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < 10000) {
                //占用80%的CPU算力
            }
        }
    }

    public void stop() {
        running = false;
    }

    public static void main(String[] args) {

        CPULoadGenerator generator = new CPULoadGenerator();
        Thread thread = new Thread(generator);
        thread.start();
        try {
            Thread.sleep(600000); //运行1分钟后停止
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        generator.stop();
    }
}
