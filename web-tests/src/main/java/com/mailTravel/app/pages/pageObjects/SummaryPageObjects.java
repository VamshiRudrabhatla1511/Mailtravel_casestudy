package com.mailTravel.app.pages.pageObjects;

import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import static java.time.temporal.ChronoUnit.SECONDS;

import java.util.List;


@Component
public class SummaryPageObjects {

    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @FindBy(xpath = "//div[@class='nbf_grid_item nbf_w20 nbf_tpl_pms_room_colheading txt-end']")
    public WebElement totalPrice;

}
