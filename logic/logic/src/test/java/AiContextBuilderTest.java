import org.example.AiContextBuilder;
import org.example.HealthCheckResult;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AiContextBuilderTest {
    @Test
    public void testPromptIncludesAllInfo() {
        AiContextBuilder builder = new AiContextBuilder();

        HealthCheckResult result = new HealthCheckResult(503, 150, "Service Unavailable");

        String prompt = builder.buildPrompt(result, 2); // 2 failures

        assertTrue("Prompt should contain status code", prompt.contains("503"));
        assertTrue("Prompt should contain response time", prompt.contains("150"));
        assertTrue("Prompt should contain error message", prompt.contains("Service Unavailable"));
        assertTrue("Prompt should contain failure count", prompt.contains("2"));
    }

}
