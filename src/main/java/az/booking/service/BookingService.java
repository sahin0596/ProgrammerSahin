package az.booking.service;

import az.booking.domain.Booking;
import az.booking.dto.request.BookingRequest;
import az.booking.dto.response.BookingResponse;
import org.springframework.http.HttpStatusCode;

import java.awt.print.Book;
import java.util.List;

public interface BookingService {

   BookingResponse findById(Long id);

   List<BookingResponse> findAll();

   List<BookingResponse> save(Long userId, Long paymentId, BookingRequest bookingRequest);

   void delete(Long id);

    Booking update(Long id, Long paymentId, Long userId, BookingRequest bookingRequest);
}
