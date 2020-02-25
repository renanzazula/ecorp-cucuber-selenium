package eCorp.utils;



import eCorp.constant.ConstantsPropertiesFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFile {


	private static final String BROWSER = "browser";

	protected InputStream input = null;
	protected Properties prop = null;

	public ReadConfigFile() {
		try {
			input = this.getClass().getClassLoader().getResourceAsStream(ConstantsPropertiesFile.CONFIG_PROPERTIES_DIRECTORY);
			prop = new Properties();

			if (input == null) {
				throw new NullPointerException("Properties file is not ready");
			}
			//load a properties file from class path, inside static method
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getBrowser() {
		return prop.getProperty(BROWSER);
	}

	public String getOS() {
		return System.getProperty("os.name").toLowerCase();
	}

}
