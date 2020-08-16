package deskera.web.automation.erp.coa.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.coa.pages.ChartOfAccountsPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

public class ChartOfAccountsTest extends DriverFactory {
	String confPath, url;
	ReadPropertyUtil rProp = new ReadPropertyUtil();

	/**
	 * Get common details required for test
	 * 
	 * @param conf
	 * @param URL
	 */
	@BeforeClass
	@Parameters({ "conf", "environment" })
	public void getConf(String conf, String URL) {
		confPath = conf;
		url = URL;
	}

	@TestRailId(testRailId = 20211)
	@Test
	@Description(value = "To verify that user is able to Add accounts")
	public void addChartOfAccounts() throws InterruptedException {
		/*
		 * String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		 * String passWord = ReadPropertyUtil.readProperty("userPass", confPath);
		 */
		String name = ReadPropertyUtil.readProperty("Name", confPath);
		String type = ReadPropertyUtil.readProperty("Type", confPath);
		String code = ReadPropertyUtil.readProperty("Code", confPath);
		String description = ReadPropertyUtil.readProperty("Description", confPath);
		// Create login Page Object instance
		/*
		 * LoginPage loginPage = new LoginPage(driver, wait); loginPage.openURL(url);
		 * loginPage.enterEmailandPassword(emailAddress, passWord);
		 * loginPage.clickSignIn();
		 */
		// Create Page Object instance
		ChartOfAccountsPage coaPage = new ChartOfAccountsPage(driver, wait);
		// Go to COA grid
		coaPage.clickAccountingButton();
		coaPage.clickChartOfAccountsCard();
		// Check whether the all UI elements are displayed.
		coaPage.verifyCOAPageElements();
		// Click to add COA
		coaPage.clickAddCOAbutton();
		// ENter account details
		coaPage.enterAccountDetails(name, code, type, description);
		// Click to save the COA details
		coaPage.clickSaveButton();
		// Check COA is created or not.
		coaPage.verifyCOACreatedSucessMessage();
		// Go to the grid
		coaPage.clickAccountingButton();
		coaPage.clickChartOfAccountsCard();
		// Verify added account details.
		coaPage.verifyAddedAccount(name, code, description);
	}

}
