package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src//test//java//resources//",
        glue = "resources/stepDefinitions",
        publish = true,
        plugin = {
                "pretty",
                "html:test-output",
        }
)
public class TestRun {
}
