package deskera.web.automation.erp.imports.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import deskera.web.automation.core.SoftAssertListner;
import io.qameta.allure.Step;

public class Chartofaccountsimportpage {
	
private WebDriver driver;
	
	private WebDriverWait wait;
	private SoftAssertListner sAssert;
   
	public Chartofaccountsimportpage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
		sAssert = new SoftAssertListner(driver);
	}
	/*******************************
	 * Import COA PAGE ELEMENTS LOCATORS
	 *******************/
	
	 @FindBy(xpath = "//span[contains(text(),'Accounting')]")
	 private WebElement Accountingbutton;
	 private static String pageTitleText = "Deskera Books";
	 @FindBy(xpath = "//span[contains(text(),'Chart of Accounts')]")
	 private WebElement Chartofaccountbutton;
	 @FindBy(xpath = "//button[@class='import mat-icon-button mat-button-base']//*[local-name()='svg']")
	 private WebElement Chartofaccountimportbutton;
    /*******************************
   * Upload import file of COA PAGE ELEMENTS LOCATORS
    *******************/
	 @FindBy(xpath = "//a[contains(text(),'browse')]")
	 private WebElement browsebutton;
	 @FindBy(xpath = "(//button[@class='mat-import-button pull-right mat-flat-button mat-button-base mat-primary'])[1]")
	 private WebElement UploadDatatNextButton;
	 @FindBy(xpath = "(//span[@class='mat-button-wrapper'][contains(text(),'Cancel')])[1]")
	 private WebElement UploadDatatCancelButton;
	 /*******************************
	 *Mapping headers of Tracked Product PAGE ELEMENTS LOCATORS
	 *******************/
	 @FindBy(xpath = "(//button[@class='mat-import-button pull-right mat-flat-button mat-button-base mat-primary'])[2]")
	 private WebElement MappingDatatNextButton;
	 @FindBy(xpath = "(//span[@class='mat-button-wrapper'][contains(text(),'Back')])[1]")
	 private WebElement MappingDatatBackButton;
	 @FindBy(xpath = "(//span[@class='mat-button-wrapper'][contains(text(),'Cancel')])[2]")
	 private WebElement MappingDatatCancelButton;
	 /*******************************
	 *Confirm Data of Tracked Product PAGE ELEMENTS LOCATORS
      *******************/
	 @FindBy(xpath = "//span[contains(text(),'Submit')]")
	 private WebElement ConfirmDataSubmitButton;
	 @FindBy(xpath = "(//span[@class='mat-button-wrapper'][contains(text(),'Back')])[2]")
	 private WebElement ConfirmDatatBackButton;
	 @FindBy(xpath = "(//span[@class='mat-button-wrapper'][contains(text(),'Cancel')])[3]")
	 private WebElement ConfirmDatatCancelButton;
	 @FindBy(xpath = "//span[contains(text(),'The file has been uploaded, Please check the ')]")
	 private WebElement Confirmationmessage;	
	 /*******************************
	  Verify imported Data PAGE ELEMENTS LOCATORS
	  *******************/	 
	 
	 @FindBy(xpath= "//input[@placeholder='Search Records']")	
	 private WebElement searchRecord;
	 @FindBy(xpath = "//*[@id='container-3']/extn-content[1]/dt-chart-of-account-list[1]/div[1]/div[1]/mat-table[1]/mat-row[1]/mat-cell[3]/span[1]")
     private WebElement enteredName;
     @FindBy(xpath = "//vertical-layout-1[@class='ng-star-inserted']//div[3]//div[2]")
	 private WebElement viewCode;
	 @FindBy(xpath = "//*[@id='container-3']/extn-content[1]/dt-add-account[1]/div[1]/div[1]/div[1]/div[2]/dt-add-account-view-form[1]/div[1]/div[1]/div[4]/div[2]")
	 private WebElement viewName;
	 @FindBy(xpath= "//div[contains(text(),'Name')]/following-sibling::div[@class='field-value']")	
     private WebElement editedName;
	 @FindBy(xpath = "//div[contains(text(),'Account Code')]/following-sibling::div[@class='field-value']")
	 private WebElement editedCode;
	 @FindBy(xpath = "//mat-row[1]//mat-cell[4]")
	 private WebElement accType;
	 
	
         
		/***********************************
		 * 
		 * Page objects manipulation methods
		 * 
		 *********************************/
		@Step("Verify Page Title")
		public void verifyPageTitle() {
			sAssert.assertEquals(driver.getTitle(), pageTitleText);
		}

		// Common util for webdriver wait
		@Step("Wait Element to be Visible")
		public void WDWait(WebElement we) {
			wait.until(ExpectedConditions.visibilityOf(we));
		}
		
		@Step("Click on Accounting button")
		public void ClickOnAccountingButton() throws InterruptedException{
			WDWait(Accountingbutton);
			Accountingbutton.click(); 
			
			//Thread.sleep(3000);
		}
		
		@Step("Click on Charts of accounts button")
		public void ClickOnCOAButton() throws InterruptedException{
			WDWait(Chartofaccountbutton);
			Chartofaccountbutton.click(); 
			
			
			//Thread.sleep(3000);
		}
		@Step("Click on import accounts button")
		public void ClickOnImportAccountsButton() throws InterruptedException{
			WDWait(Chartofaccountimportbutton);
			Chartofaccountimportbutton.click(); 
			
			
			//Thread.sleep(3000);
		}
		
		
		@Step("Scroll page")
		public void ScrollToElement(WebElement element)
		{

			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
		}
		@Step("Upload Import file of Accounts")
		public void UploadImportAccountsFile(String filename) throws InterruptedException, AWTException {
			// Supported onnly for windows local env
		
		  if (System.getProperty("os.name").toLowerCase().contains("windows") ||
		  System.getProperty("os.name").toLowerCase().contains("windows")) {
			WDWait(browsebutton);
				browsebutton.click();
				Robot rob = new Robot();
				StringSelection str = new StringSelection(System.getProperty("user.dir")+"\\testdata\\imports\\COA\\"+filename);
				//StringSelection filePath=new StringSelection("/home/seluser/COA/"+filename);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
				/*rob.keyPress(KeyEvent.VK_CONTROL);
				rob.keyPress(KeyEvent.VK_L);
				Thread.sleep(2000);
				rob.keyRelease(KeyEvent.VK_CONTROL);
				rob.keyRelease(KeyEvent.VK_L);
				Thread.sleep(2000);
				rob.keyPress(KeyEvent.VK_CONTROL);
				rob.keyPress(KeyEvent.VK_A);
				Thread.sleep(2000);
				rob.keyRelease(KeyEvent.VK_CONTROL);
				rob.keyRelease(KeyEvent.VK_A);*/
				Thread.sleep(2000);
				rob.keyPress(KeyEvent.VK_CONTROL);
				rob.keyPress(KeyEvent.VK_V);
				Thread.sleep(2000);
				rob.keyRelease(KeyEvent.VK_CONTROL);
				rob.keyRelease(KeyEvent.VK_V);
				Thread.sleep(2000);
				rob.keyPress(KeyEvent.VK_ENTER);
				rob.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(3000);
				
				Thread.sleep(2000);
				ScrollToElement(UploadDatatNextButton);
				Thread.sleep(2000);
				
				sAssert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(UploadDatatNextButton)) != null,"wait for  Next button");
				UploadDatatNextButton.click();
			}
		}
		
		@Step("Mapping headers to import Accounts")
		public void MapheadersToImportAccounts() throws InterruptedException, AWTException {
			Thread.sleep(2000);
			ScrollToElement(MappingDatatNextButton);
			Thread.sleep(2000);
			sAssert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(MappingDatatNextButton)) != null,"wait for  Next button");
			MappingDatatNextButton.click();
			
			}
		
		@Step("Confirm data to import Accounts")
		public void ConfirmDataToImportAccounts() throws InterruptedException, AWTException {
			Thread.sleep(3000);
			
			Thread.sleep(2000);
			ScrollToElement(ConfirmDataSubmitButton);
			Thread.sleep(2000);
			sAssert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(ConfirmDataSubmitButton)) != null,"wait for Submit button");
			ConfirmDataSubmitButton.click();
			
			}
		@Step("Verify import Accounts Success Message")
		public void verifyAccountsImportSuccessMessage() {
			WDWait(Confirmationmessage);
			Confirmationmessage.isDisplayed();
			sAssert.assertTrue(wait.until(ExpectedConditions.visibilityOf(Confirmationmessage)) != null);
			sAssert.assertAll();

		}	
		
		@Step("Verify added account")
		public void verifyAddedAccount(String name, String code, String desc) throws InterruptedException {
			WDWait(searchRecord);
			searchRecord.click();
			searchRecord.sendKeys(name);
			Thread.sleep(2000);
			WDWait(enteredName);
			wait.until(ExpectedConditions.elementToBeClickable(enteredName));
			Assert.assertEquals(enteredName.getText(), name);
			enteredName.click();
			
			Assert.assertEquals(editedName.getText(), name);
			Assert.assertEquals(editedCode.getText(), code);
			
			
			Thread.sleep(2000);
			sAssert.assertAll();
		}
		
}
