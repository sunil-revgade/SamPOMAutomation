package com.libr.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.libr.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	
	//Page factory or Object Repository
	
	@FindBy(xpath="//input[@name='j_username']")
	WebElement username;
	
	@FindBy(how=How.XPATH,using = "//input[@name='j_password']")
	WebElement password;
	
	@FindBy(how=How.XPATH,using = "//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(how=How.XPATH,using = "//img[@src='/libreplan/common/img/logo_login.png']")
	WebElement librPlanImg;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String loginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean loginPageValidateImg()
	{
		return librPlanImg.isDisplayed();
	}
	
	public HomePage login(String user, String pass)
	{
		username.clear();
		username.sendKeys(user);
		password.clear();
		password.sendKeys(pass);
		loginBtn.click();
		
		return new HomePage();
		
	}
	
	
	
	
	
	
}
