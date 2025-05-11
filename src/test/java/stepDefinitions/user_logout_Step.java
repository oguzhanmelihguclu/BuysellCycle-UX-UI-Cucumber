package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.LogoutPage;
import utilities.ExcelReader;
import utilities.LoggerHelper;
import utilities.ReusableMethods;


public class user_logout_Step {


    private static final Logger logger = LogManager.getLogger();
    WebDriver driver = stepDefinitions.Hooks.getDriver();
    ExcelReader excelReader = new ExcelReader("src/test/resources/TestData.xlsx");
    LogoutPage logoutPage = new LogoutPage(driver);
    BasePage basePage = new BasePage(driver);


    @When("The user clicks the logo to return to the homepage.")
    public void the_user_clicks_the_logo_to_return_to_the_homepage() {
        ReusableMethods.wait(3);
        // logoutPage.dashboardSiteLogo.click();
        basePage.click(logoutPage.dashboardSiteLogo);
        LoggerHelper.info("The user clicks the logo to return to the homepage.");

    }

    @Then("The user verifies that the Logout button is visible on the redirected homepage.")
    public void the_user_verifies_that_the_logout_button_is_visible_on_the_redirected_homepage() {
        ReusableMethods.wait(3);
        Assert.assertTrue(logoutPage.topBarLogoutButton.isDisplayed());
        LoggerHelper.info("The user verifies that the Logout button is visible on the redirected homepage");
    }


    @And("The user clicks the Logout button on the homepage.")
    public void theUserClicksTheLogoutButtonOnTheHomepage() {
        logoutPage.logoutFromHomePage();
        LoggerHelper.info("The user clicks the Logout button on the homepage.");
    }

    @Then("The user verifies that the logout was successful.")
    public void theUserVerifiesThatTheLogoutWasSuccessful() {
        //Assert.assertTrue(logoutPage.anasayfaLogoutButtonuSuccessMessage.isDisplayed());
        Assert.assertTrue(logoutPage.anasayfaSideBarCikisiButtonSuccessMessage.isDisplayed());
        LoggerHelper.info("The user verifies that the logout was successful.");

    }

    @When("On the opened Dashboard, the user scrolls down and verifies that the Logout button is visible on the sidebar.")
    public void onTheOpenedDashboardTheUserScrollsDownAndVerifiesThatTheLogoutButtonIsVisibleOnTheSidebar() {
        ReusableMethods.wait(3);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");


        ReusableMethods.wait(7);
        Assert.assertTrue(logoutPage.dashboardSideBarLogoutButton.isDisplayed());
        ReusableMethods.wait(7);


        LoggerHelper.info("On the opened Dashboard, the user scrolls down and verifies that the Logout button is visible on the sidebar");

    }

    @Then("The user clicks the sideLogout button and verifies that the logout was successful.")
    public void theUserClicksTheLogoutButtonAndVerifiesThatTheLogoutWasSuccessful() {
        ReusableMethods.wait(3);
        logoutPage.logoutFromSidebar();
        ReusableMethods.wait(3);
        Assert.assertTrue(logoutPage.anasayfaSideBarCikisiButtonSuccessMessage.isDisplayed());


        LoggerHelper.info("The user clicks the Logout button and verifies that the logout was successful.");

    }

    @When("On the Dashboard page, the user sees the Logout button on the top bar.")
    public void onTheDashboardPageTheUserSeesTheLogoutButtonOnTheTopBar() {
        Assert.assertTrue(logoutPage.topBarLogoutButton.isDisplayed());
    }

    @Then("The user clicks the topLogout button and verifies that the logout was successful.")
    public void theUserClicksTheTopLogoutButtonAndVerifiesThatTheLogoutWasSuccessful() {
        logoutPage.logoutFromHomePage();
        Assert.assertTrue(logoutPage.anasayfaSideBarCikisiButtonSuccessMessage.isDisplayed());
    }
}
