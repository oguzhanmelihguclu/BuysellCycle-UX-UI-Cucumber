package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;
import utilities.*;







public class AdminProfileNotificationsPage extends BasePage{

    public AdminProfileNotificationsPage(WebDriver driver) {

        super(driver);
    }


    @FindBy(id = "sign_in_btn")
    public WebElement adminSignInButton;

    @FindBy(id = "profile_pic")
    public WebElement adminProfilePicture;

    @FindBy(xpath = "//*[@*='fa fa-bell']")
    public WebElement notificationBell;

    @FindBy(xpath = "//*[@*='notification_count']")
    public WebElement notificationCount;

    @FindBy(xpath = "//*[.='Setting']")
    public WebElement notificationBellSetting;

    @FindBy(xpath = "(//h3)[1]")
    public WebElement personalNotificationSettingText;

    @FindBy(xpath = "//*[@*='6893']")
    public WebElement registerCheckmark;

    @FindBy(xpath = "//*[@*='6898']")
    public WebElement pendingCheckmark;

    @FindBy(xpath = "//*[@*='toast-message']")
    public WebElement updateSuccessfullyText;

    @FindBy(xpath = "//*[.='View']")
    public WebElement notificationBellView;

    @FindBy(xpath = "(//*[@*='save_button_parent'])[1]")
    public WebElement notificationsPageView;

    @FindBy(xpath = "//*[.='Read all']")
    public WebElement notificationBellReadAll;










































    //
    public void adminLogin() {


        emailTextBox.sendKeys(excelReader.getExcelText("adminSheet1", 1, 0));
        passwordTextBox.sendKeys(excelReader.getExcelText("adminSheet1", 1, 1));

        Actions actions = new Actions(driver);
        actions.moveToElement(adminSignInButton).perform();

        ReusableMethods.waitForVisibility(adminSignInButton, 5);
        adminSignInButton.click();

    }

    ExcelReader excelReader = new ExcelReader("src/test/resources/TestData.xlsx");

    @FindBy(xpath = "//input[@placeholder = 'Email address or phone']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//input[@id = 'password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//*[text() = 'My Profile']")
    public WebElement adminMyProfileLink;

    @FindBy (xpath = "//*[text()='Basic Info']")
    public WebElement basicInfoLabel;

    @FindBy (xpath = "//input[@id='first_name']")
    public WebElement basicInfoFirstNameTextBox;

    @FindBy (xpath = "//input[@id='last_name']")
    public WebElement basicInfoLastNameTextBox;

    @FindBy (xpath = "//input[@id='email']")
    public WebElement basicInfoEmailTextBox;

    @FindBy (xpath = "//input[@id='phone']")
    public WebElement basicInfoPhoneTextBox;

    @FindBy (xpath = "//input[@id='date_of_birth']")
    public WebElement basicInfoDateOfBirthTextBox;

    @FindBy (xpath = "//*[@id='update_info']")
    public WebElement basicInfoUpdateInfoButton;

    @FindBy (xpath = "//*[text()='Basic Info ']")
    public WebElement basicInfoHeaderButton;

    @FindBy (xpath = "//*[@id='address_list_tab']")
    public WebElement addressButton;

    @FindBy (xpath = "//*[text()='Edit']")
    public WebElement addressEditButton;

    @FindBy (xpath = "//*[contains(@class, 'new_address')]")
    public WebElement addNewAddressButton;

    @FindBy (xpath = "//input[@id = 'address_name']")
    public WebElement addressNameTextBox;

    @FindBy (xpath = "//input[@id = 'Email_Address1']")
    public WebElement emailAddressTextBox;

    @FindBy (xpath = "//input[@id='customer_phn']")
    public WebElement customerPhoneTextBox;

    @FindBy (xpath = "//input[@id='postal_code']")
    public WebElement postalCodeTextBox;

    @FindBy (xpath = "//span[text()='Select from options']")
    public WebElement cityDropDown;

    @FindBy (xpath = "(//*[text()='Save'])[3]")
    public WebElement saveAddressButton;

    @FindBy (xpath = "//li[contains(@class, 'option') and normalize-space(text())='Airmont']")
    public WebElement citySelectSearch;

    @FindBy (xpath = "//input[@id='Address']")
    public WebElement addressTextBox;








}
