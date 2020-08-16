package deskera.web.automation.erp.bvtSG.pages;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.hc.core5.http.nio.support.classic.SharedInputBuffer;
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
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Step;

public class SellPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public SellPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	/*******************************
	 * Sell PAGE ELEMENTS LOCATORS
	 *******************/

	@FindBy(xpath = "//h1[contains(.,'Sell Records')]")
	private WebElement sellRecordsText;
	@FindBy(xpath = "//div[@class='summary-title'][contains(.,'Quote')]")
	private WebElement quoteTotalButton;
	@FindBy(xpath = "//h5[contains(.,'Invoice')]")
	private WebElement invoiceTotalButton;
	@FindBy(xpath = "//h5[contains(.,'Archive')]")
	private WebElement archiveTotalButton;
	@FindBy(xpath = "//input[@placeholder='Date Range']")
	private WebElement dateRangeButton;
	@FindBy(xpath = "//span[contains(text(),'Filters')]")
	private WebElement filtersButton;
	@FindBy(xpath = "//span[contains(.,'Total Amount (Base Currency)')]")
	private WebElement totalAmountBaseCurrecnyText;
	@FindBy(xpath = "//div[@class='mat-slide-toggle-bar']")
	private WebElement totalAmountBaseCurrecnyTogleButton;
	@FindBy(xpath = "//input[contains(@placeholder,'Search Records')]")
	private WebElement searchBox;
	@FindBy(xpath = "//button[contains(.,'Create New')]")
	private WebElement createNewButton;
	@FindBy(xpath = "//button[contains(.,'New Quote')]")
	private WebElement newQuoteButton;
	@FindBy(xpath = "//button[contains(.,'New Invoice')]")
	private WebElement newInvoiceButton;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Number arrow_drop')]")

	private WebElement numberColumn;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Contact arrow_drop')]")

	private WebElement contactColumn;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Due Date arrow_drop')]")

	private WebElement dueDateColumn;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Total Amount')]")

	private WebElement totalAmountColumn;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Fulfillment')]")

	private WebElement fullfillmentColumn;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Quick Actions')]")
	private WebElement quickActionsColumn;
	@FindBy(xpath = "//mat-icon[contains(.,'more_vert')]")
	private WebElement threeDotsOnFirstRecord;
	@FindBy(xpath = "//button[contains(.,'Fulfill')]")
	private WebElement fullfillButton;
	@FindBy(xpath = "//span[contains(.,'Fulfill Your Quotation')]")
	private WebElement fullfillYourQuotationText;
	@FindBy(xpath = "//span[contains(.,'Fulfill Your Invoice')]")
	private WebElement fullfillYourInvoiceText;
	@FindBy(xpath = "//p[contains(.,'You can fulfill your quotation in 3 ways, by direct fulfillment, Pick Pack Ship and Dropship.')]")
	private WebElement youCanFulfillYourQuotationIn3WaysText;
	@FindBy(xpath = "//p[contains(.,'You can fulfill your invoice in 3 ways, by direct fulfillment, Pick Pack Ship and Dropship.')]")
	private WebElement youCanFulfillYourInvoiceIn3WaysText;
	@FindBy(xpath = "//span[contains(.,'Direct')]")
	private WebElement directButton;
	@FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(.,'Pick Pack Ship')]")
	private WebElement pickPackShipButton;
	@FindBy(xpath = "//span[contains(.,'Dropship')]")
	private WebElement dropshipButton;
	@FindBy(xpath = "//span[contains(.,'Direct fulfillment of Quotation')]")
	private WebElement directFulfillmentOfQuotationText;
	@FindBy(xpath = "//span[contains(.,'Direct fulfillment of Invoice')]")
	private WebElement directFulfillmentOfInvoiceText;
	@FindBy(xpath = "//span[contains(.,'Ship To')]")
	private WebElement shipToLabel;
	@FindBy(xpath = "//div[@class='mat-form-field-infix'][contains(.,'Ship From  *')]")
	private WebElement shipFromLabel;
	@FindBy(xpath = "//input[@placeholder='Type here']")
	private WebElement warehouseDropdown;
	@FindBy(xpath = "//input[@placeholder='Choose a date']")
	private WebElement fullFillDate;
	@FindBy(xpath = "//div[contains(text(),'Product')]//following::div//div[@class='dt-cell dt-cell-product']//div")
	private WebElement productDetails;
	@FindBy(xpath = "//div[contains(text(),'Description')]")
	private WebElement descriptionDetails;
	@FindBy(xpath = "//div[contains(text(),' Required ')]//following::div//div[@class='dt-cell dt-cell-quantity align-right']")
	private WebElement requiredQuantity;
	@FindBy(xpath = "//div[contains(text(),' Committing ')]//following::div//div[@class='mat-form-field-infix']")
	private WebElement commitingQuantity;
	@FindBy(xpath = "//div[contains(text(),' Stock Left ')]//following::div//div[@class='dt-cell dt-cell-stock align-right ng-star-inserted']")
	private WebElement stockLeft;

	@FindBy(xpath = "//span[contains(text(),'Fulfill')]")
	private WebElement fulfillButton;
	@FindBy(xpath = "//mat-header-cell[contains(text(),'Fulfillment')]//following::mat-row//mat-cell[6]//span")
	private WebElement fulfillmentStatus;
	@FindBy(xpath = "//span[contains(.,'Convert to Invoice')]")
	private WebElement convertToInvoiceButton;
	@FindBy(xpath = "(//div[@class='summary-values']//h5)[1]")
	private WebElement totalQuoteCount;
	@FindBy(xpath = "(//div[@class='summary-values']//h5)[2]")
	private WebElement totalInvoiceCount;
	@FindBy(xpath = "(//div[@class='summary-values']//h5)[3]")
	private WebElement totalArchiveCount;

	int invoiceCountBefore = 0;
	int invoiceCountAfter = 0;
	private static String pageTitleText = "Deskera Books";

	/*******************************
	 * Create New Quote/Invoice PAGE ELEMENTS LOCATORS
	 *******************/

	@FindBy(xpath = "//button[contains(.,'Save')]")
	private WebElement saveButton;
	@FindBy(xpath = "//h5[contains(.,'Quote Settings')]")

	private WebElement quoteSettingText;
	@FindBy(xpath = "//h5[contains(.,'Invoice Settings')]")

	private WebElement invoiceSettingText;
	@FindBy(xpath = "//span[contains(.,'Customize Number Format')]")

	private WebElement customizeNumberFormat;
	@FindBy(xpath = "//span[contains(.,'Global Custom Fields')]")

	private WebElement globalCustomFields;
	@FindBy(xpath = "//span[contains(.,'+ Add a contact')]")

	private WebElement addContactButton;
	@FindBy(xpath = "//input[contains(@placeholder,'Type here')]")
	private WebElement contactSearchBox;
	@FindBy(xpath = "//input[@formcontrolname='documentDate']")

	private WebElement quoteDate;
	@FindBy(xpath = "//input[@formcontrolname='fulfillmentDate']")

	private WebElement receivedInDate;
	@FindBy(xpath = "//input[@formcontrolname='validTillDate']")

	private WebElement dueDate;
	@FindBy(xpath = "(//span[@class='mat-option-text'])[2]")
	private WebElement firstContact;
	@FindBy(xpath = "//span[contains(.,'+ Add a Line Item')]")

	private WebElement addLineItemButton;
	@FindBy(xpath = "(//input[contains(@ng-reflect-placeholder,'Type here')])[1]")

	private WebElement productSearchBox;
	@FindBy(xpath = "(//span[contains(@class,'mat-option-text')])[1]")

	private WebElement firstProduct;
	@FindBy(xpath = "//textarea[@placeholder='Description Optional']")

	private WebElement descriptionTextArea;
	@FindBy(xpath = "//input[@formcontrolname='productQuantity']")

	private WebElement quantityTextBox;
	@FindBy(xpath = "//input[@formcontrolname='unitPrice']")

	private WebElement unitPriceTextBox;
	@FindBy(xpath = "//input[@formcontrolname='discountString']")

	private WebElement discountTextBox;
	@FindBy(xpath = "(//input[@role='combobox'])[2]")

	private WebElement taxTextBox;
	@FindBy(xpath = "(//div[@class='mat-form-field-infix']//div[@class='mat-input-element read-only-value'])[2]")

	private WebElement totalAmount;
	@FindBy(xpath = "//span[text()='Quotation has been saved successfully']")
	private WebElement createQuoteSuccessMessage;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Quick Actions')]//following::mat-row//mat-cell[2]")
	private WebElement createdFirstQuote;;

	@FindBy(xpath = "//span[contains(.,'Invoice has been saved successfully')]")
	private WebElement createInvoiceSuccessMessage;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Quick Actions')]//following::mat-row[1]//mat-cell[2]")
	private WebElement createdFirstInvoice;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Quick Actions')]//following::mat-row[2]//mat-cell[2]")
	private WebElement createdSecondInvoice;
	@FindBy(xpath = "//button[contains(.,'Receive Payment')]")
	private WebElement receivePaymentButton;
	@FindBy(xpath = "//div[contains(text(),'Receive Payment ')]")
	private WebElement receivePaymentText;
	@FindBy(xpath = "//div[contains(text(),'General')]")
	private WebElement generalTab;
	@FindBy(xpath = "(//div[contains(text(),'Confirm')])[1]")
	private WebElement confirmTab;
	@FindBy(xpath = "//input[@placeholder='Choose a date']")
	private WebElement PaymentDateTextBox;
	@FindBy(xpath = "//span[contains(text(),'Deposited To')]")
	private WebElement depositedToDropdown;
	@FindBy(xpath = "//span[contains(.,'HSBC')]")
	private WebElement hsbcBank;
	@FindBy(xpath = "//span[contains(.,'Cash')]")
	private WebElement cashOption;
	@FindBy(xpath = "//div[@class='mat-form-field-infix'][contains(.,'SGD Payment And Currency')]")
	private WebElement paymentAndCurrency;
	@FindBy(xpath = "//span[contains(@class,'dueAmount')]")
	private WebElement totalAmountOnReceivePayment;
	@FindBy(xpath = "(//span[contains(.,'Payment Type')])[1]")
	private WebElement paymentTypeDropdown;
	@FindBy(xpath = "//span[contains(.,'Cheque')]")
	private WebElement ChequePaymentType;
	@FindBy(xpath = "//input[@ng-reflect-name='referenceDate']")
	private WebElement referenceDate;
	@FindBy(xpath = "//input[@formcontrolname='referenceNumber']")
	private WebElement chequeNumber;
	@FindBy(xpath = "//span[contains(.,'Next')]")
	private WebElement nextButton;
	@FindBy(xpath = "(//button[contains(.,'Receive')])[2]")
	private WebElement receiveButton;
	@FindBy(xpath = "//span[contains(.,'Close')]")
	private WebElement closeButton;
	@FindBy(xpath = "//button[contains(@class,'cancel-btn')]//span//mat-icon")
	private WebElement backButton;

	/***********************************
	 * 
	 * Page objects manipulation methods
	 * 
	 *********************************/
	@Step("Verify Sell Page Title")
	public void verifyPageTitle() throws InterruptedException {
		Assert.assertEquals(driver.getTitle(), pageTitleText);
	}

	// Common util for webdriver wait
	@Step("Wait Element to be Visible")
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}

	@Step("Verify Sell Page Elements ")
	public void verifySellPageElements() {
		WDWait(sellRecordsText);
		sellRecordsText.isDisplayed();
		createNewButton.isDisplayed();
		quoteTotalButton.isDisplayed();
		invoiceTotalButton.isDisplayed();
		archiveTotalButton.isDisplayed();
		dateRangeButton.isDisplayed();
		filtersButton.isDisplayed();
		totalAmountBaseCurrecnyText.isDisplayed();
		totalAmountBaseCurrecnyTogleButton.isDisplayed();
		searchBox.isDisplayed();
		numberColumn.isDisplayed();
		contactColumn.isDisplayed();
		dueDateColumn.isDisplayed();
		totalAmountColumn.isDisplayed();
		fullfillmentColumn.isDisplayed();
		quickActionsColumn.isDisplayed();
	}

	@Step("Click On Create New Button and then Click on New Quote")
	public void clickNewQuoteButton() {
		WDWait(createNewButton);
		wait.until(ExpectedConditions.elementToBeClickable(createNewButton));
		createNewButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(newQuoteButton));
		newQuoteButton.click();
	}

	@Step("Click On Create New Button and then Click on New Invoice")
	public void clickNewInvoiceButton() {
		WDWait(createNewButton);
		wait.until(ExpectedConditions.elementToBeClickable(createNewButton));
		createNewButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(newInvoiceButton));
		newInvoiceButton.click();
	}

	@Step("Verify Create Quote Page Elements ")
	public void verifyCreateQuotePageElements() {
		WDWait(saveButton);
		saveButton.isDisplayed();
		addContactButton.isDisplayed();
		quoteDate.isDisplayed();
		receivedInDate.isDisplayed();
		dueDate.isDisplayed();
		addLineItemButton.isDisplayed();
		quoteSettingText.isDisplayed();
		customizeNumberFormat.isDisplayed();
		globalCustomFields.isDisplayed();
	}

	@Step("Verify Create Invoice Page Elements ")
	public void verifyCreateInvoicePageElements() {
		WDWait(saveButton);
		saveButton.isDisplayed();
		addContactButton.isDisplayed();
		quoteDate.isDisplayed();
		receivedInDate.isDisplayed();
		dueDate.isDisplayed();
		addLineItemButton.isDisplayed();
		invoiceSettingText.isDisplayed();
		customizeNumberFormat.isDisplayed();
		globalCustomFields.isDisplayed();
	}

	@Step("Select Contact")
	public void selectContact(String contactName) {
		wait.until(ExpectedConditions.elementToBeClickable(addContactButton));
		addContactButton.click();
		contactSearchBox.sendKeys(contactName);
		WDWait(firstContact);
		firstContact.click();
	}

	@Step("Verify Quote Date, Ship By Date , Valid till Date ")
	public void verifyDisplayedDates() throws InterruptedException {
		Thread.sleep(2000);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		System.out.println(quoteDate.getAttribute("value"));
		Assert.assertEquals(quoteDate.getAttribute("value"), dtf.format(now));
		System.out.println(receivedInDate.getAttribute("value"));
		Assert.assertEquals(receivedInDate.getAttribute("value"), dtf.format(now));
	}

	@Step("Select Product")
	public void selectProduct(String productName) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(addLineItemButton));
		addLineItemButton.click();
		// wait.until(ExpectedConditions.elementToBeClickable(productSearchBox));
		Thread.sleep(3000);
		productSearchBox.click();
		productSearchBox.sendKeys(productName);
		WDWait(firstProduct);
		firstProduct.click();
	}

	@Step("Enter Quantity and Discount ")
	public void enterProductDetails(String quantity, String discount) throws InterruptedException {
		WDWait(quantityTextBox);
		Thread.sleep(2000);
		quantityTextBox.click();
		quantityTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		quantityTextBox.clear();
		quantityTextBox.sendKeys(quantity);
		WDWait(discountTextBox);
		discountTextBox.clear();
		discountTextBox.sendKeys(discount);
	}

	@Step("Enter Unit Price and Discount for Invoice")
	public void enterProductDetailsForInvoice(String unitPrice) throws InterruptedException {
		WDWait(unitPriceTextBox);
		Thread.sleep(2000);
		unitPriceTextBox.click();
		unitPriceTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		quantityTextBox.clear();
		unitPriceTextBox.sendKeys(unitPrice);
		WDWait(taxTextBox);
		taxTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Thread.sleep(2000);
		discountTextBox.click();
	}

	@Step("Click on Save Button")
	public void clickSaveButton() {
		WDWait(saveButton);
		saveButton.click();
	}

	@Step("Verify Total Amount ")
	public void verifyTotalAmount() throws InterruptedException {
		Thread.sleep(3000);
		String quantity = quantityTextBox.getAttribute("value");
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

		String tax = taxTextBox.getAttribute("value");
		System.out.println("String tax=" + tax);
		String numberOnlytax = tax.replaceAll("[^0-9]", "");
		System.out.println("Number only tax =" + numberOnlytax);
		double tax1 = Double.parseDouble(numberOnlytax);
		System.out.println("Double tax1 =" + tax1);

		Thread.sleep(4000);

		String displayedTotal = totalAmount.getText();
		System.out.println("displayedTotal=" + displayedTotal);
		double displayedTotal1 = Double.parseDouble(displayedTotal);
		System.out.println("Double displayedTotal1 =" + displayedTotal1);

		double taxAmount = (quantity1 * unitPrice1 - discount1) * (tax1 / 100);
		System.out.println("Total Tax = " + taxAmount);
		double totalAmount = (quantity1 * unitPrice1 - discount1) + taxAmount;
		System.out.println("Total Amount=" + totalAmount);
		Assert.assertEquals(displayedTotal1, totalAmount);
	}

	@Step("Verify Create Quote Success Message")
	public void verifyCreateQuoteSuccessMessage() throws InterruptedException {
		WDWait(createQuoteSuccessMessage);
		createQuoteSuccessMessage.isDisplayed();
		Thread.sleep(4000);
	}

	@Step("Verify Created Quote")
	public void verifyCreatedQuote() throws InterruptedException {
		WDWait(createdFirstQuote);
		createdFirstQuote.click();
		verifyDisplayedDates();
		verifyTotalAmount();
		WDWait(backButton);
		backButton.click();
	}

	@Step("Verify Created Invoice")
	public void verifyCreatedInvoice() throws InterruptedException {
		WDWait(createdFirstInvoice);
		createdFirstInvoice.click();
		verifyDisplayedDates();
		verifyTotalAmount();
		WDWait(backButton);
		backButton.click();
	}

	@Step("Open Created First Quote")
	public void openFirstQuote() throws InterruptedException {
		WDWait(createdFirstQuote);
		createdFirstQuote.click();
	}

	@Step("Open Created First Invoice")
	public void openFirstInvoice() throws InterruptedException {
		WDWait(createdFirstInvoice);
		createdFirstInvoice.click();
	}

	@Step("Click on Three dots on first Record")
	public void clickThreeDots() {
		WDWait(threeDotsOnFirstRecord);
		threeDotsOnFirstRecord.click();
	}

	@Step("Click on Fullfill Button")
	public void clickFullfillButton() {
		WDWait(fullfillButton);
		fullfillButton.click();
	}

	@Step("Verify FullFill Your Quotation window Elements")
	public void verifyFullfillYourQuotationWindowElements() {
		WDWait(fullfillYourQuotationText);
		fullfillYourQuotationText.isDisplayed();
		youCanFulfillYourQuotationIn3WaysText.isDisplayed();
		directButton.isDisplayed();
		pickPackShipButton.isDisplayed();
		dropshipButton.isDisplayed();
	}

	@Step("Verify FullFill Your Invoice window Elements")
	public void verifyFullfillYourInvoiceWindowElements() {
		WDWait(fullfillYourInvoiceText);
		fullfillYourInvoiceText.isDisplayed();
		youCanFulfillYourInvoiceIn3WaysText.isDisplayed();
		directButton.isDisplayed();
		pickPackShipButton.isDisplayed();
		dropshipButton.isDisplayed();
	}

	@Step("Verify Direct Fulfillment Of Quotation Window Elements")
	public void verifyDirectFulfillmentOfQuotationWindowElements() {
		WDWait(directFulfillmentOfQuotationText);
		directFulfillmentOfQuotationText.isDisplayed();
		shipToLabel.isDisplayed();
		shipFromLabel.isDisplayed();
		warehouseDropdown.isDisplayed();
		Assert.assertEquals(warehouseDropdown.getAttribute("value"), "Primary Warehouse");
		fullFillDate.isDisplayed();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		Assert.assertEquals(fullFillDate.getAttribute("value"), dtf.format(now));
		productDetails.isDisplayed();
		descriptionDetails.isDisplayed();
		requiredQuantity.isDisplayed();
		commitingQuantity.isDisplayed();
		stockLeft.isDisplayed();
	}

	@Step("Verify Direct Fulfillment Of Invoice Window Elements")
	public void verifyDirectFulfillmentOfInvoiceWindowElements() throws InterruptedException {
		WDWait(directFulfillmentOfInvoiceText);
		directFulfillmentOfInvoiceText.isDisplayed();
		shipToLabel.isDisplayed();
		shipFromLabel.isDisplayed();
		Thread.sleep(2000);
		warehouseDropdown.isDisplayed();
		Assert.assertEquals(warehouseDropdown.getAttribute("value"), "Primary Warehouse");
		fullFillDate.isDisplayed();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		Assert.assertEquals(fullFillDate.getAttribute("value"), dtf.format(now));
		productDetails.isDisplayed();
		descriptionDetails.isDisplayed();
		requiredQuantity.isDisplayed();
		commitingQuantity.isDisplayed();
		stockLeft.isDisplayed();
	}

	@Step("Click on Direct button")
	public void clickDirectButton() {
		WDWait(directButton);
		directButton.click();
	}

	@Step("Click on Convert To Invoice  button")
	public void clickConvertToInvoiceButton() {
		WDWait(convertToInvoiceButton);
		convertToInvoiceButton.click();
	}

	@Step("Verify Count of Invoice Before Quote Conevrt to invoice ")
	public void verifyCountOfInvoiceBefore() {
		WDWait(totalInvoiceCount);
		String invoiceCount = totalInvoiceCount.getText();
		invoiceCountBefore = Integer.parseInt(invoiceCount);
		System.out.println("Integer invoiceCountBefore=" + invoiceCountBefore);
	}

	@Step("Verify Count of Invoice After Quote Conevrt to invoice ")
	public void verifyCountOfInvoiceAfter() {
		WDWait(totalInvoiceCount);
		String invoiceCount = totalInvoiceCount.getText();
		invoiceCountAfter = Integer.parseInt(invoiceCount);
		System.out.println("Integer invoiceCountAfter=" + invoiceCountAfter);
		Assert.assertEquals(invoiceCountAfter, invoiceCountBefore + 1);
	}

	@Step("Verify Fulfillment Status")
	public void verifyFulfillmentStatus() throws InterruptedException {
		Thread.sleep(3000);
		WDWait(fulfillmentStatus);
		Assert.assertEquals(fulfillmentStatus.getText(), "Fulfilled");
	}

	@Step("Verify Create Invoice Success Message")
	public void verifyCreateInvoiceSuccessMessage() throws InterruptedException {
		WDWait(createInvoiceSuccessMessage);
		createInvoiceSuccessMessage.isDisplayed();
		Thread.sleep(3000);
	}

	@Step("Click On Receive Payment Button")
	public void clickReceivePaymentButton() throws InterruptedException {
		WDWait(receivePaymentButton);
		receivePaymentButton.click();
	}

	@Step("Verify Raceive Payment Window Elements")
	public void verifyRaceivePaymentWindowElements() throws InterruptedException {
		WDWait(receivePaymentText);
		receivePaymentText.isDisplayed();
		generalTab.isDisplayed();
		confirmTab.isDisplayed();
		totalAmountOnReceivePayment.isDisplayed();
		PaymentDateTextBox.isDisplayed();
		paymentAndCurrency.isDisplayed();
		depositedToDropdown.isDisplayed();
	}

	@Step("Select Cash Option from Deposited To dropdown ")
	public void selectCashOption() throws InterruptedException {
		WDWait(depositedToDropdown);
		depositedToDropdown.click();
		WDWait(cashOption);
		cashOption.click();
	}

	@Step("Click on Next Button")
	public void clickNextButton() throws InterruptedException {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", nextButton);
	}

	@Step("Receive Payment For First Invoice")
	public void receivePaymentForFirstInvoce(String firstTransactionDate) throws ParseException, InterruptedException {
		WDWait(createdFirstInvoice);
		createdFirstInvoice.click();
		WDWait(receivePaymentButton);
		receivePaymentButton.click();
		System.out.println("Given date is " + firstTransactionDate);
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(firstTransactionDate);
		System.out.println("dd-MMM-yyyy Invoice Format date : " + new SimpleDateFormat("dd-MMM-yyyy").format(date));
		String invoiceDate = new SimpleDateFormat("dd MMM yyyy").format(date);
		WDWait(PaymentDateTextBox);
		PaymentDateTextBox.click();
		PaymentDateTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		PaymentDateTextBox.sendKeys(invoiceDate);
		WDWait(depositedToDropdown);
		depositedToDropdown.click();
		WDWait(hsbcBank);
		hsbcBank.click();
		WDWait(paymentTypeDropdown);
		paymentTypeDropdown.click();
		WDWait(ChequePaymentType);
		ChequePaymentType.click();
		WDWait(referenceDate);
		referenceDate.click();
		referenceDate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		referenceDate.sendKeys(invoiceDate);
		WDWait(chequeNumber);
		chequeNumber.sendKeys("12345");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", nextButton);
	}

	@Step("Receive Payment For Second  Invoice")
	public void receivePaymentForSecondInvoce(String secondTransactionDate)
			throws ParseException, InterruptedException {
		WDWait(createdFirstInvoice);
		createdFirstInvoice.click();
		WDWait(receivePaymentButton);
		receivePaymentButton.click();
		// String bankReconciledateString = "2020-05-11";
		System.out.println("Given date is " + secondTransactionDate);
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(secondTransactionDate);
		System.out.println("dd-MMM-yyyy Invoice Format date : " + new SimpleDateFormat("dd-MMM-yyyy").format(date));
		String invoiceDate = new SimpleDateFormat("dd MMM yyyy").format(date);
		WDWait(PaymentDateTextBox);
		PaymentDateTextBox.click();
		PaymentDateTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		PaymentDateTextBox.sendKeys(invoiceDate);
		WDWait(depositedToDropdown);
		depositedToDropdown.click();
		WDWait(hsbcBank);
		hsbcBank.click();
		WDWait(paymentTypeDropdown);
		paymentTypeDropdown.click();
		WDWait(ChequePaymentType);
		ChequePaymentType.click();
		WDWait(referenceDate);
		referenceDate.click();
		referenceDate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		referenceDate.sendKeys(invoiceDate);
		WDWait(chequeNumber);
		chequeNumber.sendKeys("12345");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", nextButton);
	}

	@Step("Click On Receive Button")
	public void clickReceiveButton() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", receiveButton);
		WDWait(closeButton);
		closeButton.click();
		WDWait(backButton);
		backButton.click();
		Thread.sleep(2000);
	}
}
