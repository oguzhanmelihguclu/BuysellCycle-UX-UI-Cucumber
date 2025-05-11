package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class DailyDealsPage extends BasePage{

    public DailyDealsPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "(//*[text()='Daily Deals'])[1]")
    public WebElement dealyDealsMenu;

    @FindBy(id = "count_down")
    public WebElement sayac;

    @FindBy(xpath = "//a[@class='amaz_primary_btn addToCartFromThumnail']")
    public WebElement dailyDealsFirstProduct;

    @FindBy(xpath = "//div[@class='summery_pro_content']")
    public WebElement cartToProductName;

    @FindBy(xpath = "//img[@class='lazyload']")
    public WebElement productCart;

    @FindBy(id = "add_to_cart_btn_modal")
    public WebElement formAddToCart;

    @FindBy(xpath = "//a[@class='addToCompareFromThumnail']")
    public WebElement compare;

    @FindBy(xpath = "(//a[@class='single_top_lists d-flex align-items-center d-none d-md-inline-flex'])[2]")
    public WebElement headerCompare;

    @FindBy(id = "add_to_compare_btn")
    public WebElement addToCompareForm;

    @FindBy(xpath = "//h4[text()=' WRAPAROUND COLLAR TOP ']")
    public WebElement comparePage;

    @FindBy(id = "wishlistbtn_346")
    public WebElement wishlistProductAbove;

    @FindBy(xpath = "(//a[@class='single_top_lists d-flex align-items-center d-none d-md-inline-flex'])[3]")
    public WebElement headerWishlist;

    @FindBy(xpath = "//div[@class='product__meta text-center']")
    public WebElement wihlistPage;







































}
