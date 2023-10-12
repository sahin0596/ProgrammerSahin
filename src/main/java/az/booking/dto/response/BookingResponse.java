package az.booking.dto.response;

import az.booking.domain.Flight;
import az.booking.domain.Hotel;
import az.booking.domain.Payment;
import az.booking.domain.RentalCar;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingResponse {

    Long id;

    String bookingDate;

    Double totalCost;

    List<Flight> flights;

    List<RentalCar> rentalCars;

    List<Hotel> hotels;

    PaymentResponse payment;


}
