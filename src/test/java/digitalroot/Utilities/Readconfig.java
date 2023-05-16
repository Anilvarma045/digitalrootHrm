package digitalroot.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {

	Properties pro;
	
	public Readconfig() {
	
		File src=new File("./ConfigurationsFiles\\config.properties");
	try {
		FileInputStream fis=new FileInputStream(src);
		pro=new Properties();
		pro.load(fis);
	}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
	}
	
	
	public String getappurl() {
		String appurl=pro.getProperty("URL");
		return appurl;
	}
	public String getusername() {
		String username=pro.getProperty("username");
		return username;
	}
	
	public String getchromepath() {
		String cpath=pro.getProperty("chromepath");
		return cpath;
	}
	public String getpassword() {
		String password=pro.getProperty("password");
		return password;
	}
	public String getempfname() {
		String empfname=pro.getProperty("empfname");
		return empfname;
	}
	public String getemplname() {
		String emplname=pro.getProperty("emplname");
		return emplname;
		
	}
	
	}




