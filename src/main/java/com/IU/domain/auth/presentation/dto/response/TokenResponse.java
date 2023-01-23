package com.IU.domain.auth.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter @Builder
@AllArgsConstructor
public class TokenResponse {

    private final String accessToken;

    private final String refreshToken;

    private final ZonedDateTime expiredAt;

}
