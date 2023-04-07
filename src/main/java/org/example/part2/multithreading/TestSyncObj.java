package org.example.part2.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestSyncObj {
    private int counter;

    public static void main(String[] args) throws InterruptedException {
        //TestSync testSync = new TestSync();
        //testSync.doWork();

        new Worker().main();
    }

    public void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++)
                    increment();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++)
                    increment();
            }
        });

        thread2.start();
        thread1.start();

        thread1.join();
        thread2.join();
        System.out.println(counter);
    }

    public void increment() {
        synchronized (this) {
            counter++;
        }


    }
}

class Worker {
    Random random = new Random();

    Object lock1 = new Object();
    Object lock2 = new Object();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void addToList1() {

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (lock1) {
            list1.add(random.nextInt(100));
        }
    }

    public void addToList2() {

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (lock2) {
            list2.add(random.nextInt(100));
        }
    }

    public void work() {
        for (int i = 0; i < 1000; i++) {
            addToList1();
            addToList2();
        }
    }

    public void main() {
        long before = System.currentTimeMillis();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
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

        long after = System.currentTimeMillis();
        System.out.println(after - before);
        System.out.println(list1.size());
        System.out.println(list2.size());
    }
}