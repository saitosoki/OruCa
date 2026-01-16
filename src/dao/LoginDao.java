package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import action.LoginAction;

public class LoginDao {

    private static final String DB_URL ="jdbc:h2:tcp://localhost/~/oruca";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";
    private static final String DRIVER_NAME = "org.h2.Driver";

    private Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVER_NAME);
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBCドライバが見つかりません。", e);
        }
    }

    // --- ログイン検索メソッド ---
    /**
     * 指定されたログイン名とパスワードを持つユーザーをデータベースから検索する。
     */
    public LoginAction search(String login, String password) throws Exception {

        LoginAction customer = null;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            int userNum = 0;
            try {
                userNum = Integer.parseInt(login);
            } catch (NumberFormatException e) {
                return null;
            }

            // データベース接続を取得
            con = getConnection();

            // SQLはそのまま（select * なので全てのカラムが取れます）
            st = con.prepareStatement(
                "select * from USER where USER_NUM=? and PASSWORD=?"
            );

            st.setInt(1, userNum);
            st.setString(2, password);

            rs = st.executeQuery();

            if (rs.next()) {
                customer = new LoginAction();

                customer.setId(rs.getInt("USER_NUM"));
                customer.setLogin(rs.getString("EMAIL"));
                customer.setPassword(rs.getString("PASSWORD"));

                // ★ 追加：DBの NAME と DEPARTMENT_NUM を取得してセット
                customer.setName(rs.getString("NAME"));
                customer.setDepartmentNum(rs.getString("DEPARTMENT_NUM"));
            }

            return customer;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException closeE) {
                closeE.printStackTrace();
            }
        }
    }
}