package com.payment.wallet.auth.service;

import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.payment.wallet.auth.dto.AuthResponse;
import com.payment.wallet.auth.dto.RegisterRequest;
import com.payment.wallet.auth.entity.User;
import com.payment.wallet.auth.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponse register(RegisterRequest request) {

        User user = User.builder()
                .userId(UUID.randomUUID().toString())
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);

        String accessToken = jwtService.generateToken(
                request.getEmail());

        String refreshToken = UUID.randomUUID().toString();

        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();

    }
}
