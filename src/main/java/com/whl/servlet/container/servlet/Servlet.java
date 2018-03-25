package com.whl.servlet.container.servlet;

import com.whl.servlet.container.core.Request;
import com.whl.servlet.container.core.Response;

/**
 * Created by whling on 2018/3/25.
 */
public abstract class Servlet {

    public void service(Request request, Response response) {
        if ("get".equalsIgnoreCase(request.getReqType())) {
            doGet(request, response);
        } else {
            doPost(request, response);
        }
    }

    public abstract void doGet(Request request, Response response);

    public abstract void doPost(Request request, Response response);
}
