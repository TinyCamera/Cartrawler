package codesample.cartrawler;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This Class file contains all of the selenium tests for 
 * book.cartrawler.com
 * @author Niall Conroy
 */
public class CartrawlerTest {

	
	
	String URL = "http://book.cartrawler.com/";

	static WebDriver webDriver;
	static CarTrawlerBookPage carTrawlerBookPage;

	
	/**
	 * This function, which is run once before all tests 
	 * instantiates the selenium webdriver and the Car Trawler 
	 * page object.
	 */
	@BeforeClass
	public static void setup() {

		webDriver = new FirefoxDriver();
		//Use pagefactory to initialize the Car trawler book page object
		carTrawlerBookPage = PageFactory.initElements(webDriver,
				CarTrawlerBookPage.class);
	}

	/** 
	 * This function loads the car trawler booking webpage 
	 * before each test.
	 */
	@Before
	public void startTest() {
		webDriver.get(URL);
	}

	/**
	 * Once all tests are finished this function closes
	 * the browser.
	 */
	@AfterClass
	public static void finish() {
		webDriver.quit();
	}

	/**
	 * This test ensures that an error message is shown when not all criterea
	 * on met to move to the next stage in the booking.
	 */
	@Test
	public void testErrorMessage() {
		carTrawlerBookPage.getSearchButton().click();

		if(!waitForElementVisible(carTrawlerBookPage.getErrorMessage(), 5)){
			Assert.fail("Error message not shown");
		}

	}

	/**
	 * This test checks that the Different Return location checkbox
	 * functions correctly by displaying the Return location textbox
	 */
	@Test
	public void testDifferentReturnLocation(){
		carTrawlerBookPage.getDifferentDropOffCheckbox().click();
		
		if(!waitForElementVisible(carTrawlerBookPage.getReturnLocation(), 5)){
			Assert.fail("Return loaction text box not visible after checkbox was checked");
		}
	}

	/**
	 * This tests ensures the Date picker is displayed when the user clicks 
	 * on Pick up date text box
	 */
	@Test
	public void testPickupDateDatepickerVisble(){
		carTrawlerBookPage.getPickUpDate().click();
		
		if(!waitForElementVisible(carTrawlerBookPage.getDatePicker(), 5)){
			Assert.fail("Date picker not visible after Pick up date text box clicked");
		}
		
	}

	/**
	 * This tests ensures the Date picker is displayed when the user clicks 
	 * on drop off date text box
	 */
	@Test
	public void testDropoffDateDatepickerVisble(){
		carTrawlerBookPage.getDropOffDate().click();
		
		if(!waitForElementVisible(carTrawlerBookPage.getDatePicker(), 5)){
			Assert.fail("Date picker not visible after Drop off date text box clicked");
		}
		
	}
	
	
	/**
	 * This test checks that after entering a pick location, pick up and drop off date that 
	 * the use can move to the next step without any errors displayed
	 */
	@Test
	public void testNextStep(){
		//Enter a location with the textbox and the Location picker
		//Implecent waits are needed to ensure there is timing issues
		carTrawlerBookPage.getCityName().sendKeys("Dublin - Airport");
		waitForElementVisible(carTrawlerBookPage.getLocationPicker(), 5);
		//Pick the first element in the list 
		carTrawlerBookPage.getLocationPicker().findElement(By.cssSelector("b")).click();
		waitForElementNotVisible(carTrawlerBookPage.getLocationPicker(), 5);
		
		//Enter a default pick up and drop off time
		carTrawlerBookPage.getPickUpDate().click();
		waitForElementVisible(carTrawlerBookPage.getDatePicker(), 5);
		carTrawlerBookPage.getDatePicker().findElement(By.cssSelector(".ui-datepicker-close")).click();
		waitForElementNotVisible(carTrawlerBookPage.getDatePicker(), 5);
		
		carTrawlerBookPage.getDropOffDate().click();
		waitForElementVisible(carTrawlerBookPage.getDatePicker(), 5);
		carTrawlerBookPage.getDatePicker().findElement(By.cssSelector(".ui-datepicker-close")).click();
		waitForElementNotVisible(carTrawlerBookPage.getDatePicker(), 5);

		//Click the search button to move to the next step
		carTrawlerBookPage.getSearchButton().click();
		
		//Check if there are any false errors, and fail if any are found
		if(waitForElementVisible(carTrawlerBookPage.getErrorMessage(), 5)){
			Assert.fail("Error message visible");
		}
		
	
	}
	
	/**
	 * This function implicitly waits for the visibility of a web element
	 * using WebDriverWait to ensure there are 
	 * no timing issues with the overlay transitions 
	 * @param webElement The element to wait for
	 * @param timeout the number of seconds to wait before timeout
	 * @return True if element is visible before timeout, false otherwise
	 */
	public boolean waitForElementVisible(WebElement webElement, int timeout){
		WebDriverWait wait = new WebDriverWait(webDriver, timeout);
		try {
			wait.until(ExpectedConditions.visibilityOf(webElement));
		} catch (TimeoutException e) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * This function implicitly waits for a web element to
	 * no longer be visible using WebDriverWait to ensure there 
	 * are no timing issues with the overlay transitions 
	 * @param webElement The element to wait for
	 * @param timeout the number of seconds to wait before timeout
	 * @return True if element is no longer visible before timeout, false otherwise
	 */
	public boolean waitForElementNotVisible(WebElement webElement, int timeout){
		WebDriverWait wait = new WebDriverWait(webDriver, timeout);
		try {
			wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(webElement)));
		} catch (TimeoutException e) {
			return false;
		}
		
		return true;
	}
		
	

}
