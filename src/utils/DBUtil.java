package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	 private static final String URL = "jdbc:h2:tcp://localhost/~/oruca";

	    private static final String USER = "sa";

	    private static final String PASSWORD = "";

<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git

	    static {

	        try {

	            Class.forName("org.h2.Driver");

	        } catch (ClassNotFoundException e) {

	            e.printStackTrace();

	        }

        }

		public static Connection getConnection() throws SQLException {

			return DriverManager.getConnection(URL, USER, PASSWORD);
		}
	}