package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.isLoginLinkPresent()) {
            app.clickOnSignOutButton();
        }
    }

    @Test
    public void verifyIsLogoPresent() {
        Assert.assertTrue(app.isLogoPresent());
    }

    @Test
    public void verifyIsHomeLinkPresent() {
        Assert.assertTrue(app.isHomeLinkPresent());
    }

    @Test
    public void verifyIsAboutLinkPresent() {
        Assert.assertTrue(app.isAboutLinkPresent());
    }

    @Test
    public void verifyIsLoginLinkPresent() {
        Assert.assertTrue(app.isLoginLinkPresent());
    }


}
