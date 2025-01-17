package progress_checker.progress_checker.auth_config;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String secret;

    // @Value("${jwt.expiration}")
    // private long expiration;

    @SuppressWarnings("deprecation")
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(8760)))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    @SuppressWarnings("deprecation")
    public Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                   .build()
                .parseSignedClaims(token)
                .getBody();
                // return Jwts.parser()
                // .verifyWith(secret)
                // .build()
                // .parseSignedClaims(token)
                // .getPayload();
    }

    public boolean isTokenValid(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            return !claims.getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        return getClaimsFromToken(token).getSubject();
    }
}
