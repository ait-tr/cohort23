package com.phonebook.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ApplicationManager {

    WebDriver driver;

    public void init() {
        driver = new ChromeDriver();
        driver.get("https://telranedu.web.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void stop() {
        driver.quit();
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public boolean isElementPresent1(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void type(By locator, String text) {
        if (text != null) {
            driver.findElement(locator).click();
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isAlertPresent() {

        Alert alert = new WebDriverWait(driver,Duration.ofSeconds(20))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert();
            alert.accept();
            return true;
        }
    }

    public void clickOnLoginLink() {
        click(By.xpath("//a[.='LOGIN']"));
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[.='Sign Out']"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//a[.='LOGIN']"));
    }

    public void clickOnRegistrationButton() {
        click(By.name("registration"));
    }

    public void fillLoginRegistrationForm(User user) {
        type(By.cssSelector("[placeholder='Email']"), user.getEmail());
        type(By.cssSelector("[placeholder='Password']"), user.getPassword());
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent1(By.xpath("//button[.='Sign Out']"));
    }

    public void clickOnLoginButton() {
        click(By.name("login"));
    }

    public void clickOnSaveButton() {
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    public void fillAddContactForm(String name, String lastname, String phone,
                                   String email, String address, String desc) {
        type(By.cssSelector("input:nth-child(1)"), name);
        type(By.cssSelector("input:nth-child(2)"), lastname);
        type(By.cssSelector("input:nth-child(3)"), phone);
        type(By.cssSelector("input:nth-child(4)"), email);
        type(By.cssSelector("input:nth-child(5)"), address);
        type(By.cssSelector("input:nth-child(6)"), desc);
    }

    public void clickOnAddLink() {
        click(By.cssSelector("[href='/add']"));
    }

    public boolean isContactCreated(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement element: contacts) {
            if (element.getText().contains(text))
                return  true;
        }
        return false;
    }

    public boolean isHomeComponentPresent() {
        return isElementPresent(By.xpath("//h1[text()='Home Component']"));
    }

    public boolean isHomeComponentPresent1() {
        return isElementPresent1(By.xpath("//h1[text()='Home Component']"));
    }

    public boolean isLogoPresent() {
        return isElementPresent1(By.cssSelector("h1"));
    }

    public boolean isHomeLinkPresent() {
        return isElementPresent1(By.xpath("//a[text()='HOME']"));
    }

    public boolean isAboutLinkPresent() {
        return isElementPresent(By.xpath("//a[contains(.,'ABOUT')]"));
    }
}
