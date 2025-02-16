package br.com.fiap.totem_express_payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TotemExpressPaymentsApplication implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
				.addMapping("/**")
				.allowedMethods("*")
				.allowedOrigins("*");
	}

	public static void main(String[] args) {
		SpringApplication.run(TotemExpressPaymentsApplication.class, args);
	}

}
