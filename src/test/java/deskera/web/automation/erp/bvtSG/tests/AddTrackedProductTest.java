package deskera.web.automation.erp.bvtSG.tests;

import java.awt.AWTException;
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

public class AddTrackedProductTest extends DriverFactory {
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

	@TestRailId(testRailId = 20262)
	@Test()
	@Description(value = "Add Tracked Product")
	public void addTrackedProductTest() throws InterruptedException {
		// Read test specific data from config
		String trackedProductName = ReadPropertyUtil.readProperty("trackedProductName", confPath);
		String description = ReadPropertyUtil.readProperty("description", confPath);
		Random rand = new Random();
		String barcode = String.format("%04d", rand.nextInt(1000));
		String purchasePrice = ReadPropertyUtil.readProperty("purchasePrice", confPath);
		String salesPrice = ReadPropertyUtil.readProperty("salesPrice", confPath);
		String openingQuanity = ReadPropertyUtil.readProperty("openingQuanity", confPath);
		String openingValuation = ReadPropertyUtil.readProperty("openingValuation", confPath);
		String defaultPurchaseAccount_Tracked = ReadPropertyUtil.readProperty("defaultPurchaseAccount_Tracked",
				confPath);
		String defaultPurchasePrice = ReadPropertyUtil.readProperty("defaultPurchasePrice", confPath);
		String defaultPurchaseTax = ReadPropertyUtil.readProperty("defaultPurchaseTax", confPath);
		String defaultSalesAccount = ReadPropertyUtil.readProperty("defaultSalesAccount", confPath);
		String defaultSalesPrice = ReadPropertyUtil.readProperty("defaultSalesPrice", confPath);
		String defaultSalesTax = ReadPropertyUtil.readProperty("defaultSalesTax", confPath);
		String defaultUnitOfMeasurement = ReadPropertyUtil.readProperty("defaultUnitOfMeasurement", confPath);
		String defaultCostOfGoodSoldAccount = ReadPropertyUtil.readProperty("defaultCostOfGoodSoldAccount", confPath);
		String defaultInventoryAccount = ReadPropertyUtil.readProperty("defaultInventoryAccount", confPath);
		String defaultStockAdjustmentAccount = ReadPropertyUtil.readProperty("defaultStockAdjustmentAccount", confPath);
		String defaultWarehouseCode = ReadPropertyUtil.readProperty("defaultWarehouseCode", confPath);
		// Create Page Object instance
		// LoginPage loginPage = new LoginPage(driver, wait);
		HomePage homePage = new HomePage(driver, wait);
		CreateProductPage createProductPage = new CreateProductPage(driver, wait);
		// Access Test methods
		homePage.clickProductsTab();
		createProductPage.clickNewProductButton();
		createProductPage.verifyPageTitle();
		createProductPage.verifyCreateNewProductPage();
		createProductPage.selectTrackedProduct();
		try {
			createProductPage.uploadImageProduct();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		createProductPage.enterProductDetails(trackedProductName, description, barcode);
		createProductPage.clickAccountingTab();
		createProductPage.verifyPurchaseAccountDropdownValues();
		createProductPage.verifySalesAccountDropdownValues();
		createProductPage.verifyAccountingTab(defaultPurchaseAccount_Tracked, defaultPurchasePrice, defaultPurchaseTax,
				defaultSalesAccount, defaultSalesPrice, defaultSalesTax);
		createProductPage.enterAccountingInfo(purchasePrice, salesPrice);
		createProductPage.clickInventoryTab();
		createProductPage.verifyInventoryTabForTrackedProduct(defaultUnitOfMeasurement, defaultCostOfGoodSoldAccount,
				defaultInventoryAccount, defaultStockAdjustmentAccount);
		createProductPage.enterOpeningBalanceDetails(openingQuanity, openingValuation);
		createProductPage.clickSaveButton();
		createProductPage.verifyCreateProductSuccessMessage();
		createProductPage.verifyTrackedProductCount();
		createProductPage.verifyCreatedTrackedProduct(trackedProductName, description, barcode,
				defaultPurchaseAccount_Tracked, purchasePrice, defaultSalesAccount, salesPrice, defaultPurchaseTax,
				defaultSalesTax);
		createProductPage.verifyInventoryDetailsForCreatedTrackedProduct(defaultUnitOfMeasurement,
				defaultCostOfGoodSoldAccount, defaultInventoryAccount, defaultStockAdjustmentAccount,
				defaultWarehouseCode, openingQuanity, openingValuation);
	}
}
