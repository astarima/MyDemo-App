@setUp #tags
Feature: Checkout page functionality

  Background:
    Given User is on Login page
    Given User is logged in
    Given User puts item in a cart and goes to checkout page

  @Shipping
  Scenario: User enters shipping address
    When User fills in shipping address fields
    When User clicks the To Payment button
    Then User is navigated to the Checkout page

  @Payment
  Scenario: User enters payment method
    When User fills in shipping address fields
    When User clicks the To Payment button
    Then User is navigated to the Checkout page
    When User fills in the payment method fields
    And User clicks the Review Order button
    Then User is navigated to the review order page

  @Review
  Scenario: User completes Checkout
    When User fills in shipping address fields
    When User clicks the To Payment button
    Then User is navigated to the Checkout page
    When User fills in the payment method fields
    And User clicks the Review Order button
    Then User is navigated to the review order page
    When User checks all details are correct
    And User clicks the Place Order button
    Then User received a message

  @Continue
  Scenario: User continue shopping
    When User fills in shipping address fields
    When User clicks the To Payment button
    Then User is navigated to the Checkout page
    When User fills in the payment method fields
    And User clicks the Review Order button
    Then User is navigated to the review order page
    When User checks all details are correct
    And User clicks the Place Order button
    Then User received a message
    When User clicks the Continue Shopping button
    Then User is redirected to the main shopping page