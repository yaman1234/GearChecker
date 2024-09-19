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
		return WebElementLib.findMyElement("xpath",
				"//li[normalize-space()='These credentials do not match our records.']");
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

	public WebElement createActivity_toggle_isFeatured() {
		return WebElementLib.findMyElement("xpath", "//input[@id='is_featured']");
	}

	public WebElement createActivity_button_uploadLogo() {
		return WebElementLib.findMyElement("xpath", "//div[@class='dotted-box text-gear']");
	}

	public WebElement createActivity_button_save() {
		return WebElementLib.findMyElement("xpath", "//*[@id='form']/div/div[5]/button[2]");
	}

//	XPATH FOR THE SAVE BUTTON FOR SUB-ACTIVITY IS DIFFERENT
	public WebElement createSubActivity_button_save() {
		return WebElementLib.findMyElement("xpath", "//*[@id='form']/div/div[4]/button[2]");
	}

	/***************************** TOASTER MESSAGE ***************************/
	public WebElement alert_toastMessage() {
		return WebElementLib.findMyElement("xpath", "//div[@role='alert']");
	}

	/***************************** ADVENTURE ***************************/
	public WebElement adventure_button_addNew() {
		return WebElementLib.findMyElement("xpath", "//a[@type='button']");
	}
//	SEARCH ADVENTURE INPUT
	public WebElement adventure_input_search() {
		return WebElementLib.findMyElement("xpath", "//input[@class='bg-gray-50 border border-gray-300 text-gray-900 text-sm focus:ring-primary-500 focus:border-primary-500 block w-full pl-10 p-2']");
	}
//	NO ADVENTURES AVAILABLE
	public WebElement adventure_search_notFound() {
		return WebElementLib.findMyElement("xpath", "//p[normalize-space()='No adventures available']");
	}
//	SEARCH RESULT ELEMENTS
	public List<WebElement>  adventure_search_list() {
		return WebElementLib.findMyElements("xpath", "//body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div");
	}
//	OPTIONS
	public WebElement  adventure_link_options() {
		return WebElementLib.findMyElement("xpath", "//body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/i[1]");
	}
//	EDIT ADVENTURE
	public WebElement  adventure_link_edit() {
		return WebElementLib.findMyElement("xpath", "//span[normalize-space()='Edit']");
	}
//	VIEW ADVENTURE
	public WebElement  adventure_link_view() {
		return WebElementLib.findMyElement("xpath", "//span[normalize-space()='View']");
	}
//	DELETE ADVENTURE
	public WebElement  adventure_link_delete() {
		return WebElementLib.findMyElement("xpath", "//span[normalize-space()='Delete']");
	}
	
//	SHOW ADVENTURE MODAL
	public WebElement  showAdventure_modal_header() {
		return WebElementLib.findMyElement("xpath", "//div[@class='modal-header']");
	}
	
	
//	CREATE ADVENTURE
	public WebElement createAdventure_input_name() {
		return WebElementLib.findMyElement("xpath", "//input[@id='name']");
	}

	public WebElement createAdventure_toggle_isFeatured() {
		return WebElementLib.findMyElement("xpath", "//input[@id='is_featured']");
	}

	public WebElement createAdventure_button_uploadLogo() {
		return WebElementLib.findMyElement("xpath", "//div[@class='dotted-box text-gear']");
	}

	public WebElement createAdventure_dropdown_activities() {
		return WebElementLib.findMyElement("xpath", "//input[@role='searchbox']");
	}

//	DROPDOWN ELEMENT FOR COUNTRY
	public WebElement createAdventure_dropdown_country() {
		return WebElementLib.findMyElement("xpath", "//span[@id='select2-country-select-container']");
	}

//	INPUT ELEMENT FOR COUNTRY
	public WebElement createAdventure_input_country() {
		return WebElementLib.findMyElement("xpath",
				"//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']");
	}

	public WebElement createAdventure_input_tag() {
		return WebElementLib.findMyElement("xpath", "//*[@id=\"form\"]/div/div[1]/div/div[7]/input");
	}

	public WebElement createAdventure_input_duration() {
		return WebElementLib.findMyElement("xpath", "//*[@id='duration']");
	}

	public WebElement createAdventure_input_latitude() {
		return WebElementLib.findMyElement("xpath", "//*[@id=\"latitude\"]");
	}

	public WebElement createAdventure_input_longitude() {
		return WebElementLib.findMyElement("xpath", "//*[@id=\"longitude\"]");
	}

	public WebElement createAdventure_textarea_description() {
		return WebElementLib.findMyElement("xpath", "//*[@id=\"form\"]/div/div[1]/div/div[13]/textarea");
	}

//	ADD BLOG LINK
	public WebElement createAdventure_button_addBlogLink() {
		return WebElementLib.findMyElement("xpath", "//button[normalize-space()='Add Blog Link']");
	}

	public WebElement createAdventure_input_addBlogLink() {
		return WebElementLib.findMyElement("xpath", "//input[@placeholder='Enter Blog Link here']");
	}

	public WebElement createAdventure_button_populateAddBlogLink() {
		return WebElementLib.findMyElement("xpath", "//*[@id=\"createModal\"]/div/div/div[2]/form/div/div[2]/button");
	}

//	ADD BUTTON
	public WebElement createAdventure_button_add_BlogLink() {
		return WebElementLib.findMyElement("xpath", "//button[normalize-space()='Add']");
	}

//	ADD YOUTUBE LINKS INPUT 
	public WebElement createAdventure_input_youtubeLink() {
		return WebElementLib.findMyElement("xpath", "//input[contains(@placeholder,'Enter Youtube Link here')]");
	}

//	POPULATE ADD YOUTUBE LINK
	public WebElement createAdventure_button_populateYoutubeLink() {
		return WebElementLib.findMyElement("xpath", "//*[@id=\"form\"]/div/div[2]/div/div[4]/div[2]/button");
	}

//	SAVE CHANGES BUTTON
	public WebElement createAdventure_button_saveChanges() {
		return WebElementLib.findMyElement("xpath", "//button[@id='disableButton']");
	}
//	CLOSE THE SHOW ADVENTURE MODAL
	public WebElement showAdventure_button_close() {
		return WebElementLib.findMyElement("xpath", "//button[@aria-label='Close']");
	}
	

}
