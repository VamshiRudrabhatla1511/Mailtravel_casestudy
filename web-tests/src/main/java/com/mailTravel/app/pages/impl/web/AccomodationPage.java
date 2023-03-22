package com.mailTravel.app.pages.impl.web;

import com.mailTravel.app.pages.BaseScreen;
import com.mailTravel.app.pages.pageObjects.AccomodationPageObjects;
import com.mailTravel.app.pages.pageObjects.HomePageObjects;
import com.mailTravel.app.pages.pageObjects.InfoPageObjects;
import com.mailTravel.vo.ContactDetailsVO;
import com.mailTravel.vo.PassengerVO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("web")
public class AccomodationPage extends Page implements BaseScreen<WebDriver> {

    @Autowired
    AccomodationPageObjects accomodationPageObjects;
    
    private String doubleRoomDropDownXpath = "//select[@data-roomtype='Double ']";
    private String passenger1FNXpath = "//input[@id='pax-a-first-1']";

    @Override
    public Boolean isPageDisplayed() {
        return null;
    }

    @Override
    public void initialize(WebDriver driver) {
        super.initialize(driver,accomodationPageObjects);
    }
    
    public boolean isDoubleBedAvailableForBooking() {
    		boolean isDoubleBedAvailable = false;
	    	By by= By.xpath(doubleRoomDropDownXpath);
		try {
			this.implicitlyWaitTillElementIsFound(by);
			isDoubleBedAvailable = true;
		} catch (Exception e) {
				e.printStackTrace();
				return isDoubleBedAvailable;
		}
		return isDoubleBedAvailable;
    }
    
    public String bookDoubleBedroomAndContinue(String numOfRooms) {
    		//Implicitly wait till the section loads
    		By by= By.xpath(doubleRoomDropDownXpath);
    		try {
    			this.implicitlyWaitTillElementIsFound(by);
    		} catch (Exception e) {
    			
    		}
    		this.selectDropDownByValue(accomodationPageObjects.doubleRoomDropDown,numOfRooms);
    		accomodationPageObjects.accomodationSubmitButton.click();
    		String bookingAmount = accomodationPageObjects.doubleRoomPrice.getText();
    		return bookingAmount;
    }
    
    public void fillPassengerAndContactDetails(PassengerVO passenger1, PassengerVO passenger2, ContactDetailsVO contact) {
    		//Implicitly wait till the section loads
		By by= By.xpath(passenger1FNXpath);
		this.implicitlyWaitTillElementIsFound(by);
		
		this.selectDropDownByValue(accomodationPageObjects.passenger1Title, passenger1.getTitle());
		accomodationPageObjects.passenger1FN.sendKeys(passenger1.getFirstName());
		accomodationPageObjects.passenger1LN.sendKeys(passenger1.getLastName());
		this.selectDropDownByValue(accomodationPageObjects.passenger1DOBD, passenger1.getDob_date());
		this.selectDropDownByValue(accomodationPageObjects.passenger1DOBM, passenger1.getDob_month());
		this.selectDropDownByValue(accomodationPageObjects.passenger1DOBY, passenger1.getDob_year());
		
		this.selectDropDownByValue(accomodationPageObjects.passenger2Title, passenger2.getTitle());
		accomodationPageObjects.passenger2FN.sendKeys(passenger2.getFirstName());
		accomodationPageObjects.passenger2LN.sendKeys(passenger2.getLastName());
		this.selectDropDownByValue(accomodationPageObjects.passenger2DOBD, passenger2.getDob_date());
		this.selectDropDownByValue(accomodationPageObjects.passenger2DOBM, passenger2.getDob_month());
		this.selectDropDownByValue(accomodationPageObjects.passenger2DOBY, passenger2.getDob_year());
		
		accomodationPageObjects.contactName.sendKeys(contact.getContactName());
		accomodationPageObjects.contactMobile.sendKeys(contact.getPhone());
		accomodationPageObjects.contactEmail.sendKeys(contact.getEmail());
		accomodationPageObjects.contactAddressLine1.sendKeys(contact.getAddressLine1());
		accomodationPageObjects.contactCity.sendKeys(contact.getCity());
		accomodationPageObjects.contactPostCode.sendKeys(contact.getPostcode());
		
		scrollToElement(accomodationPageObjects.continueButton);
		accomodationPageObjects.continueButton.click();
    }
    
    public void getFinalBookingAmount() {
    	
    }
    
    
}
