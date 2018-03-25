package com.whl.servlet.container.core;

import com.whl.servlet.container.common.HttpUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by whling on 2018/3/25.
 */
public class Response {

    private OutputStream outputStream;

    public Response(Socket socket) throws IOException {
        outputStream = socket.getOutputStream();
    }

    public void write(String content) {
        HttpUtils.write(outputStream, content);
    }
}
