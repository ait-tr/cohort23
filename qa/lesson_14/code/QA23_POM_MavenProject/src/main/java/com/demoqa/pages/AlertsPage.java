package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

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

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    public AlertsPage acceptTimerAlert() {
        click(timerAlertButton);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent()).accept();
        return this;
    }

    @FindBy(id = "confirmButton")
    WebElement confirmButton;

    @FindBy(id = "confirmResult")
    WebElement confirmResult;

    public AlertsPage selectAlertConfirm(String text) {

        clickWithJSExecutor(confirmButton,0,100);

        if (text != null && text.equalsIgnoreCase("OK")) {
            driver.switchTo().alert().accept();
        } else if (text != null && text.equalsIgnoreCase("Cancel")) {
            driver.switchTo().alert().dismiss();
        }

        return this;
    }

    public AlertsPage assertConfirm(String message) {
        Assert.assertTrue(confirmResult.getText().contains(message));
        return this;
    }
}
