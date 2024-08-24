package com.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.application.elements.RegistrationPageElements;

public class RegistrationPageSteps extends RegistrationPageElements{
	
	public RegistrationPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
}
	
	public void verifyRegistrationpageIsLaunched() {
		waitForElement(registrationPageHeader, 10);
		log("info","Registration page is launched");	
	}
	public void updateRegistrationDetails(String user, String pass) {
		enterInfo(firstName, "Joyeb");
		enterInfo(lastName, "Peerzade");
		enterInfo(address, "Station Road Akkalkot Dist-Solapur");
		enterInfo(city, "Solapur");
		enterInfo(state, "Maharashtra");
		enterInfo(ZipCode, "413216");
		enterInfo(phoneNumber, "8055511720");
		enterInfo(SSN, "123456789");
		enterInfo(username, "user");
		enterInfo(password, "pass");
		enterInfo(ConfirmPassword, "pass");
		
	}
	public void clickOnRegisterButton() {
		click(registerButton);
		log("info","Clicked on Register button");
	}
	
	public void verifyRegistrationIsSuccessful() {
		waitForElement(registrationSuccess, 10);
		log("info","Registration is Successful");
	
}
}