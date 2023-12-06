package az.cargo.booking.repository;

import az.cargo.booking.domain.RentalCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalCarRepository extends JpaRepository<RentalCar,Long> {
}
