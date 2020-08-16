package deskera.web.automation.erp.bvtSG.tests;
//@Listeners({ ScreenShotListener.class })

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.bvtSG.pages.ContactsPage;
import deskera.web.automation.erp.bvtSG.pages.EditContactPage;
import deskera.web.automation.erp.bvtSG.pages.LoginPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

public class EditContactTest extends DriverFactory {
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
	@Description(value = "C20261 To verify that user is able to Edit contact")
	public void editContacts() throws InterruptedException {
		String cEdit = ReadPropertyUtil.readProperty("ContactName1", confPath);
		String name = ReadPropertyUtil.readProperty("UpdatedContactName", confPath);
		String UENNumber = ReadPropertyUtil.readProperty("UpdatedUEN_Number", confPath);
		String TAXNumber = ReadPropertyUtil.readProperty("UpdatedTAX_Number", confPath);
		String email = ReadPropertyUtil.readProperty("UpdatedcontactMail1", confPath);
		String currency = ReadPropertyUtil.readProperty("currency", confPath);
		String paymentTerms = ReadPropertyUtil.readProperty("paymentTerms", confPath);
		String address = ReadPropertyUtil.readProperty("Updatedaddress", confPath);
		String state = ReadPropertyUtil.readProperty("Updatedstate", confPath);
		String postal = ReadPropertyUtil.readProperty("Updatedpostal", confPath);
		String city = ReadPropertyUtil.readProperty("Updatedcity", confPath);
		String country = ReadPropertyUtil.readProperty("Updatedcountry", confPath);
		// Create Contact page object instance
		ContactsPage contactsPage = new ContactsPage(driver, wait);
		contactsPage.clickContactsButton();
		// Edit contact page object instance
		EditContactPage editcontact = new EditContactPage(driver, wait);
		editcontact.searchRecord(cEdit);
		editcontact.clickContextMenuIcon();
		editcontact.clickEditButton();
		editcontact.editGeneralInfo(name, email, UENNumber, TAXNumber);
		editcontact.editAddressInfo(address, state, postal, city, country);
		editcontact.clickSaveChangeButton();
		editcontact.verifysuccessmessage();
		// contactsPage.clickContactsButton();
		Thread.sleep(3000);
		editcontact.verifyEditedContact(name, UENNumber, TAXNumber, currency, paymentTerms);
		// contactsPage.verifyAddedContacts(name, UENNumber, TAXNumber,currency,
		// paymentTerms);
	}
}