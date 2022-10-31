package pageEvents;

import pageObjects.HomePageElements;
import utils.ElementFetch;

public class HomePageEvents {
    public void clickOnSignInButton(String testType){
        ElementFetch elementFetch = new ElementFetch();
        if ((testType.equalsIgnoreCase("chrome")) || (testType.equalsIgnoreCase("firefox"))){
            elementFetch.getWebElement("XPATH", HomePageElements.signInButton).click();
        }else if (testType.equalsIgnoreCase("android")){
            elementFetch.getAndroidAppElement("XPATH", HomePageElements.mobileMenuButton).click();
            elementFetch.getAndroidAppElement("XPATH", HomePageElements.mobileSignInButton).click();
        }
    }
}
