package pageEvents;

import utils.pageObjects.LoginPageElements;
import utils.Constants;
import utils.ElementFetch;
import org.testng.Assert;


public class LoginPageEvents {

    public void verifyLoginPageIsOpen(){
        ElementFetch elementFetch = new ElementFetch();
        if ((Constants.testType.equalsIgnoreCase("chrome")) || (Constants.testType.equalsIgnoreCase("firefox"))) {
            Assert.assertTrue(elementFetch.getListWebElements("XPATH", LoginPageElements.loginText).size() > 0);
        }
        else if (Constants.testType.equalsIgnoreCase("android")){
            Assert.assertTrue(elementFetch.getListWebElements("XPATH", LoginPageElements.loginText).size() > 0);
        }
    }

    public void enterLoginCredentials(){
        ElementFetch elementFetch = new ElementFetch();
        if ((Constants.testType.equalsIgnoreCase("chrome")) || (Constants.testType.equalsIgnoreCase("firefox"))) {
            elementFetch.getWebElement("ID", LoginPageElements.emailField).sendKeys(Constants.emailAddress);
            elementFetch.getWebElement("ID", LoginPageElements.loginButtonUsername).click();
            Assert.assertTrue(elementFetch.getListWebElements("XPATH", LoginPageElements.passwordScreenText).size() > 0);
            elementFetch.getWebElement("ID", LoginPageElements.passwordField).sendKeys(Constants.password);
        }
        else if (Constants.testType.equalsIgnoreCase("android")){
            elementFetch.getAndroidAppElement("ID", LoginPageElements.emailField).sendKeys(Constants.emailAddress);
            elementFetch.getAndroidAppElement("ID", LoginPageElements.loginButtonUsername).click();
            Assert.assertTrue(elementFetch.getListWebElements("XPATH", LoginPageElements.passwordScreenText).size() > 0);
            elementFetch.getAndroidAppElement("ID", LoginPageElements.passwordField).sendKeys(Constants.password);
        }

    }

    public void submitLoginCredentials(){
        ElementFetch elementFetch = new ElementFetch();
        if ((Constants.testType.equalsIgnoreCase("chrome")) || (Constants.testType.equalsIgnoreCase("firefox"))) {
            elementFetch.getWebElement("ID", LoginPageElements.loginButtonPassword).click();
        }
        else if (Constants.testType.equalsIgnoreCase("android")){
            elementFetch.getAndroidAppElement("ID", LoginPageElements.loginButtonPassword).click();
        }
    }
}
