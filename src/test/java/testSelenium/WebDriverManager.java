package testSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {
	private final WebDriver driver;

	public WebDriverManager() {
		// Set the path to the ChromeDriver executable
		System.setProperty("webdriver.chrome.driver",
				"C:\\Study\\Swed Uni\\PACK\\chromedriver-win64\\chromedriver.exe");

		// Initialize Chrome options
		final ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		// Initialize WebDriver
		driver = new ChromeDriver(options);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}
