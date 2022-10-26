package main.java.pageEvents;

//import graphql.Assert;
import main.java.pageObjects.BoardPageElements;
import main.java.utils.ElementFetch;
import org.testng.Assert;
import test.java.stepDefinitions.CommonTest;

public class BoardPageEvents {
    public void verifyBoardPageIsOpen(){
        ElementFetch elementFetch = new ElementFetch();
        CommonTest.logger.info("Checking that board page is open");
        Assert.assertTrue(elementFetch.getListWebElements("XPATH", BoardPageElements.boardPageTitle).size()>0);
    }
}
