package org.example;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Multithreading {
    public static void main(String[] args) {
       // multithreading();
        //  volatileTest();
        threadPool();
    }

    private static void threadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0 ; i < 5 ; i++ ) {
            executorService.submit(new Work(i));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private static void volatileTest() {
        MyThread1  myThread1 = new MyThread1();
        myThread1.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        myThread1.shutdown();
    }
    private static void multithreading() {
        MyThread myThread = new MyThread();
        myThread.start();

        MyThread myThread2 = new MyThread();
        myThread2.start();

        Thread runner = new Thread(new Runner());
        runner.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i=0; i < 100; i ++)
            System.out.println("Main "  + i);
    }
}

class MyThread1 extends Thread {
    private  volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void shutdown() {
        System.out.println("PRESSED SHUTDOWN");
        running = false;
    }
}

class Runner implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++)
            System.out.println("Runner " + i);
    }
}
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++)
            System.out.println("MyThread " + i);
    }
}

class Work implements Runnable {
    private int id;

    public Work(int id ) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Work " + id + " was completed");
    }
}