package br.com.fiap.totem_express_payments.application.impl;

import br.com.fiap.totem_express_payments.application.FindByIdUseCase;
import br.com.fiap.totem_express_payments.application.PaymentGateway;
import br.com.fiap.totem_express_payments.domain.Payment;

import java.util.Optional;

public class FindByIdUseCaseImpl implements FindByIdUseCase {

    private final PaymentGateway gateway;

    public FindByIdUseCaseImpl(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Optional<Payment> findById(String id) {
        return gateway.findById(Long.valueOf(id));
    }
}
