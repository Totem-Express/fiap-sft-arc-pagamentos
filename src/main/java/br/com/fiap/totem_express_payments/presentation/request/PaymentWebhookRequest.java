package br.com.fiap.totem_express_payments.presentation.request;

import br.com.fiap.totem_express_payments.application.input.PaymentWebhookInput;
import br.com.fiap.totem_express_payments.domain.Status;
import jakarta.validation.constraints.NotNull;

public record PaymentWebhookRequest(@NotNull Long id,
                                    @NotNull Status status)
        implements PaymentWebhookInput {
}
