package com.mailTravel.app.steps.web;

import com.mailTravel.app.BaseTest;
import com.mailTravel.app.utils.DriverService;

import io.appium.java_client.AppiumDriver;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.mailTravel.app.steps.web.Config.class})
@SpringJUnitConfig
public class WebTest extends BaseTest {

    protected WebDriver driver;

    protected WebTest() {
        try {
            driver = DriverService.getDriver();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}

@Configuration
@ComponentScan(basePackages = {"com.mailTravel.app"})
class Config {

}
