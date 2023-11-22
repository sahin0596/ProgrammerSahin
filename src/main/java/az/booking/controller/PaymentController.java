package az.booking.controller;

import az.booking.domain.Payment;
import az.booking.dto.request.PaymentRequest;
import az.booking.dto.response.PaymentResponse;
import az.booking.service.PaymentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;


    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentResponse> findById(@PathVariable Long paymentId){
        return new ResponseEntity<>(paymentService.findById(paymentId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PaymentResponse>> findAll(){
        return new ResponseEntity<>(paymentService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<PaymentResponse> save(@RequestBody PaymentRequest paymentRequest){
        return new ResponseEntity<>(paymentService.save(paymentRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{paymentId}")
    public ResponseEntity<Payment> update(@RequestBody PaymentRequest paymentRequest, @PathVariable Long paymentId){
        return new ResponseEntity<>(paymentService.update(paymentRequest, paymentId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{paymentId}")
    public void delete (@PathVariable Long paymentId){
        paymentService.delete(paymentId);
    }
}
