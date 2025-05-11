package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.JSUtilities;
import utilities.ReusableMethods;






public class CartCheckoutPage extends BasePage {


    public CartCheckoutPage(WebDriver driver) {
        super(driver);
    }
    //zeynep

    HomeCategoriesPage homeCategoriesPage = new HomeCategoriesPage(driver);

    @FindBy(xpath = "(//*[@type='submit'])[3]")
    public WebElement continueToShippingButton;

    @FindBy(xpath = "//*[@id='payment_btn_trigger']")
    public WebElement orderNowButton;

    @FindBy(xpath = "(//*[@class='m-0 flex-fill'])[1]")
    public WebElement contactInfo;

    @FindBy(xpath = "(//*[@class='m-0 flex-fill'])[2]")
    public WebElement shipToInfo;

    @FindBy(xpath = "(//*[@class='edit_info_text'])[1]")
    public WebElement changeContactButton;

    @FindBy(xpath = "(//*[@class='edit_info_text'])[2]")
    public WebElement changeShipToButton;

    @FindBy(xpath = "(//*[@type='radio'])[3]")
    public WebElement billingRadioButton;

    @FindBy(xpath = "(//input[@type='radio'])[4]")
    public WebElement stripeRadioButton;

    @FindBy(xpath = "//*[@*='order_sumery_box flex-fill']")
    public WebElement orderSummary;

    @FindBy(xpath = "//*[@id='coupon_code']")
    public WebElement couponCodeInput;

    @FindBy(xpath = "(//*[@type='button'])[1]")
    public WebElement applyButton;

    @FindBy(xpath = "//*[.='Thank you for your purchase!']")
    public WebElement thankYouForYourPurchaseText;

    @FindBy(xpath = "//p[contains(text(), 'Your order number is')]")
    public WebElement orderNumberText;

    @FindBy(xpath = "//*[@class='flex-fill']")
    public WebElement itemsPurchased;

    @FindBy(xpath = "//*[.='View Order']")
    public WebElement viewOrderButton;

    @FindBy(xpath = "//*[.='Continue Shopping']")
    public WebElement continueShoppingButton;

    @FindBy(xpath = "(//*[@class='single_total_right'])[1]")
    public WebElement subtotal;

    @FindBy(xpath = "(//*[@class='single_total_right'])[2]")
    public WebElement shippingCharge;

    @FindBy(xpath = "(//*[@class='single_total_right'])[3]")
    public WebElement discount;

    @FindBy(xpath = "(//*[@class='single_total_right'])[4]")
    public WebElement vatTaxGst;

    @FindBy(xpath = "(//*[@class='single_total_right'])[6]")
    public WebElement total;

    @FindBy(xpath = "//*[.='Valid Coupon Code']")
    public WebElement couponConfirm;

    @FindBy(xpath = "(//*[@class='single_total_left flex-fill'])[5]")
    public WebElement couponDiscount;

    @FindBy(xpath = "//*[.='Return to information']")
    public WebElement returnToInformation;

    @FindBy(xpath = "//li[@data-value='0' and text()='New Address']")
    public WebElement newAddress;

    @FindBy(xpath = "(//*[@class='payment_method'])[2]")
    public WebElement stripeButton;

    @FindBy(xpath = "//div[@class='nice-select theme_select style2 wide mb_20']")
    public WebElement addressDdm;

    @FindBy(xpath = "//li[@data-value='451' and text()='Türkiye']")
    public WebElement option;






























































































































































































    @FindBy(xpath = "(//*[@type=\"text\"])[1]")
    public WebElement SearchButton;

    //Cart(Sepet) sayfasinda oldugumu gösteren locat
    @FindBy(xpath = "//*[text()='Order Summary']")
    public WebElement OrderSummaryButton;

    @FindBy(xpath = "(//* [@class=\"single_top_lists d-flex align-items-center d-none d-md-inline-flex\"])[4]")
    public WebElement HomeCartButton;

    //Cart(Sepet) sayfasinda oldugumu gösteren locat
    @FindBy(xpath = "//a[@class=\"amaz_primary_btn addToCartFromThumnail\"]")
    public WebElement urunCartButton;


    @FindBy(xpath = "//*[@class='summery_pro_content']")
    public WebElement urunTextbutton;

    @FindBy(xpath = "(//*[@class=\"single_total_right\"])[1]")
    public WebElement urunSubtotalbutton;

    @FindBy(xpath = "(//div[@class='thumb'])[1]")
    public WebElement urunGorselbutton;


    //Cart(sepet) ekledigim ürünün onayi icin
    @FindBy(xpath = "//*[@class='d-flex flex-column gap_10']")
    public WebElement ViewCartButton;

    //Cart(sepet) ürünü eklemek icin locat
    @FindBy(xpath = "(//*[@class='col-md-6'])[1]")
    public WebElement AddToCartButton;

    //sepette buounan
    @FindBy(xpath = "//a[@class='amaz_primary_btn2 style3']")
    public WebElement ContinueShoppingButton;

    //sepetteki Remove butonu
    @FindBy(xpath = "(//*[@class='font_14 f_w_700 m-0 text-nowrap priamry_text text-uppercase'])[5]")
    public WebElement RemoveCartButton;

    //sepetteki Shipping Charge butonu
    @FindBy(xpath = "(//*[@class='single_total_left flex-fill'])[2]")
    public WebElement ShippingChargeCartButton;

    //sepetteki Discount butonu
    @FindBy(xpath = "(//*[@class='single_total_left flex-fill'])[3]")
    public WebElement DiscountCartButton;

    //sepetteki VAT/TAX/GST ordery summery butonu
    @FindBy(xpath = "(//*[@class='single_total_left flex-fill'])[4]")
    public WebElement VATTAXGSTSummeryCartButton;

    @FindBy(xpath = " //*[@id='delete_item_2150']")
    public WebElement urunYokbutonuButton;




















































    // Sezgin Locate

    @FindBy(xpath = "(//img[@alt='Relax & Play Swing'])[1]")
    public WebElement selectedProductForCart;

    @FindBy(xpath = "//button[@id='add_to_cart_btn']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='d-flex flex-column gap_10']")
    public WebElement viewCartButton;

    @FindBy(xpath = "//a[text()='Proceed to checkout']")
    public WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//button[text()='Continue To Shipping']")
    public WebElement continueToShippingButton1;

    @FindBy(id = "coupon_code")
    public WebElement couponCodeApplyButton;

    @FindBy(xpath = "//h4[@class='font_16 f_w_700 text-nowrap m-0 theme_hover']")
    public WebElement checkoutProductName;

    @FindBy(xpath = "//h4[@class='font_16_top f_w_500 m-0 text-nowrap']")
    public WebElement checkoutProductPiece;

    @FindBy(xpath = "(//span[@class='total_text'])[1]")
    public WebElement totalText;

    @FindBy(xpath = "(//span[@class='total_text'])[1]")
    public WebElement totalAmount;

    @FindBy(xpath = "(//span[@class='total_text'])[1]")
    public WebElement contactForm;

    @FindBy(id = "note")
    public WebElement orderNote;

    @FindBy(id = "subscription_email_id")
    public WebElement subscriptionForm;

    @FindBy(id = "subscribeBtn")
    public WebElement subscriptionButton;

    @FindBy(xpath = "//div[@class='message_div error_color']")
    public WebElement subscribeToNewsletterVerification;

    @FindBy(xpath = "(//span[@class='label_name f_w_400 '])[2]")
    public WebElement IagreeTermsCheckBox;

    @FindBy(id = "error_term_check")
    public WebElement errorMassage;

    @FindBy(id = "return_text")
    public WebElement returnToCartButton;



    public void addProductToCart(){

        ReusableMethods.wait(2);
        JSUtilities.clickWithJS(driver, homeCategoriesPage.allCategoriesButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(homeCategoriesPage.electronicsMenu).perform();
        ReusableMethods.wait(2);
        actions.scrollToElement(homeCategoriesPage.telephoneMenu);
        ReusableMethods.wait(2);
        JSUtilities.clickWithJS(driver, homeCategoriesPage.mobilPhoneMenu);
        ReusableMethods.wait(2);
        JSUtilities.scrollsToElement(driver, homeCategoriesPage.addToCartIcon);
        ReusableMethods.wait(2);
        JSUtilities.clickWithJS(driver, homeCategoriesPage.addToCartIcon);
        ReusableMethods.wait(2);
        JSUtilities.clickWithJS(driver, homeCategoriesPage.viewCartButton);
    }

}



