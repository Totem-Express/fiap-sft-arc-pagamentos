package br.com.fiap.totem_express_payments.input;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import br.com.fiap.totem_express_payments.presentation.request.CreatePaymentRequest;

public class CreatePaymentInputTest {
    @Test
    public void should_create_dto_correctly() {
        final var request = new CreatePaymentRequest(BigDecimal.valueOf(1000));
        Assert.assertEquals(
                request.getAmount().toString(),
                "1000");
    }
}
