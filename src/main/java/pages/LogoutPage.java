package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.LoggerHelper;





public class LogoutPage extends BasePage {

    @FindBy(xpath = "(//img[@title='BuySellCycle'])[1]")
    public WebElement dashboardSiteLogo;

    @FindBy(xpath = "//*[@class='log_out']")
    public WebElement topBarLogoutButton;

    @FindBy(xpath = "//*[text()='Logout Successfully!']")
    public WebElement anasayfaSideBarCikisiButtonSuccessMessage;

    @FindBy(xpath = "//*[@class='position-relative d-flex align-items-center log_out']")
    public WebElement dashboardSideBarLogoutButton;


    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public void logoutFromHomePage() {

        topBarLogoutButton.click();
        LoggerHelper.info("User clicked on the Logout button in the home page.");
    }


    public void logoutFromSidebar() {
        dashboardSideBarLogoutButton.click();
        LoggerHelper.info("User clicked on the Logout button in the sidebar.");
    }

















}
