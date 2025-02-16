package br.com.fiap.totem_express_payments.presentation.errors;

import java.util.List;

public record BadRequestError(List<FieldError> errors) {
}
