package calculator;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/calculator.feature",
    glue = "calculator",
    plugin = {"pretty"}
)
public class RunnerTest {
}
