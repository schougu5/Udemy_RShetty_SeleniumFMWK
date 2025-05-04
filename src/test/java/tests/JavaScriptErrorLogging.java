package tests;



import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v134.log.Log;
import org.openqa.selenium.devtools.v134.log.model.LogEntry;

import org.testng.annotations.Test;

public class JavaScriptErrorLogging {

	@Test
	public void JavaScriptErrorlog(){
		
	    // 1) Launch ChromeDriver (no special logging prefs needed)
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);

        // 2) Create a DevTools session
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        // 3) Enable the CDP Log domain
        devTools.send(Log.enable());

        // 4) Listen for any log entry added by the browser
        devTools.addListener(Log.entryAdded(), (LogEntry entry) -> {
            // entry.getLevel() might be "verbose", "info", "warning", "error"
        	
        	 if (entry.getLevel() == LogEntry.Level.ERROR) {
                 System.out.println(" JS Error: " + entry.getText());
                 System.out.println(" Source: " + entry.getSource() +
                                    ", URL: " + entry.getUrl() +
                                    ", Line: " + entry.getLineNumber());
             }
        
        });

        // 5) Navigate to a page with a known JS error
        driver.get("https://the-internet.herokuapp.com/javascript_error");

        // Give it a moment to fire the error
        try { Thread.sleep(3000); } catch (InterruptedException ignored) {}

        driver.quit();
		
	}
	
	
	
}
