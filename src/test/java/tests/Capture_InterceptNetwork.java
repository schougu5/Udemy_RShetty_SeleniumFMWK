package tests;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v134.network.Network;
import org.openqa.selenium.devtools.v134.network.model.Request;
import org.openqa.selenium.devtools.v134.network.model.Response;
import org.testng.annotations.Test;

public class Capture_InterceptNetwork {

	
	@Test
	public void Capture_UInterceptNetworkTrafficeExample() {
		
	
	        ChromeDriver driver = new ChromeDriver();

	        // Initialize DevTools and create a session to connect with CDP
	        DevTools devTools = driver.getDevTools();
	        devTools.createSession();

	        // Enable the Network domain to start intercepting network traffic
	        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

	        // Listener to capture network requests
	        devTools.addListener(Network.requestWillBeSent(), requestWillBeSent -> {
	            Request request = requestWillBeSent.getRequest();
	            
	            System.out.println("------------------------------------------------------------");
	            System.out.println("Request URL: " + request.getUrl());
	            System.out.println("Request Method: " + request.getMethod());
	            System.out.println("Request Headers: " + request.getHeaders());
	            // Optionally filter based on URL or request method
	        });

	        // Listener to capture network responses
//	        devTools.addListener(Network.responseReceived(), responseReceived -> {
//	            Response response = responseReceived.getResponse();
//	            int statusCode = response.getStatus();
//	            String url = response.getUrl();
//	            System.out.println("Response URL: " + url);
//	            System.out.println("Response Status Code: " + statusCode);
//	            // Optionally filter based on status code or URL
//	            if (statusCode == 200) {
//	                System.out.println("Successful Response from: " + url);
//	                
//	                System.out.println("************************************************************");
//	            }
//	        });

	        
	        
	        devTools.addListener(Network.responseReceived(), responseReceived -> {
	            Response response = responseReceived.getResponse();
	            int statusCode = response.getStatus();
	            String url = response.getUrl();

	            System.out.println("Response URL: " + url);
	            System.out.println("Response Status Code: " + statusCode);

	            // Check for failed network requests (status codes 4xx and 5xx)
	            if (statusCode >= 400 && statusCode < 600) {
	                System.out.println("Failed request detected!");
	                System.out.println("Failure status code: " + statusCode);
	                
	                // Further actions based on failure codes
	                if (statusCode == 404) {
	                    System.out.println("Page not found (404) for URL: " + url);
	                } else if (statusCode == 500) {
	                    System.out.println("Internal Server Error (500) for URL: " + url);
	                }
	            }
	        });
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        // Navigate to a website that triggers network requests
	    //    driver.get("https://httpstat.us/");
	        
	        driver.get("https://github.com/nonexistent-page-1234567");
	        driver.get("https://httpstat.us/500");


	        // Trigger actions that generate network requests (e.g., clicking a button)
	   //     driver.findElement(By.id("some-element")).click();

	        // Allow time for requests and responses to be intercepted
	        try {
	            Thread.sleep(5000);  // Sleep for 5 seconds to allow interception
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Close the browser
	   //     driver.quit();
		
		
	}
}
