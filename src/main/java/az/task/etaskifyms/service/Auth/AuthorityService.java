package az.task.etaskifyms.service.Auth;

import az.task.etaskifyms.entity.authority.Authority;
import az.task.etaskifyms.entity.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorityService {
    List<Authority> getAllAuthorities();

    Authority getAuthorityById(Long id);

    Authority createAuthority(Authority authority);

    Authority updateAuthority(Long id, Authority authority);

    void deleteAuthority(Long id);

    User findUser(String email);
}
