package digitalroot.Orange_Testcases;


import java.time.Duration;

import org.testng.annotations.Test;

import digitalroot_pageObjects.Orange_logingPage;

public class TestOrange_EditEmployee extends TestBaseClass{

	@Test
	public void editEmployee() {
		
		logger.info("going to be login into the Application");
		Orange_logingPage lgn=new Orange_logingPage(driver);
		lgn.setusername(username);
		lgn.setpassword(password);
		lgn.clicksubmit();
		System.out.println("login successfully");
		logger.info("Login Successfully");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		
		
		
	}
		
	
	
	
	
	
	
}
