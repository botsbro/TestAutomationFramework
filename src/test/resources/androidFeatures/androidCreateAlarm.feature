Feature: Create alarm clock
  Scenario: User should be able to set an alarm clock
    Given the clock app is open
    When the user goes to the Timer tab
    And sets a 10 second timer
    And clicks the play button
    And waits 10 seconds
    Then the user will be prompted to stop the timer