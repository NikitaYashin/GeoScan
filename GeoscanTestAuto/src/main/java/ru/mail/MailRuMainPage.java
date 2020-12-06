package ru.mail;

public class MailRuMainPage extends BasePage {

    public void openMailRuMainPage() {
        driver.get("https://" + URL);
    }
}
