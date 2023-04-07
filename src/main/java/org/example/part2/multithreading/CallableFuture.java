package org.example.part2.multithreading;

import java.util.Random;
import java.util.concurrent.*;

public class CallableFuture {
    private static int result;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Started");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");
                Random random = new Random();
                int randomValue = random.nextInt();
                if (randomValue < 5)
                    throw new Exception("something bad happened");
                return random.nextInt(10);
            }
        });
        System.out.println("execution1");
        executorService.shutdown();
        System.out.println("execution2");
        int result = 0;
        try {
            System.out.println("execution3");
            result = future.get();
            System.out.println("execution4s");
            System.out.println(result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            Throwable ex = e.getCause();
            System.out.println(ex.getMessage());
        }
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(result);
    }

    public static int calculate() {
        return 5 + 4;
    }
}
