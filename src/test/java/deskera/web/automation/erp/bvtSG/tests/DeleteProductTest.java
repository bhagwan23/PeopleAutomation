package deskera.web.automation.erp.bvtSG.tests;

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

public class DeleteProductTest extends DriverFactory {
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
	@Description(value = "Delete Product ")
	public void deleteProductTest() throws InterruptedException {
		// Read test specific data from config
		String BOMProductName = ReadPropertyUtil.readProperty("BOMProductName", confPath);
		// Create Page Object instance
		HomePage homePage = new HomePage(driver, wait);
		CreateProductPage createProductPage = new CreateProductPage(driver, wait);
		homePage.clickProductsTab();
		createProductPage.clickThreeDotsOnBOMProduct();
		createProductPage.clickDeleteButton();
		createProductPage.verifyDeleteConfirmation();
		createProductPage.clickYesButtonOnDeleteConfirmation();
		createProductPage.verifyDeleteProductSuccessMessage();
		createProductPage.verifyBOMProductCountAfterDelete();
		createProductPage.verifyDeletedProduct(BOMProductName);
	}
}
