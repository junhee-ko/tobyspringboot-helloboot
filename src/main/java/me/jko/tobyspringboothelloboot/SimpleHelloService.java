package me.jko.tobyspringboothelloboot;

public class SimpleHelloService implements HelloService {

  @Override
  public String sayHello(String name) {
    return "Hello " + name;
  }
}
