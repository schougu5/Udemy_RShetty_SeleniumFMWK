package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import testComponents.BaseTest;

public class AutoSuggestions extends BaseTest {
	
	
	@Test
	public void AutoSuggestion_India() {
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ui-menu-item div")));

	        // Get all suggestions
	        List<WebElement> options = driver.findElements(By.cssSelector(".ui-menu-item div"));

	        // Loop through options and click on "India"
	        for (WebElement option : options) {
	            if (option.getText().equalsIgnoreCase("India")) {
	                option.click();
	                break;
	            }
	        }
	        
	        
	        
	}

}
