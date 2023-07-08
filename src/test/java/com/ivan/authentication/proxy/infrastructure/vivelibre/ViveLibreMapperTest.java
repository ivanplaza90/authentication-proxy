package com.ivan.authentication.proxy.infrastructure.vivelibre;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Map;

@ExtendWith(MockitoExtension.class)
class ViveLibreMapperTest {

    private static final String USERNAME = "USERNAME";

    private static final String PASS = "PASS";

    private static final String TOKEN = "TOKEN";

    @Mock
    private Map<String, Object> jsonResponse;

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

    @Test
    void it_should_map_access_token() {
        when(jsonResponse.get("token")).thenReturn(TOKEN);

        final var response = viveLibreMapper.toAccessToken(jsonResponse);

        assertThat(response)
            .as("it should map access token")
            .isEqualTo(TOKEN);
    }
}
