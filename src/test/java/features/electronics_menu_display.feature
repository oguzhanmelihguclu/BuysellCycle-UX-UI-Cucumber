Feature: As a user I should be able to access the Electronics category
  Scenario: [US_015 => TC-01] Check if the Electronics category widget is visible on the homepage
    Given  The user opens the browser and enters the URL address specified in the data into the URL bar.
    When   The user waits for the page to fully load.
    Then   The user verifies that all images on the homepage have loaded.
    When   The user clicks on the All Categories Link
    And    The user hovers over the Electronics menu item.
    Then   The Electronics category widget is displayed in the body section of the homepage.
    And    The user closes the browser.

  Scenario: [US_015 => TC-02] Verify that in the Electronics category, subcategories are displayed
    Given  The user opens the browser and enters the URL address specified in the data into the URL bar.
    When   The user waits for the page to fully load.
    Then   The user verifies that all images on the homepage have loaded.
    When   The user clicks on the All Categories Link
    And    The user hovers over the Electronics menu item.
    Then   Subcategories of the Electronics category widget is displayed in the body section of the homepage.
    And    The user closes the browser.

  Scenario: [US_015 => TC-03] Check if the subcategories the Electronics menu item link to relevant pages.
    Given  The user opens the browser and enters the URL address specified in the data into the URL bar.
    When   The user waits for the page to fully load.
    Then   The user verifies that all images on the homepage have loaded.
    When  the user navigates to the login page
    And   the user enters a valid email address and password and logs in
    When   The user clicks on the All Categories Link
    And    The user hovers over the Electronics menu item.
    Then   "Chargers" of the Electronics category widget is displayed in the body section of the homepage.
    When   The user clicks on the "Chargers" subcategory link
    Then   The "Chargers" subcategory links to the relevant page with appropriate content
    And    The user clicks the Logout button on the homepage.
    Then   The user verifies that the logout was successful.
    And    The user closes the browser.

  Scenario: [US_015 => TC-04] Verify that the "Add to Cart" icon is available and functional for each product on the relevant category page.
    Given  The user opens the browser and enters the URL address specified in the data into the URL bar.
    When   The user waits for the page to fully load.
    When  the user navigates to the login page
    And   the user enters a valid email address and password and logs in
    When   The user clicks on the All Categories Link
    And    The user hovers over the Electronics menu item.
    Then   "Chargers" of the Electronics category widget is displayed in the body section of the homepage.
    When   The user clicks on the "Chargers" subcategory link
    Then   The "Chargers" subcategory links to the relevant page with appropriate content
    Then   The user verifies that Add to Cart icon is clickable
    And    The user clicks on the Add to Cart icon
    Then   The user verifies that a confirmation message indicating that the product is added to cart is displayed.
    When   The user clicks on the View Cart button
    Then   The user is navigated to the Cart page.
    And    The user clicks the Logout button on the homepage.
    Then   The user verifies that the logout was successful.
    And    The user closes the browser.

  Scenario: [US_015 => TC-05] Verify that the product comparison feature is available on the relevant category pages.
    Given  The user opens the browser and enters the URL address specified in the data into the URL bar.
    When   The user waits for the page to fully load.
    Then   The user verifies that all images on the homepage have loaded.
    When  the user navigates to the login page
    And   the user enters a valid email address and password and logs in
    When   The user clicks on the All Categories Link
    And    The user hovers over the Electronics menu item.
    Then   "Chargers" of the Electronics category widget is displayed in the body section of the homepage.
    When   The user clicks on the "Chargers" subcategory link
    Then   The "Chargers" subcategory links to the relevant page with appropriate content
    Then   The user verifies and clicks on the compare icon of the first product
    Then   The user verifies that a confirmation message indicating that the product is added to compare list is displayed.
    Then   The user verifies and clicks on the compare icon of the second product
    Then   The user verifies that a confirmation message indicating that the product is added to compare list is displayed.
    When   The user clicks on the Compare link on the homepage
    Then   The user verifies to be navigated to the Compare page
    And    The user clicks the Logout button on the homepage.
    Then   The user verifies that the logout was successful.
    And    The user closes the browser.

  Scenario: [US_015 => TC-06] Verify that user can add a product to the wish list
    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user enters a valid email address and password and logs in
    When   The user clicks on the All Categories Link
    And    The user hovers over the Electronics menu item.
    Then   "Mobile Phone" of the Electronics category widget is displayed in the body section of the homepage.
    When   The user clicks on the "Mobile Phone" subcategory link
    Then   The "Mobile Phone" subcategory links to the relevant page with appropriate content
    Then   The user verifies that wishlist icon of a product is visible and clicks on the wishlist icon
    When   The user clicks on the Wishlist Link
    Then   The user verifies that the product is added to the wishlist
    And    The user clicks the Logout button on the homepage.
    Then   The user verifies that the logout was successful.
    And    The user closes the browser.

  Scenario: [US_015 => TC-07] Verify that product details can be viewed when clicked on the Quick View Icon
    Given  The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user enters a valid email address and password and logs in
    And    The user waits for the page to fully load.
    When   The user clicks on the All Categories Link
    And    The user hovers over the Electronics menu item.
    Then   "Mobile Phone" of the Electronics category widget is displayed in the body section of the homepage.
    When   The user clicks on the "Mobile Phone" subcategory link
    Then   The "Mobile Phone" subcategory links to the relevant page with appropriate content
    Then   The user verifies and clicks on the Quick View icon of the product
    Then   The user verifies that product details are shown on the pop up window
    And    The user closes the product details window
    And    The user clicks the Logout button on the homepage.
    Then   The user verifies that the logout was successful.
    And    The user closes the browser.

  Scenario: [US_015 => TC-08] Verify that user can select the number of products to display using checkboxes
    Given  The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user enters a valid email address and password and logs in
    And    The user waits for the page to fully load.
    When   The user clicks on the All Categories Link
    And    The user hovers over the Electronics menu item.
    Then   "Mobile Phone" of the Electronics category widget is displayed in the body section of the homepage.
    When   The user clicks on the "Mobile Phone" subcategory link
    Then   The "Mobile Phone" subcategory links to the relevant page with appropriate content
    Then   The user verifies that more products can be displayed in the Electronics window.
    And    The user clicks the Logout button on the homepage.



