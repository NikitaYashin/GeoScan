package ru.mail.utils;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TestDataCreator {

    static Faker faker = new Faker();

    public static String generateUserName() {
        return faker.name().firstName();
    }

    public static String generateLastName() {
        return faker.name().lastName();
    }

    public static String generateUserPassword() {
        return faker.internet().password(8, 14, true, true) +
                faker.idNumber();
    }

    public static String generateEmail(){
        return faker.gameOfThrones().character() + faker.number().randomNumber(3,true);
    }

    public static int generateGender(){
        return faker.number().numberBetween(1,2);
    }

    public static Date generateBirthDate() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("ru", "RUS"));
        df.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));
        df.setLenient(false);
        Date dateFrom = df.parse("1901-01-01 00:00:00");
        Date now = df.parse(String.valueOf(LocalDateTime.now()));
        return faker.date().between(dateFrom, now);
    }

    public static String generatePhoneNumbers(){
       return String.valueOf(faker.number().randomNumber(10, false));
    }
}
