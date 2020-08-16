package deskera.web.automation.erp.bvtSG.pages;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
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

public class EditContactPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;
	private SoftAssertListner sAssert;


	public EditContactPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
		sAssert = new SoftAssertListner(driver);

		
	}

	/******************************* EDIT CONTACT PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "//mat-row[1]//mat-cell[8]//button[1]//mat-icon[1]")
	

	private WebElement contextMenuIcon;
	@FindBy(xpath= "//button[contains(text(),'Edit')]")
	
	private WebElement editButton;
	@FindBy(xpath= "//input[@formcontrolname='name']")
	
	private WebElement name;
	@FindBy(xpath= "//input[@formcontrolname='email']")
	
	private WebElement emailAddress;
	@FindBy(xpath= "//input[@formcontrolname='uen']")
	
	private WebElement contactUEN;
	@FindBy(xpath= "//input[@formcontrolname='tax']")
	
	private WebElement taxNumber;
	
	@FindBy(xpath= "//div[contains(text(),'Address')]")
	
	private WebElement address;
	@FindBy(xpath= "//textarea[@formcontrolname='address1']")
	
	private WebElement enterAddress;
	@FindBy(xpath= "//input[@formcontrolname='state']")
	
	private WebElement state;
	@FindBy(xpath= "//input[@formcontrolname='postalCode']")
	
	private WebElement postalCode;
	@FindBy(xpath= "//input[@formcontrolname='city']")
	
	private WebElement city;
	@FindBy(xpath= "//input[@formcontrolname='country']")
	
	private WebElement country;
	
	@FindBy(xpath= "//span[@class='field-value add-address']")
	
	private WebElement addAnotherAddress;

	@FindBy(xpath= "//div[contains(text(),'Current Billing Address')]")
	
	private WebElement currentBillingAddress;

	@FindBy(xpath= "//div[contains(text(),'Current Shipping Address')]")
	
	private WebElement currentShippingAddress;
	
	@FindBy(xpath= "//span[contains(text(),'Save Changes')]")
	
	private WebElement saveChangeButton;
	
	@FindBy(xpath= "//span[text()='Contact is successfully Updated']")
	
	private WebElement updateContactSuccessMessage;
	
	/******************************* Verify edited contact objects *******************/
	
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
	@Step("Search contact to edit")
	public void searchRecord(String cName) throws InterruptedException{
		WDWait(searchRecord);
		searchRecord.click();
		searchRecord.sendKeys(cName);
		Thread.sleep(3000);
		/*Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();*/
		sAssert.assertAll();

		
	}
	@Step("Click on Context Menu icon")
	public void clickContextMenuIcon() throws InterruptedException{
		WDWait(contextMenuIcon);
		sAssert.assertTrue(contextMenuIcon.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(contextMenuIcon));
		Thread.sleep(3000);
		contextMenuIcon.click();
		Thread.sleep(4000);
		sAssert.assertAll();

	}
	@Step("Click on Edit button")
	public void clickEditButton() throws InterruptedException{
		
		WDWait(editButton);
		sAssert.assertTrue(editButton.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
		Thread.sleep(3000);
		editButton.click();	
		sAssert.assertAll();

		
	}
	@Step("Enter new general info")
	public void editGeneralInfo(String cname,String email, String uenno, String taxno){
		WDWait(name);
		name.clear();
		name.sendKeys(cname);
		
		WDWait(emailAddress);
		emailAddress.clear();
		emailAddress.sendKeys(email);
		
		WDWait(contactUEN);
		contactUEN.clear();
		contactUEN.sendKeys(uenno);
		
		WDWait(taxNumber);
		taxNumber.clear();
		taxNumber.sendKeys(taxno);
		sAssert.assertAll();

	}
	@Step("Enter new address info")
	public void editAddressInfo(String addr, String state1,String postal, String city1, String country1){ 
		WDWait(address);
		sAssert.assertTrue(address.isDisplayed(),"Enter address");
		address.click();
		
		WDWait(enterAddress);
		enterAddress.clear();
		enterAddress.sendKeys(addr);
		
		WDWait(state);
		state.clear();
		state.sendKeys(state1);
		
		WDWait(postalCode);
		postalCode.clear();
		postalCode.sendKeys(postal);
		
		WDWait(city);
		city.clear();
		city.sendKeys(city1);
		
		WDWait(country);
		country.clear();
		country.sendKeys(country1);
		
		WDWait(addAnotherAddress);
		sAssert.assertTrue(addAnotherAddress.isDisplayed(), "Verify add another address button");
		
		WDWait(currentBillingAddress);
		sAssert.assertTrue(currentBillingAddress.isDisplayed(),"Verify billing address");
		
		WDWait(currentShippingAddress);
		sAssert.assertTrue(currentShippingAddress.isDisplayed(), "verify shipping address buttonss");

		sAssert.assertAll();

	}
	@Step("Click on save and change button")
	public void clickSaveChangeButton(){
		WDWait(saveChangeButton);
		sAssert.assertTrue(saveChangeButton.isDisplayed(), "Verify save and change button");
		saveChangeButton.click();
		sAssert.assertAll();

	}
	@Step("Verify success message")
	public void verifysuccessmessage(){
		WDWait(updateContactSuccessMessage);
		sAssert.assertTrue(updateContactSuccessMessage.isDisplayed(), "Verify edit contact success message");
        wait.until(ExpectedConditions.visibilityOf(updateContactSuccessMessage));
		sAssert.assertAll();


	}
	@Step("Verify copied contact")
	public void verifyEditedContact(String cName, String UENNumber, String TAXNumber, String currency, String paymentTerms) throws InterruptedException{
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
		sAssert.assertAll();

	}
	
	
}
