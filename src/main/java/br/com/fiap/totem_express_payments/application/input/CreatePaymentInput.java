package br.com.fiap.totem_express_payments.application.input;

import java.math.BigDecimal;

public interface CreatePaymentInput {
    BigDecimal getAmount();
}
