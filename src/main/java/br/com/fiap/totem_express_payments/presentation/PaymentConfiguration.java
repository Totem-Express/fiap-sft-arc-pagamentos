package br.com.fiap.totem_express_payments.presentation;

import br.com.fiap.totem_express_payments.application.*;
import br.com.fiap.totem_express_payments.application.impl.CheckPaymentStatusUseCaseImpl;
import br.com.fiap.totem_express_payments.application.impl.ProcessPaymentWebhookUseCaseImpl;
import br.com.fiap.totem_express_payments.infrastructure.PaymentGatewayImpl;
import br.com.fiap.totem_express_payments.infrastructure.PaymentRepository;
import br.com.fiap.totem_express_payments.infrastructure.mock.FakePaymentGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PaymentConfiguration {

    private final PaymentRepository repository;
    private final RestTemplate restTemplate;

    public PaymentConfiguration(PaymentRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    @Bean
    public PaymentGateway paymentGateway() {
        return new PaymentGatewayImpl(repository);
    }

    @Bean
    public CheckPaymentStatusUseCase checkPaymentStatusUseCase() {
        return new CheckPaymentStatusUseCaseImpl(paymentGateway());
    }

    @Bean
    public ProcessPaymentWebhookUseCase processPaymentWebhookUseCase() {
        return new ProcessPaymentWebhookUseCaseImpl(paymentGateway());
    }

    @Bean
    PaymentProcessorGateway qrCodeGateway() {
        return new FakePaymentGateway();
    }
}
