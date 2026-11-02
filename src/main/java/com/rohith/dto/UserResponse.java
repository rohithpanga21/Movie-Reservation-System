package com.rohith.dto;

import java.time.LocalDateTime;

import com.rohith.entity.Role;

public record UserResponse(
	    Long id,
	    String name,
	    String email,
	    Role role,
	    LocalDateTime createdAt
) {}
