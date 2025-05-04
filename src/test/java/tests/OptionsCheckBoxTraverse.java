package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import testComponents.BaseTest;

public class OptionsCheckBoxTraverse extends BaseTest {

	@Test
	public void optioncheckbox() {
		
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement Chbox = driver.findElement(By.cssSelector("#checkBoxOption2"));
		
		Chbox.click();
		
		String FullCheckboxText = Chbox.getDomAttribute("name");
		System.out.println("FullCheckboxText is " + FullCheckboxText);
		
		
		String required_text = FullCheckboxText.substring(FullCheckboxText.length() - 7);
		
		System.out.println("Required_Text is " + required_text);
		
		
		WebElement dropdown = driver.findElement(By.cssSelector("#dropdown-class-example"));
		
		Select sel_OptCheckbox = new Select(dropdown);
		
		sel_OptCheckbox.selectByVisibleText(required_text);		
		
		driver.findElement(By.cssSelector("#name")).sendKeys(required_text);
		driver.findElement(By.cssSelector("#alertbtn")).click();
		
		String AlertText = driver.switchTo().alert().getText();
		System.out.println("Message displayed on Alert Window is " + AlertText);
	
	}
	
	
	
	
}
