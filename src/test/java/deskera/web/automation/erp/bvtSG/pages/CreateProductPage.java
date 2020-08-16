package deskera.web.automation.erp.bvtSG.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
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

public class CreateProductPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private SoftAssertListner sAssert;

	public CreateProductPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
		sAssert = new SoftAssertListner(driver);
	}

	/*******************************
	 * Create New Product PAGE ELEMENTS LOCATORS
	 *******************/
	@FindBy(xpath = "//span[contains(.,'Products')]")
	private WebElement productsTab;
	@FindBy(xpath = "//span[contains(.,'Start by Adding or Importing Your Products')]")
	private List<WebElement> startByAddingOrImportingYourProducsText;
	@FindBy(xpath = "//i[contains(@class,'fa-times close-button m')]//self::i[1]")
	private WebElement closeIcon;
	@FindBy(xpath = "//span[@class='action-button-text'][contains(.,'Create Product')]")
	private WebElement createProductButton;
	@FindBy(xpath = "//span[contains(text(),'New Product')]")
	private WebElement newProductButton;
	@FindBy(xpath = "//span[@class='ng-star-inserted'][contains(.,'Create New Product')]")
	private WebElement createNewProductText;
	@FindBy(xpath = "//div[@class='image-container d-flex']")
	private WebElement addImage;
	@FindBy(xpath = "//div[contains(text(),' General Info ')]")
	private WebElement generalInfoTab;
	@FindBy(xpath = "//div[contains(text(),' Accounting ')]")
	private WebElement accountingTab;
	@FindBy(xpath = "//div[contains(text(),'Inventory')]")
	private WebElement inventoryTab;
	@FindBy(xpath = "//div[contains(text(),' Bill of Materials')]")
	private WebElement billsOfMaterialTab;
	@FindBy(xpath = "//mat-icon[@ng-reflect-message='Info']")
	private WebElement infoIcon;
	@FindBy(xpath = "//mat-icon[@ng-reflect-message='Chat']")
	private WebElement chatIcon;
	@FindBy(xpath = "//mat-icon[@ng-reflect-svg-icon='notification']")
	private WebElement notificationIcon;
	@FindBy(xpath = "//h5[contains(.,'Quick Actions')]")
	private WebElement quickActionsText;
	@FindBy(xpath = "//span[contains(.,'Custom Number Format')]")
	private WebElement customNumberFormat;
	@FindBy(xpath = "(//span[contains(.,'Custom Fields')])[2]")
	private WebElement customFields;
	@FindBy(xpath = "//div[contains(@class,'image-container d-flex')]")
	private WebElement addImageArea;
	@FindBy(xpath = "//div[@class='mat-select-arrow-wrapper']")
	private WebElement productTypedropdown;
	@FindBy(xpath = "//span[@class='mat-option-text'][contains(.,'Non-Tracked')]")
	private WebElement nonTrackedProductType;
	@FindBy(xpath = "//span[@class='mat-option-text'][text()='Tracked']")
	private WebElement trackedProductType;
	@FindBy(xpath = "//span[@class='mat-option-text'][text()='Bill of Materials']")
	private WebElement billsOfMaterialProductType;
	@FindBy(xpath = "//input[contains(@placeholder,'Product Number')]")
	private WebElement productNumber;
	@FindBy(xpath = "//input[@formcontrolname='name']")
	private WebElement ProductNameInputBox;
	@FindBy(xpath = "//input[@formcontrolname='barcode']")
	private WebElement barcodeInputBox;
	@FindBy(xpath = "//textarea[@formcontrolname='description']")
	private WebElement descriptionInputBox;
	private static String pageTitleText = "Deskera Books";
	@FindBy(css = "	i.fas.fa-times.close-button.mt-2")
	private WebElement closeOverlayPopup;
	/*************** Accounting tab ******************************************/
	@FindBy(xpath = "//p[text()='Buy']")
	private WebElement buyText;
	@FindBy(xpath = "//mat-label[contains(text(),'Purchase Account ')]/parent::label/parent::span/parent::div/input")
	private WebElement purchaseAccount;
	@FindBy(xpath = "//span[contains(.,'Purchase Return')]")
	private WebElement purchaseReturnPurchaseAccount;
	@FindBy(xpath = "//div[@class='cdk-overlay-pane mat-autocomplete-panel-above']//div//mat-option//span")
	private List<WebElement> purchaseAccountDropdownValues;
	@FindBy(xpath = "//div[@class='cdk-overlay-pane mat-autocomplete-panel-above']//div//mat-option//span")
	private List<WebElement> salesAccountDropdownValues;
	@FindBy(xpath = "//mat-label[contains(text(),'Purchase Price')]/parent::label/parent::span/parent::div/input")
	private WebElement purchasePrice;
	@FindBy(xpath = "//mat-label[contains(text(),' Purchase Tax ')]/parent::label/parent::span/parent::div/input")
	private WebElement purchaseTax;
	@FindBy(xpath = "(//div[@class='mat-checkbox-mixedmark']//following::span[text()='Price is tax inclusive'])[1]")
	private WebElement priceIsTaxInclusiveCheckBox_Buy;
	@FindBy(xpath = "(//div[@class='mat-checkbox-mixedmark']//following::span[text()='Price is tax inclusive'])[2]")
	private WebElement priceIsTaxInclusiveCheckBox_Sell;
	@FindBy(xpath = "//p[text()='Sell']")
	private WebElement sellText;
	@FindBy(xpath = "//mat-label[contains(text(),' Sales Account ')]/parent::label/parent::span/parent::div/input")
	private WebElement salesAccount;
	@FindBy(xpath = "//span[contains(.,'Sales Return')]")
	private WebElement salesReturnSalesAccount;
	@FindBy(xpath = "//mat-label[contains(text(),'Sales Price')]/parent::label/parent::span/parent::div/input")
	private WebElement salesPrice;
	@FindBy(xpath = "//mat-label[contains(text(),' Sales Tax ')]/parent::label/parent::span/parent::div/input")
	private WebElement salesTax;
	/*************** Inventory tab ******************************************/
	@FindBy(xpath = "//mat-label[contains(text(),'Unit of Measurement')]/parent::label/parent::span/parent::div/mat-select")
	private WebElement unitOfMeasurement;
	@FindBy(xpath = "//span[contains(.,'Pieces')]")
	private WebElement piecesUnitOfMeasurement;
	@FindBy(xpath = "//mat-label[contains(text(),' Cost of Goods Sold Account ')]/parent::label/parent::span/parent::div/input")
	private WebElement costOfGoodsSoldAccount;
	@FindBy(xpath = "//mat-label[contains(text(),' Inventory Account ')]/parent::label/parent::span/parent::div/input")
	private WebElement inventoryAccount;
	@FindBy(xpath = "//span[contains(.,'Manufacturing cost')]")
	private WebElement manufacturingCostInventoryAccount;
	@FindBy(xpath = "//mat-label[contains(text(),' Stock Adjustment Account ')]/parent::label/parent::span/parent::div/input")
	private WebElement stockAdjustmentAccount;
	@FindBy(xpath = "//mat-label[contains(text(),' Manufacturing Account ')]/parent::label/parent::span/parent::div/input")
	private WebElement manufacturingAccount;
	@FindBy(xpath = "//mat-label[contains(text(),'Opening Quantity')]/parent::label/parent::span/parent::div/input")
	private WebElement openingQuanity;
	@FindBy(xpath = "//mat-label[contains(text(),'Opening Valuation')]/parent::label/parent::span/parent::div/input")
	private WebElement openingValuation;
	@FindBy(xpath = "//mat-label[contains(text(),'Warehouse')]/parent::label/parent::span/parent::div/mat-select/div/div/span/span")
	private WebElement warehouse;
	@FindBy(xpath = "//button[contains(.,'Save')]")
	private WebElement saveButton;
	@FindBy(xpath = "//span[text()='Product has been saved successfully']")
	private WebElement createProductSuccessMessage;
	/***************
	 * Bill Of Material tab
	 ******************************************/
	@FindBy(xpath = "//div[contains(text(),'+ Add a Component Product')]")
	private WebElement addComponentProductButton;
	@FindBy(xpath = "//div[contains(text(),' + Add an Additional Cost ')]")
	private WebElement addAdditionalCostButton;
	@FindBy(xpath = "//input[@placeholder='Type here' or contains(@role,'combobox')]")
	private WebElement componentProduct1TextBox;
	@FindBy(xpath = "//span[@class='mat-option-text']")
	private WebElement dropDownSelectProduct;
	@FindBy(xpath = "//input[@placeholder='Quantity']")
	private WebElement componentProduct1Value;
	@FindBy(xpath = "//mat-option//span[2][@class='mat-option-text']")
	private WebElement componentProduct2Value;
	@FindBy(xpath = "(//input[contains(@placeholder,'Quantity')])[2]")
	private WebElement component2Quantity;
	/**************************** Created Product Verification Elements ***********/
	@FindBy(xpath = "//span[text()='Non-Tracked']//following::span[1][@class='count']")
	private WebElement nonTrackedProductCount;
	@FindBy(xpath = "//span[text()='Tracked Inventory']//following::span[1][@class='count']")
	private WebElement trackedProductCount;
	@FindBy(xpath = "//span[text()='Bill of Materials']//following::span[1][@class='count']")
	private WebElement BOMProductCount;
	@FindBy(xpath = "//span[contains(text(),'0')]//following::span[text()='Item with No Stock']")
	private WebElement zeroItemWithNoStock;
	@FindBy(xpath = "//input[contains(@placeholder,'SEARCH_RECORDS') or contains(@ng-reflect-placeholder,'Search Records')]")
	private WebElement searchRecordsBox;
	@FindBy(xpath = "//mat-table//mat-row[@class='mat-row ng-star-inserted']//mat-cell[3]//span[1]")
	private WebElement searchedRecord;
	@FindBy(xpath = "//div[text()='Product Name']//following::div[@class='field-value'][1]")
	private WebElement displayedProducName;
	@FindBy(xpath = "//div[text()='Product Number']//following::div[@class='field-value'][1]")
	private WebElement displayedProductNumber;
	@FindBy(xpath = "//div[text()='Product Type']//following::div[@class='field-value'][1]")
	private WebElement displayedProducType;
	@FindBy(xpath = "//div[text()='Barcode']//following::div[@class='field-value'][1]")
	private WebElement displayedBarcode;
	@FindBy(xpath = "//div[text()='Description']//following::div[@class='field-value'][1]")
	private WebElement displayedDescription;
	@FindBy(xpath = "//div[text()='Purchase Account']//following::div[@class='field-value'][1]")
	private WebElement displayedPurchaseAccount;
	@FindBy(xpath = "//div[text()='Product Price']//following::div[@class='field-value'][1]")
	private WebElement displayedPurchasePrice;
	@FindBy(xpath = "//div[text()='Purchase Tax']//following::div[@class='field-value'][1]")
	private WebElement displayedPurchaseTax;
	@FindBy(xpath = "//div[text()='Sales Account']//following::div[@class='field-value'][1]")
	private WebElement displayedSalesAccount;
	@FindBy(xpath = "//div[text()='Sales Price']//following::div[@class='field-value'][1]")
	private WebElement displayedSalesPrice;
	@FindBy(xpath = "//div[text()='Sales Tax']//following::div[@class='field-value'][1]")
	private WebElement displayedSalesTax;
	@FindBy(xpath = "(//span[contains(.,'Price is tax inclusive')]//ancestor::div[1]//input[@type='checkbox' and @aria-checked='false' ])[1]")
	private WebElement uncheckedPriceIsTaxInclusiveCheckbox_Buy;
	@FindBy(xpath = "(//span[contains(.,'Price is tax inclusive')]//ancestor::div[1]//input[@type='checkbox' and @aria-checked='false' ])[2]")
	private WebElement uncheckedPriceIsTaxInclusiveCheckbox_Sell;
	@FindBy(xpath = "//div[text()=' Unit of Measurement ']//following::div[@class='field-value'][1]")
	private WebElement displayedUnitOfMeasurement;
	@FindBy(xpath = "//div[text()=' Cost of Goods Account ']//following::div[@class='field-value'][1]")
	private WebElement displayedCostOfGoodsAccount;
	@FindBy(xpath = "//div[text()='Inventory Account']//following::div[@class='field-value'][1]")
	private WebElement displayedInventoryAccount;
	@FindBy(xpath = "//div[text()=' Stock Adjustment Account ']//following::div[@class='field-value'][1]")
	private WebElement displayedStockAdjustmentAccount;
	@FindBy(xpath = "//div[text()='Warehouse']//following::div[@class='field-value'][1]")
	private WebElement displayedWarehouse;
	@FindBy(xpath = "//div[text()='Opening Quantity']//following::div[@class='field-value'][1]")
	private WebElement displayedOpeningQuantity;
	@FindBy(xpath = "//div[text()='Opening Valuation']//following::div[@class='field-value'][1]")
	private WebElement displayedOpeningValuation;
	@FindBy(xpath = "//mat-table[contains(@class,'deskera-grid deskera-grid-products')]//following::mat-cell[2]//span[@class='text-elipsis']")
	private WebElement firstProduct;
	@FindBy(xpath = "//mat-cell[text()=' Non-Tracked ']//following::mat-icon[contains(.,'more_vert')]")
	private WebElement threeDotsOnNonTrackedProduct;
	@FindBy(xpath = "//mat-cell[text()=' Tracked ']//following::mat-icon[contains(.,'more_vert')]")
	private WebElement threeDotsOnTrackedProduct;
	@FindBy(xpath = "//mat-cell[text()=' Bill of Materials ']//following::mat-icon[contains(.,'more_vert')]")
	private WebElement threeDotsOnBOMProduct;
	@FindBy(xpath = "//button[contains(.,'Edit')]")
	private WebElement editButton;
	@FindBy(xpath = "//button[contains(.,'Copy')]")
	private WebElement copyButton;
	@FindBy(xpath = "//button[contains(.,'Delete')]")
	private WebElement deleteButton;
	@FindBy(xpath = "//span[@class='ng-star-inserted'][contains(.,'Save Changes')]")
	private WebElement saveChangesButton;
	@FindBy(xpath = "//span[text()='Product has been updated successfully']")
	private WebElement editSuccessMessage;
	@FindBy(xpath = "//div[contains(text(),'Are you sure you want to delete this product?')]")
	private WebElement deleteConfirmationMessage;
	@FindBy(xpath = "//button[contains(.,'No')]")
	private WebElement noButtonOnDeleteConfirmation;
	@FindBy(xpath = "//span[contains(.,'Yes')]")
	private WebElement yesButtonOnDeleteConfirmation;
	@FindBy(xpath = "//span[text()='Product has been deleted successfully']")
	private WebElement deleteSuccessMessage;
	/**************************** Custom Number Format Elements ***********/
	@FindBy(xpath = "//mat-label[contains(.,'Preview')]")
	private WebElement previewText;
	@FindBy(xpath = "//div//div[contains(@class,'result mt')]")
	private WebElement previewResultBox;
	@FindBy(xpath = "//input[@placeholder='Enter prefix']")
	private WebElement prefixTextBox;
	@FindBy(xpath = "(//div[@class='mat-select-arrow'])[2]")
	private WebElement separatorDropdown;
	@FindBy(xpath = "//span[@class='mat-option-text'][contains(.,'-')]")
	private WebElement hypenSeparator;
	@FindBy(xpath = "//span[@class='mat-option-text'][contains(.,'-')]")
	private WebElement hypenSeparatorAfterDigits;
	@FindBy(xpath = "//input[@placeholder='Enter display digits']")
	private WebElement digitsTextBox;
	@FindBy(xpath = "(//div[@class='mat-select-arrow'])[3]")
	private WebElement separatorDropdownAfterDigits;
	@FindBy(xpath = "//input[contains(@placeholder,'Enter suffix')]")
	private WebElement suffixTextBox;
	@FindBy(xpath = "//div[@class='mat-checkbox-inner-container']//following::span[contains(.,'Set as Default ')]")
	private WebElement setAsDefaultCheckBox;
	@FindBy(xpath = "//span[contains(.,'Cancel')]")
	private WebElement cancelCustomNumberFormat;
	@FindBy(xpath = "(//button[contains(.,'Save')])[2]")
	private WebElement saveCustomNumberFormat;
	@FindBy(xpath = "//div[contains(text(),'is saved successfully')]")
	private WebElement createCustomNumberFormatSuccessMessage;
	String customProductNumber = "G-0001-A";

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

	@Step("Click on New Product Button")
	public void clickNewProductButton() throws InterruptedException {
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Products')]")));
		// driver.findElement(By.xpath("//div[@id='container-1']/dt-navbar/div/ul/li[10]/a/span")).click();
		Thread.sleep(3000); // THis is important because popup gets loaded and
		// then disappears
		// driver.findElement(By.cssSelector("i.fas.fa-times.close-button.mt-2")).click();
		for (int second = 0; second <= 10; second++) {
			if (second == 10) {
				System.out.println("Popup Not found!");
				break;
			}
			try {
				if (closeOverlayPopup.isDisplayed()) {
					System.out.println("closig popup now 1");
					closeOverlayPopup.click(); // popup
					// close
					// button
					System.out.println("closed popup  1");
					break;
				}
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		newProductButton.click();
	}

	@Step("close popup on contacts page")
	public void clickPopup() throws InterruptedException {
		// driver.get("https://reality-qa.deskera.xyz/book-keeper/client");
		WDWait(productsTab);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Products')]")));
		// // Contact
		// //
		// link
		// // or
		// //
		// Produ
		// //
		// link
		// driver.findElement(By.xpath("//span[contains(.,'Products')]")).click();
		productsTab.click();
		Thread.sleep(3000); // THis is important because popup gets loaded and then disappears
		// driver.findElement(By.cssSelector("i.fas.fa-times.close-button.mt-2")).click();
		for (int second = 0; second <= 15; second++) {
			if (second == 15) {
				System.out.println("Popup Not found clickin on new Contact Button");
				break;
			}
			try {
				if (closeOverlayPopup.isDisplayed()) {
					System.out.println("closig popup now!");
					closeOverlayPopup.click(); // popup close
					// button
					System.out.println("closed popup");
					break;
				}
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		// driver.findElement(By.xpath("//button[3]/span")).click(); // Create new
		// contact button
	}

	@Step("Verify Create New Product Page")
	public void verifyCreateNewProductPage() {
		WDWait(createNewProductText);
		sAssert.assertTrue(createNewProductText.isDisplayed(), "");
		sAssert.assertTrue(generalInfoTab.isDisplayed(), "Verify generalInfoTab");
		sAssert.assertTrue(accountingTab.isDisplayed(), "Verify accountingTab");
		sAssert.assertTrue(inventoryTab.isDisplayed(), "Verify inventoryTab");
		sAssert.assertTrue(infoIcon.isDisplayed(), "Verify infoIcon");
		sAssert.assertTrue(chatIcon.isDisplayed(), "");
		sAssert.assertTrue(notificationIcon.isDisplayed(), "");
		sAssert.assertTrue(quickActionsText.isDisplayed(), "");
		sAssert.assertTrue(customNumberFormat.isDisplayed(), "");
		sAssert.assertTrue(customFields.isDisplayed(), "");
		sAssert.assertTrue(addImageArea.isDisplayed(), "");
		sAssert.assertTrue(productTypedropdown.isDisplayed(), "");
		sAssert.assertTrue(productNumber.isDisplayed(), "");
		sAssert.assertTrue(ProductNameInputBox.isDisplayed(), "");
		sAssert.assertTrue(barcodeInputBox.isDisplayed(), "");
		sAssert.assertTrue(descriptionInputBox.isDisplayed(), "");
		sAssert.assertTrue(saveButton.isDisplayed(), "");
		sAssert.assertAll();
	}

	@Step("Select Non Tracked Product from Dropdown")
	public void selectNonTrackedProduct() {
		sAssert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(productTypedropdown)) != null,
				"Verify productTypedropdown");
		productTypedropdown.click();
		nonTrackedProductType.click();
		sAssert.assertAll();
	}

	@Step("Select Tracked Product from Dropdown")
	public void selectTrackedProduct() {
		sAssert.assertTrue(wait.until(ExpectedConditions.visibilityOf(productTypedropdown)) != null,
				"Wait for productTypedropdown");
		productTypedropdown.click();
		trackedProductType.click();
		sAssert.assertAll();
	}

	@Step("Upload Image for Product")
	public void uploadImageProduct() throws InterruptedException, AWTException {
		// Supported onnly for windows local env
		if (System.getProperty("os.name").toLowerCase().contains("windows")
				|| System.getProperty("os.name").toLowerCase().contains("windows")) {
			WDWait(addImage);
			addImage.click();
			Robot rob = new Robot();
			StringSelection str = new StringSelection(System.getProperty("user.dir") + "\\Product.jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
			Thread.sleep(2000);
			Thread.sleep(2000);
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_V);
			Thread.sleep(2000);
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_V);
			Thread.sleep(2000);
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
		}
	}

	@Step("Select BOM Product from Dropdown")
	public void selectBOMProduct() {
		WDWait(productTypedropdown);
		productTypedropdown.click();
		billsOfMaterialProductType.click();
	}

	@Step("Enter Product Details")
	public void enterProductDetails(String productname, String description, String barcode) {
		WDWait(ProductNameInputBox);
		ProductNameInputBox.sendKeys(productname);
		barcodeInputBox.sendKeys(barcode);
		descriptionInputBox.sendKeys(description);
	}

	@Step("Click On Accounting Tab")
	public void clickAccountingTab() {
		WDWait(accountingTab);
		accountingTab.click();
	}

	/**************
	 * Purchase account dropdown should not have Sales and Sales Return , Sales
	 * Account should not have Purchase and Purchase Return values
	 */
	@Step("Verify Purchase Account Dropdown Values")
	public void verifyPurchaseAccountDropdownValues() {
		WDWait(purchaseAccount);
		wait.until(ExpectedConditions.elementToBeClickable(purchaseAccount));
		purchaseAccount.click();
		for (WebElement we : purchaseAccountDropdownValues) {
			for (int i = 0; i < purchaseAccountDropdownValues.size(); i++) {
				if (we.getText().equalsIgnoreCase("Sales") || we.getText().equalsIgnoreCase("Sales Return")) {
					Assert.fail();
				}
			}
		}
		accountingTab.click();
	}

	@Step("Verify Sales Account Dropdown Values")
	public void verifySalesAccountDropdownValues() {
		wait.until(ExpectedConditions.elementToBeClickable(salesAccount));
		salesAccount.click();
		for (WebElement we : salesAccountDropdownValues) {
			for (int i = 0; i < salesAccountDropdownValues.size(); i++) {
				if (we.getText().equalsIgnoreCase("Purchases") || we.getText().equalsIgnoreCase("Purchase Return")) {
					Assert.fail();
				}
			}
		}
		accountingTab.click();
	}

	@Step("Verify Accounting Tab Elements")
	public void verifyAccountingTab(String defaultPurchaseAccount, String defaultPurchasePrice,
			String defaultPurchaseTax, String defaultSalesAccount, String defaultSalesPrice, String defaultSalesTax) {
		WDWait(buyText);
		buyText.isDisplayed();
		sAssert.assertEquals(purchaseAccount.getAttribute("value"), defaultPurchaseAccount,
				"Verify defaultPurchaseAccount");
		sAssert.assertEquals(purchasePrice.getAttribute("value"), defaultPurchasePrice, "Verify defaultPurchasePrice");
		sAssert.assertTrue(purchaseTax.isDisplayed(), "");
		sAssert.assertEquals(purchaseTax.getAttribute("value"), defaultPurchaseTax, "Verify defaultPurchaseTax");
		sAssert.assertTrue(priceIsTaxInclusiveCheckBox_Buy.isDisplayed(), "");
		sAssert.assertTrue(sellText.isDisplayed(), "");
		sAssert.assertEquals(salesAccount.getAttribute("value"), defaultSalesAccount, "Verify defaultSalesAccount");
		sAssert.assertEquals(salesPrice.getAttribute("value"), defaultSalesPrice, "Verify defaultSalesPrice");
		sAssert.assertTrue(salesTax.isDisplayed(), "");
		sAssert.assertEquals(salesTax.getAttribute("value"), defaultSalesTax, "Verify defaultSalesTax");
		sAssert.assertTrue(priceIsTaxInclusiveCheckBox_Sell.isDisplayed(), "");
		sAssert.assertAll();
	}

	@Step("Verify Accounting Tab Elements for BOM Product")
	public void verifyAccountingTabForBOMProduct(String defaultPurchaseAccount, String defaultPurchaseTax,
			String defaultSalesAccount, String defaultSalesPrice, String defaultSalesTax) {
		WDWait(buyText);
		buyText.isDisplayed();
		sAssert.assertEquals(purchaseAccount.getAttribute("value"), defaultPurchaseAccount);
		purchaseTax.isDisplayed();
		sAssert.assertEquals(purchaseTax.getAttribute("value"), defaultPurchaseTax);
		priceIsTaxInclusiveCheckBox_Buy.isDisplayed();
		sellText.isDisplayed();
		sAssert.assertEquals(salesAccount.getAttribute("value"), defaultSalesAccount);
		sAssert.assertEquals(salesPrice.getAttribute("value"), defaultSalesPrice);
		salesTax.isDisplayed();
		sAssert.assertEquals(salesTax.getAttribute("value"), defaultSalesTax);
		priceIsTaxInclusiveCheckBox_Sell.isDisplayed();
		sAssert.assertAll();
	}

	@Step("Enter Accounting Info")
	public void enterAccountingInfo(String purchaseprice, String salesprice) {
		WDWait(purchasePrice);
		purchasePrice.clear();
		purchasePrice.sendKeys(purchaseprice);
		salesPrice.clear();
		salesPrice.sendKeys(salesprice);
	}

	@Step("Enter Accounting Info for BOM Product")
	public void enterAccountingInfoForBOMProduct(String salesprice) {
		WDWait(salesPrice);
		salesPrice.sendKeys(salesprice);
	}

	@Step("Click on Inventory Tab")
	public void clickInventoryTab() {
		WDWait(inventoryTab);
		inventoryTab.click();
	}

	@Step("Verify Inventory Tab For Non Tracked Product")
	public void verifyInventoryTabForNonTrackedProduct(String defaultUnitOfMeasurement) {
		WDWait(unitOfMeasurement);
		unitOfMeasurement.isDisplayed();
		sAssert.assertEquals(unitOfMeasurement.getText(), defaultUnitOfMeasurement);
		sAssert.assertAll();
	}

	@Step("Verify Inventory Tab For Tracked Product")
	public void verifyInventoryTabForTrackedProduct(String defaultUnitOfMeasurement,
			String defaultCostOfGoodSoldAccount, String defaultInventoryAccount, String defaultStockAdjustmentAccount)
			throws InterruptedException {
		Thread.sleep(4000);
		WDWait(unitOfMeasurement);
		unitOfMeasurement.isDisplayed();
		sAssert.assertEquals(unitOfMeasurement.getText(), defaultUnitOfMeasurement);
		costOfGoodsSoldAccount.isDisplayed();
		sAssert.assertEquals(costOfGoodsSoldAccount.getAttribute("value"), defaultCostOfGoodSoldAccount);
		inventoryAccount.isDisplayed();
		sAssert.assertEquals(inventoryAccount.getAttribute("value"), defaultInventoryAccount);
		stockAdjustmentAccount.isDisplayed();
		sAssert.assertEquals(stockAdjustmentAccount.getAttribute("value"), defaultStockAdjustmentAccount);
		sAssert.assertEquals(openingQuanity.getAttribute("value"), "0");
		sAssert.assertEquals(openingValuation.getAttribute("value"), "0");
		warehouse.isDisplayed();
		sAssert.assertEquals(warehouse.getText(), "Primary Warehouse");
		sAssert.assertAll();
	}

	@Step("Verify Inventory Tab For BOM Product")
	public void verifyInventoryTabForBOMProduct(String defaultUnitOfMeasurement, String defaultCostOfGoodSoldAccount,
			String defaultManufacturingAccount, String defaultStockAdjustmentAccount) throws InterruptedException {
		Thread.sleep(4000);
		WDWait(unitOfMeasurement);
		unitOfMeasurement.isDisplayed();
		sAssert.assertEquals(unitOfMeasurement.getText(), defaultUnitOfMeasurement);
		costOfGoodsSoldAccount.isDisplayed();
		sAssert.assertEquals(costOfGoodsSoldAccount.getAttribute("value"), defaultCostOfGoodSoldAccount);
		inventoryAccount.isDisplayed();
		stockAdjustmentAccount.isDisplayed();
		sAssert.assertEquals(stockAdjustmentAccount.getAttribute("value"), defaultStockAdjustmentAccount);
		manufacturingAccount.isDisplayed();
		sAssert.assertEquals(manufacturingAccount.getAttribute("value"), defaultManufacturingAccount);
		sAssert.assertEquals(openingQuanity.getAttribute("value"), "0");
		sAssert.assertEquals(openingValuation.getAttribute("value"), "0");
		warehouse.isDisplayed();
		sAssert.assertEquals(warehouse.getText(), "Primary Warehouse");
		sAssert.assertAll();
	}

	@Step("Select Inventory Account")
	public void selectInventoryAccount() {
		WDWait(inventoryAccount);
		inventoryAccount.click();
		WDWait(manufacturingCostInventoryAccount);
		manufacturingCostInventoryAccount.click();
	}

	@Step("Enter Opening Balance Details")
	public void enterOpeningBalanceDetails(String openingquanity, String openingvaluation) {
		WDWait(openingQuanity);
		openingQuanity.sendKeys(openingquanity);
		openingValuation.sendKeys(openingvaluation);
	}

	@Step("Click On Bills Of Material Tab")
	public void clickBillOfMaterialTab() {
		WDWait(billsOfMaterialTab);
		billsOfMaterialTab.click();
	}

	@Step("Verify On Bills Of Material Tab")
	public void verifyBillOfMaterialTab() {
		WDWait(addComponentProductButton);
		addComponentProductButton.isDisplayed();
		addAdditionalCostButton.isDisplayed();
	}

	@Step("Enter BOM Details")
	public void enterBOMDetails(String trackedProduct, String quantity) throws InterruptedException {
		// addComponentProductButton.click();
		// WDWait(componentProduct1TextBox);
		// wait.until(ExpectedConditions.elementToBeClickable(componentProduct1TextBox));
		WDWait(componentProduct1TextBox);
		Thread.sleep(4000);
		componentProduct1TextBox.click();
		componentProduct1TextBox.sendKeys(trackedProduct);
		WDWait(dropDownSelectProduct);
		dropDownSelectProduct.click();
		WDWait(componentProduct1Value);
		componentProduct1Value.click();
		componentProduct1Value.clear();
		componentProduct1Value.sendKeys(quantity);
	}

	@Step("Click On Save Button")
	public void clickSaveButton() {
		WDWait(saveButton);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}

	@Step("Verify Create Product Success Message")
	public void verifyCreateProductSuccessMessage() {
		WDWait(createProductSuccessMessage);
		createProductSuccessMessage.isDisplayed();
		sAssert.assertTrue(wait.until(ExpectedConditions.visibilityOf(createProductSuccessMessage)) != null);
		sAssert.assertAll();
	}

	@Step("Verify Tracked Product Count")
	public void verifyTrackedProductCount() throws InterruptedException {
		Thread.sleep(3000);
		if (startByAddingOrImportingYourProducsText.size() != 0) {
			Thread.sleep(2000);
			closeIcon.click();
		}
		WDWait(trackedProductCount);
		trackedProductCount.isDisplayed();
		sAssert.assertEquals(trackedProductCount.getText(), "1");
		zeroItemWithNoStock.isDisplayed();
		sAssert.assertAll();
	}

	@Step("Verify Non Tracked Product Count")
	public void verifyNonTrackedProductCount() throws InterruptedException {
		 Thread.sleep(5000);
		if (startByAddingOrImportingYourProducsText.size() != 0) {
			Thread.sleep(2000);
			closeIcon.click();
		}
		WDWait(nonTrackedProductCount);
		nonTrackedProductCount.isDisplayed();
		sAssert.assertEquals(nonTrackedProductCount.getText(), "1");
		zeroItemWithNoStock.isDisplayed();
		sAssert.assertAll();
	}

	@Step("Verify BOM Product Count")
	public void verifyBomProductCount() throws InterruptedException {
		 Thread.sleep(3000);
		if (startByAddingOrImportingYourProducsText.size() != 0) {
			Thread.sleep(2000);
			closeIcon.click();
		}
		WDWait(BOMProductCount);
		BOMProductCount.isDisplayed();
		sAssert.assertEquals(BOMProductCount.getText(), "1");
		zeroItemWithNoStock.isDisplayed();
		sAssert.assertAll();
	}

	@Step("Verify Created Tracked Product")
	public void verifyCreatedTrackedProduct(String productname, String description, String barcode,
			String defaultPurchaseAccount, String purchasePrice, String defaultSalesAccount, String salesPrice,
			String defaultPurchaseTax, String defaultSalesTax) throws InterruptedException {
		WDWait(searchRecordsBox);
		Thread.sleep(2000);
		searchRecordsBox.click();
		searchRecordsBox.sendKeys(productname);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		searchedRecord.click();
		WDWait(displayedProducName);
		sAssert.assertEquals(displayedProducName.getText(), productname);
		sAssert.assertEquals(displayedProducType.getText(), "Tracked");
		sAssert.assertEquals(displayedBarcode.getText(), barcode);
		sAssert.assertEquals(displayedDescription.getText(), description);
		action.moveToElement(displayedPurchaseAccount).perform();
		sAssert.assertEquals(displayedPurchaseAccount.getText(), defaultPurchaseAccount);
		action.moveToElement(displayedPurchasePrice).perform();
		WDWait(displayedPurchasePrice);
		sAssert.assertEquals(displayedPurchasePrice.getText(), purchasePrice);
		action.moveToElement(displayedPurchaseTax).perform();
		sAssert.assertEquals(displayedPurchaseTax.getText(), defaultPurchaseTax);
		uncheckedPriceIsTaxInclusiveCheckbox_Buy.isDisplayed();
		action.moveToElement(displayedSalesAccount).perform();
		sAssert.assertEquals(displayedSalesAccount.getText(), defaultSalesAccount);
		action.moveToElement(displayedSalesPrice).perform();
		sAssert.assertEquals(displayedSalesPrice.getText(), salesPrice);
		action.moveToElement(displayedSalesTax).perform();
		sAssert.assertEquals(displayedSalesTax.getText(), defaultSalesTax);
		uncheckedPriceIsTaxInclusiveCheckbox_Sell.isDisplayed();
		sAssert.assertAll();
	}

	@Step("Verify Created Non Tracked Product")
	public void verifyCreatedNonTrackedProduct(String productname, String description, String barcode,
			String defaultPurchaseAccount, String purchasePrice, String defaultSalesAccount, String salesPrice,
			String defaultPurchaseTax, String defaultSalesTax) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(searchRecordsBox));
		WDWait(searchRecordsBox);
		searchRecordsBox.click();
		searchRecordsBox.sendKeys(productname);
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		// WDWait(searchedRecord);
		searchedRecord.click();
		WDWait(displayedProducName);
		sAssert.assertEquals(displayedProducName.getText(), productname);
		sAssert.assertEquals(displayedProducType.getText(), "Non-Tracked");
		sAssert.assertEquals(displayedBarcode.getText(), barcode);
		sAssert.assertEquals(displayedDescription.getText(), description);
		action.moveToElement(displayedPurchaseAccount).perform();
		sAssert.assertEquals(displayedPurchaseAccount.getText(), defaultPurchaseAccount);
		action.moveToElement(displayedPurchasePrice).perform();
		sAssert.assertEquals(displayedPurchasePrice.getText(), purchasePrice);
		action.moveToElement(displayedPurchaseTax).perform();
		sAssert.assertEquals(displayedPurchaseTax.getText(), defaultPurchaseTax);
		uncheckedPriceIsTaxInclusiveCheckbox_Buy.isDisplayed();
		action.moveToElement(displayedSalesAccount).perform();
		sAssert.assertEquals(displayedSalesAccount.getText(), defaultSalesAccount);
		action.moveToElement(displayedSalesPrice).perform();
		sAssert.assertEquals(displayedSalesPrice.getText(), salesPrice);
		action.moveToElement(displayedSalesTax).perform();
		sAssert.assertEquals(displayedSalesTax.getText(), defaultSalesTax);
		uncheckedPriceIsTaxInclusiveCheckbox_Sell.isDisplayed();
		sAssert.assertAll();
	}

	@Step("Verify Inventory Details For Created Non Tracked Product")
	public void verifyInventoryDetailsForCreatedNonTrackedProduct(String defaultUnitOfMeasurement) {
		Actions action = new Actions(driver);
		action.moveToElement(displayedUnitOfMeasurement).perform();
		sAssert.assertEquals(displayedUnitOfMeasurement.getText(), defaultUnitOfMeasurement);
		sAssert.assertAll();
	}

	@Step("Verify Inventory Details For Created Tracked Product")
	public void verifyInventoryDetailsForCreatedTrackedProduct(String defaultUnitOfMeasurement,
			String defaultCostOfGoodSoldAccount, String defaultInventoryAccount, String defaultStockAdjustmentAccount,
			String defaultWarehouseCode, String openingQuanity, String openingValuation) {
		Actions action = new Actions(driver);
		action.moveToElement(displayedUnitOfMeasurement).perform();
		sAssert.assertEquals(displayedUnitOfMeasurement.getText(), defaultUnitOfMeasurement);
		action.moveToElement(displayedCostOfGoodsAccount).perform();
		sAssert.assertEquals(displayedCostOfGoodsAccount.getText(), defaultCostOfGoodSoldAccount);
		action.moveToElement(displayedInventoryAccount).perform();
		sAssert.assertEquals(displayedInventoryAccount.getText(), defaultInventoryAccount);
		action.moveToElement(displayedStockAdjustmentAccount).perform();
		sAssert.assertEquals(displayedStockAdjustmentAccount.getText(), defaultStockAdjustmentAccount);
		action.moveToElement(displayedWarehouse).perform();
		sAssert.assertEquals(displayedWarehouse.getText(), defaultWarehouseCode);
		action.moveToElement(displayedOpeningQuantity).perform();
		sAssert.assertEquals(displayedOpeningQuantity.getText(), openingQuanity);
		action.moveToElement(displayedOpeningValuation).perform();
		sAssert.assertEquals(displayedOpeningValuation.getText(), openingValuation);
		sAssert.assertAll();
	}

	@Step("Verify Created BOM Product")
	public void verifyCreatedBOMProduct(String productname, String description, String barcode,
			String defaultPurchaseAccount, String defaultSalesAccount, String salesPrice, String defaultPurchaseTax,
			String defaultSalesTax) throws InterruptedException {
		WDWait(searchRecordsBox);
		searchRecordsBox.click();
		searchRecordsBox.sendKeys(productname);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		// WDWait(searchedRecord);
		searchedRecord.click();
		WDWait(displayedProducName);
		sAssert.assertEquals(displayedProducName.getText(), productname);
		sAssert.assertEquals(displayedProducType.getText(), "Bill of Materials");
		sAssert.assertEquals(displayedBarcode.getText(), barcode);
		sAssert.assertEquals(displayedDescription.getText(), description);
		Thread.sleep(5000);
		action.moveToElement(displayedPurchaseAccount).perform();
		sAssert.assertEquals(displayedPurchaseAccount.getText(), defaultPurchaseAccount);
		action.moveToElement(displayedPurchaseTax).perform();
		sAssert.assertEquals(displayedPurchaseTax.getText(), defaultPurchaseTax);
		uncheckedPriceIsTaxInclusiveCheckbox_Buy.isDisplayed();
		action.moveToElement(displayedSalesAccount).perform();
		sAssert.assertEquals(displayedSalesAccount.getText(), defaultSalesAccount);
		action.moveToElement(displayedSalesPrice).perform();
		sAssert.assertEquals(displayedSalesPrice.getText(), salesPrice);
		action.moveToElement(displayedSalesTax).perform();
		sAssert.assertEquals(displayedSalesTax.getText(), defaultSalesTax);
		uncheckedPriceIsTaxInclusiveCheckbox_Sell.isDisplayed();
		sAssert.assertAll();
	}

	@Step("Verify Inventory Details For Created BOM Product")
	public void verifyInventoryDetailsForCreatedBOMProduct(String defaultUnitOfMeasurement,
			String defaultCostOfGoodSoldAccount, String defaultStockAdjustmentAccount, String defaultWarehouseCode,
			String openingQuanity, String openingValuation) {
		Actions action = new Actions(driver);
		action.moveToElement(displayedUnitOfMeasurement).perform();
		sAssert.assertEquals(displayedUnitOfMeasurement.getText(), defaultUnitOfMeasurement);
		action.moveToElement(displayedCostOfGoodsAccount).perform();
		sAssert.assertEquals(displayedCostOfGoodsAccount.getText(), defaultCostOfGoodSoldAccount);
		action.moveToElement(displayedInventoryAccount).perform();
		sAssert.assertEquals(displayedInventoryAccount.getText(), "Manufacturing cost");
		action.moveToElement(displayedStockAdjustmentAccount).perform();
		sAssert.assertEquals(displayedStockAdjustmentAccount.getText(), defaultStockAdjustmentAccount);
		action.moveToElement(displayedWarehouse).perform();
		sAssert.assertEquals(displayedWarehouse.getText(), defaultWarehouseCode);
		action.moveToElement(displayedOpeningQuantity).perform();
		sAssert.assertEquals(displayedOpeningQuantity.getText(), openingQuanity);
		action.moveToElement(displayedOpeningValuation).perform();
		sAssert.assertEquals(displayedOpeningValuation.getText(), openingValuation);
		sAssert.assertAll();
	}

	/*****************************
	 * Edit Product Methods
	 ******************************/
	@Step("Select First Product")
	public void selectFirstProduct() {
		WDWait(firstProduct);
		firstProduct.click();
	}

	@Step("Click Three Dots On Non Tracked Product")
	public void clickThreeDotsOnNonTrackedProduct() throws InterruptedException {
		clickPopup();
		WDWait(threeDotsOnNonTrackedProduct);
		threeDotsOnNonTrackedProduct.click();
	}

	@Step("Click Three Dots On Tracked Product")
	public void clickThreeDotsOnTrackedProduct() throws InterruptedException {
		clickPopup();
		WDWait(threeDotsOnTrackedProduct);
		threeDotsOnTrackedProduct.click();
	}

	@Step("Click Three Dots On BOM Product")
	public void clickThreeDotsOnBOMProduct() throws InterruptedException {
		clickPopup();
		WDWait(threeDotsOnBOMProduct);
		threeDotsOnBOMProduct.click();
	}

	@Step("Click On Edit Button")
	public void clickEditButton() {
		WDWait(editButton);
		editButton.click();
	}

	@Step("Click On Copy Button")
	public void clickCopyButton() {
		WDWait(copyButton);
		copyButton.click();
	}

	@Step("Click On Delete Button")
	public void clickDeleteButton() {
		WDWait(deleteButton);
		deleteButton.click();
	}

	@Step("Edit General Information")
	public void editGeneralInfo(String productname, String barcode, String description) {
		WDWait(ProductNameInputBox);
		ProductNameInputBox.clear();
		ProductNameInputBox.sendKeys(productname);
		barcodeInputBox.clear();
		barcodeInputBox.sendKeys(barcode);
		descriptionInputBox.clear();
		descriptionInputBox.sendKeys(description);
	}

	@Step("Edit Account Details")
	public void editAccountingDetails(String purchaseprice, String salesprice) {
		WDWait(purchaseAccount);
		wait.until(ExpectedConditions.elementToBeClickable(purchaseAccount));
		purchaseAccount.click();
		WDWait(purchaseReturnPurchaseAccount);
		purchaseReturnPurchaseAccount.click();
		purchasePrice.clear();
		purchasePrice.sendKeys(purchaseprice);
		WDWait(salesAccount);
		wait.until(ExpectedConditions.elementToBeClickable(salesAccount));
		salesAccount.click();
		WDWait(salesReturnSalesAccount);
		salesReturnSalesAccount.click();
		salesPrice.clear();
		salesPrice.sendKeys(salesprice);
	}

	@Step("Edit Inventory Details")
	public void editInventoryDetails(String updatedUnitOfMeasurement) {
		WDWait(unitOfMeasurement);
		wait.until(ExpectedConditions.elementToBeClickable(unitOfMeasurement));
		unitOfMeasurement.click();
		WDWait(piecesUnitOfMeasurement);
		piecesUnitOfMeasurement.click();
	}

	@Step("Click On Save Changes Button")
	public void clickSaveChangesButton() {
		WDWait(saveChangesButton);
		saveChangesButton.click();
	}

	@Step("Verify Edit Success Message")
	public void verifyEditSuccessMessage() {
		WDWait(editSuccessMessage);
		editSuccessMessage.isDisplayed();
		wait.until(ExpectedConditions.invisibilityOf(editSuccessMessage));
	}

	@Step("Verify Edited Non Tracked Product")
	public void verifyEditedNonTrackedProduct(String productname, String description, String barcode,
			String updatedPurchaseAccount, String purchasePrice, String updatedSalesAccount, String salesPrice,
			String defaultPurchaseTax, String defaultSalesTax) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(searchRecordsBox));
		WDWait(searchRecordsBox);
		searchRecordsBox.click();
		searchRecordsBox.sendKeys(productname);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		// WDWait(searchedRecord);
		wait.until(ExpectedConditions.elementToBeClickable(searchedRecord));
		searchedRecord.click();
		WDWait(displayedProducName);
		sAssert.assertEquals(displayedProducName.getText(), productname);
		sAssert.assertEquals(displayedProducType.getText(), "Non-Tracked");
		sAssert.assertEquals(displayedBarcode.getText(), barcode);
		sAssert.assertEquals(displayedDescription.getText(), description);
		action.moveToElement(displayedPurchaseAccount).perform();
		sAssert.assertEquals(displayedPurchaseAccount.getText(), updatedPurchaseAccount);
		action.moveToElement(displayedPurchasePrice).perform();
		sAssert.assertEquals(displayedPurchasePrice.getText(), purchasePrice);
		action.moveToElement(displayedPurchaseTax).perform();
		sAssert.assertEquals(displayedPurchaseTax.getText(), defaultPurchaseTax);
		uncheckedPriceIsTaxInclusiveCheckbox_Buy.isDisplayed();
		action.moveToElement(displayedSalesAccount).perform();
		sAssert.assertEquals(displayedSalesAccount.getText(), updatedSalesAccount);
		action.moveToElement(displayedSalesPrice).perform();
		sAssert.assertEquals(displayedSalesPrice.getText(), salesPrice);
		action.moveToElement(displayedSalesTax).perform();
		sAssert.assertEquals(displayedSalesTax.getText(), defaultSalesTax);
		uncheckedPriceIsTaxInclusiveCheckbox_Sell.isDisplayed();
		sAssert.assertAll();
	}

	@Step("Verify Tracked Product Count After Copy Product")
	public void verifyTrackedProductCountAfterCopyProduct() throws InterruptedException {
		// Thread.sleep(5000);
		if (startByAddingOrImportingYourProducsText.size() != 0) {
			Thread.sleep(2000);
			closeIcon.click();
		}
		WDWait(trackedProductCount);
		trackedProductCount.isDisplayed();
		sAssert.assertEquals(trackedProductCount.getText(), "2");
		sAssert.assertAll();
	}

	@Step("Verify Copied Tracked Product")
	public void verifyCopiedTrackedProduct(String productname, String description, String barcode,
			String defaultPurchaseAccount, String purchasePrice, String defaultSalesAccount, String salesPrice,
			String defaultPurchaseTax, String defaultSalesTax) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(searchRecordsBox));
		WDWait(searchRecordsBox);
		Thread.sleep(2000);
		searchRecordsBox.click();
		searchRecordsBox.sendKeys(productname);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		searchedRecord.click();
		WDWait(displayedProducName);
		sAssert.assertEquals(displayedProducName.getText(), productname);
		sAssert.assertEquals(displayedProducType.getText(), "Tracked");
		sAssert.assertEquals(displayedBarcode.getText(), barcode);
		sAssert.assertEquals(displayedDescription.getText(), description);
		action.moveToElement(displayedPurchaseAccount).perform();
		sAssert.assertEquals(displayedPurchaseAccount.getText(), defaultPurchaseAccount);
		action.moveToElement(displayedPurchasePrice).perform();
		sAssert.assertEquals(displayedPurchasePrice.getText(), purchasePrice);
		action.moveToElement(displayedPurchaseTax).perform();
		sAssert.assertEquals(displayedPurchaseTax.getText(), defaultPurchaseTax);
		uncheckedPriceIsTaxInclusiveCheckbox_Buy.isDisplayed();
		action.moveToElement(displayedSalesAccount).perform();
		sAssert.assertEquals(displayedSalesAccount.getText(), defaultSalesAccount);
		action.moveToElement(displayedSalesPrice).perform();
		sAssert.assertEquals(displayedSalesPrice.getText(), salesPrice);
		action.moveToElement(displayedSalesTax).perform();
		sAssert.assertEquals(displayedSalesTax.getText(), defaultSalesTax);
		uncheckedPriceIsTaxInclusiveCheckbox_Sell.isDisplayed();
		sAssert.assertAll();
	}

	@Step("Verify Delete Confirmation")
	public void verifyDeleteConfirmation() {
		WDWait(deleteConfirmationMessage);
		deleteConfirmationMessage.isDisplayed();
		noButtonOnDeleteConfirmation.isDisplayed();
		yesButtonOnDeleteConfirmation.isDisplayed();
	}

	@Step("Click Yes Button On Delete Confirmation")
	public void clickYesButtonOnDeleteConfirmation() throws InterruptedException {
		WDWait(yesButtonOnDeleteConfirmation);
		wait.until(ExpectedConditions.elementToBeClickable(yesButtonOnDeleteConfirmation));
		yesButtonOnDeleteConfirmation.click();
	}

	@Step("Verify Delete Product Success Message")
	public void verifyDeleteProductSuccessMessage() throws InterruptedException {
		WDWait(deleteSuccessMessage);
		deleteSuccessMessage.isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(deleteSuccessMessage));
		Thread.sleep(2000);
	}

	@Step("Verify BOM Product Count After Delete")
	public void verifyBOMProductCountAfterDelete() throws InterruptedException {
		// Thread.sleep(5000);
		if (startByAddingOrImportingYourProducsText.size() != 0) {
			Thread.sleep(2000);
			closeIcon.click();
		}
		WDWait(BOMProductCount);
		BOMProductCount.isDisplayed();
		sAssert.assertEquals(BOMProductCount.getText(), "0");
		sAssert.assertAll();
	}

	@Step("Verify Deleted Product")
	public void verifyDeletedProduct(String BOMProductName) {
		if (driver.getPageSource().contains(BOMProductName)) {
			System.out.println("Product not deleted");
			Assert.fail();
		} else {
			System.out.println("Product Deleted successfully");
		}
	}

	@Step("Click On Custom Number Format Button")
	public void clickCustomNumberFormat() {
		wait.until(ExpectedConditions.elementToBeClickable(customNumberFormat));
		customNumberFormat.click();
	}

	@Step("Verify Custom Number Format Page Elements ")
	public void verifyCustomNumberFormatPageElements() {
		WDWait(previewText);
		previewText.isDisplayed();
		previewResultBox.isDisplayed();
		prefixTextBox.isDisplayed();
		separatorDropdown.isDisplayed();
		digitsTextBox.isDisplayed();
		separatorDropdownAfterDigits.isDisplayed();
		suffixTextBox.isDisplayed();
		setAsDefaultCheckBox.isDisplayed();
		cancelCustomNumberFormat.isDisplayed();
		saveCustomNumberFormat.isDisplayed();
	}

	@Step("Enter / Select Custom Number format details ")
	public void enterCustomNumberFormat() {
		WDWait(prefixTextBox);
		prefixTextBox.sendKeys("G");
		wait.until(ExpectedConditions.elementToBeClickable(separatorDropdown));
		separatorDropdown.click();
		WDWait(hypenSeparator);
		hypenSeparator.click();
		digitsTextBox.clear();
		digitsTextBox.sendKeys("4");
		wait.until(ExpectedConditions.elementToBeClickable(separatorDropdownAfterDigits));
		separatorDropdownAfterDigits.click();
		WDWait(hypenSeparatorAfterDigits);
		hypenSeparatorAfterDigits.click();
		WDWait(suffixTextBox);
		suffixTextBox.sendKeys("A");
	}

	@Step("Preview Custom Number format")
	public void previewCustomNumberFormat() {
		WDWait(previewResultBox);
		sAssert.assertEquals(previewResultBox.getText(), customProductNumber);
		sAssert.assertAll();
	}

	@Step("Click on Save Button on Custom Number Format Page")
	public void clickSaveCustomNumberFormat() throws InterruptedException {
		WDWait(saveCustomNumberFormat);
		saveCustomNumberFormat.click();
		Thread.sleep(4000);
	}

	@Step("Verify Custom Number Format In Product Number")
	public void verifyCustomNumberFormatInProductNumber() throws InterruptedException {
		WDWait(productNumber);
		Thread.sleep(5000);
		sAssert.assertEquals(productNumber.getAttribute("value"), customProductNumber);
		sAssert.assertAll();
	}

	@Step("Verify Create Custom Number Format Success Message")
	public void verifyCustomNumberFormatSuccessMessage() {
		WDWait(createCustomNumberFormatSuccessMessage);
		createCustomNumberFormatSuccessMessage.isDisplayed();
		wait.until(ExpectedConditions.invisibilityOf(createCustomNumberFormatSuccessMessage));
	}

	@Step("Verify Dispalyed Product Number and Format")
	public void verifyDisplayedProductNumber() {
		WDWait(displayedProductNumber);
		Actions action = new Actions(driver);
		action.moveToElement(displayedProductNumber).perform();
		sAssert.assertEquals(displayedProductNumber.getText(), customProductNumber);
		sAssert.assertAll();
	}
}
