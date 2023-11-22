package az.registrationms.repository;

import az.registrationms.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RegistrationRepository extends JpaRepository<Registration, UUID> {

    Boolean existsByUserEmail(String userEmail);

    Registration findByUserEmailIgnoreCase(String emailId);
}
