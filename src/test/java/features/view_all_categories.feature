
@test04

Feature: As a user, I would like to have a page where I can follow the current products on the site where I shop.
  Scenario:[US_006 => TC-01] Registered user verifies visibility of All Categories menu
    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user enters a valid email address and password click on the "Sign In" button
    Then the user verifies the visibility of the "All Categories" dropdown menu in the navbar
    When the user clicks the Logout button


  Scenario:[US_006 => TC-02] Registered user opens All Categories dropdown and sees Electronics category
    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user enters a valid email address and password click on the "Sign In" button
    When the user clicks on the "All Categories" dropdown menu in the navbar
    Then the user verifies the visibility of the "Electronics" category under the dropdown
    When the user clicks the Logout button



  Scenario:[US_006 => TC-03] Registered user views the Phone subcategory under Electronics
    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user enters a valid email address and password click on the "Sign In" button
    When the user clicks on the "All Categories" dropdown menu in the navbar
    Then the user verifies the visibility of the "Electronics" category under the dropdown
    When the user hovers over the "Electronics" category
    Then the user sees the "Telephone" subcategory in the opened submenu
    When the user clicks the Logout button

   @test

  Scenario:[US_006 => TC-04] Registered user accesses the Mobile Phone category from the dropdown menu
    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user enters a valid email address and password click on the "Sign In" button
    When the user clicks on the "All Categories" dropdown menu in the navbar
    Then the user verifies the visibility of the "Electronics" category under the dropdown
    When the user hovers over the "Electronics" category
    Then the user sees the "Telephone" subcategory in the opened submenu
    Then the user sees and clicks on the "Mobile Phone" subcategory
    Then the user is redirected to the Mobile Phone category page
    When the user clicks the Logout button





