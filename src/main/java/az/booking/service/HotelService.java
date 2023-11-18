package az.booking.service;

import az.booking.domain.Hotel;
import az.booking.dto.request.HotelRequest;
import az.booking.dto.response.HotelResponse;

import java.util.List;

public interface HotelService {

    HotelResponse findById(Long id);

    List<HotelResponse> findAll();

    HotelResponse save(HotelRequest hotelRequest);

    Hotel update(Long id, HotelRequest hotelRequest);

    void delete(Long id);
}
