package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.RobotClass;
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
//	@Test(priority = 1)
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

	// GearList check
	@Test(priority = 3)
	public void createActivity_test() {
		String testName = "createActivity_test";
		test = extent.createTest(testName);

//			variables
		String activityName = "bonfire";
		String logopath = "D:\\gearchecker\\Test Documents\\TestDatas\\tilicho.jpg";

		try {
			pObj.navbar_link_activity().click();
			pObj.activity_button_addActivity().click();
			Thread.sleep(3000);

			pObj.createActivity_input_name().sendKeys(activityName);
			pObj.createActivity_toggle_isFeatured().click();
			pObj.createActivity_button_uploadLogo().click();
			Thread.sleep(3000);

			// Copying and pasting file paths into the dialog
			RobotClass.copyPaste(logopath);

			Thread.sleep(6000);
			//	scroll into view
			jsDriver.executeScript("arguments[0].scrollIntoView();", pObj.createActivity_button_save());
			Thread.sleep(500);
			pObj.createActivity_button_save().click();
			Thread.sleep(2000);
//			check the pass / fail condition [check the toaster message]
			if (WebElementLib.doesElementExist(pObj.alert_toastMessage())) {
				String message = pObj.alert_toastMessage().getText();
				if (message.equals("Activity created successfully!")) {
					testPassed(testName);
				}else {
					testFailed(testName);
				}
			}

		} catch (Exception e) {
			testException(testName, e);
		}
	}

	@AfterClass
	public void teardown() {
		try {
			extent.flush();
//			driver.close();
			System.out.println("Closing the browser");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
