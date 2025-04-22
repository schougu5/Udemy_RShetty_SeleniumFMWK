package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class ProductsCatalogue extends AbstractComponent{

	public String productName;
	WebDriver driver;
	
	public ProductsCatalogue (WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	//Page factory
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By productsBy = By.cssSelector(".mb-3");
	By productNameBy = By.cssSelector("b");
	By addTocart = By.cssSelector(".card-body button:last-of-type");
	
	public List<WebElement> getProductList()
	{
		waitforElementToAppear(productsBy);
		
		if (products.size() > 0) {
		    System.out.println("Number of elements found: " + products.size());
		}  
		//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		return products;
		
	}
	
	
	//Use of Stream which reduces the few lines of codes
	
			

			// pressing the add to cart button using lastoftype function
			//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
			
			
	public WebElement getProductName(String productName) {
		
		WebElement prod = products.stream()
				.filter(product -> product.findElement(productNameBy)
				.getText().equals(productName))
				.findFirst().orElse(null);
		
		return prod;
		
	}
	
	
	public void addToCart(String productName) {
		
		WebElement prod = getProductName(productName);
		
		prod.findElement(addTocart).click();
		
	}
	
}
