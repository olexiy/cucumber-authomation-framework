@login
Feature: WebDriver University - Login page

  Background:
    Given I open login page
    When I enter username as "webdriver"

  Scenario: Successful Login
    And I enter password as "webdriver123"
    And I click login button
    Then I should be presented with successful login message

  Scenario: Unsuccessful Login
    And I enter password as "wrongpassword"
    And I click login button
    Then I should be presented with unsuccessful login messages