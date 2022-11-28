package runners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Constants;
import utils.DriverBuilder;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@CucumberOptions(
        features = "src/test/resources/desktopFeatures/",
        glue = {"stepDefinitions", "runners"},
        monochrome = true,
        tags = ""
)
public class DesktopRunner extends AbstractTestNGCucumberTests{

    public static DesktopOptions options = new DesktopOptions();
    public ExtentSparkReporter htmlReporter; //was ExtentHtmlReporter. Now called ExtentSparkReporter in extentreports ver 5.0.x
    public static ExtentReports extent;
    public static ExtentTest logger;

    public void setupDriver() throws MalformedURLException, InterruptedException{
        System.setProperty("Winium.Desktop.driver", "C:\\Users\\tom\\IdeaProjects\\TomBotsfordAutomationFramework2022\\drivers\\Winium.Desktop.Driver.exe");
        DriverBuilder.desktopDriver = new WiniumDriver(new URL("http://localhost:9999"), options);
        options.setApplicationPath(Constants.appPath);
    }

    @BeforeTest
    public void beforeTestMethod(){
        Constants.testType = "desktop";
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "AutomationReport.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Automation Test Results");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester", Constants.nameOfTester);
    }

    @BeforeMethod
    public void beforeMethodMethod(Method testMethod) throws MalformedURLException, InterruptedException {
        logger = extent.createTest(testMethod.getName());
        setupDriver();
        DriverBuilder.desktopDriver.manage().window().maximize();
        DriverBuilder.desktopDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void afterTestMethod() {
        extent.flush();
    }

    @AfterMethod
    public void afterMethodMethod(ITestResult result){
        if(result.getStatus() == ITestResult.SUCCESS){
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + "Passed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS,m);
        }
        else if(result.getStatus() == ITestResult.FAILURE){
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + "Failed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL,m);
        }
        else if(result.getStatus() == ITestResult.SKIP){
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + "Skipped";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
            logger.log(Status.SKIP,m);
        }
        DriverBuilder.desktopDriver.quit();
    }
}
