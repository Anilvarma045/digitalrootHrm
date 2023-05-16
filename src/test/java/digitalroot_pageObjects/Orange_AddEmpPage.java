package digitalroot_pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Orange_AddEmpPage {

	WebDriver ldriver;
	
	public Orange_AddEmpPage(WebDriver driver) {
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="txtEmpFirstName")
	WebElement fstName;
	
	@FindBy(name="txtEmpLastName")
	WebElement lstname;
	
	@FindBy(xpath="//input[@title='Save']")
	WebElement savebtn;
	
	
	public void firstName(String fname) {
		fstName.sendKeys(fname);
	}
	
	public void lastName(String lname) {
		lstname.sendKeys(lname);
		
	}

	public void saveEmp() {
		System.out.println("Employeed Saved Succesfully");
		savebtn.click();
	}
}
