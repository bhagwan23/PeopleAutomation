package deskera.web.automation.erp.imports.tests;

import java.awt.AWTException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.imports.pages.ContactimportPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

public class ImportContactTest extends DriverFactory {
	
	String confPath, url;
	ReadPropertyUtil rProp = new ReadPropertyUtil();
    
	/**
	 * Get common details required for test
	 * 
	 * @param conf
	 * @param URL
	 */
	@BeforeClass
	@Parameters({"confContacts", "environment" })
	public void getConf(String conf, String URL) {
		confPath = conf;
		url = URL;
	}
	@TestRailId(testRailId = 249080)
	@Test()
	@Description(value = "Import contact using xlsx file")
	public void Importxlsxfileofcontactt() throws InterruptedException, AWTException {
		ContactimportPage ContactimportPage=new ContactimportPage(driver,wait);
		ContactimportPage.clickContactsButton();
		ContactimportPage.ClickOnImportContacttButton();
		ContactimportPage.verifyPageTitle();
		ContactimportPage.UploadImportContactFile("contactimportxlsxfile.xlsx");
		ContactimportPage.MapheadersToImportContacts();
		ContactimportPage.ConfirmDataToImportContact();
		ContactimportPage.verifyContactImportSuccessMessage();
	}	
	
	@TestRailId(testRailId = 249080)
	@Test()
	@Description(value = "Import contact using csv file")
	public void Importcsvfileofcontact() throws InterruptedException, AWTException {
		ContactimportPage ContactimportPage=new ContactimportPage(driver,wait);
		ContactimportPage.clickContactsButton();
		ContactimportPage.ClickOnImportContacttButton();
		ContactimportPage.verifyPageTitle();
		ContactimportPage.UploadImportContactFile("contactimportcsvfile.csv");
		ContactimportPage.MapheadersToImportContacts();
		ContactimportPage.ConfirmDataToImportContact();
		ContactimportPage.verifyContactImportSuccessMessage();
	}	
	
}
