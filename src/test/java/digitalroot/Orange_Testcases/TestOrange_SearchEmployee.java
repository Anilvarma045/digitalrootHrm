package digitalroot.Orange_Testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import digitalroot_pageObjects.Orange_HomePage;
import digitalroot_pageObjects.Orange_logingPage;

public class TestOrange_SearchEmployee extends TestBaseClass {

	@Test
	public void searchEmployee() {
		logger.info("going to be login into the Application");
		Orange_logingPage lgn=new Orange_logingPage(driver);
		lgn.setusername(username);
		lgn.setpassword(password);
		lgn.clicksubmit();
		System.out.println("login successfully");
		logger.info("Login Successfully");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//driver.switchTo().frame(0);
		Orange_HomePage hpg=new Orange_HomePage(driver);
		hpg.selectdropdownsearch();
		hpg.searchbox("Shiva");
		hpg.clicksearchbth();
		logger.info("Search Employee by FirstName");
		
		driver.findElement(By.xpath("//a[@target='_self']")).click();
		logger.info("opened Employee Details");
		
		
		
	}
	
}