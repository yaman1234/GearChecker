package variables;

import java.util.List;

import org.openqa.selenium.WebElement;

import utilities.DateOperations;

public class ActivityVariables {

//	variables
	public static String activityName = "Test Acitivity " + DateOperations.getCurrentTimestamp();
	public static String subActivityName = "Test Sub Acitivity " + DateOperations.getCurrentTimestamp();
	public static String logopath = "C:\\Users\\yamah022\\Desktop\\eclipse\\new-selenium-workspace\\gearchecker\\testdata\\photos\\test.png";
	
//	list
	public static List<WebElement> list_searchActivity;
}
