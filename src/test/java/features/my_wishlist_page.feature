
Feature: As a registered user, I would like to have a My Wishlist page on my Dashboard dashboard where I can view the products I like.

  Scenario: [US_019 => TC-01] My Wishlist menu item should be visible and active in the Dashboard sidebar.

    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user enters a valid email address and password click on the "Sign In" button
    When In the opened Dashboard, the user sees and clicks the My Wishlist menu in the sidebar.
    Then Verifies that the user is redirected to the relevant page.
    And The user clicks the Logout button on the homepage.


  Scenario: [US_019 => TC-02] My Wishlist page should display the products you like.

    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user enters a valid email address and password click on the "Sign In" button
    When In the opened Dashboard, the user sees and clicks the My Wishlist menu in the sidebar.
    Then  Verifies that there are listed products on the opened page.
    And The user clicks the Logout button on the homepage.



  @E2E
  Scenario:[US_019 => TC-03] The products on the My wishlist page should be filtered and searchable.

    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user enters a valid email address and password click on the "Sign In" button
    When In the opened Dashboard, the user sees and clicks the My Wishlist menu in the sidebar.
    When Clicks on the New menu on the right side of the screen and selects Price - Low to High.
    Then  Sees that the products are listed according to the selected filter.
    And The user clicks the Logout button on the homepage.


  Scenario: [US_019 => TC-04]It should be possible to perform actions on products on the My Wishlist page (add to cart).

    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user enters a valid email address and password click on the "Sign In" button
    When In the opened Dashboard, the user sees and clicks the My Wishlist menu in the sidebar.
    When Clicks the cart icon for the displayed product.
    Then Sees a pop-up confirming that the product has been added to the cart.
    When Closes the pop-up and the Shopping Cart side panel.
    And The user clicks the Logout button on the homepage.


  Scenario:[US_019 => TC-05] You should be able to switch between product list pages in My Wishlist.
    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user enters a valid email address and password click on the "Sign In" button
    When In the opened Dashboard, the user sees and clicks the My Wishlist menu in the sidebar.
    When Scrolls down the list on the opened page, clicks the Next button, and verifies that the next page of the list is displayed.
    Then On the newly opened page, clicks the Previous button and verifies that the previous page is displayed.
    And The user clicks the Logout button on the homepage.