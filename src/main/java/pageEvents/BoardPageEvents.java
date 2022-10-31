package pageEvents;

import pageObjects.BoardPageElements;
import utils.ElementFetch;
import org.testng.Assert;

public class BoardPageEvents {
    public void verifyBoardPageIsOpen(){
        ElementFetch elementFetch = new ElementFetch();
        Assert.assertTrue(elementFetch.getListWebElements("XPATH", BoardPageElements.boardPageTitle).size()>0);
    }
}
