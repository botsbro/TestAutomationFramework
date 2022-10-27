package test.java.stepDefinitions;

import gherkin.lexer.Ca;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import main.java.pageEvents.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.lang.reflect.Method;

public class Steps extends CommonTest {

    HomePageEvents homePageEvents = new HomePageEvents();
    LoginPageEvents loginPageEvents = new LoginPageEvents();
    DashboardPageEvents dashboardPageEvents = new DashboardPageEvents();
    BoardPageEvents boardPageEvents = new BoardPageEvents();
    SettingsPageEvents settingsPageEvents = new SettingsPageEvents();
    CalculatorEvents calculatorEvents = new CalculatorEvents();
    ClockAppEvents clockAppEvents = new ClockAppEvents();
    ZippopotamusEvents zippopotamusEvents = new ZippopotamusEvents();


    //Trello login
    @Given("the user is on the login page")
    @Parameters(value = {"testType"})
    public void check_user_is_on_login_page (String testType) {
            homePageEvents.clickOnSignInButton(testType);
            loginPageEvents.verifyLoginPageIsOpen(testType);
    }
    @When("the user enters valid credentials")
    @Parameters(value = {"testType"})
    public void enter_login_credentials(String testType) {
        loginPageEvents.enterLoginCredentials(testType);
    }
    @And("clicks submit")
    @Parameters(value = {"testType"})
    public void click_login_submit(String testType) {
        loginPageEvents.submitLoginCredentials(testType);
    }
    @Then("the user should be logged in")
    @Parameters(value = {"testType"})
    public void check_user_is_logged_in(String testType) {
        dashboardPageEvents.verifyDashboardPageIsOpen(testType);
    }


    //Trello go to settings
    @Given("the user is on the dashboard page")
    @Parameters(value = {"testType"})
    public void check_user_is_on_dashboard_page(String testType) {
        dashboardPageEvents.verifyDashboardPageIsOpen(testType);
    }
    @When("the user clicks on the account dropdown button")
    public void click_account_dropdown() {
        dashboardPageEvents.openAccountDropdown();
    }
    @And("clicks settings")
    public void click_settings_link() {
        dashboardPageEvents.goToSettingsPage();
    }
    @Then("the user should be taken to the settings page")
    public void check_user_is_on_settings_page() {
        settingsPageEvents.verifySettingsPageIsOpen();
    }


    //Trello create board
    @When("the user clicks on the create board button")
    public void click_create_board_button() {
        dashboardPageEvents.clickCreateBoard();
    }
    @And("enters a name for the board")
    public void enter_name_for_board() {
        dashboardPageEvents.enterNameForBoard();
    }
    @And("clicks the second create button")
    public void click_confirm_create_board() {
        dashboardPageEvents.confirmCreateBoard();
    }
    @Then("a board should be created and the user should be taken to the board page")
    public void check_user_is_on_board_page(){
        boardPageEvents.verifyBoardPageIsOpen();
    }


    //Calculator multiply
    @Given("the calculator is open")
    public void check_calculator_is_open(){
        calculatorEvents.verifyCalculatorIsOpen();
    }
    @When("the user multiplies two numbers")
    public void multiply_two_numbers(){
        calculatorEvents.multiplyNumbers();
    }
    @And("clicks equals")
    public void click_equals() {
        calculatorEvents.clickEquals();
    }
    @Then("the two numbers should be multiplied correctly")
    public void check_numbers_are_multiplied(){
        calculatorEvents.verifyAnswer();
    }


    //Android timer
    @Given("the clock app is open")
    public void check_clock_app_is_open(){clockAppEvents.verifyClockAppIsOpen();}
    @When("the user goes to the Timer tab")
    public void go_to_timer_tab(){clockAppEvents.goToTimerTab();}
    @And("sets a 10 second timer")
    public void set_a_ten_second_timer(){clockAppEvents.setTenSecondTimer();}
    @And("clicks the play button")
    public void click_the_timer_play_button(){clockAppEvents.clickPlayTimerButton();}
    @And("waits 10 seconds")
    public void wait_10_seconds(){clockAppEvents.waitTenSeconds();}
    @Then("the user will be prompted to stop the timer")
    public void check_for_stop_timer_prompt(){
        clockAppEvents.verifyTimerHasFinished();
        clockAppEvents.closeTimer();
    }


    //API get postcode from place name
    @Given("^the user is requesting from (.*)$")
    public void set_api_url(String url) {
        zippopotamusEvents.setApiURL(url);
    }
    @When("the user sends an API request")
    public void send_API_request(){
        zippopotamusEvents.sendApiRequest();
    }
    @Then("^the API should return details for (.*)$")
    public void check_for_correct_place_name(String expectedPlaceName){
        zippopotamusEvents.checkForCorrectPlaceName(expectedPlaceName);
    }
    @And("^the API should return the postcode (.*)$")
    public void check_for_correct_postcode(String expectedPostcode){
        zippopotamusEvents.checkForCorrectPostcode(expectedPostcode);
    }

    @Then("the API should return a HTTP status code of {string}")
    public void check_api_returns_valid_status_code(int expectedStatusCode) {
        zippopotamusEvents.checkForCorrectStatusCode(expectedStatusCode);
    }
}
