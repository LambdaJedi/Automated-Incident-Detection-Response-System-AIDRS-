package org.example;

import org.example.service.IncidentDetector;
import org.example.domain.SeverityClassifier;
import org.example.domain.AiContextBuilder;
import org.example.dto.IncidentRequest;
import org.example.dto.IncidentResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IncidentDetectorTest {

    @Mock
    private SeverityClassifier severityClassifier;

    @Mock
    private AiContextBuilder aiContextBuilder;

    private IncidentDetector incidentDetector;

    @BeforeEach
    void setUp() {
        incidentDetector = new IncidentDetector(severityClassifier, aiContextBuilder);
    }

    @Test
    void testCriticalIncidentDetection() {
        // Given
        IncidentRequest request = new IncidentRequest(
                "payment-service", "production", 20, 15000,
                "HTTP_500", "2024-01-15T10:30:00Z"
        );

        when(severityClassifier.classify(request))
                .thenReturn(org.example.model.Severity.CRITICAL);
        when(aiContextBuilder.buildInsight(any(), any()))
                .thenReturn("Test AI Insight");

        // When
        IncidentResponse response = incidentDetector.detect(request);

        // Then
        assertEquals("CRITICAL", response.severity());
        assertTrue(response.shouldPage());
        assertEquals("SYSTEM_IMPACT", response.systemStatus());
        assertNotNull(response.recommendation());
    }

    @Test
    void testLowSeverityIncident() {
        // Given
        IncidentRequest request = new IncidentRequest(
                "auth-service", "staging", 2, 500,
                null, "2024-01-15T10:30:00Z"
        );

        when(severityClassifier.classify(request))
                .thenReturn(org.example.model.Severity.LOW);
        when(aiContextBuilder.buildInsight(any(), any()))
                .thenReturn("Test AI Insight");

        // When
        IncidentResponse response = incidentDetector.detect(request);

        // Then
        assertEquals("LOW", response.severity());
        assertFalse(response.shouldPage());
        assertEquals("OPERATIONAL", response.systemStatus());
        assertTrue(response.isAutoResolvable());
    }
}
