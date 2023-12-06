package az.cargo.booking.controller;

import az.cargo.booking.domain.Booking;
import az.cargo.booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/b1")
public class BookingController {

  private final BookingService bookingService;


  @PostMapping
  public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
    Booking createdBooking = bookingService.createBooking(booking);
    return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Booking>> getAllBookings() {
    List<Booking> bookings = bookingService.getAllBookings();
    return new ResponseEntity<>(bookings, HttpStatus.OK);
  }

  @GetMapping("/{bookingId}")
  public ResponseEntity<Booking> getBookingById(@PathVariable Long bookingId) {
    Booking booking = bookingService.getBookingById(bookingId);
    return new ResponseEntity<>(booking, HttpStatus.OK);
  }

  @DeleteMapping("/{bookingId}")
  public ResponseEntity<Void> deleteBooking(@PathVariable Long bookingId) {
    bookingService.deleteBooking(bookingId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }


}