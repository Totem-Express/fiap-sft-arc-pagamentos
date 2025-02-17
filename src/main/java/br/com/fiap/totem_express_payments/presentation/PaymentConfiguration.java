package br.com.fiap.totem_express_payments.presentation;

import br.com.fiap.totem_express_payments.application.*;
import br.com.fiap.totem_express_payments.application.impl.CheckPaymentStatusUseCaseImpl;
import br.com.fiap.totem_express_payments.application.impl.CreatePaymentUseCaseImpl;
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
    public PaymentGateway paymentGateway(PaymentProcessorGateway processor) {
        return new PaymentGatewayImpl(repository, processor);
    }

    @Bean
    public CreatePaymentUseCase createPaymentUseCase(PaymentGateway gateway) {
        return new CreatePaymentUseCaseImpl(gateway);
    }

    @Bean
    public CheckPaymentStatusUseCase checkPaymentStatusUseCase(PaymentGateway gateway) {
        return new CheckPaymentStatusUseCaseImpl(gateway);
    }

    @Bean
    public ProcessPaymentWebhookUseCase processPaymentWebhookUseCase(PaymentGateway gateway) {
        return new ProcessPaymentWebhookUseCaseImpl(gateway);
    }

    @Bean
    PaymentProcessorGateway qrCodeGateway() {
        return new FakePaymentGateway();
    }
}
