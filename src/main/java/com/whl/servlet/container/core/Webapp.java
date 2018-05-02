package com.whl.servlet.container.core;

import com.whl.servlet.container.common.ClassUtils;
import com.whl.servlet.container.servlet.Servlet;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by whling on 2018/3/25.
 */
public class Webapp {

    private static final Logger logger = LoggerFactory.getLogger(Webapp.class);

    private static ServletContext servletContext;

    static {
        //parse web.xml and init servletcontext
        SAXReader saxReader = new SAXReader();
        try {
            Document doc = saxReader.read(Webapp.class.getClassLoader().getResourceAsStream("webapp/WEB-INF/web.xml"));
            Element root = doc.getRootElement(); //root节点
            Element element = (Element) root.elements();
            List elements = element.elements();
            for (Object ele: elements) {
                Element e = (Element) ele;
                if ("servlet".equals(e.getName())) {
                    List servletMapingList = e.elements();
                } else if ("servlet-mapping".equals(e.getName())) {

                }
            }
        }catch(Exception e){
            logger.error(e.getMessage(),e);
        }


        servletContext = new ServletContext();

    }

    public static Servlet getServlet(String url) {
        String servletName = servletContext.getUrlToServletMap().get(url);
        String servletClass = servletContext.getServletToClassMap().get(servletName);
        return (Servlet) ClassUtils.getObject(servletClass);
    }
}
