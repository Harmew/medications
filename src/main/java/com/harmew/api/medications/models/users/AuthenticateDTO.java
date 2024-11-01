package com.harmew.api.medications.models.users;

public record AuthenticateDTO(
        String login,
        String password
) {
}
