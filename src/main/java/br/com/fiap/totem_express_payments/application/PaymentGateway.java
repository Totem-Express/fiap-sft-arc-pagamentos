package br.com.fiap.totem_express_payments.application;

import br.com.fiap.totem_express_payments.application.input.CreatePaymentInput;
import br.com.fiap.totem_express_payments.domain.Payment;

import java.util.Optional;

public interface PaymentGateway {

    Optional<Payment> findById(Long id);

    Payment createOrUpdate(Payment payment);

    Payment create(CreatePaymentInput input);
}
