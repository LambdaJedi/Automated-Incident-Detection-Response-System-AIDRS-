package org.example;

public class HealthCheckResult {
    private int statusCode;
    private long responseTimeMs;
    private String message;

    public HealthCheckResult(int statusCode, long responseTimeMs, String message) {
        this.statusCode = statusCode;
        this.responseTimeMs = responseTimeMs;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public long getResponseTimeMs() {
        return responseTimeMs;
    }

    public String getMessage() {
        return message;
    }
}
