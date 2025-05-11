package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class HomeHeaderPage extends BasePage  {

    public HomeHeaderPage(WebDriver driver) {
        super(driver);
    }







































    @FindBy(xpath = "(//*[text()='Pending'])[1]")
    public WebElement orderStatus;

    @FindBy(xpath = "//*[@class='text-danger']")
    public WebElement orderNumberInvalid;

    @FindBy(xpath = "(//*[@class='text-center alert alert-danger'])[1]")
    public WebElement searchResualt;

    @FindBy(xpath = "//*[@class='dropdown show category_menu']")
    public WebElement HomePageCategories;

    @FindBy(xpath = "//*[@id='count_down']")
    public WebElement DailyCountDown;

    @FindBy(xpath = "//*[text()='For You']")
    public WebElement ForYouButton;

    @FindBy(xpath = "//span[text()='Track Your Order']")
    public WebElement TrackYourOrder;

    @FindBy(xpath = "//button[text()='Track Now']")
    public WebElement TrackNowButton;

    @FindBy(xpath = "//span[text()='Wishlist (']")
    public WebElement WishlistLink;

    @FindBy(xpath = "(//span[text()='Cart ('])[1]")
    public WebElement CartLink;

    @FindBy(xpath = "//span[text()='New User Zone']")
    public WebElement NewUserZoneLink;

    @FindBy(xpath = "//span[text()='Daily Deals']")
    public WebElement DailyDealsLink;

    @FindBy(xpath = "//span[text()='Compare(']")
    public WebElement CompareLink;

    @FindBy(xpath = "//*[text()='Product compare']")
    public WebElement CompareText;

    @FindBy(xpath = "(//*[text()='New'])[2]")
    public WebElement NewWishList;

    @FindBy(xpath = "//*[text()='Order Summary']")
    public WebElement CartOnline;

    @FindBy(xpath = "//*[@class='logo_img']")
    public WebElement SiteLogo;

    @FindBy(xpath = "(//input[@id='inlineFormInputGroup'])[1]")
    public WebElement SearchBox;

    @FindBy(xpath = "//*[@id='order_number']")
    public WebElement OrderNumberBox;

    @FindBy(xpath = "//*[@id='guest_id']")
    public WebElement IdTextBox;

    @FindBy(xpath = "//*[@class='home_banner bannerUi_active owl-carousel owl-loaded owl-drag']")
    public WebElement homeBanner;









































































































    HomeCategoriesPage homeCategoriesPage = new HomeCategoriesPage(driver);

    @FindBy(xpath = "//*[text()='New Product Deals']")
    public WebElement newProductDealsButton;

    @FindBy(xpath = "//h3[@class='branding_text']")
    public WebElement bestDealsText;

    @FindBy(xpath = "//*[@class='font_16 f_w_700 mb-0 ']")
    public WebElement filterProductsButton;

    @FindBy(xpath = "(//span[@class='checkmark mr_10'])[1]")
    public WebElement tikWomensApparelButton;

    @FindBy(xpath = "//*[@title='List View']")
    public WebElement viewIconButton;

    @FindBy(xpath = "(//*[text()='Sorting by'])[2]")
    public WebElement sortingByButton;

    @FindBy(id = "refresh_btn")
    public WebElement refreshButton;

    @FindBy(xpath = "//*[text()='/ Logout']")
    public WebElement homepageLogoutButton;

    @FindBy(xpath = "(//li[@class='option'])[5]")
    public WebElement newDropdown;





    public void clickNewProductDealsButton() { click(newProductDealsButton); }
    public void clickLogoutButon() { click(homepageLogoutButton); }

    public void clicktikWomensApparelButton() { click(tikWomensApparelButton); }
    public void clickSortingByButton() { click(sortingByButton); }
    public void selectNewOption(WebDriver driver) {homeCategoriesPage.moveToElement(newDropdown);}

    public void clickViewIconButton() { click(viewIconButton); }

    public void clickRefreshButton() { click(refreshButton); }
    public void verifyPageRefresh(WebDriver driver) {

        WebElement oldElement = driver.findElement(By.id("refresh_btn"));
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertTrue(wait.until(ExpectedConditions.stalenessOf(oldElement)));

    }




































}





















