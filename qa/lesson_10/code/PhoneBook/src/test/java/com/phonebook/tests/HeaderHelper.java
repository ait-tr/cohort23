package com.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends BaseHelper{

    public HeaderHelper(WebDriver driver) {
        super(driver);
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

    public boolean isSignOutButtonPresent() {
        return isElementPresent1(By.xpath("//button[.='Sign Out']"));
    }

    public void clickOnAddLink() {
        click(By.cssSelector("[href='/add']"));
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
