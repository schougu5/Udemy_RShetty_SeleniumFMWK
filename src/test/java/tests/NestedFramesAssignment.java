package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import testComponents.BaseTest;

public class NestedFramesAssignment extends BaseTest {

	@Test
	public void NestedFrames() {
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.cssSelector("a[href='/nested_frames']")).click();
		
		
		 driver.switchTo().frame("frame-top");

	        // 2) Now switch into the middle frame by its name
	        driver.switchTo().frame("frame-middle");

	        // 3) Grab the text from the div#content
	        String middleText = driver.findElement(By.id("content")).getText();
	        System.out.println("Middle frame text = " + middleText);
		
	}
}
