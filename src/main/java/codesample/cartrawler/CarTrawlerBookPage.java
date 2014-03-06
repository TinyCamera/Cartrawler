package codesample.cartrawler;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * This class represents the page object of the first stage
 * of the car trawler booking engine
 * Selenium webelements are used to represent particular parts of the webpage 
 * and these are located using Id's when possible but css otherwise.
 * @author Niall
 *
 */
public class CarTrawlerBookPage {

	@FindBy(how = How.ID, using = "ct_s1_pickup_loc")
	private WebElement cityName;

	@FindBy(how = How.ID, using = "ct_s1_diff_dropoff")
	private WebElement differentDropOffCheckbox;

	@FindBy(how = How.ID, using = "ct_s1_dropoff_loc")
	private WebElement returnLocation;

	@FindBy(how = How.ID, using = "ct_s1_pickup_date")
	private WebElement pickUpDate;

	@FindBy(how = How.CSS, using = "#ct_s1_pickup_time .ct-ui-formfield")
	private WebElement pickUpTime;

	@FindBy(how = How.ID, using = "ct_s1_dropoff_date")
	private WebElement dropOffDate;

	@FindBy(how = How.CSS, using = "#ct_s1_dropoff_time .ct-ui-formfield")
	private WebElement dropOffTime;

	@FindBy(how = How.CSS, using = ".ct-ui-s-adv .ct-ui-formfield")
	private WebElement iLiveInDropDown;

	@FindBy(how = How.CSS, using = ".ct-ui-s-error-msg-label")
	private WebElement errorMessage;

	@FindBy(how = How.CSS, using = ".ui-autocomplete .ui-menu-item")
	private WebElement locationPicker;

	@FindBy(how = How.ID, using = "ui-datepicker-div")
	private WebElement datePicker;

	@FindBy(how = How.ID, using = "ct_s1_search_button")
	private WebElement searchButton;

	public WebElement getCityName() {
		return cityName;
	}

	public WebElement getDifferentDropOffCheckbox() {
		return differentDropOffCheckbox;
	}

	public WebElement getReturnLocation() {
		return returnLocation;
	}

	public WebElement getPickUpDate() {
		return pickUpDate;
	}

	public WebElement getPickUpTime() {
		return pickUpTime;
	}

	public WebElement getDropOffDate() {
		return dropOffDate;
	}

	public WebElement getDropOffTime() {
		return dropOffTime;
	}

	public WebElement getiLiveInDropDown() {
		return iLiveInDropDown;
	}

	public WebElement getErrorMessage() {
		return errorMessage;
	}

	public WebElement getLocationPicker() {
		return locationPicker;
	}

	public WebElement getDatePicker() {
		return datePicker;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

}
