package main.java.pageEvents;

import main.java.pageObjects.LoginPageElements;
import main.java.utils.Constants;
import main.java.utils.ElementFetch;
import org.testng.Assert;
import test.java.stepDefinitions.CommonTest;

public class LoginPageEvents {

    public void verifyLoginPageIsOpen(String testType){
        ElementFetch elementFetch = new ElementFetch();
        CommonTest.logger.info("Checking that login page is open");
        if ((testType.equalsIgnoreCase("chrome")) || (testType.equalsIgnoreCase("firefox"))) {
            Assert.assertTrue(elementFetch.getListWebElements("XPATH", LoginPageElements.loginText).size() > 0);
        }
        else if (testType.equalsIgnoreCase("android")){
            Assert.assertTrue(elementFetch.getListWebElements("XPATH", LoginPageElements.loginText).size() > 0);
        }
    }

    public void enterLoginCredentials(String testType){
        ElementFetch elementFetch = new ElementFetch();
        CommonTest.logger.info("Entering email address");
        if ((testType.equalsIgnoreCase("chrome")) || (testType.equalsIgnoreCase("firefox"))) {
            elementFetch.getWebElement("ID", LoginPageElements.emailField).sendKeys(Constants.emailAddress);
            elementFetch.getWebElement("ID", LoginPageElements.loginButtonUsername).click();
            elementFetch.getWebElement("ID", LoginPageElements.passwordField).sendKeys(Constants.password);
        }
        else if (testType.equalsIgnoreCase("android")){
            elementFetch.getAndroidAppElement("ID", LoginPageElements.emailField).sendKeys(Constants.emailAddress);
            elementFetch.getAndroidAppElement("ID", LoginPageElements.loginButtonUsername).click();
            elementFetch.getAndroidAppElement("ID", LoginPageElements.passwordField).sendKeys(Constants.password);
        }

    }

    public void submitLoginCredentials(String testType){
        ElementFetch elementFetch = new ElementFetch();
        CommonTest.logger.info("Clicking log in button");
        if ((testType.equalsIgnoreCase("chrome")) || (testType.equalsIgnoreCase("firefox"))) {
            elementFetch.getWebElement("ID", LoginPageElements.loginButtonPassword).click();
        }
        else if (testType.equalsIgnoreCase("android")){
            elementFetch.getAndroidAppElement("ID", LoginPageElements.loginButtonPassword).click();
        }
    }
}
