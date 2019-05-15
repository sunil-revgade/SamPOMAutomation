package com.libr.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.libr.qa.base.TestBase;
import com.libr.qa.pages.HomePage;
import com.libr.qa.pages.LoginPage;
import com.libr.qa.pages.ResourcesWorkers;

public class HomePageTest extends TestBase{
	
	LoginPage login;
	HomePage home;
	ResourcesWorkers worker;
	
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialise();
		login = new LoginPage();
		home=login.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1,enabled=false)
	public void homePageTitleTest()
	{
		String title = home.homePageTitle();
		Assert.assertEquals(title, "LibrePlan: Planning");
	}
	
	@Test(priority=2,enabled=false)
	public void validateHomePageAfterLogin()
	{
		String loginUser = home.loginUserOnHomePage();
		Assert.assertEquals(loginUser, "user: admin");
	}
	
	@Test(priority=3)
	public void resouceWorkerPageTest() throws InterruptedException
	{
		worker = home.clickOnResourceWorkersPage();
	}
	
	
	@AfterMethod
	public void teatDown()
	{
		driver.quit();
	}
}
