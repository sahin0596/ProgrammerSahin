package az.cargo.booking.service.serviceimpl;

import az.cargo.booking.domain.RentalCar;

import java.util.List;

public interface RentalCarServiceImpl {
    RentalCar createRentalCar(RentalCar rentalCar);

    RentalCar getRentalCarById(Long rentalCarId);

    List<RentalCar> getAllRentalCars();

    void deleteRentalCar(Long rentalCarId);
}
