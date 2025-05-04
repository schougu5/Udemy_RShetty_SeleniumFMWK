package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testComponents.BaseTest;

public class AssignmentLoginPractice extends BaseTest {

	@Test
	public void loginPractice() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername("rahulshettyacademy");
		loginPage.enterPassword("learning");
		loginPage.selectUserRadioButton();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement okayBtn = wait.until(ExpectedConditions.elementToBeClickable(loginPage.getOkayButton()));
		okayBtn.click();

		loginPage.acceptTerms();
		loginPage.selectUserType("Consultant");
		loginPage.clickSignIn();

		HomePage homePage = new HomePage(driver);
		wait.until(ExpectedConditions.visibilityOf(homePage.getCheckoutButton()));

		Assert.assertTrue(
				homePage.getCheckoutButton().isDisplayed(),
				"You are on Home Page as CheckOut button is Visible..."
		);

		List<WebElement> addToCartButtons = homePage.getAddToCartButtons();
		int total = addToCartButtons.size();

		for (int i = 0; i < total; i++) {
			addToCartButtons = homePage.getAddToCartButtons(); // Re-fetch the list
			WebElement addBtn = addToCartButtons.get(i);
			addBtn.click();
		}

		homePage.clickCheckout();

		List<WebElement> removeButtons = homePage.getRemoveButtons();
		int totalRemoveButtons = removeButtons.size();

		Assert.assertEquals(total, totalRemoveButtons);
		System.out.println("Test case PASSED");
	}
}