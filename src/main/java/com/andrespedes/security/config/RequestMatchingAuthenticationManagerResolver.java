package com.andrespedes.security.config;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationManagerResolver;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;

public class RequestMatchingAuthenticationManagerResolver
        implements AuthenticationManagerResolver<HttpServletRequest> {

    private final LinkedHashMap<RequestMatcher, AuthenticationManager> authenticationManagers;
    private AuthenticationManager defaultAuthenticationManager = authentication -> {
        throw new AuthenticationServiceException("Cannot authenticate " + authentication);
    };

    /**
     * Construct an {@link RequestMatchingAuthenticationManagerResolver}
     * based on the provided parameters
     *
     * @param authenticationManagers a {@link Map} of {@link RequestMatcher}/{@link AuthenticationManager} pairs
     */
    public RequestMatchingAuthenticationManagerResolver
    (LinkedHashMap<RequestMatcher, AuthenticationManager> authenticationManagers) {
        Assert.notEmpty(authenticationManagers, "authenticationManagers cannot be empty");
        this.authenticationManagers = authenticationManagers;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuthenticationManager resolve(HttpServletRequest context) {
        for (Map.Entry<RequestMatcher, AuthenticationManager> entry : this.authenticationManagers.entrySet()) {
            if (entry.getKey().matches(context)) {
                return entry.getValue();
            }
        }

        return this.defaultAuthenticationManager;
    }

    /**
     * Set the default {@link AuthenticationManager} to use when a request does not match
     *
     * @param defaultAuthenticationManager the default {@link AuthenticationManager} to use
     */
    public void setDefaultAuthenticationManager(AuthenticationManager defaultAuthenticationManager) {
        Assert.notNull(defaultAuthenticationManager, "defaultAuthenticationManager cannot be null");
        this.defaultAuthenticationManager = defaultAuthenticationManager;
    }
}