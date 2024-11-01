package com.harmew.api.medications.controllers;

import com.harmew.api.medications.models.users.AuthenticateDTO;
import com.harmew.api.medications.models.users.TokenDTO;
import com.harmew.api.medications.models.users.entities.User;
import com.harmew.api.medications.services.AuthenticateService;
import com.harmew.api.medications.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticateController {

    private final AuthenticateService authenticateService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticateController(AuthenticateService authenticateService, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticateService = authenticateService;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    private ResponseEntity<TokenDTO> login(@RequestBody @Valid AuthenticateDTO data) {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        Authentication authentication = authenticationManager.authenticate(token);

        TokenDTO tokenJWT = new TokenDTO(tokenService.generateToken((User) authentication.getPrincipal()));

        return ResponseEntity.ok(tokenJWT);
    }

}
