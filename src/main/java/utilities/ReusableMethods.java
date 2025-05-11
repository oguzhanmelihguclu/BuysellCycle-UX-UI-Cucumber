package utilities;

import drivers.DriverManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;
import static org.apache.poi.hssf.record.FtPioGrbitSubRecord.length;


public class ReusableMethods {


    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }


    public static void takeScreenshot(WebDriver driver, String name) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(name, new ByteArrayInputStream(screenshot));
    }


    //========Switching Window=====//
    public static void switchToWindow(String targetTitle) {
        String origin = DriverManager.getDriver().getWindowHandle();
        for (String handle : DriverManager.getDriver().getWindowHandles()) {
            DriverManager.getDriver().switchTo().window(handle);
            if (DriverManager.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        DriverManager.getDriver().switchTo().window(origin);
    }

    // wait
    public static void wait(int saniye) {

        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            System.out.println("Thread.sleep calismadi");
        }


    }



































    public static String stringmail(int lenght) {

        String karakter = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            result.append(karakter.charAt(random.nextInt(karakter.length())));
        }
        return result.toString();

    }

public static String randommail()
{
    String username=stringmail(8);
    String domain="@testgmail.com";
    return username + domain;
}














    //
    public static void clickWithToastCheck(WebElement element) {
        try {
            // Eğer ekran üzerinde "toast" varsa onun kaybolmasını bekle
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("toast")));

            // Tıklanacak elementin görünür ve tıklanabilir olmasını bekle
            wait.until(ExpectedConditions.elementToBeClickable(element));

            // Tıklama işlemini gerçekleştir
            element.click();
        } catch (Exception e) {
            System.out.println("Click with toast check failed: " + e.getMessage());
            throw e; // Testin fail olmasını istersen bunu bırak
        }
    }
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    //========Hover Over=====//
    public static void hover(WebElement element) {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(element).perform();
    }

    public static WebElement waitForClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void hoverAndClick(WebElement element) {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(element).perform();
        element.click();
    }

    public static void hoverWithToastCheck(WebElement element) {
        try {
            // Eğer ekran üzerinde "toast" varsa onun kaybolmasını bekle
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("toast")));

            // Elementin görünür olmasını bekle
            wait.until(ExpectedConditions.visibilityOf(element));

            // Hover işlemini gerçekleştir
            Actions actions = new Actions(DriverManager.getDriver());
            actions.moveToElement(element).perform();

        } catch (Exception e) {
            System.out.println("Hover with toast check failed: " + e.getMessage());
            throw e;
        }


    }

    public static void safeHover(WebElement element) {
        try {
            // 1. Toast mesajı varsa kaybolmasını bekle
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@class, 'toast')]")));

            // 2. Scroll ile ortala
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

            // 3. Element görünür hale gelene kadar bekle
            wait.until(ExpectedConditions.visibilityOf(element));

            // 4. Hover işlemi
            Actions actions = new Actions(DriverManager.getDriver());
            actions.moveToElement(element).perform();

        } catch (Exception e) {
            System.out.println("safeHover hatası: " + e.getMessage());
        }
    }


























}

















