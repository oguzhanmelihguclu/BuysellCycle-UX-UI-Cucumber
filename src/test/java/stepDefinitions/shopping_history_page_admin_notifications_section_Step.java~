package stepDefinitions;

import config.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.AdminProfileNotificationsPage;
import pages.LoginPages;
import pages.UserDashboardPage;
import utilities.ExcelReader;
import utilities.JSUtilities;
import utilities.ReusableMethods;

public class US018_35_Steps {

    private static final Logger logger = LogManager.getLogger();
    WebDriver driver = Hooks.getDriver();
    LoginPages loginPages = new LoginPages(driver);
    UserDashboardPage userDashboardPage = new UserDashboardPage(driver);
    AdminProfileNotificationsPage adminProfileNotificationsPage = new AdminProfileNotificationsPage(driver);
    ExcelReader excelReader = new ExcelReader("src/test/resources/TestData.xlsx");
    Actions actions = new Actions(driver);

    @Given("Open your web browser and go to {string}.")
    public void openYourWebBrowserAndGoTo(String url) {

        driver.get(url);
        ReusableMethods.wait(2);
    }

    @And("On the home page, find and click the Login button in the upper right corner.")
    public void onTheHomePageFindAndClickTheLoginButtonInTheUpperRightCorner() {

        loginPages.loginButton.click();
        ReusableMethods.wait(2);
    }

    @And("On the screen that opens, enter a valid email address in the Email address or phone field.")
    public void onTheScreenThatOpensEnterAValidEmailAddressInTheEmailAddressOrPhoneField() {

        loginPages.emailInput.sendKeys(excelReader.getExcelText("Sheet1", 3, 0));
        ReusableMethods.wait(2);
    }

    @And("Enter a valid password in the Password field.")
    public void enterAValidPasswordInThePasswordField() {

        loginPages.passwordInput.sendKeys(excelReader.getExcelText("Sheet1", 3, 1));
        ReusableMethods.wait(2);
    }

    @And("Click on the Sign In button.")
    public void clickOnTheSignInButton() {

        loginPages.SignInButton.click();
        ReusableMethods.wait(2);
    }

    @And("After logging in, verify that the dashboard home page has loaded.")
    public void afterLoggingInVerifyThatTheDashboardHomePageHasLoaded() {

        loginPages.logoutButton.isDisplayed();
        ReusableMethods.wait(2);
    }

    @Then("Verify that Purchase History is visible and active in the left sidebar.")
    public void verifyThatPurchaseHistoryIsVisibleAndActiveInTheLeftSidebar() {

        JSUtilities.scrollToElement(driver, userDashboardPage.purchaseHistorySidebarLink);
        Assertions.assertTrue(userDashboardPage.purchaseHistorySidebarLink.isDisplayed());
        ReusableMethods.wait(2);
    }

    @And("Press the logout button.")
    public void pressTheLogoutButton() {

        loginPages.logoutButton.click();
        ReusableMethods.wait(2);
    }

    @And("Close the page.")
    public void closeThePage() {

        driver.quit();
    }

    @Given("Go to the relevant URL and verify that the user panel has been loaded after completing the relevant login procedures.")
    public void goToTheRelevantURLAndVerifyThatTheUserPanelHasBeenLoadedAfterCompletingTheRelevantLoginProcedures() {

        driver.get(ConfigReader.getProperty("url"));
        ReusableMethods.wait(2);
        loginPages.loginButton.click();
        ReusableMethods.wait(2);
        loginPages.emailInput.sendKeys(excelReader.getExcelText("Sheet1", 3, 0));
        ReusableMethods.wait(2);
        loginPages.passwordInput.sendKeys(excelReader.getExcelText("Sheet1", 3, 1));
        ReusableMethods.wait(2);
        loginPages.SignInButton.click();
        ReusableMethods.wait(2);
        loginPages.logoutButton.isDisplayed();
        ReusableMethods.wait(2);
    }

    @And("Click Purchase History in the left sidebar.")
    public void clickPurchaseHistoryInTheLeftSidebar() {

        JSUtilities.clickWithJS(driver, userDashboardPage.purchaseHistorySidebarLink);
        ReusableMethods.wait(2);
    }

    @Then("Verify that the Purchase History page has loaded.")
    public void verifyThatThePurchaseHistoryPageHasLoaded() {

        Assertions.assertTrue(userDashboardPage.purchaseHistoryTextH3.isDisplayed());
        ReusableMethods.wait(2);
    }

    @Then("See if the Details, Amount, Delivery Status, Payment Status, Action headings are displayed.")
    public void seeIfTheDetailsAmountDeliveryStatusPaymentStatusActionHeadingsAreDisplayed() {

        Assertions.assertTrue(userDashboardPage.purchaseHistoryDetailsText.isDisplayed());
        Assertions.assertTrue(userDashboardPage.purchaseHistoryAmountText.isDisplayed());
        Assertions.assertTrue(userDashboardPage.purchaseHistoryDeliveryStatusText.isDisplayed());
        Assertions.assertTrue(userDashboardPage.purchaseHistoryPaymentStatusText.isDisplayed());
        Assertions.assertTrue(userDashboardPage.purchaseHistoryActionText.isDisplayed());
    }

    @And("Click on the Payment Status heading.")
    public void clickOnThePaymentStatusHeading() {

        userDashboardPage.purchaseHistoryPaymentStatusText.click();
        ReusableMethods.wait(2);
    }

    @Then("See filtering by Payment Status.")
    public void seeFilteringByPaymentStatus() {

        Assertions.assertFalse(userDashboardPage.purchaseHistoryDetailsText.isSelected());
    }

    @And("Click the download button under Action.")
    public void clickTheDownloadButtonUnderAction() {

        userDashboardPage.downloadButtonUnderAction.click();
        ReusableMethods.wait(3);
    }

    @And("Click on the hamburger button under Action.")
    public void clickOnTheHamburgerButtonUnderAction() {

        userDashboardPage.hamburgerButtonUnderAction.click();
        ReusableMethods.wait(2);
    }

    @Then("On the page that opens, verify that the invoice is displayed.")
    public void onThePageThatOpensVerifyThatTheInvoiceIsDisplayed() {

        Assertions.assertTrue(userDashboardPage.closeButtonOnTheOrderDocument.isDisplayed());
        ReusableMethods.wait(2);
    }

    @And("Click the close button on the page.")
    public void clickTheCloseButtonOnThePage() {

        userDashboardPage.closeButtonOnTheOrderDocument.click();
        ReusableMethods.wait(1);
    }

    @Then("View Order code,Package code,Delivery Process,Order Details,Order Summary,Payment Type information")
    public void viewOrderCodePackageCodeDeliveryProcessOrderDetailsOrderSummaryPaymentTypeInformation() {

        Assertions.assertTrue(userDashboardPage.orderCodeOnTheOrderDocument.isDisplayed());
        Assertions.assertTrue(userDashboardPage.packageCodeOnTheOrderDocument.isDisplayed());
        Assertions.assertTrue(userDashboardPage.deliveredTextOnTheOrderDocument.isDisplayed());
        Assertions.assertTrue(userDashboardPage.orderSummaryTextOnTheOrderDocument.isDisplayed());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(1);
        Assertions.assertTrue(userDashboardPage.orderDetailOnTheOrderDocument.isDisplayed());
        Assertions.assertTrue(userDashboardPage.paymentTypeCashOnDeliveryImage.isDisplayed());
    }

    @And("Enter a valid email address in the Email address or phone field.")
    public void enterAValidEmailAddressInTheEmailAddressOrPhoneField() {

        loginPages.emailInput.sendKeys(excelReader.getExcelText("Sheet2", 2, 0));
        ReusableMethods.wait(2);
    }

    @And("Click on the sign in button.")
    public void clickOnThesignInButton() {

        adminProfileNotificationsPage.adminSignInButton.click();
        ReusableMethods.wait(2);
    }

    @Then("Verify that the admin panel is loaded.")
    public void verifyThatTheAdminPanelIsLoaded() {

        Assertions.assertTrue(adminProfileNotificationsPage.adminProfilePicture.isDisplayed());
        ReusableMethods.wait(2);
    }

    @Then("Verify that the notification icon is visible.")
    public void verifyThatTheNotificationIconIsVisible() {

        Assertions.assertTrue(adminProfileNotificationsPage.notificationBell.isDisplayed());
        ReusableMethods.wait(2);
    }

    @And("Hover over the admin profile photo and press Logout.")
    public void hoverOverTheAdminProfilePhotoAndPressLogout() {

        actions.moveToElement(adminProfileNotificationsPage.adminProfilePicture).perform();
        ReusableMethods.wait(2);
        actions.click(loginPages.logoutButton).perform();
        ReusableMethods.wait(2);
    }

    @Given("Go to the relevant URL and verify that the admin panel has been loaded after completing the relevant login procedures.")
    public void goToTheRelevantURLAndVerifyThatTheAdminPanelHasBeenLoadedAfterCompletingTheRelevantLoginProcedures() {

        driver.get("https://qa.buysellcycle.com/admin/login");
        ReusableMethods.wait(2);
        loginPages.emailInput.sendKeys(excelReader.getExcelText("Sheet2", 2, 0));
        ReusableMethods.wait(2);
        loginPages.passwordInput.sendKeys(excelReader.getExcelText("Sheet2", 2, 1));
        ReusableMethods.wait(2);
        adminProfileNotificationsPage.adminSignInButton.click();
        ReusableMethods.wait(2);
        Assertions.assertTrue(adminProfileNotificationsPage.adminProfilePicture.isDisplayed());
        ReusableMethods.wait(2);
    }

    @Then("Notice that the notification icon has a number on it.")
    public void noticeThatTheNotificationIconHasANumberOnIt() {

        Assertions.assertTrue(adminProfileNotificationsPage.notificationCount.isDisplayed());
        ReusableMethods.wait(2);
    }

    @And("Click on the Notification icon.")
    public void clickOnTheNotificationIcon() {

        JSUtilities.clickWithJS(driver, adminProfileNotificationsPage.notificationBell);
        ReusableMethods.wait(2);
    }

    @And("Click on the Setting button.")
    public void clickOnTheSettingButton() {

        adminProfileNotificationsPage.notificationBellSetting.click();
        ReusableMethods.wait(2);
    }

    @Then("Verify that the Personal Notification Setting page opens.")
    public void verifyThatThePersonalNotificationSettingPageOpens() {

        Assertions.assertTrue(adminProfileNotificationsPage.personalNotificationSettingText.isDisplayed());
        ReusableMethods.wait(2);
    }

    @Then("On the Personal Notification Setting page, verify that the Register and Pending buttons can be clicked and changed.")
    public void onThePersonalNotificationSettingPageVerifyThatTheRegisterAndPendingButtonsCanBeClickedAndChanged() {

        Assertions.assertTrue(adminProfileNotificationsPage.registerCheckmark.isEnabled());
        ReusableMethods.wait(2);
        JSUtilities.clickWithJS(driver, adminProfileNotificationsPage.registerCheckmark);
        ReusableMethods.wait(2);
        JSUtilities.clickWithJS(driver, adminProfileNotificationsPage.registerCheckmark);
        ReusableMethods.wait(2);
        Assertions.assertTrue(adminProfileNotificationsPage.pendingCheckmark.isEnabled());
        ReusableMethods.wait(2);
        JSUtilities.clickWithJS(driver, adminProfileNotificationsPage.pendingCheckmark);
        ReusableMethods.wait(2);
        JSUtilities.clickWithJS(driver, adminProfileNotificationsPage.pendingCheckmark);
        ReusableMethods.wait(2);
    }

    @Then("Verify that the warning message appears after the relevant changes.")
    public void verifyThatTheWarningMessageAppearsAfterTheRelevantChanges() {

        Assertions.assertTrue(adminProfileNotificationsPage.updateSuccessfullyText.isDisplayed());
        ReusableMethods.wait(2);
    }

    @And("Click View.")
    public void clickView() {

        adminProfileNotificationsPage.notificationBellView.click();
        ReusableMethods.wait(2);
    }

    @Then("Verify that the notification page opens.")
    public void verifyThatTheNotificationPageOpens() {

        Assertions.assertTrue(adminProfileNotificationsPage.personalNotificationSettingText.isDisplayed());
        ReusableMethods.wait(2);
    }

    @And("Click View under Action.")
    public void clickViewUnderAction() {

        adminProfileNotificationsPage.notificationsPageView.click();
        ReusableMethods.wait(2);
    }

    @Then("Verify that access has been granted to the relevant page of the relevant information message.")
    public void verifyThatAccessHasBeenGrantedToTheRelevantPageOfTheRelevantInformationMessage() {

        Assertions.assertTrue(adminProfileNotificationsPage.personalNotificationSettingText.isDisplayed());
        ReusableMethods.wait(2);
    }

    @And("Click the Read All button.")
    public void clickTheReadAllButton() {

        adminProfileNotificationsPage.notificationBellReadAll.click();
        ReusableMethods.wait(2);
    }
}
