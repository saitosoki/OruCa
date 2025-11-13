package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;



public class UserDaoImpl implements UserDao {

    private static final String LOGIN_SQL =
        "SELECT name, `e-mail`, Department_num, user_num, `password` FROM user WHERE user_num = ? AND `password` = ?";
    private User mapResultSetToBean(ResultSet rs) throws SQLException {
        User bean = new User();
        bean.setName(rs.getString("name"));
        bean.setEmail(rs.getString("e-mail"));

        bean.setDepartmentNum(rs.getInt("Department_num"));
        if (rs.wasNull()) bean.setDepartmentNum(null);

        bean.setUserNum(rs.getInt("user_num"));
        if (rs.wasNull()) bean.setUserNum(null);

        bean.setPassword(rs.getString("password"));
        return bean;
    }

    private Connection getConnection() throws SQLException {
        final String JDBC_URL = "jdbc:mysql://localhost:3306/oruca_db";
        final String DB_USER = "your_user";
        final String DB_PASS = "your_password";

        return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
    }
    @Override
    public User findByLoginCredentials(Integer userNum, String password) {

    	try (Connection conn = getConnection();
    			PreparedStatement pstmt = conn.prepareStatement(LOGIN_SQL)) {

            pstmt.setInt(1, userNum);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {

                    return mapResultSetToBean(rs);
                }
            }
            return null;

        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public User findByUserNum(Integer userNum) {

        throw new UnsupportedOperationException("Not implemented yet.");
    }


    @Override
    public boolean insert(User user) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    @Override
    public boolean update(User user) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    @Override
    public boolean delete(Integer userNum) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}