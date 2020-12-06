package ru.mail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.mail.utils.PropertyLoader;
import ru.mail.utils.WDSingletone;
import ru.mail.utils.Waiters;

public class BasePage {

    protected static String URL = PropertyLoader.getEnvironment();
    protected WebDriver driver;
    protected Waiters waiter;

    public BasePage() {
        this.driver = WDSingletone.getInstance();
        this.waiter = new Waiters(driver);
        PageFactory.initElements(driver, this);
    }
}
