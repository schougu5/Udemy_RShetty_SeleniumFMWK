package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import testComponents.BaseTest;

public class AssignmentAllElements extends BaseTest{

	
	@Test
	public void TestAllWebElements() {
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Wissen");
		driver.findElement(By.name("email")).sendKeys("snehal.chougule04@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("123456");
		driver.findElement(By.cssSelector("label[for='exampleCheck1']")).click();
		
		driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']"));
		
		Select genderSelect = new Select(driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']")));
		genderSelect.selectByVisibleText("Female");
		
		
		driver.findElement(By.cssSelector("label[for='inlineRadio2']")).click();
		
		driver.findElement(By.name("bday")).sendKeys("8/28/1989");
		
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
		String expectedSubstring = "Success! The Form has been submitted successfully!";
		
		String actualText = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
		
		System.out.println("Success message is " + actualText);
		
		 Assert.assertTrue(
		            actualText.contains(expectedSubstring),
		            "Expected success message to contain [" + expectedSubstring + "], but was: [" + actualText + "]"
		        );
	}
	
	
}
