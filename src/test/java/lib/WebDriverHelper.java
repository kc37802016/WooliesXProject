package test.java.lib;

import com.google.common.base.Predicate;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import java.util.concurrent.TimeUnit;

public class WebDriverHelper extends Runner {

    private static final long IMPLICIT_WAIT = 10;
    private static final long DEFAULT_TIME_OUT = 60;
    private static final long FLUENT_WAIT = 60;

    public void setText(By by, String text) {
        if (!text.equals("")) {
                driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
                WebElement element = null;
                try {
                    element = findElement(by);
                    if (element.isDisplayed()) {
                        if (element.isEnabled()) {
                            element.sendKeys(text);
                        } else {
                            Assert.fail("Element: " + element + " not enabled");
                        }
                    } else {
                        Assert.fail("Element " + element + " is not displayed");
                    }
                } catch (NoSuchElementException e) {
                    Assert.fail("Element " + element + " cannot be found");
                }
        }
    }

    public void click(WebElement element) {
        if (element.isDisplayed()) {
            element.click();
            try {
                wait(1);
            } catch (Exception e) { // Updated by Dipanjan
                Assert.fail();
            }
            // System.out.println("Element click " + element + " successful");
        } else {
            Assert.fail();
        }
    }

    public WebElement findElement(By by) {
        WebElement element = null;
        try {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
            element = driver.findElement(by);
        } catch (NoSuchElementException e) {
            Assert.fail(by + " NOT FOUND!");
        }
        return element;
    }

    public void hardWait(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException ie) {

        }
    }

    public static void highlightelement(By by) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid blue'", driver.findElement(by));
    }

    public WebElement waitForElementClickable(final By locator) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIME_OUT);
        WebElement element = null;
        try {
            element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            Assert.fail("Element " + locator + " not found");
        }
        return element;
    }

    public void waitForElement(final By locator) {
        try {
            new FluentWait<>(driver)
                    .withTimeout(FLUENT_WAIT, TimeUnit.SECONDS)
                    .pollingEvery(10, TimeUnit.MILLISECONDS)
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class)
                    .until(new Predicate<WebDriver>() {

                        public boolean apply(WebDriver driver) {
                            return (driver.findElement(locator).isDisplayed());
                        }
                    });
        } catch (Exception e) {
            Assert.fail("Element " + locator + " not found");
        }
    }

    public void hoverBy(By by)  {
        try {
            highlightelement(by);
            Actions selAction = new Actions(driver);
            selAction.moveToElement(findElement(by)).perform();
        }
        catch(TimeoutException e){

        }
    }

    public boolean isElementExist(By by, long d) {
        WebElement element = null;
        try {
            driver.manage().timeouts().implicitlyWait(d, TimeUnit.SECONDS);
            element = driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void click(By by) {
        int counter = 1;
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIME_OUT);
        while(counter<=3) {
            try {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
                waitForElementClickable(by);
                element.getTagName();
                highlightelement(by);
                element.click();
                break;
            } catch (Exception e) {
                hardWait(3);
                counter++;
            }
        }
        if(counter>3) {
            Assert.fail("Element " + by + " is not displayed");
        }
    }

    public String getText(By by) {
        WebElement element = null;
        String strText = "";
        element = findElement(by);
        highlightelement(by);
        if (element != null) {
            if (element.isDisplayed()) {
                strText = element.getText();
            } else {
                Assert.fail("Element " + element + " is not displayed");
            }
        } else {
        }
        return strText;
    }

    public boolean isElementExist(By by) {
        @SuppressWarnings("unused")
        WebElement element = null;
        driver.findElements(by).size();
        return driver.findElements(by).size() > 0 ? true : false;
    }

    public void scrollToView(By by) {
        WebElement element;
        element = findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
