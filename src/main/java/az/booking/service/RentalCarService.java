package az.booking.service;

import az.booking.domain.RentalCar;
import az.booking.dto.request.RentalCarRequest;
import az.booking.dto.response.RentalCarResponse;

import java.util.List;

public interface RentalCarService {

    List<RentalCarResponse> findAll();

    RentalCarResponse findById(Long id);

    RentalCarResponse save(RentalCarRequest carRequest);

    RentalCar update(Long id, RentalCarRequest carRequest);

    void delete(Long id);

}
