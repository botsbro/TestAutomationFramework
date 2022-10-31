package stepDefinitions;

import gherkin.lexer.Ca;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import pageEvents.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import stepDefinitions.CommonTest;
import utils.PageBuilder;


import static io.restassured.RestAssured.*;

import java.lang.reflect.Method;

public class Steps extends CommonTest {


    //Trello login
    @Given("the user is on the login page")
    @Parameters(value = {"testType"})
    public void check_user_is_on_login_page (String testType) {
        PageBuilder.homePageEvents.clickOnSignInButton(testType);
        PageBuilder.loginPageEvents.verifyLoginPageIsOpen(testType);
    }
    @When("the user enters valid credentials")
    @Parameters(value = {"testType"})
    public void enter_login_credentials(String testType) {
        PageBuilder.loginPageEvents.enterLoginCredentials(testType);
    }
    @And("clicks submit")
    @Parameters(value = {"testType"})
    public void click_login_submit(String testType) {
        PageBuilder.loginPageEvents.submitLoginCredentials(testType);
    }
    @Then("the user should be logged in")
    @Parameters(value = {"testType"})
    public void check_user_is_logged_in(String testType) {
        PageBuilder.dashboardPageEvents.verifyDashboardPageIsOpen(testType);
    }


    //Trello go to settings
    @Given("the user is on the dashboard page")
    @Parameters(value = {"testType"})
    public void check_user_is_on_dashboard_page(String testType) {
        PageBuilder.dashboardPageEvents.verifyDashboardPageIsOpen(testType);
    }
    @When("the user clicks on the account dropdown button")
    public void click_account_dropdown() {
        PageBuilder.dashboardPageEvents.openAccountDropdown();
    }
    @And("clicks settings")
    public void click_settings_link() {
        PageBuilder.dashboardPageEvents.goToSettingsPage();
    }
    @Then("the user should be taken to the settings page")
    public void check_user_is_on_settings_page() {
        PageBuilder.settingsPageEvents.verifySettingsPageIsOpen();
    }


    //Trello create board
    @When("the user clicks on the create board button")
    public void click_create_board_button() {
        PageBuilder.dashboardPageEvents.clickCreateBoard();
    }
    @And("enters a name for the board")
    public void enter_name_for_board() {
        PageBuilder.dashboardPageEvents.enterNameForBoard();
    }
    @And("clicks the second create button")
    public void click_confirm_create_board() {
        PageBuilder.dashboardPageEvents.confirmCreateBoard();
    }
    @Then("a board should be created and the user should be taken to the board page")
    public void check_user_is_on_board_page(){
        PageBuilder.boardPageEvents.verifyBoardPageIsOpen();
    }


    //Calculator multiply
    @Given("the calculator is open")
    public void check_calculator_is_open(){
        PageBuilder.calculatorEvents.verifyCalculatorIsOpen();
    }
    @When("the user multiplies two numbers")
    public void multiply_two_numbers(){
        PageBuilder.calculatorEvents.multiplyNumbers();
    }
    @And("clicks equals")
    public void click_equals() {
        PageBuilder.calculatorEvents.clickEquals();
    }
    @Then("the two numbers should be multiplied correctly")
    public void check_numbers_are_multiplied(){
        PageBuilder.calculatorEvents.verifyAnswer();
    }


    //Android timer
    @Given("the clock app is open")
    public void check_clock_app_is_open(){PageBuilder.clockAppEvents.verifyClockAppIsOpen();}
    @When("the user goes to the Timer tab")
    public void go_to_timer_tab(){PageBuilder.clockAppEvents.goToTimerTab();}
    @And("sets a 10 second timer")
    public void set_a_ten_second_timer(){PageBuilder.clockAppEvents.setTenSecondTimer();}
    @And("clicks the play button")
    public void click_the_timer_play_button(){PageBuilder.clockAppEvents.clickPlayTimerButton();}
    @And("waits 10 seconds")
    public void wait_10_seconds(){PageBuilder.clockAppEvents.waitTenSeconds();}
    @Then("the user will be prompted to stop the timer")
    public void check_for_stop_timer_prompt(){
        PageBuilder.clockAppEvents.verifyTimerHasFinished();
        PageBuilder.clockAppEvents.closeTimer();
    }


    //API get postcode from place name
    @Given("^the user is requesting from (.*)$")
    public void set_api_url(String url) {
        PageBuilder.zippopotamusEvents.setApiURL(url);
    }
    @When("the user sends an API request")
    public void send_API_request(){
        PageBuilder.zippopotamusEvents.sendApiRequest();
    }
    @Then("^the API should return details for (.*)$")
    public void check_for_correct_place_name(String expectedPlaceName){
        PageBuilder.zippopotamusEvents.checkForCorrectPlaceName(expectedPlaceName);
    }
    @And("^the API should return the postcode (.*)$")
    public void check_for_correct_postcode(String expectedPostcode){
        PageBuilder.zippopotamusEvents.checkForCorrectPostcode(expectedPostcode);
    }

    @Then("the API should return a HTTP status code of {string}")
    public void check_api_returns_valid_status_code(int expectedStatusCode) {
        PageBuilder.zippopotamusEvents.checkForCorrectStatusCode(expectedStatusCode);
    }
}
