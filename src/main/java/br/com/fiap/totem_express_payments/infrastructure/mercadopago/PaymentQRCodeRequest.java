package br.com.fiap.totem_express_payments.infrastructure.mercadopago;

import br.com.fiap.totem_express_payments.application.input.GenerateQRCodeInput;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

public record PaymentQRCodeRequest(@JsonProperty("external_reference") String transactionId,
                                   @JsonProperty("title") String nameOrder,
                                   @JsonProperty("description") String description,
                                   @JsonProperty("total_amount") BigDecimal totalAmount,
                                   @JsonProperty("items") List<PaymentQRCodeItem> items) implements GenerateQRCodeInput {
}
