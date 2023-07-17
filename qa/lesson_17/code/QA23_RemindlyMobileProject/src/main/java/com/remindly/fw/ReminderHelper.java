package com.remindly.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReminderHelper extends BaseHelper{

    public ReminderHelper(AppiumDriver driver) {
        super(driver);
    }

    public void enterTitle(String text) {
        type(By.id("reminder_title"),text);
    }

    public void tapOnDateField() {
        tap(By.id("date"));
    }

    public void swipeToMonth(String period, String month, int number) {

        pause(1000);

        if (!getSelectedMonth().equals(month)) {
            for (int i = 0; i < number; i++) {
                if (period.equals("future")) {
                    swipe(0.7,0.4);
                } else if (period.equals("past")) {
                    swipe(0.5,0.8);
                }
            }
        }
    }

    private String getSelectedMonth() {
        return driver.findElement(By.id("date_picker_month")).getText();
    }

    public void selectDate(int index) {

        List<WebElement> days = driver.findElements(By.className("android.view.View"));
        days.get(index).click();
    }

    public void tapOnYear() {
        tap(By.id("date_picker_year"));
    }

    public void swipeToYear(String period2, String year) {
        pause(1000);

        if (!getSelectedYear().equals(year)) {
            if (period2.equals("future")) {
                swipeUntilNeededYear(year,0.6,0.5);
            } else if (period2.equals("past")) {
                swipeUntilNeededYear(year,0.5,0.6);
            }
        }
        tap(By.id("month_text_view"));
    }

    private void swipeUntilNeededYear(String year, double startPoint, double stopPoint) {

        while (!getSelectedYear().equals(year)) {
            swipeInElement(By.className("android.widget.ListView"),startPoint,stopPoint);
            getSelectedYear();
        }
    }

    public String getSelectedYear() {
        return driver.findElement(By.id("month_text_view")).getText();
    }

    public void tapOnOk() {
        tap(By.id("ok"));
    }

    public void tapOnTimeField() {
        tap(By.id("time"));
    }

    public void selectTime(String timeOfDay, int xHour, int yHour, int xMin, int yMin) {

        pause(1000);

        if (timeOfDay.equals("am")) {
            tapWithCoordinates(279,1321);
        } else if (timeOfDay.equals("pm")) {
            tapWithCoordinates(801,1321);
        }

        tapWithCoordinates(xHour,yHour);
        tapWithCoordinates(xMin,yMin);
    }

    public void tapOnRepetitionInterval() {
        tap(By.id("RepeatNo"));
    }

    public void defineRepetition(String repeat) {
        pause(1000);
        type(By.className("android.widget.EditText"),repeat);
        tap(By.xpath("//*[@text='OK']"));
    }

    public void tapOnTypeOfRepetition() {
        tap(By.id("RepeatType"));
    }

    public void selectTypeOfRepetition(String typeRep) {
        tap(By.xpath("//*[@text='" + typeRep + "']"));
    }

    public void saveReminder() {
        tap(By.id("save_reminder"));
    }
}
