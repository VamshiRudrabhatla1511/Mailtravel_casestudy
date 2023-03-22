package com.mailTravel.app.pages.impl.web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mailTravel.app.pages.impl.common.Screen;


public class Page extends Screen {

    protected WebDriver driver;

    protected void initialize(WebDriver drv, Object page) {
        driver = drv;
        PageFactory.initElements(driver,page);
    }
    
    protected void scrollToElement(WebElement webelement) {
	    	JavascriptExecutor jse = (JavascriptExecutor)driver;
	    	jse.executeScript("arguments[0].scrollIntoView()", webelement); 
    }
    
    protected void selectDropDownByValue(WebElement webelement, String value) {
    		Select dropdown = new Select(webelement);
    		dropdown.selectByValue(value);
    }
    
    protected void implicitlyWaitTillElementIsFound(By by) {
    		WebDriverWait wait = new WebDriverWait(driver, 20);
    		wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    
    protected void shortWait() {
    	try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    protected void longWait() {
    	try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
