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

public class EditProductTest extends DriverFactory {
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

	@TestRailId(testRailId = 20263)
	@Test()
	@Description(value = "Edit Product ")
	public void editProductTest() throws InterruptedException {
		// Read test specific data from config
		String nonTrackedProductName1 = ReadPropertyUtil.readProperty("nonTrackedProductName1", confPath);
		// String barcode = ReadPropertyUtil.readProperty("barcode", confPath);
		String description1 = ReadPropertyUtil.readProperty("description1", confPath);
		Random random = new Random();
		String barcode = String.format("%04d", random.nextInt(1000));
		String purchasePrice1 = ReadPropertyUtil.readProperty("purchasePrice1", confPath);
		String salesPrice1 = ReadPropertyUtil.readProperty("salesPrice1", confPath);
		String updatedPurchaseAccount = ReadPropertyUtil.readProperty("updatedPurchaseAccount", confPath);
		String defaultPurchaseTax = ReadPropertyUtil.readProperty("defaultPurchaseTax", confPath);
		String updatedSalesAccount = ReadPropertyUtil.readProperty("updatedSalesAccount", confPath);
		String defaultSalesTax = ReadPropertyUtil.readProperty("defaultSalesTax", confPath);
		String updatedUnitOfMeasurement = ReadPropertyUtil.readProperty("updatedUnitOfMeasurement", confPath);
		// Create Page Object instance
		LoginPage loginPage = new LoginPage(driver, wait);
		HomePage homePage = new HomePage(driver, wait);
		CreateProductPage createProductPage = new CreateProductPage(driver, wait);
		// Access Test methods
		homePage.clickProductsTab();
		createProductPage.clickThreeDotsOnNonTrackedProduct();
		createProductPage.clickEditButton();
		createProductPage.editGeneralInfo(nonTrackedProductName1, barcode, description1);
		createProductPage.clickAccountingTab();
		createProductPage.editAccountingDetails(purchasePrice1, salesPrice1);
		createProductPage.clickInventoryTab();
		createProductPage.editInventoryDetails(updatedUnitOfMeasurement);
		createProductPage.clickSaveChangesButton();
		createProductPage.verifyEditSuccessMessage();
		createProductPage.verifyEditedNonTrackedProduct(nonTrackedProductName1, description1, barcode,
				updatedPurchaseAccount, purchasePrice1, updatedSalesAccount, salesPrice1, defaultPurchaseTax,
				defaultSalesTax);
		createProductPage.verifyInventoryDetailsForCreatedNonTrackedProduct(updatedUnitOfMeasurement);
	}
}
