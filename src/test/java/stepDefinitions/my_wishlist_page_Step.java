package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.UserDashboardPage;
import utilities.ExcelReader;

import utilities.JSUtilities;
import utilities.LoggerHelper;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class my_wishlist_page_Step {
    private static final Logger logger = LogManager.getLogger();
    WebDriver driver = Hooks.getDriver();
    ExcelReader excelReader = new ExcelReader("src/test/resources/TestData.xlsx");
    UserDashboardPage dashboardPage = new UserDashboardPage(driver);
    BasePage basePage = new BasePage(driver);


    @When("In the opened Dashboard, the user sees and clicks the My Wishlist menu in the sidebar.")
    public void inTheOpenedDashboardTheUserSeesAndClicksTheMyWishlistMenuInTheSidebar() {
        ReusableMethods.wait(7);
        Assert.assertTrue(dashboardPage.dashboardSideBarMyWishlistButton.isDisplayed());
        ReusableMethods.wait(3);

        basePage.click(dashboardPage.dashboardSideBarMyWishlistButton);
        LoggerHelper.info("In the opened Dashboard, the user sees and clicks the My Wishlist menu in the sidebar.");
    }

    @Then("Verifies that the user is redirected to the relevant page.")
    public void verifies_that_the_user_is_redirected_to_the_relevant_page() {

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("URL 'wishlist'", currentUrl.contains("wishlist"));
        LoggerHelper.info("Verifies that the user is redirected to the relevant page.");


    }


    @Then("Verifies that there are listed products on the opened page.")
    public void verifiesThatThereAreListedProductsOnTheOpenedPage() {
        ReusableMethods.wait(3);
        JSUtilities.scrollToElement(driver, dashboardPage.dashboardMyWishListNextButton);
        ReusableMethods.wait(3);
        Assert.assertTrue(dashboardPage.dashboardMyWishListNextButton.isDisplayed());
        LoggerHelper.info("Verifies that there are listed products on the opened page.");
    }

    @When("Clicks on the New menu on the right side of the screen and selects Price - Low to High.")
    public void clicksOnTheNewMenuOnTheRightSideOfTheScreenAndSelectsPriceLowToHigh() {
        basePage.click(dashboardPage.dashboardMyWishlistNewButton);
        basePage.click(dashboardPage.dashboardMyWishlistPriceLowToHighButton);
        LoggerHelper.info("Clicks on the New menu on the right side of the screen and selects Price - Low to High.");
    }


    @Then("Sees that the products are listed according to the selected filter.")
    public void seesThatTheProductsAreListedAccordingToTheSelectedFilter() {

        // Fiyat bilgilerini temsil eden WebElement listesi al (strong etiketindeki fiyatlar)
        List<WebElement> priceElements = driver.findElements(By.xpath("//strong[contains(text(), '$')]"));

        if (priceElements.isEmpty()) {
            Assert.fail("Fiyat öğeleri bulunamadı. XPath doğru değil veya sayfa dinamik olarak yükleniyor.");
            return;
        }

        // Fiyatları al ve listeye ekle
        List<Double> prices = new ArrayList<>();
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("$", "").replace(",", "").trim();
            priceText = priceText.replace(",", ".");

            try {
                double price = Double.parseDouble(priceText);
                prices.add(price);
            } catch (NumberFormatException e) {
                System.out.println("Fiyat okunamadı. Hata: " + priceText);
                Assert.fail("Fiyatlar düzgün formatta değil.");
            }
        }

        // Fiyatları küçükten büyüğe sıralayalım
        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);

        // Sayfadaki sıralama ile kendi sıralamamızı karşılaştıralım
        if (prices.equals(sortedPrices)) {
            LoggerHelper.info("Fiyatlar doğru şekilde düşükten yükseğe sıralanmış.");
        } else {
            // Sıralama hatalıysa, hata mesajı yazdıralım
            Assert.fail("Fiyatlar doğru sıralanmamış! Fiyatlar: " + prices.toString() + ", Sıralı Fiyatlar: " + sortedPrices.toString());
        }
    }

    @When("Clicks the cart icon for the displayed product.")
    public void clicksTheCartIconForTheDisplayedProduct() {
        JSUtilities.scrollToElement(driver, dashboardPage.dashboardMyWishlistSepetIkonu);
        ReusableMethods.wait(3);
        JSUtilities.clickWithJS(driver, dashboardPage.dashboardMyWishlistSepetIkonu);
        ReusableMethods.wait(3);
        LoggerHelper.info("Clicks the cart icon for the displayed product.");
    }


    @Then("Sees a pop-up confirming that the product has been added to the cart.")
    public void seesAPopUpConfirmingThatTheProductHasBeenAddedToTheCart() {
        JSUtilities.clickWithJS(driver, dashboardPage.dashboardMyWishlistWishlistAddToCart);
        ReusableMethods.wait(5);
        Assert.assertTrue(dashboardPage.dashboardMyWishlistWishlistAddToCartSuccessMessage.isDisplayed());
        LoggerHelper.info("Sees a pop-up confirming that the product has been added to the cart.");
    }

    @When("Closes the pop-up and the Shopping Cart side panel.")
    public void closesThePopUpAndTheShoppingCartSidePanel() {
        ReusableMethods.wait(3);
        JSUtilities.clickWithJS(driver, dashboardPage.dashboardMyWishlistWishlistPopUpCloseButton);
        ReusableMethods.wait(3);
        JSUtilities.clickWithJS(driver, dashboardPage.dashboardMyWishlistWishlistYanEkranCloseButton);
        LoggerHelper.info("Closes the pop-up and the Shopping Cart side panel.");
    }

    @When("Scrolls down the list on the opened page, clicks the Next button, and verifies that the next page of the list is displayed.")
    public void scrollsDownTheListOnTheOpenedPageClicksTheNextButtonAndVerifiesThatTheNextPageOfTheListIsDisplayed() {
        ReusableMethods.wait(3);
        JSUtilities.scrollToElement(driver, dashboardPage.dashboardMyWishListNextButton);
        ReusableMethods.wait(3);
        Assert.assertTrue(dashboardPage.dashboardMyWishListNextButton.isDisplayed());
        ReusableMethods.wait(3);
        basePage.click(dashboardPage.dashboardMyWishListNextButton);
        LoggerHelper.info("Scrolls down the list on the opened page, clicks the Next button, and verifies that the next page of the list is displayed.");
    }

    @Then("On the newly opened page, clicks the Previous button and verifies that the previous page is displayed.")
    public void onTheNewlyOpenedPageClicksThePreviousButtonAndVerifiesThatThePreviousPageIsDisplayed() {
        ReusableMethods.wait(3);
        Assert.assertTrue(dashboardPage.dashboardMyWishListPreviousButton.isDisplayed());
        ReusableMethods.wait(3);
        basePage.click(dashboardPage.dashboardMyWishListPreviousButton);
        LoggerHelper.info("On the newly opened page, clicks the Previous button and verifies that the previous page is displayed.");
    }
}


