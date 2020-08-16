package deskera.web.automation.erp.bvtSG.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.bvtSG.pages.HomePage;
import deskera.web.automation.erp.bvtSG.pages.LoginPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

public class AddDemoCompanyTest extends DriverFactory {
	String confPath, url;
	ReadPropertyUtil rProp = new ReadPropertyUtil();

	/**
	 * Get common details required for test
	 * 
	 * @param conf
	 * @param URL
	 */
	@BeforeClass
	@Parameters({ "environment" })
	public void getConf(String URL) {
		//confPath = conf;
		url = URL;
	}

	@TestRailId(testRailId = 16961)
	@Test()
	@Description(value = "Create Organization ")
	public void addDemoCompanyTest() throws InterruptedException {
		HomePage homePage = new HomePage(driver, wait);
		homePage.verifyPageTitle();
		homePage.clickGettingStartedButton();
		homePage.clickDemoCompany();
		homePage.verifyDemoCompanySuccessMessage();
	}
}
