package az.cargo.booking.controller;
import az.cargo.booking.dto.request.UserRequest;
import az.cargo.booking.dto.response.UserResponse;
import az.cargo.booking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/u1")

public class UserController {
    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserResponse>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.save(userRequest), HttpStatus.CREATED);

    }

    @GetMapping("{userId}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long userId) {
        return new ResponseEntity<>(userService.findById(userId), HttpStatus.OK);
    }

    @PutMapping("{userId}")
    public ResponseEntity<UserResponse> update(@PathVariable Long userId, @RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.update(userId, userRequest), HttpStatus.OK);
    }

    @DeleteMapping("{userId}")
    public void delete1(@PathVariable Long userId) {
        userService.delete(userId);
    }
}
