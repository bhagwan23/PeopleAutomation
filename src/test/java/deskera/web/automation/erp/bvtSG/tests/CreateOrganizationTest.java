package deskera.web.automation.erp.bvtSG.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.bvtSG.pages.HomePage;
import deskera.web.automation.erp.bvtSG.pages.LoginPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

public class CreateOrganizationTest extends DriverFactory{
	String confPath, url;
	ReadPropertyUtil rProp = new ReadPropertyUtil();

	/**
	 * Get common details required for test
	 * 
	 * @param conf
	 * @param URL
	 */
	@BeforeClass
	@Parameters({ "confCommon", "environment" })
	public void getConf(String conf, String URL) {
		confPath = conf;
		url = URL;
	}
	
	@TestRailId(testRailId = 16961)
	@Test()
	@Description(value = "Create Organization ")
	public void createOrganizationTest() throws InterruptedException {
		// Read test specific data from config
		/*
		 * String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		 * String passWord = ReadPropertyUtil.readProperty("userPass", confPath);
		 */
		String taxResidency = ReadPropertyUtil.readProperty("taxResidency", confPath);	
		String financialStartDate = ReadPropertyUtil.readProperty("financialStartDate", confPath);	
		String bookBeginningDate = ReadPropertyUtil.readProperty("bookBeginningDate", confPath);	
		String addressLine1 = ReadPropertyUtil.readProperty("addressLine1", confPath);	
		String addressLine2 = ReadPropertyUtil.readProperty("addressLine2", confPath);	
		String city = ReadPropertyUtil.readProperty("city", confPath);	
		String state = ReadPropertyUtil.readProperty("state", confPath);
		String zipcode = ReadPropertyUtil.readProperty("zipcode", confPath);
		// Create Page Object instance
		//LoginPage loginPage = new LoginPage(driver, wait);
		HomePage homePage=new HomePage(driver, wait);
		
		// Access Test methods
		/*
		 * loginPage.openURL(url); loginPage.verifyPageTitle();
		 * loginPage.verifyLoginPageElements();
		 * loginPage.enterEmailandPassword(emailAddress, passWord);
		 * loginPage.clickSignIn();
		 */
		
		//homePage.verifyPageTitle();
		homePage.verifyorgElements();
		homePage.enterOrgDetails(taxResidency, financialStartDate, bookBeginningDate, addressLine1, addressLine2, city, state, zipcode);
		homePage.clickSaveButton();
		homePage.verifyCreateOrgSuccessMessage();
		homePage.clickSkipButton();
		
	}

}
