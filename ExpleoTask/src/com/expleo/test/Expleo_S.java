package com.expleo.test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.kwixee.extentreports.ExtentTestManager;
import com.kwixee.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.kwixee.base.TestBase;


public class Expleo_S {
	
	
	public boolean status=false;
	
	public boolean ExpleoTestcase(WebDriver Driver){
		try{
			
			
			
		}catch(Exception e){
			return false;
		}
		
		return status;
		
		
	}
	
	
	public static void main(String[] args) throws InterruptedException  {
		String currency="EUR";
		String currency1="GBP";
		By amt_locator=By.xpath("//input[contains(@id,'amo')]");
		By close_locator=By.xpath("//button[contains(@aria-label,'close')]");
		By accept_locator=By.xpath("//button[contains(text(),'Accept')]");
		By fromcurrenccy_locator=By.xpath("//input[contains(@id,'midmarketFromCurrency')]");
		By fromdrp_locator=By.xpath("//*[(contains(@class,'converterform-dropdown__option') or contains(@class,'ListboxOption')) and contains(.,'"+currency+"')]");
		By todrp_locator=By.xpath("//*[(contains(@class,'converterform-dropdown__option') or contains(@class,'ListboxOption')) and contains(.,'"+currency1+"')]");
		By tocurrrency_locator=By.xpath("//input[contains(@id,'midmarketToCurrency')]");
		By convert_btn=By.xpath("//button[contains(@type,'submit')][contains(@class,'button__BaseButton')]");
		
		boolean status=false;
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver_103.exe"); 
		WebDriver driver = new ChromeDriver();
        driver.get("http://www.xe.com/currencyconverter/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        Thread.sleep(5000);
        driver.findElement(accept_locator).click();
//      Thread.sleep(5000);
        WebDriverWait wait=new WebDriverWait(driver,50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(close_locator));
        driver.findElement(close_locator).click();
//      Assert.assertTrue(status);
        driver.findElement(amt_locator).click();
        driver.findElement(amt_locator).sendKeys("100");
        driver.findElement(fromcurrenccy_locator).click();
        driver.findElement(fromcurrenccy_locator).sendKeys(currency);
        driver.findElement(fromdrp_locator).click();
        
        driver.findElement(tocurrrency_locator).click();
        driver.findElement(tocurrrency_locator).sendKeys(currency1);
        driver.findElement(todrp_locator).click();
        
        Thread.sleep(3000);
        driver.findElement(convert_btn).click();
        
        String a=driver.findElement(By.xpath("//p[contains(@class,'result__BigRate')]")).getText();
        Assert.assertNotEquals(a, 0);
        
        Thread.sleep(5000);
       
        driver.quit();
       
    }


}
