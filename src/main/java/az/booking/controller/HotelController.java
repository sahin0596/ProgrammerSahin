package az.booking.controller;

import az.booking.domain.Hotel;
import az.booking.dto.request.HotelRequest;
import az.booking.dto.response.HotelResponse;
import az.booking.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<HotelResponse>> findAll() {
        return new ResponseEntity<>(hotelService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(hotelService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/createHotel")
    public ResponseEntity<HotelResponse> save(@RequestBody HotelRequest hotelRequest){
        return new ResponseEntity<>(hotelService.save(hotelRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> update(@PathVariable Long id, @RequestBody HotelRequest hotelRequest){
        return new ResponseEntity<>(hotelService.update(id, hotelRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        hotelService.delete(id);
    }
}
