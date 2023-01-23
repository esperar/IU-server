package com.IU.global.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity(debug = false)
public class SecurityConfig {
}
