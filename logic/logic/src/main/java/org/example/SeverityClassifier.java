package org.example;



public class SeverityClassifier {
    public Severity classify(HealthCheckResult result, int failureCount) {

        if (failureCount >= 3 || result.getStatusCode() >= 500) {
            return Severity.HIGH;
        }

        if (result.getResponseTimeMs() > 2000) {
            return Severity.MEDIUM;
        }

        return Severity.LOW;
    }
}
