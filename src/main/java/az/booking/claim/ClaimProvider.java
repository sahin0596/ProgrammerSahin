package az.booking.claim;

import org.springframework.security.core.Authentication;

public interface ClaimProvider {

    Claim provide(Authentication authentication);
}
