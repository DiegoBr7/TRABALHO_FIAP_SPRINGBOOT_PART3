package br.com.fiap.gerenciamento.security.service;

import br.com.fiap.gerenciamento.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    private static final String SECRET = "fiap";

    public String createToken(Usuario usuario) {

        Algorithm algorithm = Algorithm.HMAC256(SECRET);

        Instant expiresAt = LocalDateTime
                .now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));

        String token = JWT.create()
                .withIssuer("gerenciamento")
                .withSubject(usuario.getUsername())
                .withExpiresAt(expiresAt)
                .sign(algorithm);

        return token;
    }

    public String tokenValidate(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);

            return JWT.require(algorithm)
                    .withIssuer("gerenciamento")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTVerificationException e) {
            return "";
        }
    }
}