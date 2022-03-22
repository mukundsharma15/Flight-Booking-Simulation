package com.csci5308.group7.database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConfig {

    private String driver;
    private String database;
    private String username;
    private String password;

    public String getDriver() {
        return driver;
    }

    public String getDatabase() {
        return database;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void loadApplicationProperties()
    {
        InputStream inputStream = null;
        try {

            Properties prop = new Properties();
            inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
            prop.load(inputStream);

            this.driver = prop.getProperty("jdbc.driverClassName");
            this.database = prop.getProperty("jdbc.url");
            this.username = prop.getProperty("jdbc.username");
            this.password = prop.getProperty("jdbc.password");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
