Feature: Fetch place name
  Scenario Outline: User should be able to retrieve the postcode of a place by its name
    Given the user is requesting from <URL>
    When the user sends an API request
    Then the API should return details for <placeName>
    Examples:
      |URL                                 |placeName         |postCode |
      |https://api.zippopotam.us/gb/wa12   |Earlestown        |WA12     |
      |https://api.zippopotam.us/gb/wa12   |Newton-le-Willows |WA12     |