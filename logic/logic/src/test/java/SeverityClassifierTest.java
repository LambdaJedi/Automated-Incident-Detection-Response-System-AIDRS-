import org.example.HealthCheckResult;
import org.example.Severity;
import org.example.SeverityClassifier;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class SeverityClassifierTest {

    @Test
    void testHighSeverityForMultipleFailures() {
        SeverityClassifier classifier = new SeverityClassifier();

        HealthCheckResult result = new HealthCheckResult(500, 100, "Error");

        Severity severity = classifier.classify(result, 3); // 3 failures
        assertEquals(Severity.HIGH, severity, "Severity should be HIGH for 3 failures");
    }

    @Test
    void testMediumSeverityForSlowResponse() {
        SeverityClassifier classifier = new SeverityClassifier();

        HealthCheckResult result = new HealthCheckResult(200, 2500, "OK"); // 2500ms

        Severity severity = classifier.classify(result, 1);
        assertEquals(Severity.MEDIUM, severity, "Severity should be MEDIUM for slow response");
    }

    @Test
    void testLowSeverityForNormalResponse() {
        SeverityClassifier classifier = new SeverityClassifier();

        HealthCheckResult result = new HealthCheckResult(200, 100, "OK");

        Severity severity = classifier.classify(result, 1);
        assertEquals(Severity.LOW, severity, "Severity should be LOW for normal response");
    }
}
