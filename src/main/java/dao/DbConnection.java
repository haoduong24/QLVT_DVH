package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	 private static final String URL = "jdbc:mysql://localhost:3306/qlvt_dvh";
	    private static final String USER = "haoduong";
	    private static final String PASSWORD = "123456";

	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }
	}