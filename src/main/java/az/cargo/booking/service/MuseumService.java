package az.cargo.booking.service;

import az.cargo.booking.domain.Museums;
import az.cargo.booking.repository.MuseumRepository;
import az.cargo.booking.service.serviceimpl.MuseumServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MuseumService implements MuseumServiceImpl {

    private final MuseumRepository museumsRepository;

    public List<Museums> getAllMuseums() {
        return museumsRepository.findAll();
    }

    public Optional<Museums> getMuseumById(Long id) {
        return museumsRepository.findById(id);
    }

    public Museums saveMuseum(Museums museum) {
        return museumsRepository.save(museum);
    }

    public void deleteMuseum(Long id) {
        museumsRepository.deleteById(id);
    }
}


