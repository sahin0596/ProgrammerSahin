package az.cargo.booking.service.serviceimpl;

import az.cargo.booking.domain.Hotel;

import java.util.List;

public interface HotelServiceImpl {
    Hotel createHotel(Hotel hotel);

    Hotel getHotelById(Long hotelId);

    List<Hotel> getAllHotels();

    void deleteHotel(Long hotelId);
}
