package com.demoqa.tests;

import com.demoqa.pages.BrowserWindowsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserWindowsTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAlertsFrameWindows();
        new SidePanel(driver).selectBrowserWindows();
    }

    @Test
    public void openNewTabTest() {
        new BrowserWindowsPage(driver).switchToNextTab(1)
                .assertTabMessage("This is a sample page");
    }
}
