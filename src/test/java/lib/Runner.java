package test.java.lib;

import cucumber.api.Scenario;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class Runner {

    public static WebDriver driver;
    private DesiredCapabilities capabilities;
    public static Configuration conf;

    public Runner() {
        conf = new Configuration();
    }

    public void setup() {
        if (conf.getProperty("browser").equals("Chrome")) {
            String chromePath = System.getProperty("user.dir") + "\\src\\test\\resources\\config\\drivers\\";
            System.setProperty("webdriver.chrome.driver", chromePath+"chromedriver238.exe");
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            ChromeOptions ops = new ChromeOptions();
            ops.setExperimentalOption("prefs", chromePrefs);
            capabilities = DesiredCapabilities.chrome();
            ops.addArguments("--disable-notifications");
            ops.setExperimentalOption("useAutomationExtension", false);
            capabilities.setCapability(ChromeOptions.CAPABILITY, ops);
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
            driver = new ChromeDriver(capabilities);
            driver.manage().window().maximize();
        }
    }
}
