package com.demoqa.pages;

import com.beust.ah.A;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userNumber")
    WebElement userNumber;


    public PracticeFormPage enterPersonalData(String fName, String lName, String email, String phNumber) {

        type(firstName, fName);
        type(lastName, lName);
        type(userEmail, email);
        typeWithJSExecutor(userNumber, phNumber, 0, 100);
        return this;
    }

    @FindBy(css = "[for='gender-radio-1']")
    WebElement male;

    @FindBy(css = "[for='gender-radio-2']")
    WebElement female;

    @FindBy(css = "[for='gender-radio-3']")
    WebElement other;

    public PracticeFormPage selectGender(String gender) {

        if (gender.equals("Male")) {
            click(male);
        } else if (gender.equals("Female")) {
            click(female);
        } else {
            click(other);
        }
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;

    public PracticeFormPage typeDate(String bDay) {

        clickWithJSExecutor(dateOfBirthInput, 0, 100);

        selectOS(dateOfBirthInput);

        dateOfBirthInput.sendKeys(bDay);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage addSubject(String[] subjects) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                type(subjectsInput, subjects[i]);
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }

    @FindBy(css = "[for='hobbies-checkbox-1']")
    WebElement sports;

    @FindBy(css = "[for='hobbies-checkbox-2']")
    WebElement reading;

    @FindBy(css = "[for='hobbies-checkbox-3']")
    WebElement music;

    public PracticeFormPage selectHobby(String[] hobbies) {

        for (int i = 0; i < hobbies.length; i++) {
            if (hobbies[i].equals("Sports")) {
                clickWithJSExecutor(sports,0,100);
            }
            if (hobbies[i].equals("Reading")) {
                clickWithJSExecutor(reading,0,100);
            }
            if (hobbies[i].equals("Music")) {
                clickWithJSExecutor(music,0,100);
            }
        }
        return this;
    }

    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    public PracticeFormPage uploadFile(String path) {

        uploadPicture.sendKeys(path);
        return this;
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public PracticeFormPage enterAddress(String address) {
        type(currentAddress,address);
        return this;
    }

    @FindBy(id = "state")
    WebElement stateContainer;

    @FindBy(id = "react-select-3-input")
    WebElement stateInput;

    public PracticeFormPage selectState(String state) {
        click(stateContainer);
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "city")
    WebElement cityContainer;

    @FindBy(id = "react-select-4-input")
    WebElement cityInput;

    public PracticeFormPage selectCity(String city) {
        click(cityContainer);
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;

    public PracticeFormPage submit() {

        clickWithRectangle(submit,2,3);
        return this;
    }

    @FindBy(css = ".react-datepicker__month-select")
    WebElement month;

    @FindBy(css = ".react-datepicker__year-select")
    WebElement year;

    public PracticeFormPage selectDate(String m, String y, String d) {

        clickWithJSExecutor(dateOfBirthInput, 0, 100);

        Select select = new Select(month);
        select.selectByVisibleText(m);

        Select select1 = new Select(year);
        select1.selectByVisibleText(y);

        driver.findElement(By.xpath("//div[.='" + d + "']")).click();
        return this;
    }
}
