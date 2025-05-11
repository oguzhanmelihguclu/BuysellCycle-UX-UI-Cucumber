package pages;

import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ExcelReader;





public class HomeFooterPage extends  BasePage {

    public HomeFooterPage(WebDriver driver) {
        super(driver);
    }

    ExcelReader excelReader = new ExcelReader("src/test/resources/TestData.xlsx");

    @FindBy(xpath = "//footer//a[contains(text(),'About Us')]")
    public WebElement aboutUsLink;

    @FindBy(xpath = "//footer//a[text()='Blog']")
    public WebElement blogLink;

    @FindBy(xpath = "//footer//a[contains(@href, '/profile/dashboard')]")
    public WebElement dashboardLink;

    @FindBy(xpath = "//footer//a[contains(@href, '/profile')]")
    public WebElement myProfileLink;

    @FindBy(id = "subscription_email_id")
    public WebElement newsletterInput;

    @FindBy(id = "subscribeBtn")
    public WebElement subscribeButton;

    @FindBy(xpath = "//a[contains(@class, 'google_play_box')]")
    public WebElement googlePlayIcon;

    @FindBy(xpath = "(//a[contains(@class, 'google_play_box')])[2]")
    public WebElement appStoreIcon;

    @FindBy(xpath = "//footer//a[contains(@href, 'facebook.com')]")
    public WebElement facebookIcon;

    @FindBy(xpath = "//div[contains(@class, 'copy_right_text')]")
    public WebElement copyrightText;

    @FindBy(xpath = "//div[@id='back-top']/a")
    public WebElement backToTopButton;

    @FindBy(xpath = "//footer")  //
    public WebElement footerContainer;

    @FindBy(xpath = "//*[@class='text-success']")
    public WebElement successMessage;










}


