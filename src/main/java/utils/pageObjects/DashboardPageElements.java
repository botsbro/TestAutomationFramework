package utils.pageObjects;

public interface DashboardPageElements {

    String navBar = "header";
    String accountDropdown = "//button[@data-test-id='header-member-menu-button']";
    String settingsButton = "//a[@data-test-id='header-member-menu-settings']";
    String createBoardButton = "//li[@data-test-id='create-board-tile']";
    String boardTitleField = "//input[@data-test-id='create-board-title-input']";
    String confirmCreateBoardButton = "//button[@data-test-id='create-board-submit-button']";
}
