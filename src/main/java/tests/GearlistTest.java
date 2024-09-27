package tests;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.DropDown;
import utilities.UtilBase;
import utilities.WebElementLib;
import variables.ActivityVariables;
import variables.AdventureVariables;
import variables.GearlistVariables;
import variables.GlobalVariables;

public class GearlistTest extends UtilBase {

	@BeforeClass
	public void beforeClass() {
//		logging
		logger = LogManager.getLogger(GearlistTest.class);
		logger.info("Start :: GearlistTest ");
		driver.navigate().refresh();
	}

	@AfterClass
	public void afterClass() {
		logger.info("END :: GearlistTest ");
	}

	// Add New GearList
	@Test(priority = 3)
	public void gearlist_createGearlist() {
		String testName = "gearlist_createGearlist";
		test = extent.createTest(testName);

		try {

			pObj.navbar_link_gearlist().click();
			glObj.gearlist_button_addNew().click();
			glObj.newGearlist_icon_renameGearlist().click();
			glObj.newGearlist_input_renameGearlist().sendKeys(GearlistVariables.name);

//			GET AVAILABLE OPTIONS && SELECT OPTION FROM DROPDOWN
			List<String> adventureList = DropDown.getAllOptionText(glObj.newGearlist_options_adventure());
			logger.info("Adventures : " + adventureList);
			DropDown.selectOptionByVisibleText(glObj.newGearlist_options_adventure(), GearlistVariables.adventure);
			Thread.sleep(500);
//			GET AVAILABLE OPTIONS && SELECT OPTION FROM DROPDOWN
			List<String> activityList = DropDown.getAllOptionText(glObj.newGearlist_options_activity());
			logger.info("Activities : " + activityList);
			DropDown.selectOptionByVisibleText(glObj.newGearlist_options_activity(), GearlistVariables.activity);
			Thread.sleep(500);
//			GET AVAILABLE OPTIONS && SELECT OPTION FROM DROPDOWN
			List<String> subactivityList = DropDown.getAllOptionText(glObj.newGearlist_options_subActivity());
			logger.info("Sub Activities : " + subactivityList);
			DropDown.selectOptionByVisibleText(glObj.newGearlist_options_subActivity(), GearlistVariables.subactivity);
			Thread.sleep(500);
//			GET AVAILABLE OPTIONS && SELECT OPTION FROM DROPDOWN
			List<String> userList = DropDown.getAllOptionText(glObj.newGearlist_options_user());
			logger.info("User : " + userList);
			DropDown.selectOptionByVisibleText(glObj.newGearlist_options_user(), GearlistVariables.user);
			Thread.sleep(1000);
//			CLICK CREATE GEARLIST BUTTON 
			glObj.newGearlist_btn_createGearlist().click();
			Thread.sleep(3000);

//			GET THE AVAILABLE CATEGORIES
			List<WebElement> categories = glObj.newGearlist_categories();
			logger.info("Count of categories: " + categories.size());
			categories.forEach(item -> logger.info(item.getText()));

//			CLICK THE FIRST CATEGORY
			categories.get(0).click();
			Thread.sleep(1000);

//			CLICK THE FIRST CATEGORY [STORAGE]
			List<WebElement> subcategoriesNames = glObj.newGearlist_subcategories();
			logger.info("Count of subcategories: " + subcategoriesNames.size());
			subcategoriesNames.forEach(item -> logger.info(item.getText()));

//			CLICK THE FIRST SUB CATEGORY
			List<WebElement> subcategories = glObj.newGearlist_subcategories_addBtn();
			subcategories.get(0).click();
			Thread.sleep(1000);

//			GET THE PRODUCTS
			List<WebElement> products = glObj.newGearlist_subcategories_products();
			logger.info("Products Count : " + products.size());
			products.forEach(item -> logger.info(item.getText()));

//			ADD THE FIRST PRODUCT
			products.get(0).click();
			Thread.sleep(1000);

//			SAVE THE GEARLIST
			glObj.newGearlist_btn_save().click();
			Thread.sleep(4000);

//			CHECK THE PASS / FAIL CONDITION [check the URL]
			logger.info("CURRENT URL : " + driver.getCurrentUrl());
			if (driver.getCurrentUrl().equals("https://uat.gearchecker.io/admin/gear-lists")) {
				testPassed(testName);
			} else {
				testFailed(testName);
			}
		} catch (Exception e) {
			testException(testName, e);
		}
	}

	// LIST ALL GEARLIST ITEMS
	@Test(priority = 4)
	public void gearlist_listGrealistItems() {
		String testName = "gearlist_getAllGearList";
		test = extent.createTest(testName);

		try {
			pObj.navbar_link_gearlist().click();
			List<String> items = listAllGearLists();
			items.forEach(item -> logger.info(item));
			
			if (items.contains(GearlistVariables.name)) {
				testPassed(testName);
			}else {
				testFailed(testName);
			}
		} catch (Exception e) {
			testException(testName, e);
		}
	}

	public List<String> listAllGearLists() throws InterruptedException {
		List<String> gearlistItems = new ArrayList<String>();
		pObj.navbar_link_gearlist().click();
//		List<String> options = DropDown.getAllOptionText(glObj.gearlist_dropdown_rowPerPage());
//		logger.info(options);
//		DropDown.selectOptionByVisibleText(glObj.gearlist_dropdown_rowPerPage(), "50");
		Thread.sleep(3000);
//		HANDLE PAGINATION
		List<WebElement> rowElements;
		do {
//			GET THE NO OF ROWS
			rowElements = glObj.gearlist_names();
			logger.info("Table Row : " + rowElements.size());
			for (int i = 0; i < rowElements.size(); i++) {
				gearlistItems.add(rowElements.get(i).getText());
				logger.info(rowElements.get(i).getText());
			}

			try {
				// scroll into view
				jsDriver.executeScript("arguments[0].scrollIntoView();", glObj.gearlist_btn_nextPage());
				glObj.gearlist_btn_nextPage().click();
			} catch (Exception e) {
				logger.info("Reached Last Page");
				break;
			}

		} while (WebElementLib.doesElementExist(glObj.gearlist_btn_nextPage()));

		return gearlistItems;
	}

}
