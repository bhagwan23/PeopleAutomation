package deskera.web.automation.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import deskera.web.automation.utils.ReadPropertyUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Amol Tambe
 *
 */
public class DriverFactory {
	protected static RemoteWebDriver driver;
	protected static WebDriverWait wait;
	protected static String tRuId;
	ReadPropertyUtil rProp = new ReadPropertyUtil();
	//protected SoftAssertListner sAssert;
	public static WebDriverWait getWait() {
		return wait;
	}

	protected Capabilities capabilities;
	ChromeOptions coptions = new ChromeOptions();

	@BeforeTest
	@Parameters({ "browser", "testRunId", "envConf" })
	public void setup(String browser, String testRunId, String confPath) throws MalformedURLException {
		String execMode = ReadPropertyUtil.readProperty("execMode", confPath);
		String RemoteWebDriverURL = ReadPropertyUtil.readProperty("RemoteWebDriverURL", confPath);
		switch (browser.toLowerCase()) {
		case "firefox":
			FirefoxOptions foptions = new FirefoxOptions();
			FirefoxProfile profile = new FirefoxProfile();
			// Accept Untrusted Certificates
			profile.setAcceptUntrustedCertificates(true);
			profile.setAssumeUntrustedCertificateIssuer(false);
			// Use No Proxy Settings
			// profile.setPreference("network.proxy.type", 0);
			// Set Firefox profile to capabilities
			foptions.setCapability(FirefoxDriver.PROFILE, profile);
			capabilities = foptions;
			// driver = new RemoteWebDriver(new URL(RemoteWebDriverURL), capabilities);
			break;
		case "chrome":
			coptions.addArguments("--start-maximized");
			coptions.addArguments("--ignore-certificate-errors");
			coptions.addArguments("--disable-popup-blocking");
			coptions.addArguments("--incognito");
			coptions.setExperimentalOption("useAutomationExtension", false);
			coptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			capabilities = coptions;
			break;
		case "edge":
			break;
		default:
			break;
		}
		// Local mode will run the scripts on local machine
		if (execMode.equalsIgnoreCase("local")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(coptions);
		}
		// Local mode will run the scripts on Remote Selenium hub
		else if (execMode.equalsIgnoreCase("container")) {
			driver = new RemoteWebDriver(new URL(RemoteWebDriverURL), capabilities);
		}
		System.out.println(driver);
		wait = (new WebDriverWait(getDriver(), Duration.ofSeconds(120)));
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		setTRunId(testRunId);
		//sAssert = new SoftAssertListner();
	}

	public String getTRunId() {
		return tRuId;
	}

	public void setTRunId(String tRuId) {
		DriverFactory.tRuId = tRuId;
	}

	public WebDriver getDriver() {
		return driver;
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
