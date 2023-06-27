package com.phonebook.tests;

import com.phonebook.model.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
        app.getHeader().clickOnLoginLink();
        app.getUser().login();
        app.getHeader().clickOnAddLink();
        app.getContact().addContact();
    }


    @Test
    public void removeContactTest() {

        int sizeBefore = app.getContact().sizeOfContacts();

        app.getContact().removeContact();

        app.getContact().pause(1000);

        int sizeAfter = app.getContact().sizeOfContacts();

        Assert.assertEquals(sizeAfter,sizeBefore-1);

    }

}
