package ru.mail.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertyLoader {
    private static final String PATH = "src/test/resources/environment.properties";
    private static Properties propertiesInstance;

    public static String getEnvironment() {
        String env = System.getProperty("env");
        if (env != null && env.length() != 0) {
            if(env.equalsIgnoreCase("Release")) {
                return propertiesInstance.getProperty("release.env");
            }
        }
        return propertiesInstance.getProperty("release.env");
    }

    public static Properties getProperties() {
        if (propertiesInstance != null) {
            return propertiesInstance;
        }
        try (FileInputStream input = new FileInputStream(new File(PATH))) {
            propertiesInstance = new Properties();
            propertiesInstance.load(new InputStreamReader(input, StandardCharsets.UTF_8));
            return propertiesInstance;
        } catch (IOException e) {
            Logger logger = LoggerFactory.getLogger(PropertyLoader.class);
            logger.error("File with properties is not found");
        }
        return null;
    }
}
