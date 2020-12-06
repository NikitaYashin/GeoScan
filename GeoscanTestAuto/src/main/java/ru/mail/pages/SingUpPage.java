package ru.mail.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.mail.BasePage;
import ru.mail.beans.User;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class SingUpPage extends BasePage {

    //I like to use XPath in such cases because this way the field text could be checked as well
    @FindBy(xpath = "//h2[contains(text(),'Create account')]")
    WebElement singUpFirstStepTitle;
    @FindBy(xpath = "//input[@id='fname']")
    WebElement firstNameField;
    @FindBy(xpath = "//input[@id='lname']")
    WebElement lastNameField;
    @FindBy(xpath = "//span[contains(text(), 'Day')]")
    WebElement day;
    @FindBy(xpath = "//span[contains(text(), 'Month')]")
    WebElement month;
    @FindBy(xpath = "//span[contains(text(), 'Year')]")
    WebElement year;
    @FindBy(xpath = "//div[@data-test-id = 'select-option-wrapper']//span")
    List<WebElement> options;
    @FindBy(id = "gender-male")
    WebElement genderMaleOption;
    @FindBy(id = "gender-female")
    WebElement genderFemaleOption;
    @FindBy(id = "aaa__input")
    WebElement emailField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "repeatPassword")
    WebElement repeatPasswordPasswordField;
    @FindBy(id = "phone-number__phone-input")
    WebElement phoneNumberField;
    @FindBy(id = "first-step-submit")
    WebElement submitData;

    public void assertSingUpFirstStepTitle() {
        switchTab();
        assertTrue(singUpFirstStepTitle.isDisplayed());
    }

    public void singUpUser(User user){
        pasteFirstNameField(user.getUsername());
        pasteLastNameField(user.getLastName());
        selectDay(user.getBirthDate().getDay());
        selectMonth(user.getBirthDate().getMonth());
        selectYear(user.getBirthDate().getYear());
        clickGender(user.getGenderId());
        pastePasswordField(user.getPassword());
        pasteRepeatPassword(user.getPassword());
        pastePhone(user.getPhoneNumber());
        submitData.click();
    }

    public void pasteFirstNameField(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void pasteLastNameField(String lastName) {
        firstNameField.sendKeys(lastName);
    }

    public void selectDay(int indexDay) {
        day.click();
        options.get(indexDay - 1).click();
    }

    public void selectMonth(int indexMonth){
        month.click();
        options.get(indexMonth - 1).click();
    }

    public void selectYear(int yearIndex){
        year.click();
        options.get(yearIndex - 1).click();
    }

    public void chooseFemaleGender(){
        genderFemaleOption.click();
    }

    public void chooseMaleGender(){
        genderMaleOption.click();
    }

    public void clickGender(int gender){
        if (gender == 1){
            chooseFemaleGender();
        }else {
            chooseMaleGender();
        }
    }

    public void pasteEmailField(String emailName){
        emailField.sendKeys(emailName);
    }

    public void pastePasswordField(String password){
        passwordField.sendKeys(password);
    }

    public void pasteRepeatPassword(String password){
        repeatPasswordPasswordField.sendKeys(password);
    }

    public void pastePhone(String phoneNumber){
        phoneNumberField.sendKeys(phoneNumber);
    }
}
