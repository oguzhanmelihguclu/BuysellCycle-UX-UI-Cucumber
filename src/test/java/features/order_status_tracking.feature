
  Feature: The user should be able to query the final status of the orders they have made

    Scenario: [TC-001_TrackOrder-Visible] On the “Track Order” page, the “Order Tracking Number” text box and
                                           the “Track Now” button must be displayed correctly
      Given User goes to homepage with "url" and login
      When  Click on the "Track Your Order" link at the top bar of the home page
      Then Verify that the is redirected
      And Confirms that the "Track Now" button is displayed


      Scenario: [TC-002_OrderTrackingNumber_InValid] Order Tracking Number should display a
                                                     warning message for an invalid order number

        Given User goes to homepage with "url" and login
        When  Click on the "Track Your Order" link at the top bar of the home page
        Then Verify that the is redirected
        And  Enters an invalid order number in the "Order Tracking Number" text box
        And  Clicks on the "Track Now" button Confirms that a warning message is displayed



        Scenario: [TC-003_OrderTrackingNumber_Valid]  Successfully query the current status of an order with a valid order number

          Given User goes to homepage with "url" and login
          When  Click on the "Track Your Order" link at the top bar of the home page
          Then  Enters a valid order number in the "Order Tracking Number" text box
          And  Confirms that the current status of the order is displayed








