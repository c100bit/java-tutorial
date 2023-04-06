package org.example.multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
    private    static  BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void produce() throws  InterruptedException {
        Random random = new Random();
        while (true){
            queue.put(random.nextInt(100));
        }
    }

    private static void consume() throws  InterruptedException{
        Random random = new Random();
        while (true) {
            Thread.sleep(100);
            if(random.nextInt(9) == 5)
                System.out.println(queue.take());
            System.out.println("size" + queue.size());
        }
    }

}
