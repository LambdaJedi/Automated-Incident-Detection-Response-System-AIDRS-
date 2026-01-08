package org.example.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record IncidentRequest(
        @NotBlank(message = "serviceName is required")
        String serviceName,

        @NotBlank(message = "environment is required")
        String environment,

        @Min(value = 0, message = "failureCount must be >= 0")
        int failureCount,

        @Min(value = 0, message = "responseTimeMs must be >= 0")
        long responseTimeMs,

        String errorMessage,

        String timestamp
) {}

