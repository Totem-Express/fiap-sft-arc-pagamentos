package br.com.fiap.totem_express_payments.application.input;

import java.math.BigDecimal;
import java.util.List;

public interface GenerateQRCodeInput {
    String transactionId();

    String nameOrder();

    String description();

    BigDecimal totalAmount();

    List<? extends QRCodeItemInput> items();
}
