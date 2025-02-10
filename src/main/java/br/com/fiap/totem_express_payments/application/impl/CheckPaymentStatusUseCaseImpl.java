package br.com.fiap.totem_express_payments.application.impl;

import br.com.fiap.totem_express_payments.application.CheckPaymentStatusUseCase;
import br.com.fiap.totem_express_payments.application.PaymentGateway;
import br.com.fiap.totem_express_payments.application.output.PaymentView;
import br.com.fiap.totem_express_payments.domain.Payment;

public class CheckPaymentStatusUseCaseImpl implements CheckPaymentStatusUseCase {

    private final PaymentGateway gateway;

    public CheckPaymentStatusUseCaseImpl(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public PaymentView checkStatus(Long paymentId) {
        Payment payment = gateway.findById(paymentId)
                .orElseThrow(() -> new IllegalArgumentException("Payment must exists invalid id " + paymentId));
        return new PaymentView.SimpleView(payment.getId(), payment.getStatus(), payment.getQrCode());
    }
}
