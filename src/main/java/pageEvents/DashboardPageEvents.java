package main.java.pageEvents;

import main.java.pageObjects.DashboardPageElements;
import main.java.pageObjects.LoginPageElements;
import main.java.utils.Constants;
import main.java.utils.ElementFetch;
import org.testng.Assert;
import test.java.stepDefinitions.CommonTest;

public class DashboardPageEvents {

    public void verifyDashboardPageIsOpen(String browserName){
        ElementFetch elementFetch = new ElementFetch();
        CommonTest.logger.info("Checking that dashboard page is open");
        if ((browserName.equalsIgnoreCase("chrome")) || (browserName.equalsIgnoreCase("firefox"))) {
            Assert.assertTrue(elementFetch.getListWebElements("ID", DashboardPageElements.navBar).size() > 0);
        }
        else if (browserName.equalsIgnoreCase("android")){
            Assert.assertTrue(elementFetch.getListAndroidAppElements("ID", DashboardPageElements.navBar).size() > 0);
        }
    }

    public void openAccountDropdown(){
        ElementFetch elementFetch = new ElementFetch();
        CommonTest.logger.info("Opening account dropdown menu");
        elementFetch.getWebElement("XPATH", DashboardPageElements.accountDropdown).click();
    }

    public void goToSettingsPage(){
        ElementFetch elementFetch = new ElementFetch();
        CommonTest.logger.info("Going to account settings");
        elementFetch.getWebElement("XPATH", DashboardPageElements.settingsButton).click();
    }

    public void clickCreateBoard(){
        ElementFetch elementFetch = new ElementFetch();
        CommonTest.logger.info("Clicking create board button");
        elementFetch.getWebElement("XPATH", DashboardPageElements.createBoardButton).click();
    }

    public void enterNameForBoard(){
        ElementFetch elementFetch = new ElementFetch();
        CommonTest.logger.info("Entering board name");
        elementFetch.getWebElement("XPATH", DashboardPageElements.boardTitleField).sendKeys("CreateTest");
    }

    public void confirmCreateBoard(){
        ElementFetch elementFetch = new ElementFetch();
        CommonTest.logger.info("Clicking 2nd create board button");
        elementFetch.getWebElement("XPATH", DashboardPageElements.confirmCreateBoardButton).click();
    }


}
