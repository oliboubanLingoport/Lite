package com.lingoport.demo.java.utils;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * For the demonstration of Globalyzer, use the following configuration for String externalization
 *  Class name: I18nUtils
 *  Package : com.lingoport.demo.java.utils
 *  Properties filename: com.lingoport.demo.java.resources.exampleResources.properties
 *  
 *  
 *  Globalyzer finds references to Locale and flags them: in this demo, those references are fine, so 
 *  the issues should be ignored.
 *  
 *  
 * @author Olivier
 *
 */

public class I18nUtils {
	
    static ResourceBundle resources = null;
	private static Locale locale = new Locale("en", "US");  
	
	
	public static String getString(String key) {
		return getResourceBundle().getString(key);
	}
	
	/**
	 * gets the current locale for the application
	 * @return
	 */
	public static Locale getLocale() {
		return locale;	
	}
	
	public static void setLocale(Locale locale) {   
		I18nUtils.locale = locale;
		
	}
	
	static ResourceBundle getResourceBundle() {
		
		if (resources != null) {
			return resources;
		}
     	
		try {
			resources = ResourceBundle.getBundle("com/lingoport/demo/java/resources.exampleResources", locale);
		} catch (MissingResourceException mre) {
			mre.printStackTrace();
			System.exit(1);
		}
		
		return resources;

	}

}
