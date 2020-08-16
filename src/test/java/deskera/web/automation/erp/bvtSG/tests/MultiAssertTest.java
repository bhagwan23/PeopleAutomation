package deskera.web.automation.erp.bvtSG.tests;

import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import io.qameta.allure.Description;

public class MultiAssertTest extends DriverFactory{

/**
 * Verify multiple   custom soft assert failures
 * @throws InterruptedException
 */
	@TestRailId(testRailId = 1)
	@Test
	@Description(value = "Test multi assertFailure")
	public void multiAssertFailure() throws InterruptedException {
		/*
		 * System.out.println("Running Sample multiAssert------------------------->");
		 * // SoftAssert softAssertion= new SoftAssert();
		 * System.out.println("softAssert 1"); driver.get("http://www.google.com");
		 * Thread.sleep(3000); sAssert.assertTrue(false,"Should be true");
		 * System.out.println("softAssert 2"); driver.get("http://www.yahoo.com");
		 * Thread.sleep(3000); sAssert.assertEquals(1, 2, "Should be 1 =1 ");
		 * sAssert.assertAll();
		 */
	}
}
