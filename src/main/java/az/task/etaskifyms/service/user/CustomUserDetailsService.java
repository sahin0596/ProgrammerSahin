package az.task.etaskifyms.service.user;


import az.task.etaskifyms.entity.user.User;
import az.task.etaskifyms.security.UserPrincipal;
import az.task.etaskifyms.service.Auth.AuthorityService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;


@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    private  final AuthorityService authService;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Implement logic to load user details from your data source (e.g., database)
        // You may use Spring Data JPA or any other method to fetch user details.

        // Example: replace the following line with your actual logic
        throw new UsernameNotFoundException("User not found with username: " + username);
    }

    @Lazy
    public CustomUserDetailsService(@Qualifier("authorityServiceImpl") AuthorityService authService){
        this.authService =authService;
    }

    public UserDetails loadByUsername(String email) {
        User user = authService.findUser(email);
        return UserPrincipal.create(user);
    }}
