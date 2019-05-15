package com.libr.qa.ExtentReportListener;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExtentReportListner implements IReporter{

	public ExtentReports extent;

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String OutputDir) {

		extent =  new ExtentReports(OutputDir + File.separator +"Extents.html", true); 

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {

				ITestContext context = r.getTestContext();

				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);

			}
		}

		extent.flush();
		extent.close();
	}

	public  void buildTestNodes(IResultMap tests, LogStatus status) {

		ExtentTest test;
		String message;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.startTest(result.getMethod().getMethodName());

				test.getTest().setStartedTime(getTime(result.getStartMillis()));
				test.getTest().setEndedTime(getTime(result.getEndMillis()));

				for (String group : result.getMethod().getGroups())
				{   
					test.assignCategory(group);
				}


				message = "Test " +status.toString().toLowerCase() + "ed";

				if (result.getThrowable() != null)
				{
					message = result.getThrowable().toString();//getMessage();

				}

				test.log(status, message);


				extent.endTest(test);

			}
		}
	}

	private  Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();        
	}



}

