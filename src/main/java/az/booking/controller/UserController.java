package az.booking.controller;

import az.booking.dto.request.UserRequest;
import az.booking.dto.response.UserResponse;
import az.booking.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/booking")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        return new ResponseEntity<>(userServiceImpl.findAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userServiceImpl.save(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        return new ResponseEntity<>(userServiceImpl.findById(id), HttpStatus.OK);
    }

    @PutMapping("/put")
    public ResponseEntity<UserResponse> update(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userServiceImpl.update(userRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> delete(@PathVariable Long id) {
        return new ResponseEntity<>(userServiceImpl.delete(id), HttpStatus.GONE);
    }
}
