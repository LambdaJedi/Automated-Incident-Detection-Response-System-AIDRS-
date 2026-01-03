package org.example;

import java.util.Random;

public class ServiceHealthChecker {

    private final Random random = new Random();

    public HealthCheckResult check(String serviceName) {

        // Simulate HTTP status
        int[] possibleStatusCodes = {200, 200, 200, 500, 503};
        int statusCode = possibleStatusCodes[random.nextInt(possibleStatusCodes.length)];

        // Simulate response time (ms)
        int responseTime = 50 + random.nextInt(3000);

        String message = (statusCode == 200)
                ? "Service healthy"
                : "Service failure detected";

        return new HealthCheckResult(statusCode, responseTime, message);
    }
}

