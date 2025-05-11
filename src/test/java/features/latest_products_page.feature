
@test04
Feature: As a user, I would like to have a page where I can follow the current products on the site where I shop.

  Scenario:[US_007 => TC-01] Registered user accesses Best Deals from homepage

    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user enters a valid email address and password click on the "Sign In" button
    When  the user clicks on the "New Product Deals" menu
    Then  the user verifies that the "Best Deals" page is displayed
    When  the user clicks the Logout button



  Scenario:[US_007 => TC-02] Registered user filters Women's Apparel on Best Deals page

    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user enters a valid email address and password click on the "Sign In" button
    When  the user clicks on the "New Product Deals" menu
    Then the user verifies the visibility of the "Filter Products" text
    When the user sees and clicks the "Women's Apparel" filter
    Then the user sees the filtered product list
    When  the user clicks the Logout button

  @google


  Scenario:[US_007 => TC-03] Registered user views newly sorted product list
    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user enters a valid email address and password click on the "Sign In" button
    When  the user clicks on the "New Product Deals" menu
    When the user clicks on the Sorting By menu
    And the user selects the New option from the dropdown
    Then the user should see the list of newly added products
    When  the user clicks the Logout button



  Scenario:[US_007 => TC-04] Registered user changes product view layout
    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user enters a valid email address and password click on the "Sign In" button
    When  the user clicks on the "New Product Deals" menu
    When the user clicks on the icon next to the dropdown menus to change the view settings
    Then the user verifies that the products are displayed according to the selected icon layout
    When  the user clicks the Logout button




  Scenario:[US_007 => TC-05] Registered user refreshes Best Deals page using the Refresh button
    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user enters a valid email address and password click on the "Sign In" button
    When  the user clicks on the "New Product Deals" menu
    Then the user sees the "Refresh" button
    When the user clicks the Refresh button
    Then the user verifies that the page has been refreshed successfully
    When  the user clicks the Logout button





