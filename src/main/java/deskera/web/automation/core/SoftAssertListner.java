package deskera.web.automation.core;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import org.testng.collections.Maps;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

/**
 * When an assertion fails, don't throw an exception but record the failure.
 * Calling {@code assertAll()} will cause an exception to be thrown if at least
 * one assertion failed.
 */
public class SoftAssertListner extends Assertion {
	String video_path = System.getProperty("user.dir") + "/video";
	public WebDriver driver;

	public SoftAssertListner(WebDriver dr) {
		this.driver = dr;
	}

	// LinkedHashMap to preserve the order-
	private final Map<AssertionError, IAssert<?>> m_errors = Maps.newLinkedHashMap();
	private String assertMessage = null;

	@Override
	protected void doAssert(IAssert<?> a) {
		onBeforeAssert(a);
		try {
			assertMessage = a.getMessage();
			a.doAssert();
			onAssertSuccess(a);
		} catch (AssertionError ex) {
			onAssertFailure(a, ex);
			m_errors.put(ex, a);
			saveScreenshot(assertMessage);
		} finally {
			onAfterAssert(a);
		}
	}

	public void assertAll() {
		if (!m_errors.isEmpty()) {
			StringBuilder sb = new StringBuilder("The following Assertions failed:");
			boolean first = true;
			for (Map.Entry<AssertionError, IAssert<?>> ae : m_errors.entrySet()) {
				if (first) {
					first = false;
				} else {
					sb.append(",");
				}
				sb.append("\n\t");
				sb.append(ae.getKey().getMessage());
			}
			throw new AssertionError(sb.toString());
		}
	}

	@Step("Validation fail: {assertMessage}")
	@Attachment(value = "Page screenshot", type = "image/png")
	public byte[] saveScreenshot(String assertMessage) {
		byte[] screenshot = null;
		screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		return screenshot;
	}

	@Attachment(value = "Faild Test video", type = "video/mp4")
	public byte[] video_attachment() {
		File fl = new File(video_path);
		File[] files = fl.listFiles(new FileFilter() {
			public boolean accept(File file) {
				return file.isFile();
			}
		});
		long lastMod = Long.MIN_VALUE;
		File choice = null;
		for (File file : files) {
			if (file.lastModified() > lastMod) {
				choice = file;
				lastMod = file.lastModified();
			}
		}
		try {
			return Files.readAllBytes(Paths.get(choice.getAbsolutePath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return new byte[0];
			// e.printStackTrace();
		}
	}
	
	
}