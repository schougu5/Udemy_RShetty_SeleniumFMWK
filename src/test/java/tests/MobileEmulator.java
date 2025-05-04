package tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import org.testng.annotations.Test;

public class MobileEmulator {

	@Test
	public void CDPTest() {
	ChromeDriver driver = new ChromeDriver();
	
	DevTools dt = driver.getDevTools();
	
	dt.createSession();
	
//	dt.send(Emulation.setDeviceMetricsOverride(
//			300, 1000,50,true,
//			Optional.empty(), Optional.empty(),
//			Optional.empty(), Optional.empty(),
//			Optional.empty(), Optional.empty(),
//			Optional.empty(), Optional.empty(),
//			Optional.empty(), Optional.empty()));
	
//	Map<String, Object> deviceMetrics = new HashMap<>();
//	deviceMetrics.put("width", 600);
//	deviceMetrics.put("height", 1000);
//	deviceMetrics.put("deviceScaleFactor", 50);
//	deviceMetrics.put("mobile", true);
//
//	driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
//	
//	driver.get("https://rahulshettyacademy.com/angularAppdemo/");
//	
//	driver.manage().window().maximize();
//	
//	
//	
//	driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
//	
	
	
	// Enable location override
    Map<String, Object> coordinates = new HashMap<>();
    coordinates.put("latitude", 40);   // New York City latitude
    coordinates.put("longitude",3); // New York City longitude
    coordinates.put("accuracy", 100);

    // Send CDP command to emulate geolocation
    driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);

    // Open site that shows geolocation
 
    driver.get("https://www.youtube.com/");
    
    //https://www.whatismyip.com/

    // Wait to see result
    try {
        Thread.sleep(5000); // Just to observe result
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
	
	}
	



}
