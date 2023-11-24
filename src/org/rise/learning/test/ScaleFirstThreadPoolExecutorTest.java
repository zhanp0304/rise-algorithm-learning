package org.rise.learning.test;

import org.rise.learning.threadpool.ScaleFirstThreadPoolExecutor;

import java.util.concurrent.TimeUnit;

public class ScaleFirstThreadPoolExecutorTest {

    public static void main(String[] args) throws InterruptedException {
        int corePoolSize = 2;
        int maximumPoolSize = 5;
        long keepAliveTime = 1000;
        TimeUnit unit = TimeUnit.MILLISECONDS;

        ScaleFirstThreadPoolExecutor executor = new ScaleFirstThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit);

        // Submit more tasks than the corePoolSize
        for (int i = 0; i < 10; i++) {
            int taskNumber = i;
            executor.execute(() -> {
                System.out.println("Executing task " + taskNumber + " on thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(200); // Simulate task execution time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("All tasks finished.");
    }
}
