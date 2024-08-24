package com.framework.listeners;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.framework.base.BasePage;
import com.framework.commons.WebCommons;
import com.framework.reports.Reports;


public class TestListeners extends Reports implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		String TestCaseName = result.getMethod().getMethodName();
		StartReporting(TestCaseName);
		Logger.info("Test Excution Started for the test case ==>"+TestCaseName);
	    
	  }
	
	public void onTestSuccess(ITestResult result) {
		String TestCaseName = result.getMethod().getMethodName();
		Logger.pass("Test Excution is successfully completed and result printed for the test case ==>"+TestCaseName);
		StopReporting();
		  }
	
	public void onTestFailure(ITestResult result) {
		String TestCaseName = result.getMethod().getMethodName();
		Logger.fail("Test Excution is failed for the test case ==>"+TestCaseName);
		Logger.fail("Test Excution is failed due to ==>"+result.getThrowable().getMessage());
		try {
			Logger.addScreenCaptureFromPath(WebCommons.takeScreenshotOfWindow(new BasePage().getDriver(), TestCaseName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		StopReporting();
		  }
	public void onTestSkipped(ITestResult result) {
		String TestCaseName = result.getMethod().getMethodName();
		Logger.warning("Test Excution is Skipped for the test case ==>"+TestCaseName);
		Logger.warning("Test Excution is Skipped due to ==>"+result.getThrowable().getMessage());
		Logger.warning("Take Screenshot...........");
		StopReporting();
		  }

}
