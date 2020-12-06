package ru.mail.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WDSingletone {
    private static WebDriver instance;

    public static WebDriver getInstance() {
        if (instance == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            instance = new ChromeDriver(options);
        }
        return instance;
    }

    public static void quitAndSetToNull() {
        instance.quit();
        instance = null;
    }
}
