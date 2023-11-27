package az.cargo.booking.service.serviceimpl;

import az.cargo.booking.domain.Flight;

import java.util.List;

public interface FlightServiceImpl {
    Flight createFlight(Flight flight);

    Flight getFlightById(Long flightId);

    List<Flight> getAllFlights();

    void deleteFlight(Long flightId);
}
