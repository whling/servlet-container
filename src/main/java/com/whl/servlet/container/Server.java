package com.whl.servlet.container;

import com.whl.servlet.container.common.Constants;
import com.whl.servlet.container.core.Dispatcher;
import com.whl.servlet.container.core.MyThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ServerSocket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by whling on 2018/3/25.
 */
public class Server {

    private static final Logger logger = LoggerFactory.getLogger(Server.class);

    private static ServerSocket serverSocket;

    private static ExecutorService es
            = new ThreadPoolExecutor(
            Constants.CORE_THREAD_COUNT,
            Constants.CORE_THREAD_COUNT * 2,
            Constants.THREADPOOL_KEEP_ALIVE_TIME,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(200),
            new MyThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
    );

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        try {
            serverSocket = new ServerSocket(Constants.PORT);
        } catch (Exception e) {
            logger.error("server start occur error", e);
        }
        while (true) {
            try {
                es.submit(new Dispatcher(serverSocket.accept()));
            } catch (Exception e) {
                logger.error("", e);
            }
        }
    }
}
