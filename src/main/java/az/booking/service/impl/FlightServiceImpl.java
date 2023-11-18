package az.booking.service.impl;

import az.booking.domain.Flight;
import az.booking.dto.request.FlightRequest;
import az.booking.dto.response.FlightResponse;
import az.booking.errors.ApplicationException;
import az.booking.errors.Errors;
import az.booking.repository.FlightRepository;
import az.booking.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    private final ModelMapper modelMapper;

    @Override
    public FlightResponse findById(Long id) {
        Flight flight = flightRepository.findById(id).orElseThrow(() ->
                new ApplicationException(Errors.FLIGHT_NOT_FOUND));
        return modelMapper.map(flight, FlightResponse.class);
    }

    @Override
    public List<FlightResponse> findAll() {
        return flightRepository
                .findAll()
                .stream()
                .map(flight -> modelMapper.map(flight, FlightResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public FlightResponse save(FlightRequest flightRequest) {
        Flight flight = modelMapper.map(flightRequest, Flight.class);
        return modelMapper.map(flightRepository.save(flight), FlightResponse.class);
    }

    @Override
    public Flight update(Long id, FlightRequest flightRequest) {
        flightRepository.findById(id).orElseThrow(() -> new ApplicationException(Errors.FLIGHT_NOT_FOUND));
        Flight responseFlight = modelMapper.map(flightRequest, Flight.class);
        responseFlight.setId(id);
        return modelMapper.map(flightRepository.save(responseFlight), Flight.class);
    }

    @Override
    public void delete(Long id) {
        Flight flight = flightRepository.findById(id).orElseThrow(() ->
                new ApplicationException(Errors.FLIGHT_NOT_FOUND));
        flightRepository.delete(flight);
    }
}
