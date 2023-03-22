package com.mailTravel.app.pages.impl.web;

import com.mailTravel.app.pages.BaseScreen;
import com.mailTravel.app.pages.pageObjects.HomePageObjects;
import com.mailTravel.app.pages.pageObjects.InfoPageObjects;
import com.mailTravel.app.pages.pageObjects.SummaryPageObjects;

import static java.time.temporal.ChronoUnit.SECONDS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("web")
public class SummaryPage extends Page implements BaseScreen<WebDriver> {
	
	private String totalPriceXpath = "//div[@class='nbf_grid_item nbf_w20 nbf_tpl_pms_room_colheading txt-end']";
    
	@Autowired
    SummaryPageObjects summaryPageObjects;
  

    @Override
    public Boolean isPageDisplayed() {
        return null;
    }

    @Override
    public void initialize(WebDriver driver) {
        super.initialize(driver,summaryPageObjects);
    }
    
    public String getTotalBookingPrice() {
    		By by= By.xpath(totalPriceXpath);
    		this.implicitlyWaitTillElementIsFound(by);
    		return summaryPageObjects.totalPrice.getText();
    }
    
    
    
    
}
