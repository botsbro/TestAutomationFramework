Feature: Login
  Scenario: User should be able to login with valid credentials
    Given the user is on the login page
    When the user enters valid credentials
    And clicks submit
    Then the user should be logged in