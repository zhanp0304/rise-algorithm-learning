package org.rise.learning.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ScaleFirstArrayBlockingQueue
 *
 * @author zhanpeng
 */
public class ScaleFirstArrayBlockingQueue extends ArrayBlockingQueue<Runnable> {

    private final AtomicInteger currentIdleThreadCount = new AtomicInteger(0);

    public ScaleFirstArrayBlockingQueue(int capacity) {
        super(capacity);
    }


    @Override
    public boolean offer(Runnable e) {
        // TODO: pay attention to this operation is not thread safe (non-atomic)
        return currentIdleThreadCount.get() > 0 && super.offer(e);
    }

    @Override
    public Runnable take() throws InterruptedException {
        currentIdleThreadCount.incrementAndGet();
        Runnable take = super.take();
        currentIdleThreadCount.decrementAndGet();
        return take;
    }

    @Override
    public Runnable poll(long timeout, TimeUnit unit) throws InterruptedException {
        currentIdleThreadCount.incrementAndGet();
        Runnable poll = super.poll(timeout, unit);
        currentIdleThreadCount.decrementAndGet();
        return poll;
    }

    @Override
    public boolean add(Runnable runnable) {
        // it's supposed to be enqueued directly
        return super.offer(runnable);
    }
}