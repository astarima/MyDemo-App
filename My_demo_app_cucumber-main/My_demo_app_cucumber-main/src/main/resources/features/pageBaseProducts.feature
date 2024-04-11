@setUp #tags
Feature: Products page functionality

  @DoTest
  Scenario Outline: User sorts products by various criteria
    Given User is on "Products" page
    When User clicks "sort button" button
    And User clicks "<sort by>" button
    Then First product title is "<title>"

    Examples:
      | sort by   | title                       |
      | nameAsc   | Sauce Labs Backpack         |
      | nameDesc  | Test.allTheThings() T-Shirt |
      | priceAsc  | Sauce Labs Onesie           |
      | priceDesc | Sauce Labs Fleece Jacket    |

  @Skip
  Scenario: Broken test
    Given User is on "Products" page
    Then First product title is "Sauce Labs Backpack"