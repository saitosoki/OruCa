package utils;

import java.sql.Connection;

public class DBUtil {

	 private static final String URL = "jdbc:h2:tcp://localhost/~/oruca";

	    private static final String USER = "sa";

	    private static final String PASSWORD = "";

	    // JDBCドライバの読み込み（初回のみ）

	    static {

	        try {

	            Class.forName("org.h2.Driver");

	        } catch (ClassNotFoundException e) {

	            e.printStackTrace();

	        }

        }

		public static Connection getConnection() {
			// TODO 自動生成されたメソッド・スタブ
			return null;
		}
	}