package az.cargo.booking.service;

import az.cargo.booking.domain.Booking;
import az.cargo.booking.errors.ApplicationException;
import az.cargo.booking.errors.Errors;
import az.cargo.booking.repository.BookingRepository;
import az.cargo.booking.service.serviceimpl.BookingServiceImp;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class BookingService implements BookingServiceImp {

    private final BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ApplicationException(Errors.BOOKING_NOT_FOUND));
    }

    public void deleteBooking(Long bookingId) {
        if (!bookingRepository.existsById(bookingId)) {
            throw new EntityNotFoundException("Booking not found with id: " + bookingId);
        }

        bookingRepository.deleteById(bookingId);
    }

}
