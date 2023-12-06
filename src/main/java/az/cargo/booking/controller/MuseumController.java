package az.cargo.booking.controller;

import az.cargo.booking.domain.Museums;
import az.cargo.booking.service.MuseumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MuseumController {

    private final MuseumService museumsService;
        @GetMapping
        public List<Museums> getAllMuseums() {
            return museumsService.getAllMuseums();
        }

        @GetMapping("/{id}")
        public Museums getMuseumById(@PathVariable Long id) {
            return museumsService.getMuseumById(id).orElse(null);
        }

        @PostMapping
        public Museums saveMuseum(@RequestBody Museums museum) {
            return museumsService.saveMuseum(museum);
        }

        @DeleteMapping("/{id}")
        public void deleteMuseum(@PathVariable Long id) {
            museumsService.deleteMuseum(id);
        }
    }


