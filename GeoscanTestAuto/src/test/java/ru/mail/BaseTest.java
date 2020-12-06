package ru.mail;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.mail.utils.PropertyLoader;
import ru.mail.utils.WDSingletone;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected MailRuMainPage mailRuMainPage;

    @BeforeSuite
    public void driverLaunch(ITestContext context) {
        WebDriver driver = WDSingletone.getInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        context.setAttribute("driver", driver);
        Properties testData = PropertyLoader.getProperties();
        assert testData != null;
    }

    @AfterSuite
    public void tearDown(){
        WDSingletone.quitAndSetToNull();
    }
}
