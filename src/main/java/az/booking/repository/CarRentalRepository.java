package az.booking.repository;

import az.booking.domain.RentalCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRentalRepository extends JpaRepository<RentalCar, Long> {
}
