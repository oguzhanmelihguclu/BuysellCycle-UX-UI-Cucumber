package stepDefinitions;

import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomeCategoriesPage;
import pages.HomeHeaderPage;
import pages.LoginPages;
import utilities.ExcelReader;
import utilities.ReusableMethods;

public class view_all_categories_latest_products_page_Step {

    private static final Logger logger = LogManager.getLogger();
    WebDriver driver = stepDefinitions.Hooks.getDriver();
    LoginPages loginPages = new LoginPages(driver);
    ExcelReader excelReader = new ExcelReader("src/test/resources/TestData.xlsx");
    HomeHeaderPage homeHeaderPage = new HomeHeaderPage(driver);
    HomeCategoriesPage homeCategoriesPage = new HomeCategoriesPage(driver);

    //US_007
    @When("the user clicks on the {string} menu")
    public void the_user_clicks_on_the_menu(String string) {

        homeHeaderPage.clickNewProductDealsButton();
        logger.info("The user clicks on the New Product Deals menu");
    }

    @Then("the user verifies that the {string} page is displayed")
    public void the_user_verifies_that_the_page_is_displayed(String string) {

        Assert.assertTrue(homeHeaderPage.bestDealsText.isDisplayed());
        logger.info("The user verifies that the New Product Deals page is displayed");
    }

    @Then("the user verifies the visibility of the {string} text")
    public void the_user_verifies_the_visibility_of_the_text(String string) {

        Assert.assertTrue(homeHeaderPage.filterProductsButton.isDisplayed());
        logger.info("The user verifies the visibility of the Filter Products button");
    }
    @When("the user sees and clicks the {string} filter")
    public void the_user_sees_and_clicks_the_filter(String string) {

        homeHeaderPage.clicktikWomensApparelButton();
        logger.info("The user sees and clicks the Women's Apparel filter");

    }
    @Then("the user sees the filtered product list")
    public void the_user_sees_the_filtered_product_list() {

        Assert.assertTrue(homeCategoriesPage.showingProducts.isDisplayed());
        logger.info("The user sees the filtered product list");
    }
    @When("the user clicks on the Sorting By menu")
    public void the_user_clicks_on_the_sorting_by_menu() {

        homeHeaderPage.clickSortingByButton();
        logger.info("The user clicks on the Sorting By menu");

    }

    @When("the user selects the New option from the dropdown")
    public void the_user_selects_the_new_option_from_the_dropdown() {

        homeHeaderPage.selectNewOption(driver);
        logger.info("The user selects the New option from the dropdown");

    }
    @Then("the user should see the list of newly added products")
    public void the_user_should_see_the_list_of_newly_added_products() {

        Assert.assertTrue(homeCategoriesPage.showingProducts.isDisplayed());
        logger.info("The user should see the list of newly added products");
    }

    @When("the user clicks on the icon next to the dropdown menus to change the view settings")
    public void the_user_clicks_on_the_icon_next_to_the_dropdown_menus_to_change_the_view_settings() {

        homeHeaderPage.clickViewIconButton();
        logger.info("The user clicks on the icon next to the dropdown menus to change the view settings");
    }
    @Then("the user verifies that the products are displayed according to the selected icon layout")
    public void the_user_verifies_that_the_products_are_displayed_according_to_the_selected_icon_layout() {

        Assert.assertTrue(homeCategoriesPage.showingProducts.isDisplayed());
        logger.info("The user verifies that the products are displayed according to the selected icon layout");
    }

    @Then("the user sees the {string} button")
    public void the_user_sees_the_button(String string) {

        Assert.assertTrue(homeHeaderPage.refreshButton.isDisplayed());
        logger.info("The user sees the Refresh button");
    }
    @When("the user clicks the Refresh button")
    public void the_user_clicks_the_refresh_button() {

        homeHeaderPage.clickRefreshButton();
        ReusableMethods.wait(3);
        logger.info("The user clicks the Refresh button");
    }
    @Then("the user verifies that the page has been refreshed successfully")
    public void the_user_verifies_that_the_page_has_been_refreshed_successfully() {

    homeHeaderPage.verifyPageRefresh(driver);
    logger.info("The user verifies that the page has been refreshed successfully");

    }

    //============================================US_006===============================================================
    @Then("the user verifies the visibility of the {string} dropdown menu in the navbar")
    public void the_user_verifies_the_visibility_of_the_dropdown_menu_in_the_navbar(String string) {

        Assert.assertTrue(homeCategoriesPage.allCategoriesButton.isDisplayed());
        logger.info("The user verifies the visibility of the All Categories dropdown menu in the navbar");
    }

    @When("the user clicks the Logout button")
    public void the_user_clicks_the_logout_button() {

        homeHeaderPage.clickLogoutButon();
        logger.info("The user clicks the Logout button");
    }

    @When("the user clicks on the {string} dropdown menu in the navbar")
    public void the_user_clicks_on_the_dropdown_menu_in_the_navbar(String string) {

        homeCategoriesPage.clickallCategoriesButton();
        ReusableMethods.wait(3);
        logger.info("The user clicks on the All Categories dropdown menu in the navbar");
    }
    @Then("the user verifies the visibility of the {string} category under the dropdown")
    public void the_user_verifies_the_visibility_of_the_category_under_the_dropdown(String string) {

        Assert.assertTrue(homeCategoriesPage.electronicsMenu.isDisplayed());
        ReusableMethods.wait(3);
        logger.info("The user verifies the visibility of the Electronics category under the dropdown");
    }

    @When("the user hovers over the {string} category")
    public void the_user_hovers_over_the_category(String string) {

        homeCategoriesPage.moveToElement(homeCategoriesPage.electronicsMenu);
        logger.info("The user hovers over the Electronics category");

    }

    @Then("the user sees the {string} subcategory in the opened submenu")
    public void the_user_sees_the_subcategory_in_the_opened_submenu(String string) {

        Assert.assertTrue(homeCategoriesPage.telephoneMenu.isDisplayed());
        logger.info("The user sees the Telephones subcategory in the opened submenu");
    }

    @Then("the user sees and clicks on the {string} subcategory")
    public void the_user_sees_and_clicks_on_the_subcategory(String string) {

        homeCategoriesPage.moveToElement(homeCategoriesPage.telephoneMenu);
        homeCategoriesPage.clickmobilPhoneMenu();
        logger.info("The user sees and clicks on the Mobile Phones subcategory");
    }

    @Then("the user is redirected to the Mobile Phone category page")
    public void the_user_is_redirected_to_the_mobile_phone_category_page() {

        Assert.assertTrue(homeCategoriesPage.showingProducts.isDisplayed());
        logger.info("The user is redirected to the Mobile Phone category page");
    }

}




