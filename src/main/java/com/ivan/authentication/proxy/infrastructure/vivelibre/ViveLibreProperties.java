package com.ivan.authentication.proxy.infrastructure.vivelibre;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ViveLibreProperties {
    private String username;
    private String pass;

    public ViveLibreProperties(
        @Value("${vivelibre.user}") String username,
        @Value("${vivelibre.pass}") String pass
    ) {
        this.username = username;
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public String getUsername() {
        return username;
    }
}
