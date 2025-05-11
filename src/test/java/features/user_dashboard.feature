
Feature:As a registered user, I would like to have a dedicated dashboard page on the site to control my actions and settings on the site.

  Scenario:[US_017][TC_001]User access to the Dashboard page
    Given the user opens the browser and goes to the url from the data.
    When the user selects the Login option from the home page.
    Then  The user enters their email and password correctly, then presses the Sign In button.
    Then  The user's profile information should be visible on the Dashboard page
    And   The user logs out by clicking the "logoutButton"


  Scenario:[US_017][TC_002] Display of user profile, balance on the Dashboard page
    Given the user opens the browser and goes to the url from the data.
    When the user selects the Login option from the home page.
    Then  The user enters their email and password correctly, then presses the Sign In button.
    Then The user's balance information should be displayed on the Dashboard page
    And The user logs out by clicking the "logoutButton"


  Scenario: [US_017][TC_004] Displaying Summary Info on the Dashboard Page
    Given the user opens the browser and goes to the url from the data.
    When the user selects the Login option from the home page.
    Then  The user enters their email and password correctly, then presses the Sign In button.
    And The latest transaction summary on the Dashboard page
    And The user logs out by clicking the "logoutButton"

  Scenario: [US_017][TC_005] Make the body section visible on the Dashboard Page
    Given the user opens the browser and goes to the url from the data.
    When the user selects the Login option from the home page.
    Then  The user enters their email and password correctly, then presses the Sign In button.
    Then The 'body' section on the Dashboard page (e.g., panels such as Purchase History, Wishlist, Cart) should be visible."
    And The user logs out by clicking the "logoutButton"














