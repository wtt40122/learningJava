package com.wt.server;

import com.wt.server.request.RequestProcessor;
import com.wt.server.servlet.HttpServlet;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2021/10/13 19:59
 */
public class MiniTomcatBootstrap {

    private static final Integer port = 8080;

    private Map<String, HttpServlet> servletMap = new HashMap<>();

    public void start() throws Exception {

        loadServlet();

        int corePoolSize = 10;
        int maximumPoolSize = 20;
        long keepAliveTime = 1;
        TimeUnit unit = TimeUnit.MINUTES;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(100);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                threadFactory,
                handler);

        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            String data = "Hello mini tomcat";
            System.out.println(data);
            RequestProcessor requestProcessor = new RequestProcessor(socket, servletMap);
            threadPoolExecutor.execute(requestProcessor);
        }
    }

    private void loadServlet() {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("web.xml");
        SAXReader saxReader = new SAXReader();

        try {
            Document document = saxReader.read(resourceAsStream);
            Element rootElement = document.getRootElement();

            List<Element> selectNodes = rootElement.selectNodes("//servlet");
            for (int i = 0; i < selectNodes.size(); i++) {
                Element element = selectNodes.get(i);

                Element servletNameElement = (Element) element.selectSingleNode("servlet-name");
                String servletName = servletNameElement.getStringValue();

                Element servletClassElement = (Element) element.selectSingleNode("servlet-class");
                String servletClass = servletClassElement.getStringValue();

                Element servletMappingElement = (Element) rootElement.selectSingleNode("/web-app/servlet-mapping[servlet-name='" + servletName + "']");

                String urlPattern = servletMappingElement.selectSingleNode("url-pattern").getStringValue();
                servletMap.put(urlPattern, (HttpServlet) Class.forName(servletClass).newInstance());
            }

        } catch (DocumentException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) throws IOException {
        MiniTomcatBootstrap miniTomcatBootstrap = new MiniTomcatBootstrap();
        try {
            miniTomcatBootstrap.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
