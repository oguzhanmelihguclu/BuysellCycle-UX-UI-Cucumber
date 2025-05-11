package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class JSUtilities {

    // A function that scrolls the page up to the specified element.
    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    // A function that clicks the specified element using the JavaScriptExecutor.
    public static void clickWithJS(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // Function that assigns a value to the specified input element.
    public static void setInputFieldWithJS(WebDriver driver, WebElement element, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + value + "';", element);
    }

    // A function that retrieves the text of the specified element using JavaScriptExecutor.
    public static String getTextWithJS(WebDriver driver, WebElement element) {
        return ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;", element).toString();
    }



        // A function that highlights the specified element using JavaScriptExecutor.

    public static void highlightElementWithJS(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
    }

    // A function that waits until the page is loaded.
    public static void waitForPageLoadWithJS(WebDriver driver, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    // A function that scrolls to the bottom of the page.
    public static void scrollToBottom(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    // A function that scrolls to the top of the page.
    public static void scrollToTop(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
    }

    // A function that returns the number of open windows.
    public static int getNumberOfOpenWindows(WebDriver driver) {
        return driver.getWindowHandles().size();
    }

    public static void scrollsToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
    }

}
