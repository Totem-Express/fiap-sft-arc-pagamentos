package br.com.fiap.totem_express_payments.application.output;

import br.com.fiap.totem_express_payments.domain.Status;

public interface PaymentView {

    Long id();

    Status status();

    String qrCode();

    record SimpleView(Long id, Status status, String qrCode) implements PaymentView {
    }
}