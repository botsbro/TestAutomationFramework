package main.java.pageEvents;

import main.java.pageObjects.CalculatorElements;
import main.java.pageObjects.ClockAppElements;
import main.java.utils.ElementFetch;
import org.testng.Assert;
import test.java.stepDefinitions.CommonTest;

public class ClockAppEvents {

    public void verifyClockAppIsOpen(){
        ElementFetch elementFetch = new ElementFetch();
        CommonTest.logger.info("Checking that Clock app is open");
        Assert.assertTrue(elementFetch.getListAndroidAppElements("ID", ClockAppElements.timerTab).size()>0);
    }

    public void goToTimerTab(){
        ElementFetch elementFetch = new ElementFetch();
        CommonTest.logger.info("Clicking TimerTab");
        elementFetch.getAndroidAppElement("ID", ClockAppElements.timerTab).click();
    }

    public void setTenSecondTimer(){
        ElementFetch elementFetch = new ElementFetch();
        CommonTest.logger.info("Setting Timer");
        elementFetch.getAndroidAppElement("ID", ClockAppElements.number1).click();
        elementFetch.getAndroidAppElement("ID", ClockAppElements.number0).click();
    }

    public void clickPlayTimerButton(){
        ElementFetch elementFetch = new ElementFetch();
        CommonTest.logger.info("Clicking Play Timer button");
        elementFetch.getAndroidAppElement("ID", ClockAppElements.playTimerButton).click();
    }

    public void waitTenSeconds(){
        ElementFetch elementFetch = new ElementFetch();
        CommonTest.logger.info("Waiting 10 seconds for timer");
        //elementFetch.waitForAppElement("ID", ClockAppElements.playTimerButton, 10);
        elementFetch.androidHardWait(11);
        Assert.assertTrue(Integer.parseInt(elementFetch.getAndroidAppElement("ID", ClockAppElements.activeTimerText).getText()) < 0);
    }

    public void verifyTimerHasFinished(){
        ElementFetch elementFetch = new ElementFetch();
        CommonTest.logger.info("Verifying timer has progressed past 10 seconds");
        Assert.assertTrue(Integer.parseInt(elementFetch.getAndroidAppElement("ID", ClockAppElements.activeTimerText).getText()) < 0);
    }

    public void closeTimer(){
        ElementFetch elementFetch = new ElementFetch();
        CommonTest.logger.info("Closing timer");
        elementFetch.getAndroidAppElement("ID", ClockAppElements.closeTimerButton).click();

    }

}
