package com.kwixee.extentreports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.lang3.tuple.Triple;

public class ExtentTestManager {
	
	private static ThreadLocal<ExtentTest>  extentTest=new ThreadLocal<ExtentTest>();
	private static ExtentReports extent = ExtentManager.getInstance();


	public synchronized static ExtentTest getTest() {
		return  extentTest.get();
	}


	public synchronized static ExtentTest createTest(String name, String description, String category) {

		ExtentTest test = extent.createTest(name, description);
		if (category != null && !category.isEmpty())
			test.assignCategory(category);
		extentTest.set(test);
		return getTest();
	}

	public synchronized static ExtentTest createTest(String name) {
		return createTest(name, null);
	}

	public synchronized static ExtentTest createTest(String name, String category) {
		ExtentTest test = extent.createTest(name,null);
		if (category != null && !category.isEmpty())
			test.assignCategory(category);
		extentTest.set(test);
		return getTest();
	}

	public synchronized static ExtentTest setAuthorInfo(Triple authorInfo ){
		ExtentTestManager.getTest().assignAuthor(authorInfo.getMiddle().toString());
		return getTest();
	}



	public synchronized static ExtentTest childNode(String result) {
		ExtentTest child=ExtentTestManager.getTest().createNode(result);
		extentTest.set(child);
		return getTest();
	}
	public synchronized static void log(Status s1,String message) {
		getTest().log(s1,message);
	}


	public synchronized static void logWithScreenShot(String path) {
		try {
			getTest().addScreenCaptureFromPath(path,"title");
		}
		catch (Exception e){
			e.printStackTrace();
		}

	}
	public synchronized static void logWithScreenShot(Status s1,String message,String path) {
		try {
			getTest().log(s1, message).addScreenCaptureFromPath(path,"title");
		}
		catch (Exception e){
			e.printStackTrace();
		}

	}


}
