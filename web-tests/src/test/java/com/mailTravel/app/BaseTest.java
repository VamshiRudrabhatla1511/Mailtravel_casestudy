package com.mailTravel.app;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.mailTravel.app.utils.ConfigProperties;
import com.mailTravel.app.utils.DriverService;

public abstract class BaseTest {
    protected RemoteWebDriver driver;
    protected static final ConfigProperties testCp = ConfigProperties.getInstance();

    protected BaseTest() {
        try {
            driver = DriverService.getDriver();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
