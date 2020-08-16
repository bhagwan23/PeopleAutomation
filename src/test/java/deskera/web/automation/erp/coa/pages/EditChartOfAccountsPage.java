package deskera.web.automation.erp.coa.pages;

import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import deskera.web.automation.core.SoftAssertListner;
import io.qameta.allure.Step;



public class EditChartOfAccountsPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;
	private SoftAssertListner sAssert;

	public EditChartOfAccountsPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
		sAssert = new SoftAssertListner(driver);
	}
	
	@FindBy(xpath = "//span[@class='ng-star-inserted'][contains(text(),'Accounting')]")	
	private WebElement accountingButton;
	
	@FindBy(xpath = "//div[contains(@class,'row ng-star-inserted')]//div[1]//wtf2-card[1]")
	private WebElement coaCard;
	
	@FindBy(xpath= "//input[@placeholder='Search Records']")	
	private WebElement searchRecord;

	@FindBy(xpath = "//mat-table[1]/mat-row[1]//mat-cell[7]//button[1]//span[1]//mat-icon[1]")
	private WebElement contextMenuIcon;
	
	@FindBy(xpath = "//button[contains(text(),'Edit')]")
	private WebElement editButton;
	
	@FindBy(xpath = "//button[contains(text(),'Deactivate')]")
	private WebElement deactivateButton;
	
	@FindBy(xpath = "//label[contains(text(),'Edit Account')]")
	private WebElement editAccountLabel;
	
	@FindBy(xpath = "//h3[contains(text(),'Account Details')]")
	private WebElement accountDetailsLabel;
	
	@FindBy(xpath = "//mat-label[contains(text(),'Type')]")
	private WebElement typeLabel;
	
	@FindBy(xpath = "//input[@placeholder='Type here']")
	private WebElement typeInput;
	
	@FindBy(xpath = "//input[@formcontrolname='accountCode']")
	private WebElement codeInput;
	
	@FindBy(xpath = "//input[@formcontrolname='name']")
	private WebElement nameInput;
	
	@FindBy(xpath = "//textarea[@formcontrolname='description']")
	private WebElement description;
	
	@FindBy(xpath = "//mat-label[contains(text(),'Code')]")
	private WebElement codeLabel;
	
	@FindBy(xpath = "//mat-label[contains(text(),'Name')]")
	private WebElement nameLabel;
	
	@FindBy(xpath = "//mat-label[contains(text(),'Currency')]")
	private WebElement currencyLabel;
	
	@FindBy(xpath = "//app-currency-dropdown[@formcontrolname='currency']")
	private WebElement currencySelect;
	
	@FindBy(xpath = "//span[contains(text(),'Save Changes')]")
	private WebElement saveChangesButton;
	
	@FindBy(xpath= "//span[text()='Account is successfully created.']")
	@CacheLookup
	private WebElement editCOASuccessMessage;
	
	@FindBy(xpath= "//span[text()='Account has been deactivated successfully.']")
	@CacheLookup
	private WebElement deactivateCOASuccessMessage;
	
	@FindBy(xpath = "*[@id='container-3']/extn-content[1]/dt-chart-of-account-list[1]/div[1]/div[1]/mat-table[1]/mat-row[1]/mat-cell[6]/span[1]/span[1]")
	private WebElement inactive;
	
	@Step("Open URl")
	public void openURL(String URL) {
		driver.get(URL);
	}

	// Common util for webdriver wait
	@Step("Wait Element to be Visible")
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	
	@Step("Click on accounting button")
	public void clickAccountingButton() throws InterruptedException{
		WDWait(accountingButton);
		accountingButton.click(); 
		sAssert.assertAll();
	}
	
	@Step("Click on Chart Of Accounts card")
	public void clickChartOfAccountsCard() throws InterruptedException{
		WDWait(coaCard);
		coaCard.click(); 
		sAssert.assertAll();
	}
	
	@Step("Search coa to edit")
	public void searchRecord(String cName) throws InterruptedException{
		WDWait(searchRecord);
		searchRecord.click();
		searchRecord.sendKeys(cName);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		sAssert.assertAll();
		
	}
	
	@Step("Click on Context Menu icon")
	public void clickContextMenuIcon() throws InterruptedException{
		Thread.sleep(1000);
		WDWait(contextMenuIcon);
		wait.until(ExpectedConditions.elementToBeClickable(contextMenuIcon));
		contextMenuIcon.isDisplayed();
		contextMenuIcon.click();
		sAssert.assertAll();
	}
	
	@Step("Click on Edit button")
	public void clickEditButton(){
		
		WDWait(editButton);
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
		editButton.isDisplayed();
		editButton.click();	
		sAssert.assertAll();
		
	}
	
	@Step("Enter new account info")
	public void editAccountInfo(String newName,String newCode, String newDescription, String newCurrency) {
		WDWait(nameInput);
		nameInput.clear();
		nameInput.sendKeys(newName);
		
		WDWait(codeInput);
		codeInput.clear();
		codeInput.sendKeys(newCode);
		
		WDWait(description);
		description.clear();
		description.sendKeys(newDescription);
		sAssert.assertAll();
	}
	
	@Step("Click on save change button")
	public void clickSaveChangeButton(){
		WDWait(saveChangesButton);
		saveChangesButton.isDisplayed();
		saveChangesButton.click();
		sAssert.assertAll();
	}
	
	@Step("Verify success message")
	public void verifyCOAeditedSucessMessage() throws InterruptedException {
		WDWait(editCOASuccessMessage);
		wait.until(ExpectedConditions.visibilityOf(editCOASuccessMessage));
		editCOASuccessMessage.isDisplayed();
		sAssert.assertAll();

	}
	
	@Step("Click on Deactivate button")
	public void clickDeactivateButton(){
		
		WDWait(deactivateButton);
		wait.until(ExpectedConditions.elementToBeClickable(deactivateButton));
		deactivateButton.isDisplayed();
		deactivateButton.click();	
		sAssert.assertAll();
		
	}
	
	@Step("Verify deactivate COA success message")
	public void verifyCOAdeactivatedSucessMessage() throws InterruptedException {
		WDWait(deactivateCOASuccessMessage);
		wait.until(ExpectedConditions.visibilityOf(deactivateCOASuccessMessage));
		deactivateCOASuccessMessage.isDisplayed();
		sAssert.assertAll();

	}
	
	@Step("Verify deactivated account")
	public void verifyDeactivatedAccount(String name) throws InterruptedException {
		WDWait(inactive);
		Assert.assertEquals(inactive.getText(), "inactive");
		Thread.sleep(2000);
		sAssert.assertAll();
		
	}
	
}

