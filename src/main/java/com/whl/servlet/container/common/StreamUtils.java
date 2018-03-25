package com.whl.servlet.container.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by whling on 2018/3/25.
 */
public class StreamUtils {

    public static void closeStream(InputStream inputStream) {
        try {
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("close stream occur excepiton");
        }
    }

    public static void closeStream(OutputStream outputStream) {
        try {
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("close stream occur excepiton");
        }
    }
}
