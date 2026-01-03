import org.example.HealthCheckResult;
import org.example.ServiceHealthChecker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ServiceHealthCheckerTest {

    @Test
    void testHealthCheckReturnsResult() {
        ServiceHealthChecker checker = new ServiceHealthChecker();

        HealthCheckResult result = checker.check("payment-service");

        assertNotNull(result);
        assertTrue(result.getStatusCode() > 0);
        assertTrue(result.getResponseTimeMs() >= 0);
    }
}
