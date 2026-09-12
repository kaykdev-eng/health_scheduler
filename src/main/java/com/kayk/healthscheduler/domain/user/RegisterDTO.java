package com.kayk.healthscheduler.domain.user;

public record RegisterDTO(
        String login,
        String password,
        UserRole role
) {
}
