package tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import testComponents.BaseTest;

public class fileUploadAutoIT extends BaseTest {
	
	@Test
	public void hitUploadButtonThenUpload() throws InterruptedException, IOException {
		
		String downloadPath=System.getProperty("user.dir");

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
		
		
		
		
		
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("pickfiles")).click();
		
		Thread.sleep(15000);
	//This .exe file needs admin permission
	//	Runtime.getRuntime().exec("C:\\Users\\User\\Downloads\\fileuploadScriptusingAutoit.exe");
		
		driver.findElement(By.xpath("//span[@id='processTaskTextBtn']")).click();
		
		Thread.sleep(15000);
		
		File f=new File(downloadPath+"/ilovepdf_pages-to-jpg.zip");
		
		System.out.println("File path: " + f.getAbsolutePath());

		if(f.exists())

		{
			System.out.println("file exist");
			Assert.assertTrue(f.exists());

			if(f.delete()) {

				System.out.println("file deleted");
			}

		}
		
		else {
			
			System.out.println("file DOES NOT exist");
			
		}
		
		
	}
	

}
