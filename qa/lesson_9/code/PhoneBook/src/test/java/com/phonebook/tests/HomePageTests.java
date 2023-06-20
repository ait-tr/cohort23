package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void openHomePageTest() {

        // System.out.println("Home Component is " + isHomeComponentPresent1());
        // isElementPresent(By.xpath("//h1[text()='Home Component']"));
        Assert.assertTrue(app.isHomeComponentPresent());
    }

}
