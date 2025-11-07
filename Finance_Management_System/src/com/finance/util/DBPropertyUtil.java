package com.finance.util;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {

    private static final String FILE_NAME = "db.properties";

    public static Properties getDBProperties() {
        Properties props = new Properties();
        try (InputStream input = DBPropertyUtil.class.getClassLoader().getResourceAsStream(FILE_NAME)) {
            if (input == null) {
                throw new RuntimeException(FILE_NAME + " not found in classpath!");
            }
            props.load(input);
            System.out.println("DEBUG: db.properties loaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    public static String getDriver() {
        String driver = getDBProperties().getProperty("driver");
        System.out.println("DEBUG: Loaded driver = " + driver);
        if (driver == null) {
            throw new RuntimeException("Driver not found in db.properties!");
        }
        return driver;
    }

    public static String getUrl() {
        String url = getDBProperties().getProperty("url");
        if (url == null) throw new RuntimeException("URL not found in db.properties!");
        return url;
    }

    public static String getUsername() {
        String username = getDBProperties().getProperty("username");
        if (username == null) throw new RuntimeException("Username not found in db.properties!");
        return username;
    }

    public static String getPassword() {
        String password = getDBProperties().getProperty("password");
        if (password == null) throw new RuntimeException("Password not found in db.properties!");
        return password;
    }
}
