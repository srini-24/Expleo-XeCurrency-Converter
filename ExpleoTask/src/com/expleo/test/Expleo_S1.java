package com.expleo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.kwixee.base.TestBase;
import com.kwixee.util.TestUtil;

public class Expleo_S1 {
	
	public boolean status=false;
	private TestUtil TestUtil=new TestUtil();
	
	
	public By amt_locator=By.xpath("//input[contains(@id,'amo')]");
	public By xelogo_locator=By.xpath("//a[contains(@aria-label,'Home')]");
	public By close_locator=By.xpath("//button[contains(@aria-label,'close')]");
	public By accept_locator=By.xpath("//button[contains(text(),'Accept')]");
	public By sendmoney_locator=By.xpath("//button[contains(text(),'Send Money')]");
	public By fromcurrenccy_locator=By.xpath("//input[contains(@id,'midmarketFromCurrency')]");
	public By sendingcuurency_locator=By.xpath("//input[contains(@id,'sending-currency')]");
	public By recvcuurency_locator=By.xpath("//input[contains(@id,'receiving-currency')]");
	public By sendingmoneyinput_loc=By.xpath("//input[contains(@aria-label,'Sending amount')]");
//	public By fromdrp_locator=By.xpath("//*[(contains(@class,'converterform-dropdown__option') or contains(@class,'ListboxOption')) and contains(.,'"+currency+"')]");
//	public By todrp_locator=By.xpath("//*[(contains(@class,'converterform-dropdown__option') or contains(@class,'ListboxOption')) and contains(.,'"+currency1+"')]");
	public By tocurrrency_locator=By.xpath("//input[contains(@id,'midmarketToCurrency')]");
	public By payby_debit=By.xpath("//div[contains(text(),'Pay')]");
	public By debitcard_loc=By.xpath("//span[contains(text(),'debi')]");
	public By signin_loc=By.xpath("//a[contains(text(),'Sign in ')]");
	public By createaccount_loc =By.xpath("//h1[contains(text(),'Create')]");
	public By convert_btn=By.xpath("//button[contains(@type,'submit')][contains(@class,'button__BaseButton')]");
	
	public boolean CurrencyConvertEuroToGBP(WebDriver driver){

		try{
			
			TestUtil.waitForElement_visibilityOfElementLocated(driver, xelogo_locator);
			status=TestUtil.waitForElementisDisplay(driver, xelogo_locator);
			if(status) {
				TestUtil.Log(true,"XE Logo Displayed");
			}else {
				TestUtil.Log(false,"XE Logo  display Failed");
			}
			
			
			TestUtil.waitForElement(driver, accept_locator);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, accept_locator);		
			if(status) {
				TestUtil.Log(status,"Click on Accept Passed");
			}else {
				TestUtil.Log(status,"Click on Accept failed");
				return false;
			}
			
			
			TestUtil.waitForElement(driver, close_locator);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, close_locator);		
			if(status) {
				TestUtil.Log(status,"Click on Close Icon Passed");
			}else {
				TestUtil.Log(status,"Click on Close Icon failed");
				return false;
			}
			
			Thread.sleep(3000);
			status=CurrencyConvertMethod(driver,"300","EUR","GBP");
			if(!status){
				TestUtil.Log(status, "Currency Converter Method Failed");
				return false;
			}
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
	
	public boolean CurrencyConvertGBPtoEuro(WebDriver driver){

		try{
			
			TestUtil.waitForElement_visibilityOfElementLocated(driver, xelogo_locator);
			status=TestUtil.waitForElementisDisplay(driver, xelogo_locator);
			if(status) {
				TestUtil.Log(true,"XE Logo Displayed");
			}else {
				TestUtil.Log(false,"XE Logo  display Failed");
			}
			
			TestUtil.waitForElement(driver, accept_locator);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, accept_locator);		
			if(status) {
				TestUtil.Log(status,"Click on Accept Passed");
			}else {
				TestUtil.Log(status,"Click on Accept failed");
				return false;
			}
			
			
			TestUtil.waitForElement(driver, close_locator);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, close_locator);		
			if(status) {
				TestUtil.Log(status,"Click on Close Icon Passed");
			}else {
				TestUtil.Log(status,"Click on Close Icon failed");
				return false;
			}
			
			Thread.sleep(3000);
			status=CurrencyConvertMethod(driver,"300","GBP","EUR");
			if(!status){
				TestUtil.Log(status, "Currency Converter Method Failed");
				return false;
			}
			
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
	
	public boolean CurrencyConvertUSDtoINR(WebDriver driver){

		try{
			
			TestUtil.waitForElement_visibilityOfElementLocated(driver, xelogo_locator);
			status=TestUtil.waitForElementisDisplay(driver, xelogo_locator);
			if(status) {
				TestUtil.Log(true,"XE Logo Displayed");
			}else {
				TestUtil.Log(false,"XE Logo  display Failed");
			}
			
			TestUtil.waitForElement(driver, accept_locator);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, accept_locator);		
			if(status) {
				TestUtil.Log(status,"Click on Accept Passed");
			}else {
				TestUtil.Log(status,"Click on Accept failed");
				return false;
			}
			
			
			TestUtil.waitForElement(driver, close_locator);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, close_locator);		
			if(status) {
				TestUtil.Log(status,"Click on Close Icon Passed");
			}else {
				TestUtil.Log(status,"Click on Close Icon failed");
				return false;
			}
			
			
			Thread.sleep(3000);
			status=CurrencyConvertMethod(driver,"3000","USD","INR");
			if(!status){
				TestUtil.Log(status, "Currency Converter Method Failed");
				return false;
			}
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
	
	public boolean CurrencyConvertEURtoINR(WebDriver driver){

		try{
			
			TestUtil.waitForElement_visibilityOfElementLocated(driver, xelogo_locator);
			status=TestUtil.waitForElementisDisplay(driver, xelogo_locator);
			if(status) {
				TestUtil.Log(true,"XE Logo Displayed");
			}else {
				TestUtil.Log(false,"XE Logo  display Failed");
			}
			
			TestUtil.waitForElement(driver, accept_locator);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, accept_locator);		
			if(status) {
				TestUtil.Log(status,"Click on Accept Passed");
			}else {
				TestUtil.Log(status,"Click on Accept failed");
				return false;
			}
			
			
			TestUtil.waitForElement(driver, close_locator);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, close_locator);		
			if(status) {
				TestUtil.Log(status,"Click on Close Icon Passed");
			}else {
				TestUtil.Log(status,"Click on Close Icon failed");
				return false;
			}
			
			
			
			Thread.sleep(3000);
			status=CurrencyConvertMethod(driver,"3000","EUR","INR");
			if(!status){
				TestUtil.Log(status, "Currency Converter From EURO to INR  Method Failed");
				return false;
			}
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
	
	public boolean CurrencyConvertCADtoINR(WebDriver driver){

		try{
			
			TestUtil.waitForElement_visibilityOfElementLocated(driver, xelogo_locator);
			status=TestUtil.waitForElementisDisplay(driver, xelogo_locator);
			if(status) {
				TestUtil.Log(true,"XE Logo Displayed");
			}else {
				TestUtil.Log(false,"XE Logo display Failed");
			}
			
			TestUtil.waitForElement(driver, accept_locator);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, accept_locator);		
			if(status) {
				TestUtil.Log(status,"Click on Accept Passed");
			}else {
				TestUtil.Log(status,"Click on Accept failed");
				return false;
			}
			
			
			TestUtil.waitForElement(driver, close_locator);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, close_locator);		
			if(status) {
				TestUtil.Log(status,"Click on Close Icon Passed");
			}else {
				TestUtil.Log(status,"Click on Close Icon failed");
				return false;
			}
			
			
			
			Thread.sleep(3000);
			status=CurrencyConvertMethod(driver,"3000","CAD","INR");
			if(!status){
				TestUtil.Log(status, "Currency Converter From CAD to INR  Method Failed");
				return false;
			}
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
	
	public boolean CurrencyConvertAUDtoINR(WebDriver driver){

		try{
			
			TestUtil.waitForElement_visibilityOfElementLocated(driver, xelogo_locator);
			status=TestUtil.waitForElementisDisplay(driver, xelogo_locator);
			if(status) {
				TestUtil.Log(true,"XE Logo Displayed");
			}else {
				TestUtil.Log(false,"XE Logo display Failed");
			}
			
			TestUtil.waitForElement(driver, accept_locator);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, accept_locator);		
			if(status) {
				TestUtil.Log(status,"Click on Accept Passed");
			}else {
				TestUtil.Log(status,"Click on Accept failed");
				return false;
			}
			
			
			TestUtil.waitForElement(driver, close_locator);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, close_locator);		
			if(status) {
				TestUtil.Log(status,"Click on Close Icon Passed");
			}else {
				TestUtil.Log(status,"Click on Close Icon failed");
				return false;
			}
			
			
			
			Thread.sleep(3000);
			status=CurrencyConvertMethod(driver,"3000","AUD","INR");
			if(!status){
				TestUtil.Log(status, "Currency Converter From AUD to INR  Method Failed");
				return false;
			}
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
	
	public boolean CurrencyConvertGBPtoINR(WebDriver driver){

		try{
			
			TestUtil.waitForElement_visibilityOfElementLocated(driver, xelogo_locator);
			status=TestUtil.waitForElementisDisplay(driver, xelogo_locator);
			if(status) {
				TestUtil.Log(true,"XE Logo Displayed");
			}else {
				TestUtil.Log(false,"XE Logo display Failed");
			}
			
			TestUtil.waitForElement(driver, accept_locator);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, accept_locator);		
			if(status) {
				TestUtil.Log(status,"Click on Accept Passed");
			}else {
				TestUtil.Log(status,"Click on Accept failed");
				return false;
			}
			
			
			TestUtil.waitForElement(driver, close_locator);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, close_locator);		
			if(status) {
				TestUtil.Log(status,"Click on Close Icon Passed");
			}else {
				TestUtil.Log(status,"Click on Close Icon failed");
				return false;
			}
			
			
			
			Thread.sleep(3000);
			status=CurrencyConvertMethod(driver,"3000","GBP","INR");
			if(!status){
				TestUtil.Log(status, "Currency Converter From GBP to INR  Method Failed");
				return false;
			}
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
	
	public boolean SendMoney(WebDriver driver){

		try{
			
			TestUtil.waitForElement_visibilityOfElementLocated(driver, xelogo_locator);
			status=TestUtil.waitForElementisDisplay(driver, xelogo_locator);
			if(status) {
				TestUtil.Log(true,"XE Logo Displayed");
			}else {
				TestUtil.Log(false,"XE Logo display Failed");
			}
			
			TestUtil.waitForElement(driver, accept_locator);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, accept_locator);		
			if(status) {
				TestUtil.Log(status,"Click on Accept Passed");
			}else {
				TestUtil.Log(status,"Click on Accept failed");
				return false;
			}
			
			
			TestUtil.waitForElement(driver, close_locator);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, close_locator);		
			if(status) {
				TestUtil.Log(status,"Click on Close Icon Passed");
			}else {
				TestUtil.Log(status,"Click on Close Icon failed");
				return false;
			}
			
			TestUtil.waitForElement(driver, sendmoney_locator);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, sendmoney_locator);		
			if(status) {
				TestUtil.Log(status,"Click on Send Money Button Passed");
			}else {
				TestUtil.Log(status,"Click on Send Money Button failed");
				return false;
			}
			
			TestUtil.waitForElement(driver, sendingcuurency_locator);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, sendingcuurency_locator);		
			if(status) {
				TestUtil.Log(true,"Click on Send Currency Passed");
			}else {
				TestUtil.Log(false,"Click on Send  Currency Locator failed");
			}
			
			
			Thread.sleep(3000);
			String FromCurrency="EUR";
			By senddrp_locator1=By.xpath("//*[(contains(@class,'converterform-dropdown__option') or contains(@class,'ListboxOption')) and contains(.,'"+FromCurrency+"')]");
			TestUtil.waitForElement(driver, sendingcuurency_locator);
			status=TestUtil.EnterText(driver, sendingcuurency_locator, FromCurrency);
			if(status){
				TestUtil.Log(status,"Entered Currency in From Field  : "+FromCurrency);
			}else{
				TestUtil.Log(status,"Enter Currency in From Field  : "+FromCurrency +" failed");
				return false;
			}
			
			TestUtil.waitForElement(driver, senddrp_locator1);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, senddrp_locator1);		
			if(status) {
				TestUtil.Log(true,"Click on Drop DownValue "+FromCurrency+" Passed");
			}else {
				TestUtil.Log(false,"Click on Drop Down Value "+FromCurrency+ "failed");
			}
			
			Thread.sleep(3000);
			TestUtil.waitForElement(driver, sendingmoneyinput_loc);
			status=TestUtil.ClickElement(driver, sendingmoneyinput_loc);
			if(status){
				TestUtil.Log(status,"Entered in You Send Field ");
			}else{
				TestUtil.Log(status,"Enter in You Send Field failed");
				return false;
			}
			
			driver.findElement(sendingmoneyinput_loc).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			
			Thread.sleep(3000);
			TestUtil.waitForElement(driver, sendingmoneyinput_loc);
			status=TestUtil.Clear(driver, sendingmoneyinput_loc);
			if(status){
				TestUtil.Log(status,"Cleared ");
			}else{
				TestUtil.Log(status,"Cleard failed");
				return false;
			}
			
			Thread.sleep(3000);
			String money="3000";
			TestUtil.waitForElement(driver, sendingmoneyinput_loc);
			status=TestUtil.EnterText(driver, sendingmoneyinput_loc, money);
			if(status){
				TestUtil.Log(status,"Entered "+money+" in You Send Field ");
			}else{
				TestUtil.Log(status,"Enter "+money+" in You Send Field failed");
				return false;
			}
			
			TestUtil.waitForElement(driver, recvcuurency_locator);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, recvcuurency_locator);		
			if(status) {
				TestUtil.Log(true,"Click on Receiver Currency Passed");
			}else {
				TestUtil.Log(false,"Click on Receiver  Currency Locator failed");
			}
			
			
			Thread.sleep(3000);
			String ToCurrency="INR";
			By recdrp_locator1=By.xpath("//*[(contains(@class,'converterform-dropdown__option') or contains(@class,'ListboxOption')) and contains(.,'"+ToCurrency+"')]");
			TestUtil.waitForElement(driver, recvcuurency_locator);
			status=TestUtil.EnterText(driver, recvcuurency_locator, ToCurrency);
			if(status){
				TestUtil.Log(status,"Entered Currency in From Field  : "+ToCurrency);
			}else{
				TestUtil.Log(status,"Enter Currency in From Field  : "+ToCurrency +" failed");
				return false;
			}
			
			TestUtil.waitForElement(driver, recdrp_locator1);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, recdrp_locator1);		
			if(status) {
				TestUtil.Log(true,"Click on Drop DownValue "+ToCurrency+" Passed");
			}else {
				TestUtil.Log(false,"Click on Drop Down Value "+ToCurrency+ "failed");
			}
			
			Thread.sleep(2000);
			By recevingamt_locator=By.xpath("//input[contains(@aria-label,'Receiving amount')]");
			TestUtil.ScrollDown(driver, recevingamt_locator);
			TestUtil.waitForElement_visibilityOfElementLocated(driver, recevingamt_locator);
			String convertedRate=TestUtil.getAttribute(driver, recevingamt_locator);
			if(convertedRate.length()==0){
				TestUtil.Log(false, "Unable to Capture the Receiver Rate");
			}else{
				TestUtil.Log(true, " Captured the Receiver Rate :" +convertedRate);
			}
			
//			TestUtil.ScrollDown(driver, payby_debit);
			TestUtil.waitForElement(driver, payby_debit);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, payby_debit);		
			if(status) {
				TestUtil.Log(true,"Click on Pay By Debit Passed");
			}else {
				TestUtil.Log(false,"Click on Pay By Debit failed");
			}
			
//			TestUtil.ScrollDown(driver,debitcard_loc);
			TestUtil.waitForElement(driver, debitcard_loc);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, debitcard_loc);		
			if(status) {
				TestUtil.Log(true,"Click on Debitcard Passed");
			}else {
				TestUtil.Log(false,"Click on Debitcard failed");
			}
			
//			TestUtil.ScrollDown(driver,signin_loc);
			TestUtil.waitForElement(driver, signin_loc);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, signin_loc);		
			if(status) {
				TestUtil.Log(true,"Click on Sign In and SendPassed");
			}else {
				TestUtil.Log(false,"Click on Sign In and Send failed");
			}
			
			Thread.sleep(1000);
			TestUtil.waitForElement_visibilityOfElementLocated(driver, createaccount_loc);
			status=TestUtil.waitForElementisDisplay(driver, createaccount_loc);
			if(status) {
				TestUtil.Log(true,"Create Account Displayed");
			}else {
				TestUtil.Log(false,"Create Account Failed");
			}
			
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
	
	public boolean CurrencyConvertMethod(WebDriver driver, String Amount,String FromCurrency,String ToCurrency){

		try{
			
			TestUtil.waitForElement(driver, amt_locator);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, amt_locator);		
			if(status) {
				TestUtil.Log(status,"Click on Amount Locator Passed");
			}else {
				TestUtil.Log(status,"Click on Amount Locator failed");
				return false;
			}
			
			
			Thread.sleep(3000);
			TestUtil.waitForElement(driver, amt_locator);
			status=TestUtil.EnterText(driver, amt_locator, Amount);
			if(status){
				TestUtil.Log(status,"Enter Amount "+Amount+" in Amount Field" );
			}else{
				TestUtil.Log(status,"Enter Amount in Amount Field  : "+Amount +" failed");
				return false;
			}
			
			TestUtil.waitForElement(driver, fromcurrenccy_locator);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, fromcurrenccy_locator);		
			if(status) {
				TestUtil.Log(true,"Click on From Currency Passed");
			}else {
				TestUtil.Log(false,"Click on Amount Locator failed");
			}
			
			Thread.sleep(3000);
			By fromdrp_locator1=By.xpath("//*[(contains(@class,'converterform-dropdown__option') or contains(@class,'ListboxOption')) and contains(.,'"+FromCurrency+"')]");
			TestUtil.waitForElement(driver, fromcurrenccy_locator);
			status=TestUtil.EnterText(driver, fromcurrenccy_locator, FromCurrency);
			if(status){
				TestUtil.Log(status,"Entered Currency in From Field  : "+FromCurrency);
			}else{
				TestUtil.Log(status,"Enter Currency in From Field  : "+FromCurrency +" failed");
				return false;
			}
			
			TestUtil.waitForElement(driver, fromdrp_locator1);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, fromdrp_locator1);		
			if(status) {
				TestUtil.Log(true,"Click on Drop DownValue "+FromCurrency+" Passed");
			}else {
				TestUtil.Log(false,"Click on Drop Down Value "+FromCurrency+ "failed");
			}
			
			TestUtil.waitForElement(driver, tocurrrency_locator);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, tocurrrency_locator);		
			if(status) {
				TestUtil.Log(true,"Click on To Currency Field Passed");
			}else {
				TestUtil.Log(false,"Click on To Currency Field failed");
			}
			
			Thread.sleep(3000);
			By todrp_locator1=By.xpath("//*[(contains(@class,'converterform-dropdown__option') or contains(@class,'ListboxOption')) and contains(.,'"+ToCurrency+"')]");
			TestUtil.waitForElement(driver, tocurrrency_locator);
			status=TestUtil.EnterText(driver, tocurrrency_locator, ToCurrency);
			if(status){
				TestUtil.Log(status,"Entered Currency in To Field  : "+ToCurrency);
			}else{
				TestUtil.Log(status,"Enter Currency in To Field  : "+ToCurrency +" failed");
				return false;
			}
			
			TestUtil.waitForElement(driver, todrp_locator1);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, todrp_locator1);		
			if(status) {
				TestUtil.Log(true,"Click on Drop DownValue "+ToCurrency+" Passed");
			}else {
				TestUtil.Log(false,"Click on Drop Down Value "+ToCurrency+ "failed");
			}
			
			TestUtil.waitForElement(driver, convert_btn);
			Thread.sleep(1000);
			status=TestUtil.ClickElement(driver, convert_btn);		
			if(status) {
				TestUtil.Log(true,"Click on Convert Button Passed");
			}else {
				TestUtil.Log(false,"Click on Convert Button failed");
			}
			
			Thread.sleep(3000);
			TestUtil.waitForElement_visibilityOfElementLocated(driver, By.xpath("//p[contains(@class,'result__BigRate')]"));
			String convertedRate=TestUtil.GetText(driver, By.xpath("//p[contains(@class,'result__BigRate')]"));
			if(convertedRate.length()==0){
				TestUtil.Log(false, "Unable to Capture the Converted Rate");
			}else{
				TestUtil.Log(true, " Captured the Converted Rate :" +convertedRate);
			}
			
			

		}
		catch(Exception e){
			return false;
		}
		return true;
	}
	
}
	


