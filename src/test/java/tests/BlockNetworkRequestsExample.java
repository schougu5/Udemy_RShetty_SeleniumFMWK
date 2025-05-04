package tests;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v134.network.Network;
import org.testng.annotations.Test;

public class BlockNetworkRequestsExample {
	
	
	@Test
	public void BlockNetworkRequestsExample(){
		
		ChromeDriver driver = new ChromeDriver();

        // Start DevTools session
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        // Enable the Network domain
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Block specific URL patterns
        devTools.send(Network.setBlockedURLs(List.of(
            "*.png",       // block all PNG images
            "*.jpg",       // block all JPG images
            "*.gif",       // block GIFs
            "*googletagmanager.com*",  // Google Tag Manager
            "*google-analytics.com*",  // Google Analytics
            "*fonts.googleapis.com*",  // Google Fonts
            "*doubleclick.net*"        // Ad servers
        )));

        // Open the target website (e.g., a news site with ads/images/fonts)
        driver.get("https://www.cnn.com");

        // Do your test actions here...

        // Close browser
        driver.quit();
		
		
	}

}
