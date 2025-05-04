package tests;

import java.net.URI;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.Event;
import org.openqa.selenium.devtools.v134.network.Network;
import org.openqa.selenium.devtools.v134.network.model.Headers;
import org.openqa.selenium.devtools.v134.network.model.RequestPattern;
import org.testng.annotations.Test;

public class BasicAuthInterceptorExample {
	

	@Test
	public void BasicAuthInterceptor() {
	
		ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);

        Predicate<URI> uripredi = uri -> uri.getHost().contains("httpbin.org");
        
        driver.register(uripredi,UsernameAndPassword.of("foo","bar"));
        driver.get("http://httpbin.org/basic-auth/foo/bar");
        
	}

}
