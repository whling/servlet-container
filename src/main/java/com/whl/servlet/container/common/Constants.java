package com.whl.servlet.container.common;

/**
 * Created by whling on 2018/3/25.
 */
public interface Constants {

    int PORT = 8080;

    int CORE_THREAD_COUNT = Runtime.getRuntime().availableProcessors();

    long THREADPOOL_KEEP_ALIVE_TIME = 60;

    String CRLF = "\r\n";

}
