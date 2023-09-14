package az.org.organization.Controller;

import az.org.organization.Dto.UserRequest;
import az.org.organization.Dto.UserResponse;
import az.org.organization.Service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/t1/api1")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("/read2")
    public List<UserResponse> findAll() {
        return userService.findAll();
    }

    @PostMapping("/create2")
    public void create1(@RequestBody UserRequest userRequest) {
        userService.CreateUser(userRequest);
    }

    @GetMapping("/{id}")
    public UserResponse getUserId(@PathVariable Long id) {
        return userService.getUserId(id);
    }

    @PutMapping("/{id}")
    public void update1(@PathVariable Long id,@RequestBody UserRequest userRequest){
        userService.update1(id,userRequest);
    }
    @DeleteMapping("/{id}")
    public void delete1(@PathVariable Long id){
        userService.delete1(id);
    }
}
