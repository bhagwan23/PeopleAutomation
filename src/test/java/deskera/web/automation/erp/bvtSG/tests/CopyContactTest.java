package deskera.web.automation.erp.bvtSG.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.bvtSG.pages.ContactsPage;
import deskera.web.automation.erp.bvtSG.pages.CopyContactPage;
import deskera.web.automation.erp.bvtSG.pages.EditContactPage;
import deskera.web.automation.erp.bvtSG.pages.LoginPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

//@Listeners({ ScreenShotListener.class })
public class CopyContactTest extends DriverFactory {
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
	@Test
	@Description(value = "C20261 To verify that user is able to Copy contact")

	public void copyContacts() throws InterruptedException{
		/*
		 * String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		 * String passWord = ReadPropertyUtil.readProperty("userPass", confPath);
		 */
		
		String name= ReadPropertyUtil.readProperty("CopiedContactName", confPath);
		String UENNumber= ReadPropertyUtil.readProperty("UpdatedUEN_Number", confPath);
		String TAXNumber= ReadPropertyUtil.readProperty("UpdatedTAX_Number", confPath);
		String currency= ReadPropertyUtil.readProperty("currency", confPath);
		String paymentTerms= ReadPropertyUtil.readProperty("paymentTerms", confPath);


		// Create login Page Object instance
		/*
		 * LoginPage loginPage = new LoginPage(driver, wait); loginPage.openURL(url);
		 * loginPage.enterEmailandPassword(emailAddress, passWord);
		 * loginPage.clickSignIn();
		 */
		//Create Contact page object instance
		ContactsPage contactsPage = new ContactsPage(driver, wait);
		contactsPage.clickContactsButton();

		EditContactPage editcontact= new EditContactPage(driver, wait);
		
		//Edit contact page object instance
		CopyContactPage copycontact= new CopyContactPage(driver, wait);
		copycontact.clickContextMenuIcon();
		copycontact.clickCopyButton();
		copycontact.changeName(name);
		copycontact.clickSaveButton();
		copycontact.verifysuccessmessage();
		copycontact.verifyCopiedContact(name, UENNumber, TAXNumber, currency, paymentTerms);
	}
}
