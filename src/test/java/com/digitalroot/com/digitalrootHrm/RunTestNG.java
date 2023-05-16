package com.digitalroot.com.digitalrootHrm;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class RunTestNG extends BaseClass{
	//i used BaseClass here it's contain driver object initialization
	
	
	
	@Test(priority = 0)
	public void openapp() {
		
		driver.get("http://127.0.0.1/orangehrm-2.6/login.php");
		System.out.println(driver.findElement(By.name("txtUserName")).getAttribute("name"));
		System.out.println("done my test");
		
	}
	//@Test(priority =1)
	@Test(priority =1)
	public void login() {
		System.out.println("im doign login here");
		driver.findElement(By.name("txtUserName")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin");
		driver.findElement(By.name("Submit")).click();
		System.out.print(driver.getTitle());
		System.out.println("done andi Testing");
	
	}
	
	@Test (priority = 2)
	public void createEmployee()throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@value='Add']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

		driver.findElement(By.xpath("//input[@name='txtEmpFirstName']")).sendKeys("Ravi");
		
		driver.findElement(By.xpath("//input[@name='txtEmpLastName']")).sendKeys("Raja");
		
		WebElement EID=driver.findElement(By.xpath("//input[@name='txtEmployeeId']"));   //.getAttribute("value");
		String ecode=EID.getAttribute("value");
		System.out.println(ecode+": code of the Employee");
		driver.findElement(By.xpath("//input[@title='Save']")).click();
		
		Thread.sleep(5000);
		System.out.println("employee Added Successfully");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Source=ts.getScreenshotAs(OutputType.FILE);
		
	}
}
