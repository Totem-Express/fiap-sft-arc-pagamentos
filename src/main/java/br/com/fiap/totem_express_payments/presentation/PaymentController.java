package br.com.fiap.totem_express_payments.presentation;

import br.com.fiap.totem_express_payments.application.*;
import br.com.fiap.totem_express_payments.application.output.PaymentView;
import br.com.fiap.totem_express_payments.domain.Payment;
import br.com.fiap.totem_express_payments.presentation.request.PaymentWebhookRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController implements PaymentDocumentation {

    private final CheckPaymentStatusUseCase checkPaymentStatusUseCase;
    private final ProcessPaymentWebhookUseCase processPaymentWebhookUseCase;
    private final FindByIdUseCase findByIdUseCase;

    public PaymentController(CheckPaymentStatusUseCase checkPaymentStatusUseCase, ProcessPaymentWebhookUseCase processPaymentWebhookUseCase, FindByIdUseCase findByIdUseCase) {
        this.checkPaymentStatusUseCase = checkPaymentStatusUseCase;
        this.processPaymentWebhookUseCase = processPaymentWebhookUseCase;
        this.findByIdUseCase = findByIdUseCase;
    }

//    fiquei na dúvida sobre qual retonar
    @Override
    @GetMapping("/api/payment/{id}")
    public ResponseEntity<PaymentView> checkPaymentStatus(@PathVariable Long id) {
        PaymentView check = checkPaymentStatusUseCase.checkStatus(id);
        return ResponseEntity.ok(check);
    }

    //    fiquei na dúvida sobre qual retonar
    @Override
    @GetMapping("/api/payment/{id}")
    public ResponseEntity<Payment> findBy(@PathVariable String id) {
        return findByIdUseCase.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    @Transactional
    @PostMapping("/api/payment/process/{id}")
    public ResponseEntity<Void> processPayment(Long id, @RequestBody @Valid PaymentWebhookRequest input) {
        processPaymentWebhookUseCase.process(id, input);
        return ResponseEntity.ok().build();
    }
}
