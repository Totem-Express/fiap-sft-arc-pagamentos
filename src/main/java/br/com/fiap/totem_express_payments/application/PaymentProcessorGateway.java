package br.com.fiap.totem_express_payments.application;

import br.com.fiap.totem_express_payments.application.input.GenerateQRCodeInput;
import br.com.fiap.totem_express_payments.infrastructure.mercadopago.PaymentProcessorResponse;

public interface PaymentProcessorGateway {
    PaymentProcessorResponse createPaymentQRCode(GenerateQRCodeInput input);
}
