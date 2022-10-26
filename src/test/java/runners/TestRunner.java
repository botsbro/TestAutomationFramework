package test.java.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.CucumberFeatureWrapper;
import org.testng.annotations.*;

import java.util.Arrays;

@CucumberOptions(
        features = "src/test/resources/",
        glue = {"stepDefinitions", "runners"},
        monochrome = true,
        tags = ""
)
public class TestRunner extends AbstractTestNGCucumberTests{

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void SetUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs cucumber feature", dataProvider = "provideFeatures")
    public void featureGet(CucumberFeatureWrapper cucumberFeature){
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] provideFeatures(){
        if(testNGCucumberRunner == null){
            testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        }
        System.out.println(Arrays.deepToString(testNGCucumberRunner.provideFeatures()));
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void finishClass() throws Exception {
        testNGCucumberRunner.finish();
    }


}
