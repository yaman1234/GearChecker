package tests;

import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.UtilBase;

public class Setup extends UtilBase {

	@BeforeClass
	public static void setup() {
		try {
			initialiseDriver();
			
//			logger.info("Initializing the browser");

//			Extent Report
			ExtentSparkReporter spark = new ExtentSparkReporter("testReports/" + "RunnerReport" + ".html");
			extent = new ExtentReports();
			extent.attachReporter(spark);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
