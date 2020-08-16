package deskera.web.automation.erp.imports.tests;

import java.awt.AWTException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.imports.pages.Chartofaccountsimportpage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

public class ImportChartofAccountsTest extends DriverFactory {
	
	
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
	public void getConf(String conf,String URL) {
		confPath = conf;
		url = URL;
	}
	@TestRailId(testRailId = 249086)
	@Test()
	@Description(value = "Import Chart of Accounts using xlsx file")
	public void Importxlsxfileofcoa() throws InterruptedException, AWTException {
		String name = ReadPropertyUtil.readProperty("Name", confPath);
		String code = ReadPropertyUtil.readProperty("Code", confPath);
		String description = ReadPropertyUtil.readProperty("Description", confPath);
		
		Chartofaccountsimportpage Chartofaccountsimportpage=new Chartofaccountsimportpage(driver,wait);
		Chartofaccountsimportpage.ClickOnAccountingButton();
		Chartofaccountsimportpage.ClickOnCOAButton();
		Chartofaccountsimportpage.ClickOnImportAccountsButton();
		Chartofaccountsimportpage.UploadImportAccountsFile("Chartofaccountsexcelformat.xlsx");
		Chartofaccountsimportpage.MapheadersToImportAccounts();
		Chartofaccountsimportpage.ConfirmDataToImportAccounts();
		Chartofaccountsimportpage.verifyAccountsImportSuccessMessage();
		Chartofaccountsimportpage.ClickOnAccountingButton();
		Chartofaccountsimportpage.ClickOnCOAButton();
		Chartofaccountsimportpage.verifyAddedAccount(name, code, description);
		
	}
	
	@TestRailId(testRailId = 249086)
	@Test()
	@Description(value = "Import Chart of Accounts using csv file")
	public void Importcsvfileofcoa() throws InterruptedException, AWTException {
		String name = ReadPropertyUtil.readProperty("UpdatedName", confPath);
		String code = ReadPropertyUtil.readProperty("UpdatedCode", confPath);
		String description = ReadPropertyUtil.readProperty("UpdatedDescription", confPath);
		Chartofaccountsimportpage Chartofaccountsimportpage=new Chartofaccountsimportpage(driver,wait);
		Chartofaccountsimportpage.ClickOnAccountingButton();
		Chartofaccountsimportpage.ClickOnCOAButton();
		Chartofaccountsimportpage.ClickOnImportAccountsButton();
		Chartofaccountsimportpage.UploadImportAccountsFile("Chartofaccountscsvformat.csv");
		Chartofaccountsimportpage.MapheadersToImportAccounts();
		Chartofaccountsimportpage.ConfirmDataToImportAccounts();
		Chartofaccountsimportpage.verifyAccountsImportSuccessMessage();
		Chartofaccountsimportpage.ClickOnAccountingButton();
		Chartofaccountsimportpage.ClickOnCOAButton();
		Chartofaccountsimportpage.verifyAddedAccount(name, code, description);
	}

}
