package testSelenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class OpenCartTests {

	private static WebDriverManager webDriverManager;
	private WebDriver driver;
	private OpenCartPage openCartPage;
	private final String baseUrl = "https://demo.opencart.com";

	@BeforeAll
	public static void globalSetUp() {
		// This method runs once before all test methods.
		webDriverManager = new WebDriverManager();
	}

	@BeforeEach
	public void setUp() {
		// This method runs before each test method.
		driver = webDriverManager.getDriver();
		openCartPage = new OpenCartPage(driver, baseUrl);
	}

	@AfterEach
	public void tearDown() {
		// This method runs after each test method.
		if (driver != null) {
			// driver.quit();
		}
	}

	@AfterAll
	public static void globalTearDown() {
		// This method runs once after all test methods.
		if (webDriverManager != null) {
			webDriverManager.quitDriver();
		}
	}

	@Test
	public void testHomePageLoad() {
		openCartPage.navigateToHomePage();
		final boolean homePageLoadResult = openCartPage.verifyHomePageLoaded();
		assertTrue(homePageLoadResult, "Homepage Load Test Failed");
	}

	@Test
	public void testSearchProduct() {
		// Test : Search Product
		openCartPage.navigateToHomePage();
		final String searchQuery = "MacBook";
		openCartPage.searchProduct(searchQuery);
		final boolean searchResult = openCartPage.verifySearchResults(searchQuery);
		assertTrue(searchResult, "Search Product Test Failed");
	}

	@Test
	public void testFailedLogin() {
		final String randomUsername = Util.generateRandomUsername() + "@examplex.com";
		final String randomPassword = "wrongpassword";
		openCartPage.login(randomUsername, randomPassword);
		final boolean loginFailedResult = driver.getPageSource()
				.contains("Warning: No match for E-Mail Address and/or Password.");
		assertTrue(loginFailedResult, "Failed Login Test Failed");
	}

	@Test
	public void testRegisterAccount() {
		final String firstName = "Johxx";
		final String lastName = "Doe";
		final String registerEmail = "john.xx" + System.currentTimeMillis() + "@example.com"; // Unique email
		final String registerPassword = "password123";
		openCartPage.registerAccount(firstName, lastName, registerEmail, registerPassword);
		final boolean registerResult = driver.getTitle().contains("Your Account Has Been Created");
		assertTrue(registerResult, "Register Account Test Failed");
		openCartPage.logoutAccount();
	}

	@Test
	public void testFailedRegisterAccountEmptyEmail() {
		final String firstName = "Johxx";
		final String lastName = "Doe";
		final String registerEmail = ""; // Empty email
		final String registerPassword = "password123";
		openCartPage.registerAccount(firstName, lastName, registerEmail, registerPassword);
		final boolean registerResult = driver.getPageSource().contains("E-Mail Address does not appear to be valid!");
		assertTrue(registerResult, "Failed Register Account Test Failed");
	}

	@Test
	public void testFailedRegisterAccountEmptyPW() {
		final String firstName = "Johxx";
		final String lastName = "Doe";
		final String registerEmail = "john.xx" + System.currentTimeMillis() + "@example.com"; // Unique email
		final String registerPassword = ""; // Empty PW
		openCartPage.registerAccount(firstName, lastName, registerEmail, registerPassword);
		final boolean registerResult = driver.getPageSource().contains("Password must be between 4 and 20 characters!");
		assertTrue(registerResult, "Failed Register Account Test Failed");
	}

	@Test
	public void testFailedRegisterAccountEmptyFirstName() {
		final String firstName = "";
		final String lastName = "Doe";
		final String registerEmail = "john.xx" + System.currentTimeMillis() + "@example.com"; // Unique email
		final String registerPassword = "registerPassword1"; // Empty email
		openCartPage.registerAccount(firstName, lastName, registerEmail, registerPassword);
		final boolean registerResult = driver.getPageSource()
				.contains("First Name must be between 1 and 32 characters!");
		assertTrue(registerResult, "Failed Register Account Test Failed");
	}

	@Test
	public void testFailedRegisterAccountEmptyLastName() {
		final String firstName = "Johxx";
		final String lastName = "";
		final String registerEmail = "john.xx" + System.currentTimeMillis() + "@example.com"; // Unique email
		final String registerPassword = "registerPassword1"; // Empty email
		openCartPage.registerAccount(firstName, lastName, registerEmail, registerPassword);
		final boolean registerResult = driver.getPageSource()
				.contains("Last Name must be between 1 and 32 characters!");
		assertTrue(registerResult, "Failed Register Account Test Failed");
	}

	@Test
	public void testLogoutAccount() {
		final String firstName2 = "Johxx";
		final String lastName2 = "Doe";
		final String registerEmail2 = "john.xxx" + System.currentTimeMillis() + "@example.com"; // Unique email
		final String registerPassword2 = "password123";
		openCartPage.registerAccount(firstName2, lastName2, registerEmail2, registerPassword2);
		final boolean registerResult2 = driver.getTitle().contains("Your Account Has Been Created");
		assertTrue(registerResult2, "Register Account Test Failed");
		openCartPage.logoutAccount();
		final boolean logoutResult = driver.getTitle().contains("Account Logout");
		assertTrue(logoutResult, "Logout Account Test Failed");
	}

	@Test
	public void testLogin() {
		final String username = "t.rajindra@gmail.comx";
		final String password = "1234";
		openCartPage.login(username, password);
		final boolean loginResultPassed = driver.getTitle().contains("My Account");
		assertTrue(loginResultPassed, "Passed Login Test Failed");
		openCartPage.logoutAccount();
	}

}
