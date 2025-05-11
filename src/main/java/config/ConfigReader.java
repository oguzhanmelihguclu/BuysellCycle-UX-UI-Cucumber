package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties properties;

	static {
		try {
			FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
			properties = new Properties();
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Config file could not be loaded!");
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
}
