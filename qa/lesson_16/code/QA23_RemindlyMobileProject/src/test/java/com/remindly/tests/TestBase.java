package com.remindly.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestBase {

    AppiumDriver driver;

    DesiredCapabilities capabilities;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("deviceName","mob");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","com.blanyal.remindly");
        capabilities.setCapability("appActivity","com.blanyal.remindme.MainActivity");
        capabilities.setCapability("app","C:/Tools/remindly.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
}


