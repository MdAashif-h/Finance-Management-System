package com.finance.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnUtil {

	public static Connection getConnection() {
	    Connection conn = null;
	    try {
	        String driver = DBPropertyUtil.getDriver();
	        String url = DBPropertyUtil.getUrl();
	        String username = DBPropertyUtil.getUsername();
	        String password = DBPropertyUtil.getPassword();

	        Class.forName(driver);
	        conn = DriverManager.getConnection(url, username, password);
	        System.out.println("Database connected successfully");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return conn;
	}

}
