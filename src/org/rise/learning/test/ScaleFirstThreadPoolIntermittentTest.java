package org.rise.learning.test;

import org.rise.learning.threadpool.ScaleFirstThreadPoolExecutor;

import java.util.concurrent.*;

public class ScaleFirstThreadPoolIntermittentTest {

    public static void main(String[] args) throws InterruptedException {
        int corePoolSize = 5;
        int maximumPoolSize = 20;
        long keepAliveTime = 5000; // 5 seconds for idle deallocation
        ThreadPoolExecutor executor = new ScaleFirstThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                1024
        );

        // Simulate initial burst of requests
        for (int i = 0; i < 100; i++) {
            int taskNumber = i;
            executor.execute(() -> {
                try {
                    System.out.println("Executing task peak-" + taskNumber + " on thread " + Thread.currentThread().getName());
                    Thread.sleep(100); // Simulate task execution
                } catch (InterruptedException ignored) {
                }
            });
        }

        // Wait for a minute
        Thread.sleep(60000);

        // Simulate sparse requests
        for (int i = 0; i < 10; i++) {
            int taskNumber = i;
            executor.execute(() -> {
                try {
                    System.out.println("Executing task normal-" + taskNumber + " on thread " + Thread.currentThread().getName());
                    Thread.sleep(100); // Simulate task execution
                } catch (InterruptedException ignored) {
                }
            });
            Thread.sleep(5000); // Wait between sparse requests
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);

        System.out.println("All tasks finished.");
    }
}

