package br.com.fiap.totem_express_payments.application;

import br.com.fiap.totem_express_payments.application.input.CreatePaymentInput;
import br.com.fiap.totem_express_payments.application.output.PaymentView;
import br.com.fiap.totem_express_payments.domain.Payment;

public interface CreatePaymentUseCase {
    PaymentView execute(CreatePaymentInput input);
}
