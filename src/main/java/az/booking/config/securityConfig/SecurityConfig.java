package az.booking.config.securityConfig;

import az.booking.domain.UserRole;
import lombok.SneakyThrows;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;

import java.util.List;

@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)
public class SecurityConfig implements ApplicationSecurityConfig {

    @Override
    @SneakyThrows
    public void configure(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry
                                  requestMatcherRegistry) {

        configurePublicOperations(requestMatcherRegistry);

        configureUserOperations(requestMatcherRegistry);

        configureStaffOperations(requestMatcherRegistry);

        configureAdminOperations(requestMatcherRegistry);

    }

    @SneakyThrows
    private void configurePublicOperations(AuthorizeHttpRequestsConfigurer<HttpSecurity>
                                                   .AuthorizationManagerRequestMatcherRegistry http) {
        http
                .requestMatchers(HttpMethod.GET, "/api/bookings").permitAll();


    }

    private void configureUserOperations(AuthorizeHttpRequestsConfigurer<HttpSecurity>
                                                 .AuthorizationManagerRequestMatcherRegistry http) {
        http.requestMatchers(HttpMethod.GET, "api/booking/{id}").authenticated();

    }

    private void configureStaffOperations(AuthorizeHttpRequestsConfigurer<HttpSecurity>
                                                  .AuthorizationManagerRequestMatcherRegistry http) {
        http.requestMatchers(HttpMethod.GET, "api/booking/{id}").authenticated();

    }

    private void configureAdminOperations(AuthorizeHttpRequestsConfigurer<HttpSecurity>
                                                  .AuthorizationManagerRequestMatcherRegistry http) {
        http.requestMatchers(HttpMethod.GET, "api/booking/{id}").authenticated();

    }

    private String admin() {
        return UserRole.ROLE_ADMIN.name();
    }

    private String[] adminOrStaff() {
        return List.of(UserRole.ROLE_ADMIN.name(), UserRole.ROLE_STAFF.name()).toArray(new String[0]);
    }

    private String[] adminOrUser() {
        return List.of(UserRole.ROLE_ADMIN.name(), UserRole.ROLE_USER.name()).toArray(new String[0]);
    }
}
