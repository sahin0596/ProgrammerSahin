package az.cargo.booking.service.serviceimpl;

import az.cargo.booking.domain.Museums;

import java.util.List;
import java.util.Optional;

public interface MuseumServiceImpl {
    List<Museums> getAllMuseums();

    Optional<Museums> getMuseumById(Long id);

    Museums saveMuseum(Museums museum);

    void deleteMuseum(Long id);

}
