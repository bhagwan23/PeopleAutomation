package deskera.web.automation.erp.bvtSG.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import deskera.web.automation.core.SoftAssertListner;
import io.qameta.allure.Step;

public class HomePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private SoftAssertListner sAssert;

	
	public HomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
		sAssert = new SoftAssertListner(driver);

	}
	
	/******************************* Create Org  PAGE ELEMENTS LOCATORS *******************/

	@FindBy(xpath = "//button[contains(.,'Getting Started')]")
	
	private WebElement gettingStartedButton;
	@FindBy(xpath = "//button[contains(text(),'Demo Company')]")
	
	private WebElement demoCompanyButton;
	@FindBy(xpath = "//span[text()='Switched to Demo Organization']")
	
	private WebElement switchedToDemoCompanySuccessMessage;
	@FindBy(xpath = "//span[text()='Demo Company(SG)']")
	
	private WebElement demoCompanyName;
	@FindBy(xpath = "//input[contains(@formcontrolname,'countryLookupCode')]")
	
	private WebElement taxResidency;
	@FindBy(xpath = "//span[contains(.,'Singapore')]")
	
	private WebElement singaporeTaxResidency;
	@FindBy(xpath = "//input[@formcontrolname='financialStartDate']")
	
	private WebElement financialStartDate;
	@FindBy(xpath = "//input[@formcontrolname='bookBeginningStartDate']")
	
	private WebElement bookBeginningDate;
	@FindBy(xpath = "//input[contains(@formcontrolname,'address1')]")
	
	private WebElement addressLine1;
	@FindBy(xpath = "//input[@formcontrolname='address2']")
	
	private WebElement addressLine2;
	@FindBy(xpath = "//input[@formcontrolname='city']")
	
	private WebElement city;
	@FindBy(xpath = "//input[@formcontrolname='state']")
	
	private WebElement state;
	@FindBy(xpath = "//input[@placeholder='Zip Code']")
	
	private WebElement zipcode;
	@FindBy(xpath = "//input[@formcontrolname='gstNo']")
	
	private WebElement gstNo;
	@FindBy(xpath = "//input[@formcontrolname='uenNo']")
	
	private WebElement uenNo;
	@FindBy(xpath = "//button[contains(.,'Save')]")
	
	private WebElement saveButton;
	@FindBy(xpath = "//span[contains(text(),'Organization Added Successfully')]")
	
	private WebElement OrgCreationSuccessMessage;	
	@FindBy(xpath = "(//button[contains(.,'Skip')])[2]")
	
	private WebElement skipButton;	
	private static String pageTitleText = "Deskera Books";
	
	
	/******************************* HOMEPAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "//span[@class='ng-star-inserted'][contains(.,'Sell')]")
	
	private WebElement sellTab;
	
	@FindBy(xpath = "//span[contains(.,'Products')]")
	
	private WebElement productsTab;
	@FindBy(xpath = "//span[contains(text(),'Settings')]")
	
	private WebElement settingTab;
	@FindBy(xpath = "//span[contains(.,'Users')]")
	
	private WebElement usersTab;
	
	

	/***********************************
	 * 
	 * Page objects manipulation methods
	 * 
	 *********************************/
	@Step("Verify Home Page Title")
	public void verifyPageTitle() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), pageTitleText);
	}

	// Common util for webdriver wait
	@Step("Wait Element to be Visible")
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	
	@Step("Verify Org Creation Page Elements")
	public void verifyorgElements() {
		WDWait(taxResidency);
		taxResidency.isDisplayed();
		WDWait(financialStartDate);
		financialStartDate.isDisplayed();
		bookBeginningDate.isDisplayed();
		addressLine1.isDisplayed();
		addressLine2.isDisplayed();
		gstNo.isDisplayed();
		saveButton.isDisplayed();
	}
	
	@Step("Enter Organization Details")
	public void enterOrgDetails(String taxresidency,String fstartdate,String bookbeginningdate,String addline1,String addline2,String City,String State,String Zipcode){
		taxResidency.click();
		taxResidency.clear();
		taxResidency.sendKeys(taxresidency);
		singaporeTaxResidency.click();
		financialStartDate.clear();
		financialStartDate.sendKeys(fstartdate);
		bookBeginningDate.clear();
		bookBeginningDate.sendKeys(bookbeginningdate);
		addressLine1.click();
		addressLine1.sendKeys(addline1);
		addressLine2.click();
		addressLine2.sendKeys(addline2);
		city.sendKeys(City);
		state.sendKeys(State);
		zipcode.sendKeys(Zipcode);
		gstNo.sendKeys("859558565856855");
		uenNo.sendKeys("5895685");
	}
	
	@Step("Click On Save Button")
	public void clickSaveButton(){
		saveButton.click();
	}
	
	@Step("Verify Create Org Success Message")
	public void verifyCreateOrgSuccessMessage(){
		WDWait(OrgCreationSuccessMessage);
		OrgCreationSuccessMessage.isDisplayed();
		sAssert.assertTrue(wait.until(ExpectedConditions.visibilityOf(OrgCreationSuccessMessage)) != null);
	}
	
	@Step("Click On Skip Button")
	public void clickSkipButton(){
		WDWait(skipButton);
		skipButton.click();
	}
	
	@Step("Click On Products Tab")
	public void clickProductsTab(){
		WDWait(productsTab);
		productsTab.click();
	}
	
	
	
	@Step("Click On Getting Started Button")
	public void clickGettingStartedButton(){
		WDWait(gettingStartedButton);
		gettingStartedButton.click();
	}
	
	@Step("Click On Demo Company Button ")
	public void clickDemoCompany(){
		WDWait(demoCompanyButton);
		demoCompanyButton.click();
	}
	
	@Step("Verify Create Demo Company Success Message")
	public void verifyDemoCompanySuccessMessage(){
		WDWait(switchedToDemoCompanySuccessMessage);
		switchedToDemoCompanySuccessMessage.click();
		WDWait(demoCompanyName);
		demoCompanyName.isDisplayed();
	}
	
	@Step("Click On Setting Tab")
	public void clickSettingTab() throws InterruptedException{
		Thread.sleep(8000);
		//WDWait(settingTab); 
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].scrollIntoView();", settingTab);
		 * settingTab.click();
		 */
		
	    //WDWait(settingTab);
	    wait.until(ExpectedConditions.elementToBeClickable(settingTab));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", settingTab);
		
		
		/*
		  Actions action = new Actions(driver);
	        WebElement settings = driver.findElement(By.xpath("//span[contains(.,'Settings')]"));
	        action.moveToElement(settings).perform();*/
		
		/*Actions builder = new Actions(driver);
        Action mouseOverSettings = builder
                .moveToElement(settingTab)
                .build();
        System.out.println("Before hover: ");
        mouseOverSettings.perform(); 
        System.out.println("First Hover done");
		//Actions action=new Actions(driver);
		//action.moveToElement(settingTab).click().perform();
		//settingTab.click();
*/        
        
       

      
      
	}
	
	@Step("Click On User Tab")
	public void clickUsersTab(){
		WDWait(usersTab);
		usersTab.click();
	}
	
	@Step("Click On Sell Tab")
	public void clickSellTab() throws InterruptedException{
		WDWait(sellTab);
        sellTab.click();
        
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Products')]")));
		// driver.findElement(By.xpath("//div[@id='container-1']/dt-navbar/div/ul/li[10]/a/span")).click();
		Thread.sleep(3000); // THis is important because popup gets loaded and
							// then disappears
		// driver.findElement(By.cssSelector("i.fas.fa-times.close-button.mt-2")).click();
		for (int second = 0; second <= 5; second++) {
			if (second == 5) {
				System.out.println("Popup Not found clickin on new Contact Button");

				break;
			}
			try {
				if (driver.findElement(By.cssSelector("i.fas.fa-times.close-button.mt-2")).isDisplayed()) {
					System.out.println("closig popup now 1");
					driver.findElement(By.cssSelector("i.fas.fa-times.close-button.mt-2")).click(); // popup
																									// close
																									// button
					System.out.println("closed popup  1");
					break;
				}
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
			
	}
	
}
