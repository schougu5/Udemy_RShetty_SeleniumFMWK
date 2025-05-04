package tests;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v134.network.Network;
import org.openqa.selenium.devtools.v134.network.model.Response;
import org.testng.annotations.Test;

public class NetworkTest {
	
	
	@Test
	public void NetworkListenerExample() {
		
		
       ChromeDriver driver = new ChromeDriver();

        // Initialize DevTools and connect to Chrome DevTools Protocol
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        // Enable the Network domain to capture network traffic
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Add a listener to capture the response
        devTools.addListener(Network.responseReceived(), responseReceived -> {
            Response response = responseReceived.getResponse();
            int statusCode = response.getStatus();
            String url = response.getUrl();

            System.out.println("URL: " + url + " | Status Code: " + statusCode);
        });

        // Navigate to a URL
        driver.get("https://www.google.com");

//        // Perform any actions on the page if needed
//        driver.findElement(By.xpath("//a")).click();

        // Close the browser
   //     driver.quit();
		
	}

}
