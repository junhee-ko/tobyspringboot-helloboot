package me.jko.tobyspringboothelloboot;

import java.util.Objects;

public class HelloController {
  private final HelloService helloService;

  public HelloController(HelloService helloService) {
    this.helloService = helloService;
  }

  public String hello(String name) {
    HelloService helloService = new SimpleHelloService();

    return helloService.sayHello(Objects.requireNonNull(name));
  }
}
