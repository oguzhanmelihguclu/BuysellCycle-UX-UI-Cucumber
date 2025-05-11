package stepDefinitions;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.LoginPages;
import pages.HomeFooterPage;
import drivers.DriverManager;
import utilities.ReusableMethods;
import utilities.JSUtilities;
import java.time.Duration;

public class footer_section_links_Step {

    LoginPages loginPages;
    HomeFooterPage footerPage;
    WebDriver driver;

    public footer_section_links_Step() {
        driver = DriverManager.getDriver();
        loginPages = new LoginPages(driver);
        footerPage = new HomeFooterPage(driver);
    }

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        driver.get("https://qa.buysellcycle.com/login");


        ReusableMethods.wait(2);

    }
    @When("User enters valid credentials and clicks login")
    public void user_enters_valid_credentials_and_clicks_login() {
        loginPages.login();

        ReusableMethods.wait(1);

    }


    @When("User scrolls to the bottom of the page")
    public void user_scrolls_to_the_bottom_of_the_page() {
        JSUtilities.scrollToBottom(driver);

        ReusableMethods.wait(3);

    }

    @Then("Footer section should be visible")
    public void footer_section_should_be_visible() {
        Assert.assertTrue(footerPage.footerContainer.isDisplayed());

        ReusableMethods.wait(3);

    }

    @When("User scrolls to the footer section")
    public void user_scrolls_to_the_footer_section() {
        JSUtilities.waitForPageLoadWithJS(driver, Duration.ofSeconds(5));
        JSUtilities.scrollToElement(driver, footerPage.footerContainer);

        ReusableMethods.wait(2);

    }

    @Then("About Us link should be visible")
    public void about_us_link_should_be_visible() {
        Assert.assertTrue(footerPage.aboutUsLink.isDisplayed());

        ReusableMethods.wait(1);

    }

    @When("User clicks the About Us link")
    public void user_clicks_the_about_us_link() {
        footerPage.aboutUsLink.click();

        ReusableMethods.wait(2);

    }

    @Then("User should be redirected to the About Us page")
    public void user_should_be_redirected_to_the_about_us_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("about-us"));
        driver.navigate().back();

        ReusableMethods.wait(1);

    }

    @Then("Blog link should be visible")
    public void blog_link_should_be_visible() {
        Assert.assertTrue(footerPage.blogLink.isDisplayed());

        ReusableMethods.wait(1);

    }

    @When("User clicks the Blog link")
    public void user_clicks_the_blog_link() {
        footerPage.blogLink.click();

        ReusableMethods.wait(2);

    }

    @Then("User should be redirected to the Blog page")
    public void user_should_be_redirected_to_the_blog_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("blog"));
        driver.navigate().back();

        ReusableMethods.wait(1);

    }

    @Then("Dashboard link should be visible")
    public void dashboard_link_should_be_visible() {
        Assert.assertTrue(footerPage.dashboardLink.isDisplayed());

        ReusableMethods.wait(1);

    }

    @When("User clicks the Dashboard link")
    public void user_clicks_the_dashboard_link() {
        footerPage.dashboardLink.click();

        ReusableMethods.wait(1);


    }
    @Then("User should be redirected to the Dashboard page")
    public void user_should_be_redirected_to_the_dashboard_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        driver.navigate().back();

        ReusableMethods.wait(1);
    }

    @When("User enters a valid email into the newsletter field")
    public void user_enters_a_valid_email_into_the_newsletter_field() {
        footerPage.newsletterInput.sendKeys(ReusableMethods.randommail());
        ReusableMethods.wait(2);
    }
    @When("User clicks the Subscribe button")
    public void user_clicks_the_subscribe_button() {
        footerPage.subscribeButton.click(); //
}

    @Then("A success message should be displayed")
    public void a_success_message_should_be_displayed() {
        Assert.assertTrue( footerPage.successMessage.isDisplayed());

    }

    @Then("App Store and Google Play icons should be visible")
    public void app_store_and_google_play_icons_should_be_visible() {
        Assert.assertTrue(footerPage.appStoreIcon.isDisplayed());
        Assert.assertTrue(footerPage.googlePlayIcon.isDisplayed());

        ReusableMethods.wait(3);
    }

    @When("User clicks on each store icon")
    public void user_clicks_on_each_store_icon() {
        footerPage.appStoreIcon.click();
        ReusableMethods.wait(2);
        driver.navigate().back();
        footerPage.googlePlayIcon.click();
        ReusableMethods.wait(2);
        driver.navigate().back();

    }

    @Then("Each should redirect to the correct store page")
    public void each_should_redirect_to_the_correct_store_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("google") || driver.getCurrentUrl().contains("apple"));

        ReusableMethods.wait(3);

    }

    @Then("Facebook icon should be visible")
    public void facebook_icon_should_be_visible() {
        Assert.assertTrue(footerPage.facebookIcon.isDisplayed());

        ReusableMethods.wait(3);

    }

    @When("User clicks each social media icon")
    public void user_clicks_each_social_media_icon() {
        footerPage.facebookIcon.click();
        driver.navigate().back();

        ReusableMethods.wait(3);

    }

    @Then("User should see the copyright text")
    public void user_should_see_the_copyright_text() {
        // Scroll ederek elementi görünür hale getir
        JSUtilities.scrollToElement(driver, footerPage.copyrightText);

        // Elementin görünür olduğunu doğrula
        Assert.assertTrue("Copyright metni görünmüyor!", footerPage.copyrightText.isDisplayed());

        ReusableMethods.wait(3);

    }

    @And("User clicks the Back to Top button")
    public void user_clicks_the_back_to_top_button() {
        JSUtilities.scrollToBottom(driver);
        ReusableMethods.wait(2); //
        JSUtilities.highlightElementWithJS(driver, footerPage.backToTopButton);
        footerPage.backToTopButton.click();
        ReusableMethods.wait(2);

        // Yukarı çıkma doğrulaması
        int scrollY = ((Number)((JavascriptExecutor) driver).executeScript("return window.scrollY;")).intValue();
        Assert.assertTrue("Sayfa yukarı çıkmadı!", scrollY < 100);

}

    @Then("Page should scroll smoothly to the top")
    public void page_should_scroll_smoothly_to_the_top() {
        JSUtilities.scrollToTop(driver);
        ReusableMethods.wait(1);
        Assert.assertTrue(driver.getCurrentUrl().contains("buysellcycle"));
    }
}