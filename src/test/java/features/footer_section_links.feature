@test016
Feature: BuySellCycle Footer Functionality - US_016

  Background:
    Given User is on the login page
    When User enters valid credentials and clicks login

  Scenario: Verify footer is visible on the homepage
    When User scrolls to the bottom of the page
    Then Footer section should be visible

  Scenario: Visibility and functionality of About Us footer link
    When User scrolls to the footer section
    Then About Us link should be visible
    When User clicks the About Us link
    Then User should be redirected to the About Us page

  Scenario: Verify newsletter subscription from footer
    When User scrolls to the footer section
    And  User enters a valid email into the newsletter field
    And User clicks the Subscribe button
   Then A success message should be displayed

  Scenario: Verify App Store and Google Play links in footer
    When User scrolls to the footer section
    Then App Store and Google Play icons should be visible


  Scenario: Verify social media icons visibility and redirection
    When User scrolls to the footer section
    Then Facebook icon should be visible
    When User clicks each social media icon


  Scenario: Verify copyright text visibility
    When User scrolls to the footer section
    Then User should see the copyright text


  Scenario: Verify 'Back to Top' button functionality
    When User scrolls to the footer section
    And User clicks the Back to Top button
    Then Page should scroll smoothly to the top
