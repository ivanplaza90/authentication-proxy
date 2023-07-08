package com.ivan.authentication.proxy.infrastructure.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
class TokenControllerMapperTest {

    private static final String TOKEN = "token";

    @InjectMocks
    private TokenControllerMapper tokenControllerMapper;

    @Test
    void it_should_exists_the_mapper() {
        assertThat(tokenControllerMapper)
            .as("It should exists the maper")
            .isNotNull();
    }

    @Test
    void it_should_map_token() {
        final var response = tokenControllerMapper.mapToResponse(TOKEN);

        assertThat(response.get("auth-vivelibre-token"))
            .as("it should map token")
            .isEqualTo(TOKEN);
    }

    @Test
    void it_should_map_date() {
        final var response = tokenControllerMapper.mapToResponse(TOKEN);

        assertThat(response.get("date"))
            .as("it should map date")
            .isNotNull();
    }
}
