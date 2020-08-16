package deskera.web.automation.erp.bvtSG.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Step;

public class CreateBankPage {

	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;

	public CreateBankPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}


	/*******************************
	 * CREATE BANK PAGE ELEMENTS LOCATORS
	 *******************/
	@FindBy(xpath = "//span[contains(text(),'Bank')]")
	private WebElement bankTab;
	@FindBy(xpath = "//span[contains(text(),'ACC10001')]")
	private WebElement defaultbankcode;
	@FindBy(xpath = "//button[@class='wtf2-flat-button text-uppercase wtf2-primary pl-3 wtf2-button']")
	private WebElement addBankButton;
	@FindBy(xpath = "//input[@id='wtf2-input-0']")

	private WebElement code;
	@FindBy(xpath = "//input[@id='wtf2-input-1']")

	private WebElement name;
	@FindBy(xpath = "//input[@id='accdesc']")

	private WebElement description;
	@FindBy(xpath = "//*[@id='cdk-step-content-0-0']/form/div[4]/div/wtf2-form-field/div/div[1]/div[3]")

	private WebElement currency;
	@FindBy(xpath = "//wtf2-split-button-title[@class='wtf2-split-button-title']")

	private WebElement selectAndConnectButton;
	@FindBy(xpath = "//span[contains(text(),'CANCEL')]")

	private WebElement cancelButton;
	@FindBy(xpath = "//wtf2-icon[@class='wtf2-accent-fg mt-2 wtf2-icon notranslate material-icons wtf2-icon-no-color']")

	private WebElement crossIconButton;
	@FindBy(xpath = "//wtf2-split-button-title[contains(.,'SAVE AND CONNECT')]")

	private WebElement saveAndConnectButton;
	@FindBy(xpath = "//wtf2-icon[contains(text(),'keyboard_arrow_down')]")

	private WebElement dropDownButton;
	@FindBy(xpath = "//button[@class='ng-star-inserted']")

	private WebElement saveAndCloseButton;
	@FindBy(xpath = "//*[@id='AccountAccordionGrid']/wtf2-table/wtf2-row[1]/wtf2-cell[2]/span/wtf2-format-value/span")

	private WebElement accountHSBC;
	@FindBy(xpath = "//wtf2-row[1]//wtf2-cell[8]//span[1]//div[1]//button[1]//span[1]//wtf2-icon[1]")

	private WebElement accContextMenuButton;
	@FindBy(xpath = "//div//iframe[contains(@class,'bank-iframe')]")

	private WebElement searchBankFrame;
	@FindBy(xpath = "//input[@placeholder='Type a name']")

	private WebElement bankSearchBox;
	@FindBy(xpath = "(//strong[contains(.,'Fake Bank')])[1]")

	private WebElement searchedFakeSimpleBank;
	@FindBy(xpath = "//input[@name='login']")

	private WebElement bankUsername;
	@FindBy(xpath = "//input[@name='password']")

	private WebElement bankPassword;
	@FindBy(xpath = "(//input[@type='submit'])[2]")

	private WebElement connectButton;
	@FindBy(xpath = "//input[@value='Confirm']")

	private WebElement confirmButton;
	@FindBy(xpath = "(//div[@class='wtf2-select-arrow'])[2]")

	private WebElement selectYourBankAccountDropwn;
	@FindBy(xpath = "//span[contains(.,'Simple account 2')]")

	private WebElement simpleBank2;
	@FindBy(xpath = "//span[contains(.,'CONNECT ACCOUNT')]")

	private WebElement connectAccountButton;
	@FindBy(xpath = "//span[text()='Account connected to bank successfully']")

	private WebElement bankConnectSuccessMessage;
	@FindBy(xpath = "//span[contains(text(),'Fake Bank Simple')]//following::button//span")
	private WebElement threeDotsOnFakeBankSimple;
	@FindBy(xpath = "//span[contains(.,'Reconciliation')]")
	private WebElement reconciliationButton;
	@FindBy(xpath = "//div[contains(text(),'Deposit')]//preceding::div[1]")
	private WebElement firstTransactionDate;
	@FindBy(xpath = "(//div[contains(text(),'Deposit')])[2]//preceding::div[1]")
	private WebElement secondTransactionDate;
	@FindBy(xpath = "//span[contains(text(),'Deskera Transactions')]//following::wtf2-card[1]")
	private WebElement firstDeskeraTransaction;
	@FindBy(xpath = "//span[contains(text(),'Deskera Transactions')]//following::wtf2-card[2]")
	private WebElement secondDeskeraTransaction;
	@FindBy(xpath = "//b[contains(.,'MATCH')]")
	private WebElement matchButton;
	@FindBy(xpath = "//span[contains(.,'NEXT')]")
	private WebElement nextButton;
	@FindBy(xpath = "(//b[contains(.,'UNMATCH')])[1]")
	private WebElement unmatchButton1;
	@FindBy(xpath = "(//b[contains(.,'UNMATCH')])[2]")
	private WebElement unmatchButton2;
	@FindBy(xpath = "//div[@class='org-avatar ng-star-inserted']")
	private WebElement userProfileIcon;

	@FindBy(xpath = "//mat-icon[@role='img' and @svgicon='collapse']")
	private WebElement collapseIcon;
	@FindBy(xpath = "(//b[contains(.,'UNMATCH')])[1]//preceding::wtf2-card[2]//div//div[1]//following::div[1][text()=' Deposit ']")
	private WebElement bankTransaction1OnConfirmPage;
	@FindBy(xpath = "(//b[contains(.,'UNMATCH')])[1]//preceding::wtf2-card[1]//div//div[1]//following::div[1][text()=' Deposit ']")
	private WebElement bankTransaction2OnConfirmPage;
	@FindBy(xpath = "(//b[contains(.,'UNMATCH')])[1]//following::wtf2-card[1]//div//div[1]//following::div[1][text()=' Deposit ']")
	private WebElement deskeraTransaction1OnConfirmPage;
	@FindBy(xpath = "(//b[contains(.,'UNMATCH')])[1]//following::wtf2-card[2]//div//div[1]//following::div[1][text()=' Deposit ']")
	private WebElement deskeraTransaction2OnConfirmPage;
	@FindBy(xpath = "//span[contains(.,'SAVE AND RECONCILE')]")
	private WebElement saveAndReconcileButton;
	@FindBy(xpath = "//span[text()=' SAVE ']")
	private WebElement saveButtonOnConfirmPage;
	@FindBy(xpath = "//span[contains(text(),'Data saved successfully')]")
	private WebElement reconcileSuccesMessage;
	

	/*******************************
	 * Banks Object Manipulation Methods
	 *******************/
	@Step("Open URL")
	public void openURL(String URL) {
		driver.get(URL);
	}

	// Common util for webdriver wait
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}

	@Step("Click On bank Tab")
	public void clickOnBanktab() throws InterruptedException {
		WDWait(bankTab);
		wait.until(ExpectedConditions.elementToBeClickable(bankTab));
		bankTab.isDisplayed();
		bankTab.click();
	}

	@Step("Click On Collapse Icon")
	public void clickCollapseIcon() throws InterruptedException {
		Thread.sleep(4000);
		Actions action = new Actions(driver);
		action.moveToElement(userProfileIcon).build().perform();
		WDWait(collapseIcon);
		collapseIcon.click();
	}

	@Step("Verify Default Bank")
	public void verifyDefaultBank() {
		WDWait(defaultbankcode);
		defaultbankcode.isDisplayed();
		Assert.assertEquals(defaultbankcode.getText(), "ACC10001");
	}

	@Step("Click On Add Button")
	public void clickAddButton() {
		WDWait(addBankButton);
		addBankButton.isDisplayed();
		addBankButton.click();
	}

	@Step("Verify Account Detail Elements")
	public void verifyAccountDetailElements() {
		WDWait(code);
		code.isDisplayed();
		WDWait(name);
		name.isDisplayed();
		WDWait(description);
		description.isDisplayed();
		WDWait(currency);
		currency.isDisplayed();
		// Assert.assertEquals(currency.getText(), "Singapore Dollar (SGD)");
		selectAndConnectButton.isDisplayed();
		cancelButton.isDisplayed();
		crossIconButton.isDisplayed();

	}

	@Step(" Enter Bank Details")
	public void enterAccountDetails(String code1, String name1, String Desc) {
		WDWait(code);
		code.sendKeys(code1);
		name.sendKeys(name1);
		description.sendKeys(Desc);

	}

	@Step("Click Save And Close Button")
	public void clickSaveAndCloseButton() {
		WDWait(dropDownButton);
		dropDownButton.click();
		WDWait(saveAndCloseButton);
		saveAndCloseButton.click();
		driver.navigate().refresh();
	}

	@Step("Click Save And Connect")
	public void clickSaveAndConnectButton() {
		WDWait(saveAndConnectButton);
		saveAndConnectButton.click();
	}

	@Step("Verify Saved Bank")
	public void verifySavedAccount() {
		WDWait(accountHSBC);
		accountHSBC.isDisplayed();
		WDWait(accContextMenuButton);
		accContextMenuButton.isDisplayed();
		accContextMenuButton.click();
	}

	@Step("Click On Connect Button")
	public void clickOnConnectButton() {
		WDWait(connectButton);
		connectButton.isDisplayed();
		connectButton.click();
	}

	@Step("Search Bank")
	public void searchBank() {
		WDWait(searchBankFrame);
		searchBankFrame.isDisplayed();
		driver.switchTo().frame(searchBankFrame);
		WDWait(bankSearchBox);
		bankSearchBox.click();
		bankSearchBox.sendKeys("Fake Bank Simple");
		WDWait(searchedFakeSimpleBank);
		searchedFakeSimpleBank.click();
	}

	@Step("Enter Bank UserName and Password")
	public void enterBankUsernamePassword(String bankUserName, String bankPassWord) {
		WDWait(bankUsername);
		bankUsername.sendKeys(bankUserName);
		bankPassword.sendKeys(bankPassWord);
		connectButton.click();
		WDWait(confirmButton);
		confirmButton.click();
		driver.switchTo().defaultContent();
	}

	@Step("Select and Connect Bank Account")
	public void selectAndConnectBankAccount() throws InterruptedException {
		Thread.sleep(5000);
		// WDWait(selectYourBankAccountDropwn);
		wait.until(ExpectedConditions.elementToBeClickable(selectYourBankAccountDropwn));
		selectYourBankAccountDropwn.click();
		WDWait(simpleBank2);
		simpleBank2.click();
	}

	@Step("Click on Connect Account Button")
	public void clickConnectAccountButton() {
		WDWait(connectAccountButton);
		connectAccountButton.click();
	}

	@Step("Verify Bank Connect Success Message")
	public void verifyBankConnectSuccessMessage() throws InterruptedException {
		WDWait(bankConnectSuccessMessage);
		bankConnectSuccessMessage.isDisplayed();
		Thread.sleep(2000);
	}

	@Step("Click on three dots on Fake Bank Simple")
	public void clickthreeDots() {
		WDWait(threeDotsOnFakeBankSimple);
		threeDotsOnFakeBankSimple.click();
	}

	@Step("Click on Reconciliation Button")
	public void clickreconciliationButton() {
		WDWait(reconciliationButton);
		reconciliationButton.click();
	}

	// @Parameters({ "conf", "environment" })
	public void writeDate(String conf) {
		String confPath;
		confPath = conf;
		WDWait(firstTransactionDate);
		System.out.println(firstTransactionDate.getText());
		Actions action = new Actions(driver);
		action.moveToElement(secondTransactionDate).build().perform();
		System.out.println(secondTransactionDate.getText());
		ReadPropertyUtil.writeProperty("firstTransactionDate", confPath, firstTransactionDate.getText());
		ReadPropertyUtil.writeProperty("secondTransactionDate", confPath, secondTransactionDate.getText());
	}

	@Step("Select Bank and Deskera Transaction 1")
	public void selectBankAndDeskeraTransaction1() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(firstTransactionDate));
		firstTransactionDate.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(firstDeskeraTransaction));
		firstDeskeraTransaction.click();
		Thread.sleep(2000);
	}

	@Step("Click on Match Button")
	public void clickMatchButton() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", matchButton);
		wait.until(ExpectedConditions.elementToBeClickable(matchButton));
		matchButton.click();
		Thread.sleep(2000);
	}

	@Step("Select Bank and Deskera Transaction 2")
	public void selectBankAndDeskeraTransaction2() throws InterruptedException {
		// firstTransactionDate.sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME));
		// ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",
		// secondTransactionDate);
		driver.findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME));
		wait.until(ExpectedConditions.elementToBeClickable(firstTransactionDate));
		firstTransactionDate.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(firstDeskeraTransaction));
		firstDeskeraTransaction.click();
		Thread.sleep(2000);
	}

	@Step("Click on Next Button")
	public void clickNextButton() throws InterruptedException {
		driver.findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.CONTROL, Keys.END));
		wait.until(ExpectedConditions.elementToBeClickable(nextButton));
		nextButton.click();
		Thread.sleep(2000);
	}

	@Step("Verify 2 Transactions on Confirm Page")
	public void verifyTwoTransactionsOnConfirmPage() {
		WDWait(unmatchButton1);
		unmatchButton1.isDisplayed();
		WDWait(deskeraTransaction1OnConfirmPage);
		deskeraTransaction1OnConfirmPage.isDisplayed();
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", unmatchButton2);
		Actions action = new Actions(driver);
		action.moveToElement(unmatchButton2).build().perform();
		WDWait(unmatchButton2);
		unmatchButton2.isDisplayed();
		WDWait(bankTransaction1OnConfirmPage);
		bankTransaction1OnConfirmPage.isDisplayed();
	}

	@Step("Click Save and Reconcile Button")
	public void clicSaveAndReconcileButton() throws InterruptedException {
		driver.findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.CONTROL, Keys.END));
		wait.until(ExpectedConditions.elementToBeClickable(saveAndReconcileButton));
		saveAndReconcileButton.click();
	}
	
	@Step("Click Save Button on Confirm page ")
	public void clicSaveButtonOnConfirmPage() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(saveButtonOnConfirmPage));
		saveButtonOnConfirmPage.click();
	}
	
	@Step("Verify Reconcile Success Message")
	public void verifyReconcileSuccessMessage() throws InterruptedException {
		WDWait(reconcileSuccesMessage);
		reconcileSuccesMessage.isDisplayed();
		Thread.sleep(2000);
	}
}
