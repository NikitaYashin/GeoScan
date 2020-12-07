package ru.mail.utils;

import com.github.javafaker.Faker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestDataCreator {

    static Faker faker = new Faker();

    private static int MAX_AGE = 119;
    private static int MIN_AGE = 0;

    public static String generateUserName() {
        return faker.name().firstName();
    }

    public static String generateLastName() {
        return faker.name().lastName();
    }

    public static String generateUserPassword() {
        return faker.internet().password(8, 14, true, true);
    }

    public static String generateEmail() {
        return faker.gameOfThrones().character() + faker.number().randomNumber(3, true);
    }

    public static int generateGender() {
        return faker.number().numberBetween(1, 2);
    }

    public static Date generateBirthDate() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        Calendar from = new GregorianCalendar(currentYear - MAX_AGE, currentMonth, currentDay);
        Calendar to = new GregorianCalendar(currentYear - MIN_AGE, currentMonth, currentDay);
        return faker.date().between(from.getTime(), to.getTime());
    }

    public static String generatePhoneNumbers() {
        return String.valueOf(faker.number().randomNumber(10, false));
    }

    public static String generateBigString() {
        return faker.regexify("[a-z1-9]{10000}");
    }
}
