package az.cargo.booking.service.serviceimpl;


import az.cargo.booking.domain.Booking;
import az.cargo.booking.dto.request.BookingRequest;
import az.cargo.booking.dto.response.BookingResponse;

import java.util.List;

public interface BookingServiceImp {


    Booking createBooking(Booking booking);

    List<Booking> getAllBookings();

    Booking getBookingById(Long bookingId);

    void deleteBooking(Long bookingId);
}
