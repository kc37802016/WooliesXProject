package test.java.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.Assert;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class CukeHooks {

    @Before
    public void setUp(Scenario scenario) {
        String scenarioName = scenario.getName();
        String[] parts = scenarioName.split("-");
        String scenarioID = parts[0];
        try {
            BrowserSteps browserSteps = new BrowserSteps();
            browserSteps.setUp(scenario);
        }
        catch (Exception e)
        {
            Assert.fail("Failed due to Exception: " + e.getMessage());
        }
    }

    @After
    public void afterTest(Scenario scenario) {
        try {
            String Path = System.getProperty("user.dir")+"/completed.txt";
            BufferedWriter out = new BufferedWriter(new FileWriter(Path));
            out.write("Test Completed");
            out.close();
            System.out.println("The complete file has been created successfully");
            System.out.println("This is end of Test Scenario");
            BrowserSteps browserstep = new BrowserSteps();
            browserstep.cleanup();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
