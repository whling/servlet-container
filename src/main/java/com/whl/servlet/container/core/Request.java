package com.whl.servlet.container.core;


import com.whl.servlet.container.common.Constants;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.net.Socket;
import java.util.Map;

/**
 * Created by whling on 2018/3/25.
 */
public class Request {

    private String reqType;
    private String url;
    private Map<String, String> parameters;

    public Request() {
    }

    public Request(Socket socket) {
        try {
            InputStream inputStream = socket.getInputStream();
            byte[] b = new byte[20480];
            int i = inputStream.read(b);
            String reqHeader = new String(b, 0, i);
            parseRequestInfo(reqHeader);
        } catch (Exception e) {
        }
    }


    private void parseRequestInfo(String reqHeader) {
        if (StringUtils.isEmpty(reqHeader)) return;
        String firstLine = reqHeader.substring(0, reqHeader.indexOf(Constants.CRLF));
        String[] requestLine = firstLine.split("\\s"); //请求行
        reqType = requestLine[0];
        url = requestLine[1];
    }


    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
}
