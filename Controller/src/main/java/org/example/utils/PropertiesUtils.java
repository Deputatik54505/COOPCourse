package org.example.utils;

import org.example.entities.product.ProductConnector;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

    private final Properties properties;

    public PropertiesUtils(){
        properties = loadProperties();
    }

    public String getPassword() {
        String password = "db.password";
        return properties.getProperty(password);
    }
    public String getUsername(){
        String username = "db.username";
        return properties.getProperty(username);
    }
    public String getUrl(){
        String url = "db.url";
        return properties.getProperty(url);
    }

    private Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = ProductConnector.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
