package digitalroot_pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Orange_HomePage {

	WebDriver ldriver;
	
	 public Orange_HomePage(WebDriver driver) {
		 
		 ldriver=driver;
		 PageFactory.initElements(driver, this); 
	}
	 
	 @FindBy(xpath="//input[@value='Add']")
	 WebElement addEmpbtn;
	 
	 @FindBy(xpath="//input[@value='Delete']")
	 WebElement deleteEmpbtn;
	 
	 @FindBy(xpath="//select[@id='loc_code']")
	 WebElement searchdrop;
	 
	 @FindBy(xpath="//input[@id='loc_name']")
	 WebElement searchbox;
	 
	 @FindBy(xpath="//input[@value='Search']")
	 WebElement searchbtn;
	 
	 @FindBy(xpath="//a[contains(text(),'Logout')]")
	 WebElement logoutbtn;
	 



		public void clickaddempbtn() {
			
			addEmpbtn.click();
		}
		
		public void clickdeletebtn() {
			deleteEmpbtn.click();
			System.out.println("Employee Deleted"); 
		}
		
		public void selectdropdownsearch() {
	
			Select sc=new Select(searchdrop);
			sc.selectByVisibleText("Emp. First Name");
			System.out.println("Dropdown selected for firstName");
		}

		public void searchbox(String searchvalue) {
			searchbox.sendKeys(searchvalue);
		}
		
		public void clicklogout() {
			logoutbtn.click();
		}
		
		public void clicksearchbth() {
			searchbtn.click();
			System.out.println("will appear search Result");
		}

}