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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPages;
import pages.LogoutPage;
import pages.UserDashboardPage;
import utilities.JSUtilities;
import utilities.ReusableMethods;

import java.time.Duration;

public class user_dashboard_Step {

    private static final Logger logger = LogManager.getLogger();
    WebDriver driver = Hooks.getDriver();
    LoginPages loginPages = new LoginPages(driver);
    UserDashboardPage userDashboardPage=new UserDashboardPage(DriverManager.getDriver());
    LogoutPage logoutPage=new LogoutPage(driver);



    @Given("the user opens the browser and goes to the url from the data.")
    public void theUserOpensTheBrowserAndGoesToTheUrlFromTheData() {
        driver.get(ConfigReader.getProperty("url"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logger.info("the user opens the browser and goes to the url from the data." );
    }

    @When("the user selects the Login option from the home page.")
    public void theUserSelectsTheLoginOptionFromTheHomePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPages.loginButton.click();
        logger.info("the user selects the Login option from the home page." );
    }

    @Then("The user enters their email and password correctly, then presses the Sign In button.")
    public void theUserEntersTheirEmailAndPasswordCorrectlyThenPressesTheSignInButton() {
        ReusableMethods.wait(4);
        loginPages.emailInput.sendKeys(ConfigReader.getProperty("email"));
        ReusableMethods.wait(4);

        loginPages.passwordInput.sendKeys(ConfigReader.getProperty("password"));

        WebElement signInBtn = driver.findElement(By.id("sign_in_btn"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", signInBtn);;
        logger.info("The user enters their email and password correctly, then presses the Sign In button." );
    }



    @Then("The user profile information should be visible on the Dashboard page")
    public void theUserProfileInformationShouldBeVisibleOnTheDashboardPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertTrue(userDashboardPage.DashboardUserProfileButton.isDisplayed());
        ReusableMethods.wait(2);
        logger.info("The user profile information should be visible on the Dashboard page" );
    }

    @Then("The user's profile information should be visible on the Dashboard page")
    public void theUserSProfileInformationShouldBeVisibleOnTheDashboardPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement profileElement = wait.until(ExpectedConditions.visibilityOf(userDashboardPage.DashboardUserProfileButton));
        Assert.assertTrue(profileElement.isDisplayed());
        logger.info("The user's profile information should be visible on the Dashboard page" );
    }


    @And("The user logs out by clicking the {string}")
    public void theUserLogsOutByClickingThe(String logoutButton) {
        ReusableMethods.wait(2);

        JSUtilities.scrollToElement(driver, logoutPage.topBarLogoutButton);
        ReusableMethods.wait(2);
        logoutPage.topBarLogoutButton.click();
        logger.info("The user logs out by clicking the {string}" );

    }

    @Then("The user's balance information should be displayed on the Dashboard page")
    public void theUserSBalanceInformationShouldBeDisplayedOnTheDashboardPage() {
        Assert.assertTrue(userDashboardPage.DashboardProfileBalanceButton.isDisplayed());
        // İstersen içeriğini de kontrol edebilirsin
        System.out.println("Balance: " + userDashboardPage.DashboardProfileBalanceButton.getText());
        logger.info("The user's balance information should be displayed on the Dashboard page" );

    }
    @And("The latest transaction summary on the Dashboard page")
    public void theLatestTransactionSummaryOnTheDashboardPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement transactionSummary = wait.until(ExpectedConditions.visibilityOf(userDashboardPage.DashboardPurchaseHistoryButton));
        Assert.assertTrue("Transaction Summary görünmüyor!", transactionSummary.isDisplayed());
        logger.info("The latest transaction summary on the Dashboard page" );

    }

    @Then("The {string} section on the Dashboard page \\(e.g., panels such as Purchase History, Wishlist, Cart) should be visible.\"")
    public void theBodySectionOnTheDashboardPageEGPanelsSuchAsPurchaseHistoryWishlistCartShouldBeVisible(String body) throws Throwable {
        Assert.assertTrue(userDashboardPage.DashboardPurchaseHistoryButton.isDisplayed());
        ReusableMethods.wait(2);
        Assert.assertTrue(userDashboardPage.DashboardMyWishlistButton.isDisplayed());
        Assert.assertTrue(userDashboardPage.DashboardRecentOrderButton.isDisplayed());
        Assert.assertTrue(userDashboardPage.DashboardProductInCartButton.isDisplayed());
        logger.info("The {string} section on the Dashboard page \\(e.g., panels such as Purchase History, Wishlist, Cart) should be visible.\"" );

    }
    @And("The user logs out by clicking the logout button")
    public void the_user_logs_out() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Logout butonuna tıkla
        loginPages.logoutButton.click();
        logger.info("The user logs out by clicking the logout button" );


    }

}