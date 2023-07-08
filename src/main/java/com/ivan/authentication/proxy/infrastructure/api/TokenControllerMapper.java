package com.ivan.authentication.proxy.infrastructure.api;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Map;

@Component
class TokenControllerMapper {

    Map<String, Object> mapToResponse(final String token) {
        return Map.of(
            "auth-vivelibre-token", token,
            "date", getDate()
        );
    }

    String getDate() {
        Instant.now();
        final var date = LocalDate.now();
        final var displayMonth = date.getMonth().getDisplayName(TextStyle.FULL, new Locale("en", "EN"));

        return new StringBuilder(displayMonth)
            .append(" ")
            .append(date.getDayOfMonth())
            .append(", ")
            .append(date.getYear())
            .toString();
    }
}
