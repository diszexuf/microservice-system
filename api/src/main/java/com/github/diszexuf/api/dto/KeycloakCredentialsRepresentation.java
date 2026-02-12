package com.github.diszexuf.api.dto;

public record KeycloakCredentialsRepresentation(
        String type,
        String value,
        Boolean temporary
) {
}
