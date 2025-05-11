package stepDefinitions;

import drivers.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartCheckoutPage;
import pages.LoginPages;
import pages.UserDashboardPage;
import utilities.ReusableMethods;

import java.time.Duration;

public class shopping_cart_page_Step {
    private static final Logger logger = LogManager.getLogger();
    WebDriver driver = Hooks.getDriver();
    LoginPages loginPages = new LoginPages(driver);
    UserDashboardPage userDashboardPage=new UserDashboardPage(DriverManager.getDriver());
    CartCheckoutPage cartCheckoutPage=new CartCheckoutPage(DriverManager.getDriver());
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Actions actions=new Actions(DriverManager.getDriver());


    @Then("The cart button should be displayed.")
    public void theCartButtonShouldBeDisplayed() {
        Assert.assertNotNull("Cart button is not found on the page!", cartCheckoutPage.HomeCartButton);
        Assert.assertTrue("Cart button is not visible!", cartCheckoutPage.HomeCartButton.isDisplayed());
        logger.info("The cart button should be displayed." );

    }

@When("The user clicks the search button and enters {string} into the search field")
public void theUserClicksTheSearchButtonAndEntersIntoTheSearchField(String watch) {
    cartCheckoutPage.SearchButton.sendKeys(watch + Keys.ENTER);
    ReusableMethods.wait(3);
    logger.info("The user clicks the search button and enters {string} into the search field" );
}

    @And("user adds the first product to the cart")
    public void userAddsTheFirstProductToTheCart() {
        // Sayfanın zoom seviyesini küçült
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("document.body.style.zoom='80%';");
        ReusableMethods.wait(1);

        // Sayfayı bir kez aşağı kaydır
        Actions actions = new Actions(DriverManager.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(1);

        // Ürün detay sayfasına git
        cartCheckoutPage.urunCartButton.click();
        ReusableMethods.wait(2);

        // "Add to Cart" butonunu görünür hale getir
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", cartCheckoutPage.AddToCartButton);
        ReusableMethods.wait(1);

        // "Add to Cart" tıklama işlemi
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(cartCheckoutPage.AddToCartButton));
            cartCheckoutPage.AddToCartButton.click();
        } catch (Exception e) {
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", cartCheckoutPage.AddToCartButton);
        }

        ReusableMethods.wait(2);

        // Zoom'u eski haline getir (opsiyonel)
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("document.body.style.zoom='100%';");

        cartCheckoutPage.ViewCartButton.click();

        logger.info("user adds the first product to the cart" );

    }

    @Then("The user verify that the product has been added to the cart.")
    public void verify_that_the_product_has_been_added_to_the_cart() {
        // Sayfayı aşağı kaydır
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollBy(0, 500);"); // Bu satır sayfayı 500px aşağı kaydırır

        // Ürünün sepette olduğunu doğrula
        Assert.assertTrue(cartCheckoutPage.OrderSummaryButton.isDisplayed());

        // 5 saniye bekle
        ReusableMethods.wait(5);

        logger.info("The user verify that the product has been added to the cart." );
    }

    @And("The user verify that all added products are listed with name, image")
    public void verifyThatAllAddedProductsAreListedWithNameImagePriceQuantity() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Ürün adı kontrolü
        WebElement productName = wait.until(ExpectedConditions.visibilityOf(cartCheckoutPage.urunTextbutton));
        Assert.assertTrue( cartCheckoutPage.urunTextbutton.isDisplayed());

        // Ürün görseli kontrolü
        WebElement productImage = wait.until(ExpectedConditions.visibilityOf(cartCheckoutPage.urunGorselbutton));
        Assert.assertTrue(cartCheckoutPage.urunGorselbutton.isDisplayed());
        logger.info("The user verify that all added products are listed with name, image" );


    }


    @And("The user clicks the {string} button in the cart")
    public void theUserClicksTheContinueShoppingButtonInTheCart(String ContinueShoppingButton) {

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        // 'Continue Shopping' butonunun görünmesini ve tıklanabilir olmasını bekle
        WebElement continueShoppingBtn = wait.until(
                ExpectedConditions.elementToBeClickable(cartCheckoutPage.ContinueShoppingButton)
        );

        continueShoppingBtn.click();
        logger.info("The user clicks the {string} button in the cart" );

    }

    @Then("The user should be redirected to the home or products page")
    public void theUserShouldBeRedirectedToTheHomeOrProductsPage() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        // Sayfa yönlendirmesinin tamamlanmasını bekle
        wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("/cart")));

        String currentUrl = DriverManager.getDriver().getCurrentUrl();

        // /cart içermediğini doğrula
        Assert.assertFalse(currentUrl.contains("/cart"));
        logger.info("The user should be redirected to the home or products page" );
    }


    @Then("The user verifies the Order Summary section includes Subtotal, Shipping, and Taxes")
    public void theUserVerifiesTheOrderSummarySectionIncludesSubtotalShippingAndTaxes() {
        ReusableMethods.wait(2);
        Assert.assertTrue("Subtotal görünmüyor!", cartCheckoutPage.urunSubtotalbutton.isDisplayed());
        Assert.assertTrue("Shipping ücreti görünmüyor!", cartCheckoutPage.ShippingChargeCartButton.isDisplayed());
        Assert.assertTrue("Vergi bilgisi görünmüyor!", cartCheckoutPage.VATTAXGSTSummeryCartButton.isDisplayed());
        logger.info("The user verifies the Order Summary section includes Subtotal, Shipping, and Taxes" );
    }

    @And("The user verifies the product shows both discounted price")
    public void theUserVerifiesTheProductShowsBothDiscountedPrice() {
        // İndirimli fiyatın görünür olduğunu kontrol et
     ReusableMethods.wait(2);
        Assert.assertTrue(cartCheckoutPage.DiscountCartButton.isDisplayed());
        logger.info("The user verifies the product shows both discounted price" );

    }


    @And("The user removes the product from the cart")
    public void theUserRemovesTheProductFromTheCart() {
        ReusableMethods.wait(2); // kısa bekleme süresi
        cartCheckoutPage.RemoveCartButton.click();
        logger.info("The user removes the product from the cart" );
    }

    @Then("The product should be removed from the cart")
    public void theProductShouldBeRemovedFromTheCart() {
        ReusableMethods.wait(2);
        // Sepetin boş olduğunu belirten yazının görünür olup olmadığını kontrol et
        Assert.assertTrue("Ürün hâlâ sepette!", cartCheckoutPage.urunYokbutonuButton.isDisplayed());
        logger.info("The product should be removed from the cart" );
    }

}
