package br.com.fiap.totem_express_payments.application.input;

import br.com.fiap.totem_express_payments.domain.Status;

public interface PaymentWebhookInput {
    Status status();
}