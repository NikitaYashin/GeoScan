package ru.mail.pages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.mail.BaseTest;
import ru.mail.beans.User;

import static ru.mail.utils.TestDataCreator.*;

public class MailRuLoginTest extends BaseTest {

    private User user;

    @BeforeMethod
    public void setUpBefore() {
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
