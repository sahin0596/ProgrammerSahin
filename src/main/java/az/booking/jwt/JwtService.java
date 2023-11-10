package az.booking.jwt;

import az.booking.claim.Claim;
import az.booking.claim.ClaimProvider;
import az.booking.claim.ClaimSet;
import az.booking.claim.ClaimSetProvider;
import az.booking.config.securityConfig.SecurityProperties;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtService {

    private final Set<ClaimProvider> claimProviders;

    private final Set<ClaimSetProvider> claimSetProviders;

    private final SecurityProperties securityProperties;

    private Key key;

    public Claim parseToken(String token) {
        return (Claim) Jwts.parser();
    }

    public String issueToken(Authentication authentication, Duration duration){
        log.info("Issue JWT token for to {} for {}", authentication, duration );
        final JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject(authentication.getName())
                .setIssuedAt(new Date())
                .setExpiration(Date.from(Instant.now().plus
                        (Duration.ofSeconds(securityProperties.getJwtProperties().getTokenValidityInSeconds()))))
                .setHeader(Map.of("type", "JWT"))
                .signWith(SignatureAlgorithm.HS512, key);
        addClaims(jwtBuilder, authentication);
        addClaimsSet(jwtBuilder, authentication);
        return jwtBuilder.compact();

    }

    private JwtBuilder addClaims(JwtBuilder jwtBuilder, Authentication authentication){
        claimProviders.forEach(claimProvider -> {
            Claim claim = claimProvider.provide(authentication);
            log.info("Adding claim {}", claim);
            jwtBuilder.claim(claim.getKey(), claim.getClaim());
        });
        return jwtBuilder;
    }

    private JwtBuilder addClaimsSet(JwtBuilder jwtBuilder, Authentication authentication){
        claimSetProviders.forEach(claimProviderSet -> {
            ClaimSet claimSet = claimProviderSet.provide(authentication);
            log.info("Adding claim set {}", claimSet);
            jwtBuilder.claim(claimSet.getKey(), claimSet.getClaim());
        });
        return jwtBuilder;
    }

}
