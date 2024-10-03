package variables;

import java.util.List;

import org.openqa.selenium.WebElement;

import utilities.DateOperations;

public class ActivityVariables {

//	variables
	public static String activityName = "Test Activity " + DateOperations.getCurrentTimestamp();
	public static String activityNameUpdated = "Test Activity Updated";
	public static String subActivityName = "Test Sub Activity " + DateOperations.getCurrentTimestamp();
	public static String logopath = "C:\\Users\\yamah022\\Desktop\\eclipse\\new-selenium-workspace\\gearchecker\\testdata\\photos\\test.png";
	
//	list
	public static List<String> list_allActivities;
	public static List<WebElement> list_searchActivity;
	
	public static String getLogopath() {
		return (System.getProperty("user.dir")+ "\\testdata\\photos\\test.png");
	}
}
