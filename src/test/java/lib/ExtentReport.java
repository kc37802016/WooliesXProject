package test.java.lib;

import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static test.java.steps.BrowserSteps.snapsFolder;

public class ExtentReport extends Runner {

    private WebDriverHelper webDriverHelper;
    public static ExtentReports extentReports;
    private Configuration config;
    private File src;
    private DateFormat dateFormat;
    private Date date;

    public ExtentReport() {
        webDriverHelper = new WebDriverHelper();
        config = new Configuration();
    }

    public void screenshot() throws IOException{
        String snapshotpath = TestData.getScenarioID();
        dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        date = new Date();
        dateFormat.format(date);
        src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(src.toPath(), new FileOutputStream(config.getProperty("path")+"Snapshots\\"+snapsFolder+"\\"+dateFormat.format(date)+"screenshot.png"));
    }

}
