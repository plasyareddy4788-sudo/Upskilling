package org.cognizant.authenticationservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.cognizant.authenticationservice.model.TokenResponse;
import org.cognizant.authenticationservice.util.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
public class AuthenticationController {

    @GetMapping("/authenticate")
    public TokenResponse authenticate(HttpServletRequest request) {

        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Basic ")) {
            throw new RuntimeException("Authorization header missing");
        }

        String base64 = header.substring(6);

        byte[] decoded = Base64.getDecoder().decode(base64);

        String credentials = new String(decoded, StandardCharsets.UTF_8);

        String[] values = credentials.split(":");

        String username = values[0];
        String password = values[1];

        if ("user".equals(username) && "pwd".equals(password)) {

            String token = JwtUtil.generateToken(username);

            return new TokenResponse(token);
        }

        throw new RuntimeException("Invalid Credentials");
    }
}