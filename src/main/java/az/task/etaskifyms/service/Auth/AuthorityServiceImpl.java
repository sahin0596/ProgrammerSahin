package az.task.etaskifyms.service.Auth;

import az.task.etaskifyms.entity.authority.Authority;
import az.task.etaskifyms.entity.authority.UserAuthority;
import az.task.etaskifyms.entity.user.User;
import az.task.etaskifyms.repository.AuthorRepository;
import az.task.etaskifyms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class AuthorityServiceImpl implements AuthorityService {

    private final  AuthorRepository authorityRepository;
    private final UserRepository userRepository;

    @Override
    public List<Authority> getAllAuthorities() {
        return authorityRepository.findAll();
    }

    @Override
    public Authority getAuthorityById(Long id) {
        return authorityRepository.findById(id).orElse(null);
    }

    @Override
    public Authority createAuthority(Authority authority) {
        return authorityRepository.save(authority);
    }

    @Override
    public Authority updateAuthority(Long id, Authority updatedAuthority) {
        Authority existingAuthority = getAuthorityById(id);
        if (existingAuthority != null) {
            existingAuthority.setAuthority(UserAuthority.valueOf(updatedAuthority.getAuthority()));
            // You can update other fields here if needed
            return authorityRepository.save(existingAuthority);
        }
        return null;
    }

    @Override
    public void deleteAuthority(Long id) {
        authorityRepository.deleteById(id);
    }

    @Override
    public User findUser(String email) {
        return userRepository.findByEmail(email);
    }
}
