package az.cargo.booking.repository;

import az.cargo.booking.registration.ConfirmationToken;
import az.cargo.booking.registration.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TokenRepository extends JpaRepository<ConfirmationToken,Long> {
    ConfirmationToken findByConfirmationToken(String confirmationToken);
}
