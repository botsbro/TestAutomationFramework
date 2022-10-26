package main.java.pageEvents;

//import graphql.Assert;
import main.java.pageObjects.SettingsPageElements;
import main.java.utils.ElementFetch;
import org.testng.Assert;
import test.java.stepDefinitions.CommonTest;

public class SettingsPageEvents {

    public void verifySettingsPageIsOpen(){
        ElementFetch elementFetch = new ElementFetch();
        CommonTest.logger.info("Checking that settings page is open");
        Assert.assertTrue(elementFetch.getListWebElements("XPATH", SettingsPageElements.settingsTabActive).size()>0);
    }
}
