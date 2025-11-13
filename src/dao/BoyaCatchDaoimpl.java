package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.boyacatch;

public class BoyaCatchDaoimpl implements BoyaCatchDao {


    private static final String JDBC_URL = "jdbc:mysql://...";
    private static final String USER = "your_user";
    private static final String PASS = "your_password";
    private static final String INSERT_SQL =
        "INSERT INTO catch (input, reply, user_num, date) VALUES (?, ?, ?, ?)";

    private static final String SELECT_BY_KEY_SQL =
        "SELECT input, reply, user_num, date FROM catch WHERE user_num = ? AND date = ?";

    private static final String SELECT_BY_USER_SQL =
        "SELECT input, reply, user_num, date FROM catch WHERE user_num = ? ORDER BY date DESC";
    private boyacatch mapResultSetToBean(ResultSet rs) throws SQLException {
        boyacatch bean = new boyacatch();
        bean.setInput(rs.getString("input"));
        bean.setReply(rs.getString("reply"));
        bean.setUserId(rs.getInt("user_num"));
        bean.setDate(rs.getDate("date"));
        return bean;
    }
    @Override
    public boolean insert(boyacatch entry) {

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL)) {
            pstmt.setString(1, entry.getInput());
            pstmt.setString(2, entry.getReply());
            pstmt.setInt(3, entry.getUserId());
            pstmt.setDate(4, entry.getDate());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boyacatch findByCompositeKey(int userId, Date date) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_KEY_SQL)) {

            pstmt.setInt(1, userId);
            pstmt.setDate(2, date);

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
    public List<boyacatch> findByUserId(int userId) {
        List<boyacatch> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_USER_SQL)) {

            pstmt.setInt(1, userId);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSetToBean(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public boolean update(boyacatch entry) {

        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public boolean delete(int userId, Date date) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}