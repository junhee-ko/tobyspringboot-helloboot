package me.jko.tobyspringboothelloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@UnitTest
@interface FastUnitTest {

}
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD })
@Test
@interface UnitTest {

}

class HelloServiceTest {

  @FastUnitTest
  void simpleHelloService() {
    SimpleHelloService simpleHelloService = new SimpleHelloService();

    String ret = simpleHelloService.sayHello("jko");

    Assertions.assertThat(ret).isEqualTo("Hello jko");
  }

  @Test
  void helloDecorator() {
    HelloDecorator simpleHelloService = new HelloDecorator(name -> name);

    String ret = simpleHelloService.sayHello("jko");

    Assertions.assertThat(ret).isEqualTo("*jko*");
  }
}
