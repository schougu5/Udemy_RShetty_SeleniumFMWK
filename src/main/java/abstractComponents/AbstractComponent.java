package abstractComponents;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.CartPage;
import pageObjects.OrderHistoryPage;

public class AbstractComponent { // abstract English meaning is "Base". Generally, common methods get written here which can be used through out the project
//The Page Layer Helper (Reusable Actions on Pages)
//Think of this as the common toolbox used across pages.
//
//Purpose:
//
//Hold common Selenium methods that are needed across different Page Object classes (e.g., wait handling, click actions).
//
//Usually extended by page classes like LoginPage, CartPage, etc.



	
	WebDriver driver;
	
	// test git collaboartion
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(css="[routerlink*='cart']")
	WebElement CartButton;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement ButtonOrderHistory;
	
	
	 
	
	
	
	public void waitforElementToAppear(By findBytext) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBytext));
			
		
	}
	
	public void WebElementArgumentWaitforElementToAppear(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOf(element));
			
		
	}
	
	
	
	public void sendKeysMethodUsingAction(WebElement element,String InputValue) {
		
		Actions a = new Actions(driver);
		a.sendKeys(element,InputValue).build().perform();
	}
	
	public void scrollWebPageUsingJavaScript() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		
		//wait after scrolling
		Thread.sleep(5000);
	}
	
	public void TopScrollWebPageUsingJavaScript() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");

		
		//wait after scrolling
		Thread.sleep(5000);
	}
	

	
	public CartPage goToCartPage(){
		
		CartButton.click();
		CartPage cp = new CartPage(driver);
		return cp;
		
	}
	
	public OrderHistoryPage goToOrderHistoryPage() throws InterruptedException{
		
		System.out.println("Inside the second test- gotoOHPage");
		ButtonOrderHistory.click();
		OrderHistoryPage op = new OrderHistoryPage(driver);
		return op;
		
	}
	
}
