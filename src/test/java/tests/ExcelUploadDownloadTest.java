package tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.io.File;

import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testComponents.BaseTest;

public class ExcelUploadDownloadTest extends BaseTest {

	public String downloadPath=System.getProperty("user.dir");
	public String filePath = downloadPath + "\\download.xlsx";
	
	@BeforeClass
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
	
	
	@Test(priority=1)
	public void downloadExcel() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 3000);");  // scrolls down by 1000 pixels
		
		 Thread.sleep(3000); // Wait for download to complete
		driver.findElement(By.xpath("//button[@id='downloadButton']")).click();
        Thread.sleep(3000); // Wait for download to complete
        
 
        
	}
	
	
	@Test(priority = 2)
    public void editExcelFile() throws Exception {
		
		String filePath = downloadPath + "\\download.xlsx";
		System.out.println("File path being used: " + filePath);

		FileInputStream fis = new FileInputStream(filePath);
  
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
       
        for (Row row : sheet) {
            Cell fruitNameCell = row.getCell(1);
            if (fruitNameCell != null && fruitNameCell.getStringCellValue().equalsIgnoreCase("Orange")) {
                Cell priceCell = row.getCell(3); // Price column
                priceCell.setCellValue(999); // Update price to 999
                break;
            }
        }

        fis.close();
        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        workbook.close();
        fos.close();
    }

	@Test(priority = 3)
    public void uploadExcelFile() {
        WebElement uploadInput = driver.findElement(By.id("fileinput"));
        uploadInput.sendKeys(filePath);
    }
	
	 @Test(priority = 4)
	    public void verifyUpdatedValue() throws InterruptedException {
	        Thread.sleep(10000); // Allow webpage to refresh with uploaded data

	        WebElement updatedCell = driver.findElement(By.xpath("(//div[@role='row'][.//div[text()='Orange']])[2]/div[@role='cell'][4]"));
	        String updatedPrice = updatedCell.getText();
	        Assert.assertEquals(updatedPrice, "999");
	    }
}
