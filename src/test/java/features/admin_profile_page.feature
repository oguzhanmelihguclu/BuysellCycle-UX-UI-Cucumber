Feature: As an admin, I should have a profile page to access my profile information and logout.
  Scenario: [US_036 => TC-01] Verify that the profile icon is visible in the top bar of the Admin Dashboard
    Given  The admin opens the browser and navigates to admin login page
    When   The admin waits for the page to fully load.
    And    The admin logs in to the system with a valid administrator account
    Then   The admin verifies that the profile icon is visible in the top bar of the Admin Dashboard
    And     The admin hovers over the admin profile icon and presses Logout.

  Scenario: [US_036 => TC-02] Verify that My Profile link Appears when the admin hovers over admin profile icon
    Given  The admin opens the browser and navigates to admin login page
    When   The admin waits for the page to fully load.
    And    The admin logs in to the system with a valid administrator account
    Then   The admin verifies that the profile icon is visible in the top bar of the Admin Dashboard
    When   The admin hovers over the the profile icon
    And    The admin verifies that My profile link appears in the window that opens.
    And    The admin hovers over the admin profile icon and presses Logout.

  Scenario: [US_036 => TC-03] Verify that admin can access the profile page via "My Profile" link.
    Given  The admin opens the browser and navigates to admin login page
    When   The admin waits for the page to fully load.
    And    The admin logs in to the system with a valid administrator account
    Then   The admin verifies that the profile icon is visible in the top bar of the Admin Dashboard
    When   The admin hovers over the the profile icon
    And    The admin verifies that My profile link appears in the window that opens.
    When   The admin clicks the My profile link
    Then   The admin verifies that the profile page is displayed
    And    The admin hovers over the admin profile icon and presses Logout.

  Scenario: [US_036 => TC-04] Verify that First Name, Last Name, E-mail Address, Phone Number, Date of Birth are
  displayed in the Basic Info section on the profile page.
    Given  The admin opens the browser and navigates to admin login page
    When   The admin waits for the page to fully load.
    And    The admin logs in to the system with a valid administrator account
    Then   The admin verifies that the profile icon is visible in the top bar of the Admin Dashboard
    When   The admin hovers over the the profile icon
    #And    The admin verifies that My profile link appears in the window that opens.
    When   The admin clicks the My profile link
    Then   The admin verifies that the profile page is displayed
    Then   The admin verifies that First Name, Last Name, E-mail Address, Phone Number, Date of Birth are displayed in the Basic Info section on the profile page.
    And    The admin hovers over the admin profile icon and presses Logout.

  Scenario: [US_036 => TC-05] Verify that the admin can update Basic Info fields on the profile page
    Given  The admin opens the browser and navigates to admin login page
    When   The admin waits for the page to fully load.
    And    The admin logs in to the system with a valid administrator account
    Then   The admin verifies that the profile icon is visible in the top bar of the Admin Dashboard
    When   The admin hovers over the the profile icon
    #And    The admin verifies that My profile link appears in the window that opens.
    When   The admin clicks the My profile link
    Then   The admin verifies that the profile page is displayed
    #Then   The admin verifies that First Name, Last Name, E-mail Address, Phone Number, Date of Birth are displayed in the Basic Info section on the profile page.
    Then   The admin verifies that First Name, Last Name, E-mail Address, Phone Number, Date of Birth can be updated displayed in the Basic Info section on the profile page.
    And    The admin hovers over the admin profile icon and presses Logout.

  Scenario: [US_036 => TC-06] Verify that the admin cannot set a Date of Birth after 01-01-2007 when updating their profile.
    Given  The admin opens the browser and navigates to admin login page
    When   The admin waits for the page to fully load.
    And    The admin logs in to the system with a valid administrator account
    Then   The admin verifies that the profile icon is visible in the top bar of the Admin Dashboard
    When   The admin hovers over the the profile icon
    #And    The admin verifies that My profile link appears in the window that opens.
    When   The admin clicks the My profile link
    Then   The admin verifies that the profile page is displayed
    When   The admin enters an invalid Date of Birth Info on the profile page and clicks Update button
    Then   The admin verifies that an error message indicating invalid Date of Birth Info is displayed.
    And    The admin hovers over the admin profile icon and presses Logout.

  Scenario: [US_036 => TC-07] Verify that an error is shown when the Phone Number  contains characters other than digits.
    Given  The admin opens the browser and navigates to admin login page
    When   The admin waits for the page to fully load.
    And    The admin logs in to the system with a valid administrator account
    Then   The admin verifies that the profile icon is visible in the top bar of the Admin Dashboard
    When   The admin hovers over the the profile icon
    #And    The admin verifies that My profile link appears in the window that opens.
    When   The admin clicks the My profile link
    Then   The admin verifies that the profile page is displayed
    When   The admin enters Phone Number Info that contains characters other than digits.
    Then   The admin verifies that an error is shown that the Phone Number contains characters other than digits.
    And    The admin hovers over the admin profile icon and presses Logout.

  Scenario: [US_036 => TC-08] Verify that an error is shown when the Phone Number is less than 10 digits
    Given  The admin opens the browser and navigates to admin login page
    When   The admin waits for the page to fully load.
    And    The admin logs in to the system with a valid administrator account
    Then   The admin verifies that the profile icon is visible in the top bar of the Admin Dashboard
    When   The admin hovers over the the profile icon
    #And    The admin verifies that My profile link appears in the window that opens.
    When   The admin clicks the My profile link
    Then   The admin verifies that the profile page is displayed
    When   The admin enters an invalid Date Phone containing number of digits less than 10 and clicks Update button
    Then   The admin verifies that an error is shown that the Phone Number is less than 10 digits
    And    The admin hovers over the admin profile icon and presses Logout.

  Scenario: [US_036 => TC-09] Verify that an error is shown when the email has an invalid format
    Given  The admin opens the browser and navigates to admin login page
    When   The admin waits for the page to fully load.
    And    The admin logs in to the system with a valid administrator account
    Then   The admin verifies that the profile icon is visible in the top bar of the Admin Dashboard
    When   The admin hovers over the the profile icon
    #And    The admin verifies that My profile link appears in the window that opens.
    When   The admin clicks the My profile link
    Then   The admin verifies that the profile page is displayed
    When   The admin enters an invalid format email and clicks Update button
    Then   The admin verifies that an error is shown that the email has an invalid format
    And    The admin hovers over the admin profile icon and presses Logout.

  Scenario: [US_036 => TC-10] Verify that an error is shown when the First Name Field is blank
    Given  The admin opens the browser and navigates to admin login page
    When   The admin waits for the page to fully load.
    And    The admin logs in to the system with a valid administrator account
    Then   The admin verifies that the profile icon is visible in the top bar of the Admin Dashboard
    When   The admin hovers over the the profile icon
    #And    The admin verifies that My profile link appears in the window that opens.
    When   The admin clicks the My profile link
    Then   The admin verifies that the profile page is displayed
    When   The admin leaves the First Name Field blank and clicks Update button
    Then   The admin verifies that an error is shown that First Name is blank
    And    The admin hovers over the admin profile icon and presses Logout.

  Scenario: [US_036 => TC-11] Verify that an error is shown when the Email Field is blank
    Given  The admin opens the browser and navigates to admin login page
    When   The admin waits for the page to fully load.
    And    The admin logs in to the system with a valid administrator account
    Then   The admin verifies that the profile icon is visible in the top bar of the Admin Dashboard
    When   The admin hovers over the the profile icon
    #And    The admin verifies that My profile link appears in the window that opens.
    When   The admin clicks the My profile link
    Then   The admin verifies that the profile page is displayed
    When   The admin leaves the email field blank and clicks update button
    Then   The admin verifies that an error is shown that Email is blank
    And    The admin hovers over the admin profile icon and presses Logout.

  Scenario: [US_036 => TC-12] Verify that an error is shown when the Phone Number is blank
    Given  The admin opens the browser and navigates to admin login page
    When   The admin waits for the page to fully load.
    And    The admin logs in to the system with a valid administrator account
    Then   The admin verifies that the profile icon is visible in the top bar of the Admin Dashboard
    When   The admin hovers over the the profile icon
    When   The admin clicks the My profile link
    Then   The admin verifies that the profile page is displayed
    When   The admin leaves the Phone Number Field blank and clicks Update button
    Then   The admin verifies that an error is shown that the Phone Number is blank
    And    The admin hovers over the admin profile icon and presses Logout.

  Scenario: [US_036 => TC-13] Verify that the admin views the address information by clicking the "Address" button on the profile page
    Given  The admin opens the browser and navigates to admin login page
    When   The admin waits for the page to fully load.
    And    The admin logs in to the system with a valid administrator account
    Then   The admin verifies that the profile icon is visible in the top bar of the Admin Dashboard
    When   The admin hovers over the the profile icon
    When   The admin clicks the My profile link
    Then   The admin verifies that the profile page is displayed
    When   The admin clicks the Address button
    Then   The admin verifies that address information is displayed
    And    The admin hovers over the admin profile icon and presses Logout.

  Scenario: [US_036 => TC-14] Verify that the admin can add a new address in the address list
    Given  The admin opens the browser and navigates to admin login page
    When   The admin waits for the page to fully load.
    And    The admin logs in to the system with a valid administrator account
    Then   The admin verifies that the profile icon is visible in the top bar of the Admin Dashboard
    When   The admin hovers over the the profile icon
    When   The admin clicks the My profile link
    Then   The admin verifies that the profile page is displayed
    When   The admin clicks the Address button
    Then   The admin verifies that address information is displayed
    When   The admin clicks on Add New Address button
    Then   The admin verifies that a new Address Form is displayed
    When   The admin enters Name, Phone, Email, Address, Country, State, City and Postal Code in the Address form
    And    The admin clicks on the Save button
    Then   The admin verifies that the address is saved in the address list
    And    The admin hovers over the admin profile icon and presses Logout.




