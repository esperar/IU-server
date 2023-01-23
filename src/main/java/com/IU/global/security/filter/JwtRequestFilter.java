package com.IU.global.security.filter;

import com.IU.global.exception.TokenNotValidException;
import com.IU.global.security.jwt.JwtTokenProvider;
import com.IU.global.security.jwt.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {

    private final JwtTokenProvider tokenProvider;
    private final JwtProperties jwtProperties;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String accessToken = request.getHeader("Authorization");

        if (!Objects.isNull(accessToken)) {
            tokenProvider.extractAllClaims(accessToken, jwtProperties.getAccessKey());

            if (!tokenProvider.getTokenType(accessToken, jwtProperties.getAccessKey()).equals("ACCESS_TOKEN"))
                throw TokenNotValidException.EXCEPTION;

            String email = tokenProvider.getUserEmail(accessToken, jwtProperties.getAccessKey());
            registerSecurityContext(request, email);
        }

        filterChain.doFilter(request, response);
    }

    private void registerSecurityContext(HttpServletRequest request, String email) {
        UsernamePasswordAuthenticationToken authenticationToken = tokenProvider.authentication(email);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }
}
