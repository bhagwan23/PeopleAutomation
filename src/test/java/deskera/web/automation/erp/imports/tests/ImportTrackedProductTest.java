package deskera.web.automation.erp.imports.tests;

import java.awt.AWTException;
import java.util.Random;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.bvtSG.pages.CreateProductPage;
import deskera.web.automation.erp.bvtSG.pages.HomePage;
import deskera.web.automation.erp.imports.pages.TrackedProductImportPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

public class ImportTrackedProductTest extends DriverFactory {
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

	@TestRailId(testRailId = 249082)
	@Test()
	@Description(value = "Import tracked product using xlsx file")
	public void ImportxlsxfileoftrackedProduct() throws InterruptedException, AWTException {
		HomePage homePage = new HomePage(driver, wait);
		TrackedProductImportPage trackedProductImportPage = new TrackedProductImportPage(driver, wait);
		CreateProductPage createProductPage = new CreateProductPage(driver, wait);
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
		String defaultPurchaseTax = ReadPropertyUtil.readProperty("defaultPurchaseTax", confPath);
		String defaultSalesAccount = ReadPropertyUtil.readProperty("defaultSalesAccount", confPath);
		String defaultSalesTax = ReadPropertyUtil.readProperty("defaultSalesTax", confPath);
		String defaultUnitOfMeasurement = ReadPropertyUtil.readProperty("defaultUnitOfMeasurement", confPath);
		String defaultCostOfGoodSoldAccount = ReadPropertyUtil.readProperty("defaultCostOfGoodSoldAccount", confPath);
		String defaultInventoryAccount = ReadPropertyUtil.readProperty("defaultInventoryAccount", confPath);
		String defaultStockAdjustmentAccount = ReadPropertyUtil.readProperty("defaultStockAdjustmentAccount", confPath);
		String defaultWarehouseCode = ReadPropertyUtil.readProperty("defaultWarehouseCode", confPath);
		homePage.clickProductsTab();
		trackedProductImportPage.ClickOnNewProductButton();
		trackedProductImportPage.verifyPageTitle();
		trackedProductImportPage.SelectTrackedProductObjectToImpot();
		trackedProductImportPage.UploadImportProductFile("TrackedProductexcelformat.xlsx");
		trackedProductImportPage.MapheadersToImportProducts();
		trackedProductImportPage.ConfirmDataToImport();
		trackedProductImportPage.verifyProductImportSuccessMessage();
		createProductPage.verifyCreatedTrackedProduct(trackedProductName, description, barcode,
				defaultPurchaseAccount_Tracked, purchasePrice, defaultSalesAccount, salesPrice, defaultPurchaseTax,
				defaultSalesTax);
		createProductPage.verifyInventoryDetailsForCreatedTrackedProduct(defaultUnitOfMeasurement,
				defaultCostOfGoodSoldAccount, defaultInventoryAccount, defaultStockAdjustmentAccount,
				defaultWarehouseCode, openingQuanity, openingValuation);
	}

	@TestRailId(testRailId = 249082)
	@Test()
	@Description(value = "Import tracked product using csv file")
	public void ImportcsvfileoftrackedProduct() throws InterruptedException, AWTException {
		HomePage homePage = new HomePage(driver, wait);
		TrackedProductImportPage trackedProductImportPage = new TrackedProductImportPage(driver, wait);
		homePage.clickProductsTab();
		trackedProductImportPage.ClickOnNewProductButton();
		trackedProductImportPage.verifyPageTitle();
		trackedProductImportPage.SelectTrackedProductObjectToImpot();
		trackedProductImportPage.UploadImportProductFile("TrackedProductcsvformat.csv");
		trackedProductImportPage.MapheadersToImportProducts();
		trackedProductImportPage.ConfirmDataToImport();
		trackedProductImportPage.verifyProductImportSuccessMessage();
	}

	@TestRailId(testRailId = 249082)
	@Test()
	@Description(value = "Import tracked product using xlsx file")
	public void ImportxlsxfileofnontrackedProduct() throws InterruptedException, AWTException {
		HomePage homePage = new HomePage(driver, wait);
		TrackedProductImportPage trackedProductImportPage = new TrackedProductImportPage(driver, wait);
		homePage.clickProductsTab();
		trackedProductImportPage.ClickOnNewProductButton();
		trackedProductImportPage.verifyPageTitle();
		trackedProductImportPage.SelectTrackedProductObjectToImpot();
		trackedProductImportPage.UploadImportProductFile("NontrackedProductexcelformat.xlsx");
		trackedProductImportPage.MapheadersToImportProducts();
		trackedProductImportPage.ConfirmDataToImport();
		trackedProductImportPage.verifyProductImportSuccessMessage();
	}

	@TestRailId(testRailId = 249082)
	@Test()
	@Description(value = "Import tracked product using csv file")
	public void ImportcsvfileofnontrackedProduct() throws InterruptedException, AWTException {
		HomePage homePage = new HomePage(driver, wait);
		TrackedProductImportPage trackedProductImportPage = new TrackedProductImportPage(driver, wait);
		homePage.clickProductsTab();
		trackedProductImportPage.ClickOnNewProductButton();
		trackedProductImportPage.verifyPageTitle();
		trackedProductImportPage.SelectTrackedProductObjectToImpot();
		trackedProductImportPage.UploadImportProductFile("NontrackedProductcsvformat.csv");
		trackedProductImportPage.MapheadersToImportProducts();
		trackedProductImportPage.ConfirmDataToImport();
		trackedProductImportPage.verifyProductImportSuccessMessage();
	}
}
