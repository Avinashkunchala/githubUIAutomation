package com.githubAutomation.Listeners;

import org.testng.ITestListener;

import org.testng.ITestResult;

import com.githubAutomation.Base.TestBase;

public class TestNGListeners extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		
		System.out.println(result.getName() + "  execution is started");
		
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test Case  "+ result.getName() + " successfully executed");
		
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("Test Case  "+ result.getName() +" failed");
		
	}

	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test Case  "+ result.getName()+" is skipped");
		
	}
  
}
