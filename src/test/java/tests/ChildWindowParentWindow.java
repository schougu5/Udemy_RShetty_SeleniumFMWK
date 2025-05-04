package tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import testComponents.BaseTest;

public class ChildWindowParentWindow extends BaseTest {

	
	@Test
	public void ChildParentWindowHandling() {
		
		
		driver.get("https://the-internet.herokuapp.com/");
		
		 String parentHandle = driver.getWindowHandle();
	     System.out.println("Parent window handle: " + parentHandle);
	        
	        
		driver.findElement(By.cssSelector("a[href='/windows']")).click();
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
		
		
		Set<String> allHandles = driver.getWindowHandles();
        System.out.println("All handles: " + allHandles);

        // 4) Iterate through handles to find the child
        Iterator<String> it = allHandles.iterator();
        while (it.hasNext()) {
            String handle = it.next();
            if (!handle.equals(parentHandle)) {
                // 5) Switch to the child window
                driver.switchTo().window(handle);
                System.out.println("Switched to child window: " + handle);
             //   System.out.println("Child page title: " + driver.getTitle());
                
                // 6) Do whatever you need in the child…
                String childText = driver.findElement(By.tagName("h3")).getText();
                System.out.println("Child page H3 text: " + childText);

                             
            }
        }

        // 8) Switch back to the parent window
        driver.switchTo().window(parentHandle);
        //System.out.println("Back to parent, title: " + driver.getTitle());
        String ParentText = driver.findElement(By.tagName("h3")).getText();
        System.out.println("Parent page H3 text: " + ParentText);
		
		
		
		
		
	}
}
