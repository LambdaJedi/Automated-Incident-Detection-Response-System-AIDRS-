package org.example.domain;

import org.example.dto.IncidentRequest;
import org.example.model.Severity;
import org.springframework.stereotype.Component;

@Component
public class AiContextBuilder {

    public String buildInsight(IncidentRequest request, Severity severity) {
        StringBuilder insight = new StringBuilder();

        insight.append("Service Analysis:\n");
        insight.append(String.format("- Service: %s\n", request.serviceName()));
        insight.append(String.format("- Environment: %s\n", request.environment()));
        insight.append(String.format("- Failures: %d consecutive\n", request.failureCount()));
        insight.append(String.format("- Response Time: %dms\n", request.responseTimeMs()));

        if (request.errorMessage() != null && !request.errorMessage().isEmpty()) {
            insight.append(String.format("- Error: %s\n", request.errorMessage()));
        }

        insight.append("\nPattern Detection:\n");
        if (request.failureCount() > 8) {
            insight.append("- Persistent failure pattern detected\n");
            insight.append("- Possible service dependency issue\n");
        } else if (request.responseTimeMs() > 3000) {
            insight.append("- High latency pattern detected\n");
            insight.append("- Possible network/database issue\n");
        } else {
            insight.append("- Transient issue pattern\n");
        }

        return insight.toString();
    }
}
