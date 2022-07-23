package com.kwixee.util;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.Status;
//import com.google.zxing.BinaryBitmap;
//import com.google.zxing.LuminanceSource;
//import com.google.zxing.MultiFormatReader;
//import com.google.zxing.NotFoundException;
//import com.google.zxing.Result;
//import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
//import com.google.zxing.common.HybridBinarizer;
import com.kwixee.extentreports.ExtentTestManager;
//import com.kwixee.pages.DataTablePage;


public class TestUtil {

	public static long Page_load_TimeOut=10;
	public static long Page_implicit_TimeOut=10;

	public  String getScreenshot(WebDriver driver, String screenshotName) throws IOException{


		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/ScreenShots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);

		return destination;
	}
	public static String appenTime() {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		return dateName;
	}
	public  String appenTime_1() {
		String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		return dateName;
	}
	public  String D_H_M_S() {
		String dateName = new SimpleDateFormat("ddhhmmss").format(new Date());
		return dateName;
	}

	public String RandomText(WebDriver driver){		
		String RandomText = UUID.randomUUID().toString();
		return RandomText;

	}



	public boolean dragAndDrop(WebDriver driver,WebElement To,WebElement From){
		try{
			Actions builder = new Actions(driver);
			Action dragAndDrop = builder.clickAndHold(From)
					.moveToElement(To)
					.release(To)
					.build();
			dragAndDrop.perform();
		}catch(Exception e){
			return false;

		}
		return true;
	}

	public boolean waitForElementisDisplay(WebDriver driver,By element) {
		try {
			driver.findElement(element).isDisplayed();
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	public  boolean waitForElementNotVisiable(WebDriver driver,By elemnt){
		try{
			PageLoading(driver);
			WebDriverWait wait = new WebDriverWait(driver,30);
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(elemnt));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(elemnt));
		}catch(Exception e){
			return false;
			
		}
		return true;
	}

	public  boolean ScrollDown(WebDriver driver,By ele) {
		try{
			WebElement element=driver.findElement(ele);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(ele).isDisplayed();
			return true;
		}catch(Exception e){
			return false;
		}
	}
	public  boolean ScrollUp(WebDriver driver,By ele) {
		try{
			WebElement element=driver.findElement(ele);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(ele).isDisplayed();
			return true;
		}catch(Exception e){
			return false;
		}
	}

	
	public  boolean waitForElement(WebDriver driver,WebElement elemnt){
		try{
			PageLoading(driver);
			WebDriverWait wait = new WebDriverWait(driver,15);
			wait.until(ExpectedConditions.elementToBeClickable(elemnt));

		}catch(Exception e){
			return false;
		}
		return true;
	}
	public  boolean waitForElement(WebDriver driver,By elemnt){
		try{
			PageLoading(driver);
			WebDriverWait wait = new WebDriverWait(driver,15);
			wait.until(ExpectedConditions.elementToBeClickable(elemnt));
		}catch(Exception e){
			return false;
		}
		return true;
	}

	public  boolean waitForElement_visibilityOfElementLocated(WebDriver driver,By elemnt,int timeout){
		try{
			PageLoading(driver);
			WebDriverWait wait = new WebDriverWait(driver,timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(elemnt));

		}catch(Exception e){
			return false;
		}
		return true;
	}
	public  boolean waitForElement_visibilityOfElementLocated(WebDriver driver,By elemnt){
		try{
			PageLoading(driver);
			WebDriverWait wait = new WebDriverWait(driver,15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(elemnt));

		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public  boolean waitForElement_presenceOfElementLocated(WebDriver driver,By elemnt){
		try{
			PageLoading(driver);
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.presenceOfElementLocated(elemnt));
		}catch(Exception e){
			return false;
		}
		return true;
	}

	public String getAttribute(WebDriver driver,By ele){
		try{
			PageLoading(driver);
			return driver.findElement(ele).getAttribute("value").trim();

		}catch(Exception e){
			return "";
		}
	}



	public String GetText(WebDriver driver,By ele) {
		try{
			PageLoading(driver);
			return driver.findElement(ele).getText().trim();
		}catch(Exception e){
			return "";
		}
	}
	public  boolean ClickElement(WebDriver driver,By ele)
	{
		try{

			// PageLoading(driver);
			driver.findElement(ele).click();
		}catch(Exception e){
			try{
				WebElement ele1=driver.findElement(ele);
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", ele1);
			}catch (Exception e2) {
				return false;
			}

		}
		return true;
	}
	public  boolean EnterText(WebDriver driver,By ele,String testdata)
	{
		try{
			PageLoading(driver);
			driver.findElement(ele).clear();
			driver.findElement(ele).sendKeys(testdata);

		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public  boolean Clear(WebDriver driver,By ele)
	{
		try{
			PageLoading(driver);
			driver.findElement(ele).clear();

		}catch(Exception e){
			return false;
		}
		return true;
	}
	public  void Log(boolean status,String msg){
		if(status){
			ExtentTestManager.log(Status.PASS, (msg));
		}else {
			ExtentTestManager.log(Status.FAIL, (msg));
		}
	}

	public void PageLoading(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		//wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		int count =0;
		if((Boolean) executor.executeScript("return window.jQuery != undefined")){
			while(!(Boolean) executor.executeScript("return jQuery.active == 0")){
				Thread.sleep(1);
				if(count>2000)
					break;
				count++;
			}
		}
	}
	
	
}
