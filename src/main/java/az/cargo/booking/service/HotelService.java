package az.cargo.booking.service;

import az.cargo.booking.domain.Hotel;
import az.cargo.booking.errors.ApplicationException;
import az.cargo.booking.errors.Errors;
import az.cargo.booking.repository.HotelRepository;
import az.cargo.booking.service.serviceimpl.HotelServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService implements HotelServiceImpl {

    private final HotelRepository hotelRepository;

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(Long hotelId) {
        return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ApplicationException(Errors.HOTEL_NOT_FOUND));
    }

    public void deleteHotel(Long hotelId) {
        if (!hotelRepository.existsById(hotelId)) {
            throw new ApplicationException(Errors.HOTEL_NOT_FOUND);
        }

        hotelRepository.deleteById(hotelId);
    }


}
