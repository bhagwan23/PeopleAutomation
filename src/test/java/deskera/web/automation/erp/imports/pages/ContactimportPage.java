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

public class ContactimportPage {
	
private WebDriver driver;
	
	private WebDriverWait wait;
	private SoftAssertListner sAssert;
   
	public ContactimportPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
		sAssert = new SoftAssertListner(driver);
	}
	/*******************************
	 * Import contact PAGE ELEMENTS LOCATORS
	 *******************/
    @FindBy(xpath = "//span[text()=' Contacts ']")
	private WebElement contactsButton;
	@FindBy(xpath= "(//span[contains(text(),'Import Contact')])[2]")
	private WebElement Importcontactbuttonpopup;
	@FindBy(xpath= "//button[@class='import mat-icon-button mat-button-base']//*[local-name()='svg']")
	private WebElement Importcontactsbutton;
    @FindBy(xpath= "//span[contains(.,'Start by Adding or Importing Your Contacts')]")
	private List<WebElement> startByAddingOrImportingYourContacts;
    private static String pageTitleText = "Deskera Books";
	@FindBy(css = "	i.fas.fa-times.close-button.mt-2")
	private WebElement closeOverlayPopup;
	
	/*******************************Upload Data PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath="//a[contains(text(),'browse')]")
	private WebElement browsebutton;
	@FindBy(xpath="(//span[contains(text(),' Next ')])[1]")
	private WebElement uploaddataNextButton;
	@FindBy(xpath="(//span[@class='mat-button-wrapper'][contains(text(),'Cancel')])[1]")
	private WebElement uploaddataCancelButton;
	@FindBy(xpath="//a[contains(text(),'Download sample file')]")
	private WebElement Downloadsamplefilelink;
	
	/*******************************Mapping Data PAGE ELEMENTS LOCATORS *******************/
	
	@FindBy(xpath="(//span[contains(text(),' Next ')])[2]")
	private WebElement MappingdataNextButton;
	@FindBy(xpath="(//span[@class='mat-button-wrapper'][contains(text(),'Cancel')])[2]")
	private WebElement MappingDataCancelButton;
	@FindBy(xpath="(//span[@class='mat-button-wrapper'][contains(text(),'Back')])[1]")
	private WebElement MappingDataBackButton;
	
	/*******************************confirm Data PAGE ELEMENTS LOCATORS *******************/
	
	@FindBy(xpath="//span[contains(text(),'Submit')]")
	private WebElement ConfirmDataSubmitButton;
	@FindBy(xpath="(//span[@class='mat-button-wrapper'][contains(text(),'Cancel')])[2]")
	private WebElement ConfirmdataCancelButton;
	@FindBy(xpath="(//span[@class='mat-button-wrapper'][contains(text(),'Back')])[1]")
	private WebElement ConfirmDataBackButton;
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
	@Step("Click on contact button")
	public void clickContactsButton() throws InterruptedException{
		WDWait(contactsButton);
		contactsButton.click(); 
	  //Thread.sleep(3000);
	}

	@Step("Click on Import contacts Button")
	public void ClickOnImportContacttButton() throws InterruptedException {
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
					System.out.println("closing popup now 1");
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
		Importcontactsbutton.click();
		
	}
	
	@Step("Scroll page")
	public void ScrollToElement(WebElement element)
	{

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
	}
	
	@Step("Upload Import file of Product")
	public void UploadImportContactFile(String filename) throws AWTException, InterruptedException  {
		// Supported onnly for windows local env
		
		  if (System.getProperty("os.name").toLowerCase().contains("windows") ||
		  System.getProperty("os.name").toLowerCase().contains("windows")) {
		 		Thread.sleep(3000);
			WDWait(browsebutton);
			browsebutton.click();
			Robot rob = new Robot();
			StringSelection str = new StringSelection(System.getProperty("user.dir")+"\\testdata\\imports\\Contact\\"+filename);
			//StringSelection filePath=new StringSelection("/home/seluser/Contact/"+filename);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
			Thread.sleep(2000);
			
			/*rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_L);
			Thread.sleep(2000);
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_L);
			Thread.sleep(2000);
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_A);
			Thread.sleep(2000);
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_A);*/
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
			ScrollToElement(uploaddataNextButton);
			Thread.sleep(2000);
			
			sAssert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(uploaddataNextButton)) != null,"wait for  Next button");
			uploaddataNextButton.click();
		}
	}
	
	@Step("Mapping headers to import contacts")
	public void MapheadersToImportContacts() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		ScrollToElement(MappingdataNextButton);
		Thread.sleep(2000);
		sAssert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(MappingdataNextButton)) != null,"wait for  Next button");
		MappingdataNextButton.click();
		
		}
	
	@Step("Confirm data to import")
	public void ConfirmDataToImportContact() throws InterruptedException, AWTException {
		Thread.sleep(3000);
		
		Thread.sleep(2000);
		ScrollToElement(ConfirmDataSubmitButton);
		Thread.sleep(2000);
		sAssert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(ConfirmDataSubmitButton)) != null,"wait for Submit button");
		ConfirmDataSubmitButton.click();
		
		}
	
	@Step("Verify Contacts import Success Message")
	public void verifyContactImportSuccessMessage() {
		WDWait(Confirmationmessage);
		Confirmationmessage.isDisplayed();
		sAssert.assertTrue(wait.until(ExpectedConditions.visibilityOf(Confirmationmessage)) != null);
		sAssert.assertAll();
	
	}
	
	
}
