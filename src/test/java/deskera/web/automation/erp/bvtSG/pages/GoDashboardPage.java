package deskera.web.automation.erp.bvtSG.pages;

import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import deskera.web.automation.core.SoftAssertListner;
import io.qameta.allure.Step;

public class GoDashboardPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;
	private SoftAssertListner sAssert;


	public GoDashboardPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
		sAssert = new SoftAssertListner(driver);

	}

	/*******************************
	 * GO DASHBOARD PAGE ELEMENTS LOCATORS
	 *******************/
	@FindBy(xpath = "//button[@class='wtf2-primary mr-3 wtf2-flat-button']/span/span[contains(text(),'START TRIAL')]")
	
	private WebElement startTrialBooksPopupButton;
	@FindBy(xpath = "//button[@class='wtf2-primary wtf2-stroked-button']/span[contains(text(),'CANCEL')]")
	
	private WebElement cancelTrialBooksPopupButton;
	@FindBy(xpath = "//span[contains(text(),'Deskera Books')]")
	
	private WebElement goToDeskeraBooksCard;

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
		// Assert.assertEquals(driver.getTitle(), pageTitleText);
	}

	// Common util for webdriver wait
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}

	public void WDWaitClickable(WebElement we) {
		wait.until(ExpectedConditions.elementToBeClickable(we));
	}

	@Step("Verify Start Trial Popup Elements")
	public void verifystartTrialPopup() {
		WDWait(startTrialBooksPopupButton);
		cancelTrialBooksPopupButton.isDisplayed();
	}

	@Step("Click on START TRIAL popup button")
	public void clickStartBooksTrial() throws InterruptedException {
		WDWait(goToDeskeraBooksCard);
		goToDeskeraBooksCard.isDisplayed();
		WDWaitClickable(goToDeskeraBooksCard);
		Thread.sleep(5000);
		System.out.println("Waiting to be clicked on Books card--------------------->");
		goToDeskeraBooksCard.click();
		WDWait(startTrialBooksPopupButton);
		WDWaitClickable(startTrialBooksPopupButton);
		startTrialBooksPopupButton.click();
		Thread.sleep(5000);
	}
}
