package br.com.fiap.totem_express_payments.presentation.request;

import java.math.BigDecimal;

import br.com.fiap.totem_express_payments.application.input.CreatePaymentInput;

public record CreatePaymentRequest(BigDecimal amount) implements CreatePaymentInput {
    @Override
    public BigDecimal getAmount() {
        return amount;
    }
}
