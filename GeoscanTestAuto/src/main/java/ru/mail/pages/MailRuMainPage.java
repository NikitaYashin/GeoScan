package ru.mail.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.mail.BasePage;

public class MailRuMainPage extends BasePage {

    //id is the most stable locators so...
    @FindBy(id = "signup")
    WebElement singUoLink;
    @FindBy(id = "logo")
    WebElement mailRuLogo;

    public MailRuMainPage openMailRuMainPage() {
        driver.get("https://" + URL);
        return new MailRuMainPage();
    }

    public void assertMailRuLogoIsPresent() {
        mailRuLogo.isDisplayed();
    }

    public SingUpPage openSingUpPage() {
        singUoLink.click();
        return new SingUpPage();
    }
}
