package test.java.cucumber;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(ExtendedCucumber.class)
@CucumberOptions(
        glue = {"test.java.steps"},
        features = {"src/test/resources/features/"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true)

public class CucumberRunner {
}
