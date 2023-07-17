package com.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReminderTests extends TestBase{

    @Test
    public void addReminderPositiveTest() {
        //tap on add reminder
        app.getMainScreen().tapOnAddReminder();
        //enter title
        app.getReminder().enterTitle("Holiday");
        //tap on date field
        app.getReminder().tapOnDateField();
        //swipe to month
        app.getReminder().swipeToMonth("past","MAY",3);
        //select date
        app.getReminder().selectDate(0);
        //tap on year
        app.getReminder().tapOnYear();
        //swipe to year
        app.getReminder().swipeToYear("past","2019");
        //tap on OK
        app.getReminder().tapOnOk();
        //tap on time field - id - time
        app.getReminder().tapOnTimeField();
        //select time
        app.getReminder().selectTime("pm",542,1191,542,653);
        //tap on OK
        app.getReminder().tapOnOk();
        //tap on repetition interval - id - RepeatNo
        app.getReminder().tapOnRepetitionInterval();
        //define repetition
        app.getReminder().defineRepetition("2");
        //swipe up
        app.getReminder().swipe(0.7,0.4);
        //tap on type of repetition - id - RepeatType
        app.getReminder().tapOnTypeOfRepetition();
        //select type of repetition
        app.getReminder().selectTypeOfRepetition("Week");
        //save reminder
        app.getReminder().saveReminder();
        //assert by title - id - recycle_title
        Assert.assertTrue(app.getMainScreen().isReminderTitlePresent()
                .contains("Holiday"));
    }
}
