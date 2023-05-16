package com.digitalroot.com.digitalrootHrm;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public WebDriver driver;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver=new ChromeDriver();
		
		
		
	}
	@AfterClass
	public void teardown() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.close();
	}
}
