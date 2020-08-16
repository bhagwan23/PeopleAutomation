package deskera.web.automation.erp.bvtSG.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.bvtSG.pages.HomePage;
import deskera.web.automation.erp.bvtSG.pages.LoginPage;
import deskera.web.automation.erp.bvtSG.pages.UsersPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

public class AddRolesOfUserTest extends DriverFactory{

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

	@TestRailId(testRailId = 20278)
	@Test()
	@Description(value = "C20278 Add Roles Of User")
	public void addRolesOfUserTest() throws InterruptedException {
		// Read test specific data from config
		/*
		 * String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		 * String passWord = ReadPropertyUtil.readProperty("userPass", confPath);
		 */
		String firstName = ReadPropertyUtil.readProperty("firstName", confPath);
		String lastName = ReadPropertyUtil.readProperty("lastName", confPath);	
		String emailid = ReadPropertyUtil.readProperty("userEmail", confPath);
		String phoneNumber = ReadPropertyUtil.readProperty("phoneNumber", confPath);	
		// Create Page Object instance
		//LoginPage loginPage = new LoginPage(driver, wait);
		HomePage homePage=new HomePage(driver, wait);
		UsersPage usersPage=new UsersPage(driver,wait);
		// Access Test methods
		/*
		 * loginPage.openURL(url); loginPage.verifyPageTitle();
		 * loginPage.verifyLoginPageElements();
		 * loginPage.enterEmailandPassword(emailAddress, passWord);
		 * loginPage.clickSignIn();
		 */
		//	homePage.verifyPageTitle();
		/*
		 * homePage.clickSettingTab(); homePage.clickUsersTab();
		 * usersPage.verifyPageTitle(); usersPage.verifyUsersPageElements();
		 * usersPage.clickAddUserButton(); usersPage.verifyAddUserPageElements();
		 * usersPage.enterUserDetails(firstName, lastName, emailid, passWord,
		 * phoneNumber); usersPage.clickSaveButton();
		 */
	}
}
