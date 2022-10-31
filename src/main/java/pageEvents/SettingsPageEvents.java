package pageEvents;

import pageObjects.SettingsPageElements;
import utils.ElementFetch;
import org.testng.Assert;

public class SettingsPageEvents {

    public void verifySettingsPageIsOpen(){
        ElementFetch elementFetch = new ElementFetch();
        Assert.assertTrue(elementFetch.getListWebElements("XPATH", SettingsPageElements.settingsTabActive).size()>0);
    }
}
