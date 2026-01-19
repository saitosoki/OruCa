package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.StressCheck;

public class StressCheckDAO {


    public List<StressCheck> findByUserNum(int userNum) {
        List<StressCheck> list = new ArrayList<>();
        String sql = "SELECT * FROM MENTAL_CHECK2 WHERE USER_NUM = ? ORDER BY CREATED_AT DESC";
        String url = "jdbc:h2:tcp://localhost/~/oruca";
        String user = "sa";
        String pass = "";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userNum);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    StressCheck sc = new StressCheck();
                    sc.setName(rs.getString("NAME"));
                    sc.setQ1(rs.getString("Q1"));
                    sc.setQ2(rs.getString("Q2"));
                    sc.setQ3(rs.getString("Q3"));
                    sc.setQ4(rs.getString("Q4"));
                    sc.setQ5(rs.getString("Q5"));

                    sc.setCreatedAt(rs.getTimestamp("CREATED_AT"));
                    list.add(sc);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public int insert(StressCheck sc) {
        String sql = "INSERT INTO MENTAL_CHECK2 (NAME, DEPARTMENT_NUM, USER_NUM, Q1, Q2, Q3, Q4, Q5, CREATED_AT) VALUES (?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP)";
        String url = "jdbc:h2:tcp://localhost/~/oruca";
        String user = "sa";
        String pass = "";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sc.getName());
            pstmt.setString(2, sc.getDepartmentNum());
            pstmt.setInt(3, sc.getUserNum());
            pstmt.setString(4, sc.getQ1());
            pstmt.setString(5, sc.getQ2());
            pstmt.setString(6, sc.getQ3());
            pstmt.setString(7, sc.getQ4());
            pstmt.setString(8, sc.getQ5());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}