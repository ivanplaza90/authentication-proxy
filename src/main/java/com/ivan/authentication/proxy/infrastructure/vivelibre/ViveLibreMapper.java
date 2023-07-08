package com.ivan.authentication.proxy.infrastructure.vivelibre;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ViveLibreMapper {
    public Map<String, Object> toGetTokenRequest(final String username, final String pass) {
        return Map.of(
            "username", username,
            "password", pass
        );
    }

    public String toAccessToken(final Map<String, Object> jsonResponse) {
        return (String) jsonResponse.get("token");
    }
}
