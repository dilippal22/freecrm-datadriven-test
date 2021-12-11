package com.dgsl.freecrm.analyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class TestTransformer implements IAnnotationTransformer {

	public void transform(ITestAnnotation testAnnotation, Class testClass, Constructor testConstructor2,
			Method testMethod) {
		testAnnotation.setRetryAnalyzer(RetryAnalyzer.class);

	}

}
