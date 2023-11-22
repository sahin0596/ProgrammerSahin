package az.registrationms.service;

import az.registrationms.entity.Registration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface RegistrationService {

    ResponseEntity<?> saveUser(Registration user);

    ResponseEntity<?> confirmUserEmail(String confirmationToken);
}
