package com.libr.qa.tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.libr.qa.base.TestBase;
import com.libr.qa.pages.HomePage;
import com.libr.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage login;
	HomePage home;
	
	
	 public LoginPageTest() 
	{
		super();
	}
	 
	@BeforeMethod
	public void setUp()
	{
		initialise();
		login = new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest()
	{
		String title = login.loginPageTitle();
		Assert.assertEquals(title, "LibrePlan: User access");
	}
	
	@Test(priority=2)
	public void LoginPageLogoTest()
	{
		boolean logo = login.loginPageValidateImg();
		Assert.assertTrue(logo);
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		home = login.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
