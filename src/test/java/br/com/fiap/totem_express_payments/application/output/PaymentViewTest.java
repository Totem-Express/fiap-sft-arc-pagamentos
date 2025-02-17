package br.com.fiap.totem_express_payments.application.output;

import br.com.fiap.totem_express_payments.domain.Status;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentViewTest {

    @Test
    void should_create_correctly_a_dto(){
        final var view = new PaymentView.SimpleView(1L, Status.FAILED, "");
        Assertions.assertThat(view.status().toString()).isEqualTo( "FAILED");
    }
}