package com.kwixee.extentreports;

//import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	 static ExtentReports extent;
	    
	    public static ExtentReports getInstance() {	
	        return extent;
	    }
	    
	    public static synchronized ExtentReports createInstance(String fileName) {
	    	
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle("Currency Converter");
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(fileName);
	       
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	       // extent.setAnalysisStrategy(AnalysisStrategy.SUITE);
	        //extent.setReportUsesManualConfiguration(true);
			extent.setSystemInfo("Host Name", "Windows 10 ");
			extent.setSystemInfo("User Name", "Srinivas");
			extent.setSystemInfo("Environment", "QA");
			
	       extent.attachReporter(htmlReporter);
	        
	        return extent;
	    }
	   


}


