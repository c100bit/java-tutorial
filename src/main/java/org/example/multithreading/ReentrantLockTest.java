package org.example.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.firstThread();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.secondThread();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        task.showCounter();
    }
}

class Task {
    public int counter;
    private Lock lock = new ReentrantLock();

    public void firstThread() {
        System.out.println("firstThread start");
        lock.lock();
        lock.lock();
        System.out.println("firstThread locked");
        increment();
        System.out.println("firstThread increment");
        lock.unlock();
        System.out.println("firstThread unlocked");
    }

    public void secondThread() {
        System.out.println("secondThread start");
        lock.lock();
        System.out.println("secondThread locked");
        increment();
        System.out.println("secondThread increment");
        lock.unlock();
        System.out.println("secondThread unlocked");
    }


    private void increment() {
        for (int i = 0; i < 100000; i++)
            counter++;
    }

    public void showCounter() {
        System.out.println(counter);
    }
}