package az.booking.dto.response;

import az.booking.domain.Booking;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlightResponse {

    Long id;

    String flightNumber;

    String departureAirport;

    String arrivalAirport;

    String departureTime;

    String arrivalTime;

    String airline;

    Double price;

    Booking booking;

}
