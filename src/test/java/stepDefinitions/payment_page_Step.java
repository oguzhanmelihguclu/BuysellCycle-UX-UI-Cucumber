package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CartCheckoutPage;
import pages.UserDashboardPage;
import utilities.ExcelReader;
import utilities.JSUtilities;
import utilities.ReusableMethods;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class payment_page_Step {

    private static final Logger logger = LogManager.getLogger();
    WebDriver driver = Hooks.getDriver();
    CartCheckoutPage cartCheckoutPage = new CartCheckoutPage(driver);
    UserDashboardPage userDashboardPage = new UserDashboardPage(driver);
    ExcelReader excelReader = new ExcelReader("src/test/resources/TestData.xlsx");
    String regex;
    WebElement iframe;

    @And("The user's cart contains at least one product.")
    public void the_user_s_cart_contains_at_least_one_product() {

        cartCheckoutPage.addProductToCart();
        logger.info("The user's cart contains at least one product.");
    }

    @When("The user is on the Checkout page.")
    public void the_user_is_on_the_checkout_page() {

        ReusableMethods.wait(5);
        JSUtilities.clickWithJS(driver, cartCheckoutPage.proceedToCheckoutButton);
        logger.info("The user is on the Checkout page.");
    }

    @And("The user clicks on the Continue to Shipping button.")
    public void theUserClicksOnTheContinueToShippingButton() {

        ReusableMethods.wait(5);

        String newAddressAttribute = cartCheckoutPage.newAddress.getAttribute("class");
        boolean isNewAddressSelected = newAddressAttribute.contains("selected");

        if (isNewAddressSelected) {
            logger.info("'New Address' is selected. Scrolling down and selecting address option.");

            JSUtilities.scrollsToElement(driver, cartCheckoutPage.newAddress);
            ReusableMethods.wait(3);

            JSUtilities.clickWithJS(driver, cartCheckoutPage.addressDdm);
            logger.info("Address dropdown clicked.");

            JSUtilities.clickWithJS(driver, cartCheckoutPage.option);
            logger.info("Address option selected.");
        }

        JSUtilities.scrollsToElement(driver, cartCheckoutPage.continueToShippingButton);
        ReusableMethods.wait(3);

        JSUtilities.clickWithJS(driver, cartCheckoutPage.continueToShippingButton);
        logger.info("'Continue to Shipping' button clicked.");
        ReusableMethods.wait(3);
    }

    @Then("The user tests to be redirected to the Payment page.")
    public void the_user_tests_to_be_redirected_to_the_payment_page() {

        assertTrue(driver.getCurrentUrl().contains("payment"));
        logger.info("The user tests to be redirected to the Payment page.");
    }

    @Then("The user verifies that the Ship to is displayed on the Payment page.")
    public void theUserVerifiesThatTheShipToIsDisplayedOnThePaymentPage() {

        assertTrue(cartCheckoutPage.shipToInfo.isDisplayed());
        logger.info("The user verifies that the Ship to is displayed on the Payment page.");
    }

    @When("The user clicks on the Change Ship To button.")
    public void theUserClicksOnTheChangeShipToButton() {

        cartCheckoutPage.changeShipToButton.click();
        logger.info("The user clicks on the Change Ship To button.");
    }

    @Then("The user tests that Ship To information can be changed.")
    public void theUserTestsThatShipToInformationCanBeChanged() {

        cartCheckoutPage.changeShipToButton.click();
        logger.info("The user clicked the 'Change Ship To' button.");

        String currentUrl = driver.getCurrentUrl();
        logger.info("Current URL after clicking: {}", currentUrl);

        assertTrue(currentUrl.contains("ship"));
        logger.info("The user tests that Ship To information can be changed.");
    }

    @And("The user verifies that the Contact Information is displayed on the Payment page.")
    public void theUserVerifiesThatTheContactInformationIsDisplayedOnThePaymentPage() {

        assertTrue(cartCheckoutPage.contactInfo.isDisplayed());
        logger.info("The user verifies that the Contact Information is displayed on the Payment page.");
    }

    @When("The user clicks on the Change Contact button.")
    public void theUserClicksOnTheChangeContactButton() {

        cartCheckoutPage.changeContactButton.click();
        logger.info("The user clicked the 'Change Contact' button.");
    }

    @And("The user tests that the Contact information can be changed.")
    public void theUserTestsThatTheContactInformationCanBeChanged() {

        cartCheckoutPage.changeContactButton.click();
        String currentUrl = driver.getCurrentUrl();
        logger.info(" Current URL after clicking: {}", currentUrl);

        assertTrue(currentUrl.contains("contact"));
        logger.info("The user tests that the Contact information can be changed.");
    }

    @Then("The user verifies that Payment type is selectable on the Payment page.")
    public void theUserVerifiesThatPaymentTypeIsSelectableOnThePaymentPage() {

        assertTrue(cartCheckoutPage.stripeRadioButton.isEnabled());
        logger.info("Stripe button is enabled on the Payment page.");

        JSUtilities.clickWithJS(driver, cartCheckoutPage.stripeRadioButton);
        logger.info("The user clicked the 'Stripe' button.");

        assertTrue(cartCheckoutPage.stripeRadioButton.isSelected());
        logger.info("Stripe button is selected on the Payment page.");
    }

    @Then("The user verifies that Billing address is selectable on the Payment page.")
    public void theUserVerifiesThatBillingAddressIsSelectableOnThePaymentPage() {

        assertTrue(cartCheckoutPage.billingRadioButton.isEnabled());
        logger.info("Billing Address is enabled on the Payment page.");

        JSUtilities.clickWithJS(driver, cartCheckoutPage.billingRadioButton);
        logger.info("The user clicked the 'Billing Address' button.");

        assertTrue(cartCheckoutPage.billingRadioButton.isSelected());
        logger.info("Billing Address button is selected on the Payment page.");
    }

    @Then("The user verifies that Order Summary section is displayed on the Payment page.")
    public void the_user_verifies_that_order_summary_section_is_displayed_on_the_payment_page() {

        assertTrue(cartCheckoutPage.orderSummary.isDisplayed());
        logger.info("The user verifies that Order Summary section is displayed on the Payment page.");
    }

    @Then("The user verifies that The Subtotal field is displayed correctly.")
    public void the_user_verifies_that_the_subtotal_field_is_displayed_correctly() {

        assertTrue(cartCheckoutPage.subtotal.isDisplayed());
        logger.info("The user verifies that The Subtotal field is displayed correctly.");

        String subtotalText = cartCheckoutPage.subtotal.getText().trim();
        regex = "\\+?\\s?\\$\\s?\\d{1,3}(,\\d{3})*(\\.\\d{2})?";
        assertTrue(subtotalText.matches(regex));
    }

    @Then("The user verifies that The Shipping Charge field is displayed correctly.")
    public void the_user_verifies_that_the_shipping_charge_field_is_displayed_correctly() {

        assertTrue(cartCheckoutPage.shippingCharge.isDisplayed());
        logger.info("The user verifies that The Shipping Charge field is displayed correctly.");

        String shippingChargeText = cartCheckoutPage.shippingCharge.getText().trim();
        assertTrue(shippingChargeText.matches(regex));
    }

    @Then("The user verifies that The VAT_TAX_GST field is displayed correctly.")
    public void theUserVerifiesThatTheVATTAXGSTFieldIsDisplayedCorrectly() {

        assertTrue(cartCheckoutPage.vatTaxGst.isDisplayed());
        logger.info("The user verifies that The VAT_TAX_GST field is displayed correctly.");

        String vatTaxGstText = cartCheckoutPage.vatTaxGst.getText().trim();
        System.out.println(vatTaxGstText);

        regex = "\\+?\\s?\\$\\s?\\d{1,3}(,\\d{3})*(\\.\\d{2})?";
        assertTrue(vatTaxGstText.matches(regex));
    }

    @Then("The user verifies that The Discount field is displayed correctly.")
    public void the_user_verifies_that_the_discount_field_is_displayed_correctly() {

        assertTrue(cartCheckoutPage.discount.isDisplayed());
        logger.info("The user verifies that The Discount field is displayed correctly.");

        String discountText = cartCheckoutPage.discount.getText().trim();
        regex = "-?\\s?\\$\\s?\\d{1,3}(,\\d{3})*(\\.\\d{2})?";

        assertTrue(discountText.matches(regex));
    }

    @Then("The user verifies that The Coupon Code field is displayed correctly.")
    public void the_user_verifies_that_the_coupon_code_field_is_displayed_correctly() {

        assertTrue(cartCheckoutPage.couponCodeInput.isDisplayed());
        logger.info("The user verifies that The Coupon Code field is displayed correctly.");
    }

    @Then("The user verifies that The Total field is displayed correctly.")
    public void theUserVerifiesThatTheTotalFieldIsDisplayedCorrectly() {

        assertTrue(cartCheckoutPage.total.isDisplayed());
        logger.info("The user verifies that The Total field is displayed correctly.");

        String totalText = cartCheckoutPage.total.getText().trim();
        regex = "\\s?\\$\\s?\\d{1,3}(,\\d{3})*(\\.\\d{2})?";
        assertTrue(totalText.matches(regex));
    }

    @When("The user enters valid coupon code in Coupon Code field.")
    public void the_user_enters_valid_coupon_code_in_field() {

        cartCheckoutPage.couponCodeInput.clear();
        cartCheckoutPage.couponCodeInput.sendKeys(excelReader.getExcelText("Sheet5", 1, 0));
        cartCheckoutPage.applyButton.click();
        logger.info("The user enters valid coupon code in Coupon Code field.");
    }

    @Then("The user verifies that the coupon is valid on the payment page.")
    public void the_user_verifies_that_the_coupon_is_valid_on_the_payment_page() {

        assertTrue(cartCheckoutPage.couponConfirm.isDisplayed());
        logger.info("The user verifies that the coupon is valid on the payment page.");
    }

    @Then("The user verifies that the total amount to be paid has been updated.")
    public void user_verifies_that_the_total_amount_to_be_paid_has_been_updated() {

        assertTrue(cartCheckoutPage.couponDiscount.isDisplayed());
        logger.info("The user verifies that the total amount to be paid has been updated.");
    }

    @Then("The user verifies that the Return To Information button is displayed.")
    public void the_user_verifies_that_the_return_to_ınformation_button_is_displayed() {

        JSUtilities.scrollsToElement(driver, cartCheckoutPage.returnToInformation);
        assertTrue(cartCheckoutPage.returnToInformation.isDisplayed());
        logger.info("The user verifies that the Return To Information button is displayed.");
    }

    @Then("The user verifies that the Return To Information button is clickable.")
    public void the_user_verifies_that_the_return_to_ınformation_button_is_clickable() {

        JSUtilities.clickWithJS(driver, cartCheckoutPage.returnToInformation);
        assertTrue(cartCheckoutPage.orderSummary.isDisplayed());
        logger.info("The user verifies that the Return To Information button is clickable.");

        JSUtilities.clickWithJS(driver, cartCheckoutPage.continueToShippingButton);
    }

    @Then("The user verifies that the Order Now button is displayed.")
    public void the_user_verifies_that_the_order_now_button_is_displayed() {

        JSUtilities.scrollsToElement(driver, cartCheckoutPage.orderNowButton);
        assertTrue(cartCheckoutPage.orderNowButton.isDisplayed());
        logger.info("The user verifies that the Order Now button is displayed.");
    }

    @Then("The user verifies that the Order Now button is clickable.")
    public void the_user_verifies_that_the_order_now_button_is_clickable() {

        if (!cartCheckoutPage.stripeButton.isSelected()) {
            JSUtilities.clickWithJS(driver, cartCheckoutPage.stripeButton);
        }

        ReusableMethods.wait(10);
        JSUtilities.clickWithJS(driver, cartCheckoutPage.orderNowButton);

        iframe = driver.findElement(By.xpath("//iframe[@class='stripe_checkout_app']"));
        driver.switchTo().frame(iframe);
        ReusableMethods.wait(2);
        assertTrue(userDashboardPage.payButton.isDisplayed());
        ReusableMethods.wait(2);
        userDashboardPage.closeButton.click();
        driver.switchTo().defaultContent();
        ReusableMethods.wait(5);
        logger.info("The user verifies that the Order Now button is clickable.");
    }

    @When("The user clicks the Order Now button.")
    public void the_user_clicks_the_order_now_button() {

        JSUtilities.scrollsToElement(driver, cartCheckoutPage.orderNowButton);
        ReusableMethods.wait(2);

        if (!cartCheckoutPage.stripeButton.isSelected()) {

            JSUtilities.clickWithJS(driver, cartCheckoutPage.stripeButton);
            ReusableMethods.wait(2);
        }

        JSUtilities.clickWithJS(driver, cartCheckoutPage.orderNowButton);
        logger.info("The user clicks the Order Now button.");
        ReusableMethods.wait(2);
    }

    @Then("The user should be immediately navigated to the order confirmation page.")
    public void theUserShouldBeImmediatelyNavigatedToTheOrderConfirmationPage() {

        userDashboardPage.validStripePayment();
        driver.switchTo().defaultContent();
        logger.info("The user should be immediately navigated to the order confirmation page.");
    }

    @Then("The user verifies that {string} is displayed.")
    public void the_user_verifies_that_is_displayed(String msg) {

        assertTrue(cartCheckoutPage.thankYouForYourPurchaseText.isDisplayed());
        logger.info("The user verifies that {string} is displayed.");
    }

    @Then("The user verifies that The Order Number is displayed.")
    public void the_user_verifies_that_the_order_number_is_displayed() {

        assertTrue(cartCheckoutPage.orderNumberText.isDisplayed());
        logger.info("The user verifies that The Order Number is displayed.");
    }

    @Then("The user verifies that purchased item details are displayed.")
    public void the_user_verifies_that_purchased_item_details_are_displayed() {

        assertTrue(cartCheckoutPage.itemsPurchased.isDisplayed());
        logger.info("The user verifies that purchased item details are displayed.");
    }

    @When("The user clicks on the View Order button.")
    public void theUserClicksOnTheViewOrderButton() {

        ReusableMethods.wait(7);
        cartCheckoutPage.viewOrderButton.click();
        logger.info("The user clicks on the View Order button.");
    }

    @And("The user verifies that the details of the purchased items are displayed.")
    public void theUserVerifiesThatTheDetailsOfThePurchasedItemsAreDisplayed() {

        String expectedUrlContent = "purchase";
        String actualUrl = driver.getCurrentUrl();

        assertTrue(expectedUrlContent, actualUrl.contains(expectedUrlContent));
        logger.info("The user verifies that the details of the purchased items are displayed.");
    }

    @When("The user clicks on the Continue Shopping button.")
    public void theUserClicksOnTheContinueShoppingButton() {

        JSUtilities.scrollsToElement(driver, cartCheckoutPage.continueShoppingButton);
        ReusableMethods.wait(3);
        JSUtilities.clickWithJS(driver, cartCheckoutPage.continueShoppingButton);
        logger.info("The user clicks on the Continue Shopping button.");
    }

    @Then("The user verifies that The Home Page is displayed.")
    public void theUserVerifiesThatTheHomePageIsDisplayed() {

        ReusableMethods.wait(3);
        String expectedUrl = "https://qa.buysellcycle.com/";
        String actualUrl = driver.getCurrentUrl();

        assertEquals(expectedUrl, actualUrl);
        logger.info("The user verifies that The Home Page is displayed.");
    }

    @When("The user enters invalid coupon code in Coupon Code field.")
    public void the_user_enters_invalid_coupon_code_in_coupon_code_field() {

        cartCheckoutPage.couponCodeInput.clear();
        cartCheckoutPage.couponCodeInput.sendKeys(excelReader.getExcelText("Sheet6", 1, 0));
        ReusableMethods.wait(5);
        cartCheckoutPage.applyButton.click();
        ReusableMethods.wait(2);
        logger.info("The user enters invalid coupon code in Coupon Code field.");
    }

    @Then("The user verifies that the coupon is invalid on the payment page.")
    public void the_user_verifies_that_the_coupon_is_invalid_on_the_payment_page() {

        assertTrue(cartCheckoutPage.applyButton.isDisplayed());
        logger.info("The user verifies that the coupon is invalid on the payment page.");
    }

    @Then("The user verifies that the total amount to be paid has not been updated.")
    public void the_user_verifies_that_the_total_amount_to_be_paid_has_not_been_updated() {

        assertFalse(cartCheckoutPage.couponDiscount.isDisplayed());
        logger.info("The user verifies that the total amount to be paid has not been updated.");
    }

    @Then("The user verifies that the payment transaction failed.")
    public void theUserVerifiesThatThePaymentTransactionFailed() {

        boolean isPaymentUnsuccessful;

        try {
            isPaymentUnsuccessful = userDashboardPage.payButton.isDisplayed();
            logger.info("Pay button is displayed, indicating the payment transaction should have failed but was successful.");
        } catch (NoSuchElementException e) {
            isPaymentUnsuccessful = false;
            logger.error("Pay button is NOT displayed, indicating the payment transaction has failed as expected.");
        }

        assertTrue("Payment transaction should have failed, but it didn't.", isPaymentUnsuccessful);
        userDashboardPage.closeButton.click();
        driver.switchTo().defaultContent();
    }
}
