package digitalroot.Orange_Testcases;




import java.io.File;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import digitalroot.Utilities.Readconfig;

public class BaseClassDummy {
	
	Readconfig rconfig=new Readconfig();
	String url=rconfig.getappurl();
	String username=rconfig.getusername();
	String password=rconfig.getpassword();
	String chromepath=rconfig.getchromepath();
	
	Logger logger;
	
	public WebDriver driver;
	
	@BeforeClass(alwaysRun=true)
	@Parameters("browser")
	public void setup(String br) {
		
		logger=Logger.getLogger("digitalROot");
		
		PropertyConfigurator.configure("Log4j.Properties");
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver=new ChromeDriver();
		
		//driver.get("http://127.0.0.1/orangehrm-2.6/login.php");
		driver.get(url);
		System.out.println("application opened Succesfully");
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\BrowserDrivers\\chromedriver.exe");
			
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","D:\\BrowserDrivers\\Firefoxdriver.exe");
		}
		else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver","D:\\BrowserDrivers\\iedriver.exe");
		}
		else {
			System.out.println("try to give valid browser Name");
		}
		
	}
	@AfterClass
	public void teardown() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.close();
	}
	
	public void selectDropDown(WebElement element,String value) {
		Select sc=new Select(element);
		List<WebElement> alloption=sc.getOptions();
		for(WebElement option:alloption) {
			if(option.getText().equals(value));
			option.click();
			break;
		}
	}
		
		public void capturescreen(WebDriver driver,String tname) throws Exception {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			File target=new File(System.getProperty("user.dir")+"/screenshots/"+tname+".png");
			FileUtils.copyFile(source, target);
		
	}
	
	
	
}
