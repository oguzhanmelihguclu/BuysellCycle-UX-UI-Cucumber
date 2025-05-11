

Feature: [US_031) As a user, I want to have a shopping cart page where I can add the products I want to buy and then carry out my shopping transactions.

 Scenario:[US_031=> TC-01] Viewing the cart page
   Given the user opens the browser and goes to the url from the data.
   When the user selects the Login option from the home page.
   Then  The user enters their email and password correctly, then presses the Sign In button.
   Then The cart button should be displayed.
   And   The user logs out by clicking the "logoutButton"

  Scenario:[US_031=> TC-02]Adding products to the cart and viewing product details
    Given the user opens the browser and goes to the url from the data.
    When the user selects the Login option from the home page.
    Then  The user enters their email and password correctly, then presses the Sign In button.
    When The user clicks the search button and enters "watch" into the search field
    And user adds the first product to the cart
    Then The user verify that the product has been added to the cart.
    And The user verify that all added products are listed with name, image
    And   The user logs out by clicking the "logoutButton"

  Scenario:[US_031=> TC-03]Continue Shopping or Proceed to Payment Step from Cart Page
    Given the user opens the browser and goes to the url from the data.
    When the user selects the Login option from the home page.
    Then  The user enters their email and password correctly, then presses the Sign In button.
    When The user clicks the search button and enters "watch" into the search field
    And user adds the first product to the cart
    And The user clicks the 'Order Summary' button in the cart
    Then The user should be redirected to the home or products page
    And   The user logs out by clicking the "logoutButton"


  Scenario: [US_031=> TC-04] Displaying Order Summary and Discount Amounts on the Cart Page
    Given the user opens the browser and goes to the url from the data.
    When the user selects the Login option from the home page.
    Then  The user enters their email and password correctly, then presses the Sign In button.
    When The user clicks the search button and enters "watch" into the search field
    And user adds the first product to the cart
    Then The user verifies the Order Summary section includes Subtotal, Shipping, and Taxes
    And The user verifies the product shows both discounted price
    And   The user logs out by clicking the "logoutButton"

  Scenario: [US_031=> TC-05] Updating Order Summary After Product Removal
    Given the user opens the browser and goes to the url from the data.
    When the user selects the Login option from the home page.
    Then  The user enters their email and password correctly, then presses the Sign In button.
    When The user clicks the search button and enters "watch" into the search field
    And user adds the first product to the cart
    And The user removes the product from the cart
    Then The product should be removed from the cart
    And   The user logs out by clicking the "logoutButton"


















