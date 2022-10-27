package main.java.pageEvents;

import main.java.pageObjects.CalculatorElements;
import main.java.pageObjects.DashboardPageElements;
import main.java.pageObjects.LoginPageElements;
import main.java.utils.Constants;
import main.java.utils.ElementFetch;
import org.testng.Assert;
import test.java.stepDefinitions.CommonTest;

import java.util.Objects;

public class CalculatorEvents {

    public void verifyCalculatorIsOpen(){
        ElementFetch elementFetch = new ElementFetch();
        CommonTest.logger.info("Checking that calculator page is open");
        Assert.assertTrue(elementFetch.getListDesktopAppElements("ID", CalculatorElements.output).size()>0);
    }

    public void multiplyNumbers(){
        ElementFetch elementFetch = new ElementFetch();
        CommonTest.logger.info("Multiplying two numbers");
        elementFetch.getDesktopAppElement("NAME", CalculatorElements.number2).click();
        elementFetch.getDesktopAppElement("ID",CalculatorElements.multiply).click();
        elementFetch.getDesktopAppElement("NAME",CalculatorElements.number3).click();
    }

    public void clickEquals(){
        ElementFetch elementFetch = new ElementFetch();
        CommonTest.logger.info("Clicking equals");
        elementFetch.getDesktopAppElement("ID", CalculatorElements.equals).click();
    }

    public void verifyAnswer(){
        ElementFetch elementFetch = new ElementFetch();
        CommonTest.logger.info("Checking answer is correct");
        Assert.assertTrue(Objects.equals(elementFetch.getDesktopAppElement("ID", CalculatorElements.output).getText(), "6"));
    }


}
