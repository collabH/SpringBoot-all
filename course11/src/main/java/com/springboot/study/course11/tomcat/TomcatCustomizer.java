package com.springboot.study.course11.tomcat;

import org.apache.catalina.Valve;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.valves.AccessLogValve;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 定制tomcat容器
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course11.tomcat
 * @PROJECT_NAME springboot
 * @date 2018/12/26
 */
@Configuration
public class TomcatCustomizer {
    @Bean
    public ConfigurableServletWebServerFactory configurableServletWebServerFactory(){
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        //修改tomcat容器端口
        factory.setPort(10000);
        factory.addContextValves(getLogAccessLogValve());
        //配置tomcat连接器
        factory.addConnectorCustomizers(new MyTomcatConnectorCustomizer());
        factory.addInitializers((servletContext) -> {
            System.out.println("===========servletContext start up=============");
            servletContext.setAttribute("startup","true");
        });
        return factory;
    }

    /**
     * 设置tomcat日志打印
     * @return
     */
    private AccessLogValve getLogAccessLogValve() {
        AccessLogValve logValve = new AccessLogValve();
        //日志存放目录
        logValve.setDirectory("G:\\logs");
        logValve.setEnabled(true);
        //日志记录的模式
        logValve.setPattern("%h %l %u %t \"%r\" %s %b");
        logValve.setPrefix("Springboot-access");
        logValve.setSuffix(".txt");
        return logValve;
    }

    /**
     * 定制连接器
     */
 class  MyTomcatConnectorCustomizer implements TomcatConnectorCustomizer{

     @Override
     public void customize(Connector connector) {
         System.out.println(connector.getProtocol());
         Http11NioProtocol protocol= (Http11NioProtocol) connector.getProtocolHandler();
         //2000最大连接数
         protocol.setMaxConnections(2000);
         //500线程
         protocol.setMaxThreads(500);
     }
 }
}
