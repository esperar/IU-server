package com.IU.domain.auth.service;

import com.IU.domain.auth.presentation.dto.response.TokenResponse;
import com.IU.domain.user.entity.User;
import com.IU.domain.user.entity.enum_type.Authority;
import com.IU.domain.user.repository.UserRepository;
import com.IU.global.security.AuthProperties;
import com.IU.global.security.jwt.JwtTokenProvider;
import com.IU.global.security.jwt.properties.JwtProperties;
import com.IU.infrastructure.feign.client.GoogleAuth;
import com.IU.infrastructure.feign.client.GoogleInfo;
import com.IU.infrastructure.feign.dto.request.GoogleCodeRequest;
import com.IU.infrastructure.feign.dto.response.GoogleInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class GoogleAuthService {

    private final GoogleAuth googleAuth;
    private final GoogleInfo googleInfo;
    private final AuthProperties authProperties;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;

    @Transactional
    public TokenResponse execute(String code) {
        String accessToken = googleAuth.googleAuth(
                GoogleCodeRequest.builder()
                        .code(URLDecoder.decode(code, StandardCharsets.UTF_8))
                        .clientId(authProperties.getClientId())
                        .clientSecret(authProperties.getClientSecret())
                        .redirectUri(authProperties.getRedirectUrl())
                        .build()
        ).getAccessToken();

        GoogleInfoResponse googleInfoResponse = googleInfo.googleInfo(accessToken);

        String email = googleInfoResponse.getEmail();
        String name = googleInfoResponse.getName();

        String refreshToken = jwtTokenProvider.generatedRefreshToken(email);

        createUser(email, name);
        return TokenResponse
                .builder()
                .accessToken(jwtTokenProvider.generatedAccessToken(email))
                .refreshToken(refreshToken)
                .expiredAt(jwtTokenProvider.getExpiredAtToken(accessToken, jwtProperties.getAccessKey()))
                .build();
    }

    private void createUser(String email, String name) {
        if (userRepository.findByEmail(email).isEmpty()) {
            userRepository.save(
                    User.builder()
                            .email(email)
                            .name(name)
                            .authority(Authority.USER)
                            .build());
        }
    }

}
