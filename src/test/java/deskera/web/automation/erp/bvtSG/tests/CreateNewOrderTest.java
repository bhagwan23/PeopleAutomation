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

public class CreateNewOrderTest extends DriverFactory {
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
	public void getConf(String conf, String URL, String confProducts,String confContacts) {

		confPath = conf;
		url = URL;
		confProductsPath=confProducts;
		confContactsPath=confContacts;
	}


	@TestRailId(testRailId = 20270)
	@Test()
	@Description(value = "C21096 To verify that user is able to Create/Receive/Pay - Bill")
	public void createOrderTest() throws InterruptedException {
	
		String contactName = ReadPropertyUtil.readProperty("ContactName1", confContactsPath);
		String productName = ReadPropertyUtil.readProperty("trackedProductName", confProductsPath);

		String quantity = ReadPropertyUtil.readProperty("quantity", confPath);
		String discount = ReadPropertyUtil.readProperty("discount", confPath);
		
		
		// Create buy Page Object instance
		BuyPage buy= new BuyPage(driver, wait);
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
		//buy.clickSaveButton();
		
		buy.enterProductDetails(quantity, discount);
		buy.verifyTotalAmount();
		buy.clickSaveButton();
		buy.verifysuccessmessage();
		buy.verifyamountInGrid();
		buy.ordetTotalCount();
		
		
		//Receive goods for orders
		buy.searchCreatedRecord(contactName);
		buy.clickOnContact(contactName);
		buy.clickReceivedGoodsButton();
		buy.verifyReceivedGoodsElements();
		buy.clickReceiveButton();	
		buy.clickConvertToBillButton();
		/*buy.verifyConvertToBillPopupElements();
		buy.clickConvertAutoReceivedButton();
		//buy.verifyConvertBillsuccessmessage();*/
		
	}
}