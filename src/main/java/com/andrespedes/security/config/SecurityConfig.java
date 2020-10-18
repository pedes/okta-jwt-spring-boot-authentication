package com.andrespedes.security.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

@Bean
OAuth2ClientProperties oAuth2ClientProperties() {
    return new OAuth2ClientProperties();
}
    
}