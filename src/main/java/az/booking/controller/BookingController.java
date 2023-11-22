package az.booking.controller;

import az.booking.domain.Booking;
import az.booking.dto.request.BookingRequest;
import az.booking.dto.response.BookingResponse;
import az.booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;


    @GetMapping("/{id}")
    public ResponseEntity<BookingResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(bookingService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BookingResponse>> findAll() {
       return new ResponseEntity<>(bookingService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/payments/{paymentId}/users/{userId}")
    public ResponseEntity<List<BookingResponse>> save(@PathVariable Long userId,
                                                @PathVariable Long paymentId,
                                                @RequestBody BookingRequest bookingRequest){
        return new ResponseEntity<>(bookingService.save(userId, paymentId, bookingRequest), HttpStatus.CREATED);
    }

    @PutMapping("/bookings/{id}/payments/{paymentId}/users/{userId}")
    public ResponseEntity<Booking> update(@PathVariable Long id,
                                          @PathVariable Long paymentId,
                                          @PathVariable Long userId,
                                          @RequestBody BookingRequest bookingRequest) {
        return new ResponseEntity<>(bookingService.update(id, paymentId, userId, bookingRequest), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        bookingService.delete(id);
    }
}
