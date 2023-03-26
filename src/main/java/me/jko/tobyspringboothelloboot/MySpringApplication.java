//package me.jko.tobyspringboothelloboot;
//
//import org.springframework.boot.web.server.WebServer;
//import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//public class MySpringApplication {
//
//  public static void run(Class<?> applicationClass, String[] args) {
//    AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
//
//      @Override
//      protected void onRefresh() {
//        super.onRefresh();
//
//        ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
//        DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
//
//        /*
//         * Spring Container 가 DispatcherServlet 은 ApplicationContext 가 필요하다고 판단해서 주입을 해줌
//         * by ApplicationContextAware setApplicationContext
//         * */
//        // dispatcherServlet.setApplicationContext(this);
//
//        WebServer webServer = serverFactory.getWebServer(servletContext -> {
//          servletContext.addServlet("dispatcherServlet", dispatcherServlet).addMapping("/*");
//        });
//
//        webServer.start();
//      }
//    };
//
//    applicationContext.register(applicationClass);
//    applicationContext.refresh();
//  }
//}
