package pageEvents;

import utils.pageObjects.ClockAppElements;
import utils.ElementFetch;
import org.testng.Assert;

public class ClockAppEvents {

    public void verifyClockAppIsOpen(){
        ElementFetch elementFetch = new ElementFetch();
        Assert.assertTrue(elementFetch.getListAndroidAppElements("ID", ClockAppElements.timerTab).size()>0);
    }

    public void goToTimerTab(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getAndroidAppElement("ID", ClockAppElements.timerTab).click();
    }

    public void setTenSecondTimer(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getAndroidAppElement("ID", ClockAppElements.number1).click();
        elementFetch.getAndroidAppElement("ID", ClockAppElements.number0).click();
    }

    public void clickPlayTimerButton(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getAndroidAppElement("ID", ClockAppElements.playTimerButton).click();
    }

    public void waitTenSeconds(){
        ElementFetch elementFetch = new ElementFetch();
        //elementFetch.waitForAppElement("ID", ClockAppElements.playTimerButton, 10);
        elementFetch.androidHardWait(11);
        Assert.assertTrue(Integer.parseInt(elementFetch.getAndroidAppElement("ID", ClockAppElements.activeTimerText).getText()) < 0);
    }

    public void verifyTimerHasFinished(){
        ElementFetch elementFetch = new ElementFetch();
        Assert.assertTrue(Integer.parseInt(elementFetch.getAndroidAppElement("ID", ClockAppElements.activeTimerText).getText()) < 0);
    }

    public void closeTimer(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getAndroidAppElement("ID", ClockAppElements.closeTimerButton).click();

    }

}
