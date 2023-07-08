package com.ivan.authentication.proxy.infrastructure.vivelibre;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TokenRepositoryImplTest {

    private static final String USERNAME = "USERNAME";

    private static final String PASS = "PASS";

    private static final String TOKEN = "TOKEN";

    @Mock
    private ViveLibreApi viveLibreAPI;

    @Mock
    private ViveLibreMapper viveLibreMapper;

    @Mock
    private Map<String, Object> request;

    @Mock
    private Map<String, Object> response;

    @Mock
    private ViveLibreProperties viveLibreProperties;

    @InjectMocks
    private TokenRepositoryImpl tokenRepositoryImpl;


    @Test
    void it_should_get_token() {
        when(viveLibreProperties.getUsername()).thenReturn(USERNAME);
        when(viveLibreProperties.getPass()).thenReturn(PASS);
        when(viveLibreMapper.toGetTokenRequest(USERNAME, PASS)).thenReturn(request);
        when(viveLibreAPI.getToken(request)).thenReturn(response);
        when(viveLibreMapper.toAccessToken(response)).thenReturn(TOKEN);

        final var response = tokenRepositoryImpl.get();

        assertThat(response)
            .as("It should get token")
            .isEqualTo(TOKEN);
    }
}
