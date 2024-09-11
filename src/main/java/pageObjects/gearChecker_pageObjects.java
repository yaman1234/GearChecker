package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import utilities.WebElementLib;

public class gearChecker_pageObjects {


	/***************************** LOGIN PAGE ***************************/
	public WebElement input_email() {
		return WebElementLib.findMyElement("xpath", "//input[@id='email']");
	}

	public WebElement input_password() {
		return WebElementLib.findMyElement("xpath", "//input[@id='password']");
	}
	
	public WebElement button_login() {
		return WebElementLib.findMyElement("xpath", "//button[normalize-space()='Log in']");
	}
	
	public WebElement message_login_failed() {
		return WebElementLib.findMyElement("xpath", "//li[normalize-space()='These credentials do not match our records.']");
	}
	
	
	/***************************** NAVBAR ***************************/
	public WebElement navbar_link_gearlist() {
		return WebElementLib.findMyElement("xpath", "//p[normalize-space()='Gear List']");
	}
	
	public WebElement navbar_link_activity() {
		return WebElementLib.findMyElement("xpath", "//p[normalize-space()='Activity']");
	}
	
	public WebElement navbar_link_adventure() {
		return WebElementLib.findMyElement("xpath", "//p[normalize-space()='Adventure']");
	}
	
	
	
	/***************************** DASHBOARD ***************************/
	public WebElement link_dashboard_gearchecker() {
		return WebElementLib.findMyElement("xpath", "//p[normalize-space()='gearchecker']");
	}
	
	
	/***************************** ACTIVITY ***************************/
	public WebElement activity_toggle_showSubActivities() {
		return WebElementLib.findMyElement("xpath", "//input[@id='flexSwitchCheckDefault']");
	}
	
	public WebElement activity_button_addActivity() {
		return WebElementLib.findMyElement("xpath", "//span[normalize-space()='Activity']");
	}
	
	public WebElement activity_button_addSubactivity() {
		return WebElementLib.findMyElement("xpath", "//span[normalize-space()='Subactivity']");
	}
	
	public WebElement activity_button_delete() {
		return WebElementLib.findMyElement("xpath", "//span[normalize-space()='Delete']");
	}
	public WebElement activity_button_update() {
		return WebElementLib.findMyElement("xpath", "//span[normalize-space()='Update']");
	}
	
	
//	search activity
	public WebElement activity_input_search() {
		return WebElementLib.findMyElement("xpath", "//input[contains(@class,'form-control me-2')]");
	}
	
	public WebElement activity_search_notFound() {
		return WebElementLib.findMyElement("xpath", "//span[normalize-space()='No activities available']");
	}
	
	public List<WebElement> activity_search_list() {
		return WebElementLib.findMyElements("xpath", "//span[@class='parent text-gear']");
	}
	
//	create activity
	public WebElement createActivity_input_name() {
		return WebElementLib.findMyElement("xpath", "//input[contains(@placeholder,'Enter Name')]");
	}
	
	public WebElement createActivity_button_uploadLogo() {
		return WebElementLib.findMyElement("xpath", "//div[@class='dotted-box text-gear']");
	}
	public WebElement createActivity_toggle_isFeatured() {
		return WebElementLib.findMyElement("xpath", "//input[@id='is_featured']");
	}
	
	public WebElement createActivity_button_save() {
		return WebElementLib.findMyElement("xpath", "//*[@id='form']/div/div[5]/button[2]");
	}
//	XPATH FOR THE SAVE BUTTON FOR SUB-ACTIVITY IS DIFFERENT
	public WebElement createSubActivity_button_save() {
		return WebElementLib.findMyElement("xpath", "//*[@id='form']/div/div[4]/button[2]");
	}

	// Toaster alert message
	public WebElement alert_toastMessage() {
		return WebElementLib.findMyElement("xpath", "//div[@role='alert']");
	}
	
	
}
