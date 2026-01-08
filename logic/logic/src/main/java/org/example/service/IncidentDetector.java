package org.example.service;

import org.example.domain.SeverityClassifier;
import org.example.domain.AiContextBuilder;
import org.example.dto.IncidentRequest;
import org.example.dto.IncidentResponse;
import org.example.model.Severity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class IncidentDetector {

    private final SeverityClassifier severityClassifier;
    private final AiContextBuilder aiContextBuilder;

    public IncidentDetector(SeverityClassifier severityClassifier,
                            AiContextBuilder aiContextBuilder) {
        this.severityClassifier = severityClassifier;
        this.aiContextBuilder = aiContextBuilder;
    }

    public IncidentResponse detect(IncidentRequest request) {
        // 1. Calculate severity
        Severity severity = severityClassifier.classify(request);

        // 2. Build AI insight
        String aiInsight = aiContextBuilder.buildInsight(request, severity);

        // 3. Generate recommendation
        String recommendation = generateRecommendation(request, severity);

        // 4. Determine system status
        String systemStatus = determineSystemStatus(request, severity);

        // 5. Set automation flags
        Boolean shouldPage = severity == Severity.HIGH || severity == Severity.CRITICAL;
        Boolean shouldCreateTicket = severity != Severity.LOW;
        Boolean isAutoResolvable = severity == Severity.LOW;

        // 6. Return complete response
        return new IncidentResponse(
                request.serviceName(),
                severity.name(),
                recommendation,
                aiInsight,
                systemStatus,
                LocalDateTime.now(),
                shouldPage,
                shouldCreateTicket,
                isAutoResolvable
        );
    }

    private String generateRecommendation(IncidentRequest request, Severity severity) {
        switch (severity) {
            case CRITICAL:
                return "IMMEDIATE ACTION: Page on-call engineer, trigger auto-rollback";
            case HIGH:
                return "URGENT: Check service dependencies, review error logs";
            case MEDIUM:
                return "MONITOR: Increase logging, schedule investigation";
            case LOW:
                return "NORMAL: Log for trend analysis, no immediate action";
            default:
                return "No action required";
        }
    }

    private String determineSystemStatus(IncidentRequest request, Severity severity) {
        if (severity == Severity.CRITICAL) return "SYSTEM_IMPACT";
        if (severity == Severity.HIGH) return "SERVICE_DEGRADED";
        if (request.failureCount() > 5) return "ELEVATED_RISK";
        return "OPERATIONAL";
    }
}
