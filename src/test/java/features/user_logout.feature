@test03
Feature: As a logged in user, I want to be able to logout from the site.

  Scenario:[US_029 => TC-01] Verify that the registered user can easily see the Logout link on the homepage.

    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user enters a valid email address and password click on the "Sign In" button
    When The user clicks the logo to return to the homepage.
    Then The user verifies that the Logout button is visible on the redirected homepage.


  Scenario: [US_029 => TC-02] Verify that the user can securely log out by clicking the Logout link located on the homepage.

    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user enters a valid email address and password click on the "Sign In" button
    When The user clicks the logo to return to the homepage.
    And The user clicks the Logout button on the homepage.
    Then The user verifies that the logout was successful.


  Scenario:[US_029 => TC-03] Verify that the user can see the Logout link in the sidebar of the dashboard and that the link is clickable.

    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user enters a valid email address and password click on the "Sign In" button
    When On the opened Dashboard, the user scrolls down and verifies that the Logout button is visible on the sidebar.
    Then The user clicks the sideLogout button and verifies that the logout was successful.


  Scenario:[US_029 => TC-04] Verify that the user can securely log out of the system using the Logout link in the dashboard.

    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user enters a valid email address and password click on the "Sign In" button
    When On the Dashboard page, the user sees the Logout button on the top bar.
    Then The user clicks the topLogout button and verifies that the logout was successful.

