package tests;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.RobotClass;
import utilities.UtilBase;
import utilities.WebElementLib;
import variables.AdventureVariables;

public class AdventureTest extends UtilBase {

	@BeforeClass
	public void beforeClass() {
//		logging
		logger = LogManager.getLogger(AdventureTest.class);
		logger.info("Start :: AdventureTest ");

	}

	@AfterClass
	public void afterClass() {
		logger.info("END :: AdventureTest ");
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
			RobotClass.copyPaste(AdventureVariables.logopath);
			Thread.sleep(5000);

//		ENTER NAME
			pObj.createAdventure_input_name().sendKeys(AdventureVariables.adventureName);

//		SELECT ACTIVITIES

			logger.info("activities : " + AdventureVariables.activities.length);
			for (int i = 0; i < AdventureVariables.activities.length; i++) {
				// scroll into view
				jsDriver.executeScript("arguments[0].scrollIntoView();", pObj.createAdventure_dropdown_activities());
				pObj.createAdventure_dropdown_activities().click();
				logger.info(AdventureVariables.activities[i]);
				pObj.createAdventure_dropdown_activities().sendKeys(AdventureVariables.activities[i]);
				Thread.sleep(2000);
				pObj.createAdventure_dropdown_activities().sendKeys(Keys.ENTER);
				Thread.sleep(2000);

			}

//		SELECT COUNTRY
			pObj.createAdventure_dropdown_country().click();
			pObj.createAdventure_input_country().sendKeys(AdventureVariables.country);
			pObj.createAdventure_input_country().sendKeys(Keys.ENTER);

//			ENTER TAG
			pObj.createAdventure_input_tag().sendKeys(AdventureVariables.tag);
//			ENTER DURATION
			pObj.createAdventure_input_duration().sendKeys(AdventureVariables.duration);
//			ENTER LATITUDE
			pObj.createAdventure_input_latitude().sendKeys(AdventureVariables.latittude);
//			ENTER LONGITUDE
			pObj.createAdventure_input_longitude().sendKeys(AdventureVariables.longitude);
//			ENTER DESCRIPTION
			pObj.createAdventure_textarea_description().sendKeys(AdventureVariables.description);
//			ADD BLOG LINKS
			pObj.createAdventure_button_addBlogLink().click();
			Thread.sleep(3000);
			pObj.createAdventure_input_addBlogLink().sendKeys(AdventureVariables.addBlogLink);
			pObj.createAdventure_button_populateAddBlogLink().click();
			Thread.sleep(2000);
			jsDriver.executeScript("arguments[0].scrollIntoView();", pObj.createAdventure_button_add_BlogLink());
			pObj.createAdventure_button_add_BlogLink().click();
			Thread.sleep(3000);
//			ADD YOUTUBE LINKS
			pObj.createAdventure_input_youtubeLink().sendKeys(AdventureVariables.youtubeLink);
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
			logger.info(driver.getCurrentUrl());

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
			pObj.adventure_input_search().sendKeys(AdventureVariables.adventureName);
			Thread.sleep(5000);

			AdventureVariables.list_searchAdventure = pObj.adventure_search_list();
			logger.info(AdventureVariables.list_searchAdventure);
			if (AdventureVariables.list_searchAdventure.size() > 0) {
				logger.info("Adventure Found");
				String lvelement = AdventureVariables.list_searchAdventure.get(0).getText();
				logger.info(lvelement);
				Thread.sleep(2000);
				testPassed(testName);
			} else if (WebElementLib.doesElementExist(pObj.adventure_search_notFound())) {
				logger.info("Adventure Not Found");
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

}
