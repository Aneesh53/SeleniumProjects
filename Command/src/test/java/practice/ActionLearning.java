package practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	@Test
	public void RobotActions() throws AWTException, InterruptedException {
		driver.get("https://www.edureka.co/");
		driver.findElement(By.linkText("All Courses")).click();
		Robot robot = new Robot();
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_TAB);
		System.out.println("258963");
		Thread.sleep(4000);
		robot.mouseMove(30,100);	
		extenttest.log(Status.PASS,"This test case is Passed");
	}
	@Test
	public void SelectDEmo() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		WebElement day= driver.findElement(By.id("day"));
		Select select = new Select(day);
		Thread.sleep(2000);
		select.selectByIndex(9);
		WebElement mon= driver.findElement(By.id("month"));
		Select select2 = new Select(mon);
		select2.selectByVisibleText("Jun");
		WebElement Year= driver.findElement(By.id("year"));
		Select select3= new Select(Year);
		Thread.sleep(2000);
		select3.selectByValue("1999");
		List<WebElement> day_d1=select3.getOptions();
		int totaldays=day_d1.size();
		System.out.println("Total Count is:" +totaldays);
		for(WebElement data:day_d1)
		{
			String day1=data.getText();
			System.out.println("The days are: "+day1);
		}
		driver.findElement(By.xpath("//input[@class='_8esa' and @value='2']")).click();
	}
	@Test
	public void MultipleWindows() throws InterruptedException {
		driver.get("https://demoqa.com/browser-windows");
		String Parent=driver.getWindowHandle();
		JavascriptExecutor js= (JavascriptExecutor) driver;
		System.out.println(Parent);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element =wait.until(ExpectedConditions.elementToBeClickable(By.id("windowButton")));
		js.executeScript("window.scrollBy(0,400)");
		for(int i=0;i<3;i++)
		{
			element.click();
			Thread.sleep(2000);
		}
		Set<String> allWindowHandles=driver.getWindowHandles();
		for(String handle:allWindowHandles)
		{
			System.out.println("Window Handle: "+handle);
		}
		Iterator <String> itr = allWindowHandles.iterator();
		while(itr.hasNext())
		{
			js.executeScript("window.scrollBy(0,400)");
			String child=itr.next();
			if(!Parent.equals(child))
			{
				driver.switchTo().window(child);
				System.out.println(driver.getTitle());
				driver.close();	
			}
			
		}
	}

}
