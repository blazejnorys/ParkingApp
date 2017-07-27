package pl.training.backend.common.web;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class UriBuilder {

    public static final String[] PUBLIC_URIS = {
            "/v2/api-docs",
            "/configuration/ui",
            "/swagger-resources",
            "/configuration/security",
            "/webjars/**",
            "/swagger-ui.html",
            "/swagge‌​r-ui.html",
            "/swagger-resources/configuration/ui"
    };
    public static final String PREFIX = "/api-v1";
    public static final String ALL_URIS = PREFIX + "/**";

    public URI requestUriWithId(long id) {
        return ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }

}
