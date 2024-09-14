package tests;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.DateOperations;
import utilities.RobotClass;
import utilities.UtilBase;
import utilities.WebElementLib;

public class SmokeTest extends UtilBase {

//	VARIABLES
	final String baseURL = "https://uat.gearchecker.io/";
	final String username = "superadmin@gearchecker.test";
	final String password = "12345678";
//	ACTIVITIES
//	variables
	String activityName = "Test Acitivity " + DateOperations.getCurrentTimestamp();
	String subActivityName = "Test Sub Acitivity " + DateOperations.getCurrentTimestamp();
	String logopath = "C:\\Users\\yamah022\\Desktop\\eclipse\\new-selenium-workspace\\gearchecker\\testdata\\photos\\test.png";

//	VARIABLES FOR ADVENTURE
	String adventureName = "Test Adventure " + DateOperations.getCurrentTimestamp();
	String[] activities = { "Biking", "Bonfire", "Fishing" };
	String country = "Nepal";
	String tag = "Nepal Adventure Hiking";
	String duration = "5";
	String latittude = "19.3425";
	String longitude = "20.5578";
	String description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.";
	String addBlogLink = "https://theworldtravelguy.com/ternate-indonesia-island/";
	String youtubeLink = "https://www.youtube.com/watch?v=TokXb-Mpc4k";
//GLOBAL VARIABLES
	List<WebElement> list_searchActivity;
	List<WebElement> list_searchAdventure;
//	TOAST MESSAGE
	String alert_success_created = "Activity created successfully!";
	String alert_success_deleted = "Activity deleted successfully!";

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

	// Add New Activity
	@Test(priority = 3)
	public void activity_createActivity() {
		String testName = "activity_createActivity";
		test = extent.createTest(testName);

		try {
			pObj.navbar_link_activity().click();
			pObj.activity_button_addActivity().click();
			Thread.sleep(3000);

			pObj.createActivity_input_name().sendKeys(activityName);
			pObj.createActivity_toggle_isFeatured().click();
			pObj.createActivity_button_uploadLogo().click();
			Thread.sleep(3000);

			// Copying and pasting file paths into the dialog for file upload
			RobotClass.copyPaste(logopath);

			Thread.sleep(9000);
			// scroll into view
			jsDriver.executeScript("arguments[0].scrollIntoView();", pObj.createActivity_button_save());
			Thread.sleep(500);
			pObj.createActivity_button_save().click();
			Thread.sleep(2000);

			/*
			 * HANDLE :: The name has already been taken.
			 */

//			check the pass / fail condition [check the toaster message]
			if (WebElementLib.doesElementExist(pObj.alert_toastMessage())) {
				String message = pObj.alert_toastMessage().getText();
				if (message.equals(alert_success_created)) {
					testPassed(testName);
				} else {
					testFailed(testName);
				}
			}

		} catch (Exception e) {
			testException(testName, e);
		}
	}

//	SEARCH ACTIVITY
	@Test(priority = 4)
	public void activity_searchActivity() {
		String testName = "activity_searchActivity";
		test = extent.createTest(testName);
//		VARIABLES
		String searchItem = activityName;
		try {
			pObj.navbar_link_activity().click();
			pObj.activity_input_search().sendKeys(searchItem);

			Thread.sleep(3000);
			list_searchActivity = pObj.activity_search_list();

			if (list_searchActivity.size() > 0) {
				System.out.println("Activity Found");
				WebElement element = list_searchActivity.get(0);
				element.click();
				Thread.sleep(2000);
				testPassed(testName);
			} else if (WebElementLib.doesElementExist(pObj.activity_search_notFound())) {
				System.out.println("Activity Not Found");
				testFailed(testName);
			}

//			System.out.println(activitiesFound.size());
//			for(int i = 0; i < activitiesFound.size(); i++) {
//				System.out.println(activitiesFound.get(i).getText());;
//			}

		} catch (Exception e) {
			testException(testName, e);
		}
	}

//	CREATE SUBACTIVITY
	@Test(priority = 5)
	public void activity_createSubActivity() {
		String testName = "activity_createSubActivity";
		test = extent.createTest(testName);

		try {

//			ENABLE THE SHOW SUB-ACTIVITIES TOGGLE
			pObj.activity_toggle_showSubActivities().click();

//			CLICK ADD SUB-ACTIVITY BUTTON
			pObj.activity_button_addSubactivity().click();
			Thread.sleep(2000);

//			CREATE SUB-ACTIVITY
			Thread.sleep(3000);

			pObj.createActivity_input_name().sendKeys(subActivityName);
			pObj.createActivity_button_uploadLogo().click();
			Thread.sleep(3000);

			// Copying and pasting file paths into the dialog for file upload
			RobotClass.copyPaste(logopath);

			Thread.sleep(9000);
			// scroll into view
			jsDriver.executeScript("arguments[0].scrollIntoView();", pObj.createSubActivity_button_save());
			Thread.sleep(500);
			pObj.createSubActivity_button_save().click();
			Thread.sleep(2000);

			/*
			 * HANDLE :: The name has already been taken.
			 */

//			check the pass / fail condition [check the toaster message]
			if (WebElementLib.doesElementExist(pObj.alert_toastMessage())) {
				String message = pObj.alert_toastMessage().getText();
				if (message.equals(alert_success_created)) {
					testPassed(testName);
				} else {
					testFailed(testName);
				}
			}

		} catch (Exception e) {
			testException(testName, e);
		}
	}

//	DELETE ACTIVITY
	@Test(priority = 7)
	public void activity_deleteActivity() {
		String testName = "activity_deleteActivity";
		test = extent.createTest(testName);

		try {

//			CLICK THE ACTIVITY
			WebElement element = list_searchActivity.get(0);
			element.click();
			Thread.sleep(2000);

//			CLICK DELETE BUTTON
//			System.out.println(activitiesFound.size());
//			for(int i = 0; i < activitiesFound.size(); i++) {
//				System.out.println(activitiesFound.get(i).getText());;
//			}
			pObj.activity_button_delete().click();
//			HANDLE THE JAVASCRIPT ALERT
			// Store the alert in a variable
			Alert alert = driver.switchTo().alert();

			// Store the alert in a variable for reuse
			String text = alert.getText();
			System.out.println("Alert Text: " + text);

			// Press the Ok button
			alert.accept();

			// check the pass / fail condition [check the toaster message]
			if (WebElementLib.doesElementExist(pObj.alert_toastMessage())) {
				String message = pObj.alert_toastMessage().getText();
				if (message.equals(alert_success_deleted)) {
					testPassed(testName);
				} else {
					testFailed(testName);
				}
			}

		} catch (Exception e) {
			testException(testName, e);
		}
	}

//	ADVENTURE
	@Test(priority = 8)
	public void adventure_createAdventure() {
		String testName = "adventure_createAdventure";
		test = extent.createTest(testName);

		try {
			pObj.navbar_link_adventure().click();
			pObj.adventure_button_addNew().click();
			Thread.sleep(3000);

			pObj.createAdventure_toggle_isFeatured().click();
			pObj.createAdventure_button_uploadLogo().click();
			Thread.sleep(1000);

			// Copying and pasting file paths into the dialog for file upload
			RobotClass.copyPaste(logopath);

			Thread.sleep(5000);

//		ENTER NAME
			pObj.createAdventure_input_name().sendKeys(adventureName);

//		SELECT ACTIVITIES

			System.out.println("activities : " + activities.length);
			for (int i = 0; i < activities.length; i++) {
				// scroll into view
				jsDriver.executeScript("arguments[0].scrollIntoView();", pObj.createAdventure_dropdown_activities());
				pObj.createAdventure_dropdown_activities().click();
				System.out.println(activities[i]);
				pObj.createAdventure_dropdown_activities().sendKeys(activities[i]);
				Thread.sleep(2000);
				pObj.createAdventure_dropdown_activities().sendKeys(Keys.ENTER);
				Thread.sleep(2000);

			}

//		SELECT COUNTRY
			pObj.createAdventure_dropdown_country().click();
			pObj.createAdventure_input_country().sendKeys(country);
			pObj.createAdventure_input_country().sendKeys(Keys.ENTER);

//			ENTER TAG
			pObj.createAdventure_input_tag().sendKeys(tag);
//			ENTER DURATION
			pObj.createAdventure_input_duration().sendKeys(duration);
//			ENTER LATITUDE
			pObj.createAdventure_input_latitude().sendKeys(latittude);
//			ENTER LONGITUDE
			pObj.createAdventure_input_longitude().sendKeys(longitude);
//			ENTER DESCRIPTION
			pObj.createAdventure_textarea_description().sendKeys(description);
//			ADD BLOG LINKS
			pObj.createAdventure_button_addBlogLink().click();
			Thread.sleep(3000);
			pObj.createAdventure_input_addBlogLink().sendKeys(addBlogLink);
			pObj.createAdventure_button_populateAddBlogLink().click();
			Thread.sleep(2000);
			jsDriver.executeScript("arguments[0].scrollIntoView();", pObj.createAdventure_button_add_BlogLink());
			pObj.createAdventure_button_add_BlogLink().click();
			Thread.sleep(3000);
//			ADD YOUTUBE LINKS
			pObj.createAdventure_input_youtubeLink().sendKeys(youtubeLink);
			pObj.createAdventure_button_populateYoutubeLink().click();
			Thread.sleep(3000);

//			CLICK SAVE CHANGES
			jsDriver.executeScript("arguments[0].scrollIntoView();", pObj.createAdventure_button_saveChanges());
			Thread.sleep(1000);
			pObj.createAdventure_button_saveChanges().click();
			Thread.sleep(3000);
			/*
			 * HANDLE :: The name has already been taken.
			 */
			System.out.println(driver.getCurrentUrl());

			if (driver.getCurrentUrl().equals("https://uat.gearchecker.io/admin/adventures")) {
				testPassed(testName);
			} else {
				testFailed(testName);
			}

//			wait.wait_element_present(pObj.alert_toastMessage());
////			check the pass / fail condition [check the toaster message]
//			if (WebElementLib.doesElementExist(pObj.alert_toastMessage())) {
//				String message = pObj.alert_toastMessage().getText();
//				if (message.equals("Adventure created successfully!")) {
//					testPassed(testName);
//				} else {
//					testFailed(testName);
//				}
//			}

		} catch (Exception e) {
			testException(testName, e);
		}
	}

//	SEARCH ADVENTURE
	@Test(priority = 9)
	public void adventure_searchAdventure() {
		String testName = "adventure_searchAdventure";
		test = extent.createTest(testName);
//		adventureName = "Test Adventure 0914 114022";
		try {
			pObj.navbar_link_adventure().click();
			pObj.adventure_input_search().sendKeys(adventureName);
			Thread.sleep(5000);

			list_searchAdventure = pObj.adventure_search_list();
			System.out.println(list_searchAdventure);
			if (list_searchAdventure.size() > 0) {
				System.out.println("Adventure Found");
				String lvelement = list_searchAdventure.get(0).getText();
				System.out.println(lvelement);
				Thread.sleep(2000);
				testPassed(testName);
			} else if (WebElementLib.doesElementExist(pObj.adventure_search_notFound())) {
				System.out.println("Adventure Not Found");
				testFailed(testName);
			}

		} catch (Exception e) {
			testException(testName, e);
		}
	}

//	VIEW ADEVENTURE
	@Test(priority = 10)
	public void adventure_viewAdventure() {
		String testName = "adventure_viewAdventure";
		test = extent.createTest(testName);

		try {

			pObj.adventure_link_options().click();
			Thread.sleep(1000);
			pObj.adventure_link_view().click();
			Thread.sleep(3000);

//			pass condition
			if (WebElementLib.doesElementExist(pObj.showAdventure_modal_header())) {
				testPassed(testName);
			} else {
				testFailed(testName);
			}

		} catch (Exception e) {
			testException(testName, e);
		}
	}

//		sample method
//		@Test(priority = 999)
	public void sampleTest() {
		String testName = "sampleTest";
		test = extent.createTest(testName);

		try {
//				pass condition
			if (WebElementLib.doesElementExist(pObj.link_dashboard_gearchecker())) {
				testPassed(testName);
			} else {
				testFailed(testName);
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
