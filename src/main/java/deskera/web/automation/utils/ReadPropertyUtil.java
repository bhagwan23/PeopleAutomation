package deskera.web.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.commons.configuration.PropertiesConfiguration;

public class ReadPropertyUtil {
	/**
	 * Description - : This util reads config and return particular key
	 * 
	 * @param property
	 * @param config_file
	 * @return
	 */
	public static String readProperty(String property, String config_file) {
		Properties prop;
		String value = null;
		try {

			FileInputStream in = new FileInputStream(config_file);

			prop = new Properties();
			prop.load(in);
			value = prop.getProperty(property);
			if (value == null || value.isEmpty()) {
				throw new Exception("Value not set or empty for " + property);

			}
			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}



	/**
	 * Set property to update any value dynamically
	 * @param property
	 * @param config_file
	 * @param value
	 */
	public  static void writeProperty(String property, String config_file,String value) {
		Properties prop;
		try {
			  PropertiesConfiguration properties = new PropertiesConfiguration(config_file);
	            properties.setProperty(property,value);
	         
	            properties.save();
	            System.out.println("config.properties updated Successfully!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
