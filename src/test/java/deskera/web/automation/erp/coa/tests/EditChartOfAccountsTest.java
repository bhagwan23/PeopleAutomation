package deskera.web.automation.erp.coa.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.coa.pages.ChartOfAccountsPage;
import deskera.web.automation.erp.coa.pages.EditChartOfAccountsPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

public class EditChartOfAccountsTest extends DriverFactory {
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
	@Description(value = "To verify that user is able to edit accounts")
	public void editChartOfAccounts() throws InterruptedException {
		/*
		 * String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		 * String passWord = ReadPropertyUtil.readProperty("userPass", confPath);
		 */
		
		String cEdit= ReadPropertyUtil.readProperty("Name1", confPath);
		String name = ReadPropertyUtil.readProperty("UpdatedName", confPath);
		String code = ReadPropertyUtil.readProperty("UpdatedCode", confPath);
		String currency = ReadPropertyUtil.readProperty("UpdatedCurrency", confPath);
		String description = ReadPropertyUtil.readProperty("UpdatedDescription", confPath);
		// Create login Page Object instance
		/*
		 * LoginPage loginPage = new LoginPage(driver, wait); loginPage.openURL(url);
		 * loginPage.enterEmailandPassword(emailAddress, passWord);
		 * loginPage.clickSignIn();
		 */
		ChartOfAccountsPage coa = new ChartOfAccountsPage(driver, wait);
		
		// Create Page Object instance
		EditChartOfAccountsPage coaPage = new EditChartOfAccountsPage(driver, wait);
		// Go to COA grid
		coaPage.clickAccountingButton();
		coaPage.clickChartOfAccountsCard();
		// Search account to edit
		coaPage.searchRecord(cEdit);
		// click to context menu
		coaPage.clickContextMenuIcon();
		// Click on edit button
		coaPage.clickEditButton();
		// Edit account details
		coaPage.editAccountInfo(name, code, description, currency);
		coaPage.clickSaveChangeButton();
		// Save the edited details
		coaPage.verifyCOAeditedSucessMessage();
		// Verify account details 
		coa.verifyAddedAccount(name, code, description);
		
	}
}
