package deskera.web.automation.core;

import static java.util.Arrays.asList;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TestListenerOnFailure extends DriverFactory implements ITestListener {
	public String FailedTest;
	public String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new java.util.Date());
	TestRailUpdator resultupdate = new TestRailUpdator();

	public static String getCurrentTestName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	/*
	 * @Attachment(value = "Page screenshot", type = "image/png") public byte[]
	 * saveScreenshotPNG(WebDriver sdriver) { return ((TakesScreenshot)
	 * sdriver).getScreenshotAs(OutputType.BYTES); }
	 */

	@Attachment(value = "Failed Page screenshot", type = "image/png")
	public byte[] saveScreenshot() {
		byte[] screenshot = null;
		screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		return screenshot;
	}

	@Attachment(value = " Text assertion Error ", type = "text/plain") // attach cause of failure to allure report
	public static String SaveTextLog(String message) {
		return message;
	}

	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLogs(String message) {
		return message;
	}

	// HTML attachments for Allure
	@Attachment(value = "{0}", type = "text/html")
	public static String attachHtml(String html) {
		return html;
	}

	@Override
	public void onTestFailure(ITestResult result) {
		FailedTest = getCurrentTestName(result);
		// take screenshot on failure
		System.out.println("Taking screenshot for failed test " + FailedTest);
		// byte[] screenShot = ((TakesScreenshot)
		// getDriver()).getScreenshotAs(OutputType.BYTES);
		// Allure.getLifecycle().addAttachment(result.getName()+LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy_hh:mm:ss")),
		// "image/png", "png", screenShot);
		saveTextLogs(FailedTest + " Failed Test Screenshot!");
		saveScreenshot();
		// Object testClass = result.getInstance();
		// System.out.println("Current Driver ----->" + getDriver());
		// if (dr.getDriver() != null) {
		// try {
		/*
		 * Allure.addAttachment(UUID.randomUUID().toString(), new
		 * ByteArrayInputStream(((TakesScreenshot)
		 * dr.getDriver()).getScreenshotAs(OutputType.BYTES)));
		 */ //
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// Add failure log for screenshot
		/*
		 * saveScreenshotPNG(getDriver());
		 * 
		 * 
		 * byte[] screenShot = ((TakesScreenshot)
		 * getDriver()).getScreenshotAs(OutputType.BYTES);
		 * Allure.getLifecycle().addAttachment(LocalDateTime.now().format(
		 * DateTimeFormatter.ofPattern("dd-MMM-yy_hh:mm:ss")), "image/png", "png",
		 * screenShot); saveTextLogs(FailedTest + " Failed Test Screenshot!");
		 */
		Integer TestID = null;
		IClass obj = result.getTestClass();
		Class<?> newobj = obj.getRealClass();
		Method testMethod = null;
		try {
			testMethod = newobj.getMethod(result.getName());
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (testMethod.isAnnotationPresent(TestRailId.class)) {
			TestRailId useAsTestName = testMethod.getAnnotation(TestRailId.class);
			// Get the TestCase ID for TestRail
			TestID = (useAsTestName.testRailId());
			// System.out.println("Test Rail ID = " + TestID);
		}
		String trun = getTRunId();
		// Clean up trace message
		String failureReason = result.getThrowable().toString().replace("\\", "\\\\").replace("\"", "\\\"")
				.replace("\n", "");
		// mark test case as failed with failure reason
		String testResult = "{\"status_id\":5,\"comment\":\"This test Failed during AUTOMATED TEST due to "
				+ failureReason.toString() + "\"}";
		System.out.println("Failure Reason---->" + result.getThrowable().toString());
		// resultupdate.UpdateTestCaseResult(testResult, TestID.toString(), "" + trun +
		// "");
	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Integer TestID = null;
		IClass obj = result.getTestClass();
		Class<?> newobj = obj.getRealClass();
		Method testMethod = null;
		try {
			testMethod = newobj.getMethod(result.getName());
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (testMethod.isAnnotationPresent(TestRailId.class)) {
			TestRailId useAsTestName = testMethod.getAnnotation(TestRailId.class);
			// Get the TestCase ID for TestRail
			TestID = (useAsTestName.testRailId());
			// System.out.println("Test Rail ID = " + TestID);
		}
		String trun = getTRunId();
		// mark test case as Passed
		String testResult = "{\"status_id\":1,\"comment\":\"This test case is Passed by AUTOMATED TEST\"}";
		// resultupdate.UpdateTestCaseResult(testResult, TestID.toString(), "" + trun +
		// "");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test ->" + result.getName() + " execution started");
	}

	public boolean shouldIntercept(Class<?> testClass, Class<?> annotation) {
		Listeners listenersAnnotation = getListenersAnnotation(testClass);
		return listenersAnnotation != null && asList(listenersAnnotation.value()).contains(annotation);
	}

	private Listeners getListenersAnnotation(Class<?> testClass) {
		Annotation annotation = testClass.getAnnotation(Listeners.class);
		return annotation != null ? (Listeners) annotation
				: testClass.getSuperclass() != null ? getListenersAnnotation(testClass.getSuperclass()) : null;
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
	}
}
