package tests;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v134.network.Network;
import org.openqa.selenium.devtools.v134.network.model.ConnectionType;
import org.testng.annotations.Test;

public class EmulateNetworkSpeedExample {
	
	
	@Test
	public void EmulateNetworkSpeed(){
		
		ChromeOptions options = new ChromeOptions();
		 ChromeDriver driver = new ChromeDriver(options);

	        // Start DevTools session
	        DevTools devTools = driver.getDevTools();
	        devTools.createSession();

	        // Enable Network domain
	        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

	        // Emulate Slow 3G Network
	        devTools.send(Network.emulateNetworkConditions(
	            false, // offline
	            50000,  // latency (ms)
	            100000, // download throughput (bps)
	            100000, // upload throughput (bps)
	            Optional.of(ConnectionType.CELLULAR3G),Optional.empty(), Optional.empty(), Optional.empty()
	        ));

	        // Load a sample page
	        driver.get("https://www.example.com");

	        // Wait to observe the network behavior
	        try {
	            Thread.sleep(10000); // wait for 10 seconds
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Close browser
	        driver.quit();
	}
	
	

}
