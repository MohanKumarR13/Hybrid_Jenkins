package com.bank.utills;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	public static Properties properties;
	public ReadConfig() {
		File src=new File(".\\Config\\Config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			properties=new Properties();
			properties.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is"+e.getMessage());
		}
	}
	public String getUrl() {
		String url=properties.getProperty("baseURL");
		return url;	
	}
	public String getUserName() {
		String uName=properties.getProperty("userName");
		return uName;	
	}
	public String getPwd() {
		String pwd=properties.getProperty("password");
		return pwd;	
	}
}
