package dataDrivenSet;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.*;
public class Main {
	public static WebDriver driver;
	public static ExtentReports extentreports;
	public static ExtentTest extenttest;
	public  XSSFWorkbook workbook;
	public XSSFSheet sheet;
	Row row;
	Cell cell;
	@BeforeSuite
	public void Setup() {
	ExtentSparkReporter sparkreporter = new ExtentSparkReporter("C:\\Users\\vcmax\\eclipse-workspace\\Command\\Reports\\Test1.html");
	extentreports = new ExtentReports();
	extentreports.attachReporter(sparkreporter);
	}
	@BeforeMethod
	public void Login(Method method) throws IOException
	{
		extenttest=extentreports.createTest(method.getName());
		FileInputStream fis=new FileInputStream("C:\\Users\\vcmax\\eclipse-workspace\\Command\\Files\\TestData.xlsx");
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheetAt(0);
		row=sheet.getRow(0);
		System.setProperty("Webdriver.chrome.driver","C:\\Users\\vcmax\\eclipse-workspace\\Command\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
	}
	@AfterMethod
	public void end(Method method) throws InterruptedException
	
	{
		
		System.out.println("Method Passed: "+method.getName());
		Thread.sleep(2000);
		driver.quit();
	}
	@AfterTest()
		public void tearDown() throws IOException {
			workbook.close();
			extentreports.flush();
			
		}
	

}
