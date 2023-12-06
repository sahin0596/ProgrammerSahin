package az.cargo.booking.dto.response;

import az.cargo.booking.domain.Flight;
import az.cargo.booking.domain.Hotel;
import az.cargo.booking.domain.Museums;
import az.cargo.booking.domain.RentalCar;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingResponse {

    Long id;

    String bookingDate;

    Double totalCost;

    List<Flight> flights;

    List<Hotel> hotels;

    List<RentalCar> rentalCars;

    List<Museums> museums;

    PaymentResponse payment;
}
