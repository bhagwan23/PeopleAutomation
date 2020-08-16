package deskera.web.automation.erp.bvtSG.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.bvtSG.pages.ContactsPage;
import deskera.web.automation.erp.bvtSG.pages.LoginPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

public class CustomNumberFormatTest extends DriverFactory{
	String confPath, url;
	ReadPropertyUtil rProp = new ReadPropertyUtil();

	/**
	 * Get common details required for test
	 * 
	 * @param conf
	 * @param URL
	 */
	@BeforeClass
	@Parameters({ "confContacts", "environment" })
	public void getConf(String conf, String URL) {
		confPath = conf;
		url = URL;
	}

	@TestRailId(testRailId = 20261)
	@Test()
	@Description(value = "Create Custom Number Format")
	public void customNumberFormat() throws InterruptedException {
		/*String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		String passWord = ReadPropertyUtil.readProperty("userPass", confPath);	*/

		String name= ReadPropertyUtil.readProperty("ContactName", confPath);
		String contactMail  = ReadPropertyUtil.readProperty("contactMail", confPath);
		String UENNumber= ReadPropertyUtil.readProperty("UEN_Number", confPath);
		String TAXNumber= ReadPropertyUtil.readProperty("TAX_Number", confPath);
		String currency= ReadPropertyUtil.readProperty("currency", confPath);
		String paymentTerms= ReadPropertyUtil.readProperty("paymentTerms", confPath);


		String address= ReadPropertyUtil.readProperty("address", confPath);
		String state= ReadPropertyUtil.readProperty("state", confPath);
		String postal= ReadPropertyUtil.readProperty("postal", confPath);
		String city= ReadPropertyUtil.readProperty("city", confPath);
		String country= ReadPropertyUtil.readProperty("country", confPath);
		
	/*	// Create login Page Object instance
		LoginPage loginPage = new LoginPage(driver, wait);
		loginPage.openURL(url);
		loginPage.enterEmailandPassword(emailAddress, passWord);
		loginPage.clickSignIn();*/

		// Create Page Object instance
		ContactsPage contactsPage = new ContactsPage(driver, wait);

		// Access Test methods
		contactsPage.verifyPageTitle();
		contactsPage.verifyContactElements();
		contactsPage.clickContactsButton();
		
		contactsPage.clickAddContactButton();
		contactsPage.clickCustomNumberFormat();
		contactsPage.verifyCustomNumberFormatPageElements();
		contactsPage.enterCustomNumberFormatDetails();
		contactsPage.previewCustomNumberFormat();
		contactsPage.clickSaveCustomNumberFormatButton();
		contactsPage.verifyCustomNumberFormatInContactNumber();
		
		contactsPage.enterGeneralInfo(name, contactMail, UENNumber, TAXNumber);
		contactsPage.enterAccountingDetails();
		contactsPage.addressDetails();
		contactsPage.addAddressDetail(address, state, postal, city, country);
		contactsPage.clickSaveButton();
		contactsPage.verifyContactCreatedSucessMessage();
		contactsPage.verifyAddedContacts(name, UENNumber, TAXNumber,currency, paymentTerms);
		contactsPage.verifyCustomFormatNumber();
		
		

	}
}