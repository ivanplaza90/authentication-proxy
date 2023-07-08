package com.ivan.authentication.proxy.infrastructure.vivelibre;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(
    name = "ViveLibreApi",
    url = "${vivelibre.url}"
)
public interface ViveLibreApi {

    @PostMapping(value = "/token", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    Map<String, Object> getToken(@RequestBody Map<String,Object> request);
}
