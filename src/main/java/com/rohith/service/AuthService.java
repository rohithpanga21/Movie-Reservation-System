package com.rohith.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rohith.dto.SignupRequest;
import com.rohith.dto.UserResponse;
import com.rohith.entity.Role;
import com.rohith.entity.User;
import com.rohith.exception.DuplicateResourceException;
import com.rohith.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserResponse signup(SignupRequest request) {
        String email = request.email().trim().toLowerCase();

        if (userRepository.existsByEmail(email)) {
            throw new DuplicateResourceException("Email already registered");
        }

        User user = new User();
        user.setName(request.name().trim());
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRole(Role.USER);   // always USER, never from the request

        User saved = userRepository.save(user);

        return new UserResponse(saved.getId(), saved.getName(),
                saved.getEmail(), saved.getRole(), saved.getCreatedAt());
    }
}
