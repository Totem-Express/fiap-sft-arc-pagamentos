package br.com.fiap.totem_express_payments.application.impl;

import br.com.fiap.totem_express_payments.application.CreatePaymentUseCase;
import br.com.fiap.totem_express_payments.application.PaymentGateway;
import br.com.fiap.totem_express_payments.application.input.CreatePaymentInput;
import br.com.fiap.totem_express_payments.application.output.PaymentView;
import br.com.fiap.totem_express_payments.application.output.PaymentView.FullPaymentView;
import br.com.fiap.totem_express_payments.domain.Payment;

public class CreatePaymentUseCaseImpl implements CreatePaymentUseCase {

    private final PaymentGateway gateway;

    public CreatePaymentUseCaseImpl(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public PaymentView execute(CreatePaymentInput input) {
        final var payment = gateway.create(input);
        return new FullPaymentView(
                payment.getId(),
                payment.getStatus(),
                payment.getQrCode(),
                payment.getTransactionId(),
                payment.getAmount(),
                payment.getCreatedAt());
    }
}
