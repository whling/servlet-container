package com.whl.servlet.container.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by whling on 2018/3/25.
 */
public class ServletContext {

    private Map<String, String> urlToServletMap;

    private Map<String, String> servletToClassMap;


    public ServletContext() {
        urlToServletMap = new HashMap<>();
        servletToClassMap = new HashMap<>();
    }

    public Map<String, String> getUrlToServletMap() {
        return urlToServletMap;
    }

    public void setUrlToServletMap(Map<String, String> urlToServletMap) {
        this.urlToServletMap = urlToServletMap;
    }

    public Map<String, String> getServletToClassMap() {
        return servletToClassMap;
    }

    public void setServletToClassMap(Map<String, String> servletToClassMap) {
        this.servletToClassMap = servletToClassMap;
    }
}
