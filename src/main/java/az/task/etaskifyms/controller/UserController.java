package az.task.etaskifyms.controller;

import az.task.etaskifyms.dto.request.user.UserCreateRequestDto;
import az.task.etaskifyms.dto.request.user.UserRequestDto;
import az.task.etaskifyms.dto.response.UserCreateResponseDto;
import az.task.etaskifyms.dto.response.UserResponseDto;
import az.task.etaskifyms.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/new")
    public ResponseEntity<UserCreateResponseDto> create(@RequestBody UserCreateRequestDto dto) {
        return ResponseEntity.ok(userService.create(dto));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> get(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.get(userId));
    }

    @GetMapping("/{organizationId}")
    public ResponseEntity<List<UserResponseDto>> getAll(@PathVariable Long organizationId){
        return ResponseEntity.ok(userService.getAll(organizationId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponseDto> update(@PathVariable Long userId,
                                                  @RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.ok(userService.update(userId,userRequestDto));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<UserResponseDto> delete(@PathVariable Long userId){
        return ResponseEntity.ok(userService.delete(userId));
    }

}

