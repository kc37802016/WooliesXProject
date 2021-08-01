package test.java.pages;

import org.openqa.selenium.By;
import test.java.lib.WebDriverHelper;

public class Woolworths_Home_Page {

    private WebDriverHelper webDriverHelper;

    public Woolworths_Home_Page() {
        webDriverHelper = new WebDriverHelper();
    }

    public String xpath1, xpath2, xpath3;
    private static String BANNER = ".//div[@class='container-fluid ww-product-container']";
    private static final By ACCEPT_CHECKBOX = By.xpath(".//input[@type='checkbox']");
    private static final By GET_QUOTE_NOW_BTN = By.xpath(".//button[text()='Get a quote now']");
    private static final By FIRST_NAME_TXT = By.name("FirstName");

    public void insuranceQuote(String Insurance, String Quote, String menuInsurance) {
        if (!Insurance.equals("")) {
            xpath1 = Insurance;
            xpath2 = Quote;
            xpath3 = menuInsurance;
            By INSUARNCE_BANNER = By.xpath(BANNER + "//a[text()=' " + xpath1 + "']");
            By SUBMENU = By.xpath(BANNER + "//h4[text()=' " + xpath2 + "']/parent::*//a[text()='" + xpath3 + "']");
            webDriverHelper.waitForElement(INSUARNCE_BANNER);
            webDriverHelper.hoverBy(INSUARNCE_BANNER);
            webDriverHelper.waitForElement(SUBMENU);
            webDriverHelper.click(SUBMENU);
            webDriverHelper.waitForElement(ACCEPT_CHECKBOX);
        }
    }

    public void getQuoteNow(String filed){
       if(!webDriverHelper.findElement(ACCEPT_CHECKBOX).isSelected()) {
            webDriverHelper.click(ACCEPT_CHECKBOX);
        }
        webDriverHelper.waitForElement(GET_QUOTE_NOW_BTN);
        webDriverHelper.click(GET_QUOTE_NOW_BTN);
        System.out.println(filed+" :field is displayed");
        webDriverHelper.waitForElement(FIRST_NAME_TXT);
    }
}

