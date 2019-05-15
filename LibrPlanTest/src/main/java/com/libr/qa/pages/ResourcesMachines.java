package com.libr.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.libr.qa.base.TestBase;

public class ResourcesMachines extends TestBase {
	
	
	@FindBy(xpath="//div[contains(text(), 'Machines List')]")
	WebElement machinesListPageText;
	
	public ResourcesMachines()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageText()
	{
		return machinesListPageText.getText();
	}
	
	
}
