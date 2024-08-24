package com.application.tests;

import org.testng.annotations.Test;

import com.framework.base.BaseTest;

public class ApplicationTest extends BaseTest {
	
	@Test(priority=1)
	public void VerifyWhetherApplicationIsLaunched() {
		loginpage.launchApplication();
	}
	
	@Test(priority=2)
	public void VerifyLogoAndCaption() {
		loginpage.launchApplication();
		loginpage.verifyLogoAndCaption();
	}
	
	@Test(priority=3)
	public void VerifyLoginPageHeader() {
		loginpage.launchApplication();
		loginpage.verifyLoginHeader();
	}
	@Test(priority=4,dataProvider="data")
	public void VerifyRegistrationFeature(String username,String password) {
		loginpage.launchApplication();
		loginpage.clickOnRegistrationLink();
		regpage.verifyRegistrationIsSuccessful();
		regpage.updateRegistrationDetails(username, password);
		regpage.clickOnRegisterButton();
		regpage.verifyRegistrationIsSuccessful();
	}
	@Test(priority=5,dataProvider="data")
	public void VerifyLoginFeature(String username,String password) {
		loginpage.launchApplication();
		loginpage.enterCredentials(username, password);
		loginpage.clickOnLogInButton();
		loginpage.verifyLoginIsSuccessful();
		
	}
}
