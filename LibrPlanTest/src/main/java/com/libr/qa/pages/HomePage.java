package com.libr.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.libr.qa.base.TestBase;
import com.libr.qa.utils.TestUtils;

public class HomePage extends TestBase{
	
	

	@FindBy(xpath="//td[contains(text(),'user: admin')]")
	WebElement loginUserOnHomePage;
	
	@FindBy(xpath="//a[contains(text(), 'Workers')]")
	WebElement resourceWorkerPageLink;

	@FindBy(xpath="//a[contains(text(), 'Machines')]")
	WebElement resourceMachinePageLink;
	
	@FindBy(xpath="//button[contains(text(),'Resources')]")
	WebElement resourcersLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String homePageTitle()
	{
		return driver.getTitle();
	}
	
	public String loginUserOnHomePage()
	{
		return loginUserOnHomePage.getText();
	}
	
	public ResourcesWorkers clickOnResourceWorkersPage() throws InterruptedException
	{
		TestUtils.mouseHover(resourcersLink);
		resourcersLink.click();
		Thread.sleep(5000);
		resourceWorkerPageLink.click();
		return new ResourcesWorkers();
	}
	
	public ResourcesMachines clickOnResourcesMachinesLink() throws InterruptedException
	{
		TestUtils.mouseHover(resourcersLink);
		resourcersLink.click();
		Thread.sleep(5000);
		resourceMachinePageLink.click();
		return new ResourcesMachines();
	}
}
