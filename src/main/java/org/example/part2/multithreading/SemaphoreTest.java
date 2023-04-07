package org.example.part2.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {
    static int id;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Connection connection = Connection.getConnection();

        for (int i = 0; i < 10; i++) {
            id = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.work(id);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}


class Connection {
    private static Connection connection = new Connection();
    private int connectionsCount;
    private Semaphore semaphore = new Semaphore(2);

    private Connection() {
    }

    public static Connection getConnection() {
        return connection;
    }

    public void work(int i) throws InterruptedException {
        semaphore.acquire();
        try {
            doWork(i);
        } finally {
            semaphore.release();
        }
    }

    public void doWork(int i) throws InterruptedException {

        synchronized (this) {
            connectionsCount++;
            System.out.println("Thread" + i + " +" + connectionsCount);
        }
        Thread.sleep(1000);
        synchronized (this) {
            connectionsCount--;
            System.out.println("Thread" + i + "-" + connectionsCount);
        }
    }

}