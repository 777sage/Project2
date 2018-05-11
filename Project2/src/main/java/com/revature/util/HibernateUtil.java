package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory mysession;

	public HibernateUtil() {
	}
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			
		}
	}
	// The configure method, can take a filename, but by
	// default, it looks for a configuration file
	// name: 'hibernate.cfg.xml
	public static SessionFactory getSession() {
		InputStream in =null;
		Properties props = new Properties();
		try {
			in = new FileInputStream("C:\\GitHUb\\Project2\\Project2\\src\\main\\resources\\hibernate.properties");
			props.load(in);
		}catch(IOException fnfe) {
			fnfe.getMessage();
		}
		if (mysession == null) {
			Configuration conf = new Configuration();
			conf.setProperty("hibernate.connection.url", props.getProperty("hibernate.connection.url"));
			conf.setProperty("hibernate.connection.username", props.getProperty("hibernate.connection.username"));
			conf.setProperty("hibernate.connection.password", props.getProperty("hibernate.connection.password"));
			mysession = conf.configure().buildSessionFactory();
		}
		return mysession;
	}

}