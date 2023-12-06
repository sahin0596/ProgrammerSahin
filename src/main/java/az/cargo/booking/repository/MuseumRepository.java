package az.cargo.booking.repository;

import az.cargo.booking.domain.Museums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuseumRepository extends JpaRepository<Museums,Long> {
}
