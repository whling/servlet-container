package com.whl.servlet.container.core;

import com.whl.servlet.container.common.HttpUtils;
import com.whl.servlet.container.servlet.Servlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Socket;

/**
 * Created by whling on 2018/3/25.
 */
public class Dispatcher implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(Dispatcher.class);

    private Socket socket;


    public Dispatcher(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            Request request = HttpUtils.parseHttpRequest(socket.getInputStream());
            Response response = new Response(socket);

            Servlet servlet = Webapp.getServlet(request.getUrl());
            servlet.service(request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
