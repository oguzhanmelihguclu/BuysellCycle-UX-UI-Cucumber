
Feature: Registered users can make payments for their orders

  Background:
    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When The user waits for the page to fully load.
    When the user navigates to the login page
    And The user logs in with valid credentials.
    And The user's cart contains at least one product.


  Scenario: [US_033 => TC-01] The user should be able to navigate to the Payment page from the Checkout page
    When The user is on the Checkout page.
    And The user clicks on the Continue to Shipping button.
    Then The user tests to be redirected to the Payment page.
    And The user logs out.


  Scenario: [US_033 => TC-02] The user should be able to display and change the Ship to Information on the Payment page
    When The user is on the Checkout page.
    And The user clicks on the Continue to Shipping button.
    Then The user verifies that the Ship to is displayed on the Payment page.
    When The user clicks on the Change Ship To button.
    And The user tests that Ship To information can be changed.
    And The user logs out.


  Scenario: [US_033 => TC-03] The user should be able to select Payment and Billing address types on the Payment page
    When The user is on the Checkout page.
    And The user clicks on the Continue to Shipping button.
    Then The user verifies that Payment type is selectable on the Payment page.
    Then The user verifies that Billing address is selectable on the Payment page.
    And The user logs out.


  Scenario: [US_033 => TC-04] The user should be able to display correctly Order Summary on the Payment page
    When The user is on the Checkout page.
    And The user clicks on the Continue to Shipping button.
    Then The user verifies that Order Summary section is displayed on the Payment page.
    Then The user verifies that The Subtotal field is displayed correctly.
    Then The user verifies that The Shipping Charge field is displayed correctly.
    Then The user verifies that The Discount field is displayed correctly.
    Then The user verifies that The VAT_TAX_GST field is displayed correctly.
    Then The user verifies that The Coupon Code field is displayed correctly.
    Then The user verifies that The Total field is displayed correctly.
    And The user logs out.


  Scenario: [US_033 => TC-05] The user should be able to receive a discount with a valid coupon code
    When The user is on the Checkout page.
    And The user clicks on the Continue to Shipping button.
    When The user enters valid coupon code in Coupon Code field.
    Then The user verifies that the coupon is valid on the payment page.
    Then The user verifies that the total amount to be paid has been updated.
    And The user logs out.


  Scenario: [US_033 => TC-06] The user should be able to display and click Order Now and Return To Information buttons
    When The user is on the Checkout page.
    And The user clicks on the Continue to Shipping button.
    Then The user verifies that the Return To Information button is displayed.
    Then The user verifies that the Return To Information button is clickable.
    Then The user verifies that the Order Now button is displayed.
    Then The user verifies that the Order Now button is clickable.

@E2E
  Scenario: [US_033 => TC-07] The user should be able to complete the order and see the confirmation
    When The user is on the Checkout page.
    And The user clicks on the Continue to Shipping button.
    When The user clicks the Order Now button.
    Then The user should be immediately navigated to the order confirmation page.
    And The user verifies that 'Thank you for your purchase!' is displayed.
    And The user verifies that The Order Number is displayed.
    Then The user verifies that purchased item details are displayed.
    And The user logs out.


  Scenario: [US_033 => TC-08] The user should be able to access the Order Summary Page after payment
    When The user is on the Checkout page.
    And The user clicks on the Continue to Shipping button.
    When The user clicks the Order Now button.
    Then The user should be immediately navigated to the order confirmation page.
    When The user clicks on the View Order button.
    And The user verifies that the details of the purchased items are displayed.
    And The user logs out.


  Scenario: [US_033 => TC-09] The user should be able to return to the Home Page after completing the order
    When The user is on the Checkout page.
    And The user clicks on the Continue to Shipping button.
    When The user clicks the Order Now button.
    Then The user should be immediately navigated to the order confirmation page.
    When The user clicks on the Continue Shopping button.
    Then The user verifies that The Home Page is displayed.
    And The user logs out.


  Scenario: [US_033 => TC-10] The user should not be able to receive a discount with a invalid coupon code
    When The user is on the Checkout page.
    And The user clicks on the Continue to Shipping button.
    When The user enters invalid coupon code in Coupon Code field.
    Then The user verifies that the coupon is invalid on the payment page.
    Then The user verifies that the total amount to be paid has not been updated.
    And The user logs out.


  Scenario: [US_033 => TC-11] The user should be able to display and change the Contact Information on the Payment page
    When The user is on the Checkout page.
    And The user clicks on the Continue to Shipping button.
    Then The user verifies that the Contact Information is displayed on the Payment page.
    When The user clicks on the Change Contact button.
    Then The user tests that the Contact information can be changed.
    And The user logs out.


  Scenario: [US_033 => TC-12] The user should not be able to complete the payment with invalid card details
    When The user is on the Checkout page.
    And The user clicks on the Continue to Shipping button.
    When The user clicks the Order Now button.
    And The user enters invalid payment information.
    Then The user verifies that the payment transaction failed.



