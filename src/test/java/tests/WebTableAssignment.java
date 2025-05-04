package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import testComponents.BaseTest;

public class WebTableAssignment extends BaseTest {
	
	@Test
	public void WebTableProcessing() {
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		
		WebElement table = driver.findElement(By.id("product"));
		
		List<WebElement> Allrows = table.findElements(By.tagName("tr"));
		
		int rowcount = Allrows.size();
		
		List<WebElement> Allcolumns = table.findElements(By.tagName("th"));
		int colcount = Allcolumns.size();
		
		System.out.println("TotalRowsCount is " + rowcount);
		System.out.println("TotalColumnCount is " + colcount);
		
		 List<WebElement> secondRowCells = Allrows.get(2).findElements(By.tagName("td"));

         // Print data from each cell in the second row
         System.out.println("Data in second row:");
         for (WebElement cell : secondRowCells) {
             System.out.println(cell.getText());
         }
		
		
		
	}

}
