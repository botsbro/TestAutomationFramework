package main.java.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.stepDefinitions.CommonTest;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ElementFetch {

    public WebElement getWebElement(String identifierType, String identifierValue){
        switch (identifierType){
            case "ID":
                return CommonTest.driver.findElement(By.id(identifierValue));
            case "CSS":
                return CommonTest.driver.findElement(By.cssSelector(identifierValue));
            case "NAME":
                return CommonTest.driver.findElement(By.name(identifierValue));
            case "XPATH":
                return CommonTest.driver.findElement(By.xpath(identifierValue));
            default:
                return null;
        }
    }
    public List<WebElement> getListWebElements(String identifierType, String identifierValue){
        switch (identifierType){
            case "ID":
                return CommonTest.driver.findElements(By.id(identifierValue));
            case "CSS":
                return CommonTest.driver.findElements(By.cssSelector(identifierValue));
            case "NAME":
                return CommonTest.driver.findElements(By.name(identifierValue));
            case "XPATH":
                return CommonTest.driver.findElements(By.xpath(identifierValue));
            default:
                return null;
        }
    }
    public WebElement getDesktopAppElement(String identifierType, String identifierValue){
        switch (identifierType){
            case "ID":
                return CommonTest.desktopDriver.findElement(By.id(identifierValue));
            case "CSS":
                return CommonTest.desktopDriver.findElement(By.cssSelector(identifierValue));
            case "TAGNAME":
                return CommonTest.desktopDriver.findElement(By.tagName(identifierValue));
            case "XPATH":
                return CommonTest.desktopDriver.findElement(By.xpath(identifierValue));
            default:
                return null;
        }
    }
    public List<WebElement> getListDesktopAppElements(String identifierType, String identifierValue){
        switch (identifierType){
            case "ID":
                return CommonTest.desktopDriver.findElements(By.id(identifierValue));
            case "CSS":
                return CommonTest.desktopDriver.findElements(By.cssSelector(identifierValue));
            case "TAGNAME":
                return CommonTest.desktopDriver.findElements(By.tagName(identifierValue));
            case "XPATH":
                return CommonTest.desktopDriver.findElements(By.xpath(identifierValue));
            default:
                return null;
        }
    }
    public WebElement getAndroidAppElement(String identifierType, String identifierValue){
        switch (identifierType){
            case "ID":
                return CommonTest.androidDriver.findElement(By.id(identifierValue));
            case "CSS":
                return CommonTest.androidDriver.findElement(By.cssSelector(identifierValue));
            case "TAGNAME":
                return CommonTest.androidDriver.findElement(By.tagName(identifierValue));
            case "XPATH":
                return CommonTest.androidDriver.findElement(By.xpath(identifierValue));
            default:
                return null;
        }
    }
    public List<WebElement> getListAndroidAppElements(String identifierType, String identifierValue){
        switch (identifierType){
            case "ID":
                return CommonTest.androidDriver.findElements(By.id(identifierValue));
            case "CSS":
                return CommonTest.androidDriver.findElements(By.cssSelector(identifierValue));
            case "TAGNAME":
                return CommonTest.androidDriver.findElements(By.tagName(identifierValue));
            case "XPATH":
                return CommonTest.androidDriver.findElements(By.xpath(identifierValue));
            default:
                return null;
        }
    }

    public WebElement waitForAppElement(String identifierType, String identifierValue, int timeToWait) {
        switch (identifierType) {
            case "ID":
                WebElement elementToWaitFor = new WebDriverWait(CommonTest.androidDriver, Duration.ofSeconds(timeToWait)).until(ExpectedConditions.elementToBeClickable(By.id(identifierValue)));
                return elementToWaitFor;
            default:
                return null;
        }
    }

    public void androidHardWait(int timeToWait) {
        CommonTest.androidDriver.manage().timeouts().implicitlyWait(timeToWait, TimeUnit.SECONDS);
    }


}
