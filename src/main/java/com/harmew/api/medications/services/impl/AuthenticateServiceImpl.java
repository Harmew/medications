package com.harmew.api.medications.services.impl;

import com.harmew.api.medications.models.users.repositories.UserRepository;
import com.harmew.api.medications.services.AuthenticateService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateServiceImpl implements AuthenticateService {

    private final UserRepository repository;

    public AuthenticateServiceImpl(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }
}
