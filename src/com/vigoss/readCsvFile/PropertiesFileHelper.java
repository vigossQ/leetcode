package com.vigoss.readCsvFile;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Reimu Hakurei
 * @date 2023/1/8 20:03
 */
public class PropertiesFileHelper {

    public static String APPLICATION_PROPERTIES = "application.properties";
    public static final String CSV_FILE_NAME_KEY = "csv.file.name";
    public static final String DEFAULT_FILE_NAME = "default.csv";

    public static String csvFileNameFromProperties() {
        try (InputStream in = new BufferedInputStream(new FileInputStream(APPLICATION_PROPERTIES))) {
            Properties prop = new Properties();
            prop.load(in);
            for (String key : prop.stringPropertyNames()) {
                if (CSV_FILE_NAME_KEY.equals(key)) {
                    return prop.getProperty(key);
                }
            }
            return DEFAULT_FILE_NAME;
        } catch (Exception e) {
            return DEFAULT_FILE_NAME;
        }
    }
}
