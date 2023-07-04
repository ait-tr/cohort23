package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AlertsPage extends BasePage{

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "promtButton")
    WebElement promtButton;

    public AlertsPage sendMessageToAlert(String message) {
        click(promtButton);

        if (message != null) {
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }
        return this;
    }

    @FindBy(id = "promptResult")
    WebElement promptResult;

    public AlertsPage assertMessage(String message) {
        Assert.assertTrue(promptResult.getText().contains(message));
        return this;
    }
}
