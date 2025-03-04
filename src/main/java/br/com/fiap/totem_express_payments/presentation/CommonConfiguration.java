package br.com.fiap.totem_express_payments.presentation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CommonConfiguration {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}