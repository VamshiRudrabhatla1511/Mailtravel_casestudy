package com.mailTravel.app.pages.pageObjects;

import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.time.temporal.ChronoUnit.SECONDS;

@Component
public class AccomodationPageObjects {

    @WithTimeout(time = 10, chronoUnit = SECONDS)
    @FindBy(xpath = "//select[@data-roomtype='Double ']")
    public WebElement doubleRoomDropDown;
    
    @WithTimeout(time = 10, chronoUnit = SECONDS)
    @FindBy(xpath = "//div[contains(@class, 'nbf_tpl_pms_totalprice_js ')]/span[@class='ibecurr']")
    public WebElement doubleRoomPrice;
    
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//select[@id='pax-a-title-1']")
    public WebElement passenger1Title;
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//input[@id='pax-a-first-1']")
    public WebElement passenger1FN;
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//input[@id='pax-a-last-1']")
    public WebElement passenger1LN;
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//select[@id='pax-a-dobd-1']")
    public WebElement passenger1DOBD;
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//select[@id='pax-a-dobm-1']")
    public WebElement passenger1DOBM;
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//select[@id='pax-a-doby-1']")
    public WebElement passenger1DOBY;
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//select[@id='pax-a-title-2']")
    public WebElement passenger2Title;
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//input[@id='pax-a-first-2']")
    public WebElement passenger2FN;
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//input[@id='pax-a-last-2']")
    public WebElement passenger2LN;
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//select[@id='pax-a-dobd-2']")
    public WebElement passenger2DOBD;
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//select[@id='pax-a-dobm-2']")
    public WebElement passenger2DOBM;
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//select[@id='pax-a-doby-2']")
    public WebElement passenger2DOBY;
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//input[@id='contact-name']")
    public WebElement contactName;
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//input[@id='contact-mobile']")
    public WebElement contactMobile;
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//input[@id='contact-email']")
    public WebElement contactEmail;
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//input[@id='contact-address1']")
    public WebElement contactAddressLine1;
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//input[@id='contact-city']")
    public WebElement contactCity;
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//input[@id='contact-postcode']")
    public WebElement contactPostCode;
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//button[@class='nbf_button nbf_tpl_pms_button']")
    public WebElement continueButton;
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//button[@class='nbf_button nbf_tpl_pms_book_button']")
    public WebElement accomodationSubmitButton;
  
  
    
    

}
