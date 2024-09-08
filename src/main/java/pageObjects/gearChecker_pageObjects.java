package pageObjects;

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
	
	
	/***************************** DASHBOARD ***************************/
	public WebElement link_dashboard_gearchecker() {
		return WebElementLib.findMyElement("xpath", "//p[normalize-space()='gearchecker']");
	}
	
	
	
}
