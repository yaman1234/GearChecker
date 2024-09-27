package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import utilities.WebElementLib;

public class gearlist_pageObjects {

	public WebElement gearlist_button_addNew() {
		return WebElementLib.findMyElement("xpath", "//a[@class='btn btn-gear float-right']");
	}

	public WebElement gearlist_input_search() {
		return WebElementLib.findMyElement("xpath", "//input[@class='form-control']");
	}

//PAGINATION
	public WebElement gearlist_dropdown_rowPerPage() {
		return WebElementLib.findMyElement("xpath", "//select[@id='gear_lists-perPage']");
	}

	public WebElement gearlist_btn_nextPage() {
		return WebElementLib.findMyElement("xpath", "//button[contains(text(),'›')]");
	}

//	TABLE DATA
	public WebElement gearlist_table() {
		return WebElementLib.findMyElement("xpath", "//table[@id='table-gear_lists']");
	}

	public List<WebElement> gearlist_tableRows() {
		return WebElementLib.findMyElements("xpath",
				"//table[@id='table-gear_lists']/tbody/tr[contains(@id, 'gear_lists')]");
	}

	public List<WebElement> gearlist_names() {
		return WebElementLib.findMyElements("xpath",
				"//table[@id='table-gear_lists']/tbody/tr[contains(@id, 'gear_lists')]/td[4]");
	}

//	NEW GEARLIST

	public WebElement newGearlist_icon_renameGearlist() {
		return WebElementLib.findMyElement("xpath", "//i[@class='fas fa-edit my-auto py-auto svelte-i7vur8']");
	}

	public WebElement newGearlist_input_renameGearlist() {
		return WebElementLib.findMyElement("xpath", "//input[@role='textbox']");
	}
	
	
	public WebElement newGearlist_options_adventure() {
		return WebElementLib.findMyElement("xpath", "//select[@id='select-adventure']");
	}

	public WebElement newGearlist_options_activity() {
		return WebElementLib.findMyElement("xpath", "//select[@id='activity']");
	}

	public WebElement newGearlist_options_subActivity() {
		return WebElementLib.findMyElement("xpath", "//select[@id='subActivity']");
	}

	public WebElement newGearlist_options_user() {
		return WebElementLib.findMyElement("xpath", "//select[@id='userSelect']");
	}

	public WebElement newGearlist_toggle_isFeatured() {
		return WebElementLib.findMyElement("xpath", "//input[@id='is_featured']");
	}

	public WebElement newGearlist_btn_createGearlist() {
		return WebElementLib.findMyElement("xpath", "(//button[normalize-space()='Create Gearlist'])");
	}
	
//	SAVE GEARLIST BUTTON
	
	public WebElement newGearlist_btn_save() {
		return WebElementLib.findMyElement("xpath", "//button[@id='disableButton']");
	}
	
//	CATEGORIES
	public List<WebElement> newGearlist_categories(){
		return WebElementLib.findMyElements("xpath", "//*[@id='app']/section/div[1]/div/div[2]/div[2]/div[1]/div");
	}
	
	
//	SUB CATEGORIES
	
	public List<WebElement> newGearlist_subcategories(){
		return WebElementLib.findMyElements("xpath", "//*[@id='selection']/div/div/div/div/div[1]/div");
	}
	
	public List<WebElement> newGearlist_subcategories_addBtn(){
		return WebElementLib.findMyElements("xpath", "//*[@id='max_count']/div/button");
	}
	
//	PRODUCTS
	public List<WebElement> newGearlist_subcategories_products(){
		return WebElementLib.findMyElements("xpath", "//*[@id='selection']/div/div/div/div/div[2]/div[3]/div/div/div/div/div/div/h5");
	}
	
}
