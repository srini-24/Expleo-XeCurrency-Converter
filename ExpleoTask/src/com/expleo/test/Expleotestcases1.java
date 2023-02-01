package com.expleo.test1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.expleo.test.Expleo_S;
import com.kwixee.base.TestBase;
import com.expleo.test.Expleo_S1;
import com.kwixee.extentreports.ExtentTestManager;

public class Expleotestcases1 extends TestBase{
	
	private Expleo_S expleo_s=new Expleo_S();
	private Expleo_S2 expleo_s2=new Expleo_S2();
	
	@Test(priority=1)
	public void CurrencyConvertor1() throws InterruptedException, IOException {
		boolean status=false;
		ExtentTestManager.createTest("CurrencyEURToGBP","Currrency Converter");
		//status=loginPage.login(driver,username,password);
		//Assert.assertTrue(status);	
		status=expleo_s2.CurrencyConvertEuroToGBP(driver);
		Assert.assertTrue(status);
	}
	
	@Test(priority=2)
	public void CurrencyConvertor2() throws InterruptedException, IOException {
		boolean status=false;
		ExtentTestManager.createTest("CurrencyGBPToEuro","Currrency Converter");
		//status=loginPage.login(driver,username,password);
		//Assert.assertTrue(status);	
		status=expleo_s2.CurrencyConvertGBPtoEuro(driver);
		Assert.assertTrue(status);
	}
	
	@Test(priority=3)
	public void CurrencyConvertor3() throws InterruptedException, IOException {
		boolean status=false;
		ExtentTestManager.createTest("CurrencyUSDToINR","Currrency Converter");
		//status=loginPage.login(driver,username,password);
		//Assert.assertTrue(status);	
		status=expleo_s2.CurrencyConvertUSDtoINR(driver);
		Assert.assertTrue(status);
	}
	
	@Test(priority=4)
	public void CurrencyConvertor4() throws InterruptedException, IOException {
		boolean status=false;
		ExtentTestManager.createTest("CurrencyEURToINR","Currrency Converter");
		//status=loginPage.login(driver,username,password);
		//Assert.assertTrue(status);	
		status=expleo_s2.CurrencyConvertEURtoINR(driver);
		Assert.assertTrue(status);
	}
	
	@Test(priority=5)
	public void CurrencyConvertor5() throws InterruptedException, IOException {
		boolean status=false;
		ExtentTestManager.createTest("CurrencyCADToINR","Currrency Converter");
		//status=loginPage.login(driver,username,password);
		//Assert.assertTrue(status);	
		status=expleo_s2.CurrencyConvertCADtoINR(driver);
		Assert.assertTrue(status);
	}
	
	@Test(priority=6)
	public void CurrencyConvertor6() throws InterruptedException, IOException {
		boolean status=false;
		ExtentTestManager.createTest("CurrencyAUDToINR","Currrency Converter");
		//status=loginPage.login(driver,username,password);
		//Assert.assertTrue(status);	
		status=expleo_s2.CurrencyConvertAUDtoINR(driver);
		Assert.assertTrue(status);
	}
	
	@Test(priority=7)
	public void CurrencyConvertor7() throws InterruptedException, IOException {
		boolean status=false;
		ExtentTestManager.createTest("CurrencyGBPToINR","Currrency Converter");
		//status=loginPage.login(driver,username,password);
		//Assert.assertTrue(status);	
		status=expleo_s2.CurrencyConvertGBPtoINR(driver);
		Assert.assertTrue(status);
	}
	
	@Test(priority=8)
	public void CurrencyConvertor8() throws InterruptedException, IOException {
		boolean status=false;
		ExtentTestManager.createTest("Send Money","Currrency Converter");
		//status=loginPage.login(driver,username,password);
		//Assert.assertTrue(status);	
		status=expleo_s2.SendMoney(driver);
		Assert.assertTrue(status);
	}

}
