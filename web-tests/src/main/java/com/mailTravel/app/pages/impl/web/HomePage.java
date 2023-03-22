package com.mailTravel.app.pages.impl.web;

import com.mailTravel.app.pages.BaseScreen;
import com.mailTravel.app.pages.pageObjects.HomePageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("web")
public class HomePage extends Page implements BaseScreen<WebDriver> {
	
	private InfoPage infoPage;

    @Autowired
    HomePageObjects homePageObjects;

    @Override
    public Boolean isPageDisplayed() {
        return null;
    }

    @Override
    public void initialize(WebDriver driver) {
        super.initialize(driver,homePageObjects);
    }
    
    String searchResultItem = "//div[@id='as_searchtext_freetext_search_form']/ul[@id='as_ul']/li[1]/a";
    
    public String getHomePageTitle() {
    		return homePageObjects.logo.getAttribute("title");
    }
    
    public void performSearch(String searchstring, String link) {
		 homePageObjects.searchBox.sendKeys(searchstring);
		 this.shortWait();
		 WebElement m = driver.findElement(By.xpath(searchResultItem));
		 Actions actions = new Actions (driver);
		 actions.moveToElement(m).click().build().perform();
    }
}
