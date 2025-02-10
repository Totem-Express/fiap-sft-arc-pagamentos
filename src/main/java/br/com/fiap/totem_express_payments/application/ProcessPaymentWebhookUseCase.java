package br.com.fiap.totem_express_payments.application;

import br.com.fiap.totem_express_payments.application.input.PaymentWebhookInput;

public interface ProcessPaymentWebhookUseCase {
    void process(Long paymentId, PaymentWebhookInput input);
}