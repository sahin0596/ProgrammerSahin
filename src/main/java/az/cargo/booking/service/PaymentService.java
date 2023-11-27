package az.cargo.booking.service;

import az.cargo.booking.domain.Payment;
import az.cargo.booking.repository.PaymentRepository;
import az.cargo.booking.service.serviceimpl.PaymentServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService implements PaymentServiceImpl {
    private final PaymentRepository paymentRepository;
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId)
                .orElseThrow(() -> new EntityNotFoundException("Payment not found with id: " + paymentId));
    }

    public void deletePayment(Long paymentId) {

        if (!paymentRepository.existsById(paymentId)) {
            throw new EntityNotFoundException("Payment not found with id: " + paymentId);
        }

        paymentRepository.deleteById(paymentId);
    }


}