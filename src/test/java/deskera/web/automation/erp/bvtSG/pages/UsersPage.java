package deskera.web.automation.erp.bvtSG.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.qameta.allure.Step;

public class UsersPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public UsersPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}
		
		
		/******************************* Users  PAGE ELEMENTS LOCATORS *******************/

	@FindBy(xpath = "//button[contains(.,'addADD USER')]")
	
	private WebElement addUsersButton;	
	@FindBy(xpath = "(//button[text()=' Name '])[1]")
	
	private WebElement nameColumn;	
	@FindBy(xpath = "(//button[text()=' Email '])[1]")
	
	private WebElement emailColumn;	
	@FindBy(xpath = "(//button[text()=' Role '])[1]")
	
	private WebElement roleColumn;	
	private static String pageTitleText = "Deskera Books";
	
	
	/******************************* Add User Section  ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "//input[contains(@placeholder,'First Name')]")
	
	private WebElement firstName;
	@FindBy(xpath = "//input[@placeholder='Last name']")
	
	private WebElement lastName;
	@FindBy(xpath = "//input[@placeholder='Email']")
	
	private WebElement email;
	@FindBy(xpath = "//input[@placeholder='Password']")
	
	private WebElement password;
	@FindBy(xpath = "//input[@value='phoneNumber']")
	
	private WebElement phoneNumber;
	@FindBy(xpath = "//div[@class='wtf2-form-field-infix'][contains(.,'Assign Roles  *')]")
	
	private WebElement assignRolesDropdown;
	@FindBy(xpath = "//span[contains(.,'Business')]")
	
	private WebElement businessRole;
	@FindBy(xpath = "//span[contains(.,'CANCEL')]")
	
	private WebElement cancelButton;
	@FindBy(xpath = "//span[contains(text(),'SAVE')]")
	
	private WebElement saveButton;
	

	/***********************************
	 * 
	 * Page objects manipulation methods
	* 
	 *********************************/
	@Step("Verify Page Title")
	public void verifyPageTitle() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), pageTitleText);
	}

	// Common util for webdriver wait
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	
	@Step("Verify Users Page Elements")
	public void verifyUsersPageElements(){
		WDWait(addUsersButton);
		addUsersButton.isDisplayed();
		WDWait(nameColumn);
		nameColumn.isDisplayed();
		emailColumn.isDisplayed();
		roleColumn.isDisplayed();
	}
	
	@Step("Click on Add User Button")
	public void clickAddUserButton(){
		addUsersButton.click();
	}
	
	@Step("Verify Add User Page Elements")
	public void verifyAddUserPageElements(){
		WDWait(firstName);
		firstName.isDisplayed();
		lastName.isDisplayed();
		email.isDisplayed();
		password.isDisplayed();
		phoneNumber.isDisplayed();
		assignRolesDropdown.isDisplayed();
		cancelButton.isDisplayed();
		saveButton.isDisplayed();
	}
	
	@Step("Enter User Details")
	public void enterUserDetails(String firstname,String lastname,String emailid,String passWord,String phone){
		WDWait(firstName);
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		email.sendKeys(emailid);
		password.sendKeys(passWord);
		phoneNumber.sendKeys(phone);
		assignRolesDropdown.click();
		WDWait(businessRole);
		businessRole.click();
	}
	
	@Step("Click On Save Button")
	public void clickSaveButton(){
		saveButton.click();
	}
}

