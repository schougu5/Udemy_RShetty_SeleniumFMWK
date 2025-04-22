package tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.ConfirmationPage;
import pageObjects.LandingPage;
import pageObjects.ProductsCatalogue;
import testComponents.BaseTest;
import testComponents.Retry;


public class ErrorValidationTest extends BaseTest {

	 @Test(retryAnalyzer = Retry.class)
	public void IncorrectUserName_SubmitOrder() throws IOException, InterruptedException
	 {
		// TODO Auto-generated method stub

		//Chrome Driver ocnfiguration
		String productName = "ZARA COAT 3";
//		WebDriver driver = new ChromeDriver();
//		
//		driver.get("https://rahulshettyacademy.com/client/");
//		driver.manage().window().maximize();
//		
//		//Implicit wait
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		
		//LandingPage lp = launchApplication();
		
		lp.loginApplication("Snehal.Chougule04@gmail.com1", "NewJob@1008");
		String ErrorMessageUnauthorised = lp.getErrorMessage();
		
		Assert.assertEquals(ErrorMessageUnauthorised, "Incorrect email password.");
  
		    
		}

	
		
	}

