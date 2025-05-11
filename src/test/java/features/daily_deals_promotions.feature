Feature: As a user, you can test a page on the site that includes daily special discounts and campaigns.

  @smoke
  Scenario: [US_012 => TC_001] Testing the visibility and functionality of the "Daily Deals" menu in the NavBar
    Given Registered user goes to the relevant url
    When Enter the requested information on the login page and log in.
    And Goes from Dashboard page to Homepage
    Then Daily Deals menu appears on the homepage navbar and clicked
    And Access to the Daily Deals page is confirmed.

  @smoke
  Scenario: [US_012 => TC_002] Test counter visibility on Daily Deals page
    Given Registered user goes to the relevant url
    When Enter the requested information on the login page and log in.
    And Goes from Dashboard page to Homepage
    Then Click Daily Deals on the homepage navbar
    And Verify that there is a counter on the Daily Deals page

  @smoke
  Scenario: [US_012 => TC_003] Testing the visibility of promotional products on the Daily Deals page
    Given Registered user goes to the relevant url
    When Enter the requested information on the login page and log in.
    And Goes from Dashboard page to Homepage
    Then Click Daily Deals on the homepage navbar
    And Verify that the product is listed on the page

  

  Scenario: [US_012 => TC_005] Test to add the product to the comparison list
    Given Registered user goes to the relevant url
    When Enter the requested information on the login page and log in.
    And Goes from Dashboard page to Homepage
    Then Click Daily Deals on the homepage navbar
    And Click the Compare button for the product listed on the Daily Deals page
    And And verify that it has been successfully added to the comparison list

  Scenario: [US_012 => TC_006] Adding the product to the favorites list and viewing test
    Given Registered user goes to the relevant url
    When Enter the requested information on the login page and log in.
    And Goes from Dashboard page to Homepage
    Then Click Daily Deals on the homepage navbar
    And Click on the favorite button of the product listed on the Daily Deals page
    And And confirm that you have been added to the favorites list
