package digitalroot.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testContext) {
		 String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 String repName="Test-Reporter-"+timeStamp+".html";
		 
		 htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		 
		 extent=new ExtentReports();
		 extent.attachReporter(htmlReporter);
		 extent.setSystemInfo("Host name","Digital root");
		 extent.setSystemInfo("QA Engineer", "Anil Kumar");
		 extent.setSystemInfo("Environment", "staging 1");
		 
		 htmlReporter.config().setDocumentTitle("DigitalRootHrm Application");
		 htmlReporter.config().setReportName("Functional Test Reporter");
		 htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		 htmlReporter.config().setTheme(Theme.DARK);
		 
		 
	}
		 public void onTestSucess(ITestResult tr) {
			 logger=extent.createTest(tr.getName()); // create new entry in the report
				logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
		
	}
	
	public void onTestSkipped(ITestResult tr) {
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));

		
	}
	public void onTestFailure(ITestResult tr) {
		 logger=extent.createTest(tr.getName());
		 logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		 String screenshotpath=System.getProperty("user.dir")+"\\screenshots\\"+tr.getName()+".png";
		 
		 File f=new File(screenshotpath);
		 if(f.exists()) {
			 try {logger.fail("screenshot is below:" + logger.addScreenCaptureFromPath(screenshotpath));
			 
			 }catch(IOException e) {
				 e.printStackTrace();
			 }
		 }
	}
	public void onFinish(ITestContext tr) {
		extent.flush();
	}
}

