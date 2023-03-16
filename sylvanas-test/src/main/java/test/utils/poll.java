package test.utils;

import java.util.concurrent.ConcurrentLinkedQueue;

public class poll {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.add(1);
        queue.offer(2);
        queue.add(3);
        queue.offer(4);
        System.out.println("队列头部元素：" + queue.peek());

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
