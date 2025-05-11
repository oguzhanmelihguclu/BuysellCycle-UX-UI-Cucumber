@smoke
Feature: As a user I should be able to access the home page

  Scenario: [US_001 => TC-01] The user should be able to successfully access the homepage.

    Given  The user opens the browser and enters the URL address specified in the data into the URL bar.
    When   The user waits for the page to fully load.
    Then   The user verifies that all images on the homepage have loaded.
    And    The user closes the browser.

  Scenario: [US_001 => TC-02] The user should be able to access the homepage within 3 seconds.

    Given  The user opens the browser and enters the URL address specified in the data into the URL bar.
    When   The user verifies that the page has fully loaded within 3 seconds.
    Then   The user closes the browser.

  Scenario: [US_001 => TC-03] The user verifies that the page title is "BuySellCycle | Multivendor Marketplace"
  when they enter the site.

    Given  The user opens the browser and enters the URL address specified in the data into the URL bar.
    When   The user waits for the page to fully load.
    And    The user checks the page title and verifies that it is "BuySellCycle | Multivendor Marketplace".
    Then   The user closes the browser.







