package az.booking.repository;

import az.booking.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightResponse extends JpaRepository<Flight, Long> {
}
