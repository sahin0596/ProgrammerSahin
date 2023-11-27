package az.cargo.booking.controller;

import az.cargo.booking.domain.Payment;
import az.cargo.booking.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/p1")
public class PaymentController {

    private final PaymentService paymentService;
    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment createdPayment = paymentService.createPayment(payment);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }

    @PutMapping("/{paymentId}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long paymentId, @RequestBody Payment updatedPayment) {
        Payment existingPayment = paymentService.getPaymentById(paymentId);


        existingPayment.setPaymentAmount(updatedPayment.getPaymentAmount());
        existingPayment.setPaymentMethod(updatedPayment.getPaymentMethod());
        existingPayment.setPaymentDate(updatedPayment.getPaymentDate());

        Payment savedPayment = paymentService.createPayment(existingPayment);
        return new ResponseEntity<>(savedPayment, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long paymentId) {
        Payment payment = paymentService.getPaymentById(paymentId);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }
    @DeleteMapping("/{paymentId}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long paymentId) {
        paymentService.deletePayment(paymentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}


