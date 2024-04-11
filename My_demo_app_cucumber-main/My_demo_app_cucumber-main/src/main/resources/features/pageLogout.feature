@setUp #tags
Feature: Logout page functionality

  Background:
    Given User is on Login page
    Given User is logged in

  @LoggedOut
  Scenario: User successfully Logged out
    When User clicks menu button
    Then Log out is visible
    When User clicks Log Out button
    Then User gets a message
    When User clicks Logout button
    Then User gets popup with a message
    When User clicks “OK“
    Then User is on "Login" page

  @StillLogin
  Scenario: User still Logged in
    When User clicks menu button
    Then Log out is visible
    When User clicks Log Out button
    Then User gets a message
    When User clicks Cancel
    Then Log out is visible

