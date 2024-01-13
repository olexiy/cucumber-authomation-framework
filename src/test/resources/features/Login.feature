@login
Feature: WebDriver University - Login page

  Background:
    Given I open login page


  Scenario Outline: Validate - Successful & Unsuccessful Login
    When I enter a username <username>
    And I enter a password <password>
    And I click login button
    Then I should be presented with the following validation message <loginValidationMessage>
    Examples:
      | username  | password      | loginValidationMessage |
      | webdriver | webdriver123  | validation succeeded   |
      | webdriver1| webdriver123  | validation failed      |
      | webdriver | wrongpassword | validation failed      |