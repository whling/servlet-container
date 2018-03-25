package com.whl.servlet.container.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by whling on 2018/3/25.
 */
public class DispatcherFactory extends Thread {

    private static final Logger logger = LoggerFactory.getLogger(DispatcherFactory.class);

    private Runnable runnable;

    private AtomicInteger count;

    public DispatcherFactory(Runnable runnable,AtomicInteger count) {
        this.runnable = runnable;
        this.count = count;
    }

    @Override
    public void run() {
        try {
            runnable.run();
        } finally {
            int currentThreadCount = count.decrementAndGet();
            logger.info("thread run over,threadpool remain thread count :{}", currentThreadCount);
        }
    }
}
