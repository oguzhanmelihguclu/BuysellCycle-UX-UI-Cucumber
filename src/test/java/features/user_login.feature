
Feature: As a user, I would like to be able to log in with the email and password I registered with the site.

  Scenario: [US_005 => TC-01] It is checked whether the login link in the top bar of the homepage is visible and active.

    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    Then  the user verifies if the Login link in the top right corner is visible and active
    When  The user closes the browser.

  Scenario: [US_005 => TC-02] Check if the relevant image and the text "Turn your ideas into reality."
  are visible in the right section of the Login page.

    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    Then  the user verifies if the image and the text "Turn your ideas into reality." are visible on the right side of the page
    When  The user closes the browser.


  Scenario: [US_005 => TC-03] Check if the SignIn form is present in the left section of the Login page.

    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    Then  the user verifies if the SignIn form in the top left corner is visible
    When  The user closes the browser.


  Scenario: [US_005 => TC-04] Check if the SignIn button is visible and active on the Login page.

    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When the user navigates to the login page
    Then the user verifies if the SignIn button is visible and active
    When  The user closes the browser.


  Scenario: [US_005 => TC-05] Check if the "Remember me" checkbox is selectable in the Login form.

    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    Then  the user verifies if the checkbox is selectable
    When  The user closes the browser.


  Scenario: [US_005 => TC-06] Check if the "Forgot Password" link is clickable on the Login page.

    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user clicks on the "Forgot Password" link
    Then  the user verifies if they are redirected to the correct page
    When  The user closes the browser.

  Scenario: [US_005 => TC-07] Check if the "Register" link is clickable on the Login page.

    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user clicks on the "Register" link
    Then  the user verifies if they are redirected to the correct page
    When  The user closes the browser.


  Scenario: [US_005 => TC-08] Check if error messages are displayed when the
  SignIn button is clicked with invalid credentials.

    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user attempts to sign in with an invalid email and password by clicking the 'Sign In' button
    Then  the user checks for error messages
    When  The user closes the browser.


  Scenario: [US_005 => TC-09] Check if a successful login occurs when the
  SignIn button is clicked with valid credentials.

    Given The user opens the browser and enters the URL address specified in the data into the URL bar.
    When  the user navigates to the login page
    And   the user enters a valid email address and password click on the "Sign In" button
    Then  the user verifies if they have successfully logged in
    When  The user closes the browser.