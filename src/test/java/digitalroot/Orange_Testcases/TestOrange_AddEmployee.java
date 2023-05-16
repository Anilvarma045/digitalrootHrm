package digitalroot.Orange_Testcases;

import java.io.File;

import java.io.IOException;
import java.util.List;

import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import digitalroot_pageObjects.Orange_AddEmpPage;
import digitalroot_pageObjects.Orange_HomePage;
import digitalroot_pageObjects.Orange_logingPage;
@Listeners(digitalroot.Utilities.Reporting.class)
public class TestOrange_AddEmployee extends TestBaseClass{
	
	
	@Test
	@Parameters({"firstn","lastn"})
	public void addEmployee(String fname, String lname) throws Exception{
		Orange_logingPage login= new Orange_logingPage(driver);
		login.setusername("admin");
		login.setpassword("admin");
		login.clicksubmit();
		
		System.out.println("Login Successfully");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		logger.warn("loging successfully");
		driver.switchTo().frame(0);
		
		Orange_HomePage hpg=new Orange_HomePage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		try {
			if(js.executeScript("return document.readyState").toString().equals("complete")) {
				System.out.println("page load succesfully"); }
			}catch(Exception e) {
				System.out.println("page not loaded");
				
			}
		
		
		hpg.clickaddempbtn();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Orange_AddEmpPage addemp=new Orange_AddEmpPage(driver);
		addemp.firstName(fname);
		addemp.lastName(lname);
		addemp.saveEmp();
		logger.info("Employe added with first and lastName"+fname+","+lname);
//		File f1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//
//		FileUtils.copyFile(f1,new File("D:\\mypng.jpg"));
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/screenshots/" +" testProof" + ".png");
    	FileUtils.copyFile(source, target);
    	logger.info("Screenshot was taken successfully");
	}

}
