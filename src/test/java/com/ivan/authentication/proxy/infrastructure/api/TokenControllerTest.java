package com.ivan.authentication.proxy.infrastructure.api;

import com.ivan.authentication.proxy.domain.TokenRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TokenControllerTest {

    public static final String TOKEN = "token";
    @Mock
    private TokenRepository getToken;

    @Mock
    private Map<String, Object> response;

    @Mock
    private TokenControllerMapper tokenControllerMapper;

    @InjectMocks
    private TokenController tokenController;

    @Test
    void it_should_exists_controller() {
        assertThat(tokenController)
            .as("It should exists controller")
            .isNotNull();
    }

    @Test
    void it_should_return_a_response() {
        when(getToken.get()).thenReturn(TOKEN);
        when(tokenControllerMapper.mapToResponse(TOKEN)).thenReturn(response);

        final var response = tokenController.getToken();

        assertThat(response)
            .as("it should return a response")
            .isEqualTo(response);
    }
}
