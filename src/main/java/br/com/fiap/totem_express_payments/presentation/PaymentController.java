package br.com.fiap.totem_express_payments.presentation;

import br.com.fiap.totem_express_payments.application.CheckPaymentStatusUseCase;
import br.com.fiap.totem_express_payments.application.CreatePaymentUseCase;
import br.com.fiap.totem_express_payments.application.ProcessPaymentWebhookUseCase;
import br.com.fiap.totem_express_payments.application.output.PaymentView;
import br.com.fiap.totem_express_payments.presentation.request.CreatePaymentRequest;
import br.com.fiap.totem_express_payments.presentation.request.PaymentWebhookRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController implements PaymentDocumentation {

    private final CreatePaymentUseCase createPaymentUseCase;
    private final CheckPaymentStatusUseCase checkPaymentStatusUseCase;
    private final ProcessPaymentWebhookUseCase processPaymentWebhookUseCase;

    public PaymentController(CreatePaymentUseCase createPaymentUseCase,
            CheckPaymentStatusUseCase checkPaymentStatusUseCase,
            ProcessPaymentWebhookUseCase processPaymentWebhookUseCase) {
        this.createPaymentUseCase = createPaymentUseCase;
        this.checkPaymentStatusUseCase = checkPaymentStatusUseCase;
        this.processPaymentWebhookUseCase = processPaymentWebhookUseCase;
    }

    @Override
    @GetMapping("/api/payment/{id}")
    public ResponseEntity<PaymentView> checkPaymentStatus(@PathVariable Long id) {
        PaymentView check = checkPaymentStatusUseCase.checkStatus(id);
        return ResponseEntity.ok(check);
    }

    @PostMapping("/api/create")
    @Transactional
    public ResponseEntity<PaymentView> handleCreatePayment(@RequestBody CreatePaymentRequest request) {
        final var response = createPaymentUseCase.execute(request);

        return ResponseEntity.ok(response);
    }

    @Override
    @Transactional
    @PostMapping("/api/payment/process/{id}")
    public ResponseEntity<Void> processPayment(Long id, @RequestBody @Valid PaymentWebhookRequest input) {
        processPaymentWebhookUseCase.process(id, input);
        return ResponseEntity.ok().build();
    }
}
