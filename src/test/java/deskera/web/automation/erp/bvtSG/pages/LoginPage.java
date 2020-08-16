package deskera.web.automation.erp.bvtSG.pages;

import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.qameta.allure.Step;

public class LoginPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	/*******************************
	 * LOGIN PAGE ELEMENTS LOCATORS
	 *******************/
	@FindBy(xpath = "//span[contains(text(),'Deskera Books')]/../preceding-sibling::div[@class='card-background-img']")

	private WebElement goToDeskeraBooksCard;
	@FindBy(xpath = "//*[@id='wtf2-input-2']")

	private WebElement userLoginEmail;
	@FindBy(xpath = "//*[@id='wtf2-input-3']")

	private WebElement userLoginPassword;
	@FindBy(xpath = "//wtf2-icon[contains(.,'visibility_off')]")

	private WebElement eyeIcon;
	@FindBy(xpath = "(//span[contains(.,'Remember me')])[1]")

	private WebElement rememberMe;
	@FindBy(xpath = "//span[contains(.,'Forgot Password')]")

	private WebElement forgotPasswordLink;

	@FindBy(xpath = "(//span[contains(.,'Sign in') or contains(.,'SIGN IN')])[2]")	
	private WebElement signInButton;
	@FindBy(xpath = "(//span[contains(.,'Google')])[1]")

	private WebElement signInUsingGoogle;
	@FindBy(xpath = "(//span[contains(.,'SIGN UP Now') or contains(.,'Sign up Now')])[2]")
	private WebElement signUpNowLink;
	@FindBy(xpath = "//h6[@class='m-0 p-0 font-weight-500']")

	private WebElement dashboardHeading;
	private static String pageTitleText = "Deskera SSO";
	/*******************************
	 * Sign Using Google PAGE ELEMENTS LOCATORS
	 *******************/
	@FindBy(xpath = "//input[@aria-label='Email or phone']")

	private WebElement googleEmailOrPhone;
	@FindBy(xpath = "//span[@class='CwaK9']/span[contains(text(),'Next')]")

	private WebElement nextButton;
	@FindBy(xpath = "//input[contains(@autocomplete,'current-password')]")

	private WebElement googlePassword;
	@FindBy(xpath = "//span[@class='CwaK9']/span[contains(text(),'Next')]")

	private WebElement PasswordNextButton;

	/***********************************
	 * 
	 * Page objects manipulation methods
	 * 
	 *********************************/
	@Step("Open URL")
	public void openURL(String URL) {
		driver.get(URL);
	}

	@Step("Verify Page Title")
	public void verifyPageTitle() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), pageTitleText);
	}

	// Common util for webdriver wait
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}

	public void WDWaitClickable(WebElement we) {
		wait.until(ExpectedConditions.elementToBeClickable(we));
	}

	public void MOverElement(WebElement we) throws InterruptedException
	{
		Actions action = new Actions(driver);
		action.moveToElement(we).perform();
		Thread.sleep(1000);
	}

	@Step("Verify Login Page Elements")
	public void verifyLoginPageElements() {
		WDWait(userLoginEmail);
		userLoginEmail.isDisplayed();
		userLoginPassword.isDisplayed();
		eyeIcon.isDisplayed();
		rememberMe.isDisplayed();
		forgotPasswordLink.isDisplayed();
		signInButton.isDisplayed();
		signInUsingGoogle.isDisplayed();
		WDWait(signUpNowLink);
		signUpNowLink.isDisplayed();
	}

	@Step("Enter Email and Password")
	public void enterEmailandPassword(String email, String password) {
		WDWait(userLoginEmail);
		userLoginEmail.sendKeys(email);
		userLoginPassword.click();
		userLoginPassword.sendKeys(password);
	}

	@Step("Click Sign In")
	public void clickSignIn() throws InterruptedException {
		WDWait(signInButton);
		signInButton.click();
		Thread.sleep(3000);
		goToDeskeraBooks();
		// WDWait(dashboardHeading);
		// dashboardHeading.isDisplayed();
	}

	@Step("Click Sign In First Time")
	public void clickSignInFirstTime() {
		WDWait(signInButton);
		signInButton.click();
	}

	@Step("Go to Deskera books from GO")
	public void goToDeskeraBooks() throws InterruptedException {
		Thread.sleep(3000);
		WDWait(goToDeskeraBooksCard);
		WDWaitClickable(goToDeskeraBooksCard);
		Thread.sleep(3000);
		MOverElement(goToDeskeraBooksCard);
		goToDeskeraBooksCard.click();
		Thread.sleep(3000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}

	@Step("ClickS On ignIn Using Google")
	public void clickSignInUsingGoogle() {
		signInUsingGoogle.click();
	}

	@Step("Enter Google Email Password")
	public void enterGoogleEmailPassword(String email, String password) {
		googleEmailOrPhone.sendKeys(email);
		nextButton.click();
		googlePassword.sendKeys(password);
		PasswordNextButton.click();
	}
}
