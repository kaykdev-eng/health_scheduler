package com.kayk.healthscheduler.domain.doctor;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.UUID;

public record DoctorRequestDTO(
        UUID id,
        @NotBlank(message = "Requested name")
        String name,
        @NotBlank(message = "Request CRM")
        @Pattern(
                regexp = "^[0-9]{3,7}/[A-Z]{2}$",
                message = "O CRM deve estar no formato '123456/SP' (de 3 a 7 números, barra e duas letras maiúsculas)."
        )
        String crm,
        @NotNull(message = "The price is mandatory.")
        @PositiveOrZero(message = "The price must be greater than or equal to zero.")
        @Digits(integer = 8, fraction = 2)
        BigDecimal price,
        @NotNull(message = "mandatory specialty")
        UUID specialityId
) {
}
