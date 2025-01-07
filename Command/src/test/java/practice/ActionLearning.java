package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import dataDrivenSet.Main;

public class ActionLearning extends Main {
	
	@Test
	public void ActionCase1() {
		try
		{
			driver.get("https://www.saucedemo.com/");
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			driver.findElement(By.id("login-button")).click();
			driver.getTitle();
			extenttest.log(Status.PASS,"The title of the page is: "+driver.getTitle());
		}
		catch (Exception e)
		{
			extenttest.log(Status.FAIL, "This Test is failed: "+e);
		}
	}
	@Test
	public void ActionCase2() {
		try
		{
			driver.get("https://www.saucedemo.com/");
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			driver.findElement(By.id("login-button")).click();
			WebElement target=driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']"));
			WebElement target2=driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-bike-light']"));
			WebElement target3=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
 			Actions action = new Actions(driver);
 			action.moveToElement(target).click().perform();
 			action.moveToElement(target2).click().perform();
 			action.moveToElement(target3).click().perform();
			extenttest.log(Status.PASS,"This test case is Passed");
		}
		catch (Exception e)
		{
			extenttest.log(Status.FAIL, "This Test is failed: "+e);
		}
	}
	@Test
	public void Amazon() {
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Drag and Drop")).click();
		WebElement drag=driver.findElement(By.xpath("//div[@id='column-a']"));
		WebElement drop=driver.findElement(By.xpath("//div[@id='column-b']"));
		Actions action= new Actions(driver);
		action.dragAndDrop(drag,drop).build().perform();
		extenttest.log(Status.PASS,"This test case is Passed");
	}

}
