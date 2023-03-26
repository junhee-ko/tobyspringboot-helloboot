package me.jko.tobyspringboothelloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HelloServiceTest {

  @Test
  void simpleHelloService() {
    SimpleHelloService simpleHelloService = new SimpleHelloService();

    String ret = simpleHelloService.sayHello("jko");

    Assertions.assertThat(ret).isEqualTo("Hello jko");
  }
}
