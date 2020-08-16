package deskera.web.automation.erp.bvtSG.pages;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
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

public class CopyContactPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;
	private SoftAssertListner sAssert;


	public CopyContactPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
		sAssert = new SoftAssertListner(driver);
	}

	/******************************* COPY CONTACT PAGE ELEMENTS LOCATORS *******************/

	@FindBy(xpath = "//mat-row[1]//mat-cell[8]//button[1]//mat-icon[1]")
	
	private WebElement contextMenuIcon;
	@FindBy(xpath= "//button[contains(text(),'Copy')]")
	
	private WebElement copyButton;
	@FindBy(xpath= "//input[@formcontrolname='name']")
	
	private WebElement name;
	@FindBy(xpath= "//button[@class='mat-flat-button mat-button-base mat-primary']")
	
	private WebElement saveButton;
	@FindBy(xpath= "//span[text()='Contact Successfuly Added']")
	private WebElement copyContactSuccessMessage;
	
	/******************************* Verify Copied contacts elements *******************/

	@FindBy(xpath= "//input[@placeholder='Search Records']")
	
	private WebElement searchRecord;
	@FindBy(xpath= "//mat-table//mat-row[@class='mat-row ng-star-inserted']//mat-cell[3]")
	
	private WebElement enteredName;
	@FindBy(xpath= "//div[contains(text(),'Contact Name')]/following-sibling::div[@class='field-value']")
	
	private WebElement contactName;
	@FindBy(xpath= "//div[contains(text(),'Contact UEN')]/following-sibling::div[@class='field-value']")
	
	private WebElement uENnumber;
	@FindBy(xpath="//div[contains(text(),'Tax Number')]/following-sibling::div[@class='field-value']")
	
	private WebElement tax;
	@FindBy(xpath="//div[contains(text(),'Currency')]/following-sibling::div[@class='field-value']")
	
	private WebElement contactCurrency;
	@FindBy(xpath= "//div[contains(text(),'Purchase Account')]/following-sibling::div[@class='field-value']")
	
	private WebElement accPayable;
	@FindBy(xpath= "//div[contains(text(),'Sales Account')]/following-sibling::div[@class='field-value']")
	
	private WebElement accReceivable;
	@FindBy(xpath="//div[@class='section-container py-4']//div[4]//div[1]/following-sibling::div[@class='field-value']")
	
	private WebElement buyPaymentTerm;
	@FindBy(xpath="//div[@class='section-container py-4']//div[7]//div[1]/following-sibling::div[@class='field-value']")
	
	private WebElement sellPaymentTerm;
	@FindBy(xpath="//*[@id='container-1']/dt-navbar/div/div[1]/button/div/span")
	
	private WebElement companyOrg;
	@FindBy(xpath="//div[contains(text(),'Contact Organisation')]/following-sibling::div[@class='field-value']")
	
	private WebElement contactOrg;
	String organization;
	
	

	/*******************************Edit Contacts Object Manipulation Methods *******************/
	
	@Step("Open URL")
	public void openURL(String URL) {
		driver.get(URL);
	}
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	@Step("Click on Context menu icon")
	public void clickContextMenuIcon(){
		WDWait(contextMenuIcon);
		sAssert.assertTrue(contextMenuIcon.isDisplayed(),"Verify Context menu for contact");
		contextMenuIcon.click();
		sAssert.assertAll();

	}
	@Step("Click on copy button")
	public void clickCopyButton(){
		WDWait(copyButton);
		sAssert.assertTrue(copyButton.isDisplayed(),"Verify Copy button");
		copyButton.click();
		sAssert.assertAll();

	}
	@Step("Change name in general info")
	public void changeName(String cname){
		WDWait(name);
		name.clear();
		name.sendKeys(cname);
	}
	@Step("Click on Save button")
	public void clickSaveButton(){
		WDWait(saveButton);
		sAssert.assertTrue(saveButton.isDisplayed(),"Verify Save button");
		saveButton.click();
		sAssert.assertAll();

	}
	@Step("Verify success message")
	public void verifysuccessmessage(){
		WDWait(copyContactSuccessMessage);
		sAssert.assertTrue(copyContactSuccessMessage.isDisplayed(), "Verify copy contact success message");
        wait.until(ExpectedConditions.visibilityOf(copyContactSuccessMessage));
        sAssert.assertAll();
	}
	@Step("Verify copied contact")
	public void verifyCopiedContact(String cName, String UENNumber, String TAXNumber, String currency, String paymentTerms) throws InterruptedException{
		WDWait(searchRecord);
		searchRecord.click();
		searchRecord.sendKeys(cName);
		
		WDWait(enteredName);
		wait.until(ExpectedConditions.elementToBeClickable(enteredName));
		sAssert.assertEquals(enteredName.getText(), cName);
		enteredName.click();
		
		sAssert.assertEquals(contactName.getText(), cName);
		sAssert.assertEquals(uENnumber.getText(), UENNumber);
		sAssert.assertEquals(tax.getText(), TAXNumber);
		sAssert.assertEquals(contactCurrency.getText(), currency);
		organization= companyOrg.getText();
		sAssert.assertEquals(contactOrg.getText(),organization);


		scrollToElement(accPayable);
		wait.until(ExpectedConditions.visibilityOf(accPayable));
		Thread.sleep(5000);
		sAssert.assertEquals(accPayable.getText(), "Accounts Payable");
		
		scrollToElement(accReceivable);
		wait.until(ExpectedConditions.visibilityOf(accReceivable));
		Thread.sleep(5000);
		sAssert.assertEquals(accReceivable.getText(), "Accounts Receivable");

		sAssert.assertEquals(buyPaymentTerm.getText(), paymentTerms);
		sAssert.assertEquals(sellPaymentTerm.getText(), paymentTerms);

		sAssert.assertAll();

	}
	@Step("Scroll page")
	public void scrollToElement(WebElement element)
	{

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
		//sAssert.assertTrue(copyContactSuccessMessage.isDisplayed(),"Verify Success message for Contact creation");
		sAssert.assertAll();

	}
	
	

}
