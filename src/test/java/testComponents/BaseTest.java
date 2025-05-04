package testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import abstractComponents.AbstractComponent;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import pageObjects.LandingPage;

public class BaseTest {

	public WebDriver driver = null;
	public LandingPage lp;

	public String downloadPath=System.getProperty("user.dir");
	public String filePath = downloadPath + "\\download.xlsx";
	
	public String productName = "ZARA COAT 3";
	
	
	  static {
	      // adjust the path if your properties file lives elsewhere
	      PropertyConfigurator.configure("src/main/java/resources/log4j.properties");
	    }
	    // ...
	
	 
	  public void setupPath() throws InterruptedException {
			
			

			System.out.println("Here is the downloadpath value" + downloadPath);

			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

			chromePrefs.put("profile.default_content_settings.popups", 0);

			chromePrefs.put("download.default_directory", downloadPath);
			chromePrefs.put("download.prompt_for_download", false);
			chromePrefs.put("download.directory_upgrade", true);
			chromePrefs.put("safebrowsing.enabled", true);

			ChromeOptions options=new ChromeOptions();

			options.setExperimentalOption("prefs", chromePrefs);

			driver = new ChromeDriver(options);
			
			
			
			
			
			driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
			driver.manage().window().maximize();
			
			System.out.println("Browser is maximised....");
			
			
	 
	        
		}
	  
	  
	public WebDriver InitializeDriver() throws IOException {
		
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\GlobalData.properties");
		prop.load(fis);
		
		// Maven command is passing the browser name : mvn test -Dbrowser=Firefox. Its written in single line. 
		//Java tarnary operator. 
		//Else condition is about prop.*
		String browerName = System.getProperty("browser") !=null ? System.getProperty("browser") : prop.getProperty("browser");
		
		
		//String browerName= prop.getProperty("browser");
		
		if(browerName.contains("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			
			if(browerName.contains("headless"))
			{
				options.addArguments("headless");
			}
			
			
		 driver = new ChromeDriver(options);
		
	//	driver.get("https://rahulshettyacademy.com/client/");
		
		driver.manage().window().setSize(new Dimension(1440,900));
		
		
		}
		else if(browerName.equalsIgnoreCase("Firefox"))
		{
			 driver = new FirefoxDriver();
		}
		else if(browerName.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		return driver;
		}
	
	
	
	
	public String getScreenshot(String TestCaseName, WebDriver driver) throws IOException {
		
		
		// driver will go into photoTaking mode - Source , destination collected - Copied the file - Return the path where it is stored.
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destfile= new File(System.getProperty("user.dir") + "//screenshots//" + TestCaseName + ".png");
		FileUtils.copyFile(source, destfile);
		return System.getProperty("user.dir") + "//screenshots//" + TestCaseName + ".png";
	}
	
	
	
	
	public List<HashMap<String, String>> getjsonDatatoMap(String filepath) throws IOException {
		
		
		//jackson-databind Maven Dependency is required to support FileUtils
		
		//Read the json to string
		
		String jsonContent = FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
		
		//
		ObjectMapper mapper = new ObjectMapper();
		
		
		//json to String and then string to HashMap..This is the flow...
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
		
		
	}

	//@BeforeMethod()
	public LandingPage launchApplication() throws IOException { // Launch browser...
		System.out.println("Testing first before method");
		driver=InitializeDriver();
		
		lp = new LandingPage(driver); // Passing driver to landing page for next operations...Made LandingPage public so that it can be accessible publically...
		lp.goToHomePage();
		
		return lp;
	}

	@BeforeMethod()
	public void BrowserLaunch() throws IOException { // Launch browser...
		System.out.println("BrowserLaunch method started...");
		driver=InitializeDriver();

	}


	public void printmessage() throws IOException {
		
		System.out.println("Testing another before method");
	}
	
	@AfterMethod(alwaysRun=true)
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
	//	driver.quit();
		Thread.sleep(5000);
		
		
	}
	
	
}
