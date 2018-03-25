package com.whl.servlet.container.servlet;

import com.whl.servlet.container.core.Request;
import com.whl.servlet.container.core.Response;

/**
 * Created by whling on 2018/3/25.
 */
public class HelloServlet extends Servlet {

    @Override
    public void doGet(Request request, Response response) {
        System.out.println("hello world");
        response.write("welcome to whling's tomcat");
    }

    @Override
    public void doPost(Request request, Response response) {
        this.doGet(request, response);
    }
}
