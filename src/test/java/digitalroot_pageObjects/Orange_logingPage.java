package digitalroot_pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Orange_logingPage {

	WebDriver ldriver;
	public Orange_logingPage(WebDriver driver) {
	
	ldriver = driver;
	PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//input[@name='txtUserName']")
	WebElement usernametxt;
	
	@FindBy(xpath="//input[@name='txtPassword']")
	WebElement passwordtxt;
	
	@FindBy(name="Submit")
	WebElement submit;
	
	public void setusername(String username) {
		usernametxt.sendKeys(username);
	}
	
	public void setpassword(String password) {
		passwordtxt.sendKeys(password);
	}
	
	public void clicksubmit() {
		submit.click();
		System.out.print("just now clicked submit button");
	}
	
	
	
}
