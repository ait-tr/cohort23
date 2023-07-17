package com.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainScreenTests extends TestBase{

    @Test
    public void launchAppTest() {
        Assert.assertTrue(app.getMainScreen().isMainScreenMessagePresent());
    }
}
