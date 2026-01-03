import org.example.HealthCheckResult;
import org.example.IncidentDetector;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IncidentDetectorTest {
    @Test
    public void testIncidentDetectedForNon200Status() {
        IncidentDetector detector = new IncidentDetector();

        // Example HealthCheckResult with error
        HealthCheckResult result = new HealthCheckResult(500, 100, "Internal Server Error");

        boolean incident = detector.isIncident(result);

        assertTrue("Incident should be detected for status != 200", incident);
    }

    @Test
    public void testNoIncidentFor200Status() {
        IncidentDetector detector = new IncidentDetector();

        HealthCheckResult result = new HealthCheckResult(200, 50, "OK");

        boolean incident = detector.isIncident(result);

        assertFalse("No incident should be detected for status 200", incident);
    }
}
