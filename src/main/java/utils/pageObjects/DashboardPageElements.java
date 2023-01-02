package utils.pageObjects;

public interface DashboardPageElements {

    String navBar = "header";
    String accountDropdown = "//button[@data-testid='header-member-menu-button']";
    String settingsButton = "//a[@data-testid='header-member-menu-settings']";
    String createBoardButton = "//li[@data-testid='create-board-tile']";
    String boardTitleField = "//input[@data-testid='create-board-title-input']";
    String confirmCreateBoardButton = "//button[@data-testid='create-board-submit-button']";
}
