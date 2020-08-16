package deskera.web.automation.erp.bvtSG.pages;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class BuyPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;
	private SoftAssertListner sAssert;

	public BuyPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
		sAssert = new SoftAssertListner(driver);
	}

	/*******************************
	 * BUY PAGE ELEMENTS LOCATORS
	 *******************/
	@FindBy(xpath = "//span[@class='ng-star-inserted'][contains(.,'Buy')]")
	private WebElement buyTab;
	@FindBy(xpath = "//h1[contains(.,'Buy Records')]")
	private WebElement buyRecordHeading;
	@FindBy(xpath = "//button[contains(.,'Create New')]")
	
	private WebElement createNewButton;
	@FindBy(xpath = "//div[@class='summary-title'][contains(.,'Order Total') or contains(.,'Orders Total')]")
	
	private WebElement orderTotal;
	@FindBy(xpath = "//h5[contains(text(),'1')]")
	private WebElement orderTotalCount;
	@FindBy(xpath = "//div[@class='summary-title'][contains(.,'Bill Total') or contains(.,'Bills Total')]")
	
	private WebElement billTotal;
	@FindBy(xpath = "//div[@class='summary-title'][contains(.,'Archive Total') or contains(.,'Archived Total')]")
	
	private WebElement archiveTotal;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Number arrow_drop')]")
	
	private WebElement numberColumn;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Contact arrow_drop')]")
	
	private WebElement contactColumn;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Due Date arrow_drop')]")
	private WebElement dueDateColumn;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Total Amount')]")
	private WebElement totalAmountColumn;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Goods Received')]")
	private WebElement goodsReceivedColumn;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Quick Actions')]")
	private WebElement quickAction;
	@FindBy(xpath = "//button[contains(.,'New Order')]")
	private WebElement newOrderButton;
	private static String pageTitleText = "Deskera Books";

	/****************************
	 * CREATE NEW ORDER PAGE ELEMENTS LOCATORS
	 *******************/

	@FindBy(xpath = "//button[contains(.,'Save')]")
	private WebElement saveButton;
	@FindBy(xpath = "//span[contains(.,'+ Add a contact')]")
	private WebElement addContactButton;
	@FindBy(xpath = "//input[@formcontrolname='documentDate']")
	private WebElement orderDate;
	@FindBy(xpath = "//input[@formcontrolname='validTillDate']")
	private WebElement dueDate;
	@FindBy(xpath = "//span[contains(.,'+ Add a Line Item')]")
	private WebElement addLineItemButton;
	@FindBy(xpath = "//h5[contains(.,'Order Settings')]")
	private WebElement orderSettingText;
	@FindBy(xpath = "//span[contains(.,'Customize Number Format')]")
	private WebElement customizeNumberFormat;
	@FindBy(xpath = "//span[contains(.,'Global Custom Fields')]")
	private WebElement globalCustomFields;
	@FindBy(xpath = "//span[contains(text(),'Multi-Currency Options')]")
	private WebElement multiCurrencyOptions;
	@FindBy(xpath = "(//span[@class='mat-option-text'])[2]")
	private WebElement firstContact;
	@FindBy(xpath = "(//input[@aria-autocomplete='list'])[1]")
	private WebElement typeHere;
	@FindBy(xpath = "(//input[@aria-autocomplete='list'])[1]")
	private WebElement pTypeHere;
	@FindBy(xpath = "(//span[contains(@class,'mat-option-text')])[1]")
	private WebElement firstProduct;
	@FindBy(xpath = "//input[@formcontrolname='productQuantity']")
	private WebElement pQuantity;
	@FindBy(xpath = "(//input[@role='combobox'])[2]")
	private WebElement pTax;
	@FindBy(xpath = "//mat-checkbox[@formcontrolname='unitPriceGstInclusive']/label/span[1]")
	
	private WebElement unitPriceIsTaxInclusive;
	@FindBy(xpath = "//input[@formcontrolname='unitPrice']")
	private WebElement unitPriceTextBox;
	@FindBy(xpath = "//input[@formcontrolname='discountString']")
	private WebElement discountTextBox;
	@FindBy(xpath = "(//div[@class='mat-form-field-infix']//div[@class='mat-input-element read-only-value'])[2]")
	private WebElement amountSGD;
	@FindBy(xpath = "//span[text()='Order has been saved successfully']")
	private WebElement ordercreatedSuccessMessage;
	@FindBy(xpath = "//*[@id='container-3']/extn-content/ng-list/div/div/mat-table/mat-row/mat-cell[5]/span")
	private WebElement verifyAmountInGrid;
	String amount;

	/****************************
	 * CONVERT ORDER TO BILL PAGE ELEMENTS LOCATORS
	 *******************/

	@FindBy(xpath = "//input[@placeholder='Search Records']")
	private WebElement searchRecord;
	@FindBy(xpath = "//mat-table//mat-row[@class='mat-row ng-star-inserted']//mat-cell[3]")
	private WebElement contactName;
	@FindBy(xpath = "//span[contains(text(),'Convert to Bill')]")
	private WebElement convertToBillButton;
	@FindBy(xpath = "//div[@class='mat-dialog-title']//span[contains(text(),'Convert to Bill')]")
	private WebElement convertToBillHeading;
	@FindBy(xpath = "//span[contains(text(),'Convert (Auto-Received)')]")
	private WebElement convertAutoReceivedbutton;
	@FindBy(xpath = "//span[contains(text(),'Convert Only')]")
	private WebElement convertOnlyButton;
	@FindBy(xpath = "//span[contains(text(),'Order is billed successfully')]")
	private WebElement convertBillSucessMsg;

	
	/****************************
	 * CREATE NEW BILL PAGE ELEMENTS LOCATORS
	 *******************/

	@FindBy(xpath = "//button[contains(.,'New Bill')]")
	private WebElement newBillButton;
	@FindBy(xpath = "//input[@formcontrolname='documentDate']")
	private WebElement billDate;
	@FindBy(xpath = "//h5[contains(.,'Bill Settings')]")
	
	private WebElement billSettingText;
	@FindBy(xpath = "//div[@class='canvas-title']")
	private WebElement billText;
	@FindBy(xpath = "//span[text()='Bill has been saved successfully']")
	private WebElement billcreatedSuccessMessage;
	@FindBy(xpath = "//h5[contains(text(),'1')]")
	private WebElement billTotalCount;
	@FindBy(xpath = "//div[@class='tab-container activeTab ng-star-inserted']")
	private WebElement billCard;

	@FindBy(xpath = "//span[contains(text(),'Receive Goods')]")
	private WebElement receivedGoodsButton;
	@FindBy(xpath = "//input[@formcontrolname='receiptQuantity']")
	private WebElement receivingTextBox;
	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	private WebElement cancelButton;
	@FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(text(),'Receive')]")
	private WebElement receiveButton;
	@FindBy(xpath = "//span[contains(text(),'Make Payment')]")
	private WebElement makePaymentButton;
	@FindBy(xpath = "//div[@class='mat-dialog-title'][contains(.,'Make Payment')]")
	private WebElement makePaymentHeading;
	@FindBy(xpath = "//div[contains(text(),'General')]")
	private WebElement generalTab;
	@FindBy(xpath = "//div[contains(text(),'Confirm')]")
	private WebElement confirmTab;
	@FindBy(xpath = "//div[contains(text(),'Current Outstanding')]")
	private WebElement currentOustandingText;
	@FindBy(xpath = "//span[@class='statusBadge due-in']")
	private WebElement dueInLabel;
	@FindBy(xpath = "//span[@class='dueAmount']//span[contains(text(),'SGD')]")
	private WebElement sgdCurrency;
	@FindBy(xpath = "//span[@class='dueAmount']")
	private WebElement displayedAmount;
	@FindBy(xpath = "//input[@formcontrolname='documentDate']")
	private WebElement paymentDate;
	@FindBy(xpath = "//div[@class='currency-dropdown-code']")
	private WebElement currencyDropdown;
	@FindBy(xpath = "//div[@class='amount']//input[@inputtype='decimal']")
	private WebElement paymentAndCurrencyAmount;
	@FindBy(xpath = "//div[@class='mat-select-value']//span[contains(.,'Pay From')]")
	private WebElement payFromDropDown;
	@FindBy(xpath = "//span[contains(text(),'Cash')]")
	private WebElement clickOnCash;
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	private WebElement nextButton;
	@FindBy(xpath = "//div[@class='payment-preview-title']")
	private WebElement confirmPaymentMadeText;
	@FindBy(xpath = "//div[contains(text(),'Pay From')]/following-sibling::div")
	private WebElement payfromCash;
	@FindBy(xpath = "//span[contains(text(),'Back')]")
	private WebElement backButton;
	@FindBy(xpath = "//button[@class='mat-flat-button mat-stroked-button mat-button-base mat-primary ng-star-inserted']//span[@class='mat-button-wrapper'][contains(text(),'Pay')]")
	private WebElement payButton;
	@FindBy(xpath = "//span[contains(text(),'Close')]")
	private WebElement closeButton;
	@FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(text(),'Print')]")
	private WebElement printButton;
	@FindBy(xpath = "//span[text()='1 Payment Received']")
	private WebElement paymentReceivedSuccessMessage;

	/*******************************
	 * Archive Bill Page Element Locators
	 *******************/

	@FindBy(xpath = "//mat-row[1]//mat-cell[8]//button[2]//span[1]//mat-icon[1]")
	private WebElement contextMenuIcon;
	@FindBy(xpath = "//button[contains(text(),'Archive Bill')]")
	private WebElement archiveBillButton;
	@FindBy(xpath = "//h5[contains(text(),'1')]")
	private WebElement archiveTotalCount;
	
	
	/*******************************
	 * Reopen Bill/Order Page Element Locators
	 *******************/
	@FindBy(xpath = "//mat-row[1]//mat-cell[8]//button[1]//span[1]//mat-icon[1]")
	private WebElement archiveContextMenuIcon; 
	@FindBy(xpath = "//button[contains(text(),'Reopen')]")
	private WebElement reopenButton;
	@FindBy(xpath = "//div[@class='no-records ng-star-inserted']")
	private WebElement noMatchingRecord;
	
	/*******************************
	 * Archive Order Page Element Locators
	 *******************/
	@FindBy(xpath = "//mat-row[1]//mat-cell[7]//button[2]//span[1]//mat-icon[1]")
	private WebElement orderContextMenuIcon;
	@FindBy(xpath = "//button[contains(text(),'Archive Order')]")
	private WebElement archiveOrderButton;
	@FindBy(xpath = "//div[@class='tabs-container']//div[3]")
	private WebElement archiveCard;
	@FindBy(xpath = "//span[contains(text(),'Cancelled')]")
	private WebElement cancelledStatus;
	
	/*******************************
	 * Buy Object Manipulation Methods
	 *******************/
	@Step("Open URl")
	public void openURL(String URL) {
		driver.get(URL);
	}

	@Step("Verify page title")
	public void verifyPageTitle() {
		sAssert.assertEquals(driver.getTitle(), pageTitleText);
		sAssert.assertAll();
	}
	public void MOverElement(WebElement we) throws InterruptedException
	{
		Actions action = new Actions(driver);
		action.moveToElement(we).perform();
		Thread.sleep(1000);
	}


	// Common util for webdriver wait
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}

	@Step("verify buytab elements")
	public void verifybuytabElements() {
		WDWait(buyTab);
		sAssert.assertTrue(buyTab.isDisplayed(), "Verify Buy tab");
		sAssert.assertAll();

	}

	@Step("Click on buytab button")
	public void clickbuytab() throws InterruptedException {
		WDWait(buyTab);
		buyTab.click();
		clickPopup();
		sAssert.assertAll();

	}

	@Step("close popup on buy page")
	public void clickPopup() throws InterruptedException {
		// driver.get("https://reality-qa.deskera.xyz/book-keeper/client");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[@class='ng-star-inserted'][contains(.,'Buy')]"))); // Contact
																												// //
																												// link
																												// //
																												// or
																												// //
																												// Produ
																												// //
																												// link
		driver.findElement(By.xpath("//span[@class='ng-star-inserted'][contains(.,'Buy')]")).click();
		Thread.sleep(3000); // THis is important because popup gets loaded and
							// then disappears
		// driver.findElement(By.cssSelector("i.fas.fa-times.close-button.mt-2")).click();
		for (int second = 0; second <= 15; second++) {
			if (second == 15) {
				System.out.println("Popup Not found clickin on create new Button");
				break;
			}
			try {
				if (driver.findElement(By.cssSelector("i.fas.fa-times.close-button.mt-2")).isDisplayed()) {
					System.out.println("closig popup now 1");
					driver.findElement(By.cssSelector("i.fas.fa-times.close-button.mt-2")).click(); // popup
																									// close
																									// button
					System.out.println("closed popup  1");
					break;
				}
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}

	@Step("Verify Buy page elements")
	public void verifyBuyPageElement() {
		WDWait(buyRecordHeading);
		sAssert.assertTrue(buyRecordHeading.isDisplayed(),"Verify buy record heading");
		sAssert.assertTrue(createNewButton.isDisplayed());
		sAssert.assertTrue(orderTotal.isDisplayed());
		sAssert.assertTrue(billTotal.isDisplayed());
		sAssert.assertTrue(archiveTotal.isDisplayed());
		sAssert.assertTrue(numberColumn.isDisplayed());
		sAssert.assertTrue(contactColumn.isDisplayed());
		sAssert.assertTrue(dueDateColumn.isDisplayed());
		sAssert.assertTrue(totalAmountColumn.isDisplayed());
		sAssert.assertTrue(goodsReceivedColumn.isDisplayed());
		sAssert.assertTrue(quickAction.isDisplayed());
		
		sAssert.assertAll();

	}

	@Step("Click On Create New Button and then Click on New Order")
	public void clickCreatNew() {
		WDWait(createNewButton);
		wait.until(ExpectedConditions.elementToBeClickable(createNewButton));
		createNewButton.click();
		sAssert.assertAll();

	}

	@Step(" Click on New Order")
	public void clickOnNewOrder() {
		WDWait(newOrderButton);
		wait.until(ExpectedConditions.elementToBeClickable(newOrderButton));
		newOrderButton.click();
		sAssert.assertAll();

	}

	@Step("Verify create order page elements")
	public void verifyCreateOrderElements() {
		WDWait(saveButton);
		sAssert.assertTrue(saveButton.isDisplayed(),"Verify save button");
		sAssert.assertTrue(addContactButton.isDisplayed(), "Verify add contact button");
		sAssert.assertTrue(orderDate.isDisplayed(),"Verify order date");
		sAssert.assertTrue(dueDate.isDisplayed(),"Verify due date");
		sAssert.assertTrue(addLineItemButton.isDisplayed(), "Verify add line item button");
		sAssert.assertTrue(orderSettingText.isDisplayed(),"Verify order setting text");
		sAssert.assertTrue(customizeNumberFormat.isDisplayed(),"Verify custom number format text");
		sAssert.assertTrue(globalCustomFields.isDisplayed(), "Verify global custom field text");
		// unitPriceIsTaxInclusive.isDisplayed();
		sAssert.assertAll();

	}

	@Step("Add Contact")
	public void addContact(String cName) {
		wait.until(ExpectedConditions.elementToBeClickable(addContactButton));
		addContactButton.click();
		WDWait(typeHere);
		typeHere.sendKeys(cName);
		WDWait(firstContact);
		firstContact.click();
		sAssert.assertAll();

	}

	@Step("Verify Multi currency options")
	public void verifyMultiCurrencyOptions() {
		WDWait(multiCurrencyOptions);
		sAssert.assertTrue(multiCurrencyOptions.isDisplayed(), "Verify multi currency option");
		sAssert.assertAll();

	}

	@Step("Add Product")
	public void addProduct(String pName) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(addLineItemButton));
		addLineItemButton.click();
		WDWait(pTypeHere);
		wait.until(ExpectedConditions.elementToBeClickable(pTypeHere));
		pTypeHere.sendKeys(pName);
		WDWait(firstProduct);
		firstProduct.click();
		sAssert.assertAll();

	}

	@Step("Verrify default quantity of products")
	public void verifydefaultQuantityAndTax() {
		WDWait(pQuantity);
		sAssert.assertTrue(pQuantity.isDisplayed(),"Verify quantity");
		sAssert.assertEquals(pQuantity.getAttribute("value"), "1.00");
		sAssert.assertAll();

	}

	@Step("Enter Quantity and Discount ")
	public void enterProductDetails(String quantity, String discount) throws InterruptedException {
		WDWait(pQuantity);
		Thread.sleep(2000);
		pQuantity.click();
		pQuantity.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		pQuantity.clear();

		pQuantity.sendKeys(quantity);
		WDWait(discountTextBox);
		discountTextBox.clear();
		discountTextBox.sendKeys(discount);
		sAssert.assertAll();

	}

	@Step("Verify Total Amount ")
	public void verifyTotalAmount() throws InterruptedException {
		WDWait(pQuantity);

		String quantity = pQuantity.getAttribute("value");
		System.out.println("String Quantity=" + quantity);
		double quantity1 = Double.parseDouble(quantity);
		System.out.println("Double Quantity1 =" + quantity1);

		String unitPrice = unitPriceTextBox.getAttribute("value");
		System.out.println("String unitPrice=" + unitPrice);
		double unitPrice1 = Double.parseDouble(unitPrice);
		System.out.println("Double unitPrice1 =" + unitPrice1);

		String discount = discountTextBox.getAttribute("value");
		System.out.println("String discount=" + discount);
		double discount1 = Double.parseDouble(discount);
		System.out.println("Double discount1 =" + discount1);

		String tax = pTax.getAttribute("value");
		System.out.println("String tax=" + tax);
		String numberOnlytax = tax.replaceAll("[^0-9]", "");
		System.out.println("Number only tax =" + numberOnlytax);
		double tax1 = Double.parseDouble(numberOnlytax);
		System.out.println("Double tax1 =" + tax1);

		Thread.sleep(4000);

		amount = amountSGD.getText();
		System.out.println("displayedTotal=" + amount);
		double amount1 = Double.parseDouble(amount);
		System.out.println("Double displayedTotal1 =" + amount1);

		double taxAmount = (quantity1 * unitPrice1 - discount1) * (tax1 / 100);
		System.out.println("Total Tax = " + taxAmount);
		double totalAmount = (quantity1 * unitPrice1 - discount1) + taxAmount;
		System.out.println("Total Amount=" + totalAmount);

		sAssert.assertEquals(amount1, totalAmount);
		
		sAssert.assertAll();

	}

	@Step("Click on Save Button")
	public void clickSaveButton() throws InterruptedException {
		WDWait(saveButton);
		// Thread.sleep(3000);
		saveButton.click();
		sAssert.assertAll();

	}

	@Step("Verify success message")
	public void verifysuccessmessage() {
		WDWait(ordercreatedSuccessMessage);
		sAssert.assertTrue(ordercreatedSuccessMessage.isDisplayed(), "Verify order created success message");
		wait.until(ExpectedConditions.visibilityOf(ordercreatedSuccessMessage));
		sAssert.assertAll();

	}
	@Step("Verify total amount in grid")
	public void verifyamountInGrid(){
		WDWait(verifyAmountInGrid);
		sAssert.assertTrue(verifyAmountInGrid.isDisplayed(),"Verify amount in grid");
		
		sAssert.assertEquals(verifyAmountInGrid.getText(), amount);
		sAssert.assertAll();

	}

	@Step("Verify total order count")
	public void ordetTotalCount() {
		WDWait(orderTotalCount);
		sAssert.assertTrue(orderTotalCount.isDisplayed(),"Verify order count");
		sAssert.assertEquals(orderTotalCount.getText(), "1");
		sAssert.assertAll();

	}

	@Step("Search created order")
	public void searchCreatedRecord(String cName) throws InterruptedException {
		WDWait(searchRecord);
		//wait.until(ExpectedConditions.elementToBeClickable(searchRecord));
		searchRecord.click();
		Thread.sleep(4000);
		searchRecord.sendKeys(cName);
		sAssert.assertAll();

	}

	@Step("Click on searched order")
	public void clickOnContact(String cName) {
		WDWait(contactName);
		wait.until(ExpectedConditions.elementToBeClickable(contactName));
		sAssert.assertEquals(contactName.getText(), cName);
		contactName.click();
		sAssert.assertAll();

	}

	@Step("Click on Convert to bill button")
	public void clickConvertToBillButton() throws InterruptedException {

		WDWait(convertToBillButton);
		sAssert.assertTrue(convertToBillButton.isDisplayed(),"Verify convert to bill button");
		convertToBillButton.click();
		sAssert.assertAll();

	}

	@Step("Verify convert to bill popup")
	public void verifyConvertToBillPopupElements() {
		WDWait(convertToBillHeading);
		sAssert.assertTrue(convertToBillHeading.isDisplayed(),"Verify convert to bill heading");
		WDWait(convertAutoReceivedbutton);
		sAssert.assertTrue(convertAutoReceivedbutton.isDisplayed(),"Verify auto receive button");
		WDWait(convertOnlyButton);
		sAssert.assertTrue(convertOnlyButton.isDisplayed(),"Verify convert only button");
		sAssert.assertAll();
	}

	@Step("Click on convert autoreceived button")
	public void clickConvertAutoReceivedButton() {
		WDWait(convertAutoReceivedbutton);
		sAssert.assertTrue(convertAutoReceivedbutton.isDisplayed(),"Verify convert autoreceive button");
		convertAutoReceivedbutton.click();
		sAssert.assertAll();
	}

	@Step("Verify success message")
	public void verifyConvertBillsuccessmessage() {
		WDWait(convertBillSucessMsg);
		sAssert.assertTrue(convertBillSucessMsg.isDisplayed(),"Verify convert bill success message");
		wait.until(ExpectedConditions.visibilityOf(convertBillSucessMsg));
		sAssert.assertAll();
	}

	/*******************************
	 * Create Bill Object Manipulation Methods
	 *******************/

	@Step(" Click on New Bill button")
	public void clickOnNewBill() {
		WDWait(newBillButton);
		wait.until(ExpectedConditions.elementToBeClickable(newBillButton));
		newBillButton.click();
		sAssert.assertAll();
	}

	@Step("Verify create order page elements")
	public void verifyCreateBillElements() {
		WDWait(saveButton);
		sAssert.assertTrue(saveButton.isDisplayed(),"Verify save button");
		WDWait(billText);
		sAssert.assertTrue(billText.isDisplayed(),"Verify bill text");
		sAssert.assertTrue(addContactButton.isDisplayed(),"Verify add contact button");
		sAssert.assertTrue(billDate.isDisplayed(),"Verify bill date");
		sAssert.assertTrue(dueDate.isDisplayed(),"Verify due date");
		sAssert.assertTrue(addLineItemButton.isDisplayed(),"Verify add line item buttom");
		sAssert.assertTrue(billSettingText.isDisplayed(),"Verify billing setting text");
		sAssert.assertTrue(customizeNumberFormat.isDisplayed(),"Verify customize number format");
		sAssert.assertTrue(globalCustomFields.isDisplayed(),"Verify global custom fields");
		/*wait.until(ExpectedConditions.visibilityOf(unitPriceIsTaxInclusive));
		sAssert.assertTrue(unitPriceIsTaxInclusive.isDisplayed(),"Verify unit price is tax inclusive button");*/
		sAssert.assertAll();
	}

	@Step("Verify success message")
	public void verifybillcreatedsuccessmessage() {
		WDWait(billcreatedSuccessMessage);
		sAssert.assertTrue(billcreatedSuccessMessage.isDisplayed(),"Verify bill created success message");
		wait.until(ExpectedConditions.visibilityOf(billcreatedSuccessMessage));
		sAssert.assertAll();
	}

	@Step("Verify total bill count")
	public void billTotalCount() {
		WDWait(billTotalCount);
		sAssert.assertTrue(billTotalCount.isDisplayed(),"Verify bill total count");
		sAssert.assertEquals(billTotalCount.getText(), "1");
		sAssert.assertAll();
	}

	@Step("Click on Bill Card")
	public void clickOnBillCard() {
		WDWait(billCard);
		sAssert.assertTrue(billCard.isDisplayed(),"Verify bill card");
		billCard.click();
		sAssert.assertAll();
	}

	@Step("Click on Received Goods button")
	public void clickReceivedGoodsButton() {
		WDWait(receivedGoodsButton);
		sAssert.assertTrue(receivedGoodsButton.isDisplayed(),"Verify received goods button");
		receivedGoodsButton.click();
		sAssert.assertAll();

	}

	@Step("Verify receive goods elements ")
	public void verifyReceivedGoodsElements() {
		WDWait(receivingTextBox);
		sAssert.assertTrue(receivingTextBox.isDisplayed(),"Verify receiving text box");
		WDWait(cancelButton);
		sAssert.assertTrue(cancelButton.isDisplayed(),"Verify cancel button");
		WDWait(receiveButton);
		sAssert.assertTrue(receiveButton.isDisplayed(),"Verify receive button");
		sAssert.assertAll();

	}

	@Step("Click on Receive button")
	public void clickReceiveButton() throws InterruptedException {
		WDWait(receiveButton);
		sAssert.assertTrue(receiveButton.isDisplayed(),"Click receive button");
		receiveButton.click();
		Thread.sleep(3000);
		sAssert.assertAll();

	}

	@Step("Click on Make Payment button")
	public void clickMakePaymentButton() {
		WDWait(makePaymentButton);
		sAssert.assertTrue(makePaymentButton.isDisplayed(),"Click make payment button");
		makePaymentButton.click();
		sAssert.assertAll();
	}

	@Step("Verify make payment page element")
	public void verifyMakePaymentElement() {
		WDWait(makePaymentHeading);
		sAssert.assertTrue(makePaymentHeading.isDisplayed(),"Verify make payment heading");
		WDWait(generalTab);
		sAssert.assertTrue(generalTab.isDisplayed(),"Verify general tab");
		WDWait(confirmTab);
		sAssert.assertTrue(confirmTab.isDisplayed(),"Verify confirm tab");
		WDWait(currentOustandingText);
		sAssert.assertTrue(currentOustandingText.isDisplayed(),"Verify current outstanding text");
		WDWait(dueInLabel);
		sAssert.assertTrue(dueInLabel.isDisplayed(),"Verify due in label");
		WDWait(sgdCurrency);
		sAssert.assertTrue(sgdCurrency.isDisplayed(),"Verify currency");
		WDWait(displayedAmount);
		sAssert.assertTrue(displayedAmount.isDisplayed(),"Verify displayed amount");
		WDWait(paymentDate);
		sAssert.assertTrue(paymentDate.isDisplayed(),"Verify payment date");
		WDWait(currencyDropdown);
		sAssert.assertTrue(currencyDropdown.isDisplayed(),"Verify currency drop down");
		WDWait(paymentAndCurrencyAmount);
		sAssert.assertTrue(paymentAndCurrencyAmount.isDisplayed(),"Verify payment and currency field");
		sAssert.assertAll();
	}

	@Step("Click on Pay Form Drop down")
	public void clickPayFormDropDown() throws InterruptedException {
		WDWait(payFromDropDown);
		sAssert.assertTrue(payFromDropDown.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(payFromDropDown));
		payFromDropDown.click();
		WDWait(clickOnCash);
		sAssert.assertTrue(clickOnCash.isDisplayed());
		clickOnCash.click();
		sAssert.assertAll();
	}

	@Step("Verify default currency in Payment and amount")
	public void verifyCurrency() {
		WDWait(sgdCurrency);
		sAssert.assertEquals(sgdCurrency.getText(), "SGD");
		sAssert.assertAll();
	}

	@Step("Click on Next button")
	public void clickOnNext() {
		WDWait(nextButton);
		sAssert.assertTrue(nextButton.isDisplayed());
		nextButton.click();
		sAssert.assertAll();
	}

	@Step("Verify Confirm payment made page elements")
	public void verifyConfirmPaymentElements() {
		WDWait(confirmPaymentMadeText);
		sAssert.assertTrue(confirmPaymentMadeText.isDisplayed(),"Verify confirm Payment Made Text");
		WDWait(payfromCash);
		sAssert.assertTrue(payfromCash.isDisplayed(),"Verify pay from cash");
		sAssert.assertEquals(payfromCash.getText(), "Cash");
		WDWait(backButton);
		sAssert.assertTrue(backButton.isDisplayed(),"Verify back button");
		WDWait(payButton);
		sAssert.assertTrue(payButton.isDisplayed(),"Verify pay button");
		payButton.click();
		sAssert.assertAll();
	}

	@Step("Click on Close button")
	public void ClickOnCloseButton() {
		WDWait(printButton);
		sAssert.assertTrue(printButton.isDisplayed());
		WDWait(closeButton);
		sAssert.assertTrue(closeButton.isDisplayed());
		closeButton.click();
		sAssert.assertAll();
	}

	@Step("Verify payment received success message")
	public void verifyPaymentReceivedsuccessmessage() {
		WDWait(paymentReceivedSuccessMessage);
		sAssert.assertTrue(paymentReceivedSuccessMessage.isDisplayed(),"Verify payment received success message");
		wait.until(ExpectedConditions.visibilityOf(paymentReceivedSuccessMessage));
		sAssert.assertAll();
	}

	/******************************
	 * Archive bill Object Manipulation Methods
	 *******************/

	@Step("Click on Context Menu icon")
	public void clickContextMenuIcon() throws InterruptedException {
		WDWait(contextMenuIcon);
		sAssert.assertTrue(contextMenuIcon.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(contextMenuIcon));
		// Thread.sleep(3000);
		contextMenuIcon.click();
		// Thread.sleep(4000);
		sAssert.assertAll();
	}

	@Step("Click on Archive Bill button")
	public void clickOnArchiveBillButton() {
		WDWait(archiveBillButton);
		sAssert.assertTrue(archiveBillButton.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(archiveBillButton));
		archiveBillButton.click();
		sAssert.assertAll();
	}

	@Step("Verify total archive count")
	public void archiveTotalCount() {
		WDWait(archiveTotalCount);
		sAssert.assertTrue(archiveTotalCount.isDisplayed(),"Verify archive total count");
		wait.until(ExpectedConditions.visibilityOf(archiveTotalCount));
		sAssert.assertEquals(archiveTotalCount.getText(), "1");
		sAssert.assertAll();
	}
	
	/******************************
	 * Archive Order Object Manipulation Methods
	 * @throws InterruptedException 
	 *******************/
	@Step("Click on Context Menu icon of Orders")
	public void clickOrderContextMenuIcon() throws InterruptedException {
		WDWait(orderContextMenuIcon);
		sAssert.assertTrue(orderContextMenuIcon.isDisplayed());
		MOverElement(orderContextMenuIcon);
		wait.until(ExpectedConditions.elementToBeClickable(orderContextMenuIcon));
		orderContextMenuIcon.click();
		Thread.sleep(1000);
		sAssert.assertAll();
	}
	@Step("Click on Archive Order button")
	public void clickOnArchiveOrderButton() throws InterruptedException {
		Thread.sleep(1000);
		WDWait(archiveOrderButton);
		sAssert.assertTrue(archiveOrderButton.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(archiveOrderButton));
		archiveOrderButton.click();
		sAssert.assertAll();
	}
	@Step("Click on Archive card")
	public void clickOnArchiveCard(){
		WDWait(archiveCard);
		sAssert.assertTrue(archiveCard.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(archiveCard));
		archiveCard.click();
		sAssert.assertAll();
	}
	@Step("Verify cancelled status of archived record")
	public void verifyCancelledStatus() throws InterruptedException{
		WDWait(cancelledStatus);
		sAssert.assertTrue(cancelledStatus.isDisplayed(),"Verify cancelled status");
		wait.until(ExpectedConditions.visibilityOf(cancelledStatus));
		sAssert.assertEquals(cancelledStatus.getText(), "Cancelled");
		sAssert.assertAll();
	}
	
	/******************************
	 * Reopen Order Object Manipulation Methods
	 *******************/
	@Step("Click on context menu icon to reopen")
	public void clickOnContextMenuOnArchivePage(){
		WDWait(archiveContextMenuIcon);
		sAssert.assertTrue(archiveContextMenuIcon.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(archiveContextMenuIcon));
		archiveContextMenuIcon.click();
		sAssert.assertAll();
	}
	@Step("Click on Reopen button")
	public void clickOnReopen(){
		WDWait(reopenButton);
		sAssert.assertTrue(reopenButton.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(reopenButton));
		reopenButton.click();
		sAssert.assertAll();
	}
	@Step("No records message after reopen of bill/order")
	public void noMatchingRecord() throws InterruptedException{
		WDWait(noMatchingRecord);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(noMatchingRecord));
		sAssert.assertTrue(noMatchingRecord.isDisplayed(),"Verify no matching record text");
		sAssert.assertAll();
	}
	
	
	
}