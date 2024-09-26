package tests;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.DropDown;
import utilities.TableData;
import utilities.UtilBase;

public class GearlistTest extends UtilBase {

	@BeforeClass
	public void beforeClass() {
//		logging
		logger = LogManager.getLogger(GearlistTest.class);
		logger.info("Start :: GearlistTest ");

	}

	@AfterClass
	public void afterClass() {
		logger.info("END :: GearlistTest ");
	}

	// Add New GearList
	@Test(priority = 3)
	public void gearlist_getAllGearList() {
		String testName = "gearlist_getAllGearList";
		test = extent.createTest(testName);

		try {

			pObj.navbar_link_gearlist().click();
			glObj.gearlist_button_addNew().click();

		} catch (Exception e) {
			testException(testName, e);
		}
	}

	public void listAllGearLists() throws InterruptedException {
		pObj.navbar_link_gearlist().click();
		List<String> options = DropDown.getAllOptionText(glObj.gearlist_dropdown_rowPerPage());
		logger.info(options);
		DropDown.selectOptionByVisibleText(glObj.gearlist_dropdown_rowPerPage(), "50");
		Thread.sleep(3000);

		int rowCount = TableData.getRowCount(glObj.gearlist_table());
		logger.info("Total Rows : " + rowCount);

//		GET THE NO OF ROWS
		List<WebElement> rowElements = glObj.gearlist_tableRows();
		logger.info(rowElements.size());
		for (int i = 0; i < rowElements.size(); i++) {
			logger.info(rowElements.get(i).getText());
		}
	}

}
