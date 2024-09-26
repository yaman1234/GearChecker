package testRunner;

import org.testng.TestNG;

import tests.ActivityTest;
import tests.AdventureTest;
import tests.GearlistTest;
import tests.LoginTest;
import tests.Setup;
import tests.TearDown;

public class TestRunner {

	public static void main(String[] args) {

		// Step 1: Setup the environment
		Setup.setup();

		// Step 2: Create an instance of TestNG
		TestNG testng = new TestNG();

		// Step 3: Specify the test classes to run
		testng.setTestClasses(new Class[] { LoginTest.class, ActivityTest.class, AdventureTest.class, GearlistTest.class });

		// Step 4: Run the test classes
		testng.run();

		// Step 5: Perform cleanup actions
		TearDown.teardown();
	}

}
