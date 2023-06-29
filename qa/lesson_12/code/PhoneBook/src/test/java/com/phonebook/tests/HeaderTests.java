package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
    }

    @Test
    public void verifyIsLogoPresent() {
        Assert.assertTrue(app.getHeader().isLogoPresent());
    }

    @Test
    public void verifyIsHomeLinkPresent() {
        Assert.assertTrue(app.getHeader().isHomeLinkPresent());
    }

    @Test
    public void verifyIsAboutLinkPresent() {
        Assert.assertTrue(app.getHeader().isAboutLinkPresent());
    }

    @Test
    public void verifyIsLoginLinkPresent() {
        Assert.assertTrue(app.getHeader().isLoginLinkPresent());
    }


}
