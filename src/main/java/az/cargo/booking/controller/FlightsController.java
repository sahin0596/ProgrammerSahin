package az.cargo.booking.controller;

import az.cargo.booking.domain.Flight;
import az.cargo.booking.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/f1")
@RequiredArgsConstructor
public class FlightsController {
    private final FlightService flightService;

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        Flight createdFlight = flightService.createFlight(flight);
        return new ResponseEntity<>(createdFlight, HttpStatus.CREATED);
    }

    @PutMapping("/{flightId}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long flightId, @RequestBody Flight updatedFlight) {
        Flight existingFlight = flightService.getFlightById(flightId);

        existingFlight.setFlightNumber(updatedFlight.getFlightNumber());
        existingFlight.setDepartureAirport(updatedFlight.getDepartureAirport());
        existingFlight.setArrivalAirport(updatedFlight.getArrivalAirport());
        existingFlight.setDepartureTime(updatedFlight.getDepartureTime());
        existingFlight.setArrivalTime(updatedFlight.getArrivalTime());
        existingFlight.setAirline(updatedFlight.getAirline());

        Flight savedFlight = flightService.createFlight(existingFlight);
        return new ResponseEntity<>(savedFlight, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = flightService.getAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long flightId) {
        Flight flight = flightService.getFlightById(flightId);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @DeleteMapping("/{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long flightId) {
        flightService.deleteFlight(flightId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

}

}
