package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	public LandingPage lp;
	WebDriver driver;
	
	public LandingPage (WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	//WebElement userEmail= driver.findElement(By.id("userEmail"));
	
	
	//Page factory
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submitButton;
	
		
	@FindBy(css="[class*='flyInOut']")
	WebElement Field_ErrorMessageToast;
	
//	By ToastMessage = By.cssSelector("[class*='flyInOut']");
	
	public void goToHomePage() 
	{
		driver.get("https://rahulshettyacademy.com/client/");
		
	}
	
	public ProductsCatalogue loginApplication(String Uname, String Passwd) 
	{
		userEmail.sendKeys(Uname);
		userPassword.sendKeys(Passwd);
		
		submitButton.click();
		ProductsCatalogue pc = new ProductsCatalogue(driver);
		return pc;
		
	}
	
	public String getErrorMessage() {
		
		//waitforElementToAppear(ToastMessage);
		
		WebElementArgumentWaitforElementToAppear(Field_ErrorMessageToast);
		String TextToastErrorMessage = Field_ErrorMessageToast.getText();
		return TextToastErrorMessage;
		
	}
	
}
