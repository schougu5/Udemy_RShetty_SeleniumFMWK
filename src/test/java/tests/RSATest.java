package tests;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import testComponents.BaseTest;

public class RSATest extends BaseTest {

	@Test
	public void HomePageRSA() throws MalformedURLException, URISyntaxException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(CapabilityType.BROWSER_NAME,"firefox");
		
		
		driver= new RemoteWebDriver(new URI("http://192.168.46.44:4444").toURL(), caps);
		
		driver.get("https://www.cognizant.com/in/en");
		System.out.println(driver.getTitle());
		
	}
}
