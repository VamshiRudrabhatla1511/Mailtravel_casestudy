package com.mailTravel.app.steps.web;

import com.mailTravel.app.models.AppContext;
import com.mailTravel.app.models.EnumConstants;
import com.mailTravel.app.pages.BaseScreen;
import com.mailTravel.app.pages.impl.web.AccomodationPage;
import com.mailTravel.app.pages.impl.web.HomePage;
import com.mailTravel.app.pages.impl.web.InfoPage;
import com.mailTravel.app.pages.impl.web.SummaryPage;
import com.mailTravel.app.pages.pageObjects.HomePageObjects;
import com.mailTravel.vo.ContactDetailsVO;
import com.mailTravel.vo.PassengerVO;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.mailTravel.app.models.EnumConstants.DEFAULT_ELEMENT_TIMEOUT_IN_SECONDS_10;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class MailTravelSteps extends WebTest {

    private HomePage homePage;
    private 	PassengerVO passenger1;
	private PassengerVO passenger2;
	private ContactDetailsVO contact;
	private String expectedBookingAmount="";
	private String selectedDepartureDate = "";
	
    
    
    @Autowired
    private InfoPage infoPage;
    
    @Autowired
    private AccomodationPage accomodationPage;
    
    @Autowired
    private SummaryPage summaryPage;

    @Autowired
    HomePageObjects homePageObjects;

    @Autowired
    public MailTravelSteps(HomePage homePage) {
        if (!EnumConstants.Platform.api.name().equalsIgnoreCase(AppContext.platform)) {
        		homePage.initialize(driver);
        }
        this.homePage = homePage;
        this.buildTestData();
    }

    @Given("^I am on Mailtravel.co.uk home page and verify (.*) as the title$")
    public void goToHomePageAndVerify(String title) {
        driver.navigate().to(testCp.getWebUrl());
        assertEquals(homePage.getHomePageTitle(), title);
    }

   @When("^I search for the text (.*) in the Search Box and I click more info on the (.*)$")
   public void chooseTheMaxPriceItem(String searchString, String link){
	    homePage.performSearch(searchString, link);
   }

    

    @And("^I make sure that it is displaying (.*) days, price as (.*) and phone number as (.*)$")
    public void verifyDaysPricePhone(String days, String price, String phone) {
    		infoPage.initialize(driver);	
    		assertEquals(infoPage.getDays(), days);
    		assertEquals(infoPage.getPrice(), price);
    		assertEquals(infoPage.getPhone(), phone);
        
    }
    
    @And("^I select the departure date as click on Book Online link$")
    public void selectDepartureDateAndBookOnline(){
    		boolean isDoubleBedAvailable = false;
    		while(!isDoubleBedAvailable) {
	    		this.selectedDepartureDate = infoPage.selectDepartureDateAndBookOnline(this.selectedDepartureDate);
	    		accomodationPage.initialize(driver);
	    		isDoubleBedAvailable = accomodationPage.isDoubleBedAvailableForBooking();
	    		if(!isDoubleBedAvailable) {
	    			driver.navigate().back();
	    		}
    		}
 
    }
    
    @And("^I select the Double Room for 2 adults and continue$")
    public void bookDoubleBedroomFor2Adults(){
    		accomodationPage.initialize(driver);	
    		this.expectedBookingAmount = accomodationPage.bookDoubleBedroomAndContinue("1");
    }
    
    @And("^I fill the passenger details and continue$")
    public void fillPassengerDetailsAndSubmit(){
    		accomodationPage.fillPassengerAndContactDetails(passenger1, passenger2, contact);
    }
    
    @Then("^I verify payment amount is as per the accommodation selected for 2 adults$")
    public void verifyThePaymetAount(){
    		summaryPage.initialize(driver);
    		String actualBookingPrice = summaryPage.getTotalBookingPrice();
    		assertEquals(actualBookingPrice, expectedBookingAmount);
    }
    
    
    private void buildTestData() {
    		 passenger1 = new PassengerVO("Mr", "pass1_first", "pass1_last","10","1","2007");
    		 passenger2 = new PassengerVO("Mrs", "pass2_first", "pass2_last","11","2","2007");
    		 contact = new ContactDetailsVO("testName", "44789123222", "test@test.com", "123 addressTest", "London", "TWR123"); 	
    }
    
    
}