package ru.mail.login;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.mail.BaseTest;
import ru.mail.MailRuMainPage;

public class MailRuLoginTest extends BaseTest {

    @BeforeClass
    public void setUp(){
        mailRuMainPage = new MailRuMainPage();
    }

    @Test
    public void openMailRuTest(){
        mailRuMainPage.openMailRuMainPage();
    }
}
