package me.jko.tobyspringboothelloboot;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();

    WebServer webServer = serverFactory.getWebServer(servletContext -> {
      servletContext.addServlet("hello", new HttpServlet() {
        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          // 인증, 보안, 다국어 처리, 공통 기능 ..

          if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
            String name = req.getParameter("name");

            resp.setStatus(HttpStatus.OK.value());
            resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
            resp.getWriter().println("Hello Servlet " + name);
          } else if (req.getRequestURI().equals("/user")) {
            // ...
          } else {
            // ...
          }
        }
      }).addMapping("/*");
    });

    webServer.start();
  }

}
