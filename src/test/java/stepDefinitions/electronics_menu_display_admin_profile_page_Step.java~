package stepDefinitions;

import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utilities.ExcelReader;
import utilities.LoggerHelper;
import utilities.ReusableMethods;
import java.time.Duration;


public class US_015and036Step  {

    private static final Logger logger = LogManager.getLogger();
    WebDriver driver = stepDefinitions.Hooks.getDriver();
    HomeCategoriesPage homeCategoriesPage = new HomeCategoriesPage(driver);

    AdminProfileNotificationsPage adminProfileNotificationsPage = new AdminProfileNotificationsPage(driver);
    HomeHeaderPage homeHeaderPage = new HomeHeaderPage(driver);
    ExcelReader excelReader = new ExcelReader("src/test/resources/TestData.xlsx");

    LoginPages loginPages = new LoginPages(driver);

    @When("The user clicks on the All Categories Link")
    public void the_user_clicks_on_the_all_categories_link() {

        homeCategoriesPage.click(homeCategoriesPage.allCategoriesButton);
        LoggerHelper.info("The user clicks on the All Categories Link");

    }
    @When("The user hovers over the Electronics menu item.")
    public void the_user_hovers_over_the_electronics_menu_item() {

        Actions actions = new Actions(driver);
        actions.moveToElement(homeCategoriesPage.electronicsMenu).perform();
        LoggerHelper.info("The user hovers over the Electronics menu item.");
    }

    @Then("The Electronics category widget is displayed in the body section of the homepage.")
    public void the_electronics_category_widget_is_displayed_in_the_body_section_of_the_homepage() {

        Assert.assertTrue(homeCategoriesPage.mobilPhoneMenu.isDisplayed());
        LoggerHelper.info("The Electronics category widget is displayed in the body section of the homepage.");
    }

    @Then("Subcategories of the Electronics category widget is displayed in the body section of the homepage.")
    public void subcategories_of_the_electronics_category_widget_is_displayed_in_the_body_section_of_the_homepage() {
        WebElement telephoneCategory = driver.findElement(By.xpath("//*[text()='Telephone']"));
        Assert.assertTrue(telephoneCategory.isDisplayed());
        LoggerHelper.info("Subcategories of the Electronics category widget is displayed in the body section of the homepage.");
    }

    @Then("{string} of the Electronics category widget is displayed in the body section of the homepage.")
    public void of_the_electronics_category_widget_is_displayed_in_the_body_section_of_the_homepage(String subCategory) {
        String path = "//*[text()='" + subCategory + "']";
        WebElement category = driver.findElement(By.xpath(path));

        ReusableMethods.waitForVisibility(category, 10);
        Assert.assertTrue(category.isDisplayed());
        LoggerHelper.info("Selected subcategory of the Electronics category widget is displayed in the body section of the homepage.");
    }

    @When("The user clicks on the {string} subcategory link")
    public void the_user_clicks_on_the_subcategory_link(String subCategory) {
        String path = "//*[text()='" + subCategory + "']";
        WebElement category = driver.findElement(By.xpath(path));

        ReusableMethods.waitForVisibility(category, 5);
        category.click();
        LoggerHelper.info("The user clicks on the selected subcategory link");
    }

    @Then("The {string} subcategory links to the relevant page with appropriate content")
    public void the_subcategory_links_to_the_relevant_page_with_appropriate_content(String subCategory) {

        String categoryText = homeCategoriesPage.subCategoryName.getText();
        Assert.assertEquals(subCategory.toUpperCase(), categoryText);
        LoggerHelper.info("Selected subcategory links to the relevant page with appropriate content");
    }

    @Then("The user verifies that Add to Cart icon is clickable")
    public void the_user_verifies_that_add_to_cart_icon_is_clickable() {

    }
    @Then("The user clicks on the Add to Cart icon")
    public void the_user_clicks_on_the_add_to_cart_icon() {

        WebElement addToCartIcon = driver.findElement(By.xpath("(//*[@title = 'Add to Cart'])[1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartIcon).perform();
        addToCartIcon.click();

        ReusableMethods.wait(3);
        LoggerHelper.info("The user clicks on the Add to Cart icon");

    }

    @Then("The user verifies that a confirmation message indicating that the product is added to cart is displayed.")
    public void the_user_verifies_that_a_confirmation_message_indicating_that_the_product_is_added_to_cart_is_displayed() {

        Assert.assertTrue(homeCategoriesPage.itemAddedConfirmationElement.isDisplayed());
        LoggerHelper.info("The user verifies that a confirmation message indicating that the product is added to cart is displayed.");

    }
    @When("The user clicks on the View Cart button")
    public void the_user_clicks_on_the_view_cart_button() {

        homeCategoriesPage.click(homeCategoriesPage.viewCartButton);
        LoggerHelper.info("The user clicks on the View Cart button");

    }

    @Then("The user is navigated to the Cart page.")
    public void the_user_is_navigated_to_the_cart_page() {

        String expectedUrl = "https://qa.buysellcycle.com/cart";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl);
        LoggerHelper.info("The user is navigated to the Cart page.");
    }

    @Then("The user verifies that Compare icon is displayed")
    public void the_user_verifies_that_compare_icon_is_displayed() {

        Assert.assertTrue(homeCategoriesPage.compareIcon.isDisplayed());
        LoggerHelper.info("The user verifies that Compare icon is displayed");

    }

    @Then("The user verifies and clicks on the compare icon of the first product")
    public void the_user_verifies_and_clicks_on_the_compare_icon_of_the_first_product() {

        ReusableMethods.waitForClickable(homeCategoriesPage.firstProductCard, 5);

        Actions actions = new Actions(driver);
        actions.moveToElement(homeCategoriesPage.firstProductCard).perform();

        ReusableMethods.waitForClickable(homeCategoriesPage.compareIcon, 5);

        Assert.assertTrue(homeCategoriesPage.compareIcon.isDisplayed());

        homeCategoriesPage.click(homeCategoriesPage.compareIcon);
        LoggerHelper.info("The user verifies and clicks on the compare icon of the first product");

    }
    @Then("The user verifies and clicks on the compare icon of the second product")
    public void the_user_verifies_and_clicks_on_the_compare_icon_of_the_second_product() {

        Actions actions = new Actions(driver);
        actions.moveToElement(homeCategoriesPage.secondProductCard).perform();

        Assert.assertTrue(homeCategoriesPage.compareIcon2.isDisplayed());
        homeCategoriesPage.click(homeCategoriesPage.compareIcon2);
        LoggerHelper.info("The user verifies and clicks on the compare icon of the second product");
    }

    @Then("The user verifies that a confirmation message indicating that the product is added to compare list is displayed.")
    public void the_user_verifies_that_a_confirmation_message_indicating_that_the_product_is_added_to_compare_list_is_displayed() {

        // compare kismina eklendi mesaji

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".toast-message")
        ));

        System.out.println(toastMessage.getText());
        Assert.assertTrue("Toast mesajı görünmüyor!", toastMessage.isDisplayed());
        Assert.assertTrue(toastMessage.getText().contains("Product added to compare list successfully"));
        LoggerHelper.info("The user verifies that a confirmation message indicating that the product is added to compare list is displayed.");

    }

    @When("The user clicks on the Compare link on the homepage")
    public void the_user_clicks_on_the_compare_link_on_the_homepage() {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homeHeaderPage.CompareLink);

        ReusableMethods.waitForClickable(homeHeaderPage.CompareLink, 5);
        ReusableMethods.clickWithToastCheck(homeHeaderPage.CompareLink);
        LoggerHelper.info("The user clicks on the Compare link on the homepage");

    }
    @Then("The user verifies to be navigated to the Compare page")
    public void the_user_verifies_to_be_navigated_to_the_compare_page() {


        String expectedUrl = "https://qa.buysellcycle.com/compare";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl);
        LoggerHelper.info("The user verifies to be navigated to the Compare page");

    }

    // Login
    @When("the user enters a valid email address and password and logs in")
    public void the_user_enters_a_valid_email_address_and_password_and_logs_in() {

        loginPages.emailInput.sendKeys(excelReader.getExcelText("Sheet1", 1, 0));
        loginPages.passwordInput.sendKeys(excelReader.getExcelText("Sheet1", 1, 1));

        Actions actions = new Actions(driver);
        actions.moveToElement(loginPages.SignInButton).perform();

        homeCategoriesPage.click(loginPages.SignInButton);
        LoggerHelper.info("the user enters a valid email address and password and logs in");

    }

    @Then("The user verifies that wishlist icon of a product is visible and clicks on the wishlist icon")
    public void the_user_verifies_that_wishlist_icon_of_a_product_is_visible_and_clicks_on_the_wishlist_icon() {

        Actions actions = new Actions(driver);
        actions.moveToElement(homeCategoriesPage.firstProductCard).perform();

        ReusableMethods.waitForVisibility(homeCategoriesPage.wishListIcon, 5);

        Assert.assertTrue(homeCategoriesPage.wishListIcon.isDisplayed());

        homeCategoriesPage.click(homeCategoriesPage.wishListIcon);
        LoggerHelper.info("TThe user verifies that wishlist icon of a product is visible and clicks on the wishlist icon");
    }


    @When("The user clicks on the Wishlist Link")
    public void the_user_clicks_on_the_wishlist_link()  {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", homeHeaderPage.WishlistLink);
        ReusableMethods.clickWithToastCheck(homeHeaderPage.WishlistLink);

        LoggerHelper.info("The user clicks on the Wishlist Link");

    }

    @Then("The user verifies that the product is added to the wishlist")
    public void the_user_verifies_that_the_product_is_added_to_the_wishlist() {

        String wishListResultText = homeCategoriesPage.wishResultSet.getText();

        String result = wishListResultText.substring(8, 9);

        int resultInt = Integer.parseInt(result);

        Assert.assertTrue(resultInt > 0);
        LoggerHelper.info("The user verifies that the product is added to the wishlist");
    }

    @Then("The user verifies and clicks on the Quick View icon of the product")
    public void the_user_verifies_and_clicks_on_the_quick_view_icon_of_the_product() {

        //Actions actions = new Actions(driver);
        //actions.moveToElement(homeCategoriesPage.firstProductCard).perform();

        ReusableMethods.waitForClickable(homeCategoriesPage.firstProductCard, 5);

        ReusableMethods.hover(homeCategoriesPage.quickViewIcon);

        Assert.assertTrue(homeCategoriesPage.quickViewIcon.isDisplayed());

        homeCategoriesPage.click(homeCategoriesPage.quickViewIcon);
        LoggerHelper.info("The user verifies and clicks on the Quick View icon of the product");

    }
    @Then("The user verifies that product details are shown on the pop up window")
    public void the_user_verifies_that_product_details_are_shown_on_the_pop_up_window() {

        ReusableMethods.waitForVisibility(homeCategoriesPage.quickViewAddToCartButton, 5);

        Assert.assertTrue(homeCategoriesPage.quickViewAddToCartButton.isDisplayed());
        LoggerHelper.info("The user verifies that product details are shown on the pop up window");

    }
    @And("The user closes the product details window")
    public void the_user_closes_the_product_details_window() {

        ReusableMethods.waitForClickable(homeCategoriesPage.quickViewAddToCartButton, 5);
        homeCategoriesPage.click(homeCategoriesPage.closeProductDetailsWindow);
        LoggerHelper.info("The user closes the product details window");
    }

    @Then("The user verifies that more products can be displayed in the Electronics window.")
    public void the_user_verifies_that_more_products_can_be_displayed_in_the_electronics_window() {

        ReusableMethods.waitForVisibility(homeCategoriesPage.showMoreItemsDropDown, 5);

        Assert.assertTrue(homeCategoriesPage.showMoreItemsDropDown.isDisplayed());
        LoggerHelper.info("The user verifies that more products can be displayed in the Electronics window.");
    }

    // US_036

    @Given("The admin opens the browser and navigates to admin login page")
    public void the_admin_opens_the_browser_and_navigates_to_admin_login_page() {

        String adminLoginUrl = "https://qa.buysellcycle.com/admin/login";
        driver.get(adminLoginUrl);
        LoggerHelper.info("The admin opens the browser and navigates to admin login page");
    }

    @When("The admin waits for the page to fully load.")
    public void the_admin_waits_for_the_page_to_fully_load() throws InterruptedException {
        Thread.sleep(3000);
        LoggerHelper.info("The admin waits for the page to fully load.");
    }

    @When("The admin logs in to the system with a valid administrator account")
    public void the_admin_logs_in_to_the_system_with_a_valid_administrator_account() {

        adminProfileNotificationsPage.adminLogin();
        LoggerHelper.info("The admin logs in to the system with a valid administrator account");
    }

    @Then("The admin verifies that the profile icon is visible in the top bar of the Admin Dashboard")
    public void the_admin_verifies_that_the_profile_icon_is_visible() {

        ReusableMethods.waitForVisibility(adminProfileNotificationsPage.adminProfilePicture, 5);

        Assert.assertTrue(adminProfileNotificationsPage.adminProfilePicture.isDisplayed());
        LoggerHelper.info("The admin verifies that the profile icon is visible in the top bar of the Admin Dashboard");


    }

    @When("The admin hovers over the the profile icon")
    public void the_admin_hovers_over_the_the_profile_icon() {

        ReusableMethods.safeHover(adminProfileNotificationsPage.adminProfilePicture);
        LoggerHelper.info("The admin hovers over the the profile icon");
    }

    @When("The admin verifies that My profile link appears in the window that opens.")
    public void the_admin_verifies_that_my_profile_link_appears_in_the_window_that_opens() {


        ReusableMethods.hoverWithToastCheck(adminProfileNotificationsPage.adminProfilePicture);
        Assert.assertTrue(adminProfileNotificationsPage.adminMyProfileLink.isDisplayed());
        LoggerHelper.info("The admin verifies that My profile link appears in the window that opens.");

    }

    @When("The admin clicks the My profile link")
    public void the_admin_clicks_the_my_profile_link() {

        ReusableMethods.waitForClickable(adminProfileNotificationsPage.adminMyProfileLink, 5);
        adminProfileNotificationsPage.adminMyProfileLink.click();
        LoggerHelper.info("The admin clicks the My profile link");

    }

    @Then("The admin verifies that the profile page is displayed")
    public void the_admin_verifies_that_the_profile_page_is_displayed() {

        ReusableMethods.waitForVisibility(adminProfileNotificationsPage.basicInfoLabel, 5);
        Assert.assertTrue(adminProfileNotificationsPage.basicInfoLabel.isDisplayed());
        LoggerHelper.info("The admin verifies that the profile page is displayed");

    }

    @Then("The admin verifies that First Name, Last Name, E-mail Address, Phone Number, Date of Birth are displayed in the Basic Info section on the profile page.")
    public void the_admin_verifies_that_first_name_last_name_e_mail_address_phone_number_date_of_birth_are_displayed_in_the_basic_info_section_on_the_profile_page() {

        ReusableMethods.waitForVisibility(adminProfileNotificationsPage.basicInfoLastNameTextBox, 5);

        Assert.assertTrue(adminProfileNotificationsPage.basicInfoFirstNameTextBox.isDisplayed());
        Assert.assertTrue(adminProfileNotificationsPage.basicInfoLastNameTextBox.isDisplayed());
        Assert.assertTrue(adminProfileNotificationsPage.basicInfoEmailTextBox.isDisplayed());
        Assert.assertTrue(adminProfileNotificationsPage.basicInfoDateOfBirthTextBox.isDisplayed());
        LoggerHelper.info("The admin verifies that First Name, Last Name, E-mail Address, Phone Number, Date of Birth are displayed in the Basic Info section on the profile page.");

    }

    @Then("The admin verifies that First Name, Last Name, E-mail Address, Phone Number, Date of Birth can be updated displayed in the Basic Info section on the profile page.")
    public void the_admin_verifies_that_first_name_last_name_e_mail_address_phone_number_date_of_birth_can_be_updated_displayed_in_the_basic_info_section_on_the_profile_page() {

        // Admin Profile Update
        adminProfileNotificationsPage.basicInfoFirstNameTextBox.clear();
        adminProfileNotificationsPage.basicInfoFirstNameTextBox.sendKeys(excelReader.getExcelText("adminSheet2", 1, 0));

        adminProfileNotificationsPage.basicInfoLastNameTextBox.clear();
        adminProfileNotificationsPage.basicInfoLastNameTextBox.sendKeys(excelReader.getExcelText("adminSheet2", 1, 1));

        adminProfileNotificationsPage.basicInfoEmailTextBox.clear();
        adminProfileNotificationsPage.basicInfoEmailTextBox.sendKeys(excelReader.getExcelText("adminSheet2", 1, 2));

        adminProfileNotificationsPage.basicInfoPhoneTextBox.clear();
        adminProfileNotificationsPage.basicInfoPhoneTextBox.sendKeys(excelReader.getExcelText("adminSheet2", 1, 3));

        adminProfileNotificationsPage.basicInfoDateOfBirthTextBox.clear();
        adminProfileNotificationsPage.basicInfoDateOfBirthTextBox.sendKeys(excelReader.getExcelText("adminSheet2", 1, 4));

        ReusableMethods.waitForClickable(adminProfileNotificationsPage.basicInfoUpdateInfoButton, 5);
        adminProfileNotificationsPage.basicInfoUpdateInfoButton.click();

        ReusableMethods.waitForClickable(adminProfileNotificationsPage.basicInfoHeaderButton, 5);
        adminProfileNotificationsPage.basicInfoHeaderButton.click();

        LoggerHelper.info("The admin verifies that First Name, Last Name, E-mail Address, Phone Number, Date of Birth can be updated displayed in the Basic Info section on the profile page.");

    }

    @When("The admin enters an invalid Date of Birth Info on the profile page and clicks Update button")
    public void the_admin_enters_an_invalid_date_of_birth_info_on_the_profile_page_and_clicks_update_button() {

        adminProfileNotificationsPage.basicInfoDateOfBirthTextBox.clear();
        adminProfileNotificationsPage.basicInfoDateOfBirthTextBox.sendKeys(excelReader.getExcelText("adminSheet3", 1, 0));

        ReusableMethods.waitForClickable(adminProfileNotificationsPage.basicInfoUpdateInfoButton, 5);
        adminProfileNotificationsPage.basicInfoUpdateInfoButton.click();

        LoggerHelper.info("The admin enters an invalid Date of Birth Info on the profile page and clicks Update button");

    }
    @Then("The admin verifies that an error message indicating invalid Date of Birth Info is displayed.")
    public void the_admin_verifies_that_an_error_message_indicating_invalid_date_of_birth_info_is_displayed() {

        WebElement actualErrorMessageWE = driver.findElement(By.xpath("//*[text()='The date of birth must be a date before or equal to 01-01-2007.']"));
        ReusableMethods.waitForVisibility(actualErrorMessageWE, 5);

        String actualErrorMessage = actualErrorMessageWE.getText();

        String expectedErrorMessage = "The date of birth must be a date before or equal to 01-01-2007.";

        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

        LoggerHelper.info("The admin verifies that an error message indicating invalid Date of Birth Info is displayed.");

    }

    // [US_036 => TC-07] Verify that an error is shown when the Phone Number  contains characters other than digits.
    @When("The admin enters Phone Number Info that contains characters other than digits.")
    public void the_admin_enters_phone_number_info_that_contains_characters_other_than_digits() {

        adminProfileNotificationsPage.basicInfoPhoneTextBox.clear();
        adminProfileNotificationsPage.basicInfoPhoneTextBox.sendKeys(excelReader.getExcelText("adminSheet4", 1, 0));

        ReusableMethods.waitForClickable(adminProfileNotificationsPage.basicInfoUpdateInfoButton, 5);
        adminProfileNotificationsPage.basicInfoUpdateInfoButton.click();

        LoggerHelper.info("The admin enters Phone Number Info that contains characters other than digits.");
    }
    @Then("The admin verifies that an error is shown that the Phone Number contains characters other than digits.")
    public void the_admin_verifies_that_an_error_is_shown_that_the_phone_number_contains_characters_other_than_digits() {

        String actualValue = adminProfileNotificationsPage.basicInfoPhoneTextBox.getAttribute("value");

        System.out.println("actualValue is: " + actualValue);

        String input = excelReader.getExcelText("adminSheet4", 1, 0);

        //String expectedErrorMessage = "Phone Number should contain only digits";

        Assert.assertNotEquals(input, actualValue);
        LoggerHelper.info("The admin verifies that an error is shown that the Phone Number contains characters other than digits.");
    }

    // [US_036 => TC-08] Verify that an error is shown when the Phone Number is less than 10 digits
    @When("The admin enters an invalid Date Phone containing number of digits less than {int} and clicks Update button")
    public void the_admin_enters_an_invalid_date_phone_containing_number_of_digits_less_than_and_clicks_update_button(Integer int1) {

        adminProfileNotificationsPage.basicInfoPhoneTextBox.clear();
        adminProfileNotificationsPage.basicInfoPhoneTextBox.sendKeys(excelReader.getExcelText("adminSheet4", 2, 0));

        ReusableMethods.waitForClickable(adminProfileNotificationsPage.basicInfoUpdateInfoButton, 5);
        adminProfileNotificationsPage.basicInfoUpdateInfoButton.click();

        //ReusableMethods.wait(5);
        //LoggerHelper.info("The admin enters an invalid Date Phone containing number of digits less than 10 and clicks Update button");
    }
    @Then("The admin verifies that an error is shown that the Phone Number is less than {int} digits")
    public void the_admin_verifies_that_an_error_is_shown_that_the_phone_number_is_less_than_digits(Integer numOfDigits) {

        WebElement actualErrorMessageWE = driver.findElement(By.xpath("//*[text()='Minimum 10 digits required on phone number']"));
        ReusableMethods.waitForVisibility(actualErrorMessageWE, 5);

        String actualErrorMessage = actualErrorMessageWE.getText();

        String expectedErrorMessage = "Minimum 10 digits required on phone number";

        //ReusableMethods.wait(5);

        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

        LoggerHelper.info("The admin verifies that an error is shown that the Phone Number is less than 10 digits");
    }


    @When("The admin leaves the Phone Number Field blank and clicks Update button")
    public void the_admin_leaves_the_phone_number_field_blank_and_clicks_update_button() {

        adminProfileNotificationsPage.basicInfoPhoneTextBox.clear();
        adminProfileNotificationsPage.basicInfoPhoneTextBox.sendKeys("");

        ReusableMethods.waitForClickable(adminProfileNotificationsPage.basicInfoUpdateInfoButton, 5);
        adminProfileNotificationsPage.basicInfoUpdateInfoButton.click();

        //ReusableMethods.wait(5);

        LoggerHelper.info("The admin leaves the Phone Number Field blank and clicks Update button");
    }
    @Then("The admin verifies that an error is shown that the Phone Number is blank")
    public void the_admin_verifies_that_an_error_is_shown_that_the_phone_number_is_blank() {

        WebElement actualErrorMessageWE = driver.findElement(By.xpath("//*[text()='The phone field is required.']"));
        ReusableMethods.waitForVisibility(actualErrorMessageWE, 5);

        String actualErrorMessage = actualErrorMessageWE.getText();

        String expectedErrorMessage = "The phone field is required.";

        System.out.println("actualErrorMessage is: " + actualErrorMessage);

        //ReusableMethods.wait(5);

        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

        LoggerHelper.info("The admin verifies that an error is shown that the Phone Number is blank");
    }

    @When("The admin leaves the First Name Field blank and clicks Update button")
    public void the_admin_leaves_the_first_name_field_blank_and_clicks_update_button() {

        adminProfileNotificationsPage.basicInfoFirstNameTextBox.clear();
        adminProfileNotificationsPage.basicInfoFirstNameTextBox.sendKeys("");

        ReusableMethods.waitForClickable(adminProfileNotificationsPage.basicInfoUpdateInfoButton, 5);
        adminProfileNotificationsPage.basicInfoUpdateInfoButton.click();

        //ReusableMethods.wait(5);
        LoggerHelper.info("The admin leaves the First Name Field blank and clicks Update button");

    }
    @Then("The admin verifies that an error is shown that First Name is blank")
    public void the_admin_verifies_that_an_error_is_shown_that_first_name_is_blank() {

        WebElement actualErrorMessageWE = driver.findElement(By.xpath("//*[text()='The first name field is required.']"));
        ReusableMethods.waitForVisibility(actualErrorMessageWE, 5);

        String actualErrorMessage = actualErrorMessageWE.getText();
        String expectedErrorMessage = "The first name field is required.";

        //ReusableMethods.wait(5);

        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        LoggerHelper.info("The admin verifies that an error is shown that First Name is blank");
    }
    @When("The admin leaves the email field blank and clicks update button")
    public void the_admin_leaves_the_email_field_blank_and_clicks_update_button() {

        adminProfileNotificationsPage.basicInfoEmailTextBox.clear();
        adminProfileNotificationsPage.basicInfoEmailTextBox.sendKeys("");

        ReusableMethods.waitForClickable(adminProfileNotificationsPage.basicInfoUpdateInfoButton, 5);
        adminProfileNotificationsPage.basicInfoUpdateInfoButton.click();

        //ReusableMethods.wait(5);
        LoggerHelper.info("The admin leaves the email field blank and clicks update button");
    }

    @Then("The admin verifies that an error is shown that Email is blank")
    public void the_admin_verifies_that_an_error_is_shown_that_email_is_blank() {

        WebElement actualErrorMessageWE = driver.findElement(By.xpath("//*[text()='The email field is required.']"));
        ReusableMethods.waitForVisibility(actualErrorMessageWE, 5);

        String actualErrorMessage = actualErrorMessageWE.getText();
        String expectedErrorMessage = "The email field is required.";

        //ReusableMethods.wait(5);

        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        LoggerHelper.info("The admin verifies that an error is shown that Email is blank");

    }

    //The email must be a valid email address.

    @When("The admin enters an invalid format email and clicks Update button")
    public void the_admin_enters_an_invalid_format_email_and_clicks_update_button() {

        adminProfileNotificationsPage.basicInfoEmailTextBox.clear();
        adminProfileNotificationsPage.basicInfoEmailTextBox.sendKeys(excelReader.getExcelText("adminSheet5", 1, 0));

        ReusableMethods.waitForClickable(adminProfileNotificationsPage.basicInfoUpdateInfoButton, 5);
        adminProfileNotificationsPage.basicInfoUpdateInfoButton.click();
        LoggerHelper.info("The admin enters an invalid format email and clicks Update button");

    }
    @Then("The admin verifies that an error is shown that the email has an invalid format")
    public void the_admin_verifies_that_an_error_is_shown_that_the_email_has_an_invalid_format() {

        WebElement actualErrorMessageWE = driver.findElement(By.xpath("//*[text()='The email must be a valid email address.']"));
        ReusableMethods.waitForVisibility(actualErrorMessageWE, 5);

        String actualErrorMessage = actualErrorMessageWE.getText();
        String expectedErrorMessage = "The email must be a valid email address.";

        ReusableMethods.wait(5);

        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        LoggerHelper.info("The admin verifies that an error is shown that the email has an invalid format");
    }

    @When("The admin clicks the Address button")
    public void the_admin_clicks_the_address_button() {

        ReusableMethods.waitForClickable(adminProfileNotificationsPage.addressButton, 5);

        adminProfileNotificationsPage.addressButton.click();
        LoggerHelper.info("The admin clicks the Address button");

    }
    @Then("The admin verifies that address information is displayed")
    public void the_admin_verifies_that_address_information_is_displayed() {

        ReusableMethods.waitForVisibility(adminProfileNotificationsPage.addNewAddressButton, 5);

        Assert.assertTrue(adminProfileNotificationsPage.addNewAddressButton.isDisplayed());
        LoggerHelper.info("The admin verifies that address information is displayed");

    }

    @When("The admin clicks on Add New Address button")
    public void the_admin_clicks_on_add_new_address_button() {

        ReusableMethods.waitForClickable(adminProfileNotificationsPage.addNewAddressButton, 5);

        adminProfileNotificationsPage.addNewAddressButton.click();
        LoggerHelper.info("The admin clicks on Add New Address button");

    }
    @Then("The admin verifies that a new Address Form is displayed")
    public void the_admin_verifies_that_a_new_address_form_is_displayed() {

        ReusableMethods.waitForVisibility(adminProfileNotificationsPage.addressNameTextBox, 5);

        Assert.assertTrue(adminProfileNotificationsPage.addressNameTextBox.isDisplayed());
        LoggerHelper.info("The admin verifies that a new Address Form is displayed");


    }
    @When("The admin enters Name, Phone, Email, Address, Country, State, City and Postal Code in the Address form")
    public void the_admin_enters_name_phone_email_address_country_state_city_and_postal_code_in_the_address_form() {

        adminProfileNotificationsPage.addressNameTextBox.clear();
        adminProfileNotificationsPage.addressNameTextBox.sendKeys(excelReader.getExcelText("adminSheet6", 1, 0));

        adminProfileNotificationsPage.customerPhoneTextBox.clear();
        adminProfileNotificationsPage.customerPhoneTextBox.sendKeys(excelReader.getExcelText("adminSheet6", 1, 1));

        adminProfileNotificationsPage.emailAddressTextBox.clear();
        adminProfileNotificationsPage.emailAddressTextBox.sendKeys(excelReader.getExcelText("adminSheet6", 1, 2));

        adminProfileNotificationsPage.addressTextBox.clear();
        adminProfileNotificationsPage.addressTextBox.sendKeys(excelReader.getExcelText("adminSheet6", 1, 3));

        //adminProfileNotificationsPage.cityDropDown.clear();

        ReusableMethods.wait(5);

        adminProfileNotificationsPage.cityDropDown.click();

        String selectedCity = excelReader.getExcelText("adminSheet6", 1, 6);

        String path = "//li[contains(@class, 'option') and normalize-space(text())='" + selectedCity + "']";

        WebElement cityOption = driver.findElement(By.xpath(path));

        ReusableMethods.waitForClickable(cityOption, 5);
        cityOption.click();

        adminProfileNotificationsPage.postalCodeTextBox.clear();
        adminProfileNotificationsPage.postalCodeTextBox.sendKeys(excelReader.getExcelText("adminSheet6", 1, 7));

        ReusableMethods.wait(15);
        LoggerHelper.info("The admin enters Name, Phone, Email, Address, Country, State, City and Postal Code in the Address form");

    }
    @When("The admin clicks on the Save button")
    public void the_admin_clicks_on_the_save_button() {

        ReusableMethods.waitForClickable(adminProfileNotificationsPage.saveAddressButton, 5);

        adminProfileNotificationsPage.saveAddressButton.click();
        LoggerHelper.info("The admin clicks on the Save button");

    }
    @Then("The admin verifies that the address is saved in the address list")
    public void the_admin_verifies_that_the_address_is_saved_in_the_address_list() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".toast-message")
        ));

        System.out.println(toastMessage.getText());
        Assert.assertTrue("Toast mesajı görünmüyor!", toastMessage.isDisplayed());
        Assert.assertTrue(toastMessage.getText().contains("success"));
        LoggerHelper.info("The admin verifies that the address is saved in the address list");

    }

    @And("The admin hovers over the admin profile icon and presses Logout.")
    public void hoverOverTheAdminProfilePhotoAndPressLogout() {

        Actions actions = new Actions(driver);
        actions.moveToElement(adminProfileNotificationsPage.adminProfilePicture).perform();
        ReusableMethods.wait(2);
        actions.click(loginPages.logoutButton).perform();
        ReusableMethods.wait(2);
        LoggerHelper.info("The admin hovers over the admin profile icon and presses Logout.");
    }

















}
