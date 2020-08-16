package deskera.web.automation.erp.imports.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import deskera.web.automation.core.SoftAssertListner;
import io.qameta.allure.Step;

public class TrackedProductImportPage {
	
	
	

	private WebDriver driver;
	
	private WebDriverWait wait;
	private SoftAssertListner sAssert;
   
	public TrackedProductImportPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
		sAssert = new SoftAssertListner(driver);
	}
	/*******************************
	 * Import New Product PAGE ELEMENTS LOCATORS
	 *******************/
	@FindBy(xpath = "//span[contains(.,'Products')]")
	private WebElement productsTab;
	private static String pageTitleText = "Deskera Books";
	@FindBy(xpath = "//span[contains(.,'Start by Adding or Importing Your Products')]")
	private List<WebElement> startByAddingOrImportingYourProducsText;
	@FindBy(xpath = "//i[contains(@class,'fa-times close-button m')]//self::i[1]")
	private WebElement closeIcon;
	@FindBy(css = "	i.fas.fa-times.close-button.mt-2")
	private WebElement closeOverlayPopup;
	@FindBy(xpath = "(//span[contains(text(),'Import Product')])[2]")
	private WebElement importProductButton;
	@FindBy(xpath = "//button[@class='import mat-icon-button mat-button-base']//*[local-name()='svg']")
	private WebElement ImportProductsbutton;
	@FindBy(xpath = "//span[contains(text(),'Import Products')]")
	private WebElement ImportProductsText;
	@FindBy(xpath = "//input[@id='trackedproducts']")
	private WebElement TrackedAndNonTrackedProductsSelection;
	@FindBy(xpath = "//input[@id='bomproducts']")
	private WebElement BomProductsSelection;
	@FindBy(xpath = "(//button[@class='mat-import-button pull-right mat-flat-button mat-button-base mat-primary'])[1]")
	private WebElement SelectObjectNextButton;
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'][contains(text(),'Cancel')])[1]")
	private WebElement SelectObjectCancelButton;
	
	/*******************************
	 * Upload import file of Tracked Product PAGE ELEMENTS LOCATORS
	 *******************/
	@FindBy(xpath = "//a[contains(text(),'browse')]")
	private WebElement browsebutton;
	@FindBy(xpath = "(//button[@class='mat-import-button pull-right mat-flat-button mat-button-base mat-primary'])[2]")
	private WebElement UploadDatatNextButton;
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'][contains(text(),'Cancel')])[2]")
	private WebElement UploadDatatCancelButton;
	
	/*******************************
	 *Mapping headers of Tracked Product PAGE ELEMENTS LOCATORS
	 *******************/
	@FindBy(xpath = "(//button[@class='mat-import-button pull-right mat-flat-button mat-button-base mat-primary'])[3]")
	private WebElement MappingDatatNextButton;
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'][contains(text(),'Back')])[1]")
	private WebElement MappingDatatBackButton;
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'][contains(text(),'Cancel')])[3]")
	private WebElement MappingDatatCancelButton;
	
	/*******************************
	 *Confirm Data of Tracked Product PAGE ELEMENTS LOCATORS
	 *******************/
	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	private WebElement ConfirmDataSubmitButton;
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'][contains(text(),'Back')])[2]")
	private WebElement ConfirmDatatBackButton;
	@FindBy(xpath = "(//span[@class='mat-button-wrapper'][contains(text(),'Cancel')])[4]")
	private WebElement ConfirmDatatCancelButton;
	@FindBy(xpath = "//span[contains(text(),'The file has been uploaded, Please check the ')]")
	private WebElement Confirmationmessage;
	
	
	
	/***********************************
	 * 
	 * Page objects manipulation methods
	 * 
	 *********************************/
	@Step("Verify Page Title")
	public void verifyPageTitle() {
		sAssert.assertEquals(driver.getTitle(), pageTitleText);
	}

	// Common util for webdriver wait
	@Step("Wait Element to be Visible")
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}

	@Step("Click on New Product Button")
	public void ClickOnNewProductButton() throws InterruptedException {
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Products')]")));
		// driver.findElement(By.xpath("//div[@id='container-1']/dt-navbar/div/ul/li[10]/a/span")).click();
		Thread.sleep(3000); // THis is important because popup gets loaded and
		// then disappears
		// driver.findElement(By.cssSelector("i.fas.fa-times.close-button.mt-2")).click();
		for (int second = 0; second <= 10; second++) {
			if (second == 10) {
				System.out.println("Popup Not found!");
				break;
			}
			try {
				if (closeOverlayPopup.isDisplayed()) {
					System.out.println("closig popup now 1");
					closeOverlayPopup.click(); // popup
					// close
					// button
					System.out.println("closed popup  1");
					break;
				}
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		ImportProductsbutton.click();
	}
	@Step("Scroll page")
	public void ScrollToElement(WebElement element)
	{

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
	}
	
	
	
	/*@Step("Scrolling a page")
	public void scrollingpagetoend(int amt) throws AWTException {
		
		Robot r=new Robot();
		r.mouseWheel(amt);
		}*/
	
	
	@Step("Select object to Import")
	public void SelectTrackedProductObjectToImpot() throws AWTException, InterruptedException {
		sAssert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(TrackedAndNonTrackedProductsSelection)) != null,"Verify object selection to import");
		TrackedAndNonTrackedProductsSelection.click();
		Thread.sleep(1000);
		ScrollToElement(SelectObjectNextButton);
		Thread.sleep(1000);
		sAssert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(SelectObjectNextButton)) != null,"wait for  Next button");
		SelectObjectNextButton.click();
	}
	
	@Step("Upload Import file of Product")
	public void UploadImportProductFile(String filename) throws InterruptedException, AWTException {
		// Supported onnly for windows local env
		
		  if (System.getProperty("os.name").toLowerCase().contains("windows") ||
		  System.getProperty("os.name").toLowerCase().contains("windows")) {
		 		WDWait(browsebutton);
			browsebutton.click();
			Robot rob = new Robot();
			StringSelection str = new StringSelection(System.getProperty("user.dir")+"\\testdata\\imports\\Product\\"+filename);
			//StringSelection filePath=new StringSelection("/home/seluser/Product/"+filename);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
			Thread.sleep(2000);
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_L);
			Thread.sleep(2000);
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_L);
			Thread.sleep(2000);
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_A);
			Thread.sleep(2000);
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_A);
			Thread.sleep(2000);
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_V);
			Thread.sleep(2000);
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_V);
			Thread.sleep(2000);
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			
			Thread.sleep(2000);
			ScrollToElement(UploadDatatNextButton);
			Thread.sleep(2000);
			
			sAssert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(UploadDatatNextButton)) != null,"wait for  Next button");
			UploadDatatNextButton.click();
		}
	}
	
	@Step("Mapping headers to import products")
	public void MapheadersToImportProducts() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		ScrollToElement(MappingDatatNextButton);
		Thread.sleep(2000);
		sAssert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(MappingDatatNextButton)) != null,"wait for  Next button");
		MappingDatatNextButton.click();
		
		}
	
	@Step("Confirm data to import")
	public void ConfirmDataToImport() throws InterruptedException, AWTException {
		Thread.sleep(3000);
		
		Thread.sleep(2000);
		ScrollToElement(ConfirmDataSubmitButton);
		Thread.sleep(2000);
		sAssert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(ConfirmDataSubmitButton)) != null,"wait for Submit button");
		ConfirmDataSubmitButton.click();
		
		}
	@Step("Verify import Product Success Message")
	public void verifyProductImportSuccessMessage() {
		WDWait(Confirmationmessage);
		Confirmationmessage.isDisplayed();
		sAssert.assertTrue(wait.until(ExpectedConditions.visibilityOf(Confirmationmessage)) != null);
		sAssert.assertAll();

	}
	
	
}
