package org.example.util;  // Consider putting in util package

import org.example.HealthCheckResult;  // Assuming this exists

public class AiContextBuilder {

    public String buildPrompt(HealthCheckResult result, int failureCount) {
        return """
                Service status code: %d
                Response time: %d ms
                Message: %s
                Failure count: %d
                Provide possible causes and mitigation steps.
                """.formatted(
                result.getStatusCode(),
                result.getResponseTimeMs(),
                result.getMessage(),
                failureCount
        );
    }
}
