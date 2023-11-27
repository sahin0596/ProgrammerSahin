package az.cargo.booking.service;

import az.cargo.booking.domain.Hotel;
import az.cargo.booking.repository.HotelRepository;
import az.cargo.booking.service.serviceimpl.HotelServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService implements HotelServiceImpl {

    private final HotelRepository hotelRepository;


    public Hotel createHotel(Hotel hotel) {
        // Add any business logic or validation before saving to the repository
        return hotelRepository.save(hotel);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(Long hotelId) {
        return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new EntityNotFoundException("Hotel not found with id: " + hotelId));
    }

    public void deleteHotel(Long hotelId) {
        // Check if hotel exists before attempting to delete
        if (!hotelRepository.existsById(hotelId)) {
            throw new EntityNotFoundException("Hotel not found with id: " + hotelId);
        }

        hotelRepository.deleteById(hotelId);
    }


}
