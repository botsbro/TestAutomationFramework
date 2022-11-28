package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.*;

public class DriverBuilder {

    public static WebDriver driver;
    public static WiniumDriver desktopDriver;
    public static AndroidDriver androidDriver;

    static
    {
        buildDrivers();
    }

    private static void buildDrivers()
    {

    }
}
