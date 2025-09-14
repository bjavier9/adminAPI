package com.insurance.api.domain.service;

import com.insurance.api.domain.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class ServicioAutenticacionImpl implements ServicioAutenticacion {

    private final JwtEncoder encoder;
    private final UserDetailsService userDetailsService;

    public ServicioAutenticacionImpl(JwtEncoder encoder, UserDetailsService userDetailsService) {
        this.encoder = encoder;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public String login(Usuario usuario) {
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(usuario.getUsername());
            Instant now = Instant.now();
            long expiry = 36000L;
            String scope = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.joining(" "));
            JwtClaimsSet claims = JwtClaimsSet.builder()
                    .issuer("self")
                    .issuedAt(now)
                    .expiresAt(now.plusSeconds(expiry))
                    .subject(userDetails.getUsername())
                    .claim("scope", scope)
                    .build();
            return this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        } catch (UsernameNotFoundException e) {
            throw new CredencialesInvalidasException("Usuario o contraseña incorrectos");
        }
    }
}
