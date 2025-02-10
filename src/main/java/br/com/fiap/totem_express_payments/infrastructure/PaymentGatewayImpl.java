package br.com.fiap.totem_express_payments.infrastructure;

import br.com.fiap.totem_express_payments.application.PaymentGateway;
import br.com.fiap.totem_express_payments.domain.Payment;

import java.util.Optional;

public class PaymentGatewayImpl implements PaymentGateway {

    private final PaymentRepository repository;

    public PaymentGatewayImpl(PaymentRepository paymentRepository) {
        this.repository = paymentRepository;
    }

    @Override
    public Optional<Payment> findById(Long id) {
        return repository.findById(id).map(PaymentEntity::toDomain);
    }

    @Override
    public Payment create(Payment payment) {
        PaymentEntity save = repository.save(new PaymentEntity(payment));
        Payment domain = save.toDomain();
        return domain;
    }
}
