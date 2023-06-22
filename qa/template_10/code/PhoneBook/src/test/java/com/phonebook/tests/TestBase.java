package com.phonebook.tests;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.*;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager
            (System.getProperty("browser", Browser.CHROME.browserName()));

    //@BeforeMethod
    @BeforeSuite
    public void setUp() {
        app.init();
    }

    //  @AfterMethod(enabled = false)
    @AfterSuite(enabled = false)
    public void tearDown() {
        app.stop();
    }

}


