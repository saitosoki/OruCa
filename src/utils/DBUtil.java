package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String URL = "jdbc:h2:tcp://localhost/~/oruca";
    private static final String USER = "sa";     // あなたのユーザー名
    private static final String PASS = ""; // あなたのパスワード

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.h2.Driver");  // MySQLドライバ
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
