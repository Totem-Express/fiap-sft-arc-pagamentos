package br.com.fiap.totem_express_payments.infrastructure;

import br.com.fiap.totem_express_payments.application.PaymentGateway;
import br.com.fiap.totem_express_payments.application.PaymentProcessorGateway;
import br.com.fiap.totem_express_payments.application.input.CreatePaymentInput;
import br.com.fiap.totem_express_payments.domain.Payment;
import br.com.fiap.totem_express_payments.infrastructure.mercadopago.PaymentQRCodeRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PaymentGatewayImpl implements PaymentGateway {

    private final PaymentRepository repository;
    private final PaymentProcessorGateway mGateway;

    public PaymentGatewayImpl(PaymentRepository paymentRepository, PaymentProcessorGateway mGateway) {
        this.repository = paymentRepository;
        this.mGateway = mGateway;
    }

    @Override
    public Payment createOrUpdate(Payment payment) {
        return repository.save(new PaymentEntity(payment)).toDomain();
    }

    @Override
    public Optional<Payment> findById(Long id) {
        return repository.findById(id).map(PaymentEntity::toDomain);
    }

    @Override
    public Payment create(CreatePaymentInput input) {
        final var payment = new Payment(input.getAmount());
        final var qrCode = mGateway.createPaymentQRCode(
                new PaymentQRCodeRequest(
                        UUID.randomUUID().toString(),
                        "Order Totem",
                        "Descripton",
                        input.getAmount(),
                        List.of()));
        payment.setQrCode(qrCode.getQrData());
        PaymentEntity save = repository.save(new PaymentEntity(payment));
        Payment domain = save.toDomain();
        return domain;
    }
}
