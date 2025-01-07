package sunnexttest1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import dataDrivenSet.Main;

public class Basicfunctionality1 extends Main  {
	@Test
	public void TitleofthePage() {
		try
		{
			driver.getTitle();
			extenttest.log(Status.PASS,"The title of the page is: " +driver.getTitle());
			
		}
		catch(Exception e)
		{
			extenttest.log(Status.FAIL,"The test cases is failed: "+e);
		}
	}
	@Test
	public void SignIn() {
		try
		{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		String signin=sheet.getRow(2).getCell(1).toString();
		String Username=sheet.getRow(3).getCell(1).toString();
		String SendKeysUsername=sheet.getRow(3).getCell(2).toString();
		String password=sheet.getRow(4).getCell(1).toString();
		String SendKeysPassword=sheet.getRow(4).getCell(2).toString();
		String Submit=sheet.getRow(5).getCell(1).toString();
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(signin))); 
		element.click();
		WebElement element2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Username)));
		element2.sendKeys(Username);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(password))).sendKeys(SendKeysPassword);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Submit))).click();
		extenttest.log(Status.PASS,"Successfully Logined Into Page: ");
		}
		catch(Exception e)
		{
			extenttest.log(Status.FAIL,"The test cases is failed: "+e);
		}
		
	}

	

}
