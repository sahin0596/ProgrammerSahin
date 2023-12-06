package az.cargo.booking.service;

import az.cargo.booking.domain.RentalCar;
import az.cargo.booking.repository.RentalCarRepository;
import az.cargo.booking.service.serviceimpl.RentalCarServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalCarService implements RentalCarServiceImpl {
    private final RentalCarRepository rentalCarRepository;


    public RentalCar createRentalCar(RentalCar rentalCar) {
        return rentalCarRepository.save(rentalCar);
    }

    public List<RentalCar> getAllRentalCars() {
        return rentalCarRepository.findAll();
    }

    public RentalCar getRentalCarById(Long rentalCarId) {
        return rentalCarRepository.findById(rentalCarId)
                .orElseThrow(() -> new EntityNotFoundException("RentalCar not found with id: " + rentalCarId));
    }

    public void deleteRentalCar(Long rentalCarId) {
        // Check if rental car exists before attempting to delete
        if (!rentalCarRepository.existsById(rentalCarId)) {
            throw new EntityNotFoundException("RentalCar not found with id: " + rentalCarId);
        }

        rentalCarRepository.deleteById(rentalCarId);
    }
}
