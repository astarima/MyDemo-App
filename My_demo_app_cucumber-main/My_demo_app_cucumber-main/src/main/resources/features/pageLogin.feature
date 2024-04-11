@setUp #tags
Feature: Login/Logout page functionality


  Background:
    Given User is on Login page


  @Login
  Scenario: User  successfully logs in and is redirected to Products page
    When User enters valid username
    And User enters valid password
    And User clicks Login button
    Then User is on "Products" page

  @BadLogin
  Scenario: User unsuccessfully logs in with not valid username and password
    When User enters not valid Username
    And User enters not valid Password
    And User clicks Login button
    Then User gets error message

  @BadLogin
  Scenario: User unsuccessfully logs in with locked out user credentials
    When User enters locked out user credentials
    And User enters valid password
    And User clicks Login button
    Then User gets error message Sorry

