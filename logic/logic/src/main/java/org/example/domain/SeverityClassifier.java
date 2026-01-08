package org.example.domain;

import org.example.dto.IncidentRequest;
import org.example.model.Severity;
import org.springframework.stereotype.Component;

@Component
public class SeverityClassifier {

    public Severity classify(IncidentRequest request) {
        // Rule 1: Critical
        if (request.responseTimeMs() > 10000 || request.failureCount() > 15) {
            return Severity.CRITICAL;
        }

        // Rule 2: High
        if (request.responseTimeMs() > 5000 || request.failureCount() > 10) {
            return Severity.HIGH;
        }

        // Rule 3: Medium
        if (request.responseTimeMs() > 2000 || request.failureCount() > 5) {
            return Severity.MEDIUM;
        }

        // Rule 4: Default to low
        return Severity.LOW;
    }
}
