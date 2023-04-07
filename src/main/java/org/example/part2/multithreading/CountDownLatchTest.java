package org.example.part2.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor(countDownLatch));
        }
        executorService.shutdown();
        System.out.println("shutdown");

        for (int i = 0; i < 3; i++) {
            try {

                Thread.sleep(1000);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Thread.sleep(3000);
        System.out.println("main thread is proceeding");
    }
}

class Processor implements Runnable {
    private CountDownLatch countDownLatch;

    public Processor(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.println("thread closed");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}