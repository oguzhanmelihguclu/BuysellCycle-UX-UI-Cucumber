package stepDefinitions;

import drivers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utilities.LoggerHelper;
import utilities.ReusableMethods;

import java.time.Duration;

public class Hooks {
	private static WebDriver driver;

	@Before
	public void setUp(Scenario scenario) {
		LoggerHelper.info("Test Başlıyor: " + scenario.getName());

		// WebDriver başlat
		driver = DriverManager.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		LoggerHelper.info("Driver başlatıldı");
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			ReusableMethods.takeScreenshot(driver,scenario.getName());
			LoggerHelper.error("Test başarısız oldu: " + scenario.getName());
		} else {
			LoggerHelper.info("Test başarıyla tamamlandı: " + scenario.getName());
		}

		// WebDriver'ı kapat
		DriverManager.quitDriver();
		LoggerHelper.info("Driver kapatıldı.");
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
