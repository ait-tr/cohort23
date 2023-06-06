package com.ait.qa23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FindElementTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementsByCssTest() {
        //id -> css(#)
        //driver.findElement.(By.id("city");
        driver.findElement(By.cssSelector("#city"));

        //class -> css(.)
        //driver.findElement(By.className("header"));
        driver.findElement(By.cssSelector(".header"));

        //attribute -> css([])
        driver.findElement(By.cssSelector("[type='submit']"));

        //contains -> *
        driver.findElement(By.cssSelector("[href*='car']"));
        //start with -> ^
        driver.findElement(By.cssSelector("[href^='/let']"));
        //end on -> $
        driver.findElement(By.cssSelector("[href$='work']"));
    }

    @Test
    public void findElementByXpathTest() {
        //id -> xpath //*[@id='value']
        //driver.findElement.(By.id("city");
        driver.findElement(By.xpath("//*[@id='city']"));

        //class -> xpath //*[@class='value']
        //driver.findElement(By.className("header"));
        driver.findElement(By.xpath("//*[@class='header']"));

        //contains, end on, start -> //*[contains(.,'text')]
        driver.findElement(By.xpath("//*[contains(.,'Find your car now!')]"));

    }
}
