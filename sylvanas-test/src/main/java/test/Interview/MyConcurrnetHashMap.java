package test.Interview;

import java.util.HashMap;
import java.util.concurrent.*;

public class MyConcurrnetHashMap {
    private static ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

    private static HashMap hashMap = new HashMap();

    private static ConcurrentLinkedQueue concurrentLinkedQueue1 = new ConcurrentLinkedQueue();

    private static ConcurrentLinkedQueue concurrentLinkedQueue2 = new ConcurrentLinkedQueue();

    private static ConcurrentLinkedQueue concurrentLinkedQueue10 = new ConcurrentLinkedQueue();

    private static ConcurrentLinkedQueue concurrentLinkedQueue20 = new ConcurrentLinkedQueue();
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new MyThread1());
        thread1.start();
        Thread thread2 = new Thread(new MyThread2());
        thread2.start();
        countDownLatch.await(1, TimeUnit.MINUTES);
        System.out.println(concurrentLinkedQueue1);
//        for (int i = 0; i < 499; i++) {
//            System.out.print(concurrentLinkedQueue1.poll());
//            System.out.print("  ");
//
//        }
//        System.out.println("");
        System.out.println(concurrentLinkedQueue10);
        System.out.println(concurrentLinkedQueue2);
        System.out.println(concurrentLinkedQueue20);
//        Thread thread3 = new Thread((Runnable) new MyThread3());
//        thread3.start();


    }

    static class MyThread1 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 500; i++) {
                concurrentHashMap.put(String.valueOf(i), i * 1);
                hashMap.put(String.valueOf(i), i * 1);
                concurrentLinkedQueue10.add(concurrentHashMap.get(String.valueOf(i)));
                concurrentLinkedQueue1.add(hashMap.get(String.valueOf(i)));
            }
            countDownLatch.countDown();

        }
    }

    static class MyThread2 implements Runnable {

        @Override
        public void run() {
            for (int i = 500; i < 1000; i++) {
                concurrentHashMap.put(String.valueOf(i), i * 1);
                hashMap.put(String.valueOf(i), i * 1);
                concurrentLinkedQueue20.add(concurrentHashMap.get(String.valueOf(i)));
                concurrentLinkedQueue2.add(hashMap.get(String.valueOf(i)));
            }
            countDownLatch.countDown();
        }
    }

    static class MyThread3 implements Callable<String> {


        @Override
        public String call() throws Exception {
            for (int i = 1000; i < 50; i++) {
                concurrentHashMap.put(String.valueOf(i), i * 3);
                System.out.println(concurrentHashMap.get(String.valueOf(i)));
            }
            return "1L";
        }
    }
}
