package pageEvents;

import pageObjects.DashboardPageElements;
import utils.Constants;
import utils.ElementFetch;
import org.testng.Assert;

public class DashboardPageEvents {

    public void verifyDashboardPageIsOpen(String browserName){
        ElementFetch elementFetch = new ElementFetch();
        if ((browserName.equalsIgnoreCase("chrome")) || (browserName.equalsIgnoreCase("firefox"))) {
            Assert.assertTrue(elementFetch.getListWebElements("ID", DashboardPageElements.navBar).size() > 0);
        }
        else if (browserName.equalsIgnoreCase("android")){
            Assert.assertTrue(elementFetch.getListAndroidAppElements("ID", DashboardPageElements.navBar).size() > 0);
        }
    }

    public void openAccountDropdown(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("XPATH", DashboardPageElements.accountDropdown).click();
    }

    public void goToSettingsPage(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("XPATH", DashboardPageElements.settingsButton).click();
    }

    public void clickCreateBoard(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("XPATH", DashboardPageElements.createBoardButton).click();
    }

    public void enterNameForBoard(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("XPATH", DashboardPageElements.boardTitleField).sendKeys("CreateTest");
    }

    public void confirmCreateBoard(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("XPATH", DashboardPageElements.confirmCreateBoardButton).click();
    }


}
