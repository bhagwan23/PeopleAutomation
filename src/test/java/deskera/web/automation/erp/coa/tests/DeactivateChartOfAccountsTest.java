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

public class DeactivateChartOfAccountsTest extends DriverFactory {
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
	@Description(value = "To verify that user is able to deactivate accounts")
	public void deactivateChartOfAccounts() throws InterruptedException {
		/*
		 * String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		 * String passWord = ReadPropertyUtil.readProperty("userPass", confPath);
		 */
		
		String cEdit= ReadPropertyUtil.readProperty("Name2", confPath);
		
		ChartOfAccountsPage coa = new ChartOfAccountsPage(driver, wait);
		
		// Create Page Object instance
		EditChartOfAccountsPage coaPage = new EditChartOfAccountsPage(driver, wait);
		// Go to COA grid
		coaPage.clickAccountingButton();
		coaPage.clickChartOfAccountsCard();
		// Search account to deactivate
		coaPage.searchRecord(cEdit);
		// click to context menu
		coaPage.clickContextMenuIcon();
		// Click on deactivate button
		coaPage.clickDeactivateButton();
		// verify deactivated message
		coaPage.verifyCOAdeactivatedSucessMessage();
		
	}
}
