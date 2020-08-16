package deskera.web.automation.erp.bvtSG.tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.SoftAssertListner;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.bvtSG.pages.GoDashboardPage;
import deskera.web.automation.erp.bvtSG.pages.LoginPage;
import deskera.web.automation.erp.bvtSG.pages.SignUpPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

//@Listeners({ TestListenerOnFailure.class })
public class SignUpTest extends DriverFactory {
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

	@TestRailId(testRailId = 16960)
	@Test()
	@Description(value = "C16960 To verify user should be able to sign up with Email and  Phone Number.")
	public void testSignUpPage() throws InterruptedException {
		// Writing dynamically created Email
		DateFormat df = new SimpleDateFormat("ddMMyyHHmmss");
		Date dateobj = new Date();
		ReadPropertyUtil.writeProperty("userEmail", confPath, "testauto_" + df.format(dateobj) + "@getnada.com");
		// Read test specific data from config
		String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		System.out.println("Signup Email Address ----->" + emailAddress);
		String phone = ReadPropertyUtil.readProperty("phone", confPath);
		String countryCode = ReadPropertyUtil.readProperty("countryCode", confPath);
		String accountName = ReadPropertyUtil.readProperty("userFirstName", confPath);
		String passWord = ReadPropertyUtil.readProperty("password", confPath);
		String company = ReadPropertyUtil.readProperty("company", confPath);
		// Create Page Object instance
		SignUpPage signUpPage = new SignUpPage(driver, wait);
		GoDashboardPage gDashboardPage = new GoDashboardPage(driver, wait);
		// Access Test methods
		signUpPage.openURL(url);
		signUpPage.verifyPageTitle();
		signUpPage.verifySignUpPageElements();
		signUpPage.enterEmailandPhone(emailAddress, countryCode, phone);
		signUpPage.clickCreateACcountButton();
		signUpPage.verifyAccountDetailsPageElements();
		signUpPage.enterAccountDetails(accountName, passWord, company);
		signUpPage.clickNextButton();
		signUpPage.verifyPersonalizeAccountPageElements();
		signUpPage.enterPersonalizeAccountDetails();
		signUpPage.clickNext();
		signUpPage.verifySuccessPageElements(emailAddress);
		signUpPage.clickResentEmailButton();
		signUpPage.verifyPageElementsAfterResentEmail(emailAddress);
		System.out.println("First Time Login Email Address ----->" + emailAddress);
		// Create Page Object instance
		LoginPage loginPage = new LoginPage(driver, wait);
		// Access Test methods and start trial first time
		loginPage.openURL(url);
		loginPage.verifyPageTitle();
		loginPage.verifyLoginPageElements();
		loginPage.enterEmailandPassword(emailAddress, passWord);
		loginPage.clickSignInFirstTime();
		gDashboardPage.clickStartBooksTrial();
	}

	@TestRailId(testRailId = 20565)
	@Test
	@Description(value = "C20565 To verify user should be able to sign up without Phone Number.")
	public void testSignUpWithoutPhoneNumber() throws InterruptedException {
		// Writing dynamically created Email
		DateFormat df = new SimpleDateFormat("ddMMyyHHmmss");
		Date dateobj = new Date();
		ReadPropertyUtil.writeProperty("userEmail", confPath, "testauto_" + df.format(dateobj) + "@getnada.com");
		// Read test specific data from config
		String accountName = ReadPropertyUtil.readProperty("userFirstName", confPath);
		String passWord = ReadPropertyUtil.readProperty("password", confPath);
		String company = ReadPropertyUtil.readProperty("company", confPath);
		String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		// Create Page Object instance
		SignUpPage signUpPage = new SignUpPage(driver, wait);
		GoDashboardPage gDashboardPage = new GoDashboardPage(driver, wait);
		// Access Test methods
		signUpPage.openURL(url);
		signUpPage.verifyPageTitle();
		signUpPage.verifySignUpPageElements();
		signUpPage.enterEmailId(emailAddress);
		signUpPage.clickCreateACcountButton();
		signUpPage.verifyAccountDetailsPageElements();
		signUpPage.enterAccountDetails(accountName, passWord, company);
		signUpPage.clickNextButton();
		signUpPage.verifyPersonalizeAccountPageElements();
		signUpPage.enterPersonalizeAccountDetails();
		signUpPage.clickNext();
		signUpPage.verifySuccessPageElements(emailAddress);
		signUpPage.clickResentEmailButton();
		signUpPage.verifyPageElementsAfterResentEmail(emailAddress);
		System.out.println("First Time Login Email Address ----->" + emailAddress);
		// Create Page Object instance
		LoginPage loginPage = new LoginPage(driver, wait);
		// Access Test methods
		// Access Test methods and start trial first time
		loginPage.openURL(url);
		loginPage.verifyPageTitle();
		loginPage.verifyLoginPageElements();
		loginPage.enterEmailandPassword(emailAddress, passWord);
		loginPage.clickSignInFirstTime();
		gDashboardPage.clickStartBooksTrial();
	}

	@TestRailId(testRailId = 20566)
	@Test()
	@Description(value = "C20566 To verify user should be able to sign up for Deskera Bookkeeper with Phone Number")
	public void testSignUpForDeskeraBookkeeper() throws InterruptedException {
		// Writing dynamically created Email
		DateFormat df = new SimpleDateFormat("ddMMyyHHmmss");
		Date dateobj = new Date();
		ReadPropertyUtil.writeProperty("userEmail", confPath, "testauto_" + df.format(dateobj) + "@getnada.com");
		// Read test specific data from config
		String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		String phone = ReadPropertyUtil.readProperty("phone", confPath);
		String countryCode = ReadPropertyUtil.readProperty("countryCode", confPath);
		String accountName = ReadPropertyUtil.readProperty("userFirstName", confPath);
		String passWord = ReadPropertyUtil.readProperty("password", confPath);
		String company = ReadPropertyUtil.readProperty("company", confPath);
		// Create Page Object instance
		SignUpPage signUpPage = new SignUpPage(driver, wait);
		// Access Test methods
		signUpPage.openURL(url);
		signUpPage.verifyPageTitle();
		signUpPage.verifySignUpPageElements();
		signUpPage.clickSignUpForBookkeeper();
		signUpPage.verifyBookkeeperSignUpPageElements();
		signUpPage.enterEmailandPhone(emailAddress, countryCode, phone);
		signUpPage.clickCreateACcountButton();
		signUpPage.verifyAccountDetailsPageElements();
		signUpPage.enterAccountDetails(accountName, passWord, company);
		signUpPage.clickNextButton();
		signUpPage.verifyPersonalizeAccountPageElements();
		signUpPage.enterPersonalizeAccountDetails();
		signUpPage.clickNext();
		signUpPage.verifySuccessPageElements(emailAddress);
		signUpPage.clickResentEmailButton();
		signUpPage.verifyPageElementsAfterResentEmail(emailAddress);
		// Access Test methods and start trial first time
		LoginPage loginPage = new LoginPage(driver, wait);
		loginPage.openURL(url);
		loginPage.verifyPageTitle();
		loginPage.verifyLoginPageElements();
		loginPage.enterEmailandPassword(emailAddress, passWord);
		loginPage.clickSignInFirstTime();
		GoDashboardPage gDashboardPage = new GoDashboardPage(driver, wait);
		gDashboardPage.clickStartBooksTrial();
	}
}