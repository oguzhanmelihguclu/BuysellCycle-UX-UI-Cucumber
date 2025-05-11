package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		if (driver.get() == null) {
			String browser = config.ConfigReader.getProperty("browser").toLowerCase();
			switch (browser) {
				case "chrome":

					WebDriverManager.chromedriver().setup();
					driver.set(new ChromeDriver());
					break;
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver.set(new FirefoxDriver());
					break;
				default:
					throw new IllegalArgumentException("Unsupported browser: " + browser);
			}

		}
		return driver.get();
	}


	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}



}
