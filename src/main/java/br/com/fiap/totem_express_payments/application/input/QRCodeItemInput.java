package br.com.fiap.totem_express_payments.application.input;

import java.math.BigDecimal;

public interface QRCodeItemInput {
    String title();

    String description();

    BigDecimal unitPrice();

    Long quantity();

    String unitMeasure();

    BigDecimal totalAmount();
}
