package tobyspring.helloboot;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class HelloServiceTest {

	@Test
	void simpleHelloService() {
		SimpleHelloService helloService = new SimpleHelloService();

		String ret = helloService.sayHello("Test");
		assertThat(ret).isEqualTo("Hello Test");
	}

	@Test
	public void helloDecorator() {
		HelloDecorator decorator = new HelloDecorator(name -> name);

		String ret = decorator.sayHello("Test");
		assertThat(ret).isEqualTo("*Test*");
	}
}
