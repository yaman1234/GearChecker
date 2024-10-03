package tests;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.RobotClass;
import utilities.UtilBase;
import utilities.WebElementLib;
import variables.ActivityVariables;
import variables.GlobalVariables;

public class ActivityTest extends UtilBase {

	/*------------------------------------------------------------------------
	File        : ActivityTest.java
	Purpose     :
	Syntax      :
	Description : This File contains the tests to performed for ACTION 
	Author(s)   : yaman
	Created     : 
	Notes       :
	------------------------------------------------------------------------------------------
	date         version    author     description
	-----------------------------------------------------------------------------------------
	26/07/2018   v1.01       ananda    Created.
	
	-------------------------------------------------------------------------------------*/

	@BeforeClass
	public void beforeClass() {
//		logging
		logger = LogManager.getLogger(ActivityTest.class);
		logger.info("Start :: ActivityTest ");
		driver.navigate().refresh();

	}

	@AfterClass
	public void afterClass() {
		logger.info("END :: ActivityTest ");
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

//			GET LIST OF ALL AVAILABLE ACTIVITIES
			logger.info("LIST OF ACTIVITIES :: ");
			List<WebElement> activitySearchList = pObj.activity_search_list();
			ActivityVariables.list_allActivities = activitySearchList.stream().map(WebElement::getText)
					.collect(Collectors.toList());
			ActivityVariables.list_allActivities.forEach(item -> {
				logger.info(item);
			});

//			ENTER THE ACTIVITY IN THE SEARCH BAR
			pObj.createActivity_input_name().sendKeys(ActivityVariables.activityName);
			logger.info(ActivityVariables.activityName);
			pObj.createActivity_toggle_isFeatured().click();
			pObj.createActivity_button_uploadLogo().click();
			Thread.sleep(3000);

			// Copying and pasting file paths into the dialog for file upload
			RobotClass.copyPaste(ActivityVariables.getLogopath());
			Thread.sleep(9000);

			// scroll into view
			jsDriver.executeScript("arguments[0].scrollIntoView();", pObj.createActivity_button_save());
			Thread.sleep(500);
			pObj.createActivity_button_save().click();
			Thread.sleep(2000);

//				check the pass / fail condition [check the toaster message]
			if (WebElementLib.doesElementExist(pObj.alert_toastMessage())) {
				String message = pObj.alert_toastMessage().getText();
				logger.info(message);
				if (message.contains(GlobalVariables.alert_success_created)) {
					testPassed(testName);
				} else {
					testFailed(testName);
				}
			}
		} catch (Exception e) {
			testException(testName, e);
		}
	}

//		SEARCH ACTIVITY
	@Test(priority = 4)
	public void activity_searchActivity() {
		String testName = "activity_searchActivity";
		test = extent.createTest(testName);
//			VARIABLES
		String searchItem = ActivityVariables.activityName;
		try {
			pObj.navbar_link_activity().click();
			pObj.activity_input_search().sendKeys(searchItem);

			Thread.sleep(3000);
			ActivityVariables.list_searchActivity = pObj.activity_search_list();

			if (ActivityVariables.list_searchActivity.size() > 0) {
				logger.info("Activity Found");
				WebElement element = ActivityVariables.list_searchActivity.get(0);
				element.click();
				Thread.sleep(2000);
				testPassed(testName);
			} else if (WebElementLib.doesElementExist(pObj.activity_search_notFound())) {
				logger.info("Activity Not Found");
				testFailed(testName);
			}

//				logger.info(activitiesFound.size());
//				for(int i = 0; i < activitiesFound.size(); i++) {
//					logger.info(activitiesFound.get(i).getText());;
//				}

		} catch (Exception e) {
			testException(testName, e);
		}
	}

//	UPDATE ACTIVITY
	@Test(priority = 4)
	public void activity_updateActivity() {

		String testName = "activity_updateActivity";
		test = extent.createTest(testName);
//		VARIABLES
		String searchItem = ActivityVariables.activityName;
		String newNameActivity = "Activity name updated";
		logger.info("name of activity before update : " + searchItem);
		logger.info("name of activity after update : " + newNameActivity);

		try {
			pObj.navbar_link_activity().click();
			pObj.activity_input_search().sendKeys(searchItem);

			Thread.sleep(3000);
			ActivityVariables.list_searchActivity = pObj.activity_search_list();

			if (ActivityVariables.list_searchActivity.size() > 0) {
				logger.info("Activity Found");
				WebElement element = ActivityVariables.list_searchActivity.get(0);
				element.click();
				Thread.sleep(2000);

//				UPDATE THE ACTIVITY NAME
				pObj.activity_button_update().click();
				Thread.sleep(1000);

				pObj.createActivity_input_name().clear();
				pObj.createActivity_input_name().sendKeys(newNameActivity);

//			SCROLL INTO THE SAVE BUTTON AND CLICK SAVE
				jsDriver.executeScript("arguments[0].scrollIntoView();", pObj.createActivity_button_save());
				Thread.sleep(500);
				pObj.createActivity_button_save().click();
				Thread.sleep(2000);

//				VERIFY THE NAME OF ACTIVITY IS UPDATED SUCCESSFULLY
				pObj.navbar_link_activity().click();
				pObj.activity_input_search().sendKeys(newNameActivity);
				Thread.sleep(3000);

				ActivityVariables.list_searchActivity = pObj.activity_search_list();

				if (ActivityVariables.list_searchActivity.size() > 0) {

					logger.info("Activity Found");
					WebElement newElement = ActivityVariables.list_searchActivity.get(0);
					logger.info(newElement.getText());
					newElement.click();
					Thread.sleep(2000);

					logger.info("Test passed : Activity Update");
					testPassed(testName);

				} else if (WebElementLib.doesElementExist(pObj.activity_search_notFound())) {
					logger.info("Activity Not Found");
					testFailed(testName);
				}

			} else if (WebElementLib.doesElementExist(pObj.activity_search_notFound())) {
				logger.info("Activity Not Found");
				testFailed(testName);
			}

//			logger.info(activitiesFound.size());
//			for(int i = 0; i < activitiesFound.size(); i++) {
//				logger.info(activitiesFound.get(i).getText());;
//			}

		} catch (Exception e) {
			testException(testName, e);
		}
	}

//		CREATE SUBACTIVITY
	@Test(priority = 5)
	public void activity_createSubActivity() {
		String testName = "activity_createSubActivity";
		test = extent.createTest(testName);

		try {

//				ENABLE THE SHOW SUB-ACTIVITIES TOGGLE
			pObj.activity_toggle_showSubActivities().click();

//				CLICK ADD SUB-ACTIVITY BUTTON
			pObj.activity_button_addSubactivity().click();
			Thread.sleep(2000);

//				CREATE SUB-ACTIVITY
			Thread.sleep(3000);

			pObj.createActivity_input_name().sendKeys(ActivityVariables.subActivityName);
			pObj.createActivity_button_uploadLogo().click();
			Thread.sleep(3000);

			// Copying and pasting file paths into the dialog for file upload
			RobotClass.copyPaste(ActivityVariables.getLogopath());

			Thread.sleep(9000);
			// scroll into view
			jsDriver.executeScript("arguments[0].scrollIntoView();", pObj.createSubActivity_button_save());
			Thread.sleep(500);
			pObj.createSubActivity_button_save().click();
			Thread.sleep(2000);

			/*
			 * HANDLE :: The name has already been taken.
			 */

//				check the pass / fail condition [check the toaster message]
			if (WebElementLib.doesElementExist(pObj.alert_toastMessage())) {
				String message = pObj.alert_toastMessage().getText();
				if (message.contains(GlobalVariables.alert_success_created)) {
					testPassed(testName);
				} else {
					testFailed(testName);
				}
			}

		} catch (Exception e) {
			testException(testName, e);
		}
	}

//		DELETE ACTIVITY
	@Test(priority = 7)
	public void activity_deleteActivity() {
		String testName = "activity_deleteActivity";
		test = extent.createTest(testName);

		try {

//				CLICK THE ACTIVITY
			WebElement element = ActivityVariables.list_searchActivity.get(0);
			element.click();
			Thread.sleep(2000);

//				CLICK DELETE BUTTON
//				logger.info(activitiesFound.size());
//				for(int i = 0; i < activitiesFound.size(); i++) {
//					logger.info(activitiesFound.get(i).getText());;
//				}
			pObj.activity_button_delete().click();
//				HANDLE THE JAVASCRIPT ALERT
			// Store the alert in a variable
			Alert alert = driver.switchTo().alert();

			// Store the alert in a variable for reuse
			String text = alert.getText();
			logger.info("Alert Text: " + text);

			// Press the Ok button
			alert.accept();

			// check the pass / fail condition [check the toaster message]
			if (WebElementLib.doesElementExist(pObj.alert_toastMessage())) {
				String message = pObj.alert_toastMessage().getText();
				if (message.contains(GlobalVariables.alert_success_deleted)) {
					testPassed(testName);
				} else {
					testFailed(testName);
				}
			}

		} catch (Exception e) {
			testException(testName, e);
		}
	}

}
