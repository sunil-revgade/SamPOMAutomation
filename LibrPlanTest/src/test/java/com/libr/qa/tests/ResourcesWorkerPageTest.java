package com.libr.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.libr.qa.base.TestBase;
import com.libr.qa.pages.HomePage;
import com.libr.qa.pages.LoginPage;
import com.libr.qa.pages.ResourcesWorkers;
import com.libr.qa.utils.TestUtils;

public class ResourcesWorkerPageTest extends TestBase{
	
	LoginPage login;
	HomePage home;
	ResourcesWorkers worker;
	String sheetName = "Worker";
	
	public ResourcesWorkerPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialise();
		login = new LoginPage();
		home=login.login(prop.getProperty("username"), prop.getProperty("password"));
		worker=home.clickOnResourceWorkersPage();
	}
	
	@Test(priority=1,enabled=false)
	public void verifyReourcesWorkerTitle() throws InterruptedException
	{
		Thread.sleep(5000);
		String title = worker.verifyLabelResourcesWorkerListPage();
		Assert.assertEquals(title, "Workers List");
	}
	
	@Test(priority=2,enabled=false)
	public void verifyForFilterBy()
	{
		worker.clickOnFilterBy(prop.getProperty("WorkerSearch"));
		worker.clickOnFilterBtn();
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		Object[][] data = TestUtils.getTetData(sheetName);
		return data;
	}
	
	@Test(priority=3,enabled=true,dataProvider = "getTestData")
	public void verifyCreateWorkerTest(String first, String last) throws InterruptedException
	{
		System.out.println("first :"+first+"Last "+last);
	  worker.createWorkerDetails(first, last);	
	}
	
	@AfterMethod
	public void teatDown()
	{
		driver.quit();
	}


}
