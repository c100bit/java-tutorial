package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerWN pc = new ProducerConsumerWN();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread2.start();
        thread1.start();

        thread1.join();
        thread2.join();
    }


}

class ProducerConsumerWN {
    private final int LIMIT = 10;
    private Queue<Integer> queue = new LinkedList<>();
    private Object lock = new Object();

    public void produce() throws InterruptedException {
        Random random = new Random();
        while (true) {
            synchronized (lock) {
                while (queue.size() == LIMIT)
                    lock.wait();
                queue.offer(random.nextInt(100));
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {

            synchronized (lock) {
                System.out.println(queue.poll());
                lock.notify();
            }
            Thread.sleep(1000);
        }
    }
}
