package com.kwixee.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.Status;
import com.dummy.ReportReading;
import com.kwixee.extentreports.ExtentManager;
import com.kwixee.extentreports.ExtentTestManager;
import com.kwixee.util.TestUtil;
import com.threadlocal.instance.BrowserFactory;

public class TestBase{
	
public static String BasicElements=System.getProperty("user.dir")+"\\src\\test\\java\\com\\kwixee\\testdata\\BasicElements.xlsx";


	public Properties pro;
	public static String url;
	public static String xeurl="http://www.xe.com/currencyconverter/";
	public static String payroll;
	public static String addrecord_Url;
	public static String url_Custom_Dashboard;
	public static String addrecordsUserName;

	public static String username;
	public static String password;
	public static String testdataURL;

	public static String username_Custom_Dashboard;
	//public static String password;
	public String SearchUser="dileepkumar.meka@navayugainfotech.com";
	public String roleId="dileep@kwixee.com";

	public WebDriver driver = null;
	TestUtil TestUtil;

	public TestBase()  {
		try {
			pro=new Properties();
			FileInputStream ip  = new FileInputStream(".\\src\\com\\kwixee\\config\\config.properties");
			pro.load(ip);
			username=pro.getProperty("username");
			password=pro.getProperty("password");
			url=pro.getProperty("url");
			payroll=pro.getProperty("payroll");
			testdataURL=pro.getProperty("CreateTestDataInThisEnvironment");
			url_Custom_Dashboard=pro.getProperty("url_Custom_Dashboard");
			username_Custom_Dashboard=pro.getProperty("username_Custom_Dashboard");
			addrecord_Url=pro.getProperty("addrecord_Url");
			addrecordsUserName=pro.getProperty("addrecordsUserName");
			TestUtil=new TestUtil();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	String startTime="";
	String fileName="";


	@BeforeSuite
	public void setExtent() throws InterruptedException{

		fileName=getReportFolderName()+"/ExpleoTask"+TestUtil.appenTime_1()+".html";
		ExtentManager.createInstance(fileName);
		startTime=TestUtil.appenTime_1();
		System.out.println("File path "+fileName);
	}

	@BeforeMethod
	public void setUp() throws InterruptedException, IOException{
		driver=openBrowser();	
		Assert.assertNotNull(driver);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException, InterruptedException{


		if(result.getStatus()==ITestResult.SUCCESS){
			ExtentTestManager.log(Status.PASS, "Test Case PASSED IS " + result.getName());
			//String screenshotPath = TestUtil.getScreenshot(driver, result.getName());
			//ExtentTestManager.logWithScreenShot(screenshotPath);
		}else if(result.getStatus()==ITestResult.FAILURE){

				ExtentTestManager.log(Status.FAIL, "TEST CASE FAILED IS "+result.getName());
				ExtentTestManager.log(Status.FAIL, "TEST CASE FAILED IS "+result.getThrowable());
				String screenshotPath = TestUtil.getScreenshot(driver, result.getName());
				ExtentTestManager.logWithScreenShot(screenshotPath);
			}
			else if(result.getStatus()==ITestResult.SKIP){
				ExtentTestManager.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
				String screenshotPath = TestUtil.getScreenshot(driver, result.getName());
				ExtentTestManager.logWithScreenShot(screenshotPath);

			}
			quitBrowser(driver);
	}

	@AfterSuite
	public void endReport() throws InterruptedException, IOException{
		//System.out.println("After test excuted");
		System.out.println("fileName "+fileName);
		
		ExtentManager.getInstance().flush();
		Thread.sleep(1000);
		ReportReading.ReadDataFromExportFileToExcelSheet(fileName);
	}


	public static String getReportFolderName(){
		String dateName = new SimpleDateFormat("yyyy_MM_dd").format(new Date());
		File dir = new File(System.getProperty("user.dir")+"/Reports_"+dateName);
		if (!dir.exists())
			dir.mkdirs();
		return dir.getAbsolutePath();
	}
	public  WebDriver PayRollopenBrowser(){
		try{
			BrowserFactory browserFactory=BrowserFactory.getInstance();
			browserFactory.setDriver("chrome");
			driver=browserFactory.getDriver();
			driver.manage().window().maximize();
			driver.navigate().to(payroll);
			driver.get(payroll);
			return driver;
		}catch(Exception e){
			return driver;
		}
	}
	public  WebDriver 	addRecordopenBrowser(){
		try{
			BrowserFactory browserFactory=BrowserFactory.getInstance();
			browserFactory.setDriver("chrome");
			driver=browserFactory.getDriver();
			driver.manage().window().maximize();
			driver.navigate().to(addrecord_Url);
			driver.get(addrecord_Url);
			return driver;
		}catch(Exception e){
			return driver;
		}
	}
	public  WebDriver openBrowser(){
		try{
			//	BrowserFactory browserFactory=new BrowserFactory();

			BrowserFactory browserFactory=BrowserFactory.getInstance();
//			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver_105.exe"); 
			browserFactory.setDriver("chrome");
			driver=browserFactory.getDriver();
//			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			

			//driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_TimeOut, TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(TestUtil.Page_implicit_TimeOut, TimeUnit.SECONDS);
			//driver.navigate().to(url);

			//	driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_TimeOut, TimeUnit.SECONDS);
			//	driver.manage().timeouts().implicitlyWait(TestUtil.Page_implicit_TimeOut, TimeUnit.SECONDS);
			//	driver.navigate().to(url);
			driver.get(xeurl);
			return driver;
		}catch(Exception e){
			return driver;
		}

	}

	public  WebDriver openBrowserForCustomAndDashBoardModule(){
		try{
			//	BrowserFactory browserFactory=new BrowserFactory();

			BrowserFactory browserFactory=BrowserFactory.getInstance();

			browserFactory.setDriver("chrome");

			driver=browserFactory.getDriver();

			driver.manage().window().maximize();

			//	driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_TimeOut, TimeUnit.SECONDS);
			//	driver.manage().timeouts().implicitlyWait(TestUtil.Page_implicit_TimeOut, TimeUnit.SECONDS);
			//	driver.navigate().to(url);
			driver.navigate().to(url_Custom_Dashboard);

			driver.get(url_Custom_Dashboard);
			return driver;
		}catch(Exception e){
			return driver;
		}

	}



	public void quitBrowser(WebDriver driver){
		driver.close();
		driver.quit();
	}

}

