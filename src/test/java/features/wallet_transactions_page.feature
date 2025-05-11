
Feature: Registered user can perform wallet transactions in the Dashboard panel

  Background:
    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When The user waits for the page to fully load.
    And the user navigates to the login page
    And The user logs in with valid credentials.


  Scenario: [US_021 => TC-01] The user should be able to see and click on the My Wallet menu item in the Sidebar
    When The user tests that the My Wallet menu item is visible in the Dashboard sideBar.
    And The user clicks the My Wallet menu item.
    Then The user tests to be redirected to the My Wallet page.
    And The user logs out.


  Scenario: [US_021 => TC-02] The user should be able to see the My Wallet information boards and the information they contain
    When The user clicks the My Wallet menu item.
    Then The user tests that the Running Balance information board is visible.
    Then The user tests that the Pending Balance information board is visible.
    And The user logs out.


  Scenario: [US_021 => TC-03] The user should be able to upload wallet
    When The user clicks the My Wallet menu item.
    Then The user clicks on the Recharge Wallet button.
    And The user enters "200" as amount.
    And The user enters valid payment information.
    Then The user tests the Running Balance is updated.
    And The user logs out.


  Scenario: [US_021 => TC-04] The user should be able to view the history of wallet uploads
    When The user clicks the My Wallet menu item.
    And The user tests that the Wallet Recharge History table is visible.
    Then The user tests that "Date, Trx Id, Amount, Type, Payment Method, Status" information is visible.
    And The user logs out.


  Scenario: [US_021 => TC-05] The user should not be able to upload wallet with invalid amount
    When The user clicks the My Wallet menu item.
    Then The user clicks on the Recharge Wallet button.
    And The user enters "-105e0.+" as invalid amount.
    Then The user tests whether the wallet upload process has been completed.
    And The user logs out.


  Scenario: [US_021 => TC-06] The user should not be able to upload wallet with invalid card information
    When The user clicks the My Wallet menu item.
    Then The user clicks on the Recharge Wallet button.
    And The user enters "200" as amount.
    And The user enters invalid payment information.
    Then The user tests that the payment transaction has failed.
    And The user logs out.


  Scenario: [US_021 => TC-07] The user should not be able to upload wallet with blank form
    When The user clicks the My Wallet menu item.
    Then The user clicks on the Recharge Wallet button.
    And The user clicks the Add Fund button without entering any information.
    Then The user tests that the upload wallet transaction failed.
    And The user logs out.


  Scenario: [US_021 => TC-08] The user should not be able to upload wallet with invalid email
    When The user clicks the My Wallet menu item.
    Then The user clicks on the Recharge Wallet button.
    And The user enters "200" as amount.
    Then The user enters invalid email.
    And The user enters valid card information.
    Then The user tests that the payment transaction failed.
    And The user logs out.










