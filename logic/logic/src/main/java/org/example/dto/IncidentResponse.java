package org.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public record IncidentResponse(
        String serviceName,
        String severity,
        String recommendation,
        String aiInsight,
        String systemStatus,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        LocalDateTime analyzedAt,

        Boolean shouldPage,
        Boolean shouldCreateTicket,
        Boolean isAutoResolvable
) {
    // This is a canonical record - no custom constructor needed
}