package me.jko.tobyspringboothelloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/*
 * RequestMapping 을 붙이지 않아도, DispatcherServlet 이 이 안에 매핑 정보가 담겨있을 것이라고 판단하고 메서드들을 뒤짐
 * */
@RestController
public class HelloController {
  private final HelloService helloService;

  public HelloController(HelloService helloService) {
    this.helloService = helloService;
  }

  /*
   * - "hello spring" 을 리턴하면, DispatcherServlet 이 "hello spring" 이름의 뷰가 있는지 확인. 없으면 404
   * - "hello spring" 을 리턴하면, DispatcherServlet 이 웹 응답의 바디로 넣어서 text-plain 으로 전달하게 하려면 "@ResponseBody" 를 추가해야함
   * - " @ResponseBody" 를 추가 안하려면, @RestController 를 붙이면 됨 -> DispatcherServlet 은 그럼 모든 메서드에 "@ResponseBody" 가 붙여있다고 가정함
   * */
  @GetMapping("/hello")
  public String hello(String name) {
    return helloService.sayHello(Objects.requireNonNull(name));
  }
}
