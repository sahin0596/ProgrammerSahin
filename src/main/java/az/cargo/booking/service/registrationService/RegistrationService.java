package az.cargo.booking.service.registrationService;


import az.cargo.booking.registration.Registration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface RegistrationService {

    ResponseEntity<?> saveUser(Registration user);

    ResponseEntity<?> confirmUserEmail(String confirmationToken);
}