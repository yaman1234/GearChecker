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
	
	public WebElement gearlist_dropdown_rowPerPage() {
		return WebElementLib.findMyElement("xpath", "//select[@id='gear_lists-perPage']");
	}
	
	public WebElement gearlist_table() {
		return WebElementLib.findMyElement("xpath", "//table[@id='table-gear_lists']");
	}
	
	public List<WebElement> gearlist_tableRows() {
		return WebElementLib.findMyElements("xpath", "//table[@id='table-gear_lists']/tbody/tr[contains(@id, 'gear_lists')]");
	}
}
