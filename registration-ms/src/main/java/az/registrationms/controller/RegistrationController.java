package az.registrationms.controller;

import az.registrationms.entity.Registration;
import az.registrationms.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody Registration user) {
        return registrationService.saveUser(user);
    }

    @RequestMapping(value = "/confirm-account", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<?> confirmAccount(@RequestParam("token") String confirmationToken) {
        return registrationService.confirmUserEmail(confirmationToken);
    }
}
