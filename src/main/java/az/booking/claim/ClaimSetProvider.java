package az.booking.claim;

import org.springframework.security.core.Authentication;

public interface ClaimSetProvider {

    ClaimSet provide(Authentication authentication);
}
