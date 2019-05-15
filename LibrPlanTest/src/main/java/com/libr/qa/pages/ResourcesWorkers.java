package com.libr.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.libr.qa.base.TestBase;

public class ResourcesWorkers extends TestBase {
	
	
		@FindBy(xpath="//div[contains(text(),'Workers List')]")
		WebElement workerListPageVerify;
		
		@FindBy(xpath="//a[@id='nN4Qt-a'][contains(text(), 'Workers')]")
		WebElement workersLink;
		
		@FindBy(xpath="//input[@class='z-bandbox-inp'][1]")
		WebElement filterBy;
		
		
		@FindBy(xpath="//i[@class='z-bandbox-btn'][1]")
		WebElement filterBtn;
		
		@FindBy(xpath="//td[contains(text(),'Create')]")
		WebElement createBtn;
		
		
		@FindBy(xpath="//span[contains(text(),'First name')]")
		WebElement firstName;
		
		
		@FindBy(xpath="//input[@id='tEgEi6']")
		WebElement lastName;
		
		
		@FindBy(xpath="//*[@id='pQWVlf-box']/tbody/tr[2]/td[2]")
		WebElement saveBtn;
		
		
		
		
		public ResourcesWorkers()
		{
			PageFactory.initElements(driver, this);
		}
		
		public String verifyLabelResourcesWorkerListPage()
		{
			return workerListPageVerify.getText();
		}
		
		public void clickOnFilterBy(String search)
		{
			
			filterBy.sendKeys(search);
		}
		public void clickOnFilterBtn()
		{
			filterBtn.click();
		}
		
		public void createWorkerDetails(String firstname, String lastname) throws InterruptedException
		{
			createBtn.click();
			Thread.sleep(5000);
			//firstName.click();
			System.out.println("Clicked in Firstname " +firstname);
			//firstName.sendKeys(firstname);
			
			//lastName.click();
			System.out.println("Clicked in Lastnaem "+lastname);
			//lastName.sendKeys(lastname);
			//saveBtn.click();
		}
		
}
