package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateContactTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.isLoginLinkPresent()) {
            app.clickOnSignOutButton();
        }
        app.clickOnLoginLink();
        app.fillLoginRegistrationForm(new User().setEmail("kan@gmai.com").setPassword("Kan123$-_$"));
        app.clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        //click on the ADD link
        app.clickOnAddLink();
        // int i = (int) (System.currentTimeMillis() / 1000)%3600;
        //fill in the add contact form
        app.fillAddContactForm("Karl", "Adam", "1234567890", "adam@gm.com", "Koblenz", "goalkeeper");
        //click on the Save button
        app.clickOnSaveButton();
        //assert the contact is added
        Assert.assertTrue(app.isContactCreated("Karl"));
    }

    // VOM
    // POM

}
