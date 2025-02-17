package br.com.fiap.totem_express_payments.infrastructure.mock;

import br.com.fiap.totem_express_payments.application.PaymentProcessorGateway;
import br.com.fiap.totem_express_payments.application.input.GenerateQRCodeInput;
import br.com.fiap.totem_express_payments.infrastructure.mercadopago.PaymentProcessorResponse;

import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FakePaymentGateway implements PaymentProcessorGateway {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz123456789";

    @Override
    public PaymentProcessorResponse createPaymentQRCode(GenerateQRCodeInput input) {
        return new PaymentProcessorResponse(
                generateQRCodeData(),
                UUID.randomUUID().toString());
    }

    private String generateQRCodeData() {
        final var random = new Random();

        return IntStream
                .range(0, 36)
                .mapToObj(index -> String.valueOf(ALPHABET.charAt(random.nextInt(ALPHABET.length()))))
                .collect(Collectors.joining(""));
    }

}
