package com.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper{

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeComponentPresent() {
        return isElementPresent(By.xpath("//h1[text()='Home Component']"));
    }

    public boolean isHomeComponentPresent1() {
        return isElementPresent1(By.xpath("//h1[text()='Home Component']"));
    }
}
