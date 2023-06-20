package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.isLoginLinkPresent()) {
            app.clickOnSignOutButton();
        }
        app.clickOnLoginLink();
    }

    @Test
    public void loginPositiveTest() {
        //enter email field
        app.fillLoginRegistrationForm(new User()
                .setEmail("kan@gmai.com")
                .setPassword("Kan123$-_$"));
        //click on Login button
        app.clickOnLoginButton();
        //assert user logged in(check Sign Out button displayed)
        Assert.assertTrue(app.isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeWithoutPasswordTest() {
        //enter email field
        app.fillLoginRegistrationForm(new User().setEmail("kan@gmai.com"));
        //click on Login button
        app.clickOnLoginButton();
        Assert.assertTrue(app.isAlertPresent());
    }
}
