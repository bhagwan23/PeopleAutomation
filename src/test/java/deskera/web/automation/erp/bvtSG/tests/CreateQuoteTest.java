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

public class CreateQuoteTest extends DriverFactory{

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
	
	@TestRailId(testRailId = 21099)
	@Test()
	@Description(value = "C21099 To verify that user is able to Create/Fulfill/Invoice/ - Quote")
	public void createQuoteTest() throws InterruptedException {
		// Read test specific data from config
		/*
		 * String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		 * String passWord = ReadPropertyUtil.readProperty("userPass", confPath);
		 */
		String quantity = ReadPropertyUtil.readProperty("quantity", confPath);
		String discount = ReadPropertyUtil.readProperty("discount", confPath);
		String trackedProductName = ReadPropertyUtil.readProperty("trackedProductName", confProductsPath);	
		String contactName = ReadPropertyUtil.readProperty("ContactName", confContactsPath);
		// Create Page Object instance
	//	LoginPage loginPage = new LoginPage(driver, wait);
		HomePage homePage=new HomePage(driver, wait);
		SellPage sellPage=new SellPage(driver, wait);
		
		// Access Test methods
		/*
		 * loginPage.openURL(url); loginPage.verifyPageTitle();
		 * loginPage.verifyLoginPageElements();
		 * loginPage.enterEmailandPassword(emailAddress, passWord);
		 * loginPage.clickSignIn();
		 */
		homePage.clickSellTab();
		sellPage.verifyPageTitle();
		sellPage.verifySellPageElements();
		sellPage.clickNewQuoteButton();
		sellPage.verifyCreateQuotePageElements();
		sellPage.selectContact(contactName);
        sellPage.verifyDisplayedDates();
		sellPage.selectProduct(trackedProductName);		
		sellPage.enterProductDetails(quantity, discount);
		sellPage.verifyTotalAmount();
		sellPage.clickSaveButton();
		sellPage.verifyCreateQuoteSuccessMessage();
		sellPage.verifyCreatedQuote();
		sellPage.clickThreeDots();
		sellPage.clickFullfillButton();
		sellPage.verifyFullfillYourQuotationWindowElements();
		sellPage.clickDirectButton();
		sellPage.verifyDirectFulfillmentOfQuotationWindowElements();
		sellPage.clickFullfillButton();
		sellPage.verifyFulfillmentStatus();
		sellPage.verifyCountOfInvoiceBefore();
		sellPage.openFirstQuote();
		sellPage.clickConvertToInvoiceButton();
		sellPage.verifyCountOfInvoiceAfter();	
	}
}
