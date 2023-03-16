package test.utils;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

public class jihe {
    public static void main(String[] args) {
        Queue arrayBlockingQueue = new ArrayBlockingQueue(10);
        Queue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        Queue linkedQueue = new LinkedBlockingQueue();
        Queue delayQueue = new DelayQueue();
        Queue priorityQueue = new PriorityBlockingQueue();
        Queue synchronousQueue = new SynchronousQueue();
        Queue linkedList = new LinkedList();
        linkedList.add(synchronousQueue.add(priorityQueue.add(delayQueue.add(linkedQueue.add(concurrentLinkedQueue.add(arrayBlockingQueue.add(new cmcc(String.valueOf(System.currentTimeMillis())))))))));

        System.out.println(linkedList);
    }
}
