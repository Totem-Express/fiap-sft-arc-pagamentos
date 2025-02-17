package br.com.fiap.totem_express_payments.application.output;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.fiap.totem_express_payments.domain.Status;

public interface PaymentView {

    Long id();

    Status status();

    String qrCode();

    record SimpleView(Long id, Status status, String qrCode) implements PaymentView {
    }

    record FullPaymentView(Long id, Status status, String qrCode, String transactionId, BigDecimal amount,
            LocalDateTime createdAt) implements PaymentView {
    }
}