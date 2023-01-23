package starter;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"html:target/cucumber", "pretty", "rerun:target/rerun/failed_scenarios.txt"},
        features = "src/test/resources/features",
        tags = "@smokes-ui"
)
public class TestRunner {}
