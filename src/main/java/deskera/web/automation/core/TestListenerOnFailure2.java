package deskera.web.automation.core;

import static java.util.Arrays.asList;

import java.io.ByteArrayInputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class TestListenerOnFailure2 implements ITestListener {
	DriverFactory dr = new DriverFactory();
	public String FailedTest;
	public String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new java.util.Date());

	public static String getCurrentTestName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
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
		System.out.println("Taking screenshot for failed test " + getCurrentTestName(result));
		// Object testClass = result.getInstance();
		System.out.println("Test Failed for Driver ------------------------------------>" + dr.getDriver());
		if (dr.getDriver() != null) {
			try {
				Allure.addAttachment(getCurrentTestName(result)+LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy_hh:mm:ss")),
						new ByteArrayInputStream(((TakesScreenshot) dr.getDriver()).getScreenshotAs(OutputType.BYTES)));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// Add failure log for screenshot
		saveTextLogs(getCurrentTestName(result) + " Failed Test Screenshot!");
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
		String trun = dr.getTRunId();
		// Clean up trace message
		String failureReason = result.getThrowable().toString().replace("\\", "\\\\").replace("\"", "\\\"")
				.replace("\n", "");
		// mark test case as failed with failure reason
		String testResult = "{\"status_id\":5,\"comment\":\"This test Failed during AUTOMATED TEST due to "
				+ failureReason.toString() + "\"}";
		TestRailUpdator resultupdate = new TestRailUpdator();
		resultupdate.UpdateTestCaseResult(testResult, TestID.toString(), "" + trun + "");
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
		String trun = dr.getTRunId();
		// mark test case as Passed
		String testResult = "{\"status_id\":1,\"comment\":\"This test case is Passed by AUTOMATED TEST\"}";
		TestRailUpdator resultupdate = new TestRailUpdator();
		resultupdate.UpdateTestCaseResult(testResult, TestID.toString(), "" + trun + "");
		
		System.out.println("Test Passed for Driver ------------------------------------>" + dr.getDriver());

	}

	@Override
	public void onTestStart(ITestResult result) {
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
