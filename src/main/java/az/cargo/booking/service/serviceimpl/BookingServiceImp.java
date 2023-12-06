package az.cargo.booking.service.serviceimpl;


import az.cargo.booking.domain.Booking;

import java.util.List;

public interface BookingServiceImp {


    Booking createBooking(Booking booking);

    List<Booking> getAllBookings();

    Booking getBookingById(Long bookingId);

    void deleteBooking(Long bookingId);
}
