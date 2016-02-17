package cn.Util;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	private static Properties prop;

	// start the static
	static {

		try {

			InputStream in = PropertiesUtil.class.getClassLoader()
					.getResourceAsStream("config.properties");
			prop = new Properties();
			prop.load(in);

		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end static
	
	/**
	 * get the value of the config.properties
	 * @param key -- the key
	 * @return
	 */
	public static String getValue(String key) {
		
		
		return prop.getProperty(key);
	}

}
