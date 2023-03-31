package tobyspring.helloboot;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@HellobootTest
public class HelloServiceCountTest {

	@Autowired
	HelloService helloService;

	@Autowired
	HelloRepository helloRepository;

	@Test
	void sayHelloIncreaseCount() {
		IntStream.rangeClosed(1, 10).forEach(count -> {
			helloService.sayHello("Toby");
			assertThat(helloRepository.countOf("Toby")).isEqualTo(count);
		});
	}
}
