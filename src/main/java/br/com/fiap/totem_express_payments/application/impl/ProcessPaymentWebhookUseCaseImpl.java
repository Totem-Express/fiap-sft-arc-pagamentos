package br.com.fiap.totem_express_payments.application.impl;

import br.com.fiap.totem_express_payments.application.PaymentGateway;
import br.com.fiap.totem_express_payments.application.ProcessPaymentWebhookUseCase;
import br.com.fiap.totem_express_payments.application.input.PaymentWebhookInput;
import br.com.fiap.totem_express_payments.domain.Payment;

public class ProcessPaymentWebhookUseCaseImpl implements ProcessPaymentWebhookUseCase {

    private final PaymentGateway gateway;

    public ProcessPaymentWebhookUseCaseImpl(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void process(Long paymentId, PaymentWebhookInput input) {
        Payment payment = gateway.findById(paymentId)
                .orElseThrow(() -> new IllegalArgumentException("Payment must exists invalid id " + paymentId));

        payment.processPayment(input.status());

        gateway.createOrUpdate(payment);
    }
}