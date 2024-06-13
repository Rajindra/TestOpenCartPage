package testSelenium;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {
	private final WebDriver driver;

	public WebDriverManager() {
		// Load properties from the config file
		Properties properties = new Properties();
		try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
			if (input == null) {
				System.out.println("Sorry, unable to find config.properties");
				throw new RuntimeException("config.properties not found");
			}
			properties.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new RuntimeException("Failed to load config.properties");
		}

		// Set the path to the ChromeDriver executable
		System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));

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
