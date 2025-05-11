package stepDefinitions;

import config.ConfigReader;
import drivers.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.HomeHeaderPage;
import pages.LoginPages;
import utilities.ExcelReader;
import utilities.ReusableMethods;


public class topbar_navigation_links_order_status_tracking_Step {

    WebDriver driver = Hooks.getDriver();
    HomeHeaderPage homeHeaderPage = new HomeHeaderPage(driver);
    LoginPages loginPages = new LoginPages(driver);
    private static final Logger logger = LogManager.getLogger();
    ExcelReader excelReader = new ExcelReader("src/test/resources/TestData.xlsx");

    @Given("User goes to homepage with {string} and login")
    public void userGoesToHomepageWithAndLogin(String configUrl) {
        DriverManager.getDriver().get(ConfigReader.getProperty(configUrl));

        ReusableMethods.wait(7);
        loginPages.loginButton.click();
        ReusableMethods.wait(7);
        loginPages.loginCansu();

        logger.info("User logs in to the system");

    }

    @When("Clicks on the Track Your Order link at the top bar of the home page")
    public void clicksOnTheTrackYourOrderLinkAtTheTopBarOfTheHomePage() {

        ReusableMethods.wait(2);
        Assert.assertTrue(homeHeaderPage.TrackYourOrder.isDisplayed());

        logger.info("Displays TrackYourOrder link");

    }


    @Then("Confirms that there is a Compare link on the home page")
    public void confirmsThatThereIsACompareLinkOnTheHomePage() {

        Assert.assertTrue(homeHeaderPage.CompareLink.isDisplayed());

        logger.info("Displays CompareLink link");

    }


    @Then("Wishlist link is displayed")
    public void wishlistLinkIsDisplayed() {

        Assert.assertTrue(homeHeaderPage.WishlistLink.isDisplayed());

        logger.info("Displays WishlistLink link");
    }


    @And("Cart link is displayed")
    public void cartLinkIsDisplayed() {

        Assert.assertTrue(homeHeaderPage.CartLink.isDisplayed());

        logger.info("Displays CartLink link");
    }


    @Then("New User Zone link is displayed")
    public void newUserZoneLinkIsDisplayed() {

        Assert.assertTrue(homeHeaderPage.NewUserZoneLink.isDisplayed());

        logger.info("Displays NewUserZoneLink link");
    }

    @And("Daily Deals link is displayed")
    public void dailyDealsLinkIsDisplayed() {

        Assert.assertTrue(homeHeaderPage.DailyDealsLink.isDisplayed());

        logger.info("Displays DailyDealsLink link");
    }

    @When("Click on the {string} link at the top bar of the home page")
    public void clickOnTheLinkAtTheTopBarOfTheHomePage(String arg0) {

        homeHeaderPage.TrackYourOrder.click();

        logger.info("Clicks on TrackYourOrder link");
    }

    @Then("Track your order page is up")
    public void trackYourOrderPageIsUp() {

        Assert.assertTrue(homeHeaderPage.TrackNowButton.isDisplayed());

        logger.info("Displays TrackYourOrder linkk");
    }

    @And("Click on the Compare link at the top bar of the home page")
    public void clickOnTheCompareLinkAtTheTopBarOfTheHomePage() {

        homeHeaderPage.CompareLink.click();

        logger.info("Clicks on CompareLink link");

    }

    @Then("Verify that you are on the Compare page")
    public void verifyThatYouAreOnTheComparePage() {

        Assert.assertTrue(homeHeaderPage.CompareText.isDisplayed());

        logger.info("Displays CompareText linkk");
    }

    @Then("Click on the Wishlist link at the top bar of the home page")
    public void clickOnTheWishlistLinkAtTheTopBarOfTheHomePage() {

        homeHeaderPage.WishlistLink.click();

        logger.info("Clicks on WishlistLink link");
    }

    @And("Confirm that you are on the Wishlist page")
    public void confirmThatYouAreOnTheWishlistPage() {

        Assert.assertTrue(homeHeaderPage.NewWishList.isDisplayed());

        logger.info("Displays NewWishList linkk");
    }

    @Then("Click on the Cart link at the top bar of the home page.")
    public void clickOnTheCartLinkAtTheTopBarOfTheHomePage() {

        homeHeaderPage.CartLink.click();

        logger.info("Clicks on CartLink link");
    }


    @Then("Confirm you are on the Cart page")
    public void confirmYouAreOnTheCartPage() {

        Assert.assertTrue(homeHeaderPage.CartOnline.isDisplayed());

        logger.info("Displays CartOnline linkk");
    }


    @And("Clicks on the New User Zone link")
    public void clicksOnTheNewUserZoneLink() {

        homeHeaderPage.NewUserZoneLink.click();

        logger.info("Clicks on NewUserZoneLink link");
    }

    @And("Confirm routing to New User Zone")
    public void confirmRoutingToNewUserZone() {

        Assert.assertTrue(homeHeaderPage.ForYouButton.isDisplayed());

        logger.info("Displays ForYouButton linkk");
    }

    @Then("click on the “Daily Details” link on the home page")
    public void clickOnTheDailyDetailsLinkOnTheHomePage() {

        homeHeaderPage.DailyDealsLink.click();

        logger.info("Clicks on DailyDealsLink link");
    }

    @And("Confirms that the Daily Details page has been uploaded")
    public void confirmsThatTheDailyDetailsPageHasBeenUploaded() {

        Assert.assertTrue(homeHeaderPage.DailyCountDown.isDisplayed());

        logger.info("Displays DailyCountDown linkk");
    }

    @And("User logs out of the system")
    public void userLogsOutOfTheSystem() {

        loginPages.logoutButton.click();

        logger.info("Clicks on logoutButton  button");

    }

    @When("Confirms that the site logo is displayed in the upper left corner of")
    public void confirmsThatTheSiteLogoIsDisplayedInTheUpperLeftCornerOf() {

        Assert.assertTrue(homeHeaderPage.SiteLogo.isDisplayed());

        logger.info("Displays SiteLogo link");
    }

    @Then("Clicks on the site logo")
    public void clicksOnTheSiteLogo() {

        homeHeaderPage.SiteLogo.click();

        logger.info("Clicks on SiteLogo link");
    }

    @And("Confirms that the home page reloaded")
    public void confirmsThatTheHomePageReloaded() {

        Assert.assertTrue(homeHeaderPage.HomePageCategories.isDisplayed());

        logger.info("Displays HomePageCategories link");
    }

    @When("Confirms that the text box is visible")
    public void confirmsThatTheTextBoxIsVisible() {

        Assert.assertTrue(homeHeaderPage.SearchBox.isDisplayed());

        logger.info("Displays SearchBox ");
    }

    @Then("Types the word they want to search  for and searches")
    public void typesTheWordTheyWantToSearchForAndSearches() {

        homeHeaderPage.SearchBox.sendKeys(excelReader.getExcelText("Sheet11", 2, 1) + Keys.ENTER);

        logger.info(" Type the word you want to search for");
    }

    @And("Confirms that the search results are the right products for the search")
    public void confirmsThatTheSearchResultsAreTheRightProductsForTheSearch() {

        Assert.assertTrue(homeHeaderPage.searchResualt.isDisplayed());

        logger.info("Displays searchResualt button ");
    }


    @Then("Verify that the is redirected")
    public void verifyThatTheIsRedirected() {

        Assert.assertTrue(homeHeaderPage.TrackNowButton.isDisplayed());

        logger.info("Displays TrackNowButton button ");
    }

    @And("Confirms that a text box labeled {string} is displayed")
    public void confirmsThatATextBoxLabeledIsDisplayed(String arg0) {

        Assert.assertTrue(homeHeaderPage.OrderNumberBox.isDisplayed());

        logger.info("Displays OrderNumberBox button ");

    }

    @And("Confirms that the {string} button is displayed")
    public void confirmsThatTheButtonIsDisplayed(String arg0) {

        Assert.assertTrue(homeHeaderPage.TrackNowButton.isDisplayed());

        logger.info("Displays TrackNowButton buttonn ");
    }


    @And("Enters an invalid order number in the {string} text box")
    public void entersAnInvalidOrderNumberInTheTextBox(String arg0) {

      homeHeaderPage.OrderNumberBox.sendKeys(excelReader.getExcelText("Sheet11", 3, 1) + Keys.ENTER);

        logger.info(" Type the word you want to search for ");


    }

    @And("Clicks on the {string} button Confirms that a warning message is displayed")
    public void clicksOnTheButtonConfirmsThatAWarningMessageIsDisplayed(String arg0) {

        Assert.assertTrue(homeHeaderPage.orderNumberInvalid.isDisplayed());

        logger.info("Displays orderNumberInvalid button ");
    }


    @Then("Enters a valid order number in the {string} text box")
    public void entersAValidOrderNumberInTheTextBox(String arg0) {

        homeHeaderPage.OrderNumberBox.sendKeys(excelReader.getExcelText("Sheet11", 4, 1) + Keys.ENTER);

        logger.info(" Type the word you want to search for textbox");
    }

    @And("Confirms that the current status of the order is displayed")
    public void confirmsThatTheCurrentStatusOfTheOrderIsDisplayed() {

        Assert.assertTrue(homeHeaderPage.orderStatus.isDisplayed());

        logger.info("Displays orderStatus button ");

    }
}
