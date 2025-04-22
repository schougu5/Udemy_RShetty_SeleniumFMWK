package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{
	
	WebDriver driver;
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}

	By Confirm_message_text = By.cssSelector(".hero-primary");
	
	public String getConfirmationMessage() throws InterruptedException {
		
		TopScrollWebPageUsingJavaScript();
		String ThankMessage =driver.findElement(Confirm_message_text).getText();
		System.out.println(ThankMessage);
		
		return ThankMessage;
		
	}
	
}
