package dev.gustavoteixeirah.backoffice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(TestcontainersConfiguration.class)
class BackofficeApplicationTests {

	@Autowired

	@Test
	void contextLoads() {
	}

}
