package az.booking.service;

import az.booking.domain.Payment;
import az.booking.dto.request.PaymentRequest;
import az.booking.dto.response.PaymentResponse;

import java.util.List;

public interface PaymentService {

    PaymentResponse findById(Long paymentId);

    List<PaymentResponse> findAll();

    PaymentResponse save(PaymentRequest paymentRequest);

    Payment update(PaymentRequest paymentRequest, Long paymentId);

    void delete(Long paymentId);
}
