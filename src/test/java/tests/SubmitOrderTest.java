package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.ConfirmationPage;
import pageObjects.LandingPage;
import pageObjects.OrderHistoryPage;
import pageObjects.ProductsCatalogue;
import testComponents.BaseTest;

//gitclonetest
public class SubmitOrderTest extends BaseTest {

	public ProductsCatalogue pc;
	
	
	@Test(dataProvider = "getData")
	public void SubmitOrder(HashMap<String, String> input) throws IOException, InterruptedException
	 {
		
				
		//Capture the returned object and use it for next operations
		pc= lp.loginApplication(input.get("Uname"),input.get("Passwd"));
		
		List<WebElement> products = pc.getProductList();
				
		pc.addToCart(input.get("productName"));
		
		Thread.sleep(5000);
			
		CartPage cp = pc.goToCartPage();

		Boolean match = cp.matchProduct(input.get("productName"));		
		
		Assert.assertTrue(match, "The condition is TRUE! Please check==" + match);
		
		CheckOutPage Chkoutpg = cp.clickOnCheckoutButton();
		
		
		Chkoutpg.SelectCountry("Ind");
		ConfirmationPage ConfPage = Chkoutpg.ClickOnPlaceOrderButton();
		
		String ThankMessage= ConfPage.getConfirmationMessage();

		
		Assert.assertEquals(ThankMessage, "THANKYOU FOR THE ORDER.");
		Assert.assertTrue(ThankMessage.equalsIgnoreCase("Thankyou for the order."));
		
	 }

	
		@Test( dependsOnMethods = "SubmitOrder")
		public void OrderHistory() throws InterruptedException {
			
			pc= lp.loginApplication("Snehal.Chougule04@gmail.com", "NewJob@1008");
			OrderHistoryPage op =pc.goToOrderHistoryPage();
			Boolean match = op.matchProduct_OH(productName);
			Assert.assertTrue(match, "The condition is TRUE! Product found in OH page" + match);
			//Assert.assertFalse(match, "The condition is FALSE..setting it false deliverately" + match);
		}

	
	

		@DataProvider
		public Object[][] getData() throws IOException { // THIS IS VERY IMPORTANT TOPIC
		
			//Map	A collection of key-value pairs.
			//Hash	A technique to store and find data quickly using hash codes.
			//HashMap	A data structure that uses hashing to store key-value pairs efficiently.
			
//			HashMap<String, String> map = new HashMap<String, String>();
//			map.put("Uname","Snehal.Chougule04@gmail.com");
//			map.put("Passwd", "NewJob@1008");
//			map.put("productName", "ZARA COAT 3");
//			
//			HashMap<String, String> map2 = new HashMap<String, String>();
//			map2.put("Uname","Snehal.Chougule04@gmail.com");
//			map2.put("Passwd", "NewJob@1008");
//			map2.put("productName", "ZARA COAT 3");
			
			List<HashMap<String,String>> data = getjsonDatatoMap(System.getProperty("user.dir") + "\\src\\test\\java\\data\\PurchaseOrder.json");
			return new Object[][] {{data.get(0)},{data.get(1)}};

			
		//	return new Object[][] {{map},{map2}};
			
			// tRIED PASSING THE TEST DATA HERE BUT THIS IS NOT GOOD PRACTICE AND HENCE, USED HASHMAP
			
		//	return new Object[][] {{"Snehal.Chougule04@gmail.com","NewJob@1008","ZARA COAT 3"},{"Snehal.Chougule04@gmail.com","NewJob@1008","ZARA COAT 3"}};
			// Its 2D array. meaning Array of Array. 2D does not mean that it will accept only 2 parameters like Uname and Passwd.
			
			
			
			
		}


		
		
		
	}

