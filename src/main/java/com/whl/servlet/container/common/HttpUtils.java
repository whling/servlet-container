package com.whl.servlet.container.common;

import com.whl.servlet.container.core.Request;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by whling on 2018/3/25.
 */
public class HttpUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    public static Request parseHttpRequest(InputStream inputStream) {
        Request request = new Request();
        String reqHeader = "";
        try {
            byte[] b = new byte[20480];
            int i = inputStream.read(b);
            reqHeader = new String(b, 0, i);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            // 试试这里关闭了流，请求会变成什么样子 todo
            StreamUtils.closeStream(inputStream);
        }
        if (StringUtils.isEmpty(reqHeader))
            throw new RuntimeException("request is illegal");
        String firstLine = reqHeader.substring(0, reqHeader.indexOf(Constants.CRLF));
        String[] requestLine = firstLine.split("\\s"); //请求行
        request.setReqType(requestLine[0]);
        request.setUrl(requestLine[1]);
        return request;
    }


    public static void write(OutputStream outputStream, String content) {
        // write response info to browser

        StringBuilder sb =
                new StringBuilder();
        try {
            sb.append("HTTP/1.1 200 OK").append("\n")
                    .append("Content-Type: text/html").append("\n")
                    .append("\r\n")
                    .append("<html><body>").append("\n")
                    .append(content).append("\n")
                    .append("</body></html>");
            outputStream.write(sb.toString().getBytes());
        }catch(Exception e){
            logger.error("response to client fail",e);
            throw new RuntimeException("response to client fail");
        }
    }
}
