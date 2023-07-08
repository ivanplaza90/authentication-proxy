package com.ivan.authentication.proxy.infrastructure.vivelibre;

import com.ivan.authentication.proxy.domain.TokenRepository;
import org.springframework.stereotype.Component;

@Component
public class TokenRepositoryImpl implements TokenRepository {

    private ViveLibreProperties viveLibreProperties;

    private ViveLibreMapper viveLibreMapper;

    private ViveLibreApi viveLibreApi;

    public TokenRepositoryImpl(
        final ViveLibreProperties viveLibreProperties,
        final ViveLibreMapper viveLibreMapper,
        final ViveLibreApi viveLibreApi
    ) {
        this.viveLibreProperties = viveLibreProperties;
        this.viveLibreMapper = viveLibreMapper;
        this.viveLibreApi = viveLibreApi;
    }

    @Override
    public String get() {
        return viveLibreApi.getToken(
            viveLibreMapper.toGetTokenRequest(
                viveLibreProperties.getUsername(),
                viveLibreProperties.getPass()
            )
        );
    }
}
