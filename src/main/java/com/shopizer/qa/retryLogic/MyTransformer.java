package com.shopizer.qa.retryLogic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import org.testng.util.RetryAnalyzerCount;

public class MyTransformer implements IAnnotationTransformer{
	
	public void tranform(ITestAnnotation annotation, Class testClass,Constructor testConstructor,Method testMethod)
	{
		annotation.setRetryAnalyzer(RetryAnalyzerCount.class);
	}

}
