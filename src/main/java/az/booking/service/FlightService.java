package az.booking.service;

import az.booking.domain.Flight;
import az.booking.dto.request.FlightRequest;
import az.booking.dto.response.FlightResponse;

import java.util.List;

public interface FlightService {

    FlightResponse findById(Long id);

    List<FlightResponse> findAll();

    FlightResponse save(FlightRequest flightRequest);

    Flight update(Long id, FlightRequest flightRequest);

    void delete(Long id);
}
