package org.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@ConfigurationProperties(prefix = "aidrs")
public class AidrsProperties {

    private Thresholds thresholds = new Thresholds();
    private BusinessHours businessHours = new BusinessHours();
    private Automation automation = new Automation();
    private N8n n8n = new N8n();

    // Getters and Setters
    public Thresholds getThresholds() { return thresholds; }
    public void setThresholds(Thresholds thresholds) { this.thresholds = thresholds; }

    public BusinessHours getBusinessHours() { return businessHours; }
    public void setBusinessHours(BusinessHours businessHours) { this.businessHours = businessHours; }

    public Automation getAutomation() { return automation; }
    public void setAutomation(Automation automation) { this.automation = automation; }

    public N8n getN8n() { return n8n; }
    public void setN8n(N8n n8n) { this.n8n = n8n; }

    // Inner classes
    public static class Thresholds {
        private long criticalResponseTime = 10000;
        private long highResponseTime = 5000;
        private long mediumResponseTime = 2000;
        private int criticalFailures = 15;
        private int highFailures = 10;
        private int mediumFailures = 5;

        // Getters and Setters
        public long getCriticalResponseTime() { return criticalResponseTime; }
        public void setCriticalResponseTime(long criticalResponseTime) { this.criticalResponseTime = criticalResponseTime; }

        public long getHighResponseTime() { return highResponseTime; }
        public void setHighResponseTime(long highResponseTime) { this.highResponseTime = highResponseTime; }

        public long getMediumResponseTime() { return mediumResponseTime; }
        public void setMediumResponseTime(long mediumResponseTime) { this.mediumResponseTime = mediumResponseTime; }

        public int getCriticalFailures() { return criticalFailures; }
        public void setCriticalFailures(int criticalFailures) { this.criticalFailures = criticalFailures; }

        public int getHighFailures() { return highFailures; }
        public void setHighFailures(int highFailures) { this.highFailures = highFailures; }

        public int getMediumFailures() { return mediumFailures; }
        public void setMediumFailures(int mediumFailures) { this.mediumFailures = mediumFailures; }
    }

    public static class BusinessHours {
        private LocalTime start = LocalTime.of(9, 0);
        private LocalTime end = LocalTime.of(17, 0);

        public LocalTime getStart() { return start; }
        public void setStart(LocalTime start) { this.start = start; }

        public LocalTime getEnd() { return end; }
        public void setEnd(LocalTime end) { this.end = end; }
    }

    public static class Automation {
        private boolean pageOnHigh = true;
        private boolean createTicketOnMedium = true;
        private boolean autoRetryEnabled = true;

        public boolean isPageOnHigh() { return pageOnHigh; }
        public void setPageOnHigh(boolean pageOnHigh) { this.pageOnHigh = pageOnHigh; }

        public boolean isCreateTicketOnMedium() { return createTicketOnMedium; }
        public void setCreateTicketOnMedium(boolean createTicketOnMedium) { this.createTicketOnMedium = createTicketOnMedium; }

        public boolean isAutoRetryEnabled() { return autoRetryEnabled; }
        public void setAutoRetryEnabled(boolean autoRetryEnabled) { this.autoRetryEnabled = autoRetryEnabled; }
    }

    public static class N8n {
        private int webhookTimeout = 5000;
        private int maxRetries = 3;

        public int getWebhookTimeout() { return webhookTimeout; }
        public void setWebhookTimeout(int webhookTimeout) { this.webhookTimeout = webhookTimeout; }

        public int getMaxRetries() { return maxRetries; }
        public void setMaxRetries(int maxRetries) { this.maxRetries = maxRetries; }
    }
}
