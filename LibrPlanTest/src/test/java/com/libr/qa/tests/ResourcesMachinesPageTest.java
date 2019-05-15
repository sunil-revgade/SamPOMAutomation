package com.libr.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.libr.qa.base.TestBase;
import com.libr.qa.pages.HomePage;
import com.libr.qa.pages.LoginPage;
import com.libr.qa.pages.ResourcesMachines;

public class ResourcesMachinesPageTest extends TestBase{
	
	
	LoginPage login;
	HomePage home;
	ResourcesMachines machine;
	
	public ResourcesMachinesPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialise();
		login = new LoginPage();
		home=login.login(prop.getProperty("username"), prop.getProperty("password"));
		machine=home.clickOnResourcesMachinesLink();
	}
	
	@Test(priority=1,enabled=true)
	public void verifyReourcesWorkerTitle() throws InterruptedException
	{
		String title = machine.verifyPageText();
		Assert.assertEquals(title, "Machines List");
	}
	
}
