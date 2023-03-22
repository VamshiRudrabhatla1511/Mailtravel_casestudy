package com.mailTravel.app.pages.pageObjects;

import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import static java.time.temporal.ChronoUnit.SECONDS;

import java.util.List;


@Component
public class InfoPageObjects {

    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//*[@id='price-pin_days-ctr']/span[@id='price-pin_riviera-days-num']")
    public WebElement days;
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//*[@id='price-pin_price_non_newmarket']//span[@class='ibecurr']")
    public WebElement price;
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//a[@id='supplier-phone']")
    public WebElement phone;
    
  
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//h2[@id='dates_and_prices_title']")
    public WebElement DatesAndPriceSection;
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//div[contains(@class, 'nbf_tpl_pms_calendar_day_available')]")
    public List<WebElement> availableDepartureDays;
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//div[@class =  'nbf_tpl_pms_calendar_next nbf_tpl_pms_calendar_update']")
    public WebElement moveToNextMonth;
    
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//div[@id='book-cont']//button[@class = 'nbf_button nbf_tpl_pms_book_button nbf_rcorners']")
    public WebElement bookOnlineButton;
    
    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//span[@id='travel-experience-wrap_tr_ex_iter_4_tr-experience-span']")
    public WebElement protectedTravelSection;
    
  
  


}
