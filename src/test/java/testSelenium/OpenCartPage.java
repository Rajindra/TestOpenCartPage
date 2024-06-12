package testSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpenCartPage extends BasePage {

	public OpenCartPage(final WebDriver driver, final String baseUrl) {
		super(driver, baseUrl);
	}

	public boolean verifyHomePageLoaded() {
		return driver.getTitle().equals("Your Store");
	}

	public void searchProduct(final String query) {
		final WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
		searchBox.sendKeys(query + Keys.ENTER);
	}

	public boolean verifySearchResults(final String query) {
		try {
			final List<WebElement> searchResults = wait
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".product-thumb")));
			for (final WebElement result : searchResults) {
				if (result.getText().contains(query)) {
					return true;
				}
			}
		} catch (final Exception e) {
			System.out.println("Exception caught while verifying search results: " + e.getMessage());
		}
		return false;
	}

	public void login(final String username, final String password) {
		navigateToHomePage();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("My Account"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Login"))).click();

		final WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));
		final WebElement passwordInput = driver.findElement(By.id("input-password"));

		emailInput.sendKeys(username);
		passwordInput.sendKeys(password);

		driver.findElement(By.xpath("//*[@id='form-login']/button")).click();

		try {
			Thread.sleep(1000);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void registerAccount(final String firstName, final String lastName, final String email,
			final String password) {
		navigateToHomePage();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("My Account"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register"))).click();

		final WebElement firstNameInput = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-firstname")));
		final WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
		final WebElement emailInput = driver.findElement(By.id("input-email"));
		final WebElement passwordInput = driver.findElement(By.id("input-password"));

		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		emailInput.sendKeys(email);
		passwordInput.sendKeys(password);

		try {
			Thread.sleep(1000);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

		// Wait until the checkbox is present and clickable
		final WebElement agreeCheckbox = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='form-register']/div/div/div/input[@name='agree']")));

		// Scroll to the checkbox to ensure it's in view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", agreeCheckbox);

		// Click the checkbox
		agreeCheckbox.click();

		try {
			Thread.sleep(1000);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

		final WebElement continueButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form-register\"]/div/div/button")));

		// Scroll to the Continue button to ensure it's in view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueButton);

		// Click the Continue button
		continueButton.click();

		try {
			Thread.sleep(1000);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void logoutAccount() {
		navigateToHomePage();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Logout")).click();

		try {
			Thread.sleep(1000);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
	}
}
