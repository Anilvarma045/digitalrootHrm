package digitalroot.Orange_Testcases;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

import digitalroot_pageObjects.Orange_logingPage;

@Listeners(digitalroot.Utilities.Reporting.class)
public class TestOrange_login extends TestBaseClass{
	//@Test(groups= {"demo"},invocationCount=4)
	@Test
	//@Test(invocationCount = 2, threadPoolSize = 0)

	public void loginOrange() throws Exception {
		Orange_logingPage login=new Orange_logingPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		login.setusername(username);
		login.setpassword(password);
		
		capturescreen(driver,"mypicture");
		
		login.clicksubmit();
		Thread.sleep(3000);
		System.out.println("login Done");
			logger.info("login successfull");
			
		try {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		if(js.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.print("page loaded successfully");
			logger.info("page loaded fully and login sucessfully");
		}
		}catch(Exception e){
			e.getMessage();
			System.out.println("page not loaded properly");
			logger.info("page was not loaded properly");
			
		}
		
	}
	

	
}
