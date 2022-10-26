package main.java.pageEvents;

import main.java.pageObjects.HomePageElements;
import main.java.utils.ElementFetch;
import test.java.stepDefinitions.CommonTest;

public class HomePageEvents {
    public void clickOnSignInButton(String testType){
        ElementFetch elementFetch = new ElementFetch();
        CommonTest.logger.info("Clicking on sign in button");
        if ((testType.equalsIgnoreCase("chrome")) || (testType.equalsIgnoreCase("firefox"))){
            elementFetch.getWebElement("XPATH", HomePageElements.signInButton).click();
        }else if (testType.equalsIgnoreCase("android")){
            elementFetch.getAndroidAppElement("XPATH", HomePageElements.mobileMenuButton).click();
            elementFetch.getAndroidAppElement("XPATH", HomePageElements.mobileSignInButton).click();
        }
    }
}
