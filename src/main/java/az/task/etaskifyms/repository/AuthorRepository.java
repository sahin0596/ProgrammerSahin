package az.task.etaskifyms.repository;

import az.task.etaskifyms.entity.authority.Authority;
import az.task.etaskifyms.entity.authority.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Authority,Long> {
    Optional<Authority> findByAuthority(UserAuthority userAuthority);
}