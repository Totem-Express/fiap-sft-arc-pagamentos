package br.com.fiap.totem_express_payments.application.impl;

import br.com.fiap.totem_express_payments.application.PaymentGateway;
import br.com.fiap.totem_express_payments.application.input.PaymentWebhookInput;
import br.com.fiap.totem_express_payments.domain.Payment;
import br.com.fiap.totem_express_payments.presentation.request.PaymentWebhookRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static br.com.fiap.totem_express_payments.domain.Status.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProcessPaymentWebhookUseCaseImplTest {

    private PaymentGateway gateway;

    private ProcessPaymentWebhookUseCaseImpl useCase;

    @BeforeEach
    void setUp() {
        gateway = mock(PaymentGateway.class);
        useCase = new ProcessPaymentWebhookUseCaseImpl(gateway);
    }

    @Test
    void should_process_payment_for_paid_when_payment_exists() {
        Long paymentId = 1L;
        Payment payment = new Payment(
                paymentId,
                LocalDateTime.now(),
                LocalDateTime.now(),
                PENDING,
                "TXN123",
                new BigDecimal("100.00"),
                "QRCode123");

        when(gateway.findById(paymentId)).thenReturn(Optional.of(payment));

        PaymentWebhookInput input = new PaymentWebhookRequest(paymentId, PAID);

        useCase.process(paymentId, input);

        assertThat(payment.getStatus()).isEqualTo(PAID);
    }

    @Test
    void should_return_exception_when_payment_does_not_exist() {
        Long paymentId = 1L;
        PaymentWebhookInput input = new PaymentWebhookRequest(paymentId, PENDING);

        when(gateway.findById(paymentId)).thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                useCase.process(paymentId, input)
        );

        assertThat(exception.getMessage()).isEqualTo("Payment must exists invalid id " + paymentId);
    }
}