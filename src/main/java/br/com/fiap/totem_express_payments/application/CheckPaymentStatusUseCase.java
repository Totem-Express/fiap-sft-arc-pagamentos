package br.com.fiap.totem_express_payments.application;

import br.com.fiap.totem_express_payments.application.output.PaymentView;

public interface CheckPaymentStatusUseCase {
    PaymentView checkStatus(Long paymentId);
}