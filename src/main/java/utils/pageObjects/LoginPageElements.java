package utils.pageObjects;

public interface LoginPageElements {
    String loginText = "//h1[text()='Log in to Trello']";
    String emailField = "user";
    String passwordField = "password";
    //String passwordField = "//input[@id='password']";
    String loginButtonUsername = "login";
    String loginButtonPassword = "login-submit";
}
