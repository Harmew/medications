package com.harmew.api.medications.services;

import com.harmew.api.medications.models.users.entities.User;

public interface TokenService {

    /**
     * Generate token with provided user
     */
    public String generateToken(User user);

    /**
     * Get subject by provided token
     */
    public String getSubject(String tokenJWT);
}
