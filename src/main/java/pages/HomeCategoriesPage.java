package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import java.util.List;





public class HomeCategoriesPage extends BasePage{

    public HomeCategoriesPage(WebDriver driver) {

        super(driver);

    }


    Actions actions = new Actions(driver);



  




    @FindBy(xpath = "//*[@class='Categories_togler']")
    public WebElement allCategoriesButton;

    @FindBy(xpath = "//*[text()=' Electronics']")
    public WebElement electronicsMenu;

    @FindBy(xpath = "(//*[text()='Telephone'])[1]")
    public WebElement telephoneMenu;

    @FindBy(xpath = "//*[text()='Mobile Phone']")
    public WebElement mobilPhoneMenu;



    @FindBy(xpath = "//*[@class='font_16 f_w_500 mr_10 mb-0']")
    public WebElement showingProducts;


    @FindBy(xpath = "(//img[@title=\"BuySellCycle\"])[1]")
    public WebElement dashboardHome;

    @FindBy(xpath = "(//span[@class='title_text'])[1]")
    public WebElement bestdealsViewAll;

    @FindBy(xpath = "//div[@class='product_widget5 mb_30 style5 w-100']")
    public List<WebElement> bestDealsList;

















































































    @FindBy(xpath = "//h3")
    public WebElement subCategoryName;

    //
    @FindBy(xpath = "(//*[@title = 'Add to Cart'])[1]")
    public WebElement addToCartIcon;

    @FindBy(xpath = "//*[text()='View cart']")
    public WebElement viewCartButton;

    @FindBy(xpath = "//*[text()='Item added to your cart']")
    public WebElement itemAddedConfirmationElement;



    @FindBy(xpath = "(//*[@class='product_thumb_upper'])[1]")
    public WebElement firstProductCard;

    @FindBy(xpath = "(//*[@class='product_thumb_upper'])[2]")
    public WebElement secondProductCard;

    @FindBy(xpath = "//*[text()='Product compare']")
    public WebElement productCompareLabel;

    @FindBy(xpath = "(//*[@class='product_thumb_upper']//*[@title='Compare'])[1]")
    public WebElement compareIcon;

    @FindBy(xpath = "(//*[@class='product_thumb_upper']//*[@title='Compare'])[2]")
    public WebElement compareIcon2;






    public void clickallCategoriesButton() {
        click(allCategoriesButton);
    }


    public void moveToElement(WebElement element) {
        actions.moveToElement(element).perform();

    }

    public void clickmobilPhoneMenu() {
        click(mobilPhoneMenu);

    }

    @FindBy(xpath = "(//*[@class='product_thumb_upper'])[1]//*[@class='add_to_wishlist is_wishlist']")
    public WebElement addToWishListIcon1;

    @FindBy(xpath = "(//*[@class='product_thumb_upper'])[1]//*[@class='add_to_wishlist is_wishlist']")
    public WebElement addToWishListIcon2;

    @FindBy(xpath = "(//*[@class='product_thumb_upper']//*[@title='Wishlist'])[1]")
    public WebElement wishListIcon;

    @FindBy(xpath = "(//*[contains(text(),'Showing')])[1]")
    public WebElement wishResultSet;

    @FindBy(xpath = "(//*[@class='product_thumb_upper']//*[@title='Quick View'])[1]")
    public WebElement quickViewIcon;

    @FindBy(xpath = "(//*[@id='add_to_cart_btn_modal'])[1]")
    public WebElement quickViewAddToCartButton;

    @FindBy(xpath = "(//*[@class='ti-close'])[2]")
    public WebElement closeProductDetailsWindow;

    @FindBy(xpath = "(//*[contains(text(), 'Show')])[8]")
    public WebElement showMoreItemsDropDown;

}
