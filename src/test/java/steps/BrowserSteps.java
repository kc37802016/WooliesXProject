package test.java.steps;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import test.java.lib.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import static test.java.lib.TestData.getScenarioID;

public class BrowserSteps extends Runner {

    private Runner runner;
    private WebDriverHelper webDriverHelper;
    private static ExtentReport extentReport;
    private File src;
    private DateFormat dateFormat;
    private Date date;
    private Configuration config;

    public static String snapsFolder = "";

    public BrowserSteps() {
        runner = new Runner();
        webDriverHelper = new WebDriverHelper();
        config = new Configuration();
        extentReport = new ExtentReport();
    }

    @Given("^I start the web browser$")
    public void i_start_the_web_browser() {
        runner.setup();
    }

    public void setUp(Scenario scenario) {
        String scenarioName = scenario.getName();
        String[] parts = scenarioName.split("-");
        String scenarioID = parts[0];
        try {
            Path path = Paths.get(config.getProperty("path"));
            if(!Files.exists(path)) {
                Files.createDirectories(path);
            }
            if(!Files.exists(Paths.get(config.getProperty("screenshots")))){
                Files.createDirectories(Paths.get(config.getProperty("screenshots")));
            }

        dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        date = new Date();
        dateFormat.format(date);
        snapsFolder = scenarioID;
        snapsFolder = snapsFolder+"_"+dateFormat.format(date);
        Files.createDirectories(Paths.get(config.getProperty("screenshots")+"\\"+snapsFolder));
        }
            catch (IOException e) {
            System.err.println("Failed to create directory!" + e.getMessage());

        }
    }

    public void cleanup() {
        driver.quit();
    }


}
