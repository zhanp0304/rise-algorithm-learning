package org.rise.learning.threadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * ScaleFirstThreadPoolExecutor
 *
 * @author zhanpeng
 */
public class ScaleFirstThreadPoolExecutor extends ThreadPoolExecutor {


    public ScaleFirstThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, new ScaleFirstUnboundedBlockingQueue());
        setRejectedExecutionHandler(new ReEnqueuePolicy());
    }

    public ScaleFirstThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, int queueCapacity) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, new ScaleFirstArrayBlockingQueue(queueCapacity));
        setRejectedExecutionHandler(new ReEnqueuePolicy());
    }


    private static class ReEnqueuePolicy implements RejectedExecutionHandler {
        private final RejectedExecutionHandler rejectedExecutionHandler;

        public ReEnqueuePolicy() {
            this.rejectedExecutionHandler = new ThreadPoolExecutor.AbortPolicy();
        }

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            // here we use add() instead of offer() to avoid deadlock, it's supposed to be enqueued directly
            if (!executor.getQueue().add(r)) {
                rejectedExecutionHandler.rejectedExecution(r, executor);
            }
        }
    }
}
