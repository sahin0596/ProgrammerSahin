package az.booking.repository.security;

import az.booking.domain.securityDomain.UserSecurity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserSecRepository extends JpaRepository<UserSecurity, Long>, JpaSpecificationExecutor<UserSecurity> {

    @EntityGraph(attributePaths = {"authorities"})
    Optional<UserSecurity> findByUsername(String username);

    UserSecurity findById(long id);
}
