package com.ivan.authentication.proxy.infrastructure.vivelibre;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

@ExtendWith(MockitoExtension.class)
class ViveLibreMapperTest {

    private static final String USERNAME = "USERNAME";

    private static final String PASS = "PASS";

    @InjectMocks
    private ViveLibreMapper viveLibreMapper;

    @Test
    void it_should_map_username() {
        final var response = viveLibreMapper.toGetTokenRequest(USERNAME, PASS);

        assertThat(response.get("username"))
            .as("It should map username")
            .isEqualTo(USERNAME);
    }

    @Test
    void it_should_map_pass() {
        final var response = viveLibreMapper.toGetTokenRequest(USERNAME, PASS);

        assertThat(response.get("password"))
                .as("It should map pass")
                .isEqualTo(PASS);
    }
}
