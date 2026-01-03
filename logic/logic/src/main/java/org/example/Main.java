package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        ServiceHealthChecker checker = new ServiceHealthChecker();
        IncidentDetector detector = new IncidentDetector();
        SeverityClassifier classifier = new SeverityClassifier();
        AiContextBuilder aiBuilder = new AiContextBuilder();

        int failureCount = 0;

        for (int i = 0; i < 5; i++) {
            HealthCheckResult result = checker.check("web-service");

            System.out.println("Health Check Result: " + result);

            if (detector.isIncident(result)) {
                failureCount++;

                Severity severity = classifier.classify(result, failureCount);
                String aiContext = aiBuilder.buildPrompt(result, failureCount);

                System.out.println("🚨 INCIDENT DETECTED");
                System.out.println("Severity: " + severity);
                System.out.println("AI Context:");
                System.out.println(aiContext);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {}
        }
    }
}