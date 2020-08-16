package deskera.web.automation.erp.bvtSG.pages;

import java.util.List;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import deskera.web.automation.core.SoftAssertListner;
import io.qameta.allure.Step;

public class ContactsPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;
	private SoftAssertListner sAssert;

	public ContactsPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
		sAssert = new SoftAssertListner(driver);
	}

	/******************************* CONTACTS PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "//span[text()=' Contacts ']")
	
	private WebElement contactsButton;

	@FindBy(xpath ="//span[contains(text(),'Add Contact')]")
	
	private WebElement  addContactButton;
	@FindBy(xpath= "//button[@class='mat-long-button mat-flat-button mat-button-base mat-primary']")
	
	private WebElement newContactButton;
	@FindBy(xpath= "//span[contains(.,'Start by Adding or Importing Your Contacts')]")
	
	private List<WebElement> startByAddingOrImportingYourContacts;

	private static String pageTitleText = "Deskera Books";
	
	@FindBy(css = "	i.fas.fa-times.close-button.mt-2")
	
	private WebElement closeOverlayPopup;
	


	/******************************* ADD CONTACT PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath= "//div[contains(text(),'General Info')]")
	
	private WebElement generalInfotab;
	@FindBy(xpath= "//input[@formcontrolname='name']")
	
	private WebElement name;
	@FindBy(xpath= "//input[@formcontrolname='email']")
	
	private WebElement emailAddress;
	@FindBy(xpath= "//input[@formcontrolname='uen']")
	
	private WebElement contactUEN;
	@FindBy(xpath= "//input[@formcontrolname='tax']")
	
	private WebElement taxNumber;
	@FindBy(xpath= "//div[@class='currency-dropdown-code']")
	
	private WebElement currency;
	@FindBy(xpath= "//input[@name='sequenceValue']")
	
	private WebElement autoNumberingFormat;

	@FindBy(xpath="//div[contains(text(),'Accounting')]")
	
	private WebElement accountingtab;
	@FindBy(xpath= "//p[contains(text(),'Payment Terms')]")
	
	private WebElement paymentTerms;
	@FindBy(xpath= "//div[@class='mat-form-field-infix']/mat-select[@formcontrolname='paymentTermCode']")
	
	private WebElement paymentTermsList;

	@FindBy(xpath="//span[contains(text(),'NET 0')]")
	
	private WebElement selectNET0;
	@FindBy(xpath="//span[contains(text(),'NET 10')]")
	
	private WebElement selectNET10;
	@FindBy(xpath="//span[contains(text(),'NET 15')]")
	
	private WebElement selectNET15;
	@FindBy(xpath= "//span[@class='mat-option-text'][contains(text(),'NET 30')]")
	
	private WebElement selectNET30;
	@FindBy(xpath= "//span[contains(text(),'NET 45')]")
	
	private WebElement selectNET45;

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
	@FindBy(xpath="//div[contains(text(),'Set as Current Billing Address')]")
		
	private WebElement setAsCurrentBillingAddress;
	@FindBy(xpath="//div[contains(text(),'Set as Current Shipping Address')]")
	
	private WebElement setAsCurrentShippingAddress;
	@FindBy(xpath="//span[@class='field-value add-address']")
	
	private WebElement addAnotherAddress;
	@FindBy(xpath= "//button[@class='mat-flat-button mat-button-base mat-primary']")
	
	private WebElement saveButton;
	@FindBy(xpath= "//div//i[contains(@class,'fa-times close-button m')]//self::i[1]")
	
	private WebElement cancel;
	@FindBy(xpath= "(//input[@aria-autocomplete='list'])[1]")
	
	private WebElement accountPayable;
	@FindBy(xpath="(//input[@aria-autocomplete='list'])[2]")
	
	private WebElement accountReceivable;

	@FindBy(xpath= "//span[text()='Contact Successfuly Added']")
	
	private WebElement createContactSuccessMessage;

	/******************************* Verify Added contacts elements *******************/


	@FindBy(xpath= "//mat-cell[contains(text(),'Edward')]")
	
	private WebElement addedContactName;
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

	@FindBy(xpath= "//mat-table//mat-row[@class='mat-row ng-star-inserted']//mat-cell[3]")
	
	private WebElement enteredName;
	
	@FindBy(xpath="//*[@id='container-1']/dt-navbar/div/div[1]/button/div/span")
	
	private WebElement companyOrg;
	@FindBy(xpath="//div[contains(text(),'Contact Organisation')]/following-sibling::div[@class='field-value']")
	
	private WebElement contactOrg;
	
	@FindBy(xpath="//div[contains(text(),'Accounts Receivable')]")
	
	private WebElement enteredpurchaseAccount;
	@FindBy(xpath= "//div[@class='section-container py-4']//div[4]//div[2]")
	
	private WebElement enteredPaymentTerms;
	String buyAccount,sellAccount;

	@FindBy(xpath= "//input[@placeholder='Search Records']")
	
	private WebElement searchRecord;
	
	@FindBy(xpath= "//*[@id='container-3']/extn-content/ng-contact-list/div/div/div[2]/div[2]/div[1]/span[2]")
	
	private WebElement allSummaryCount;
	
	String organization;
	
	/******************************* Custom Number Format Objects 	*******************************/

	@FindBy(xpath= "//span[@class='menu-label ng-star-inserted'][contains(text(),'Custom Fields')]")
	
	private WebElement customField;
	@FindBy(xpath= "//span[contains(text(),'Cancel')]")
	
	private WebElement customCancelButton;
	@FindBy(xpath= "//span[contains(text(),'Custom Number Format')]")
	
	private WebElement customNumberFormat;

	@FindBy(xpath = "//mat-label[contains(.,'Preview')]")
	
	private WebElement previewLabel;
	@FindBy(xpath = "//div//div[contains(@class,'result mt')]")
	
	private WebElement previewBox;
	@FindBy(xpath = "//input[@placeholder='Enter prefix']")
	
	private WebElement prefixTextBox;
	@FindBy(xpath = "(//div[@class='mat-select-arrow'])[2]")
	
	private WebElement separatorDropdown;
	@FindBy(xpath = "//input[@placeholder='Enter display digits']")
	
	private WebElement displayDigits;
	@FindBy(xpath = "(//div[@class='mat-select-arrow'])[3]")
	
	private WebElement separatorDropdownAfterDigits;
	@FindBy(xpath = "//input[contains(@placeholder,'Enter suffix')]")
	
	private WebElement suffixTextBox;
	@FindBy(xpath = "//div[@class='mat-checkbox-inner-container']//following::span[contains(.,'Set as Default ')]")
	
	private WebElement setAsDefault;
	@FindBy(xpath= "//span[contains(text(),'Cancel')]")
	
	private WebElement cusomNumberFormatCancelButton;
	@FindBy(xpath = "(//button[contains(.,'Save')])[2]")
	
	private WebElement customNumberFormatSaveButton;
	@FindBy(xpath = "//span[@class='mat-option-text'][contains(.,'-')]")
	
	private WebElement hyphen;
	@FindBy(xpath = "//span[@class='mat-option-text'][contains(.,'-')]")
	
	private WebElement hypenAfterDigits;
	@FindBy(xpath = "//input[contains(@placeholder,'Auto-Numbering Format')]")
	
	private WebElement autoNumberingformat;
	@FindBy(xpath = "//div[@class='section-container pb-4']//div[3]//div[1]/following-sibling::div[@class='field-value']")
	
	private WebElement displayedNumber;
	String customFormatNumber="U-0001-C";



	/******************************* Contacts Object Manipulation Methods *******************/
	@Step("Open URl")
	public void openURL(String URL) {
		driver.get(URL);
	}
	@Step("Verify page title")
	public void verifyPageTitle() {
		sAssert.assertEquals(driver.getTitle(), pageTitleText);
		sAssert.assertAll();
	}
	// Common util for webdriver wait
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	@Step("verify contact elements")
	public void verifyContactElements(){
		WDWait(contactsButton);
		sAssert.assertTrue(contactsButton.isDisplayed(),"Verify Contact Section link");
		sAssert.assertAll();
	}
	@Step("Click on contact button")
	public void clickContactsButton() throws InterruptedException{
		WDWait(contactsButton);
		contactsButton.click(); 
		clickPopup();
		sAssert.assertAll();
	}
	@Step("close popup on contacts page")
	public void clickPopup() throws InterruptedException{	
		//driver.get("https://reality-qa.deskera.xyz/book-keeper/client");
		WDWait(contactsButton);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' Contacts ']"))); // Contact // link                                                                                                            // or                                                                                                            // Produ                                                                                                            // link
		//driver.findElement(By.xpath("//span[text()=' Contacts ']")).click();
		contactsButton.click();
		Thread.sleep(3000); // THis is important because popup gets loaded and then disappears
		// driver.findElement(By.cssSelector("i.fas.fa-times.close-button.mt-2")).click();
		for (int second = 0; second <= 15; second++) {
			if (second == 15) {
				System.out.println("Popup Not found!");
				break;
			}
			try {
				if (closeOverlayPopup.isDisplayed()) {
					System.out.println("closig popup now 1");
					closeOverlayPopup.click(); //popup close button
					System.out.println("closed popup  1");
					break;
				}
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}
	@Step("click on new contact button")
	public void clickAddContactButton(){
		WDWait(newContactButton);
		sAssert.assertTrue(newContactButton.isDisplayed(),"Verify New Contact Button");
		newContactButton.click();

		
		/*


		WDWait(customNumberFormat);
		sAssert.assertTrue(customNumberFormat.isDisplayed(),"Verify Custom Number format option");
		customNumberFormat.click();

		WDWait(cusomNumberFormatCancelButton);
		sAssert.assertTrue(cusomNumberFormatCancelButton.isDisplayed(),"");
		cusomNumberFormatCancelButton.click();
		WDWait(customField);
		sAssert.assertTrue(customField.isDisplayed(),"Verify Custom filed option");
		customField.click();
		WDWait(customCancelButton);
		customCancelButton.isDisplayed();
		customCancelButton.click();*/
		

		WDWait(generalInfotab);
		sAssert.assertTrue(generalInfotab.isDisplayed(),"Veify generalInfotab");
		generalInfotab.click();
		
		sAssert.assertAll();

	}
	@Step("Enter general info")
	public void enterGeneralInfo(String Cname, String email, String UEN, String tax) throws InterruptedException{
		WDWait(name);

		//wait.until(ExpectedConditions.elementToBeClickable(name));
		sAssert.assertTrue(name.isDisplayed(),"");
		name.sendKeys(Cname);
		WDWait(emailAddress);
		emailAddress.sendKeys(email);
		WDWait(contactUEN);
		contactUEN.sendKeys(UEN);		
		WDWait(taxNumber);
		taxNumber.sendKeys(tax);
		Thread.sleep(3000);
		sAssert.assertTrue(currency.isDisplayed(),"Verify currency");
		sAssert.assertEquals(currency.getText(), "Singapore Dollar (SGD)");
		sAssert.assertTrue(autoNumberingFormat.isDisplayed(),"Verify autoNumberingFormat");

		WDWait(saveButton);
		sAssert.assertTrue(saveButton.isDisplayed(),"Verify saveButton");
		sAssert.assertAll();

	}
	@Step("Enter account details")
	public void enterAccountingDetails(){
		WDWait(accountingtab);
		sAssert.assertTrue(accountingtab.isDisplayed(),"Verify accountingtab");
		accountingtab.click();
		sAssert.assertTrue(paymentTerms.isDisplayed(),"Verify paymentTerms");
		sAssert.assertEquals(paymentTermsList.getText(), "NET 30");

		WDWait(paymentTermsList);
		sAssert.assertTrue(paymentTermsList.isDisplayed(),"Verify paymentTermsList");
		paymentTermsList.click();
		selectNET0.isDisplayed();
		selectNET10.isDisplayed();
		selectNET15.isDisplayed();
		selectNET45.isDisplayed();
		selectNET30.isDisplayed();
		selectNET30.click();

		WDWait(accountPayable);
		sAssert.assertTrue(accountPayable.isDisplayed());
		buyAccount=accountPayable.getAttribute("value");
		sAssert.assertEquals(accountPayable.getAttribute("value"), "Accounts Payable");

		WDWait(accountReceivable);
		sAssert.assertTrue(accountReceivable.isDisplayed());
		sellAccount=accountReceivable.getAttribute("value");
		sAssert.assertEquals(accountReceivable.getAttribute("value"), "Accounts Receivable");
		
		sAssert.assertAll();


	}
	@Step("Verify address details")
	public void addressDetails() throws InterruptedException{
		WDWait(address);
		sAssert.assertTrue(address.isDisplayed());
		address.click();
		Thread.sleep(3000);
		sAssert.assertTrue(enterAddress.isDisplayed());
		sAssert.assertTrue(state.isDisplayed());
		sAssert.assertTrue(postalCode.isDisplayed());
		sAssert.assertTrue(city.isDisplayed());
		sAssert.assertTrue(country.isDisplayed());
		sAssert.assertTrue(setAsCurrentBillingAddress.isDisplayed());
		sAssert.assertTrue(setAsCurrentShippingAddress.isDisplayed());
		sAssert.assertTrue(addAnotherAddress.isDisplayed());
		
		
		sAssert.assertAll();

	}
	@Step("Enter address details")
	public void addAddressDetail(String addr, String state1,String postal, String city1, String country1){ 
		WDWait(enterAddress);
		enterAddress.sendKeys(addr);
		WDWait(state);
		state.sendKeys(state1);
		WDWait(postalCode);
		postalCode.sendKeys(postal);
		WDWait(city);
		city.sendKeys(city1);
		WDWait(country);
		country.sendKeys(country1);
		
		sAssert.assertAll();

	}
	@Step("Click on save button")
	public void clickSaveButton(){
		saveButton.click();
		sAssert.assertAll();

	}
	@Step("Verify added contacts")
	public void verifyAddedContacts(String cName, String UENNumber, String TAXNumber,String currency, String paymentTerms) throws InterruptedException{

		WDWait(searchRecord);
		searchRecord.click();
		searchRecord.sendKeys(cName);

		/*Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();*/

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
		sAssert.assertEquals(accPayable.getText(), buyAccount);
		scrollToElement(accReceivable);
		wait.until(ExpectedConditions.visibilityOf(accReceivable));
		Thread.sleep(5000);
		sAssert.assertEquals(accReceivable.getText(), sellAccount);
		
		sAssert.assertEquals(buyPaymentTerm.getText(), paymentTerms);
		sAssert.assertEquals(sellPaymentTerm.getText(), paymentTerms);
		
		
		/*WDWait(customField);
		customField.isDisplayed();
		customField.click();
		WDWait(customCancelButton);
		customCancelButton.isDisplayed();
		customCancelButton.click();*/
		sAssert.assertAll();


	}
	@Step("Verify success message")
	public void verifyContactCreatedSucessMessage(){
		WDWait(createContactSuccessMessage);
		sAssert.assertTrue(createContactSuccessMessage.isDisplayed(),"Verify create contacts success message");
		wait.until(ExpectedConditions.visibilityOf(createContactSuccessMessage));
		sAssert.assertAll();


	}
	@Step("Verify summary count")
	public void allSummaryCountForFirstContact(){
		WDWait(allSummaryCount);
		sAssert.assertTrue(allSummaryCount.isDisplayed(),"Verify all summary count");
		sAssert.assertEquals(allSummaryCount.getText(), "1");
		sAssert.assertAll();
	}
	@Step("Verify summary count")
	public void allSummaryCountForSecondContact(){
		WDWait(allSummaryCount);
		sAssert.assertTrue(allSummaryCount.isDisplayed(),"Verify all summary count");
		sAssert.assertEquals(allSummaryCount.getText(), "2","Verify count of 2 contacts displayed for All Summary");
		sAssert.assertAll();
		

	}
	@Step("Clilck on custom number format link")
	public void clickCustomNumberFormat(){
		WDWait(customNumberFormat);
		sAssert.assertTrue(customNumberFormat.isDisplayed());
		customNumberFormat.click();
		sAssert.assertAll();
	}
	@Step("Verify Custom Number Format Page Elements ")
	public void verifyCustomNumberFormatPageElements() {
		WDWait(previewLabel);
		sAssert.assertTrue(previewLabel.isDisplayed(), "Verify preview label");
		sAssert.assertTrue(previewBox.isDisplayed(),"Verify preview box");
		sAssert.assertTrue(prefixTextBox.isDisplayed(),"Verify prefix text box");
		sAssert.assertTrue(separatorDropdown.isDisplayed(),"Verify drop down field");
		sAssert.assertTrue(displayDigits.isDisplayed(),"Verify display digits");
		sAssert.assertTrue(separatorDropdownAfterDigits.isDisplayed(),"verify seperator drop down after digits");
		sAssert.assertTrue(suffixTextBox.isDisplayed(),"sAssert.assertTrue(erify suffix text box");
		sAssert.assertTrue(setAsDefault.isDisplayed(),"Verify set as default field");
		sAssert.assertTrue(cusomNumberFormatCancelButton.isDisplayed(),"Verify custom number format cancel button");
		sAssert.assertTrue(customNumberFormatSaveButton.isDisplayed(),"Verify custom number format save button");
		sAssert.assertAll();
	}
	@Step("Enter Custom Number format details ")
	public void enterCustomNumberFormatDetails() {
		WDWait(prefixTextBox);
		prefixTextBox.sendKeys("U");
		wait.until(ExpectedConditions.elementToBeClickable(separatorDropdown));
		separatorDropdown.click();
		WDWait(hyphen);
		hyphen.click();
		displayDigits.clear();
		displayDigits.sendKeys("4");
		wait.until(ExpectedConditions.elementToBeClickable(separatorDropdownAfterDigits));
		separatorDropdownAfterDigits.click();
		WDWait(hypenAfterDigits);
		hypenAfterDigits.click();
		WDWait(suffixTextBox);
		suffixTextBox.sendKeys("C");	
		sAssert.assertAll();
	}
	@Step("Preview Custom Number format")
	public void previewCustomNumberFormat() {
		WDWait(previewBox);
		sAssert.assertEquals(previewBox.getText(), customFormatNumber);	
		sAssert.assertAll();
	}
	@Step("Click on Save Button on Custom Number Format Page")
	public void clickSaveCustomNumberFormatButton() throws InterruptedException {
		WDWait(customNumberFormatSaveButton);
		customNumberFormatSaveButton.click();
		//Thread.sleep(4000);
		sAssert.assertAll();
	}
	@Step("Verify Custom Number Format In Contact Number")
	public void verifyCustomNumberFormatInContactNumber() throws InterruptedException {
		WDWait(autoNumberingformat);
		Thread.sleep(5000);
		sAssert.assertEquals(autoNumberingformat.getAttribute("value"), customFormatNumber);	
		sAssert.assertAll();
	}
	@Step("Verify Contact Number and Format")
	public void verifyCustomFormatNumber() {
		WDWait(displayedNumber);
		Actions action = new Actions(driver);
		action.moveToElement(displayedNumber).perform();
		sAssert.assertEquals(displayedNumber.getText(), customFormatNumber);
		sAssert.assertAll();
	}
	@Step("Scroll page")
	public void scrollToElement(WebElement element)
	{

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
		sAssert.assertAll();
	}
	
	
}
