package com.mailTravel.app.pages.impl.web;

import com.mailTravel.app.pages.BaseScreen;
import com.mailTravel.app.pages.pageObjects.HomePageObjects;
import com.mailTravel.app.pages.pageObjects.InfoPageObjects;import static java.time.temporal.ChronoUnit.SECONDS;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("web")
public class InfoPage extends Page implements BaseScreen<WebDriver> {
	
	private String departureDateXpath = "//div[contains(@class, 'nbf_tpl_pms_calendar_day_available')]";
	private String nextMonthMoveXpath = "//div[@class =  'nbf_tpl_pms_calendar_next nbf_tpl_pms_calendar_update']";

    @Autowired
    InfoPageObjects infoPageObjects;
  

    @Override
    public Boolean isPageDisplayed() {
        return null;
    }

    @Override
    public void initialize(WebDriver driver) {
        super.initialize(driver,infoPageObjects);
    }
    
    public String getDays() {
    		return infoPageObjects.days.getText();
    }
    
    public String getPrice() {
		return infoPageObjects.price.getText();
    }
    
    public String getPhone() {
		return infoPageObjects.phone.getText();
    }
    
    public String selectDepartureDateAndBookOnline(String previousSelectedDate) {
    		scrollToElement(infoPageObjects.DatesAndPriceSection);
    		this.shortWait();
    		String selectedDepartureDate = "";
    		boolean moveToNextMonth = true;
    		while(moveToNextMonth) {
	    		if(infoPageObjects.availableDepartureDays.size()>0) {
	    			
	    				selectedDepartureDate = driver.findElement(By.xpath(departureDateXpath + "//input[@class='pms_pricing_update']")).getAttribute("data-selecteddatedisplay");
	    				if(!selectedDepartureDate.equals(previousSelectedDate)) {
	    					try {
	    						infoPageObjects.availableDepartureDays.get(0).click();
	    					}	catch (StaleElementReferenceException e) {
	    						driver.findElement(By.xpath(departureDateXpath)).click();
	    					}
	    					moveToNextMonth = false;
	    				}
	    			
	    		} else {
	    			scrollToElement(infoPageObjects.protectedTravelSection);
	    			try {
	    				infoPageObjects.moveToNextMonth.click();
	    			}catch (StaleElementReferenceException e) {
					driver.findElement(By.xpath(nextMonthMoveXpath)).click();
				}
	    		}
    		}
    		infoPageObjects.bookOnlineButton.click();
    		return selectedDepartureDate;
    }
    
    
}
