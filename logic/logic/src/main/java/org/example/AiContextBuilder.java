package org.example;

public class AiContextBuilder {
    public String buildPrompt(HealthCheckResult result, int failureCount) {

        return String.format(
                "Service status code: %d%n" +
                        "Response time: %d ms%n" +
                        "Message: %s%n" +
                        "Failure count: %d%n" +
                        "Provide possible causes and mitigation steps.",
                result.getStatusCode(),
                result.getResponseTimeMs(),
                result.getMessage(),
                failureCount
        );
    }
}
