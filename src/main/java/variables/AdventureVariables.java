package variables;

import java.util.List;

import org.openqa.selenium.WebElement;

import utilities.DateOperations;

public class AdventureVariables {
	
//	VARIABLES FOR ADVENTURE
	public static String adventureName = "Test Adventure " + DateOperations.getCurrentTimestamp();
	public static String[] activities = { "Biking", "Bonfire", "Fishing" };
	public static String country = "Nepal";
	public static String tag = "Nepal Adventure Hiking";
	public static String duration = "5";
	public static String latittude = "19.3425";
	public static String longitude = "20.5578";
	public static String description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.";
	public static String addBlogLink = "https://theworldtravelguy.com/ternate-indonesia-island/";
	public static String youtubeLink = "https://www.youtube.com/watch?v=TokXb-Mpc4k";
	
//	LIST
	public static List<WebElement> list_searchAdventure;
	
	public static String logopath = "C:\\Users\\yamah022\\Desktop\\eclipse\\new-selenium-workspace\\gearchecker\\testdata\\photos\\test.png";
	
}
