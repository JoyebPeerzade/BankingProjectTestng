package com.application.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.commons.WebCommons;

public class RegistrationPageElements extends WebCommons{
	
	protected By registrationPageHeader = By.xpath("//h1[text()='Signing up is easy!']");

	
	@FindBy(xpath="//h1[@class='title']")
	protected WebElement title;
	
	public By regTitleLocator = By.xpath("//h1[@class='title']");
	
	@FindBy(xpath="//input[@id='customer.firstName']")
	protected WebElement firstName;
	
	@FindBy(xpath="//input[@id='customer.lastName']")
	protected WebElement lastName;
	
	@FindBy(xpath="//input[@id='customer.address.street']")
	protected WebElement address;
	
	@FindBy(xpath="//input[@id='customer.address.city']")
	protected WebElement city;
	
	@FindBy(xpath="//input[@id='customer.address.state']")
	protected WebElement state;
	
	@FindBy(xpath="//input[@id='customer.address.zipCode']")
	protected WebElement ZipCode;
	
	@FindBy(xpath="//input[@id='customer.phoneNumber']")
	protected WebElement phoneNumber;
	
	@FindBy(xpath="//input[@id='customer.ssn']")
	protected WebElement SSN;
	
	@FindBy(xpath="//input[@id='customer.username']")
	protected WebElement username;
	
	@FindBy(xpath="//input[@id='customer.password']")
	protected WebElement password;
	
	@FindBy(xpath="//input[@id='repeatedPassword']")
	protected WebElement ConfirmPassword;
	
	@FindBy(xpath="//input[@value='Register']")
	protected WebElement registerButton;
	
	@FindBy(xpath="//span[class='error']")
	public List<WebElement> errors;
	
	public By registrationSuccess = By.xpath("//h1[@class='title' and contains(text)");
}
