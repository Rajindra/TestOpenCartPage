package testSelenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	private final String baseUrl;

	public BasePage(final WebDriver driver, final String baseUrl) {
		this.driver = driver;
		this.baseUrl = baseUrl;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public void navigateToHomePage() {
		driver.get(baseUrl);
	}
}
