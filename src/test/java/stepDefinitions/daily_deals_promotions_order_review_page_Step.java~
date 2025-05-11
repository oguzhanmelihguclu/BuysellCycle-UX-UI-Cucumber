package stepDefinitions;

import drivers.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.*;
import utilities.ExcelReader;
import utilities.JSUtilities;
import utilities.ReusableMethods;

import java.util.List;

public class US_012_032Step extends ReusableMethods{



    WebDriver driver = stepDefinitions.Hooks.getDriver();
    LoginPages loginPages = new LoginPages(driver);
    HomeCategoriesPage homeCategoriesPage = new HomeCategoriesPage(driver);
    CartCheckoutPage cartCheckoutPage = new CartCheckoutPage(driver);
    DailyDealsPage dailyDealsPage = new DailyDealsPage(driver);
    HomeHeaderPage homeHeaderPage = new HomeHeaderPage(driver);
    Actions actions = new Actions(driver);
    ExcelReader excelReader = new ExcelReader("src/test/resources/TestData.xlsx");


    @Given("Registered user goes to the relevant url")
    public void registered_user_goes_to_the_relevant() {

        driver.get(config.ConfigReader.getProperty("url"));
        ReusableMethods.wait(10);
    }
    @When("Enter the requested information on the login page and log in.")
    public void enter_the_requested_information_on_the_login_page_and_log_in() {

        loginPages.loginButton.click();
        ReusableMethods.wait(8);
        JSUtilities.scrollToElement(driver, loginPages.SignInButton);
        ReusableMethods.wait(8);
        loginPages.login1();
        ReusableMethods.wait(8);



    }
    @And("Goes from Dashboard page to Homepage")
    public void goes_from_dashboard_page_to_homepage() {

        homeCategoriesPage.dashboardHome.click();
        ReusableMethods.wait(5);

    }
    @And("Select the desired product from Best Deals in the body section on the homepage.")
    public void select_the_desired_product_from_best_deals_in_the_body_section_on_the_homepage() {

        ReusableMethods.wait(5);
        JSUtilities.scrollToElement(driver, homeHeaderPage.homeBanner);
        ReusableMethods.wait(7);
        homeCategoriesPage.bestdealsViewAll.click();
        ReusableMethods.wait(5);
        JSUtilities.scrollToElement(driver, cartCheckoutPage.selectedProductForCart);
        ReusableMethods.wait(6);
        JSUtilities.clickWithJS(driver,cartCheckoutPage.selectedProductForCart);
        ReusableMethods.wait(5);


    }
    @And("Adds the selected product to the cart and goes to the Cart page.")
    public void adds_the_selected_product_to_the_cart_and_goes_to_the_cart_page() {

        JSUtilities.clickWithJS(driver,cartCheckoutPage.addToCartButton);
        ReusableMethods.wait(4);
        cartCheckoutPage.addToCartButton.click();
        ReusableMethods.wait(3);
        cartCheckoutPage.viewCartButton.click();

    }
    @Then("Click the PROCEED TO CHECKOUT button in the cart.")
    public void click_the_proceed_to_checkout_button_in_the_cart() {

        cartCheckoutPage.proceedToCheckoutButton.click();

        ReusableMethods.wait(10);
    }

    @Then("Enters information in the address form and presses the Continue button.")
    public void enters_information_in_the_address_form_and_presses_the_continue_button() {

        actions.moveToElement(cartCheckoutPage.continueToShippingButton).perform();
        ReusableMethods.wait(15);
        cartCheckoutPage.continueToShippingButton.click();
        ReusableMethods.wait(15);



    }
    @When("Checkout page confirms that you are directed to the payment section")
    public void checkout_page_confirms_that_you_are_directed_to_the_payment_section() {

        Assert.assertTrue(cartCheckoutPage.couponCodeApplyButton.isEnabled());

    }

    @Then("On the checkout page, the product name, quantity, unit price and subtotal added to the cart are verified.")
    public void on_the_checkout_page_the_product_name_quantity_unit_price_and_subtotal_added_to_the_cart_are_verified() {

        Assert.assertEquals(cartCheckoutPage.checkoutProductName.getText(),"Relax & Play Swing");

        String urunAdetElement = DriverManager.getDriver().findElement(By.xpath("//h4[@class='font_16_top f_w_500 m-0 text-nowrap']")).getText();

        urunAdetElement = urunAdetElement.replaceAll("\\D","");

        int productPiece = Integer.parseInt(urunAdetElement);

        Assert.assertTrue(productPiece>0);

        Assert.assertEquals(cartCheckoutPage.totalText.getText(),"Total");

    }

    @Then("On the checkout page, it is verified that the total amount to be paid for the product added to the cart is visible.")
    public void on_the_checkout_page_it_is_verified_that_the_total_amount_to_be_paid_for_the_product_added_to_the_cart_is_visible() {

        Assert.assertTrue(cartCheckoutPage.totalAmount.isDisplayed());

    }

    @Then("Verify that there is a Contact Information section on the checkout page.")
    public void verify_that_there_is_a_section_on_the_checkout_page() {

        Assert.assertEquals(cartCheckoutPage.contactForm.getText(),"Contact Information");

    }

    @Then("Verifies that there is a note in the order summary")
    public void verifies_that_there_is_a_note_in_the_order_summary() {

        Assert.assertTrue(cartCheckoutPage.orderNote.isEnabled());
        ReusableMethods.wait(7);
    }

    @Then("Confirms that you can subscribe to the newsletter from the footer section")
    public void confirms_that_you_can_subscribe_to_the_newsletter_from_the_footer_section() {

        JSUtilities.scrollToElement(driver,cartCheckoutPage.subscriptionForm);
        ReusableMethods.wait(5);

        cartCheckoutPage.subscriptionForm.sendKeys(excelReader.getExcelText("Sheet1", 2, 0));
        cartCheckoutPage.subscriptionButton.click();
        Assert.assertEquals(cartCheckoutPage.subscribeToNewsletterVerification.getText(),"You Are Already Subscribed.");

    }


    @Then("Click the Continue to Shipping button without checking the I agree with the terms checkbox.")
    public void click_the_button_without_checking_the_checkbox() {

        cartCheckoutPage.IagreeTermsCheckBox.click();
        cartCheckoutPage.continueToShippingButton.click();


    }
    @Then("Confirms that you received an error message")
    public void confirms_that_you_received_an_error_message() {

        Assert.assertEquals(cartCheckoutPage.errorMassage.getText(),"Please Agree With Terms");


    }

    @Then("Find the Return to Cart button on the Checkout page")
    public void find_the_button_on_the_checkout_page(String string) {

        Assert.assertTrue(cartCheckoutPage.returnToCartButton.isDisplayed());

    }
    @Then("Test the clickability of both buttons")
    public void test_the_clickability_of_both_buttons() {

        Assert.assertTrue(cartCheckoutPage.continueToShippingButton.isEnabled());

        Assert.assertTrue(cartCheckoutPage.continueToShippingButton.isEnabled());

    }


    // ************************   US_012  *****************************


    @Then("Daily Deals menu appears on the homepage navbar and clicked")
    public void daily_deals_menu_appears_on_the_homepage_navbar_and_clicked() {

        Assert.assertTrue(dailyDealsPage.dealyDealsMenu.isDisplayed());
        ReusableMethods.wait(3);
        dailyDealsPage.dealyDealsMenu.click();
        ReusableMethods.wait(3);

    }
    @Then("Access to the Daily Deals page is confirmed.")
    public void access_to_the_daily_deals_page_is_confirmed() {

        String expectedUrl = "https://qa.buysellcycle.com/flash-deal/march-flash-sale-wdtvw";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);
        ReusableMethods.wait(3);

    }

    @Then("Click Daily Deals on the homepage navbar")
    public void click_daily_deals_on_the_homepage_navbar() {
        dailyDealsPage.dealyDealsMenu.click();
        ReusableMethods.wait(10);

    }
    @Then("Verify that there is a counter on the Daily Deals page")
    public void verify_that_there_is_a_counter_on_the_daily_deals_page() {

        Assert.assertTrue(dailyDealsPage.sayac.isDisplayed());
        String time1 = dailyDealsPage.sayac.getText();
        ReusableMethods.wait(5);
        String time2 = dailyDealsPage.sayac.getText();
        Assert.assertTrue(time2.compareTo(time1) < 0);



    }
    @Then("Verify that the product is listed on the page")
    public void verify_that_the_product_is_listed_on_the_page() {
        JSUtilities.scrollToElement(driver, dailyDealsPage.productCart);
        ReusableMethods.wait(8);
        List<WebElement> urunList = driver.findElements(By.xpath("//div[@class='product_widget5 mb_30 style5 w-100']"));
        Assert.assertTrue(urunList.size() > 0);
        ReusableMethods.wait(10);

    }

    @Then("Click the Add to Cart button for the product listed on the Daily Deals page.")
    public void click_the_add_to_cart_button_for_the_product_listed_on_the_daily_deals_page() {
        JSUtilities.scrollToElement(driver, dailyDealsPage.productCart);
        ReusableMethods.wait(5);
        dailyDealsPage.dailyDealsFirstProduct.click();
        ReusableMethods.wait(10);
        dailyDealsPage.formAddToCart.click();
        ReusableMethods.wait(10);
        cartCheckoutPage.viewCartButton.click();
        ReusableMethods.wait(10);

    }
    @Then("And confirm that it has been added to your cart")
    public void and_confirm_that_it_has_been_added_to_your_cart() {

        String expectedProduct = "WRAPAROUND COLLAR TOP";
        String actualProduct = dailyDealsPage.cartToProductName.getText();
        ReusableMethods.wait(4);

        Assert.assertEquals(expectedProduct,actualProduct);

    }

    @Then("Click the Compare button for the product listed on the Daily Deals page")
    public void click_the_compare_button_for_the_product_listed_on_the_daily_deals_page() {

        ReusableMethods.wait(4);
        JSUtilities.clickWithJS(driver, dailyDealsPage.compare);
        ReusableMethods.wait(2);
        JSUtilities.clickWithJS(driver, dailyDealsPage.addToCompareForm);
        ReusableMethods.wait(5);
        dailyDealsPage.headerCompare.click();
        ReusableMethods.wait(9);





    }
    @Then("And verify that it has been successfully added to the comparison list")
    public void and_verify_that_it_has_been_successfully_added_to_the_comparison_list() {

        String expectedProduct = "WRAPAROUND COLLAR TOP";
        String actualProduct = dailyDealsPage.comparePage.getText();

        Assert.assertEquals(expectedProduct,actualProduct);

    }

    @Then("Click on the favorite button of the product listed on the Daily Deals page")
    public void click_on_the_favorite_button_of_the_product_listed_on_the_daily_deals_page() {

        JSUtilities.clickWithJS(driver, dailyDealsPage.wishlistProductAbove);
        dailyDealsPage.headerWishlist.click();
        ReusableMethods.wait(8);

    }
    @Then("And confirm that you have been added to the favorites list")
    public void and_confirm_that_you_have_been_added_to_the_favorites_list() {

        Assert.assertTrue(dailyDealsPage.wihlistPage.isDisplayed());
    }



}
