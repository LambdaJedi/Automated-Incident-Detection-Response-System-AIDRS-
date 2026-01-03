package org.example;

public class IncidentDetector {
    public boolean isIncident(HealthCheckResult result) {
        // Simple rule for now
        return result.getStatusCode() != 200;
    }
}
