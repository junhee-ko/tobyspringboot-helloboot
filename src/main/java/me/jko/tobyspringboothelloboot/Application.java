package me.jko.tobyspringboothelloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ComponentScan
public class Application {

  public static void main(String[] args) {
    AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {

      @Override
      protected void onRefresh() {
        super.onRefresh();

        // 서블릿 컨테이너를 만들고 서블릿 초기화 작업을 스프링 컨테이너가 초기화 되는 과정 중에.
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
          servletContext.addServlet("dispatcherServlet", new DispatcherServlet(this)).addMapping("/*");
        });

        webServer.start();
      }
    };

    applicationContext.register(Application.class);
    applicationContext.refresh();
  }
}
