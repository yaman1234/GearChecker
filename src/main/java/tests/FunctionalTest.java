package tests;

import utilities.UtilBase;

public class FunctionalTest extends UtilBase {

	
//	@Test (priority = 100)
public void methodName_test() {
	try {
		test = extent.createTest("methodName_test");
		logger.info("START	 : methodName_test  ---------------------------------------");
//			Initialize variable with expected values
//			Hit the API
//			Initialize variable with actual values
//			Run the Test
		if (true) {
			logger.info("SUCCESS : methodName_test");
			test.pass("methodName_test");
			test.addScreenCaptureFromPath(capture("methodName_test_success"), "methodName_test ");
//		 Use JavaScriptExecutor to scroll the element into view
			jsDriver.executeScript("arguments[0].scrollIntoView({block: 'center'});", pqc_po.salesPrice_table());
		} else {
			logger.info("ERROR : methodName_test ");
			test.fail("methodName_test");
			test.addScreenCaptureFromPath(capture("methodName_test_failed"), "methodName_test");
			Assert.assertTrue(false);
		}
		logger.info("END	 : methodName_test	---------------------------------------");
	} catch (Exception e) {
		logger.severe("EXCEPTION: methodName_test ");
		test.fail("methodName_test");
		test.addScreenCaptureFromPath(capture("methodName_test_failed"), "methodName_test");
		e.printStackTrace();
		Assert.assertTrue(false);
	}
}
}
