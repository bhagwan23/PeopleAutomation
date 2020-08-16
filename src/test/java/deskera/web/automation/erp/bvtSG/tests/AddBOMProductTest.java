package deskera.web.automation.erp.bvtSG.tests;

import java.util.Random;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.bvtSG.pages.CreateProductPage;
import deskera.web.automation.erp.bvtSG.pages.HomePage;
import deskera.web.automation.erp.bvtSG.pages.LoginPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

public class AddBOMProductTest extends DriverFactory {
	String confPath, url;
	ReadPropertyUtil rProp = new ReadPropertyUtil();

	/**
	 * Get common details required for test
	 * 
	 * @param conf
	 * @param URL
	 */
	@BeforeClass
	@Parameters({ "confProducts", "environment" })
	public void getConf(String conf, String URL) {
		confPath = conf;
		url = URL;
	}
	@TestRailId(testRailId = 21022)
	@Test()
	@Description(value = "C21022 Create BOM Product ")
	public void addBOMProductTest() throws InterruptedException {
		// Read test specific data from config
		/*
		 * String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		 * String passWord = ReadPropertyUtil.readProperty("userPass", confPath);
		 */
		String BOMProductName = ReadPropertyUtil.readProperty("BOMProductName", confPath);	
		String description = ReadPropertyUtil.readProperty("description", confPath);	
		Random random = new Random();
		String barcode = String.format("%04d", random.nextInt(1000));
		String salesPrice = ReadPropertyUtil.readProperty("salesPrice", confPath);	
		String openingQuanity = ReadPropertyUtil.readProperty("openingQuanity", confPath);	
		String openingValuation = ReadPropertyUtil.readProperty("openingValuation", confPath);	
		String quantity1 = ReadPropertyUtil.readProperty("quantity1", confPath);	
		String trackedProductName = ReadPropertyUtil.readProperty("trackedProductName", confPath);	
		String defaultPurchaseAccount_Tracked = ReadPropertyUtil.readProperty("defaultPurchaseAccount_Tracked", confPath);	
		String defaultPurchaseTax = ReadPropertyUtil.readProperty("defaultPurchaseTax", confPath);
		String defaultSalesAccount = ReadPropertyUtil.readProperty("defaultSalesAccount", confPath);	
		String defaultSalesPrice = ReadPropertyUtil.readProperty("defaultSalesPrice", confPath);
		String defaultSalesTax = ReadPropertyUtil.readProperty("defaultSalesTax", confPath);
		String defaultUnitOfMeasurement = ReadPropertyUtil.readProperty("defaultUnitOfMeasurement", confPath);	
		String defaultCostOfGoodSoldAccount = ReadPropertyUtil.readProperty("defaultCostOfGoodSoldAccount", confPath);	
		String defaultManufacturingAccount = ReadPropertyUtil.readProperty("defaultManufacturingAccount", confPath);	
		String defaultStockAdjustmentAccount = ReadPropertyUtil.readProperty("defaultStockAdjustmentAccount", confPath);
		String defaultWarehouseCode = ReadPropertyUtil.readProperty("defaultWarehouseCode", confPath);
		
		// Create Page Object instance
		/* LoginPage loginPage = new LoginPage(driver, wait); */
		HomePage homePage=new HomePage(driver, wait);
		CreateProductPage createProductPage=new CreateProductPage(driver,wait);
		// Access Test methods
		/*
		 * loginPage.openURL(url); loginPage.verifyPageTitle();
		 * loginPage.verifyLoginPageElements();
		 * loginPage.enterEmailandPassword(emailAddress, passWord);
		 * loginPage.clickSignIn();
		 */
		homePage.clickProductsTab();
		createProductPage.clickNewProductButton();
		createProductPage.verifyPageTitle();
		createProductPage.verifyCreateNewProductPage();
		createProductPage.selectBOMProduct();
		createProductPage.enterProductDetails(BOMProductName,description,barcode);
		createProductPage.clickAccountingTab();
	    createProductPage.verifyPurchaseAccountDropdownValues();
		createProductPage.verifySalesAccountDropdownValues();
		createProductPage.verifyAccountingTabForBOMProduct(defaultPurchaseAccount_Tracked,defaultPurchaseTax, defaultSalesAccount, defaultSalesPrice,defaultSalesTax);
		createProductPage.enterAccountingInfoForBOMProduct(salesPrice);	
		createProductPage.clickInventoryTab();
		createProductPage.verifyInventoryTabForBOMProduct(defaultUnitOfMeasurement,defaultCostOfGoodSoldAccount, defaultManufacturingAccount, defaultStockAdjustmentAccount);
		createProductPage.selectInventoryAccount();
		createProductPage.enterOpeningBalanceDetails(openingQuanity, openingValuation);
		createProductPage.clickBillOfMaterialTab();
		createProductPage.verifyBillOfMaterialTab();
		createProductPage.enterBOMDetails(trackedProductName,quantity1);
		Thread.sleep(2000);
		createProductPage.clickSaveButton();
		createProductPage.verifyCreateProductSuccessMessage();
		createProductPage.verifyBomProductCount();
		createProductPage.verifyCreatedBOMProduct(BOMProductName, description,barcode,defaultPurchaseAccount_Tracked,defaultSalesAccount,salesPrice,defaultPurchaseTax,defaultSalesTax);
		createProductPage.verifyInventoryDetailsForCreatedBOMProduct(defaultUnitOfMeasurement, defaultCostOfGoodSoldAccount,defaultStockAdjustmentAccount, defaultWarehouseCode, openingQuanity, openingValuation);

 }
}
