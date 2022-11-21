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
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Constants;
import utils.DriverBuilder;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@CucumberOptions(
        features = "src/test/resources/androidFeatures/",
        glue = {"stepDefinitions", "runners"},
        monochrome = true,
        tags = ""
)
public class AndroidRunner extends AbstractTestNGCucumberTests{

    public ExtentSparkReporter htmlReporter; //was ExtentHtmlReporter. Now called ExtentSparkReporter in extentreports ver 5.0.x
    public static ExtentReports extent;
    public static ExtentTest logger;

    public void setupDriver() throws MalformedURLException, InterruptedException{
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, Constants.phoneOSVersion);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, Constants.phoneName);
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        caps.setCapability("chromedriverExecutable", "C:\\Users\\tom\\IdeaProjects\\TomBotsfordAutomationFramework2022\\drivers\\chromedriver.exe");
        caps.setCapability(MobileCapabilityType.APP, "com.android." + Constants.mobileAppName);
        URL url = new URL(Constants.appiumURL);
        DriverBuilder.androidDriver = new AndroidDriver<MobileElement>(url, caps);
    }

    @BeforeTest
    public void beforeTestMethod(){
        Constants.testType = "android";
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
        //DriverBuilder.androidDriver.manage().window().maximize();
        //DriverBuilder.androidDriver.get(Constants.url);
        DriverBuilder.androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        DriverBuilder.androidDriver.quit();
    }
}