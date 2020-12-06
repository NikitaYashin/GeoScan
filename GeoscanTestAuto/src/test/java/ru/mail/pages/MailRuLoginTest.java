package ru.mail.pages;

import lombok.SneakyThrows;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.mail.BaseTest;
import ru.mail.beans.User;

import java.text.ParseException;

import static ru.mail.utils.TestDataCreator.*;

public class MailRuLoginTest extends BaseTest {

    private User user;

    @BeforeMethod
    public void setUpBefore() throws ParseException {
        user = new User(generateUserName(), generateLastName(), generateUserPassword(), generateEmail(),
                generateBirthDate(), generateGender(), generatePhoneNumbers());
    }

    @Test
    public void singUpToMailRu() {
        mailRuMainPage.openMailRuMainPage().assertMailRuLogoIsPresent();
        mailRuMainPage.openSingUpPage().assertSingUpFirstStepTitle();
        singUpPage.singUpUser(user);
    }
}
