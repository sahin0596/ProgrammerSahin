package az.cargo.booking.controller;

import az.cargo.booking.domain.RentalCar;
import az.cargo.booking.service.RentalCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/c1")
public class RentalCarController {
    private final RentalCarService rentalCarService;

    @PostMapping
    public ResponseEntity<RentalCar> createRentalCar(@RequestBody RentalCar rentalCar) {
        RentalCar createdRentalCar = rentalCarService.createRentalCar(rentalCar);
        return new ResponseEntity<>(createdRentalCar, HttpStatus.CREATED);
    }

    @PutMapping("/{rentalCarId}")
    public ResponseEntity<RentalCar> updateRentalCar(@PathVariable Long rentalCarId, @RequestBody RentalCar updatedRentalCar) {
        RentalCar existingRentalCar = rentalCarService.getRentalCarById(rentalCarId);
        existingRentalCar.setRentalCompany(updatedRentalCar.getRentalCompany());
        existingRentalCar.setCarModel(updatedRentalCar.getCarModel());
        existingRentalCar.setRentalPeriod(updatedRentalCar.getRentalPeriod());
        existingRentalCar.setPickUpLocation(updatedRentalCar.getPickUpLocation());

        RentalCar savedRentalCar = rentalCarService.createRentalCar(existingRentalCar);
        return new ResponseEntity<>(savedRentalCar, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RentalCar>> getAllRentalCars() {
        List<RentalCar> rentalCars = rentalCarService.getAllRentalCars();
        return new ResponseEntity<>(rentalCars, HttpStatus.OK);
    }

    @GetMapping("/{rentalCarId}")
    public ResponseEntity<RentalCar> getRentalCarById(@PathVariable Long rentalCarId) {
        RentalCar rentalCar = rentalCarService.getRentalCarById(rentalCarId);
        return new ResponseEntity<>(rentalCar, HttpStatus.OK);
    }

    @DeleteMapping("/{rentalCarId}")
    public ResponseEntity<Void> deleteRentalCar(@PathVariable Long rentalCarId) {
        rentalCarService.deleteRentalCar(rentalCarId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
