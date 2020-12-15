package utils;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Log4j2
public class PropertyReader {

    private static String propertiesPath = "/config.properties";
    private static volatile Properties properties;
    private static InputStream inputStream;

    private PropertyReader() {
    }

    public static String getProperty(String envVariable, String propertyFromFile) {
        String value = System.getenv().get(envVariable);
        if (value != null) {
            log.debug(String.format("Getting '%s' value of environment variable '%s'", value, envVariable));
        } else {
            value = getProperty(propertyFromFile);
            log.debug(String.format("Getting '%s' value of property from file '%s'", value, propertyFromFile));
        }
        return value;
    }

    public static String getProperty(String propertyName) {
        String value = loadProperties().getProperty(propertyName);
        log.debug(String.format("Getting '%s' value of property from file '%s'", value, propertyName));
        return value;
    }

    private static String getCorrectPath() {
        if (propertiesPath.charAt(0) != '/')
            propertiesPath = "/" + propertiesPath;
        return propertiesPath;
    }

    private static Properties readProperties() {
        properties = new Properties();
        try {
            inputStream = PropertyReader.class.getResourceAsStream(getCorrectPath());
            if (inputStream != null)
                properties.load(inputStream);
        } catch (Exception ex) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (properties.getProperty("config_file") != null) {
            Properties additionalProperties = getProperties(properties.getProperty("config_file"));
            properties.putAll(additionalProperties);
        }
        return properties;
    }

    private static Properties loadProperties() {
        return properties != null ? properties : readProperties();
    }

    private static Properties getProperties(String path) {
        propertiesPath = path;
        return readProperties();
    }
}
