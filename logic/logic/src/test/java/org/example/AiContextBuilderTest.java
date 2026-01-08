package org.example;

import org.example.domain.AiContextBuilder;
import org.example.dto.IncidentRequest;
import org.example.model.Severity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AiContextBuilderTest {

    private final AiContextBuilder builder = new AiContextBuilder();

    @Test
    void testBuildInsight() {
        IncidentRequest request = new IncidentRequest(
                "payment-service", "production", 10, 5000,
                "Database timeout", "2024-01-15T10:30:00Z"
        );

        String insight = builder.buildInsight(request, Severity.HIGH);

        assertNotNull(insight);
        assertTrue(insight.contains("payment-service"));
        assertTrue(insight.contains("production"));
        assertTrue(insight.contains("HIGH"));
    }
}
