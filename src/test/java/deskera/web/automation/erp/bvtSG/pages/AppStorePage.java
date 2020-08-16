package deskera.web.automation.erp.bvtSG.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AppStorePage {

	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;

	public AppStorePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}

	/******************************* CREATE BANK PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath= "//*[@id='container-1']/dt-navbar/div/ul/li[12]/a")
	
	private WebElement appsTab;
	private static String pageTitleText = "Deskera - App Store";

	/******************************* APPS Object Manipulation Methods *******************/

	public void openURL(String URL) {
		driver.get(URL);
	}
	public void verifyPageTitle() {
		Assert.assertEquals(driver.getTitle(), pageTitleText);
	}
	
	// Common util for webdriver wait
		public void WDWait(WebElement we) {
			wait.until(ExpectedConditions.visibilityOf(we));
		}
}
