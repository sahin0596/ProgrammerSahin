package az.cargo.booking.service.serviceimpl;

import az.cargo.booking.domain.Payment;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PaymentServiceImpl {
    Payment createPayment(Payment payment);

    Payment getPaymentById(Long paymentId);

    List<Payment> getAllPayments();

    void deletePayment(Long paymentId);
}
