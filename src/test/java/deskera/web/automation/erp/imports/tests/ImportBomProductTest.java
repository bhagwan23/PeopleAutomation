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
import deskera.web.automation.erp.imports.pages.BOMProductimportPage;

import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

public class ImportBomProductTest extends DriverFactory {
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
	@Description(value = "Import BOM product using xlsx file")
	public void ImportxlsxfileofBOMProduct() throws InterruptedException, AWTException {
		
		HomePage homePage=new HomePage(driver, wait);
		BOMProductimportPage BOMProductimportPage=new BOMProductimportPage(driver,wait);
		CreateProductPage createProductPage=new CreateProductPage(driver,wait);
		
		String BOMProductName = ReadPropertyUtil.readProperty("BOMProductName", confPath);	
		String description = ReadPropertyUtil.readProperty("description", confPath);	
		Random random = new Random();
		String barcode = String.format("%04d", random.nextInt(1000));
		String salesPrice = ReadPropertyUtil.readProperty("salesPrice", confPath);	
		String openingQuanity = ReadPropertyUtil.readProperty("openingQuanity", confPath);	
		String openingValuation = ReadPropertyUtil.readProperty("openingValuation", confPath);	
		String defaultPurchaseAccount_Tracked = ReadPropertyUtil.readProperty("defaultPurchaseAccount_Tracked", confPath);	
		String defaultPurchaseTax = ReadPropertyUtil.readProperty("defaultPurchaseTax", confPath);
		String defaultSalesAccount = ReadPropertyUtil.readProperty("defaultSalesAccount", confPath);	
		String defaultSalesTax = ReadPropertyUtil.readProperty("defaultSalesTax", confPath);
		String defaultUnitOfMeasurement = ReadPropertyUtil.readProperty("defaultUnitOfMeasurement", confPath);	
		String defaultCostOfGoodSoldAccount = ReadPropertyUtil.readProperty("defaultCostOfGoodSoldAccount", confPath);	
		String defaultStockAdjustmentAccount = ReadPropertyUtil.readProperty("defaultStockAdjustmentAccount", confPath);
		String defaultWarehouseCode = ReadPropertyUtil.readProperty("defaultWarehouseCode", confPath);

		homePage.clickProductsTab();
		
		BOMProductimportPage.clickNewProductButton();
		BOMProductimportPage.verifyPageTitle();
		BOMProductimportPage.selectTrackedProductobjecttoimpot();
		BOMProductimportPage.uploadImportproductfile("BOMProductexcelformat.xlsx");
		BOMProductimportPage.Mapheaderstoimportproducts();
		BOMProductimportPage.confirmdatatoimport();
		BOMProductimportPage.verifyProductimportSuccessMessage();
		createProductPage.verifyCreatedBOMProduct(BOMProductName, description,barcode,defaultPurchaseAccount_Tracked,defaultSalesAccount,salesPrice,defaultPurchaseTax,defaultSalesTax);
		createProductPage.verifyInventoryDetailsForCreatedBOMProduct(defaultUnitOfMeasurement, defaultCostOfGoodSoldAccount,defaultStockAdjustmentAccount, defaultWarehouseCode, openingQuanity, openingValuation);

		
		
	}
	
	@TestRailId(testRailId = 249082)
	@Test()
	@Description(value = "Import BOM product using csv file")
	public void ImportcsvfileofBOMProduct() throws InterruptedException, AWTException {
		
		HomePage homePage=new HomePage(driver, wait);
        BOMProductimportPage BOMProductimportPage=new BOMProductimportPage(driver,wait);
		
		homePage.clickProductsTab();
		
		BOMProductimportPage.clickNewProductButton();
		BOMProductimportPage.verifyPageTitle();
		BOMProductimportPage.selectTrackedProductobjecttoimpot();
		BOMProductimportPage.uploadImportproductfile("BOMProductcsvformat.csv");
		BOMProductimportPage.Mapheaderstoimportproducts();
		BOMProductimportPage.confirmdatatoimport();
		BOMProductimportPage.verifyProductimportSuccessMessage();
		
		
	}
	

}
