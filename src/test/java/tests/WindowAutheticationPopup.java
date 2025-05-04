package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import testComponents.BaseTest;

public class WindowAutheticationPopup extends BaseTest {
	
	 static Logger logger = Logger.getLogger(WindowAutheticationPopup.class);
	 
	@Test
	public void handleWindowAuthenticationPopup() {
		
	//driver.get("https://the-internet.herokuapp.com/");
		
//		driver.get("http://adming:admin@the-internet.herokuapp.com/");
//	 driver.findElement(By.linkText("Basic Auth")).click();	
//	 
	 driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
	 logger.info("Starting Selenium Test...");

	 
		
	}

}
