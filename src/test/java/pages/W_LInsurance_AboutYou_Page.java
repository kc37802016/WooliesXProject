package test.java.pages;

import test.java.lib.Runner;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.java.lib.WebDriverHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class W_LInsurance_AboutYou_Page extends Runner {

    private WebDriverHelper webDriverHelper;

    public W_LInsurance_AboutYou_Page() {
        webDriverHelper = new WebDriverHelper();
    }

    private static final By FIRST_NAME_TXT = By.name("FirstName");
    private static final By DOB = By.name("dateofbirth");
    private static final By DOB_SELECT = By.xpath(".//div[contains(@class,'datepicker__day--selected')]");
    private static final By CIGARETTE_NO_TXT = By.xpath(".//input[@name='Smoker']/following-sibling::label[text()='No']");
    private static final By CIGARETTE_YES_TXT = By.xpath(".//input[@name='Smoker']/following-sibling::label[text()='Yes']");
    private static final By INCOME_NO_TXT = By.xpath(".//input[@name='Income']/following-sibling::label[text()='No']");
    private static final By INCOME_YES_TXT = By.xpath(".//input[@name='Income']/following-sibling::label[text()='Yes']");
    private static final By GENDER_MALE = By.xpath(".//label[contains(@for,'Gender')][text()='Male']");
    private static final By GENDER_FEMALE = By.xpath(".//label[contains(@for,'Gender')][text()='Female']");
    private static final By PLEASE_SELECT_TXT = By.xpath(".//*[text()='Please select...']");
    private static final By COVER_AMOUNT = By.xpath(".//*[contains(@id,'option-0')]");
    private static final By COVER_AMOUNT_DRPDOWN = By.xpath(".//*[contains(@id,'option-')]");
    private static final By ACCEPT_CHECKBOX = By.xpath(".//input[@type='checkbox']");
    private static final By CONTINUE_BTN = By.xpath(".//button[text()='Continue']");
    private static final By NICE_TO_MEET_TXT = By.xpath(".//*[contains(text(),'it’s nice to meet you')]");

    public void enterAboutYouDetails(String firstname, String dob, String smoker, String gender, String income, String cover){
        webDriverHelper.setText(FIRST_NAME_TXT, firstname);
        webDriverHelper.setText(DOB, dob);
        webDriverHelper.click(DOB_SELECT);
        webDriverHelper.hardWait(1);
        if(smoker.equals("Yes")){
            webDriverHelper.click(CIGARETTE_YES_TXT);
        }else{
            webDriverHelper.click(CIGARETTE_NO_TXT);
        }
        if(gender.equals("Male")) {
            webDriverHelper.click(GENDER_MALE);
        }else if(gender.equals("Female")){
            webDriverHelper.click(GENDER_FEMALE);
        }
        if(income.equals("Yes")){
            webDriverHelper.click(INCOME_YES_TXT);
        }else{
            webDriverHelper.click(INCOME_NO_TXT);
        }
        webDriverHelper.hardWait(5);
        webDriverHelper.waitForElementClickable(PLEASE_SELECT_TXT);
        webDriverHelper.click(PLEASE_SELECT_TXT);
        boolean exists = webDriverHelper.isElementExist(COVER_AMOUNT,3);
        Assert.assertTrue("Cover Amount is displayed", exists);
        webDriverHelper.hardWait(2);
        List<WebElement> coverAmounts = driver.findElements(COVER_AMOUNT_DRPDOWN);
        if(!cover.equals("")){
            for(int i=0;i<coverAmounts.size();i++){
                if(coverAmounts.get(i).getText().equals(cover)){
                    webDriverHelper.findElement(By.xpath(".//*[contains(@id,'option-"+i+"')]")).click();
                    break;
                }
            }
        }
    }

    public void verifyCoverAmounts(String order){
        if(!webDriverHelper.isElementExist(COVER_AMOUNT,3)){
            webDriverHelper.click(PLEASE_SELECT_TXT);
        }
        List<String> coverAmounts = new ArrayList();
        List<Integer> coverAmountValue = new ArrayList();
        List<Integer> coverAmountValueSorted = new ArrayList();
        for(int i=0;i<driver.findElements(COVER_AMOUNT_DRPDOWN).size();i++){
            coverAmounts.add(driver.findElements(COVER_AMOUNT_DRPDOWN).get(i).getText());
            coverAmounts.set(i, coverAmounts.get(i).replace("$", ""));
            coverAmounts.set(i, coverAmounts.get(i).replace(",", ""));
        }
        for(int i=0;i<coverAmounts.size();i++){
            coverAmountValue.add(Integer.parseInt(coverAmounts.get(i)));
            coverAmountValueSorted.add(Integer.parseInt(coverAmounts.get(i)));
        }
        if(order.equals("Ascending order")){
            Collections.sort(coverAmountValueSorted);
            if(coverAmountValueSorted.equals(coverAmountValue)){
                Assert.assertTrue("Cover Amounts are in Ascending Order", true);
            }else{
                Assert.fail("Cover Amounts are not in Ascending Order");
            }
        }
    }

    public void acceptAndContinue(){
        webDriverHelper.click(ACCEPT_CHECKBOX);
        webDriverHelper.click(CONTINUE_BTN);
        webDriverHelper.waitForElement(NICE_TO_MEET_TXT);
    }

}
