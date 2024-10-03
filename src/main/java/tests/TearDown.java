package tests;

import org.testng.annotations.AfterClass;

import utilities.UtilBase;

public class TearDown extends UtilBase {

	
	@AfterClass (alwaysRun = true)
	public static void teardown() {
		try {
			extent.flush();
//			driver.close();
			System.out.println("Closing the browser");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
