package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import abstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	
	WebDriver driver;
	
	public CartPage (WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	//List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));		
		
	//Page factory
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;
	
	
	@FindBy(css=".totalRow button")
	WebElement checkckOutButton;
	
	
	
	public Boolean matchProduct(String productName) 
	{
		
		Boolean match= cartproducts.stream().anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productName));
		return match;
	
	}
		
	
	public CheckOutPage clickOnCheckoutButton() {
		
		checkckOutButton.click();
		
		CheckOutPage Chkoutpg = new CheckOutPage(driver);
		return Chkoutpg;
		
	}
	
}
