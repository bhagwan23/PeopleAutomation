package deskera.web.automation.erp.bvtSG.tests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.bvtSG.pages.CreateBankPage;
import deskera.web.automation.erp.bvtSG.pages.LoginPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

//@Listeners({ ScreenShotListener.class })
public class CreateBankTest extends DriverFactory {

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

	@TestRailId(testRailId = 20274)
	@Test
	@Description(value = "C20274 To verify that user is able to Create/Connect - Bank")
	public void addCreateBankTestBank() throws InterruptedException{

		String bcode = ReadPropertyUtil.readProperty("bcode", confPath);
		String bname = ReadPropertyUtil.readProperty("bname", confPath);	
		String bDesc = ReadPropertyUtil.readProperty("bDesc", confPath);
		String bankUsername = ReadPropertyUtil.readProperty("bankUsername", confPath);	
		String bankPassword = ReadPropertyUtil.readProperty("bankPassword", confPath);
		// Create login Page Object instance
		CreateBankPage bank= new CreateBankPage(driver, wait);		
		bank.clickOnBanktab();
		bank.verifyDefaultBank();
		bank.clickAddButton();
		bank.verifyAccountDetailElements();
		bank.enterAccountDetails(bcode, bname, bDesc);
		bank.clickSaveAndConnectButton();
		bank.searchBank();
		bank.enterBankUsernamePassword(bankUsername, bankPassword);
		bank.selectAndConnectBankAccount();
		bank.clickConnectAccountButton();
		bank.verifyBankConnectSuccessMessage();		
	}
}
