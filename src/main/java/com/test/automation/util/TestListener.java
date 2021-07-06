package com.test.automation.util;


import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener, ISuiteListener {
	
			
    public void onFinish(ITestContext arg0) {					
       LoggerUtil.endTestCase(arg0.getName());		
        		
    }		

    		
    public void onStart(ITestContext arg0) {					

    	
        		
    }		

    		
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    		
    public void onTestFailure(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    		
    public void onTestSkipped(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    		
    public void onTestStart(ITestResult arg0) {					
    	LoggerUtil.startTestCase(arg0.getName());	
        		
    }		
    
    public void onTestFinish() {
    	
    }

    		
    public void onTestSuccess(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		
}
