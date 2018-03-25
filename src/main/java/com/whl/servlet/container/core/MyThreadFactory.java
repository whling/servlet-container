package com.whl.servlet.container.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by whling on 2018/3/25.
 */
public class MyThreadFactory implements ThreadFactory {

    private static final Logger logger = LoggerFactory.getLogger(MyThreadFactory.class);

    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        count.incrementAndGet();
        logger.info("create thread count:{}", count);
        return new DispatcherFactory(r,count);
    }
}
