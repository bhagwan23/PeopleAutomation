package deskera.web.automation.erp.bvtSG.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.bvtSG.pages.HomePage;
import deskera.web.automation.erp.bvtSG.pages.SellPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

public class CreateInvoiceTest extends DriverFactory{
	String confPath, url,confProductsPath,confContactsPath;
	ReadPropertyUtil rProp = new ReadPropertyUtil();

	/**
	 * Get common details required for test
	 * 
	 * @param conf
	 * @param URL
	 */
	@BeforeClass
	@Parameters({ "conf", "environment","confProducts","confContacts"})
	public void getConf(String conf, String URL,String confProducts,String confContacts) {
		confPath = conf;
		url = URL;
		confProductsPath=confProducts;
		confContactsPath=confContacts;
	}
	
	@TestRailId(testRailId = 21100)
	@Test()
	@Description(value = "C21100 To verify that user is able to Create/Fulfill/Get paid - Invoice")
	public void createInvoiceTest() throws InterruptedException {
		// Read test specific data from config
		String quantity = ReadPropertyUtil.readProperty("quantity", confPath);
		String discount = ReadPropertyUtil.readProperty("discount", confPath);
		String trackedProductName = ReadPropertyUtil.readProperty("trackedProductName", confProductsPath);	
		String contactName = ReadPropertyUtil.readProperty("ContactName", confContactsPath);
		// Create Page Object instance
		HomePage homePage=new HomePage(driver, wait);
		SellPage sellPage=new SellPage(driver, wait);		
		// Access Test methods
		homePage.clickSellTab();
		sellPage.verifyPageTitle();
		sellPage.verifySellPageElements();
		sellPage.clickNewInvoiceButton();
		sellPage.verifyCreateInvoicePageElements();
		sellPage.selectContact(contactName);
        sellPage.verifyDisplayedDates();
		sellPage.selectProduct(trackedProductName);		
		sellPage.enterProductDetails(quantity, discount);
		sellPage.verifyTotalAmount();
		sellPage.clickSaveButton();
		sellPage.verifyCreateInvoiceSuccessMessage();
		sellPage.verifyCreatedInvoice();
		sellPage.clickThreeDots();
		sellPage.clickFullfillButton();
		sellPage.verifyFullfillYourInvoiceWindowElements();
		sellPage.clickDirectButton();
		sellPage.verifyDirectFulfillmentOfInvoiceWindowElements();
		sellPage.clickFullfillButton();
		sellPage.verifyFulfillmentStatus();
		sellPage.openFirstInvoice();
		sellPage.clickReceivePaymentButton();
		sellPage.verifyRaceivePaymentWindowElements();
		sellPage.selectCashOption();
		sellPage.clickNextButton();
		sellPage.clickReceiveButton();
		
		
		
		
		
		
		
		/*
		sellPage.verifyCreatedQuote();
		sellPage.clickThreeDots();
		sellPage.clickFullfillButton();
		sellPage.verifyFullfillYourQuotationwindowElements();
		sellPage.clickDirectButton();
		sellPage.clickFullfillButton();
		sellPage.verifyFulfillmentStatus();
		sellPage.verifyCountOfInvoiceBefore();
		sellPage.openFirstQuoteQuote();
		sellPage.clickConvertToInvoiceButton();
		sellPage.verifyCountOfInvoiceAfter();	*/
	}
}
