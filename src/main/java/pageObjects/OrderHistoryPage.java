package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class OrderHistoryPage extends AbstractComponent {

	WebDriver driver;
	

	public OrderHistoryPage(WebDriver driver) {
		
		super(driver);
		
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> OrderHistoryproducts;
	


	public Boolean matchProduct_OH(String productName) 
	{
		
		Boolean match= OrderHistoryproducts.stream().anyMatch(abc -> abc.getText().equalsIgnoreCase(productName));
		return match;
	
	}
	
}
