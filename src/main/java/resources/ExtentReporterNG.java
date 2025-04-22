package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	
	public static ExtentReports getReportObject() { // this is just configuration of Report
		
		String path = System.getProperty("user.dir") + "//Myreports//index.html";
		
		ExtentSparkReporter custReporter_spark = new ExtentSparkReporter(path); // Location provided where report will be kept
		custReporter_spark.config().setReportName("Web Automation Summary");// Report Title Given
		custReporter_spark.config().setDocumentTitle("Sanity-Doc Title"); // Tab title given
		
		
		// ExtentReport does NOT build its own report. It allows the reporter to access the information and which in turn create the report
		ExtentReports extent = new ExtentReports(); //we are using this class to generate the Report and passing the parameters to it using the object extent.
		extent.attachReporter(custReporter_spark); // Pulling the above configuration of Spark
		extent.setSystemInfo("Tester","Snehal Chougule"); // setting the meta data : System data
		
		return extent;
		
	}

}
