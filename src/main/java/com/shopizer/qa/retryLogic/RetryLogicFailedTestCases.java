package com.shopizer.qa.retryLogic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public abstract class RetryLogicFailedTestCases implements IRetryAnalyzer{
	
	int counter=3;
	int retryLimit=0;
	
	public boolean rtry(ITestResult result)
	{
		if(counter<retryLimit)
		{
			counter++;
			return true;
		}
		return false;
		
		
	}

}
