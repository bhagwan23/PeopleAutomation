package deskera.web.automation.erp.bvtSG.pages;

import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import deskera.web.automation.core.SoftAssertListner;
import io.qameta.allure.Step;

public class DeleteContactPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;
	private SoftAssertListner sAssert;


	public DeleteContactPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
		sAssert = new SoftAssertListner(driver);

	}

	/******************************* DELETE CONTACTS PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath= "//mat-row[1]//mat-cell[8]//button[1]//mat-icon[1]")
	
	private WebElement contextMenuIcon;
	@FindBy(xpath= "//button[@class='mat-menu-item ng-star-inserted'][contains(text(),'Delete')]")
	
	private WebElement deleteButton;
	@FindBy(xpath="//span[text()='Contact Deleted']")
	
	private WebElement deleteSucessMessage;
	@FindBy(xpath= "//input[@placeholder='Search Records']")
	
	private WebElement searchRecord;
	@FindBy(xpath= "//div[@class='no-records ng-star-inserted']")
	
	private WebElement thereIsNoMatchingRecords;
	@FindBy(xpath= "//*[@id='container-3']/extn-content/ng-contact-list/div/div/div[2]/div[2]/div[1]/span[2]")
	
	private WebElement allSummaryCount;
	
	
	/******************************* Contacts Delete Object Manipulation Methods *******************/
	@Step("Open URL")
	public void openURL(String URL) {
		driver.get(URL);
	}
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	
	@Step("Click on Context menu icon")
	public void clickContextMenuIcon() throws InterruptedException{
		WDWait(contextMenuIcon);
		sAssert.assertTrue(contextMenuIcon.isDisplayed());
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(contextMenuIcon));
        contextMenuIcon.click();
		
		WDWait(deleteButton);
		sAssert.assertTrue(deleteButton.isDisplayed(), "Verify delete button");
		deleteButton.click();
		sAssert.assertAll();

	}
	@Step("Verify success message")
	public void verifySuccessMessageForDelete(){
		WDWait(deleteSucessMessage);
		sAssert.assertTrue(deleteSucessMessage.isDisplayed(), "Verify contact delete success message");
        wait.until(ExpectedConditions.visibilityOf(deleteSucessMessage));
		sAssert.assertAll();

	}
	@Step("Search contact before/after delete contact")
	public void searchRecord(String cName) throws InterruptedException{
		WDWait(searchRecord);
		searchRecord.click();
		searchRecord.clear();
		searchRecord.sendKeys(cName);
		Thread.sleep(3000);
		/*Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();*/
		sAssert.assertAll();

	}
	@Step("Verify deleted contacts")
	public void verifyDeletedContact(String cName) throws InterruptedException{
		//Thread.sleep(2000);
		//WDWait(thereIsNoMatchingRecords);
		//sAssert.assertTrue(thereIsNoMatchingRecords.isDisplayed(), "No matching record message");
		//sAssert.assertAll();
		 if (driver.getPageSource().contains(cName)) {
	            System.out.println("Contact not deleted");
	            Assert.fail();
	        } else {
	            System.out.println(cName+"Contact Deleted successfully");
	        }

	}
	@Step("Verify summary count after deletion of contact")
	public void verifysummarycount(){
		WDWait(allSummaryCount);
		sAssert.assertTrue(allSummaryCount.isDisplayed(), "Verify total summary count");
		sAssert.assertEquals(allSummaryCount.getText(), "0");
		sAssert.assertAll();
	}
}
