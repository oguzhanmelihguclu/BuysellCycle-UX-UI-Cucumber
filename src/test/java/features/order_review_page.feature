Feature: As a registered user, I want to have a checkout page before I make the payment for the products I intend to purchase (add to my cart).

  @smoke
  Scenario: [US_032 => TC_001] Redirect from Cart to Checkout page

    Given Registered user goes to the relevant url
    When Enter the requested information on the login page and log in.
    And Goes from Dashboard page to Homepage
    And Select the desired product from Best Deals in the body section on the homepage.
    And Adds the selected product to the cart and goes to the Cart page.
    Then Click the PROCEED TO CHECKOUT button in the cart.
    And Enters information in the address form and presses the Continue button.
    When Checkout page confirms that you are directed to the payment section


  @smoke
  Scenario: [US_032 => TC_002] Product information should be displayed in detail

    Given Registered user goes to the relevant url
    When Enter the requested information on the login page and log in.
    And Goes from Dashboard page to Homepage
    And Select the desired product from Best Deals in the body section on the homepage.
    And Adds the selected product to the cart and goes to the Cart page.
    Then Click the PROCEED TO CHECKOUT button in the cart.
    And On the checkout page, the product name, quantity, unit price and subtotal added to the cart are verified.

  @smoke
  Scenario: [US_032 => TC_003] The total amount should appear on the checkout page

    Given Registered user goes to the relevant url
    When Enter the requested information on the login page and log in.
    And Goes from Dashboard page to Homepage
    And Select the desired product from Best Deals in the body section on the homepage.
    And Adds the selected product to the cart and goes to the Cart page.
    Then Click the PROCEED TO CHECKOUT button in the cart.
    And On the checkout page, it is verified that the total amount to be paid for the product added to the cart is visible.


  @smoke
  Scenario: [US_032 => TC_004] Contact Information must be visible on the checkout page.

    Given Registered user goes to the relevant url
    When Enter the requested information on the login page and log in.
    And Goes from Dashboard page to Homepage
    And Select the desired product from Best Deals in the body section on the homepage.
    And Adds the selected product to the cart and goes to the Cart page.
    Then Click the PROCEED TO CHECKOUT button in the cart.
    And Verify that there is a Contact Information section on the checkout page.

  @smoke
  Scenario: [US_032 => TC_005] You should be able to enter a note for the order on the Checkout page.

    Given Registered user goes to the relevant url
    When Enter the requested information on the login page and log in.
    And Goes from Dashboard page to Homepage
    And Select the desired product from Best Deals in the body section on the homepage.
    And Adds the selected product to the cart and goes to the Cart page.
    Then Click the PROCEED TO CHECKOUT button in the cart.
    And Verifies that there is a note in the order summary

  @smoke
  Scenario: [US_032 => TC_006] You should be able to enter a note for the order on the Checkout page.

    Given Registered user goes to the relevant url
    When Enter the requested information on the login page and log in.
    And Goes from Dashboard page to Homepage
    And Select the desired product from Best Deals in the body section on the homepage.
    And Adds the selected product to the cart and goes to the Cart page.
    Then Click the PROCEED TO CHECKOUT button in the cart.
    And Confirms that you can subscribe to the newsletter from the footer section


  @smoke
  Scenario: [US_032 => TC_007] Test for Not Accepting Terms and Conditions

    Given Registered user goes to the relevant url
    When Enter the requested information on the login page and log in.
    And Goes from Dashboard page to Homepage
    And Select the desired product from Best Deals in the body section on the homepage.
    And Adds the selected product to the cart and goes to the Cart page.
    Then Click the PROCEED TO CHECKOUT button in the cart.
    And Click the Continue to Shipping button without checking the I agree with the terms checkbox.
    And Confirms that you received an error message

  @smoke
  Scenario: [US_032 => TC_008] Test for Not Accepting Terms and Conditions

    Given Registered user goes to the relevant url
    When Enter the requested information on the login page and log in.
    And Goes from Dashboard page to Homepage
    And Select the desired product from Best Deals in the body section on the homepage.
    And Adds the selected product to the cart and goes to the Cart page.
    Then Click the PROCEED TO CHECKOUT button in the cart.
    And Enters information in the address form and presses the Continue button.
    And Find the Return to Cart button on the Checkout page
    And Test the clickability of both buttons






