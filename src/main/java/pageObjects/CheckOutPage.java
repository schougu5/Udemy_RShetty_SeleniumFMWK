package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
	
	WebDriver driver;
	
	public CheckOutPage (WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(css="[placeholder*='Select Country']")
	WebElement Field_SelectCountry;
	
			
	By Field_CheckOutSuggestionBox = By.cssSelector(".ta-results");
	By Field_India_SelectCountry= By.xpath("//button[contains(@class,'ta-item')][2]");
	By Field_PlaceOrderButton = By.cssSelector(".btnn");
	
	
	public void SelectCountry(String CountryName) {
		
//		Actions a = new Actions(driver);
//	//	a.sendKeys(Field_SelectCountry, CountryName).build().perform();
//		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	
		sendKeysMethodUsingAction(Field_SelectCountry, CountryName);
		
		waitforElementToAppear(Field_CheckOutSuggestionBox);
		driver.findElement(Field_India_SelectCountry).click();
				
	}
	
	public ConfirmationPage ClickOnPlaceOrderButton() throws InterruptedException {
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//
//		
//		//wait after scrolling
//		Thread.sleep(5000);
		scrollWebPageUsingJavaScript();
		
		driver.findElement(Field_PlaceOrderButton).click();
		
		ConfirmationPage ConfPage = new ConfirmationPage(driver);
		return ConfPage;
		
	}

}
