package ru.mail.utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {
    public  WebDriverWait shortWait;
    public  WebDriverWait wait;
    public  WebDriverWait longWait;

    public Waiters(WebDriver driver) {
        wait = new WebDriverWait(driver, 10);
        shortWait = new WebDriverWait(driver, 2);
        longWait = new WebDriverWait(driver, 35, 2000);
    }
}
