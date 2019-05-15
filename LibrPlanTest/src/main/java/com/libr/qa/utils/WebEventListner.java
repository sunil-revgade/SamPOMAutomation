package com.libr.qa.utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.libr.qa.base.TestBase;

public class WebEventListner extends TestBase implements WebDriverEventListener {

	public void beforeAlertAccept(WebDriver driver) {
		
		System.out.println("Before Alert Accept: " +driver);
	} 

	public void afterAlertAccept(WebDriver driver) {
		System.out.println("After Alert Accepted: "+driver );
	}

	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("After Alert Dismiss: "+driver);
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("Before Alert Dismiss: "+driver);
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before Navigate to:" +url+ " "+driver);
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("After Navigate to:" +url+ " "+driver);
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Before Navigate Back: " +driver);
		
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("After Navigate to:" +driver);
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Before Navigate forward:" +driver);
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("After Navigate forward:" +driver);		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("Before Navigate refresh: "+driver);		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("After Navigate Refresh: " +driver);		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Before FindBy: " +by+ "WebElement: "+element+ "Driver: "+driver);	
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("After FindBy: " +by+ "WebElement: "+element+ "Driver: "+driver);			
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Before Click On WebElement: "+element+ "Driver: "+driver);	
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("After Click On WebElement: "+element+ "Driver: "+driver);	
			
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Before Change Value of: "+element+ "Driver: "+driver+" and Character Seq is: "+keysToSend);	
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("After Change Value of: "+element+ "Driver: "+driver+" and Character Seq is: "+keysToSend);	
		
	}

	public void beforeScript(String script, WebDriver driver) {
		System.out.println("Before Script: "+script+ " Driver: "+driver);	
		
	}

	public void afterScript(String script, WebDriver driver) {
		System.out.println("After Script: "+script+ " Driver: "+driver);			
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("Before Switch to Window: "+windowName+ " Driver: "+driver);	
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("After Switch to Window: "+windowName+ " Driver: "+driver);	
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println("Exception occured "+throwable+" Driver: "+driver);	
		try
		{
			TestUtils.takeScreenshotAtEndOfTest();
		}
		catch(IOException r)
		{
			r.printStackTrace();
		}
	}

}
