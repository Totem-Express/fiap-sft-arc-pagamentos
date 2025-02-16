package br.com.fiap.totem_express_payments;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class TotemExpressPaymentsApplicationTests {

	@Test
	void contextLoads() {
	}

}
