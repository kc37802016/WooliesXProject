package test.java.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.java.lib.ExtentReport;
import test.java.lib.WebDriverHelper;
import test.java.pages.W_LInsurance_AboutYou_Page;

import java.util.Map;

public class QuoteSteps {

    private WebDriverHelper webDriverHelper;
    private W_LInsurance_AboutYou_Page liAboutYouPage;
    private ExtentReport extentReport;

    public QuoteSteps(){
        webDriverHelper = new WebDriverHelper();
        liAboutYouPage = new W_LInsurance_AboutYou_Page();
        extentReport = new ExtentReport();
    }

    @When("^I enter the details in About you Section$")
    public void iEnterTheDetailsInAboutYouSection(DataTable aboutyouinfo) throws Throwable {
        System.out.println("STEP - I enter the details in About you Section"+"\n");
        for (Map<String, String> data : aboutyouinfo.asMaps(String.class, String.class)) {
            liAboutYouPage.enterAboutYouDetails(data.get("First Name"), data.get("DOB"), data.get("Cigarette"), data.get("Gender"),
                    data.get("Annual Income"), data.get("Cover"));
        }
        extentReport.screenshot();
    }

    @Then("^I verify Cover Amounts are in \"([^\"]*)\"$")
    public void iVerifyCoverAmountsAreIn(String order) throws Throwable {
        System.out.println("STEP - I verify Cover Amounts are in "+order+"\n");
        liAboutYouPage.verifyCoverAmounts(order);
        extentReport.screenshot();
    }
}
