package com.framework.commons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.base.BasePage;
import com.framework.reports.Reports;
import com.framework.utilities.ReadProperties;

public class WebCommons {
	// WebCommons will have all the common  methods to perform different actions on Web Applications
	
	
	public WebDriver driver = new BasePage().getDriver();
	public Properties prop = ReadProperties.readData(System.getProperty("user.dir")+"\\Config\\Config.Properties");
	
	// Method to launch the Application
	
	public void launchApplication (String url) {
		driver.get(url);
		
	}
	//Method to scroll Down to element 
	public void ScrollToElement(WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", element);
	}
	
	//Method to click on element 
	public void click (WebElement element) {
		ScrollToElement(element);
		element.click();
	}
	
	//Method to type text into text element 
	public void enterInfo (WebElement element,String value) {
			ScrollToElement(element);
			element.clear();
			element.sendKeys(value);
	}
	//Method to select the check box
	public void selectCheckbox (WebElement element) {
			ScrollToElement(element);
			if(!element.isSelected())
			element.click();
		}
	//Method to select the check box
	public void selectCheckbox (WebElement element,String method,String option) {
			Select s = new Select(element);
			if(method.equalsIgnoreCase("visibleText"))
				s.selectByVisibleText(option);
			else if(method.equalsIgnoreCase("value"))
				s.selectByValue(option);
			else if(method.equalsIgnoreCase("Index"))
				s.selectByIndex(Integer.parseInt(option));
		}
	
	// Method to Wait [Java Wait] 
	public void wait(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	// Implicit wait
	public void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	// explicit wait
	public void waitForElement(By locator, int sec) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
		}
	// Take ScreenShot of element and get the ScreenShot Path 
	public static String takeScreenshotOfElement(WebElement element, String name) throws IOException {
		String filepath=System.getProperty("user.dir")+"\\ScreenShots\\"+name+".png";
		File scrFile = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(filepath));
		return filepath;
	}
	// Take ScreenShot of window and get the ScreenShot Path
	public static String  takeScreenshotOfWindow(WebDriver driver, String name) throws IOException {
		String filepath=System.getProperty("user.dir")+"\\ScreenShots\\"+name+".png";
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(filepath));
		return filepath;
	}
	//Get element text
	public String getElementText(WebElement element) {
		 return element.getText();
		
	}
	//Get Title of the Window
		public String getTitle() {
			 return driver.getTitle();
		}
		
		//to print message in the report 
		public void  log(String status, String message) {
			if(status.equalsIgnoreCase("info"))
				Reports.Logger.info(message);
			else if(status.equalsIgnoreCase("pass"))
				Reports.Logger.pass(message);
			else if(status.equalsIgnoreCase("fail"))
				Reports.Logger.fail(message);
			else if(status.equalsIgnoreCase("warning"))
				Reports.Logger.warning(message);
		}
		
		//check element is displyed
		public boolean isElementDisplayed(WebElement element) {
			 return element.isDisplayed();
		}
			
}
