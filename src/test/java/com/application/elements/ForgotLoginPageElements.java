package com.application.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotLoginPageElements {
	
	
	protected By forgotLoginPageHeader = By.xpath("//h1[text()='Customer Lookup']");

	@FindBy(xpath="//h1[@class='title']")
	protected WebElement caption;
	
	@FindBy(xpath="//input[@id='firstName']")
	protected WebElement FirstName;
	
	@FindBy(xpath="//input[@id='lastName']")
	protected WebElement LastName;
	
	@FindBy(xpath="//input[@id='address.street']")
	protected WebElement Address;
	
	@FindBy(xpath="//input[@id='address.city']")
	protected WebElement City;
	
	@FindBy(xpath="//input[@id='address.state']")
	protected WebElement State;
	
	@FindBy(xpath="//input[@id='address.zipCode']")
	protected WebElement ZipCode;
	
	@FindBy(xpath="//input[@id='ssn']")
	protected WebElement SSN;
	
	@FindBy(xpath="//input[@value='Find My Login Info']")
	protected WebElement FindLoginInfoBTN;

}
