package com.ivan.authentication.proxy.infrastructure.api;

import com.ivan.authentication.proxy.domain.TokenRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
class TokenController {

    private final TokenRepository getToken;

    private final TokenControllerMapper mapper;

    TokenController(
        final TokenRepository getToken,
        final TokenControllerMapper mapper
    ) {
        this.getToken = getToken;
        this.mapper = mapper;
    }

    @GetMapping("get-token")
    Map<String, Object> getToken() {
        return mapper.mapToResponse(getToken.get());
    }
}
