package az.cargo.booking.service;

import az.cargo.booking.domain.Flight;
import az.cargo.booking.repository.FlightRepository;
import az.cargo.booking.service.serviceimpl.FlightServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService implements FlightServiceImpl {

    private final FlightRepository flightRepository;


    public Flight createFlight(Flight flight) {

        return flightRepository.save(flight);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long flightId) {
        return flightRepository.findById(flightId)
                .orElseThrow(() -> new EntityNotFoundException("Flight not found with id: " + flightId));
    }

    public void deleteFlight(Long flightId) {
        if (!flightRepository.existsById(flightId)) {
            throw new EntityNotFoundException("Flight not found with id: " + flightId);
        }

        flightRepository.deleteById(flightId);
    }


}
