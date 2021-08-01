package test.java.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.java.lib.ExtentReport;
import test.java.lib.GoRestAPI;
import test.java.lib.Runner;
import test.java.lib.WebDriverHelper;
import test.java.pages.Woolworths_Home_Page;
import test.java.pages.W_LInsurance_AboutYou_Page;
;import java.io.IOException;

public class NavigationSteps extends Runner {

    private ExtentReport extentReport;
    private WebDriverHelper webDriverHelper;
    private Woolworths_Home_Page homePage;
    private W_LInsurance_AboutYou_Page WLInsurance_about_you_page;
    private GoRestAPI goRestAPI;


    public NavigationSteps(){
        webDriverHelper = new WebDriverHelper();
        homePage = new Woolworths_Home_Page();
        WLInsurance_about_you_page = new W_LInsurance_AboutYou_Page();
        extentReport = new ExtentReport();
        goRestAPI = new GoRestAPI();
    }

    @When("^I open Woolworths Insurance Home Page$")
    public void iOpenWoolworthsInsuranceHomePage() throws IOException {
        System.out.println("STEP - I open Woolworths Insurance Home Page"+"\n");
        driver.get(conf.getProperty("UrltoUse"));
        extentReport.screenshot();
    }

    @When("^I navigate to \"([^\"]*)\" and then to \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iNavigateToAndThenToAnd(String arg0, String arg1, String arg2) throws Throwable {
        System.out.println("STEP - I navigate to "+arg0+" and then to "+arg1+" and "+arg2+"\n");
        homePage.insuranceQuote(arg0, arg1, arg2);
        extentReport.screenshot();
    }

    @When("^I click terms Checkbox and click on \"([^\"]*)\"$")
    public void iClickTermsCheckboxAndClickOn(String field) throws Throwable {
        System.out.println("STEP - I click terms Checkbox and click on "+field+"\n");
        switch(field){
            case "Get a quote now":
                homePage.getQuoteNow(field);
                break;
            case "Continue":
                WLInsurance_about_you_page.acceptAndContinue();
                break;
            default: break;

        }
        extentReport.screenshot();
    }

    @Given("^I Set Get data service endpoint API$")
    public void iSetGetDataServiceEndpointAPI() {
        System.out.println("STEP - Set Get data service endpoint API"+"\n");
        goRestAPI.reqSpec();
    }

    @When("^I send \"([^\"]*)\" HTTP request and validate the response status code \"([^\"]*)\"$")
    public void iSendHTTPRequestAndValidateTheResponseStatusCode(String RequestType, String StatusCode) throws Throwable {
        System.out.println("STEP - I Send HTTP request "+RequestType+" and validate the response status code "+StatusCode+"\n");
        goRestAPI.resSpec(RequestType, StatusCode);
    }

    @Then("^I validate JSON Schema for the \"([^\"]*)\" request and Status Code \"([^\"]*)\"$")
    public void iValidateJSONSchemaForTheRequestAndStatusCode(String RequestType, String StatusCode) throws Throwable {
        System.out.println("STEP - I validate JSON Schema for the "+RequestType+" request and Status Code "+StatusCode+"\n");
        goRestAPI.jsonSchemaValidator(RequestType, StatusCode);
    }
}
