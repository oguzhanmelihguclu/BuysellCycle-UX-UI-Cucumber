package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPages;
import pages.LogoutPage;
import pages.UserDashboardPage;
import utilities.ExcelReader;
import utilities.JSUtilities;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US_021Step {

    private static final Logger logger = LogManager.getLogger();
    WebDriver driver = Hooks.getDriver();
    LoginPages loginPages = new LoginPages(driver);
    UserDashboardPage userDashboardPage = new UserDashboardPage(driver);
    LogoutPage logoutPage = new LogoutPage(driver);
    ExcelReader excelReader = new ExcelReader("src/test/resources/TestData.xlsx");
    String amountToUpload;
    double balanceBefore;
    WebElement iframe;

    @And("The user logs in with valid credentials.")
    public void theUserLogsInWithValidCredentials() {

        loginPages.loginZeynep();
        logger.info("The user logs in with valid credentials.");
    }

    @When("The user tests that the My Wallet menu item is visible in the Dashboard sideBar.")
    public void the_user_tests_that_the_my_wallet_menu_item_is_visible_in_the_dashboard_side_bar() {

        JSUtilities.scrollsToElement(driver, userDashboardPage.myWalletMenu);
        ReusableMethods.wait(2);

        assertTrue(userDashboardPage.myWalletMenu.isDisplayed());
        logger.info("The user tests that the My Wallet menu item is visible in the Dashboard sideBar.");
    }

    @When("The user clicks the My Wallet menu item.")
    public void the_user_clicks_the_my_wallet_menu_item() {

        JSUtilities.scrollsToElement(driver, userDashboardPage.myWalletMenu);
        ReusableMethods.wait(2);
        JSUtilities.clickWithJS(driver, userDashboardPage.myWalletMenu);
        ReusableMethods.wait(2);
        logger.info("The user clicks the My Wallet menu item.");
    }

    @Then("The user tests to be redirected to the My Wallet page.")
    public void the_user_tests_to_be_redirected_to_the_my_wallet_page() {

        String expectedUrlContent = "wallet";
        String actualUrlContent = driver.getCurrentUrl();

        assertTrue(expectedUrlContent, actualUrlContent.contains(expectedUrlContent));
        logger.info("The user tests to be redirected to the My Wallet page.");
    }

    @Then("The user logs out.")
    public void the_user_logs_out() {

        ReusableMethods.wait(5);
        logoutPage.topBarLogoutButton.click();
        logger.info("The user logs out.");
    }

    @Then("The user tests that the Running Balance information board is visible.")
    public void theUserTestsThatTheRunningBalanceInformationBoardIsVisible() {

        ReusableMethods.wait(5);
        assertTrue(userDashboardPage.runningBalanceBoard.isDisplayed());
        logger.info("The user tests that the Running Balance information board is visible.");
    }

    @Then("The user tests that the Pending Balance information board is visible.")
    public void theUserTestsThatThePendingBalanceInformationBoardIsVisible() {

        assertTrue(userDashboardPage.pendingBalanceBoard.isDisplayed());
        logger.info("The user tests that the Pending Balance information board is visible.");
    }

    @Then("The user clicks on the Recharge Wallet button.")
    public void the_user_clicks_on_the_recharge_wallet_button() {

        String runningBalanceBefore = userDashboardPage.runningBalanceBoard.getText();
        String cleanedBalanceBeforeText = runningBalanceBefore.replaceAll(".*[$\\s]+", "").replace(",", "");
        balanceBefore = Double.parseDouble(cleanedBalanceBeforeText);

        userDashboardPage.rechargeWalletButton.click();
        logger.info("The user clicks on the Recharge Wallet button.");
    }

    @And("The user enters {string} as amount.")
    public void theUserEntersAsAmount(String amount) {

        amountToUpload = amount;
        userDashboardPage.amountInput.clear();
        userDashboardPage.amountInput.sendKeys(amount);
        userDashboardPage.addFundButton.click();
        userDashboardPage.stripeButton.click();
        logger.info("The user enters \"{}\" as amount.", amount);
    }

    @And("The user enters valid payment information.")
    public void theUserEntersValidPaymentInformation() {

        userDashboardPage.validStripePayment();
        logger.info("The user enters valid payment information.");
    }

    @Then("The user tests the Running Balance is updated.")
    public void the_user_tests_the_running_balance_is_updated() {

        driver.switchTo().defaultContent();
        ReusableMethods.wait(2);

        String runningBalanceAfter = userDashboardPage.runningBalanceBoard.getText();
        String cleanedBalanceAfterText = runningBalanceAfter.replaceAll(".*[$\\s]+", "").replace(",", "");
        double balanceAfter = Double.parseDouble(cleanedBalanceAfterText);
        double amount = Double.parseDouble(amountToUpload);
        double expectedBalance = balanceBefore + amount;

        assertEquals(expectedBalance, balanceAfter, 0.01);
        logger.info("Balance updated correctly after uploading funds.");
    }

    @And("The user tests that the Wallet Recharge History table is visible.")
    public void theUserTestsThatTheWalletRechargeHistoryTableIsVisible() {

        assertTrue(userDashboardPage.walletRechargeHistoryTable.isDisplayed());
        logger.info("The user tests that the Wallet Recharge History table is visible.");
    }

    @Then("The user tests that {string} information is visible.")
    public void theUserTestsThatInformationIsVisible(String expectedHeadersStr) {

        List<String> expectedHeaders = Arrays.asList(expectedHeadersStr.split(", "));
        logger.info("Expected table headers: {}", expectedHeaders);

        List<String> actualHeaders = new ArrayList<>();

        for (WebElement header : userDashboardPage.walletHistoryTableHeaders) {
            assertTrue(header.isDisplayed());
            String headerText = header.getText().trim();
            actualHeaders.add(headerText);
            logger.info("Header found and visible: \"{}\"", headerText);
        }
        logger.info("Actual table headers: {}", actualHeaders);

        assertTrue(actualHeaders.containsAll(expectedHeaders));
        logger.info("All expected headers are visible in the wallet history table.");
    }

    @And("The user enters {string} as invalid amount.")
    public void theUserEntersAsInvalidAmount(String invalidAmount) {

        userDashboardPage.amountInput.clear();
        userDashboardPage.amountInput.sendKeys(invalidAmount);
        userDashboardPage.addFundButton.click();
        logger.info("The user enters \"{}\" as invalid amount.", invalidAmount);
    }

    @Then("The user tests whether the wallet upload process has been completed.")
    public void the_user_tests_whether_the_wallet_upload_process_has_been_completed() {

        assertTrue(userDashboardPage.addFundButton.isDisplayed());
        logger.info("Add Fund button is displayed, indicating the wallet upload process has not been completed yet.");

        userDashboardPage.cancelButton.click();
        logger.info("User clicked on cancel button after checking the upload process.");
    }

    @And("The user enters invalid payment information.")
    public void theUserEntersInvalidPaymentInformation() {

        userDashboardPage.invalidStripePayment();
        ReusableMethods.wait(2);
        logger.info("The user enters invalid payment information.");
    }

    @Then("The user tests that the payment transaction failed.")
    public void theUserTestsThatThePaymentTransactionFailed() {

        driver.switchTo().frame(iframe);
        boolean isPaymentUnsuccessful;

        try {
            isPaymentUnsuccessful = userDashboardPage.payButton.isDisplayed();
            logger.info("Pay button is displayed, indicating the payment transaction has failed as expected.");
        } catch (NoSuchElementException e) {
            isPaymentUnsuccessful = false;
            logger.error("Pay button is NOT displayed, indicating the payment transaction might have gone through unexpectedly.");
        }

        assertTrue("Payment transaction should have failed, but it didn't.", isPaymentUnsuccessful);

        userDashboardPage.closeButton.click();
        ReusableMethods.wait(2);
        driver.switchTo().defaultContent();
    }

    @And("The user clicks the Add Fund button without entering any information.")
    public void theUserClicksTheAddFundButtonWithoutEnteringAnyInformation() {

        userDashboardPage.amountInput.clear();
        ReusableMethods.wait(2);
        userDashboardPage.addFundButton.click();
        logger.info("The user clicks the Add Fund button without entering any information.");
    }

    @Then("The user tests that the upload wallet transaction failed.")
    public void theUserTestsThatTheUploadWalletTransactionFailed() {

        boolean isUploadUnsuccessful;

        try {
            isUploadUnsuccessful = userDashboardPage.addFundButton.isDisplayed();
            logger.info("Add Fund button is still visible, indicating the upload wallet transaction failed as expected.");
        } catch (NoSuchElementException e) {
            isUploadUnsuccessful = false;
            logger.error("Add Fund button is not visible, upload wallet transaction may have been successful unexpectedly.");
        }

        assertTrue("Upload wallet transaction should have failed, but it didn't.", isUploadUnsuccessful);
        userDashboardPage.cancelButton.click();
    }

    @Then("The user enters invalid email.")
    public void theUserEntersInvalidEmail() {

        iframe = driver.findElement(By.xpath("//iframe[@name='stripe_checkout_app']"));
        driver.switchTo().frame(iframe);
        ReusableMethods.wait(2);

        String invalidEmail = excelReader.getExcelText("Sheet9", 1, 0);
        userDashboardPage.emailInput.sendKeys(invalidEmail);
        logger.info("The user enters invalid email: {}", invalidEmail);
    }

    @And("The user enters valid card information.")
    public void theUserEntersValidCardInformation() {

        ReusableMethods.wait(2);
        JSUtilities.setInputFieldWithJS(driver, userDashboardPage.cardNumberInput, excelReader.getExcelText("Sheet7", 1, 0));
        JSUtilities.setInputFieldWithJS(driver, userDashboardPage.cardExpireInput, excelReader.getExcelText("Sheet7", 1, 1));
        JSUtilities.setInputFieldWithJS(driver, userDashboardPage.cardCvcInput, excelReader.getExcelText("Sheet7", 1, 2));
        userDashboardPage.payButton.click();
        ReusableMethods.wait(2);
        logger.info("The user enters valid card information.");

        driver.switchTo().defaultContent();
    }

    @Then("The user tests that the payment transaction has failed.")
    public void theUserTestsThatThePaymentTransactionHasFailed() {

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
        ReusableMethods.wait(2);
        driver.switchTo().defaultContent();
    }

}
