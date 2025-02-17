package br.com.fiap.totem_express_payments.output;

import org.junit.Assert;
import org.junit.Test;

import br.com.fiap.totem_express_payments.application.output.PaymentView.FullPaymentView;

public class PaymentViewTest {

    @Test
    public void should_create_dto_correctly() {
        final var view = new FullPaymentView(1L, null, null, null, null, null);
        Assert.assertEquals(1L, view.id(), 0.01);
    }
}
