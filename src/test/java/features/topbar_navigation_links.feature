
Feature: As a user I should have easy access to the links on the homepage


  Scenario: [TC-001_TrackOrder-Visible] The user must be able to access the links on the top bar of the homepage

    Given User goes to homepage with "url" and login
    When Clicks on the Track Your Order link at the top bar of the home page
    Then Confirms that there is a Compare link on the home page
    Then Wishlist link is displayed
    And Cart link is displayed
    Then  New User Zone link is displayed
    And  Daily Deals link is displayed
    And User logs out of the system


    Scenario: [TC-002_NavigateToUrl] Links on the home page top bar should be functional

      Given User goes to homepage with "url" and login
      When  Click on the "Track Your Order" link at the top bar of the home page
      Then Track your order page is up
      And Click on the Compare link at the top bar of the home page
      Then Verify that you are on the Compare page
      Then Click on the Wishlist link at the top bar of the home page
      And Confirm that you are on the Wishlist page
      Then Click on the Cart link at the top bar of the home page.
      And Confirm you are on the Cart page
      Then  Clicks on the New User Zone link
      And Confirm routing to New User Zone
      Then click on the “Daily Details” link on the home page
      And Confirms that the Daily Details page has been uploaded
      And User logs out of the system




  Scenario: [TC-003_Logo_Functional] When the site logo is clicked, it is redirected to the homepage

        Given User goes to homepage with "url" and login
        When Confirms that the site logo is displayed in the upper left corner of
        Then Clicks on the site logo
        And Confirms that the home page reloaded
         And User logs out of the system


        Scenario: [TC_004_Search_Functional] User should be able to use the search text box

          Given User goes to homepage with "url" and login
          When Confirms that the text box is visible
          Then Types the word they want to search  for and searches
          And Confirms that the search results are the right products for the search










