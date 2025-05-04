package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import testComponents.BaseTest;

public class CheckboxAssignment extends BaseTest {
	
	
	
	@Test
	public void CheckboxTest() {
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement Chbox1 = driver.findElement(By.cssSelector("#checkBoxOption1"));
		
		Chbox1.click();
		
		if(Chbox1.isSelected()) {
			
			System.out.println("Checkbox is checked");
		}
		
		Chbox1.click();
		
		if(Chbox1.isSelected()) {
			
			System.out.println("Checkbox is Checked...");
		}else
		{
			
			System.out.println("Checkbox is UNCHECKED...");
			
		}
			
			
		
		//input[contains(@id,'checkBoxOption')]
		
		
		List<WebElement> countofCheckboxes =driver.findElements(By.xpath("//input[contains(@id,'checkBoxOption')]"));
		
		
		System.out.println("Number of Checkboxes present on site = " + countofCheckboxes.size());
		
	}
	
	

}
