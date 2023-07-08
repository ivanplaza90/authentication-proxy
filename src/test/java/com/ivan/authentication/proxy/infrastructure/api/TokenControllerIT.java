package com.ivan.authentication.proxy.infrastructure.api;

import com.ivan.authentication.proxy.infrastructure.vivelibre.ViveLibreApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class TokenControllerIT {

    private static final String TOKEN = "TOKEN";

    @MockBean
    private ViveLibreApi viveLibreApi;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void it_should_return_token_ok_response() throws Exception {
        when(viveLibreApi.getToken(anyMap())).thenReturn(Map.of("token", TOKEN));

        mockMvc.perform(get("/get-token")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.auth-vivelibre-token").value(TOKEN))
            .andExpect(jsonPath("$.date").exists());
    }

}
