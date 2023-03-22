package com.mailTravel.app.pages.pageObjects;

import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.time.temporal.ChronoUnit.SECONDS;

@Component
public class HomePageObjects {

    @WithTimeout(time = 10, chronoUnit = SECONDS)
    @FindBy(xpath = "//img[@id='site-logosite-logo-mobile']")
    public WebElement logo;
    
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//input[@id='searchtext_freetext_search_form']")
    public WebElement searchBox;
    
    @WithTimeout(time = 10, chronoUnit = SECONDS)
    @FindBy(xpath = "//div[@id='as_searchtext_freetext_search_form']/ul[@id='as_ul']/li[1]/a")
    public WebElement India11DaysSearchItem;

}
