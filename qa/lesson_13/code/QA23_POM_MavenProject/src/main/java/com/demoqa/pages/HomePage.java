package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[.='Alerts, Frame & Windows']")
    WebElement alertsFrameWindows;

    public SidePanel getAlertsFrameWindows() {
        clickWithJSExecutor(alertsFrameWindows,0,300);
        return new SidePanel(driver);
    }

    @FindBy(xpath = "//h5[.='Interactions']")
    WebElement interactions;

    public SidePanel getInteractions() {
        clickWithJSExecutor(interactions,0,300);
        return new SidePanel(driver);
    }
}
