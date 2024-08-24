package com.framework.reports;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports {
	//Will have Common methods to generate reports using extent reports 
	
	public static ExtentHtmlReporter html = null; //empty html report (White Paper )
	public static ExtentReports extent = null;    // To set configurations and pass instruction (printer)
	public static ExtentTest Logger = null;		  // to print colorful message in the report (ink)
	
	@BeforeSuite (alwaysRun=true)
	public static void SetupReport() {
		html = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\AutomationTestReport.html"); //creating white paper [creating empty report]
		extent = new ExtentReports();
		extent.attachReporter(html); // inserting into printer 
	}
	public static void StartReporting(String testcase) {
		Logger = extent.createTest(testcase);  // fill up the Ink to start the printing process
		}
	@AfterSuite (alwaysRun=true)
	public static void StopReporting() {
		extent.flush();  //Stop the printing for the testcase 
		}
}
