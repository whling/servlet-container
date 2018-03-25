package com.whl.servlet.container.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by whling on 2018/3/25.
 */
public class ClassUtils {

    private static final Logger logger = LoggerFactory.getLogger(ClassUtils.class);

    public static Object getObject(String className) {
        Class<?> aClass = null;
        try {
            aClass =
                    Class.forName(className);

        } catch (Exception e) {
            logger.error("class reflect occur exception,className:{}", className, e);
        }
        return aClass;
    }
}
