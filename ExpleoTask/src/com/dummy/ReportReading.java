package com.dummy;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.poi.hssf.util.HSSFColor.GREEN;
import org.apache.poi.hssf.util.HSSFColor.LIGHT_BLUE;
import org.apache.poi.hssf.util.HSSFColor.LIGHT_ORANGE;
import org.apache.poi.hssf.util.HSSFColor.RED;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class ReportReading {
	public static  Map< String,Map< String,String>> reports=new LinkedHashMap<String,Map< String,String>>();
	public static WebDriver driver = null;

	public static String StartAndEndTime="";
	public static XSSFWorkbook workbook ;
	public static String exportTOExcel="C:\\Users\\dileepkumarm\\Desktop\\ExcelSheetReports\\Reports.xlsx";
	
	public static void main(String[] args) throws InterruptedException, IOException {
	//ReadDataFromExportFileToExcelSheet("D:\\VividMinds\\KwixeeAutomation\\Reports_2020_10_05\\Quixy_2020_10_05_10_36_50.html");
	//	System.out.println("Present Project Directory : "+ System.getProperty("user.dir")+"\\Drivers\\chromedriver_78.exe");
	
	}



	public static void ReadDataFromExportFileToExcelSheet(String filePath) throws InterruptedException, IOException{
		System.out.println("Launching the Chrome Browser");
		String driverpath = System.getProperty("user.dir")+"\\Drivers\\chromedriver_78.exe";
		System.setProperty("webdriver.chrome.driver",driverpath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(filePath);
		Thread.sleep(20000);
		driver.findElement(By.xpath("//a[@view='category-view']/i")).click();
		Thread.sleep(10000);
		int ModuleCount=driver.findElements(By.xpath("//ul[@id='category-collection']/li")).size();
		System.out.println(" ModuleCount "+ModuleCount);

		//System.out.println("ModuleCount "+ModuleCount);
		Map< String,String> testdata;
		for(int i=1;i<=ModuleCount-1;i++){
			testdata =  new LinkedHashMap<String,String>(); 
			WebElement element=driver.findElement(By.xpath("//ul[@id='category-collection']/li["+i+"]/div[1]/span[1]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

			String module=driver.findElement(By.xpath("//ul[@id='category-collection']/li["+i+"]/div[1]/span[1]")).getText();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//ul[@id='category-collection']/li["+i+"]/div[1]/span[1]")).click();
			Thread.sleep(1000);
			int testcasesCount=driver.findElements(By.xpath("//*[text()='"+module+"']/parent::div/following-sibling::div//tbody/tr")).size();
			for(int j=1;j<=testcasesCount;j++){

				WebElement element1=driver.findElement(By.xpath("//*[text()='"+module+"']/parent::div/following-sibling::div//tbody/tr["+j+"]/td[2]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);

				String tn=driver.findElement(By.xpath("//*[text()='"+module+"']/parent::div/following-sibling::div//tbody/tr["+j+"]/td[2]")).getAttribute("innerText");
				String status=driver.findElement(By.xpath("//*[text()='"+module+"']/parent::div/following-sibling::div//tbody/tr["+j+"]//td[text()='"+tn+"']/../td[3]/span")).getAttribute("innerText");


				//if passed
				try{
					if(testdata.get(tn).equalsIgnoreCase("pass")){
						continue;
					}
				}catch(Exception e){

				}
				//if passed before later failed
				if(status.equals("fail")||status.equals("skip")){

					testdata.put(tn,"Fail");

				}else if(status.equals("pass")){

					testdata.put(tn,"Pass");

					if(testdata.containsKey(tn)){

						if(testdata.containsValue("Fail")){

							testdata.put(tn,"Pass");
						}
					}
				}
			}
			//System.out.println(testdata);
			reports.put(module, testdata);
		}
		System.out.println(reports);
		clearExcel();
		writeToExcel();

	}

	public static void writeToExcel() throws IOException, InterruptedException
	{
		//File  src=new File("C:\\Users\\dileepkumarm\\Desktop\\CompareFiles\\Reports.xlsx");
		File  src=new File(exportTOExcel);
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis); 
		Sheet sheet = wb.getSheetAt(0); 
		FileOutputStream fileOut = null;


		int k=5;
		int TotalTestcasesCount =0;
		int FailTestCasesCount=0;
		int PassTestCasesCount=0;
		Row row = null;

		row= sheet.createRow(4); 

		Cell c1=row.createCell(1);
		c1.setCellValue("Module Name");
		CellStyle s1 = wb.createCellStyle();  
		XSSFFont f1=wb.createFont();
		f1.setBold(true);
		f1.setColor(LIGHT_ORANGE.index);
		f1.setFontName(XSSFFont.DEFAULT_FONT_NAME);
		s1.setFont(f1);
		s1.setVerticalAlignment(CellStyle.ALIGN_CENTER);
		c1.setCellStyle(s1);

		Cell c2=row.createCell(2);
		c2.setCellValue("Test case Discription");
		c2.setCellStyle(s1);

		Cell c3=row.createCell(3);
		c3.setCellValue("Automation Status");
		c3.setCellStyle(s1);

		for (String key : reports.keySet()) {

			Map<String , String> testcases = reports.get(key);
			row= sheet.createRow(k); 

			Cell cell1=row.createCell(1);
			cell1.setCellValue(key);
			CellStyle style1 = wb.createCellStyle();  
			XSSFFont font1=wb.createFont();
			font1.setBold(true);
			font1.setColor(LIGHT_BLUE.index);
			font1.setFontName(XSSFFont.DEFAULT_FONT_NAME);
			style1.setFont(font1);
			style1.setVerticalAlignment(CellStyle.ALIGN_CENTER);
			cell1.setCellStyle(style1);


			Thread.sleep(10);
			for(String testcaseName : testcases.keySet()){
				TotalTestcasesCount++;
				k++;
				Row row1 = sheet.createRow(k); 
				row1.createCell(2).setCellValue(testcaseName);

				if(testcases.get(testcaseName).equals("Pass")){
					PassTestCasesCount++;
					Cell cell=row1.createCell(3);
					cell.setCellValue("Pass");
					CellStyle style = wb.createCellStyle();  
					XSSFFont font=wb.createFont();
					font.setBold(true);
					font.setColor(GREEN.index);
					font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
					style.setFont(font);
					style.setVerticalAlignment(CellStyle.ALIGN_CENTER);
					cell.setCellStyle(style);

				}else{
					FailTestCasesCount++;
					Cell cell=row1.createCell(3);
					cell.setCellValue("Fail");
					CellStyle style = wb.createCellStyle();  
					XSSFFont font=wb.createFont();
					font.setBold(true);
					font.setColor(RED.index);
					font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
					style.setFont(font);
					style.setVerticalAlignment(CellStyle.ALIGN_CENTER);
					cell.setCellStyle(style);

				}
			}
			k++;
		}


		Row status=null;
		status=sheet.createRow(0);
		Cell cell1=status.createCell(1);
		cell1.setCellValue("Total Test cases Count");
		Cell cell_1=status.createCell(2);
		cell_1.setCellValue(TotalTestcasesCount);

		status=sheet.createRow(1);
		Cell cell2=status.createCell(1);
		cell2.setCellValue("Total Pass Test cases Count");
		Cell cell_2=status.createCell(2);
		cell_2.setCellValue(PassTestCasesCount);


		status=sheet.createRow(2);
		Cell cell3=status.createCell(1);
		cell3.setCellValue("Total Fail Test cases Count");
		Cell cell_3=status.createCell(2);
		cell_3.setCellValue(FailTestCasesCount);

		//Capturing time

		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@view='dashboard-view']/i")).click();
		Thread.sleep(10000);
		String start=driver.findElement(By.xpath("//div[@class='row']/div[3]/div/div")).getAttribute("innerText").trim();
		String end=driver.findElement(By.xpath("//div[@class='row']/div[4]/div/div")).getAttribute("innerText").trim();

		status=sheet.createRow(3);
		Cell cell4=status.createCell(1);
		cell4.setCellValue("Start Time And End Time");
		Cell cell_4=status.createCell(2);
		cell_4.setCellValue(start + "   >>>>>>>   " +end);
		driver.close();
		driver.quit();
		fileOut = new FileOutputStream(src); 
		wb.write(fileOut);
		fileOut.close(); 

	}
	public static void clearExcel() throws IOException{
	//	File  src=new File("C:\\Users\\dileepkumarm\\Desktop\\ExcelSheetReports\\Reports.xlsx");
		File  src=new File(exportTOExcel);
		
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis); 
		Sheet sheet = wb.getSheetAt(0); 
		FileOutputStream fileOut = null;

		int i=sheet.getLastRowNum();
		System.out.println("999 "+i);
		Row row = null;

		for(int j=0;j<=i;j++){
          row= sheet.createRow(j); 

			Cell c1=row.createCell(1);
			c1.setCellValue("");
		}
		fileOut = new FileOutputStream(src); 
		wb.write(fileOut);
		fileOut.close();
	}
}

