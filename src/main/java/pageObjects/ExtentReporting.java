package pageObjects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporting {
	
	 static ExtentReports extent;
	public static ExtentReports getExtentReport() {
		
		
		String path =	System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Test Results");
		reporter.config().setDocumentTitle("Tests");
		
		extent	 = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Michael Djamba");
	 // test =  extent.createTest(testname);
		return extent;
		
		
	}

}
