package pageEvents;

import pageObjects.CalculatorElements;
import utils.Constants;
import utils.ElementFetch;
import org.testng.Assert;


import java.util.Objects;

public class CalculatorEvents {

    public void verifyCalculatorIsOpen(){
        ElementFetch elementFetch = new ElementFetch();
        Assert.assertTrue(elementFetch.getListDesktopAppElements("ID", CalculatorElements.output).size()>0);
    }

    public void multiplyNumbers(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getDesktopAppElement("NAME", CalculatorElements.number2).click();
        elementFetch.getDesktopAppElement("ID",CalculatorElements.multiply).click();
        elementFetch.getDesktopAppElement("NAME",CalculatorElements.number3).click();
    }

    public void clickEquals(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getDesktopAppElement("ID", CalculatorElements.equals).click();
    }

    public void verifyAnswer(){
        ElementFetch elementFetch = new ElementFetch();
        Assert.assertTrue(Objects.equals(elementFetch.getDesktopAppElement("ID", CalculatorElements.output).getText(), "6"));
    }


}
