package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsPage extends BasePage{

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    WebElement tabButton;

    public BrowserWindowsPage switchToNextTab(int index) {
        click(tabButton);

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public BrowserWindowsPage assertTabMessage(String message) {
        Assert.assertTrue(shouldHaveText(sampleHeading,message,15));
        return this;
    }
}
