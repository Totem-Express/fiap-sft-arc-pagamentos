package br.com.fiap.totem_express_payments.application.input;

import br.com.fiap.totem_express_payments.presentation.request.CreatePaymentRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CreatePaymentInputTest {

    @Test
    void should_create_dto_correctly(){
        final var request = new CreatePaymentRequest(new BigDecimal("100"));

        Assertions.assertThat(request.getAmount()).isEqualTo(new BigDecimal("100"));
    }
}