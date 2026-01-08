package org.example;

import org.example.domain.SeverityClassifier;
import org.example.dto.IncidentRequest;
import org.example.model.Severity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SeverityClassifierTest {

    private final SeverityClassifier classifier = new SeverityClassifier();

    @Test
    void testCriticalSeverity() {
        IncidentRequest request = new IncidentRequest(
                "service", "production", 16, 11000,
                "Critical error", "2024-01-15T10:30:00Z"
        );
        assertEquals(Severity.CRITICAL, classifier.classify(request));
    }

    @Test
    void testHighSeverity() {
        IncidentRequest request = new IncidentRequest(
                "service", "production", 11, 6000,
                "High error", "2024-01-15T10:30:00Z"
        );
        assertEquals(Severity.HIGH, classifier.classify(request));
    }

    @Test
    void testMediumSeverity() {
        IncidentRequest request = new IncidentRequest(
                "service", "production", 6, 2500,
                "Medium error", "2024-01-15T10:30:00Z"
        );
        assertEquals(Severity.MEDIUM, classifier.classify(request));
    }

    @Test
    void testLowSeverity() {
        IncidentRequest request = new IncidentRequest(
                "service", "production", 2, 1000,
                "Low error", "2024-01-15T10:30:00Z"
        );
        assertEquals(Severity.LOW, classifier.classify(request));
    }
}
