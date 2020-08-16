package deskera.web.automation.erp.bvtSG.tests;
//@Listeners({ ScreenShotListener.class })

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.bvtSG.pages.BuyPage;
import deskera.web.automation.erp.bvtSG.pages.LoginPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

public class ArchiveOrderTest extends DriverFactory {
	String confPath, url,confProductsPath,confContactsPath;
	ReadPropertyUtil rProp = new ReadPropertyUtil();

	/**
	 * Get common details required for test
	 * 
	 * @param conf
	 * @param URL
	 */
	@BeforeClass
	@Parameters({ "confBuy", "environment","confProducts","confContacts" })
	public void getConf(String conf, String URL,String confProducts,String confContacts) {

		confPath = conf;
		url = URL;
		confProductsPath=confProducts;
		confContactsPath=confContacts;
	}

	@TestRailId(testRailId = 20299)
	@Test()
	@Description(value = "C20299 To verify user should be able to Archive/Reopen Order or Bill")
	public void archiveOrderTest() throws InterruptedException {
		
		String contactName = ReadPropertyUtil.readProperty("ContactName1", confContactsPath);
		String productName = ReadPropertyUtil.readProperty("trackedProductName", confProductsPath);

		String quantity = ReadPropertyUtil.readProperty("quantity", confPath);
		String discount = ReadPropertyUtil.readProperty("discount", confPath);

		

		// Create buy Page Object instance
		BuyPage buy = new BuyPage(driver, wait);
		buy.verifybuytabElements();
		buy.clickbuytab();
		buy.verifyBuyPageElement();
		buy.clickCreatNew();
		buy.clickOnNewOrder();
		buy.verifyCreateOrderElements();
		buy.addContact(contactName);
		buy.verifyMultiCurrencyOptions();
		buy.addProduct(productName);
		buy.verifydefaultQuantityAndTax();
		buy.enterProductDetails(quantity, discount);
		buy.verifyTotalAmount();
		buy.clickSaveButton();
		buy.verifysuccessmessage();
		buy.searchCreatedRecord(contactName);

		buy.clickOrderContextMenuIcon();
		buy.clickOnArchiveOrderButton();
		Thread.sleep(4000);
		buy.clickOnArchiveCard();
		//buy.searchCreatedOrder(contactName);	
		buy.archiveTotalCount();
		buy.verifyCancelledStatus();

		//Reopen order
		buy.clickOnContextMenuOnArchivePage();
		buy.clickOnReopen();
		//buy.noMatchingRecord();
	}
}