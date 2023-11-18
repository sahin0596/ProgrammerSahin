package az.booking.service.impl;

import az.booking.domain.Hotel;
import az.booking.dto.request.HotelRequest;
import az.booking.dto.response.HotelResponse;
import az.booking.errors.ApplicationException;
import az.booking.errors.Errors;
import az.booking.repository.HotelRepository;
import az.booking.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    private final ModelMapper modelMapper;

    @Override
    public HotelResponse findById(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new ApplicationException(Errors.HOTEL_NOT_FOUND));
        return modelMapper.map(hotel, HotelResponse.class);
    }

    @Override
    public List<HotelResponse> findAll() {
        return hotelRepository
                .findAll()
                .stream()
                .map(hotel -> modelMapper.map(hotel, HotelResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public HotelResponse save(HotelRequest hotelRequest) {
        Hotel hotel = modelMapper.map(hotelRequest, Hotel.class);
        return modelMapper.map(hotelRepository.save(hotel), HotelResponse.class);
    }

    @Override
    public Hotel update(Long id, HotelRequest hotelRequest) {
        hotelRepository.findById(id).orElseThrow(() -> new ApplicationException(Errors.HOTEL_NOT_FOUND));
        Hotel responseHotel = modelMapper.map(hotelRequest, Hotel.class);
        responseHotel.setId(id);
        return modelMapper.map(hotelRepository.save(responseHotel), Hotel.class);
    }

    @Override
    public void delete(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new ApplicationException(Errors.HOTEL_NOT_FOUND));
        hotelRepository.delete(hotel);
    }
}
