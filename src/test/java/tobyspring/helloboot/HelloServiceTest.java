package tobyspring.helloboot;

import static org.assertj.core.api.Assertions.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Test;

public class HelloServiceTest {

	private static HelloRepository helloRepositoryStub = new HelloRepository() {
		@Override
		public Hello findHello(String name) {
			return null;
		}

		@Override
		public void increaseCount(String name) {

		}
	};

	@FastUnitTest
	void simpleHelloService() {

		SimpleHelloService helloService = new SimpleHelloService(helloRepositoryStub);

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

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@UnitTest
@interface FastUnitTest {

}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Test
@interface UnitTest {

}

