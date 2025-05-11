package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ExcelReader;




public class LoginPages extends BasePage {


    ExcelReader excelReader = new ExcelReader("src/test/resources/TestData.xlsx");

    @FindBy(xpath = "(//a[text()='Login'])[1]")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@*='text']")
    public WebElement emailInput;

    @FindBy(xpath = "//*[@*='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//*[text()='Turn your ideas into reality..']")
    public WebElement RightText;

    @FindBy(xpath = "//img[@class='img-fluid']")
    public WebElement RightImage;

    @FindBy(xpath = "(//*[text()='Sign In'])[1]")
    public WebElement SignInForm;

    @FindBy(xpath = "(//*[text()='Sign In'])[2]")
    public WebElement SignInButton;

    @FindBy(xpath = "//*[text()='Remember me']")
    public WebElement RememberMeButton;

    @FindBy(xpath = "//a[@class='log_out']")
    public WebElement logoutButton;

    @FindBy(xpath = "//a[text()='Click Here']")
    public WebElement forgotPasswordLinki;

    @FindBy (xpath = "//p[text()='Please send password link.']")
    public WebElement forgotPasswordText;

    @FindBy (xpath = "//span[text()='These credentials do not match our records.']")
    public WebElement gecersizLoginText;




    public LoginPages(WebDriver driver) {
        super(driver);
    }

    // Login işlemi
    public void login() {

        emailInput.sendKeys(excelReader.getExcelText("Sheet1", 1, 0));
        passwordInput.sendKeys(excelReader.getExcelText("Sheet1", 1, 1));
        SignInButton.click();
    }
    // Login işlemi
    public void gecersizlogin() {

        emailInput.sendKeys(excelReader.getExcelText("Sheet3", 1, 0));
        passwordInput.sendKeys(excelReader.getExcelText("Sheet3", 1, 1));
        SignInButton.click();
    }

    public void login1() {

        emailInput.sendKeys(excelReader.getExcelText("Sheet1", 2, 0));
        passwordInput.sendKeys(excelReader.getExcelText("Sheet1", 2, 1));
        SignInButton.click();
    }


    public void loginCansu(){

        emailInput.sendKeys(excelReader.getExcelText("Sheet11", 1,0));
        passwordInput.sendKeys(excelReader.getExcelText("Sheet11", 1, 1));
        SignInButton.click();
    }


    public void loginZeynep() {

        emailInput.sendKeys(excelReader.getExcelText("Sheet4", 1, 0));
        passwordInput.sendKeys(excelReader.getExcelText("Sheet4", 1, 1));
        SignInButton.click();
    }




}
