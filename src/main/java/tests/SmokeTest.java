package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.UtilBase;
import utilities.WebElementLib;

public class SmokeTest extends UtilBase {

//	VARIABLES
	final String baseURL = "https://uat.gearchecker.io/";
	final String username = "superadmin@gearchecker.test";
	final String password = "12345678";

	@BeforeClass
	public void setup() {
		try {
			initialiseDriver();
			System.out.println("Initializing the browser");

//			Extent Report
			ExtentSparkReporter spark = new ExtentSparkReporter("testReports/" + "SmokeTest_Report" + ".html");
			extent = new ExtentReports();
			extent.attachReporter(spark);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	Login Test with Invalid Credentials
	@Test(priority = 1)
	public void loginTest_invalidCredentials() {
		String testName = "loginTest_invalidCredentials";
		test = extent.createTest(testName);

//		Invalid Credentials
		String username_invalid = "randomUser@gearchecker.test";
		String password_invalid = "random345";
		try {
			driver.get(baseURL);
			pObj.input_email().sendKeys(username_invalid);
			pObj.input_password().sendKeys(password_invalid);
			pObj.button_login().click();
			Thread.sleep(3000);

//			pass condition
			if (WebElementLib.doesElementExist(pObj.message_login_failed())) {
				testPassed(testName);
			} else {
				testFailed(testName);
			}

		} catch (Exception e) {
			testException(testName, e);
		}

	}

//Login Test with Valid Credentials
	@Test(priority = 2)
	public void loginTest_validCredentials() {
		String testName = "loginTest_validCredentials";
		test = extent.createTest(testName);



		try {
			driver.get(baseURL);
			pObj.input_email().sendKeys(username);
			pObj.input_password().sendKeys(password);
			pObj.button_login().click();
			Thread.sleep(3000);

//			pass condition
			if (WebElementLib.doesElementExist(pObj.link_dashboard_gearchecker())) {
				testPassed(testName);
			} else {
				testFailed(testName);
			}

		} catch (Exception e) {
			testException(testName, e);
		}
	}

	
	
	
	//GearList check
		@Test(priority = 3)
		public void gearlist_test() {
			String testName = "gearlist_test";
			test = extent.createTest(testName);



			try {
				

			} catch (Exception e) {
				testException(testName, e);
			}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterClass
	public void teardown() {
		try {
			extent.flush();
			driver.close();
			System.out.println("Closing the browser");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
